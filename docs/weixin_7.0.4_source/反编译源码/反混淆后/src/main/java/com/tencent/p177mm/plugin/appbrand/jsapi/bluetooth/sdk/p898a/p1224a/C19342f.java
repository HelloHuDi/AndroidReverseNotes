package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10343a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33265f;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f */
public final class C19342f extends C10343a {
    private final String hEq;
    private final String hEr;
    private final String value;

    public C19342f(String str, String str2, String str3) {
        this.hEq = str;
        this.hEr = str2;
        this.value = str3;
    }

    public final void aCR() {
        AppMethodBeat.m2504i(94273);
        BluetoothGatt bluetoothGatt = this.hEt.hEl;
        if (bluetoothGatt == null) {
            C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            mo21808a(C26942j.hET);
            done();
            AppMethodBeat.m2505o(94273);
        } else if (C38283b.m64775AX(this.hEq)) {
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.hEq));
            if (service == null) {
                C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
                mo21808a(C26942j.hER);
                done();
                AppMethodBeat.m2505o(94273);
            } else if (C38283b.m64775AX(this.hEr)) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.hEr));
                if (characteristic == null) {
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                    mo21808a(C26942j.hES);
                    done();
                    AppMethodBeat.m2505o(94273);
                } else if (C38283b.m64778oh(characteristic.getProperties()) || C38283b.m64779oi(characteristic.getProperties())) {
                    byte[] bArr;
                    byte[] decode = Base64.decode(this.value, 2);
                    if (decode == null || decode.length == 0) {
                        C26944a.m42896e("MicroMsg.Ble.BleHelper", "data is null", new Object[0]);
                        bArr = new byte[0];
                    } else {
                        int i;
                        int i2;
                        int length = decode.length;
                        if (decode.length < length) {
                            C26944a.m42898w("MicroMsg.Ble.BleHelper", "data length is shorter then print command length", new Object[0]);
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
                        C26944a.m42895d("MicroMsg.Ble.BleHelper", "write data = %s", toUpperCase);
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
                    C26944a.m42898w("MicroMsg.Ble.Action", "dataToWrite's length:%d", Integer.valueOf(bArr.length));
                    if (this.aJe) {
                        C26944a.m42897i("MicroMsg.Ble.Action", "dataToWrite:%s", Arrays.toString(bArr));
                    }
                    if (bluetoothGatt.writeCharacteristic(characteristic)) {
                        if (!C38283b.m64778oh(characteristic.getProperties()) && C38283b.m64779oi(characteristic.getProperties())) {
                            mo21808a(C26942j.hEL);
                            done();
                        }
                        AppMethodBeat.m2505o(94273);
                        return;
                    }
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", this);
                    mo21808a(C26942j.hEV);
                    done();
                    AppMethodBeat.m2505o(94273);
                } else {
                    C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", this);
                    mo21808a(C26942j.hEU);
                    done();
                    AppMethodBeat.m2505o(94273);
                }
            } else {
                C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
                mo21808a(C26942j.hES);
                done();
                AppMethodBeat.m2505o(94273);
            }
        } else {
            C26944a.m42896e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            mo21808a(C26942j.hER);
            done();
            AppMethodBeat.m2505o(94273);
        }
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        AppMethodBeat.m2504i(94274);
        C26944a.m42897i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", this, C33265f.m54415od(i));
        if (i == 0) {
            mo21808a(C26942j.hEL);
        }
        done();
        AppMethodBeat.m2505o(94274);
    }

    public final String getName() {
        return "WriteCharacteristicAction";
    }

    public final String toString() {
        AppMethodBeat.m2504i(94275);
        String str = "WriteCharacteristicAction{serviceId='" + this.hEq + '\'' + ", characteristicId='" + this.hEr + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.aJe + ", mainThread=" + this.hDP + ", serial=" + this.hDR + '}';
        AppMethodBeat.m2505o(94275);
        return str;
    }
}
