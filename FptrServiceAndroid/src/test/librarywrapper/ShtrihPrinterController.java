package test.librarywrapper;

import android.content.Context;
import android.os.Environment;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;
import com.shtrih.util.SysUtils;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

import jpos.JposConst;
import jpos.JposException;
import test.librarywrapper.config.JposConfig;
import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.enums.TypePrint;
import test.librarywrapper.strategy.Instruction;
import test.librarywrapper.strategy.InstructionFactory;

import static android.R.attr.data;

/**
 * Created by mamba on 14.08.2017.
 */

public class ShtrihPrinterController {
    private ShtrihPrinterCallbackReceiver callbackReceiver;
    private WeakReference<Context> weakContext;
    private ShtrihFiscalPrinter printer;
    private final Object connectionLock = new Object();
    private RegistrationManager registrationManager;


    public ShtrihPrinterController(ShtrihFiscalPrinter printer, Context context, ShtrihPrinterPreferences shtrihPrinterPreferences) {
        this.printer = printer;
        this.weakContext = new WeakReference<>(context);
        this.registrationManager = new RegistrationManager(context, shtrihPrinterPreferences);
        BluetoothManager.getInstance();
    }

    public void print(TypePrint typePrint, @Nullable ShtrihPrinterInputData inputData){
        Instruction instruction = InstructionFactory.getInstruction(printer, inputData, typePrint);
        PrintingAsyncTask asyncTask = new PrintingAsyncTask(instruction, callbackReceiver);
        asyncTask.execute();
    }

    public void setCallbackReceiver(ShtrihPrinterCallbackReceiver receiver){
        this.callbackReceiver = receiver;
    }

    public void connectDevice() {
        String address = registrationManager.loadMacAddress();
        try {
            JposConfig.configure("ShtrihFptr", address, weakContext.get().getApplicationContext());
            if (printer.getState() != JposConst.JPOS_S_CLOSED) {
                printer.close();
            }
            printer.open("ShtrihFptr");
            printer.claim(3000);
            callbackReceiver.onConnected();
            printer.setDeviceEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPrinter(){
        if(callbackReceiver != null) {
            (new Thread() {
                public void run() {
                    synchronized (ShtrihPrinterController.this.connectionLock) {
                        while (!BluetoothManager.isStateBluetooth()) {
                            BluetoothManager.enableBluetooth();
                        }
                        if (registrationManager.isSavedNamePrinter() == null) {
                            List<String> listOfDevices = registrationManager.getDeviceList();
                            if (listOfDevices != null && listOfDevices.size() == 1)
                                try {
                                    setSelectedDevices(listOfDevices.get(0));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            else
                                callbackReceiver.onDeviceList(listOfDevices);
                        } else
                            callbackReceiver.onInitializationPreferences();
                    }
                }
            }).run();
        }
    }

    public String getDevicesMacAddress(String name){
        return registrationManager.getDeviceMacAdress(name);
    }

    public void setSelectedDevices(String name){
        registrationManager.setSelectedDevice(name);
        callbackReceiver.onInitializationPreferences();
    }

    public String loadNamePrinter(){
        return registrationManager.loadNamePrinter();
    }

    public void clearDataBases() {
        registrationManager.clearDataBase();
    }
}
