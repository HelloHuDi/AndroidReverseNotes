package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class m extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 173;
    private static final String NAME = "openBluetoothAdapter";

    public static class c extends ah {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";
        private static JSONObject hDD = new JSONObject();
        private static c hDF = new c();

        static {
            AppMethodBeat.i(94202);
            AppMethodBeat.o(94202);
        }

        public static synchronized void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, boolean z, boolean z2) {
            synchronized (c.class) {
                AppMethodBeat.i(94201);
                if (cVar == null) {
                    ab.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.o(94201);
                } else {
                    try {
                        hDD.remove("available");
                        hDD.put("available", z);
                        hDD.remove("discovering");
                        hDD.put("discovering", z2);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e);
                    }
                    if (cVar == null) {
                        ab.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.o(94201);
                    } else {
                        hDF.b(cVar, cVar.aBw()).AM(hDD.toString()).aCj();
                        ab.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", hDD.toString());
                        AppMethodBeat.o(94201);
                    }
                }
            }
        }
    }

    static class b extends ah {
        private static final int CTRL_INDEX = 188;
        private static final String NAME = "onBLEConnectionStateChanged";
        private static JSONObject hDD = new JSONObject();
        private static b hDE = new b();

        private b() {
        }

        static {
            AppMethodBeat.i(94200);
            AppMethodBeat.o(94200);
        }

        public static synchronized void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, boolean z) {
            synchronized (b.class) {
                AppMethodBeat.i(94199);
                if (cVar == null) {
                    ab.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent dispatch fail, service is null");
                    AppMethodBeat.o(94199);
                } else {
                    try {
                        hDD.remove("deviceId");
                        hDD.put("deviceId", str);
                        hDD.remove("connected");
                        hDD.put("connected", z);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e);
                    }
                    if (cVar == null) {
                        ab.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.o(94199);
                    } else {
                        hDE.b(cVar, cVar.aBw()).AM(hDD.toString()).aCj();
                        ab.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent %s", hDD.toString());
                        AppMethodBeat.o(94199);
                    }
                }
            }
        }
    }

    static class a extends ah {
        private static final int CTRL_INDEX = 187;
        private static final String NAME = "onBLECharacteristicValueChange";
        private static a hDC = new a();
        private static JSONObject hDD = new JSONObject();

        private a() {
        }

        static {
            AppMethodBeat.i(94198);
            AppMethodBeat.o(94198);
        }

        public static synchronized void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, String str2, String str3, String str4) {
            synchronized (a.class) {
                AppMethodBeat.i(94197);
                if (cVar == null) {
                    ab.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent dispatch fail, service is null");
                    AppMethodBeat.o(94197);
                } else {
                    try {
                        hDD.remove("value");
                        hDD.put("value", str4);
                        hDD.remove("deviceId");
                        hDD.put("deviceId", str);
                        hDD.remove("serviceId");
                        hDD.put("serviceId", str2);
                        hDD.remove("characteristicId");
                        hDD.put("characteristicId", str3);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e);
                    }
                    if (cVar == null) {
                        ab.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.o(94197);
                    } else {
                        hDC.b(cVar, cVar.aBw()).AM(hDD.toString()).aCj();
                        ab.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent %s", hDD.toString());
                        AppMethodBeat.o(94197);
                    }
                }
            }
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94203);
        c.kT(0);
        ab.i("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", cVar.getAppId());
        j a = a.a(r0, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.a() {
            public final void dV(boolean z) {
                AppMethodBeat.i(94194);
                c.a(cVar, z, false);
                AppMethodBeat.o(94194);
            }
        }, new h() {
            public final void ag(String str, boolean z) {
                AppMethodBeat.i(94195);
                b.a(cVar, str, z);
                AppMethodBeat.o(94195);
            }
        }, new g() {
            public final void f(String str, String str2, String str3, String str4) {
                AppMethodBeat.i(94196);
                a.a(cVar, str, str2, str3, str4);
                AppMethodBeat.o(94196);
            }
        });
        HashMap hashMap = new HashMap();
        switch (a.errCode) {
            case 0:
                cVar.M(i, j("ok", hashMap));
                c.kT(1);
                AppMethodBeat.o(94203);
                return;
            case 10001:
                hashMap.put("errCode", Integer.valueOf(10001));
                cVar.M(i, j("fail:not available", hashMap));
                c.cZ(2, 7);
                AppMethodBeat.o(94203);
                return;
            case 10009:
                hashMap.put("errCode", Integer.valueOf(10009));
                cVar.M(i, j("fail:system not support", hashMap));
                c.cZ(2, 8);
                AppMethodBeat.o(94203);
                return;
            default:
                hashMap.put("errCode", Integer.valueOf(a.errCode));
                cVar.M(i, j(a.aIm, hashMap));
                c.kT(2);
                AppMethodBeat.o(94203);
                return;
        }
    }
}
