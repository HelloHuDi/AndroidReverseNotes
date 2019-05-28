package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;

@TargetApi(18)
public final class b extends a {
    public String ceI;
    public boolean hEo;
    public String hEp = "LE";

    public b(String str) {
        this.ceI = str;
    }

    public final void aCR() {
        boolean z = false;
        AppMethodBeat.i(94259);
        BluetoothAdapter aCY = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCY();
        if (aCY == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothGatt is null", this);
            a(j.hET);
            done();
            AppMethodBeat.o(94259);
        } else if (this.ceI == null || !BluetoothAdapter.checkBluetoothAddress(this.ceI)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", this);
            a(j.hFc);
            done();
            AppMethodBeat.o(94259);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCZ()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
            a(j.hEO);
            done();
            AppMethodBeat.o(94259);
        } else if (this.hEt.hEl != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
            a(j.hFb);
            done();
            AppMethodBeat.o(94259);
        } else {
            BluetoothDevice remoteDevice = aCY.getRemoteDevice(this.ceI);
            if (remoteDevice != null) {
                String toUpperCase;
                BluetoothGatt connectGatt;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "autoConnect:%b transport:%s", Boolean.valueOf(this.hEo), this.hEp);
                if (VERSION.SDK_INT >= 23) {
                    toUpperCase = this.hEp.toUpperCase();
                    boolean z2 = true;
                    switch (toUpperCase.hashCode()) {
                        case 2425:
                            if (toUpperCase.equals("LE")) {
                                z2 = false;
                                break;
                            }
                            break;
                        case 2020783:
                            if (toUpperCase.equals("AUTO")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 63463747:
                            if (toUpperCase.equals("BREDR")) {
                                z2 = true;
                                break;
                            }
                            break;
                    }
                    switch (z2) {
                        case false:
                            connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hEt), 2);
                            break;
                        case true:
                            connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hEt), 0);
                            break;
                        case true:
                            connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hEt), 1);
                            break;
                        default:
                            connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hEt), 2);
                            break;
                    }
                }
                connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.hEt));
                String str;
                Object[] objArr;
                if (connectGatt != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "mBluetoothGatt:%s", connectGatt);
                    str = "MicroMsg.Ble.ConnectAction";
                    toUpperCase = "create a new connection deviceId=%s mainthread:%b";
                    objArr = new Object[2];
                    objArr[0] = this.ceI;
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        z = true;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, toUpperCase, objArr);
                    this.hEt.hEl = connectGatt;
                    AppMethodBeat.o(94259);
                    return;
                }
                String str2 = "MicroMsg.Ble.ConnectAction";
                str = "Get Gatt fail!, deviceId=%s mainthread:%b";
                objArr = new Object[2];
                objArr[0] = this.ceI;
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(str2, str, objArr);
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", this.ceI);
            }
            a(j.hEM);
            done();
            AppMethodBeat.o(94259);
        }
    }

    public final String getName() {
        return "ConnectAction";
    }

    public final void b(j jVar) {
        AppMethodBeat.i(94260);
        switch (jVar.errCode) {
            case 10012:
                this.hEt.dW(false);
                break;
        }
        AppMethodBeat.o(94260);
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.i(94261);
        String str = "MicroMsg.Ble.ConnectAction";
        String str2 = "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
        objArr[1] = f.od(i);
        objArr[2] = i2 == 2 ? "CONNECTED" : "DISCONNECTED";
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(str, str2, objArr);
        this.hEt.hEl = bluetoothGatt;
        if (i2 == 2) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
            bluetoothGatt.discoverServices();
            AppMethodBeat.o(94261);
            return;
        }
        if (i2 == 0) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
            this.hEt.dW(false);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fail:connection fail");
            stringBuilder.append(" ");
            stringBuilder.append("status:");
            stringBuilder.append(i);
            a(new j(10003, stringBuilder.toString()));
        }
        AppMethodBeat.o(94261);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.i(94262);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", f.od(i));
        this.hEt.hEl = bluetoothGatt;
        if (i == 0) {
            a(j.hEL);
        } else {
            a(j.hFd);
        }
        done();
        AppMethodBeat.o(94262);
    }

    public final String toString() {
        AppMethodBeat.i(94263);
        String str = "ConnectAction{deviceId='" + this.ceI + '\'' + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
        AppMethodBeat.o(94263);
        return str;
    }
}
