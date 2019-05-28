package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class o extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 176;
    private static final String NAME = "startBluetoothDevicesDiscovery";

    static class a extends ah {
        private static final int CTRL_INDEX = 190;
        private static final String NAME = "onBluetoothDeviceFound";
        private static JSONObject hDD = new JSONObject();
        private static a hDI = new a();

        private a() {
        }

        static {
            AppMethodBeat.i(94211);
            AppMethodBeat.o(94211);
        }

        public static synchronized void a(c cVar, d dVar) {
            synchronized (a.class) {
                AppMethodBeat.i(94209);
                if (cVar == null) {
                    ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.o(94209);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray.put(dVar.aCq());
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e);
                    }
                    try {
                        hDD.remove("devices");
                        hDD.put("devices", jSONArray);
                    } catch (JSONException e2) {
                        ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e2);
                    }
                    if (cVar == null) {
                        ab.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                        AppMethodBeat.o(94209);
                    } else {
                        hDI.b(cVar, cVar.aBw()).AM(hDD.toString()).aCj();
                        ab.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", hDD.toString());
                        AppMethodBeat.o(94209);
                    }
                }
            }
        }

        public static synchronized void a(c cVar, List<d> list) {
            synchronized (a.class) {
                AppMethodBeat.i(94210);
                if (cVar == null) {
                    ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.o(94210);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    for (d aCq : list) {
                        try {
                            jSONArray.put(aCq.aCq());
                        } catch (JSONException e) {
                            ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e);
                        }
                    }
                    try {
                        hDD.remove("devices");
                        hDD.put("devices", jSONArray);
                    } catch (JSONException e2) {
                        ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e2);
                    }
                    if (cVar == null) {
                        ab.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                        AppMethodBeat.o(94210);
                    } else {
                        hDI.b(cVar, cVar.aBw()).AM(hDD.toString()).aCj();
                        ab.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", hDD.toString());
                        AppMethodBeat.o(94210);
                    }
                }
            }
        }
    }

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(94212);
        c.kT(11);
        HashMap hashMap;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            cVar.M(i, j("fail:invalid data", hashMap));
            c.cZ(13, 14);
            AppMethodBeat.o(94212);
            return;
        }
        ab.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", cVar.getAppId(), jSONObject);
        b AT = a.AT(cVar.getAppId());
        if (AT == null) {
            ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(13, 16);
            AppMethodBeat.o(94212);
        } else if (!b.aCZ()) {
            ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(13, 18);
            AppMethodBeat.o(94212);
        } else if (b.aCZ()) {
            boolean optBoolean = jSONObject.optBoolean("allowDuplicatesKey");
            int optInt = jSONObject.optInt("interval");
            String optString = jSONObject.optString("", "middle");
            List list = null;
            if (jSONObject.has("services")) {
                list = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("services"));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        list.add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.a().a(ParcelUuid.fromString(jSONArray.getString(i2).toUpperCase())).aCV());
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
                    hashMap = new HashMap();
                    hashMap.put("isDiscovering", Boolean.FALSE);
                    hashMap.put("errCode", Integer.valueOf(10004));
                    cVar.M(i, j("fail:no service", hashMap));
                    c.kT(13);
                    AppMethodBeat.o(94212);
                    return;
                }
            }
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a();
            aVar.eCL = optInt;
            aVar.hDL = optBoolean;
            aVar.hDU = optString;
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a aCP = aVar.aCP();
            if (AT.hDu != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleManager", "initBleConfig:%s", aCP);
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(aCP);
            }
            AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                public final void a(j jVar) {
                    AppMethodBeat.i(94206);
                    ab.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", jVar);
                    HashMap hashMap;
                    switch (jVar.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            hashMap.put("isDiscovering", Boolean.TRUE);
                            cVar.M(i, o.this.j("ok", hashMap));
                            c.kT(12);
                            AppMethodBeat.o(94206);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                            hashMap.put("isDiscovering", Boolean.FALSE);
                            cVar.M(i, o.this.j(jVar.aIm, hashMap));
                            c.kT(13);
                            AppMethodBeat.o(94206);
                            return;
                    }
                }
            };
            AnonymousClass2 anonymousClass2 = new i() {
                public final void a(d dVar) {
                    AppMethodBeat.i(94207);
                    a.a(cVar, dVar);
                    AppMethodBeat.o(94207);
                }

                public final void aK(List<d> list) {
                    AppMethodBeat.i(94208);
                    a.a(cVar, (List) list);
                    AppMethodBeat.o(94208);
                }
            };
            if (AT.hDu != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = AT.hDu;
                if (bVar.hDZ != null) {
                    bVar.hDZ.a(anonymousClass1, list, anonymousClass2);
                }
            }
            m.c.a(cVar, true, true);
            AppMethodBeat.o(94212);
        } else {
            ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(13, 18);
            AppMethodBeat.o(94212);
        }
    }
}
