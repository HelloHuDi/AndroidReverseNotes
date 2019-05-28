package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.C16638m.C16639c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C45588b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.p */
public final class C33258p extends C10296a {
    private static final int CTRL_INDEX = 177;
    private static final String NAME = "stopBluetoothDevicesDiscovery";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94213);
        C42484c.m75254kT(101);
        String appId = c2241c.getAppId();
        String str = "MicroMsg.JsApiStopBluetoothDevicesDiscovery";
        String str2 = "appId:%s stopBluetoothDevicesDiscovery data:%s";
        Object[] objArr = new Object[2];
        objArr[0] = appId;
        if (jSONObject == null) {
            jSONObject = "";
        }
        objArr[1] = jSONObject;
        C4990ab.m7417i(str, str2, objArr);
        C44696b AT = C42483a.m75250AT(appId);
        HashMap hashMap;
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(103, 106);
            AppMethodBeat.m2505o(94213);
        } else if (C38283b.aCZ()) {
            C26942j aCU;
            if (AT.hDu != null) {
                C45588b c45588b = AT.hDu;
                if (c45588b.hDZ != null) {
                    aCU = c45588b.hDZ.aCU();
                } else {
                    aCU = C26942j.hEM;
                }
            } else {
                aCU = C26942j.hEM;
            }
            C4990ab.m7417i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", aCU);
            HashMap hashMap2 = new HashMap();
            switch (aCU.errCode) {
                case 0:
                    hashMap2.put("isDiscovering", Boolean.FALSE);
                    c2241c.mo6107M(i, mo73394j("ok", hashMap2));
                    C42484c.m75254kT(102);
                    C16639c.m25604a(c2241c, true, false);
                    AppMethodBeat.m2505o(94213);
                    return;
                default:
                    hashMap2.put("isDiscovering", Boolean.FALSE);
                    c2241c.mo6107M(i, mo73394j("fail", hashMap2));
                    C42484c.m75254kT(103);
                    AppMethodBeat.m2505o(94213);
                    return;
            }
        } else {
            C4990ab.m7412e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(103, 108);
            AppMethodBeat.m2505o(94213);
        }
    }
}
