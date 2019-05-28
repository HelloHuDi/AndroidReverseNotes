package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C45588b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.C31128d;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.i */
public final class C45583i extends C10296a {
    private static final int CTRL_INDEX = 175;
    private static final String NAME = "getBluetoothAdapterState";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        boolean z = false;
        AppMethodBeat.m2504i(94188);
        C42484c.m75254kT(126);
        C4990ab.m7417i("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", c2241c.getAppId());
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(128, 130);
            AppMethodBeat.m2505o(94188);
            return;
        }
        boolean aCZ = C38283b.aCZ();
        if (AT.hDu != null) {
            C45588b c45588b = AT.hDu;
            if (c45588b.hDZ != null) {
                z = c45588b.hDZ.hFh.get();
            }
        }
        C4990ab.m7416i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + aCZ + ",discoveringState : " + z);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("available", Boolean.valueOf(aCZ));
        hashMap2.put("discovering", Boolean.valueOf(z));
        c2241c.mo6107M(i, mo73394j("ok", hashMap2));
        C42484c.m75254kT(C31128d.MIC_SketchMark);
        AppMethodBeat.m2505o(94188);
    }
}
