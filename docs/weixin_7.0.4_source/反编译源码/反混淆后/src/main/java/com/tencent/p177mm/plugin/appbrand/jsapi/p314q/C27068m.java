package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.m */
public final class C27068m extends C10296a {
    public static final int CTRL_INDEX = 231;
    public static final String NAME = "vibrateLong";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126434);
        C4990ab.m7410d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
        Vibrator vibrator = (Vibrator) c2241c.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(400);
        }
        c2241c.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(126434);
    }
}
