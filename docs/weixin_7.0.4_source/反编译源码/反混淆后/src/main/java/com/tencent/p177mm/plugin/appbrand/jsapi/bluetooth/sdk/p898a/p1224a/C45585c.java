package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p300b.C2236a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10343a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33265f;
import java.util.UUID;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c */
public final class C45585c extends C10343a {
    private final boolean enable;
    private final String hEq;
    private final String hEr;

    public C45585c(String str, String str2, boolean z) {
        this.hEq = str;
        this.hEr = str2;
        this.enable = z;
    }

    public final void aCR() {
        AppMethodBeat.m2504i(94264);
        BluetoothGatt bluetoothGatt = this.hEt.hEl;
        if (bluetoothGatt == null) {
            C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            mo21808a(C26942j.hET);
            done();
            AppMethodBeat.m2505o(94264);
            return;
        }
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.hEq));
        if (service == null) {
            C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            mo21808a(C26942j.hER);
            done();
            AppMethodBeat.m2505o(94264);
        } else if (C38283b.m64775AX(this.hEr)) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.hEr));
            if (characteristic == null) {
                C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                mo21808a(C26942j.hES);
                done();
                AppMethodBeat.m2505o(94264);
            } else if (!C38283b.m64781ok(characteristic.getProperties())) {
                C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, not support indicate", this);
                mo21808a(C26942j.hEU);
                done();
                AppMethodBeat.m2505o(94264);
            } else if (bluetoothGatt.setCharacteristicNotification(characteristic, this.enable)) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(C2236a.hEs);
                if (descriptor == null) {
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", this);
                    mo21808a(C26942j.hEX);
                    done();
                    AppMethodBeat.m2505o(94264);
                    return;
                }
                if (!descriptor.setValue(this.enable ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", this);
                    mo21808a(C26942j.hEY);
                    done();
                    AppMethodBeat.m2505o(94264);
                } else if (bluetoothGatt.writeDescriptor(descriptor)) {
                    mo21808a(C26942j.hEL);
                    AppMethodBeat.m2505o(94264);
                } else {
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", this);
                    mo21808a(C26942j.hEZ);
                    done();
                    AppMethodBeat.m2505o(94264);
                }
            } else {
                C26944a.m42896e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", this);
                mo21808a(C26942j.hEV);
                done();
                AppMethodBeat.m2505o(94264);
            }
        } else {
            C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
            mo21808a(C26942j.hES);
            done();
            AppMethodBeat.m2505o(94264);
        }
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        AppMethodBeat.m2504i(94265);
        C26944a.m42897i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", this, C33265f.m54415od(i));
        done();
        AppMethodBeat.m2505o(94265);
    }

    public final String getName() {
        return "IndicateCharacteristicAction";
    }

    public final String toString() {
        AppMethodBeat.m2504i(94266);
        String str = "IndicateCharacteristicAction{serviceId='" + this.hEq + '\'' + ", characteristicId='" + this.hEr + '\'' + ", enable=" + this.enable + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
        AppMethodBeat.m2505o(94266);
        return str;
    }
}
