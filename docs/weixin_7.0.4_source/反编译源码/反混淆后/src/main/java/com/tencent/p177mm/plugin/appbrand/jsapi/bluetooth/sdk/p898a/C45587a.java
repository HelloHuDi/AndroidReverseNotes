package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a */
public final class C45587a extends BluetoothGattCallback {
    public C26941e hEa;

    public C45587a(C26941e c26941e) {
        this.hEa = c26941e;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94220);
        this.hEa.onConnectionStateChange(bluetoothGatt, i, i2);
        AppMethodBeat.m2505o(94220);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.m2504i(94221);
        this.hEa.onServicesDiscovered(bluetoothGatt, i);
        AppMethodBeat.m2505o(94221);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.m2504i(94222);
        this.hEa.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        AppMethodBeat.m2505o(94222);
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.m2504i(94223);
        this.hEa.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        AppMethodBeat.m2505o(94223);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.m2504i(94224);
        this.hEa.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        AppMethodBeat.m2505o(94224);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.m2504i(94225);
        this.hEa.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        AppMethodBeat.m2505o(94225);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.m2504i(94226);
        this.hEa.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        AppMethodBeat.m2505o(94226);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.m2504i(94227);
        this.hEa.onReliableWriteCompleted(bluetoothGatt, i);
        AppMethodBeat.m2505o(94227);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94228);
        this.hEa.onReadRemoteRssi(bluetoothGatt, i, i2);
        AppMethodBeat.m2505o(94228);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94229);
        this.hEa.onMtuChanged(bluetoothGatt, i, i2);
        AppMethodBeat.m2505o(94229);
    }
}
