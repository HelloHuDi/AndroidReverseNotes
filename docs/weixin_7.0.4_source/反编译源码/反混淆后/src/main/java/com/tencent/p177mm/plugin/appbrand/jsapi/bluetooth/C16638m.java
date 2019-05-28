package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.C44696b.C33257a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10345h;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C38282g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m */
public final class C16638m extends C10296a {
    private static final int CTRL_INDEX = 173;
    private static final String NAME = "openBluetoothAdapter";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m$c */
    public static class C16639c extends C42467ah {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";
        private static JSONObject hDD = new JSONObject();
        private static C16639c hDF = new C16639c();

        static {
            AppMethodBeat.m2504i(94202);
            AppMethodBeat.m2505o(94202);
        }

        /* renamed from: a */
        public static synchronized void m25604a(C2241c c2241c, boolean z, boolean z2) {
            synchronized (C16639c.class) {
                AppMethodBeat.m2504i(94201);
                if (c2241c == null) {
                    C4990ab.m7412e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.m2505o(94201);
                } else {
                    try {
                        hDD.remove("available");
                        hDD.put("available", z);
                        hDD.remove("discovering");
                        hDD.put("discovering", z2);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e);
                    }
                    if (c2241c == null) {
                        C4990ab.m7420w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.m2505o(94201);
                    } else {
                        hDF.mo61030b(c2241c, c2241c.aBw()).mo61028AM(hDD.toString()).aCj();
                        C4990ab.m7417i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", hDD.toString());
                        AppMethodBeat.m2505o(94201);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m$b */
    static class C16640b extends C42467ah {
        private static final int CTRL_INDEX = 188;
        private static final String NAME = "onBLEConnectionStateChanged";
        private static JSONObject hDD = new JSONObject();
        private static C16640b hDE = new C16640b();

        private C16640b() {
        }

        static {
            AppMethodBeat.m2504i(94200);
            AppMethodBeat.m2505o(94200);
        }

        /* renamed from: a */
        public static synchronized void m25605a(C2241c c2241c, String str, boolean z) {
            synchronized (C16640b.class) {
                AppMethodBeat.m2504i(94199);
                if (c2241c == null) {
                    C4990ab.m7412e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent dispatch fail, service is null");
                    AppMethodBeat.m2505o(94199);
                } else {
                    try {
                        hDD.remove("deviceId");
                        hDD.put("deviceId", str);
                        hDD.remove("connected");
                        hDD.put("connected", z);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e);
                    }
                    if (c2241c == null) {
                        C4990ab.m7420w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.m2505o(94199);
                    } else {
                        hDE.mo61030b(c2241c, c2241c.aBw()).mo61028AM(hDD.toString()).aCj();
                        C4990ab.m7417i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent %s", hDD.toString());
                        AppMethodBeat.m2505o(94199);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m$a */
    static class C16641a extends C42467ah {
        private static final int CTRL_INDEX = 187;
        private static final String NAME = "onBLECharacteristicValueChange";
        private static C16641a hDC = new C16641a();
        private static JSONObject hDD = new JSONObject();

        private C16641a() {
        }

        static {
            AppMethodBeat.m2504i(94198);
            AppMethodBeat.m2505o(94198);
        }

        /* renamed from: a */
        public static synchronized void m25606a(C2241c c2241c, String str, String str2, String str3, String str4) {
            synchronized (C16641a.class) {
                AppMethodBeat.m2504i(94197);
                if (c2241c == null) {
                    C4990ab.m7412e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent dispatch fail, service is null");
                    AppMethodBeat.m2505o(94197);
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
                        C4990ab.m7413e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e);
                    }
                    if (c2241c == null) {
                        C4990ab.m7420w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.m2505o(94197);
                    } else {
                        hDC.mo61030b(c2241c, c2241c.aBw()).mo61028AM(hDD.toString()).aCj();
                        C4990ab.m7417i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent %s", hDD.toString());
                        AppMethodBeat.m2505o(94197);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94203);
        C42484c.m75254kT(0);
        C4990ab.m7417i("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", c2241c.getAppId());
        C26942j a = C42483a.m75252a(r0, new C33257a() {
            /* renamed from: dV */
            public final void mo21793dV(boolean z) {
                AppMethodBeat.m2504i(94194);
                C16639c.m25604a(c2241c, z, false);
                AppMethodBeat.m2505o(94194);
            }
        }, new C10345h() {
            /* renamed from: ag */
            public final void mo21816ag(String str, boolean z) {
                AppMethodBeat.m2504i(94195);
                C16640b.m25605a(c2241c, str, z);
                AppMethodBeat.m2505o(94195);
            }
        }, new C38282g() {
            /* renamed from: f */
            public final void mo30606f(String str, String str2, String str3, String str4) {
                AppMethodBeat.m2504i(94196);
                C16641a.m25606a(c2241c, str, str2, str3, str4);
                AppMethodBeat.m2505o(94196);
            }
        });
        HashMap hashMap = new HashMap();
        switch (a.errCode) {
            case 0:
                c2241c.mo6107M(i, mo73394j("ok", hashMap));
                C42484c.m75254kT(1);
                AppMethodBeat.m2505o(94203);
                return;
            case 10001:
                hashMap.put("errCode", Integer.valueOf(10001));
                c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
                C42484c.m75253cZ(2, 7);
                AppMethodBeat.m2505o(94203);
                return;
            case 10009:
                hashMap.put("errCode", Integer.valueOf(10009));
                c2241c.mo6107M(i, mo73394j("fail:system not support", hashMap));
                C42484c.m75253cZ(2, 8);
                AppMethodBeat.m2505o(94203);
                return;
            default:
                hashMap.put("errCode", Integer.valueOf(a.errCode));
                c2241c.mo6107M(i, mo73394j(a.aIm, hashMap));
                C42484c.m75254kT(2);
                AppMethodBeat.m2505o(94203);
                return;
        }
    }
}
