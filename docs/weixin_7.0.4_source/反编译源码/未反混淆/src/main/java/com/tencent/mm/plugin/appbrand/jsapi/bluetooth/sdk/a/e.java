package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

public interface e {
    void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

    void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

    void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2);

    void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i);

    void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i);

    void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2);

    void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2);

    void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i);

    void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i);
}
