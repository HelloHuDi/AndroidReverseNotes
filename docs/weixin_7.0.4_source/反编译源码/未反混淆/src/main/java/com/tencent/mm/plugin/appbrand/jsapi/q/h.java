package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 535;
    public static final String NAME = "getVolume";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126417);
        ab.i("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
        if (cVar == null) {
            ab.e("MicroMsg.JsApiGetVolume", "component is null");
            AppMethodBeat.o(126417);
            return;
        }
        Context context = cVar.getContext();
        if (context == null) {
            ab.e("MicroMsg.JsApiGetVolume", "fail:context is null");
            cVar.M(i, j("fail:context is null", null));
            AppMethodBeat.o(126417);
        } else if (context instanceof Activity) {
            AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null) {
                ab.e("MicroMsg.JsApiGetVolume", "fail:manager is null");
                cVar.M(i, j("fail:manager is null", null));
                AppMethodBeat.o(126417);
                return;
            }
            ab.i("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", Integer.valueOf(audioManager.getStreamVolume(3)), Integer.valueOf(audioManager.getStreamMaxVolume(3)));
            HashMap hashMap = new HashMap();
            hashMap.put("currentVolume", Integer.valueOf(r1));
            hashMap.put("maxVolume", Integer.valueOf(r0));
            cVar.M(i, j("ok", hashMap));
            AppMethodBeat.o(126417);
        } else {
            ab.e("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
            cVar.M(i, j("fail:context is not Activity", null));
            AppMethodBeat.o(126417);
        }
    }
}
