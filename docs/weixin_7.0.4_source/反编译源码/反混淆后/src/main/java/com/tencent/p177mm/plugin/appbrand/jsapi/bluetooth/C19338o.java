package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.C16638m.C16639c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C38281a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C38281a.C26939a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C45588b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10346i;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C2237b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33263d;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.C10347a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o */
public final class C19338o extends C10296a {
    private static final int CTRL_INDEX = 176;
    private static final String NAME = "startBluetoothDevicesDiscovery";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o$a */
    static class C10340a extends C42467ah {
        private static final int CTRL_INDEX = 190;
        private static final String NAME = "onBluetoothDeviceFound";
        private static JSONObject hDD = new JSONObject();
        private static C10340a hDI = new C10340a();

        private C10340a() {
        }

        static {
            AppMethodBeat.m2504i(94211);
            AppMethodBeat.m2505o(94211);
        }

        /* renamed from: a */
        public static synchronized void m18036a(C2241c c2241c, C33263d c33263d) {
            synchronized (C10340a.class) {
                AppMethodBeat.m2504i(94209);
                if (c2241c == null) {
                    C4990ab.m7412e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.m2505o(94209);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray.put(c33263d.aCq());
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e);
                    }
                    try {
                        hDD.remove("devices");
                        hDD.put("devices", jSONArray);
                    } catch (JSONException e2) {
                        C4990ab.m7413e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e2);
                    }
                    if (c2241c == null) {
                        C4990ab.m7420w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                        AppMethodBeat.m2505o(94209);
                    } else {
                        hDI.mo61030b(c2241c, c2241c.aBw()).mo61028AM(hDD.toString()).aCj();
                        C4990ab.m7417i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", hDD.toString());
                        AppMethodBeat.m2505o(94209);
                    }
                }
            }
        }

        /* renamed from: a */
        public static synchronized void m18037a(C2241c c2241c, List<C33263d> list) {
            synchronized (C10340a.class) {
                AppMethodBeat.m2504i(94210);
                if (c2241c == null) {
                    C4990ab.m7412e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.m2505o(94210);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    for (C33263d aCq : list) {
                        try {
                            jSONArray.put(aCq.aCq());
                        } catch (JSONException e) {
                            C4990ab.m7413e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e);
                        }
                    }
                    try {
                        hDD.remove("devices");
                        hDD.put("devices", jSONArray);
                    } catch (JSONException e2) {
                        C4990ab.m7413e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e2);
                    }
                    if (c2241c == null) {
                        C4990ab.m7420w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                        AppMethodBeat.m2505o(94210);
                    } else {
                        hDI.mo61030b(c2241c, c2241c.aBw()).mo61028AM(hDD.toString()).aCj();
                        C4990ab.m7417i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", hDD.toString());
                        AppMethodBeat.m2505o(94210);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(94212);
        C42484c.m75254kT(11);
        HashMap hashMap;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            c2241c.mo6107M(i, mo73394j("fail:invalid data", hashMap));
            C42484c.m75253cZ(13, 14);
            AppMethodBeat.m2505o(94212);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", c2241c.getAppId(), jSONObject);
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(13, 16);
            AppMethodBeat.m2505o(94212);
        } else if (!C38283b.aCZ()) {
            C4990ab.m7412e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(13, 18);
            AppMethodBeat.m2505o(94212);
        } else if (C38283b.aCZ()) {
            boolean optBoolean = jSONObject.optBoolean("allowDuplicatesKey");
            int optInt = jSONObject.optInt("interval");
            String optString = jSONObject.optString("", "middle");
            List list = null;
            if (jSONObject.has("services")) {
                list = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("services"));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        list.add(new C10347a().mo21819a(ParcelUuid.fromString(jSONArray.getString(i2).toUpperCase())).aCV());
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
                    hashMap = new HashMap();
                    hashMap.put("isDiscovering", Boolean.FALSE);
                    hashMap.put("errCode", Integer.valueOf(10004));
                    c2241c.mo6107M(i, mo73394j("fail:no service", hashMap));
                    C42484c.m75254kT(13);
                    AppMethodBeat.m2505o(94212);
                    return;
                }
            }
            C26939a c26939a = new C26939a();
            c26939a.eCL = optInt;
            c26939a.hDL = optBoolean;
            c26939a.hDU = optString;
            C38281a aCP = c26939a.aCP();
            if (AT.hDu != null) {
                C26944a.m42897i("MicroMsg.Ble.BleManager", "initBleConfig:%s", aCP);
                C38281a.m64772a(aCP);
            }
            C193391 c193391 = new C2237b() {
                /* renamed from: a */
                public final void mo6097a(C26942j c26942j) {
                    AppMethodBeat.m2504i(94206);
                    C4990ab.m7417i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", c26942j);
                    HashMap hashMap;
                    switch (c26942j.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            hashMap.put("isDiscovering", Boolean.TRUE);
                            c2241c.mo6107M(i, C19338o.this.mo73394j("ok", hashMap));
                            C42484c.m75254kT(12);
                            AppMethodBeat.m2505o(94206);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(c26942j.errCode));
                            hashMap.put("isDiscovering", Boolean.FALSE);
                            c2241c.mo6107M(i, C19338o.this.mo73394j(c26942j.aIm, hashMap));
                            C42484c.m75254kT(13);
                            AppMethodBeat.m2505o(94206);
                            return;
                    }
                }
            };
            C193402 c193402 = new C10346i() {
                /* renamed from: a */
                public final void mo21817a(C33263d c33263d) {
                    AppMethodBeat.m2504i(94207);
                    C10340a.m18036a(c2241c, c33263d);
                    AppMethodBeat.m2505o(94207);
                }

                /* renamed from: aK */
                public final void mo21818aK(List<C33263d> list) {
                    AppMethodBeat.m2504i(94208);
                    C10340a.m18037a(c2241c, (List) list);
                    AppMethodBeat.m2505o(94208);
                }
            };
            if (AT.hDu != null) {
                C45588b c45588b = AT.hDu;
                if (c45588b.hDZ != null) {
                    c45588b.hDZ.mo44682a(c193391, list, c193402);
                }
            }
            C16639c.m25604a(c2241c, true, true);
            AppMethodBeat.m2505o(94212);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(13, 18);
            AppMethodBeat.m2505o(94212);
        }
    }
}
