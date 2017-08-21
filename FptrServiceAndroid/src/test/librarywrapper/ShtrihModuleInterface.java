package test.librarywrapper;

import java.util.List;

import test.librarywrapper.data.ShtrihPrinterInputData;

/**
 * Created by mamba on 15.08.2017.
 */

public interface ShtrihModuleInterface {
    void addPrinter();
    void clearSavedPrinterName();
    void printFiscalCheck(ShtrihPrinterInputData inputData);
    void printRepeatedCheck(ShtrihPrinterInputData inputData);
    void printSlipCheck(ShtrihPrinterInputData inputData);
    void printReportX();
    void printReportZ();
    void setSelectedDevice(String macAddress) throws Exception;
    void setCallbackReceiver(ShtrihPrinterCallbackReceiver receiver);
    String isSavedPrinterName();
}
