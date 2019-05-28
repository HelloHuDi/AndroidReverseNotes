package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class l extends a {
    public static final int CTRL_INDEX = 534;
    public static final String NAME = "setVolume";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126433);
        ab.i("MicroMsg.JsApiSetVolume", "invoke JsApiSetVolume!");
        if (cVar == null) {
            ab.e("MicroMsg.JsApiSetVolume", "fail:component is null");
            AppMethodBeat.o(126433);
            return;
        }
        Context context = cVar.getContext();
        if (context == null) {
            ab.e("MicroMsg.JsApiSetVolume", "fail:context is null");
            cVar.M(i, j("fail:context is null", null));
            AppMethodBeat.o(126433);
        } else if (context instanceof Activity) {
            AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null) {
                ab.e("MicroMsg.JsApiSetVolume", "fail:manager is null");
                cVar.M(i, j("fail:manager is null", null));
                AppMethodBeat.o(126433);
                return;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int optInt = jSONObject.optInt("value", streamVolume);
            ab.i("MicroMsg.JsApiSetVolume", "JsApiSetVolume value:%d, current:%d, max:%d", Integer.valueOf(optInt), Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
            if (optInt < 0) {
                streamMaxVolume = 0;
            } else if (optInt <= streamMaxVolume) {
                streamMaxVolume = optInt;
            }
            if (streamMaxVolume != streamVolume) {
                com.tencent.mm.compatible.b.a.b(audioManager, 3, streamMaxVolume);
                cVar.M(i, j("ok", null));
                AppMethodBeat.o(126433);
                return;
            }
            cVar.M(i, j("fail:volume does not change", null));
            AppMethodBeat.o(126433);
        } else {
            ab.e("MicroMsg.JsApiSetVolume", "fail:context is not Activity");
            cVar.M(i, j("fail:context is not Activity", null));
            AppMethodBeat.o(126433);
        }
    }
}
