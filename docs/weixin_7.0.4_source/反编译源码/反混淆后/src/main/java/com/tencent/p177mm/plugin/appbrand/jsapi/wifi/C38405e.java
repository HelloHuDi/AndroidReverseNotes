package com.tencent.p177mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.e */
public final class C38405e extends C10296a {
    public static final int CTRL_INDEX = 315;
    public static final String NAME = "stopWifi";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94378);
        C4990ab.m7416i("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
        Context context = c2241c.getContext();
        HashMap hashMap;
        if (context == null) {
            C4990ab.m7412e("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            c2241c.mo6107M(i, mo73394j("fail:context is null", hashMap));
            AppMethodBeat.m2505o(94378);
        } else if (C16683d.ide) {
            if (C16683d.idf != null) {
                C4990ab.m7416i("MicroMsg.JsApiStopWifi", "unregisterReceiver");
                context.unregisterReceiver(C16683d.idf);
                C16683d.ide = false;
                C16683d.idf = null;
            }
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            c2241c.mo6107M(i, mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(94378);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiStopWifi", "not invoke startWifi");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12000));
            c2241c.mo6107M(i, mo73394j("fail:not invoke startWifi", hashMap));
            AppMethodBeat.m2505o(94378);
        }
    }
}
