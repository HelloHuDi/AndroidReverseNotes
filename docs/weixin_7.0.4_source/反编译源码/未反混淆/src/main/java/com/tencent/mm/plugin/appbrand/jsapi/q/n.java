package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class n extends a {
    public static final int CTRL_INDEX = 230;
    public static final String NAME = "vibrateShort";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126435);
        ab.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
        try {
            Vibrator vibrator = (Vibrator) cVar.getContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(15);
            }
        } catch (Exception e) {
            ab.w("MicroMsg.JsApiVibrateShort", "vibrateShort exception %s", e.getMessage());
        }
        cVar.M(i, j("ok", null));
        AppMethodBeat.o(126435);
    }
}
