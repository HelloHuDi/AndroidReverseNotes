package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(18)
public final class a extends BluetoothGattCallback {
    public e hEa;

    public a(e eVar) {
        this.hEa = eVar;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94220);
        this.hEa.onConnectionStateChange(bluetoothGatt, i, i2);
        AppMethodBeat.o(94220);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.i(94221);
        this.hEa.onServicesDiscovered(bluetoothGatt, i);
        AppMethodBeat.o(94221);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.i(94222);
        this.hEa.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        AppMethodBeat.o(94222);
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.i(94223);
        this.hEa.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        AppMethodBeat.o(94223);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.i(94224);
        this.hEa.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        AppMethodBeat.o(94224);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.i(94225);
        this.hEa.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        AppMethodBeat.o(94225);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.i(94226);
        this.hEa.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        AppMethodBeat.o(94226);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.i(94227);
        this.hEa.onReliableWriteCompleted(bluetoothGatt, i);
        AppMethodBeat.o(94227);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94228);
        this.hEa.onReadRemoteRssi(bluetoothGatt, i, i2);
        AppMethodBeat.o(94228);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94229);
        this.hEa.onMtuChanged(bluetoothGatt, i, i2);
        AppMethodBeat.o(94229);
    }
}
