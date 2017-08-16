package com.example.mamba.shtrihprinterlibrary;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.shtrih.util.StaticContext;
import java.util.ArrayList;
import java.util.List;
import test.librarywrapper.ShtrihModule;
import test.librarywrapper.ShtrihPrinterCallbackReceiver;
import test.librarywrapper.data.GoodsData;
import test.librarywrapper.data.ReceiptInformation;
import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.enums.PrinterOperationType;
import test.librarywrapper.enums.TypePrint;

public class MainActivity extends AppCompatActivity implements ShtrihPrinterCallbackReceiver {
    private TextView statusText;
    private ShtrihModule shtrihModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StaticContext.setContext(getApplicationContext());
        shtrihModule = new ShtrihModule(MainActivity.this);
        shtrihModule.setCallbackReceiver(this);
        statusText = (TextView) findViewById(R.id.status_text);
        shtrihModule.addPrinter();
    }

    public void printReceipt(View v) {
        List<GoodsData> groceries = new ArrayList<>();
        groceries.add(new GoodsData(15, "milk", 2));
        groceries.add(new GoodsData(20, "bread", 4));
        ReceiptInformation info = new ReceiptInformation.Builder().build();
        final ShtrihPrinterInputData data = new ShtrihPrinterInputData(PrinterOperationType.PAYMENT, groceries, true, info);
        shtrihModule.printFiscalCheck(data);
    }

    public void printZReport(View v) {
        shtrihModule.printReportZ();
    }

    public void printXReport(View view) { shtrihModule.printReportX(); }

    public void printDuplicateReceipt(View v) {
        shtrihModule.printRepeatedCheck( null);
    }

    @Override
    public void onInitializationPreferences() {
    }

    @Override
    public void onDeviceList(List<String> listOfDevices) {

    }

    @Override
    public void onCompletePrinting(TypePrint typePrint) {
        statusText.setText("Печать окончена");
    }

    @Override
    public void onErrorPrinting(TypePrint typePrint, String error) {
        statusText.setText("код операции " + typePrint.getCodeType() + ". " + error);
    }

    @Override
    public void onReportPrintingZ() {

    }

    @Override
    public void onReportAlreadyClosed() {

    }

    @Override
    public void onConnected() {
        List<GoodsData> groceries = new ArrayList<>();
        groceries.add(new GoodsData(15, "milk", 2));
        groceries.add(new GoodsData(20, "bread", 4));
        ReceiptInformation info = new ReceiptInformation.Builder().build();
        final ShtrihPrinterInputData data = new ShtrihPrinterInputData(PrinterOperationType.PAYMENT, groceries, true, info);
        shtrihModule.printFiscalCheck(data);
    }

    public void onClickConnection(View view) {
        shtrihModule.connectDevice();
    }


}