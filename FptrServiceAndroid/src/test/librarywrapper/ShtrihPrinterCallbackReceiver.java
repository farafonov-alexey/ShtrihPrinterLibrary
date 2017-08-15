package test.librarywrapper;

import java.util.List;

import test.librarywrapper.data.ShtrihPrinterInputData;

/**
 * Created by mamba on 14.08.2017.
 */

public interface ShtrihPrinterCallbackReceiver {
    void onInitializationPreferences();
    void onDeviceList(List<String> listOfDevices);
    void onCompletePrinting(int printType);
    void onErrorPrinting(int printType, String error);
    void onReportPrintingZ();
    void onReportAlreadyClosed();
}
