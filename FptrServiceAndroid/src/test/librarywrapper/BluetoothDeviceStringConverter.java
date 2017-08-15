package test.librarywrapper;

import android.bluetooth.BluetoothDevice;

import com.google.common.base.Converter;

/**
 * Created by mamba on 15.08.2017.
 */

public class BluetoothDeviceStringConverter extends Converter<BluetoothDevice, String> {
    protected String doForward(BluetoothDevice device) {
        return device.getName();
    }

    protected BluetoothDevice doBackward(String s) {
        return null;
    }
}
