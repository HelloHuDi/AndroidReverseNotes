package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ab */
public final class C19281ab extends JsApiUploadWeRunData {
    public static final int CTRL_INDEX = 324;
    public static final String NAME = "addWeRunData";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130391);
        C4990ab.m7410d("MicroMsg.JsApiAddWeRunData", "JsApiAddWeRunData!");
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiAddWeRunData", "data is null");
            AppMethodBeat.m2505o(130391);
            return;
        }
        mo60986a(this, c2241c, i, jSONObject.optInt("step"), true);
        AppMethodBeat.m2505o(130391);
    }
}
