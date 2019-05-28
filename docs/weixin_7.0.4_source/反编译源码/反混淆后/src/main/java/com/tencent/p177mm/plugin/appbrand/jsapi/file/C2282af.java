package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m.C38338a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.af */
public final class C2282af extends C19497u {
    private static final int CTRL_INDEX = 396;
    private static final String NAME = "saveFileSync";

    /* renamed from: b */
    public final String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102809);
        C38338a d = C33307ae.m54482d(c2241c, jSONObject);
        String j = mo73394j(d.aIm, d.values);
        AppMethodBeat.m2505o(102809);
        return j;
    }
}
