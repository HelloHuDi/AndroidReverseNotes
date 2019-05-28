package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 221;
    private static final String NAME = "startBeaconDiscovery";
    private com.tencent.mm.plugin.appbrand.jsapi.c.a.a.a hKb;
    com.tencent.mm.plugin.appbrand.g.c hKg = null;

    static class a extends ah {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static class b extends ah {
        private static final int CTRL_INDEX = 224;
        private static final String NAME = "onBeaconUpdated";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94364);
        ab.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", jSONObject);
        UUID[] z = z(jSONObject);
        if (z == null || z.length <= 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED));
            cVar.M(i, j("fail:invalid data", hashMap));
            AppMethodBeat.o(94364);
            return;
        }
        com.tencent.mm.vending.j.b F;
        String appId = cVar.getAppId();
        com.tencent.mm.plugin.appbrand.jsapi.c.a.a AZ = a.AZ(cVar.getAppId());
        if (AZ == null) {
            ab.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
            AZ = new com.tencent.mm.plugin.appbrand.jsapi.c.a.a();
            a.a(appId, AZ);
        }
        if (this.hKb == null) {
            ab.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
            this.hKb = new com.tencent.mm.plugin.appbrand.jsapi.c.a.a.a() {
                b hKh = new b();
                a hKi = new a();

                public final void z(Map<String, JSONObject> map) {
                    AppMethodBeat.i(94361);
                    JSONArray jSONArray = new JSONArray();
                    for (JSONObject jSONObject : map.values()) {
                        if (jSONObject != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("beacons", jSONArray);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", e);
                    }
                    this.hKh.b(cVar, cVar.aBw()).AM(jSONObject2.toString()).aCj();
                    AppMethodBeat.o(94361);
                }

                public final void dV(boolean z) {
                    AppMethodBeat.i(94362);
                    ab.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", Boolean.valueOf(z));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("available", z);
                        jSONObject.put("discovering", false);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", e);
                    }
                    ab.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject.toString());
                    this.hKi.b(cVar, cVar.aBw()).AM(jSONObject.toString()).aCj();
                    AppMethodBeat.o(94362);
                }
            };
        }
        if (this.hKg == null) {
            ab.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
            this.hKg = new com.tencent.mm.plugin.appbrand.g.c() {
                public final void onDestroy() {
                    AppMethodBeat.i(94363);
                    ab.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
                    g.b(cVar.getAppId(), this);
                    com.tencent.mm.plugin.appbrand.jsapi.c.a.a AZ = a.AZ(cVar.getAppId());
                    if (AZ != null) {
                        AZ.EH();
                        a.remove(cVar.getAppId());
                    }
                    c.this.hKg = null;
                    AppMethodBeat.o(94363);
                }
            };
            g.a(cVar.getAppId(), this.hKg);
        }
        AZ.hKa = z;
        AZ.hKb = this.hKb;
        ab.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", Integer.valueOf(AZ.hashCode()));
        if (AZ.isStart()) {
            ab.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", Integer.valueOf(AZ.hashCode()));
            F = com.tencent.mm.vending.j.a.F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY), "fail:already start");
        } else if (d.fP(18)) {
            ab.e("MicroMsg.BeaconManager", "API version is below 18!");
            F = com.tencent.mm.vending.j.a.F(Integer.valueOf(CdnLogic.kMediaTypeExposeImage), "fail:not support");
        } else if (AZ.hJY == null) {
            ab.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            F = com.tencent.mm.vending.j.a.F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS), "fail:bluetooth service is unavailable");
        } else if (!AZ.hJY.isEnabled()) {
            ab.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            F = com.tencent.mm.vending.j.a.F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS), "fail:bluetooth service is unavailable");
        } else if (AZ.hJY.isDiscovering()) {
            ab.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
            F = com.tencent.mm.vending.j.a.F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY), "fail:already start");
        } else {
            AZ.hJZ.clear();
            ab.i("MicroMsg.BeaconManager", "startLeScan:%b", Boolean.valueOf(AZ.hJY.startLeScan(AZ.hKe)));
            if (AZ.hJY.startLeScan(AZ.hKe)) {
                AZ.cFy = true;
                F = com.tencent.mm.vending.j.a.F(Integer.valueOf(0), "");
            } else {
                F = com.tencent.mm.vending.j.a.F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL), "fail:system error");
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errCode", F.get(0));
        cVar.M(i, j(((Integer) F.get(0)).intValue() == 0 ? "ok" : (String) F.get(1), hashMap2));
        AppMethodBeat.o(94364);
    }

    private static UUID[] z(JSONObject jSONObject) {
        AppMethodBeat.i(94365);
        UUID[] uuidArr = null;
        if (jSONObject.has("uuids")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("uuids"));
                uuidArr = new UUID[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    ab.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", jSONArray.getString(i));
                    uuidArr[i] = UUID.fromString(r3);
                }
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
            }
        }
        AppMethodBeat.o(94365);
        return uuidArr;
    }
}
