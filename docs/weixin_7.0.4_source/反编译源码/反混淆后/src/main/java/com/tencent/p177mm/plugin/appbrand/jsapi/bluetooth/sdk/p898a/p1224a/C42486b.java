package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10343a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33265f;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C45587a;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b */
public final class C42486b extends C10343a {
    public String ceI;
    public boolean hEo;
    public String hEp = "LE";

    public C42486b(String str) {
        this.ceI = str;
    }

    public final void aCR() {
        boolean z = false;
        AppMethodBeat.m2504i(94259);
        BluetoothAdapter aCY = C38283b.aCY();
        if (aCY == null) {
            C26944a.m42896e("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothGatt is null", this);
            mo21808a(C26942j.hET);
            done();
            AppMethodBeat.m2505o(94259);
        } else if (this.ceI == null || !BluetoothAdapter.checkBluetoothAddress(this.ceI)) {
            C26944a.m42898w("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", this);
            mo21808a(C26942j.hFc);
            done();
            AppMethodBeat.m2505o(94259);
        } else if (!C38283b.aCZ()) {
            C26944a.m42896e("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
            mo21808a(C26942j.hEO);
            done();
            AppMethodBeat.m2505o(94259);
        } else if (this.hEt.hEl != null) {
            C26944a.m42898w("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
            mo21808a(C26942j.hFb);
            done();
            AppMethodBeat.m2505o(94259);
        } else {
            BluetoothDevice remoteDevice = aCY.getRemoteDevice(this.ceI);
            if (remoteDevice != null) {
                String toUpperCase;
                BluetoothGatt connectGatt;
                C26944a.m42897i("MicroMsg.Ble.ConnectAction", "autoConnect:%b transport:%s", Boolean.valueOf(this.hEo), this.hEp);
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
                            connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new C45587a(this.hEt), 2);
                            break;
                        case true:
                            connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new C45587a(this.hEt), 0);
                            break;
                        case true:
                            connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new C45587a(this.hEt), 1);
                            break;
                        default:
                            connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new C45587a(this.hEt), 2);
                            break;
                    }
                }
                connectGatt = remoteDevice.connectGatt(this.hEt.context, this.hEo, new C45587a(this.hEt));
                String str;
                Object[] objArr;
                if (connectGatt != null) {
                    C26944a.m42897i("MicroMsg.Ble.ConnectAction", "mBluetoothGatt:%s", connectGatt);
                    str = "MicroMsg.Ble.ConnectAction";
                    toUpperCase = "create a new connection deviceId=%s mainthread:%b";
                    objArr = new Object[2];
                    objArr[0] = this.ceI;
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        z = true;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    C26944a.m42897i(str, toUpperCase, objArr);
                    this.hEt.hEl = connectGatt;
                    AppMethodBeat.m2505o(94259);
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
                C26944a.m42896e(str2, str, objArr);
            } else {
                C26944a.m42896e("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", this.ceI);
            }
            mo21808a(C26942j.hEM);
            done();
            AppMethodBeat.m2505o(94259);
        }
    }

    public final String getName() {
        return "ConnectAction";
    }

    /* renamed from: b */
    public final void mo21811b(C26942j c26942j) {
        AppMethodBeat.m2504i(94260);
        switch (c26942j.errCode) {
            case 10012:
                this.hEt.mo21794dW(false);
                break;
        }
        AppMethodBeat.m2505o(94260);
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        AppMethodBeat.m2504i(94261);
        String str = "MicroMsg.Ble.ConnectAction";
        String str2 = "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
        objArr[1] = C33265f.m54415od(i);
        objArr[2] = i2 == 2 ? "CONNECTED" : "DISCONNECTED";
        C26944a.m42897i(str, str2, objArr);
        this.hEt.hEl = bluetoothGatt;
        if (i2 == 2) {
            C26944a.m42897i("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
            bluetoothGatt.discoverServices();
            AppMethodBeat.m2505o(94261);
            return;
        }
        if (i2 == 0) {
            C26944a.m42897i("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
            this.hEt.mo21794dW(false);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fail:connection fail");
            stringBuilder.append(" ");
            stringBuilder.append("status:");
            stringBuilder.append(i);
            mo21808a(new C26942j(10003, stringBuilder.toString()));
        }
        AppMethodBeat.m2505o(94261);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        AppMethodBeat.m2504i(94262);
        C26944a.m42897i("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", C33265f.m54415od(i));
        this.hEt.hEl = bluetoothGatt;
        if (i == 0) {
            mo21808a(C26942j.hEL);
        } else {
            mo21808a(C26942j.hFd);
        }
        done();
        AppMethodBeat.m2505o(94262);
    }

    public final String toString() {
        AppMethodBeat.m2504i(94263);
        String str = "ConnectAction{deviceId='" + this.ceI + '\'' + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
        AppMethodBeat.m2505o(94263);
        return str;
    }
}
