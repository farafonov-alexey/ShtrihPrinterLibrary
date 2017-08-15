package test.librarywrapper;

import android.bluetooth.BluetoothAdapter;

/**
 * Created by mamba on 14.08.2017.
 */

public class BluetoothManager {
    private static BluetoothAdapter adapter;

    public BluetoothManager() {
    }

    public static void getInstance() {
        if(adapter == null)
            adapter = BluetoothAdapter.getDefaultAdapter();
    }

    public static void enableBluetooth() {
        if(adapter != null && adapter.getState() == BluetoothAdapter.STATE_OFF)
            adapter.enable();
    }

    public static void disableBluetooth() {
        if(adapter != null && adapter.getState() == BluetoothAdapter.STATE_ON)
            adapter.disable();
    }

    public static boolean isStateBluetooth() {
        boolean isState = false;
        if(adapter != null)
            isState = adapter.getState() == BluetoothAdapter.STATE_ON;
        return isState;
    }
}
