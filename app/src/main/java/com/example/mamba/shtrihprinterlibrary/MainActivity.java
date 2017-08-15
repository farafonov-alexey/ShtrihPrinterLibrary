package com.example.mamba.shtrihprinterlibrary;

import android.app.Activity;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.shtrih.util.StaticContext;
import java.util.ArrayList;
import java.util.List;
import test.librarywrapper.ShtrihModule;
import test.librarywrapper.ShtrihPrinterCallbackReceiver;
import test.librarywrapper.constants.OperationType;
import test.librarywrapper.data.GoodsData;
import test.librarywrapper.data.ReceiptInformation;
import test.librarywrapper.data.ShtrihPrinterInputData;

public class MainActivity extends AppCompatActivity implements ShtrihPrinterCallbackReceiver {
    private TextView statusText;
    private ShtrihModule shtrihModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StaticContext.setContext(getApplicationContext());
        shtrihModule = new ShtrihModule(MainActivity.this, this);
        statusText = (TextView) findViewById(R.id.status_text);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case DeviceListActivity.REQUEST_CONNECT_BT_DEVICE:
                if (resultCode == Activity.RESULT_OK) {
                    String address = data.getExtras().getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
                    try {
                        shtrihModule.setSelectedDevice(address);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_connect_ptk) {
            Intent i = new Intent(this, DeviceListActivity.class);
            startActivityForResult(i, DeviceListActivity.REQUEST_CONNECT_BT_DEVICE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void printReceipt(View v) {
        List<GoodsData> groceries = new ArrayList<>();
        groceries.add(new GoodsData(15, "milk", 2));
        groceries.add(new GoodsData(20, "bread", 4));
        ReceiptInformation info = new ReceiptInformation.Builder().build();
        final ShtrihPrinterInputData data = new ShtrihPrinterInputData(OperationType.PAYMENT, groceries, true, info);
        shtrihModule.printFiscalCheck(this, data);

    }

    public void printZReport(View v) {
        shtrihModule.printReportZ(this);
    }

    public void printDuplicateReceipt(View v) {
        shtrihModule.printRepeatedCheck(this, null);
    }

    @Override
    public void onInitializationPreferences() {

    }

    @Override
    public void onDeviceList(List<String> listOfDevices) {

    }

    @Override
    public void onCompletePrinting(int printType) {
        statusText.setText("Печать окончена");
    }

    @Override
    public void onErrorPrinting(int printType, String error) {
        statusText.setText("код операции " + printType + ". " + error);
    }

    @Override
    public void onReportPrintingZ() {

    }

    @Override
    public void onReportAlreadyClosed() {

    }
}