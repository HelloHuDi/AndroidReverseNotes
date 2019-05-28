package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
public final class l extends a {
    private static final int CTRL_INDEX = 186;
    private static final String NAME = "notifyBLECharacteristicValueChanged";
    public static String hDy = "notification";
    public static String hDz = "indication";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94193);
        c.kT(71);
        HashMap hashMap;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            cVar.M(i, j("fail:invalid data", hashMap));
            c.cZ(73, 74);
            AppMethodBeat.o(94193);
            return;
        }
        final String appId = cVar.getAppId();
        ab.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", appId, jSONObject.toString());
        b AT = a.AT(cVar.getAppId());
        if (AT == null) {
            ab.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(73, 76);
            AppMethodBeat.o(94193);
        } else if (b.aCZ()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c cVar2;
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            boolean optBoolean = jSONObject.optBoolean("state");
            String optString4 = jSONObject.optString("type", hDz);
            boolean optBoolean2 = jSONObject.optBoolean("debug", false);
            boolean optBoolean3 = jSONObject.optBoolean("mainThread", false);
            boolean optBoolean4 = jSONObject.optBoolean("serial", true);
            if (AT.hDu != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = AT.hDu;
                if (bVar.hDY != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c cVar3 = bVar.hDY;
                    if (cVar3.hEg.get(optString) != null) {
                        d dVar = (d) cVar3.hEg.get(optString);
                        if (dVar.hEl == null) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
                        } else if (bo.isNullOrNil(optString2) || bo.isNullOrNil(optString3)) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] serviceId is null, err", new Object[0]);
                        } else if (!b.AX(optString2)) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
                        } else if (b.AX(optString3)) {
                            BluetoothGattService service = dVar.hEl.getService(UUID.fromString(optString2));
                            if (service == null) {
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
                            } else {
                                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(optString3));
                                if (characteristic == null) {
                                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] characteristics is null, err", new Object[0]);
                                } else {
                                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c cVar4 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
                                    cVar4.eCq = characteristic.getUuid().toString().toUpperCase();
                                    int properties = characteristic.getProperties();
                                    cVar4.hEC = b.og(properties);
                                    cVar4.hED = b.oh(properties);
                                    cVar4.hEE = b.oi(properties);
                                    cVar4.flq = b.oj(properties);
                                    cVar4.hEF = b.ok(properties);
                                    cVar2 = cVar4;
                                }
                            }
                        } else {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
                        }
                    }
                }
                cVar2 = null;
            } else {
                cVar2 = null;
            }
            if (cVar2 == null) {
                ab.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10005));
                cVar.M(i, j("fail:no characteristic", hashMap));
                c.kT(73);
                AppMethodBeat.o(94193);
                return;
            }
            boolean z = (cVar2.flq && !cVar2.hEF) || (cVar2.flq && cVar2.hEF && optString4.toLowerCase().equals(hDy));
            boolean z2 = (!cVar2.flq && cVar2.hEF) || (cVar2.flq && cVar2.hEF && optString4.toLowerCase().equals(hDz));
            ab.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", appId, Boolean.valueOf(z), Boolean.valueOf(z2));
            final c cVar5;
            final int i2;
            if (z) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d dVar2 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d(optString2, optString3, optBoolean);
                dVar2.aJe = optBoolean2;
                dVar2.hDP = optBoolean3;
                dVar2.hDR = optBoolean4;
                cVar5 = cVar;
                i2 = i;
                AT.a(optString, dVar2, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                    public final void a(j jVar) {
                        AppMethodBeat.i(94191);
                        HashMap hashMap;
                        switch (jVar.errCode) {
                            case 0:
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(0));
                                cVar5.M(i2, l.this.j("ok", hashMap));
                                c.kT(42);
                                AppMethodBeat.o(94191);
                                return;
                            default:
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                                cVar5.M(i2, l.this.j(jVar.aIm, hashMap));
                                c.kT(43);
                                AppMethodBeat.o(94191);
                                return;
                        }
                    }
                });
                AppMethodBeat.o(94193);
            } else if (z2) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c cVar6 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c(optString2, optString3, optBoolean);
                cVar6.aJe = optBoolean2;
                cVar6.hDP = optBoolean3;
                cVar6.hDR = optBoolean4;
                cVar5 = cVar;
                i2 = i;
                AT.a(optString, cVar6, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                    public final void a(j jVar) {
                        AppMethodBeat.i(94192);
                        ab.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", appId, jVar);
                        switch (jVar.errCode) {
                            case 0:
                                new HashMap().put("errCode", Integer.valueOf(0));
                                cVar5.M(i2, l.this.j("ok", null));
                                c.kT(42);
                                AppMethodBeat.o(94192);
                                return;
                            default:
                                new HashMap().put("errCode", Integer.valueOf(jVar.errCode));
                                cVar5.M(i2, l.this.j(jVar.aIm, null));
                                c.kT(43);
                                AppMethodBeat.o(94192);
                                return;
                        }
                    }
                });
                AppMethodBeat.o(94193);
            } else {
                ab.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(CdnLogic.kMediaTypeFavoriteBigFile));
                cVar.M(i, j("fail:internal error", hashMap));
                c.cZ(73, 82);
                AppMethodBeat.o(94193);
            }
        } else {
            ab.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(73, 79);
            AppMethodBeat.o(94193);
        }
    }
}
