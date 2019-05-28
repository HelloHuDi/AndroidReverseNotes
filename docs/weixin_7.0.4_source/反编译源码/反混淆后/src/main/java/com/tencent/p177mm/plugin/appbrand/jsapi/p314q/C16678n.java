package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.n */
public final class C16678n extends C10296a {
    public static final int CTRL_INDEX = 230;
    public static final String NAME = "vibrateShort";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126435);
        C4990ab.m7410d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
        try {
            Vibrator vibrator = (Vibrator) c2241c.getContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(15);
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.JsApiVibrateShort", "vibrateShort exception %s", e.getMessage());
        }
        c2241c.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(126435);
    }
}
