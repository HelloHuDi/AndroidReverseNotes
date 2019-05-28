package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10343a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33265f;
import java.util.UUID;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e */
public final class C45586e extends C10343a {
    private final String hEq;
    private final String hEr;

    public C45586e(String str, String str2) {
        this.hEq = str;
        this.hEr = str2;
    }

    public final void aCR() {
        AppMethodBeat.m2504i(94270);
        BluetoothGatt bluetoothGatt = this.hEt.hEl;
        if (bluetoothGatt == null) {
            C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            mo21808a(C26942j.hET);
            done();
            AppMethodBeat.m2505o(94270);
        } else if (C38283b.m64775AX(this.hEq)) {
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.hEq));
            if (service == null) {
                C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
                mo21808a(C26942j.hER);
                done();
                AppMethodBeat.m2505o(94270);
            } else if (C38283b.m64775AX(this.hEr)) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.hEr));
                if (characteristic == null) {
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                    mo21808a(C26942j.hES);
                    done();
                    AppMethodBeat.m2505o(94270);
                } else if (!C38283b.m64777og(characteristic.getProperties())) {
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, not support read", this);
                    mo21808a(C26942j.hEU);
                    done();
                    AppMethodBeat.m2505o(94270);
                } else if (bluetoothGatt.readCharacteristic(characteristic)) {
                    mo21808a(C26942j.hEL);
                    AppMethodBeat.m2505o(94270);
                } else {
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.readCharacteristic fail", this);
                    mo21808a(C26942j.hEV);
                    done();
                    AppMethodBeat.m2505o(94270);
                }
            } else {
                C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
                mo21808a(C26942j.hES);
                done();
                AppMethodBeat.m2505o(94270);
            }
        } else {
            C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            mo21808a(C26942j.hER);
            done();
            AppMethodBeat.m2505o(94270);
        }
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.m2504i(94271);
        C26944a.m42897i("MicroMsg.Ble.Action", "action:%s onCharacteristicRead status:%s", this, C33265f.m54415od(i));
        done();
        AppMethodBeat.m2505o(94271);
    }

    public final String getName() {
        return "ReadCharacteristicAction";
    }

    public final String toString() {
        AppMethodBeat.m2504i(94272);
        String str = "ReadCharacteristicAction{serviceId='" + this.hEq + '\'' + ", characteristicId='" + this.hEr + '\'' + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
        AppMethodBeat.m2505o(94272);
        return str;
    }
}
