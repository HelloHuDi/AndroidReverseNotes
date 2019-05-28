package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@TargetApi(18)
public final class d implements e {
    public String ceI;
    public Context context;
    public h hEh;
    public g hEi;
    public b hEk;
    public BluetoothGatt hEl;
    public List<e> hEm;
    public Map<String, List<c>> hEn;

    public d(Context context, String str) {
        this.context = context;
        this.ceI = str;
    }

    public final synchronized void dW(boolean z) {
        AppMethodBeat.i(94246);
        if (this.hEl != null) {
            a.i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s closeMyself", this.ceI);
            if (z) {
                ah(this.ceI, false);
            }
            if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.hDW) {
                b.a(this.hEl);
            }
            this.hEl.close();
            this.hEl = null;
        }
        AppMethodBeat.o(94246);
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94247);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.od(i);
        objArr[2] = i2 == 2 ? "CONNECTED" : "DISCONNECTED";
        a.i(str, str2, objArr);
        this.hEk.onConnectionStateChange(bluetoothGatt, i, i2);
        if (i != 0 || (i2 != 2 && i2 == 0)) {
            dW(true);
        }
        AppMethodBeat.o(94247);
    }

    private void ah(String str, boolean z) {
        AppMethodBeat.i(94248);
        if (this.hEh != null) {
            this.hEh.ag(str, z);
        }
        AppMethodBeat.o(94248);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.i(94249);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onServicesDiscovered]gatt deviceId:%s status:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.od(i);
        a.i(str, str2, objArr);
        this.hEk.onServicesDiscovered(bluetoothGatt, i);
        if (i == 0) {
            ah(bluetoothGatt.getDevice().getAddress(), true);
        }
        AppMethodBeat.o(94249);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.i(94250);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = f.od(i);
        a.i(str, str2, objArr);
        this.hEk.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        if (i == 0) {
            a.i("MicroMsg.Ble.BleConnectWorker", "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase(), bluetoothGattCharacteristic.getUuid().toString().toUpperCase(), new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2)));
            this.hEi.f(r0, str2, r3, str);
        }
        AppMethodBeat.o(94250);
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.i(94251);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s";
        Object[] objArr = new Object[4];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = bluetoothGattCharacteristic != null ? Arrays.asList(new byte[][]{bluetoothGattCharacteristic.getValue()}) : "";
        objArr[3] = f.od(i);
        a.i(str, str2, objArr);
        this.hEk.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        AppMethodBeat.o(94251);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.i(94252);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        a.i(str, str2, objArr);
        this.hEk.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        if (this.hEi != null) {
            a.i("MicroMsg.Ble.BleConnectWorker", "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase(), bluetoothGattCharacteristic.getUuid().toString().toUpperCase(), new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2)));
            this.hEi.f(r0, str2, r3, str);
        }
        AppMethodBeat.o(94252);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.i(94253);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onDescriptorRead]gatt deviceId:%s descriptorId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        a.i(str, str2, objArr);
        this.hEk.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        AppMethodBeat.o(94253);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.i(94254);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        a.i(str, str2, objArr);
        this.hEk.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        AppMethodBeat.o(94254);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.i(94255);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onReliableWriteCompleted]gatt deviceId:%s status:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.od(i);
        a.i(str, str2, objArr);
        this.hEk.onReliableWriteCompleted(bluetoothGatt, i);
        AppMethodBeat.o(94255);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94256);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = f.od(i2);
        a.i(str, str2, objArr);
        this.hEk.onReadRemoteRssi(bluetoothGatt, i, i2);
        AppMethodBeat.o(94256);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94257);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = f.od(i2);
        a.i(str, str2, objArr);
        this.hEk.onMtuChanged(bluetoothGatt, i, i2);
        AppMethodBeat.o(94257);
    }
}
