package test.librarywrapper;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mamba on 15.08.2017.
 */

public class RegistrationManager {
    private SelectionService deviceSelectionService;
    private ShtrihPrinterPreferences printerPreferences;
    private String address, port;

    public RegistrationManager(Context context) {
        printerPreferences = new ShtrihPrinterPreferences(context);
        address = null;
        port = null;
    }

    public void connectionSettings(String address, String port) {
        this.address = address;
        this.port = port;
    }

    public String isSettings() {
        String settings = printerPreferences.getSettings();
        if(settings == null) {
            return null;
        } else {
            return settings;
        }
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
        printerPreferences.savePrinterName(device.getName());
    }
}
