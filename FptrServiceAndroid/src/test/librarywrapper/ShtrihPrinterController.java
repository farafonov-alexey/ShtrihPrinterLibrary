package test.librarywrapper;

import android.content.Context;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import org.jetbrains.annotations.Nullable;

import java.lang.ref.WeakReference;
import java.util.List;

import jpos.JposConst;
import jpos.JposException;
import test.librarywrapper.config.JposConfig;
import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.strategy.Instruction;
import test.librarywrapper.strategy.InstructionFactory;

/**
 * Created by mamba on 14.08.2017.
 */

public class ShtrihPrinterController {
    private ShtrihPrinterCallbackReceiver callbackReceiver;
    private WeakReference<Context> weakContext;
    private ShtrihFiscalPrinter printer;
    private final Object connectionLock = new Object();
    private RegistrationManager registrationManager;

    public ShtrihPrinterController(ShtrihFiscalPrinter printer, Context context) {
        this.printer = printer;
        this.weakContext = new WeakReference<>(context);
        this.registrationManager = new RegistrationManager(context);
    }

    public void print(int printType, @Nullable ShtrihPrinterInputData inputData){
        Instruction instruction = InstructionFactory.getInstruction(printer, inputData, printType);
        PrintingAsyncTask asyncTask = new PrintingAsyncTask(instruction, callbackReceiver);
        asyncTask.execute();
    }

    public void setCallbackReceiver(ShtrihPrinterCallbackReceiver receiver){
        this.callbackReceiver = receiver;
    }

    public void connectDevice(String address) throws Exception {
        JposConfig.configure("ShtrihFptr", address, weakContext.get().getApplicationContext());
        if (printer.getState() != JposConst.JPOS_S_CLOSED) {
            printer.close();
        }
        printer.open("ShtrihFptr");
        printer.claim(3000);
        printer.setDeviceEnabled(true);
    }

    public void addPrinter(){
        if(callbackReceiver != null) {
            (new Thread() {
                public void run() {
                    synchronized (ShtrihPrinterController.this.connectionLock) {
                        while (!BluetoothManager.isStateBluetooth()) {
                            BluetoothManager.enableBluetooth();
                        }
                        if (registrationManager.isSettings() == null) {
                            List<String> listOfDevices = registrationManager.getDeviceList();
                            if (listOfDevices != null && listOfDevices.size() == 1)
                                try {
                                    connectDevice(listOfDevices.get(0));
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
}
