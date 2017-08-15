package test.librarywrapper;

import java.util.List;

import test.librarywrapper.data.ShtrihPrinterInputData;

/**
 * Created by mamba on 15.08.2017.
 */

public interface LibraryInterface {
    void addPrinter();
    String isSavedPrinterName();
    void clearSavedPrinterName();
    void printFiscalCheck(ShtrihPrinterCallbackReceiver receiver, ShtrihPrinterInputData inputData);
    void printRepeatedCheck(ShtrihPrinterCallbackReceiver receiver, ShtrihPrinterInputData inputData);
    void printSlipCheck(ShtrihPrinterCallbackReceiver receiver, ShtrihPrinterInputData inputData);
    void printReportX(ShtrihPrinterCallbackReceiver receiver);
    void printReportZ(ShtrihPrinterCallbackReceiver receiver);
    void setSelectedDevice(String macAddress) throws Exception;
}
