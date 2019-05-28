package com.tencent.p177mm.plugin.appbrand.jsapi.p899c;

import android.annotation.TargetApi;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p899c.C33269a.C10354a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p899c.C33269a.C10354a.C10355a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7370b;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.c */
public final class C16645c extends C10296a {
    private static final int CTRL_INDEX = 221;
    private static final String NAME = "startBeaconDiscovery";
    private C10355a hKb;
    C33186c hKg = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.c$a */
    static class C16648a extends C42467ah {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private C16648a() {
        }

        /* synthetic */ C16648a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.c$b */
    static class C16649b extends C42467ah {
        private static final int CTRL_INDEX = 224;
        private static final String NAME = "onBeaconUpdated";

        private C16649b() {
        }

        /* synthetic */ C16649b(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94364);
        C4990ab.m7417i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", jSONObject);
        UUID[] z = C16645c.m25610z(jSONObject);
        if (z == null || z.length <= 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED));
            c2241c.mo6107M(i, mo73394j("fail:invalid data", hashMap));
            AppMethodBeat.m2505o(94364);
            return;
        }
        C7370b F;
        String appId = c2241c.getAppId();
        C10354a AZ = C33269a.m54418AZ(c2241c.getAppId());
        if (AZ == null) {
            C4990ab.m7416i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
            AZ = new C10354a();
            C33269a.m54419a(appId, AZ);
        }
        if (this.hKb == null) {
            C4990ab.m7416i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
            this.hKb = new C10355a() {
                C16649b hKh = new C16649b();
                C16648a hKi = new C16648a();

                /* renamed from: z */
                public final void mo21828z(Map<String, JSONObject> map) {
                    AppMethodBeat.m2504i(94361);
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
                        C4990ab.m7413e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", e);
                    }
                    this.hKh.mo61030b(c2241c, c2241c.aBw()).mo61028AM(jSONObject2.toString()).aCj();
                    AppMethodBeat.m2505o(94361);
                }

                /* renamed from: dV */
                public final void mo21827dV(boolean z) {
                    AppMethodBeat.m2504i(94362);
                    C4990ab.m7417i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", Boolean.valueOf(z));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("available", z);
                        jSONObject.put("discovering", false);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", e);
                    }
                    C4990ab.m7411d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject.toString());
                    this.hKi.mo61030b(c2241c, c2241c.aBw()).mo61028AM(jSONObject.toString()).aCj();
                    AppMethodBeat.m2505o(94362);
                }
            };
        }
        if (this.hKg == null) {
            C4990ab.m7416i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
            this.hKg = new C33186c() {
                public final void onDestroy() {
                    AppMethodBeat.m2504i(94363);
                    C4990ab.m7416i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
                    C33183g.m54276b(c2241c.getAppId(), this);
                    C10354a AZ = C33269a.m54418AZ(c2241c.getAppId());
                    if (AZ != null) {
                        AZ.mo21825EH();
                        C33269a.remove(c2241c.getAppId());
                    }
                    C16645c.this.hKg = null;
                    AppMethodBeat.m2505o(94363);
                }
            };
            C33183g.m54274a(c2241c.getAppId(), this.hKg);
        }
        AZ.hKa = z;
        AZ.hKb = this.hKb;
        C4990ab.m7417i("MicroMsg.BeaconManager", "BeaconWorker:%d start", Integer.valueOf(AZ.hashCode()));
        if (AZ.isStart()) {
            C4990ab.m7417i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", Integer.valueOf(AZ.hashCode()));
            F = C5710a.m8574F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY), "fail:already start");
        } else if (C1443d.m3067fP(18)) {
            C4990ab.m7412e("MicroMsg.BeaconManager", "API version is below 18!");
            F = C5710a.m8574F(Integer.valueOf(CdnLogic.kMediaTypeExposeImage), "fail:not support");
        } else if (AZ.hJY == null) {
            C4990ab.m7412e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            F = C5710a.m8574F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS), "fail:bluetooth service is unavailable");
        } else if (!AZ.hJY.isEnabled()) {
            C4990ab.m7412e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            F = C5710a.m8574F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS), "fail:bluetooth service is unavailable");
        } else if (AZ.hJY.isDiscovering()) {
            C4990ab.m7412e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
            F = C5710a.m8574F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY), "fail:already start");
        } else {
            AZ.hJZ.clear();
            C4990ab.m7417i("MicroMsg.BeaconManager", "startLeScan:%b", Boolean.valueOf(AZ.hJY.startLeScan(AZ.hKe)));
            if (AZ.hJY.startLeScan(AZ.hKe)) {
                AZ.cFy = true;
                F = C5710a.m8574F(Integer.valueOf(0), "");
            } else {
                F = C5710a.m8574F(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL), "fail:system error");
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errCode", F.get(0));
        c2241c.mo6107M(i, mo73394j(((Integer) F.get(0)).intValue() == 0 ? "ok" : (String) F.get(1), hashMap2));
        AppMethodBeat.m2505o(94364);
    }

    /* renamed from: z */
    private static UUID[] m25610z(JSONObject jSONObject) {
        AppMethodBeat.m2504i(94365);
        UUID[] uuidArr = null;
        if (jSONObject.has("uuids")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("uuids"));
                uuidArr = new UUID[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    C4990ab.m7411d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", jSONArray.getString(i));
                    uuidArr[i] = UUID.fromString(r3);
                }
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
            }
        }
        AppMethodBeat.m2505o(94365);
        return uuidArr;
    }
}
