package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C38281a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10345h;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33262c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33264e;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33265f;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C38282g;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d */
public final class C10341d implements C26941e {
    public String ceI;
    public Context context;
    public C10345h hEh;
    public C38282g hEi;
    public C38279b hEk;
    public BluetoothGatt hEl;
    public List<C33264e> hEm;
    public Map<String, List<C33262c>> hEn;

    public C10341d(Context context, String str) {
        this.context = context;
        this.ceI = str;
    }

    /* renamed from: dW */
    public final synchronized void mo21794dW(boolean z) {
        AppMethodBeat.m2504i(94246);
        if (this.hEl != null) {
            C26944a.m42897i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s closeMyself", this.ceI);
            if (z) {
                m18038ah(this.ceI, false);
            }
            if (C38281a.hDK.hDW) {
                C38283b.m64776a(this.hEl);
            }
            this.hEl.close();
            this.hEl = null;
        }
        AppMethodBeat.m2505o(94246);
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94247);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = C33265f.m54415od(i);
        objArr[2] = i2 == 2 ? "CONNECTED" : "DISCONNECTED";
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onConnectionStateChange(bluetoothGatt, i, i2);
        if (i != 0 || (i2 != 2 && i2 == 0)) {
            mo21794dW(true);
        }
        AppMethodBeat.m2505o(94247);
    }

    /* renamed from: ah */
    private void m18038ah(String str, boolean z) {
        AppMethodBeat.m2504i(94248);
        if (this.hEh != null) {
            this.hEh.mo21816ag(str, z);
        }
        AppMethodBeat.m2505o(94248);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.m2504i(94249);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onServicesDiscovered]gatt deviceId:%s status:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = C33265f.m54415od(i);
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onServicesDiscovered(bluetoothGatt, i);
        if (i == 0) {
            m18038ah(bluetoothGatt.getDevice().getAddress(), true);
        }
        AppMethodBeat.m2505o(94249);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.m2504i(94250);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = C33265f.m54415od(i);
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        if (i == 0) {
            C26944a.m42897i("MicroMsg.Ble.BleConnectWorker", "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase(), bluetoothGattCharacteristic.getUuid().toString().toUpperCase(), new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2)));
            this.hEi.mo30606f(r0, str2, r3, str);
        }
        AppMethodBeat.m2505o(94250);
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.m2504i(94251);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s";
        Object[] objArr = new Object[4];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = bluetoothGattCharacteristic != null ? Arrays.asList(new byte[][]{bluetoothGattCharacteristic.getValue()}) : "";
        objArr[3] = C33265f.m54415od(i);
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        AppMethodBeat.m2505o(94251);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.m2504i(94252);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        if (this.hEi != null) {
            C26944a.m42897i("MicroMsg.Ble.BleConnectWorker", "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase(), bluetoothGattCharacteristic.getUuid().toString().toUpperCase(), new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2)));
            this.hEi.mo30606f(r0, str2, r3, str);
        }
        AppMethodBeat.m2505o(94252);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.m2504i(94253);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onDescriptorRead]gatt deviceId:%s descriptorId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        AppMethodBeat.m2505o(94253);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.m2504i(94254);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        AppMethodBeat.m2505o(94254);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.m2504i(94255);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onReliableWriteCompleted]gatt deviceId:%s status:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = C33265f.m54415od(i);
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onReliableWriteCompleted(bluetoothGatt, i);
        AppMethodBeat.m2505o(94255);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94256);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = C33265f.m54415od(i2);
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onReadRemoteRssi(bluetoothGatt, i, i2);
        AppMethodBeat.m2505o(94256);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94257);
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = C33265f.m54415od(i2);
        C26944a.m42897i(str, str2, objArr);
        this.hEk.onMtuChanged(bluetoothGatt, i, i2);
        AppMethodBeat.m2505o(94257);
    }
}
