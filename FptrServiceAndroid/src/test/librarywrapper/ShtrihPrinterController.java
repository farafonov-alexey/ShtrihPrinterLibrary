package test.librarywrapper;

import android.content.Context;
import android.os.Handler;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;
import org.jetbrains.annotations.Nullable;
import java.lang.ref.WeakReference;
import java.util.List;
import jpos.JposConst;
import jpos.JposException;
import test.librarywrapper.bluetooth.BluetoothManager;
import test.librarywrapper.bluetooth.RegistrationManager;
import test.librarywrapper.bluetooth.ShtrihPrinterPreferences;
import test.librarywrapper.config.JposConfig;
import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.enums.TypePrint;
import test.librarywrapper.strategy.Instruction;
import test.librarywrapper.strategy.InstructionFactory;
import test.librarywrapper.strategy.PrintingAsyncTask;

import static test.librarywrapper.ShtrihModule.LOG_TAG;

/**
 * Created by mamba on 14.08.2017.
 */

public class ShtrihPrinterController {
    private static final int RECONNECTION_LIMIT = 2;
    private volatile int reconnectionCount;
    private ShtrihPrinterCallbackReceiver callbackReceiver;
    private WeakReference<Context> weakContext;
    private ShtrihFiscalPrinter printer;
    private final Object connectionLock = new Object();
    private RegistrationManager registrationManager;


    public ShtrihPrinterController(ShtrihFiscalPrinter printer, Context context, ShtrihPrinterPreferences shtrihPrinterPreferences) {
        this.reconnectionCount = 0;
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

    public synchronized void connectDevice() {
        String address = registrationManager.loadMacAddress();
        CustomLog.d(LOG_TAG, "String address = registrationManager.loadMacAddress();");
        try {
            JposConfig.configure("ShtrihFptr", address, weakContext.get().getApplicationContext());
            CustomLog.d(LOG_TAG, "JposConfig.configure(\"ShtrihFptr\", address, weakContext.get().getApplicationContext());");
            if (printer.getState() != JposConst.JPOS_S_CLOSED) {
                printer.close();
                CustomLog.d(LOG_TAG, "printer.close();");
            }
            printer.open("ShtrihFptr");
            CustomLog.d(LOG_TAG, "printer.open(\"ShtrihFptr\");"+"Thread: "+Thread.currentThread().getName());
            printer.claim(3000);
            CustomLog.d(LOG_TAG, "printer.claim(3000);"+"Thread: "+Thread.currentThread().getName());
            printer.setDeviceEnabled(true);
            CustomLog.d(LOG_TAG, "printer.setDeviceEnabled(true);"+"Thread: "+Thread.currentThread().getName());
            ShtrihModule.setIsConnected(true);
            reconnectionCount = 0;
            CustomLog.d(LOG_TAG, "ShtrihModule.setIsConnected(true);"+"Thread: "+Thread.currentThread().getName());
        } catch (final JposException e){
            e.printStackTrace();
            onDisconnected();
            CustomLog.d(LOG_TAG, "onDisconnected();");
//            callbackReceiver.onConnectionError(e.getMessage());
            CustomLog.d(LOG_TAG, "callbackReceiver.onConnectionError(e.getMessage());"+"Thread: "+Thread.currentThread().getName());
        } catch (final Exception e) {
            e.printStackTrace();
            onDisconnected();
            CustomLog.d(LOG_TAG, "onDisconnected();");
//            callbackReceiver.onConnectionError(e.getMessage());
            CustomLog.d(LOG_TAG, "callbackReceiver.onConnectionError(e.getMessage());"+"Thread: "+Thread.currentThread().getName());
        }
    }

    private void onDisconnected(){
        ShtrihModule.setIsConnected(false);
        reconnectionCount++;
        if (reconnectionCount > RECONNECTION_LIMIT){
            callbackReceiver.onConnectionError(null);
            reconnectionCount = 0;
        }else{
            connectDevice();
        }
    }

    public void addPrinter(){
        if(callbackReceiver != null) {
            (new Thread() {
                public void run() {
                    synchronized (ShtrihPrinterController.this.connectionLock) {
                        while (!BluetoothManager.isStateBluetooth()) {
                            BluetoothManager.enableBluetooth();
                            CustomLog.d(LOG_TAG, "BluetoothManager.enableBluetooth();");
                        }
                        if (registrationManager.isSavedNamePrinter() == null) {
                            List<String> listOfDevices = registrationManager.getDeviceList();
                            CustomLog.d(LOG_TAG, "List<String> listOfDevices = registrationManager.getDeviceList();");
                            if (listOfDevices != null && listOfDevices.size() == 1){
                                setSelectedDevices(listOfDevices.get(0));
                                CustomLog.d(LOG_TAG, "setSelectedDevices(listOfDevices.get(0));");
                            }
                            else{
                                callbackReceiver.onDeviceList(listOfDevices);
                                CustomLog.d(LOG_TAG, "callbackReceiver.onDeviceList(listOfDevices);");
                            }
                        } else{
                            callbackReceiver.onInitializationPreferences();
                            CustomLog.d(LOG_TAG, "callbackReceiver.onInitializationPreferences();");
                        }
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
        CustomLog.d(LOG_TAG, "registrationManager.setSelectedDevice(name);");
        callbackReceiver.onInitializationPreferences();
        CustomLog.d(LOG_TAG, "callbackReceiver.onInitializationPreferences();");
    }

    public String loadNamePrinter(){
        return registrationManager.loadNamePrinter();
    }

    public void clearDataBases() {
        registrationManager.clearDataBase();
    }

    public String isSavedPrinterName() {
        return registrationManager.loadNamePrinter();
    }
}
