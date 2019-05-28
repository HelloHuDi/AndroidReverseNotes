package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C45588b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C2237b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33262c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C10341d;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C33260c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a.C38278d;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a.C45585c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l */
public final class C45584l extends C10296a {
    private static final int CTRL_INDEX = 186;
    private static final String NAME = "notifyBLECharacteristicValueChanged";
    public static String hDy = "notification";
    public static String hDz = "indication";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94193);
        C42484c.m75254kT(71);
        HashMap hashMap;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            c2241c.mo6107M(i, mo73394j("fail:invalid data", hashMap));
            C42484c.m75253cZ(73, 74);
            AppMethodBeat.m2505o(94193);
            return;
        }
        final String appId = c2241c.getAppId();
        C4990ab.m7417i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", appId, jSONObject.toString());
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(73, 76);
            AppMethodBeat.m2505o(94193);
        } else if (C38283b.aCZ()) {
            C33262c c33262c;
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            boolean optBoolean = jSONObject.optBoolean("state");
            String optString4 = jSONObject.optString("type", hDz);
            boolean optBoolean2 = jSONObject.optBoolean("debug", false);
            boolean optBoolean3 = jSONObject.optBoolean("mainThread", false);
            boolean optBoolean4 = jSONObject.optBoolean("serial", true);
            if (AT.hDu != null) {
                C45588b c45588b = AT.hDu;
                if (c45588b.hDY != null) {
                    C33260c c33260c = c45588b.hDY;
                    if (c33260c.hEg.get(optString) != null) {
                        C10341d c10341d = (C10341d) c33260c.hEg.get(optString);
                        if (c10341d.hEl == null) {
                            C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
                        } else if (C5046bo.isNullOrNil(optString2) || C5046bo.isNullOrNil(optString3)) {
                            C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] serviceId is null, err", new Object[0]);
                        } else if (!C38283b.m64775AX(optString2)) {
                            C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
                        } else if (C38283b.m64775AX(optString3)) {
                            BluetoothGattService service = c10341d.hEl.getService(UUID.fromString(optString2));
                            if (service == null) {
                                C26944a.m42898w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
                            } else {
                                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(optString3));
                                if (characteristic == null) {
                                    C26944a.m42898w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] characteristics is null, err", new Object[0]);
                                } else {
                                    C33262c c33262c2 = new C33262c();
                                    c33262c2.eCq = characteristic.getUuid().toString().toUpperCase();
                                    int properties = characteristic.getProperties();
                                    c33262c2.hEC = C38283b.m64777og(properties);
                                    c33262c2.hED = C38283b.m64778oh(properties);
                                    c33262c2.hEE = C38283b.m64779oi(properties);
                                    c33262c2.flq = C38283b.m64780oj(properties);
                                    c33262c2.hEF = C38283b.m64781ok(properties);
                                    c33262c = c33262c2;
                                }
                            }
                        } else {
                            C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
                        }
                    }
                }
                c33262c = null;
            } else {
                c33262c = null;
            }
            if (c33262c == null) {
                C4990ab.m7412e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10005));
                c2241c.mo6107M(i, mo73394j("fail:no characteristic", hashMap));
                C42484c.m75254kT(73);
                AppMethodBeat.m2505o(94193);
                return;
            }
            boolean z = (c33262c.flq && !c33262c.hEF) || (c33262c.flq && c33262c.hEF && optString4.toLowerCase().equals(hDy));
            boolean z2 = (!c33262c.flq && c33262c.hEF) || (c33262c.flq && c33262c.hEF && optString4.toLowerCase().equals(hDz));
            C4990ab.m7417i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", appId, Boolean.valueOf(z), Boolean.valueOf(z2));
            final C2241c c2241c2;
            final int i2;
            if (z) {
                C38278d c38278d = new C38278d(optString2, optString3, optBoolean);
                c38278d.aJe = optBoolean2;
                c38278d.hDP = optBoolean3;
                c38278d.hDR = optBoolean4;
                c2241c2 = c2241c;
                i2 = i;
                AT.mo71732a(optString, c38278d, new C2237b() {
                    /* renamed from: a */
                    public final void mo6097a(C26942j c26942j) {
                        AppMethodBeat.m2504i(94191);
                        HashMap hashMap;
                        switch (c26942j.errCode) {
                            case 0:
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(0));
                                c2241c2.mo6107M(i2, C45584l.this.mo73394j("ok", hashMap));
                                C42484c.m75254kT(42);
                                AppMethodBeat.m2505o(94191);
                                return;
                            default:
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(c26942j.errCode));
                                c2241c2.mo6107M(i2, C45584l.this.mo73394j(c26942j.aIm, hashMap));
                                C42484c.m75254kT(43);
                                AppMethodBeat.m2505o(94191);
                                return;
                        }
                    }
                });
                AppMethodBeat.m2505o(94193);
            } else if (z2) {
                C45585c c45585c = new C45585c(optString2, optString3, optBoolean);
                c45585c.aJe = optBoolean2;
                c45585c.hDP = optBoolean3;
                c45585c.hDR = optBoolean4;
                c2241c2 = c2241c;
                i2 = i;
                AT.mo71732a(optString, c45585c, new C2237b() {
                    /* renamed from: a */
                    public final void mo6097a(C26942j c26942j) {
                        AppMethodBeat.m2504i(94192);
                        C4990ab.m7417i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", appId, c26942j);
                        switch (c26942j.errCode) {
                            case 0:
                                new HashMap().put("errCode", Integer.valueOf(0));
                                c2241c2.mo6107M(i2, C45584l.this.mo73394j("ok", null));
                                C42484c.m75254kT(42);
                                AppMethodBeat.m2505o(94192);
                                return;
                            default:
                                new HashMap().put("errCode", Integer.valueOf(c26942j.errCode));
                                c2241c2.mo6107M(i2, C45584l.this.mo73394j(c26942j.aIm, null));
                                C42484c.m75254kT(43);
                                AppMethodBeat.m2505o(94192);
                                return;
                        }
                    }
                });
                AppMethodBeat.m2505o(94193);
            } else {
                C4990ab.m7416i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(CdnLogic.kMediaTypeFavoriteBigFile));
                c2241c.mo6107M(i, mo73394j("fail:internal error", hashMap));
                C42484c.m75253cZ(73, 82);
                AppMethodBeat.m2505o(94193);
            }
        } else {
            C4990ab.m7412e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(73, 79);
            AppMethodBeat.m2505o(94193);
        }
    }
}
