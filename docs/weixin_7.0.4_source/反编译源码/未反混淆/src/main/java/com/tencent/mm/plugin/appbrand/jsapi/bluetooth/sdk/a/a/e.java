package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import java.util.UUID;

@TargetApi(18)
public final class e extends a {
    private final String hEq;
    private final String hEr;

    public e(String str, String str2) {
        this.hEq = str;
        this.hEr = str2;
    }

    public final void aCR() {
        AppMethodBeat.i(94270);
        BluetoothGatt bluetoothGatt = this.hEt.hEl;
        if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            a(j.hET);
            done();
            AppMethodBeat.o(94270);
        } else if (b.AX(this.hEq)) {
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.hEq));
            if (service == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
                a(j.hER);
                done();
                AppMethodBeat.o(94270);
            } else if (b.AX(this.hEr)) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.hEr));
                if (characteristic == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                    a(j.hES);
                    done();
                    AppMethodBeat.o(94270);
                } else if (!b.og(characteristic.getProperties())) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support read", this);
                    a(j.hEU);
                    done();
                    AppMethodBeat.o(94270);
                } else if (bluetoothGatt.readCharacteristic(characteristic)) {
                    a(j.hEL);
                    AppMethodBeat.o(94270);
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.readCharacteristic fail", this);
                    a(j.hEV);
                    done();
                    AppMethodBeat.o(94270);
                }
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
                a(j.hES);
                done();
                AppMethodBeat.o(94270);
            }
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            a(j.hER);
            done();
            AppMethodBeat.o(94270);
        }
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.i(94271);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicRead status:%s", this, f.od(i));
        done();
        AppMethodBeat.o(94271);
    }

    public final String getName() {
        return "ReadCharacteristicAction";
    }

    public final String toString() {
        AppMethodBeat.i(94272);
        String str = "ReadCharacteristicAction{serviceId='" + this.hEq + '\'' + ", characteristicId='" + this.hEr + '\'' + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
        AppMethodBeat.o(94272);
        return str;
    }
}
