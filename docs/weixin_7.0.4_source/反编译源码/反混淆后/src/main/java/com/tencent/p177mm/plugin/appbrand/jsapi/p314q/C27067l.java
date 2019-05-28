package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1397a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.l */
public final class C27067l extends C10296a {
    public static final int CTRL_INDEX = 534;
    public static final String NAME = "setVolume";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126433);
        C4990ab.m7416i("MicroMsg.JsApiSetVolume", "invoke JsApiSetVolume!");
        if (c2241c == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetVolume", "fail:component is null");
            AppMethodBeat.m2505o(126433);
            return;
        }
        Context context = c2241c.getContext();
        if (context == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetVolume", "fail:context is null");
            c2241c.mo6107M(i, mo73394j("fail:context is null", null));
            AppMethodBeat.m2505o(126433);
        } else if (context instanceof Activity) {
            AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null) {
                C4990ab.m7412e("MicroMsg.JsApiSetVolume", "fail:manager is null");
                c2241c.mo6107M(i, mo73394j("fail:manager is null", null));
                AppMethodBeat.m2505o(126433);
                return;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int optInt = jSONObject.optInt("value", streamVolume);
            C4990ab.m7417i("MicroMsg.JsApiSetVolume", "JsApiSetVolume value:%d, current:%d, max:%d", Integer.valueOf(optInt), Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
            if (optInt < 0) {
                streamMaxVolume = 0;
            } else if (optInt <= streamMaxVolume) {
                streamMaxVolume = optInt;
            }
            if (streamMaxVolume != streamVolume) {
                C1397a.m2944b(audioManager, 3, streamMaxVolume);
                c2241c.mo6107M(i, mo73394j("ok", null));
                AppMethodBeat.m2505o(126433);
                return;
            }
            c2241c.mo6107M(i, mo73394j("fail:volume does not change", null));
            AppMethodBeat.m2505o(126433);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiSetVolume", "fail:context is not Activity");
            c2241c.mo6107M(i, mo73394j("fail:context is not Activity", null));
            AppMethodBeat.m2505o(126433);
        }
    }
}
