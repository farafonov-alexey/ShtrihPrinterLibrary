package test.librarywrapper.bluetooth;

import android.bluetooth.BluetoothDevice;

import java.util.List;

/**
 * Created by mamba on 15.08.2017.
 */

public class DeviceSelectionServiceBluetooth extends SelectionService<BluetoothDevice, List<BluetoothDevice>, BluetoothDeviceStringConverter> {

    public DeviceSelectionServiceBluetooth(List<BluetoothDevice> deviceList, BluetoothDeviceStringConverter converter) {
        super(deviceList, converter);
    }

}
