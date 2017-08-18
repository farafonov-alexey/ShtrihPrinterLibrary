package test.librarywrapper.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import test.librarywrapper.CustomLog;
import test.librarywrapper.bluetooth.BluetoothDeviceStringConverter;
import test.librarywrapper.bluetooth.DeviceSelectionServiceBluetooth;
import test.librarywrapper.bluetooth.SelectionService;
import test.librarywrapper.bluetooth.ShtrihPrinterPreferences;

import static test.librarywrapper.ShtrihModule.LOG_TAG;

/**
 * Created by mamba on 15.08.2017.
 */

public class RegistrationManager {
    private SelectionService deviceSelectionService;
    private ShtrihPrinterPreferences printerPreferences;
    private String address, port;

    public RegistrationManager(Context context, ShtrihPrinterPreferences shtrihPrinterPreferences) {
        this.printerPreferences = shtrihPrinterPreferences;
        address = null;
        port = null;
    }

    public String isSavedNamePrinter() {
        return printerPreferences.loadNamePrinter();
    }

    public void clearNamePrinter() {
        printerPreferences.savePrinterName(null);
    }

    public List<String> getDeviceList() {
        List<BluetoothDevice> discoveredDevices = new ArrayList<BluetoothDevice>();
        Set<BluetoothDevice> boundedDevices = BluetoothAdapter.getDefaultAdapter()
                .getBondedDevices();
        for (BluetoothDevice device : boundedDevices) {
            if (device.getName().contains("SHTR")) {
                discoveredDevices.add(device);
            }
        }
        deviceSelectionService = new DeviceSelectionServiceBluetooth(discoveredDevices, new BluetoothDeviceStringConverter());
        List<String> listDeviceName = deviceSelectionService.getSelectionList();
        return listDeviceName;
    }

    public void setSelectedDevice(String deviceExternal) {
        BluetoothDevice device = (BluetoothDevice) deviceSelectionService.getObject(deviceExternal);
        CustomLog.d(LOG_TAG, "BluetoothDevice device = (BluetoothDevice) deviceSelectionService.getObject(deviceExternal);");
        printerPreferences.savePrinterName(device.getName());
        CustomLog.d(LOG_TAG, "printerPreferences.saveMacAddress(device.getAddress());");
        printerPreferences.saveMacAddress(device.getAddress());
    }

    public String getDeviceMacAdress(String name) {
        ArrayList discoveredDevices = new ArrayList();
        Set boundedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        Iterator listDeviceName = boundedDevices.iterator();

        while(listDeviceName.hasNext()) {
            BluetoothDevice device = (BluetoothDevice)listDeviceName.next();
            if(device.getName().contains(name)) {
                return device.getAddress();
            }
        }
        return name;
    }

    public String loadNamePrinter(){
        return printerPreferences.loadNamePrinter();
    }

    public void clearDataBase() {
        printerPreferences.savePrinterName(null);
        printerPreferences.saveMacAddress(null);
    }

    public String loadMacAddress() {
        return printerPreferences.loadMacAddress();
    }
}
