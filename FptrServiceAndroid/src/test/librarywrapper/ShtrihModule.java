package test.librarywrapper;

import android.content.Context;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import java.lang.ref.WeakReference;

import jpos.FiscalPrinter;
import test.librarywrapper.constants.PrintType;
import test.librarywrapper.data.ShtrihPrinterInputData;

/**
 * Created by mamba on 15.08.2017.
 */

public class ShtrihModule implements LibraryInterface {
    private ShtrihPrinterController controller;
    private ShtrihFiscalPrinter printer;
    private WeakReference<Context> weakContext;
    private ShtrihPrinterPreferences preferences;
    private ShtrihPrinterCallbackReceiver receiver;
    private BluetoothManager btManager;



    public ShtrihModule(Context context, ShtrihPrinterCallbackReceiver receiver) {
        this.printer = new ShtrihFiscalPrinter(new FiscalPrinter());
        this.weakContext = new WeakReference<>(context);
        this.controller = new ShtrihPrinterController(printer, context);
        this.weakContext = new WeakReference<>(context);
        this.preferences = new ShtrihPrinterPreferences(context);
        this.receiver = receiver;
        this.btManager = new BluetoothManager();
    }

    @Override
    public void addPrinter() {
        controller.addPrinter();
    }

    @Override
    public String isSavedPrinterName() {
        return preferences.loadNamePrinter();
    }

    @Override
    public void clearSavedPrinterName() {
        preferences.savePrinterName(null);
    }

    @Override
    public void printFiscalCheck(ShtrihPrinterCallbackReceiver receiver, ShtrihPrinterInputData inputData) {
        controller.setCallbackReceiver(receiver);
        controller.print(PrintType.FISCAL_TRANSACTION, inputData);
    }

    @Override
    public void printRepeatedCheck(ShtrihPrinterCallbackReceiver receiver, ShtrihPrinterInputData inputData) {
        controller.setCallbackReceiver(receiver);
        controller.print(PrintType.REPEAT_TRANSACTION, null);
    }

    @Override
    public void printSlipCheck(ShtrihPrinterCallbackReceiver receiver, ShtrihPrinterInputData inputData) {

    }

    @Override
    public void printReportX(ShtrihPrinterCallbackReceiver receiver) {
        printReportZ(receiver);
    }

    @Override
    public void printReportZ(ShtrihPrinterCallbackReceiver receiver) {
        controller.setCallbackReceiver(receiver);
        controller.print(PrintType.Z_REPORT, null);
        receiver.onReportPrintingZ();
    }

    @Override
    public void setSelectedDevice(String macAddress) throws Exception {
        controller.connectDevice(macAddress);
        receiver.onInitializationPreferences();
    }
}
