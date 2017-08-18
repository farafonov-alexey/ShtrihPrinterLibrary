package test.librarywrapper;

import android.content.Context;
import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;
import jpos.FiscalPrinter;
import test.librarywrapper.bluetooth.ShtrihPrinterPreferences;
import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.enums.TypePrint;

/**
 * Created by mamba on 15.08.2017.
 */

public class ShtrihModule implements ShtrihModuleInterface {
    private static volatile boolean isConnected = false;
    public static final String LOG_TAG = "happy";
    private ShtrihPrinterController controller;
    private ShtrihFiscalPrinter printer;
    private ShtrihPrinterCallbackReceiver receiver;

    public ShtrihModule(Context context) {
        this.printer = new ShtrihFiscalPrinter(new FiscalPrinter());
        this.controller = new ShtrihPrinterController(printer, context, new ShtrihPrinterPreferences(context));
        CustomLog.enableDebugLogging(true);
    }

    @Override
    public void addPrinter() {
        controller.setCallbackReceiver(receiver);
        controller.addPrinter();
    }

    @Override
    public String isSavedPrinterName() {
        return controller.loadNamePrinter();
    }

    @Override
    public void clearSavedPrinterName() {
        controller.clearDataBases();
    }

    @Override
    public void printFiscalCheck(final ShtrihPrinterInputData inputData) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                controller.setCallbackReceiver(receiver);
                if (ShtrihModule.isConnected() == false)
                    controller.connectDevice();
                controller.print(TypePrint.FISCAL_TRANSACTION, inputData);
            }
        }).run();
    }

    @Override
    public void printRepeatedCheck(ShtrihPrinterInputData inputData) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                controller.setCallbackReceiver(receiver);
                if(ShtrihModule.isConnected()==false)
                    controller.connectDevice();
                controller.print(TypePrint.REPEAT_TRANSACTION, null);
            }
        }).run();
    }

    @Override
    public void printSlipCheck(ShtrihPrinterInputData inputData) {

    }

    @Override
    public void printReportX() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                controller.setCallbackReceiver(receiver);
                if(ShtrihModule.isConnected() == false)
                    controller.connectDevice();
                controller.print(TypePrint.X_REPORT, null);
            }
        }).run();
    }

    @Override
    public void printReportZ() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                controller.setCallbackReceiver(receiver);
                if (ShtrihModule.isConnected() == false)
                    controller.connectDevice();
                controller.print(TypePrint.Z_REPORT, null);
            }
        }).run();
    }

    @Override
    public void setSelectedDevice(String name) throws Exception {
        controller.setSelectedDevices(name);
    }

    public void setCallbackReceiver(ShtrihPrinterCallbackReceiver receiver){
        this.receiver = receiver;
    }

    public void connectDevice(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(ShtrihModule.isConnected() == false)
                    controller.connectDevice();
                receiver.onConnected();
            }
        }).run();
    }

    public static boolean isConnected() {
        return isConnected;
    }

    public static void setIsConnected(boolean isConnected) {
        ShtrihModule.isConnected = isConnected;
    }
}
