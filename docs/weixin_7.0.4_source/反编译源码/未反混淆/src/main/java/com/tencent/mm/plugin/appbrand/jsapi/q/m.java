package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class m extends a {
    public static final int CTRL_INDEX = 231;
    public static final String NAME = "vibrateLong";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126434);
        ab.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
        Vibrator vibrator = (Vibrator) cVar.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(400);
        }
        cVar.M(i, j("ok", null));
        AppMethodBeat.o(126434);
    }
}
