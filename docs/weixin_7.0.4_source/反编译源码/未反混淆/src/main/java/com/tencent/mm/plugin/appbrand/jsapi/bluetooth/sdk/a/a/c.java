package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import java.util.UUID;

@TargetApi(18)
public final class c extends a {
    private final boolean enable;
    private final String hEq;
    private final String hEr;

    public c(String str, String str2, boolean z) {
        this.hEq = str;
        this.hEr = str2;
        this.enable = z;
    }

    public final void aCR() {
        AppMethodBeat.i(94264);
        BluetoothGatt bluetoothGatt = this.hEt.hEl;
        if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            a(j.hET);
            done();
            AppMethodBeat.o(94264);
            return;
        }
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.hEq));
        if (service == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            a(j.hER);
            done();
            AppMethodBeat.o(94264);
        } else if (b.AX(this.hEr)) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.hEr));
            if (characteristic == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                a(j.hES);
                done();
                AppMethodBeat.o(94264);
            } else if (!b.ok(characteristic.getProperties())) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support indicate", this);
                a(j.hEU);
                done();
                AppMethodBeat.o(94264);
            } else if (bluetoothGatt.setCharacteristicNotification(characteristic, this.enable)) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b.a.hEs);
                if (descriptor == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", this);
                    a(j.hEX);
                    done();
                    AppMethodBeat.o(94264);
                    return;
                }
                if (!descriptor.setValue(this.enable ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", this);
                    a(j.hEY);
                    done();
                    AppMethodBeat.o(94264);
                } else if (bluetoothGatt.writeDescriptor(descriptor)) {
                    a(j.hEL);
                    AppMethodBeat.o(94264);
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", this);
                    a(j.hEZ);
                    done();
                    AppMethodBeat.o(94264);
                }
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", this);
                a(j.hEV);
                done();
                AppMethodBeat.o(94264);
            }
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
            a(j.hES);
            done();
            AppMethodBeat.o(94264);
        }
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.i(94265);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", this, f.od(i));
        done();
        AppMethodBeat.o(94265);
    }

    public final String getName() {
        return "IndicateCharacteristicAction";
    }

    public final String toString() {
        AppMethodBeat.i(94266);
        String str = "IndicateCharacteristicAction{serviceId='" + this.hEq + '\'' + ", characteristicId='" + this.hEr + '\'' + ", enable=" + this.enable + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
        AppMethodBeat.o(94266);
        return str;
    }
}
