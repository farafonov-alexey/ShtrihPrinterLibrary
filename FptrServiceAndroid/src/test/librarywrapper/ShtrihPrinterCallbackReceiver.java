package test.librarywrapper;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.enums.TypePrint;

/**
 * Created by mamba on 14.08.2017.
 */

public interface ShtrihPrinterCallbackReceiver {
    void onInitializationPreferences();
    void onDeviceList(List<String> listOfDevices);
    void onCompletePrinting(TypePrint typePrint);
    void onErrorPrinting(@Nullable TypePrint typePrint, String error);
    void onReportPrintingZ();
    void onReportAlreadyClosed();
    void onConnected();
    void onDisconnected();
}
