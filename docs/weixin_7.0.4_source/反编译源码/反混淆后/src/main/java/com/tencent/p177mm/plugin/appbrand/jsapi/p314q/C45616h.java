package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.h */
public final class C45616h extends C10296a {
    public static final int CTRL_INDEX = 535;
    public static final String NAME = "getVolume";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126417);
        C4990ab.m7416i("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
        if (c2241c == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetVolume", "component is null");
            AppMethodBeat.m2505o(126417);
            return;
        }
        Context context = c2241c.getContext();
        if (context == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetVolume", "fail:context is null");
            c2241c.mo6107M(i, mo73394j("fail:context is null", null));
            AppMethodBeat.m2505o(126417);
        } else if (context instanceof Activity) {
            AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null) {
                C4990ab.m7412e("MicroMsg.JsApiGetVolume", "fail:manager is null");
                c2241c.mo6107M(i, mo73394j("fail:manager is null", null));
                AppMethodBeat.m2505o(126417);
                return;
            }
            C4990ab.m7417i("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", Integer.valueOf(audioManager.getStreamVolume(3)), Integer.valueOf(audioManager.getStreamMaxVolume(3)));
            HashMap hashMap = new HashMap();
            hashMap.put("currentVolume", Integer.valueOf(r1));
            hashMap.put("maxVolume", Integer.valueOf(r0));
            c2241c.mo6107M(i, mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(126417);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
            c2241c.mo6107M(i, mo73394j("fail:context is not Activity", null));
            AppMethodBeat.m2505o(126417);
        }
    }
}
