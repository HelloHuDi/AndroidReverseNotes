package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

@TargetApi(18)
public final class f extends a {
    private final String hEq;
    private final String hEr;
    private final String value;

    public f(String str, String str2, String str3) {
        this.hEq = str;
        this.hEr = str2;
        this.value = str3;
    }

    public final void aCR() {
        AppMethodBeat.i(94273);
        BluetoothGatt bluetoothGatt = this.hEt.hEl;
        if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            a(j.hET);
            done();
            AppMethodBeat.o(94273);
        } else if (b.AX(this.hEq)) {
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.hEq));
            if (service == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
                a(j.hER);
                done();
                AppMethodBeat.o(94273);
            } else if (b.AX(this.hEr)) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.hEr));
                if (characteristic == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                    a(j.hES);
                    done();
                    AppMethodBeat.o(94273);
                } else if (b.oh(characteristic.getProperties()) || b.oi(characteristic.getProperties())) {
                    byte[] bArr;
                    byte[] decode = Base64.decode(this.value, 2);
                    if (decode == null || decode.length == 0) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleHelper", "data is null", new Object[0]);
                        bArr = new byte[0];
                    } else {
                        int i;
                        int i2;
                        int length = decode.length;
                        if (decode.length < length) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleHelper", "data length is shorter then print command length", new Object[0]);
                            length = decode.length;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (i = 0; i < length; i++) {
                            i2 = decode[i] & 255;
                            if (i2 < 16) {
                                stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            }
                            stringBuilder.append(Integer.toHexString(i2));
                        }
                        String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.d("MicroMsg.Ble.BleHelper", "write data = %s", toUpperCase);
                        if (toUpperCase == null || toUpperCase.equals("")) {
                            bArr = new byte[0];
                        } else {
                            int length2 = toUpperCase.toUpperCase().length() / 2;
                            char[] toCharArray = toUpperCase.toCharArray();
                            bArr = new byte[length2];
                            for (i = 0; i < length2; i++) {
                                i2 = i * 2;
                                bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i2])) << 4));
                            }
                        }
                    }
                    characteristic.setValue(bArr);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", Integer.valueOf(bArr.length));
                    if (this.aJe) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", Arrays.toString(bArr));
                    }
                    if (bluetoothGatt.writeCharacteristic(characteristic)) {
                        if (!b.oh(characteristic.getProperties()) && b.oi(characteristic.getProperties())) {
                            a(j.hEL);
                            done();
                        }
                        AppMethodBeat.o(94273);
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", this);
                    a(j.hEV);
                    done();
                    AppMethodBeat.o(94273);
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", this);
                    a(j.hEU);
                    done();
                    AppMethodBeat.o(94273);
                }
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
                a(j.hES);
                done();
                AppMethodBeat.o(94273);
            }
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            a(j.hER);
            done();
            AppMethodBeat.o(94273);
        }
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.i(94274);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", this, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f.od(i));
        if (i == 0) {
            a(j.hEL);
        }
        done();
        AppMethodBeat.o(94274);
    }

    public final String getName() {
        return "WriteCharacteristicAction";
    }

    public final String toString() {
        AppMethodBeat.i(94275);
        String str = "WriteCharacteristicAction{serviceId='" + this.hEq + '\'' + ", characteristicId='" + this.hEr + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
        AppMethodBeat.o(94275);
        return str;
    }
}
