package test.librarywrapper;

import android.content.Context;
import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;
import jpos.FiscalPrinter;
import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.enums.TypePrint;

/**
 * Created by mamba on 15.08.2017.
 */

public class ShtrihModule implements LibraryInterface {
    private ShtrihPrinterController controller;
    private ShtrihFiscalPrinter printer;
    private ShtrihPrinterCallbackReceiver receiver;



    public ShtrihModule(Context context) {
        this.printer = new ShtrihFiscalPrinter(new FiscalPrinter());
        this.controller = new ShtrihPrinterController(printer, context, new ShtrihPrinterPreferences(context));
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
                controller.print(TypePrint.REPEAT_TRANSACTION, null);
            }
        }).run();
    }

    @Override
    public void printSlipCheck(ShtrihPrinterInputData inputData) {

    }

    @Override
    public void printReportX() {
        printReportZ();
    }

    @Override
    public void printReportZ() {
        controller.setCallbackReceiver(receiver);
        controller.print(TypePrint.Z_REPORT, null);
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
                controller.setCallbackReceiver(receiver);
                controller.connectDevice();
            }
        }).run();
    }


}
