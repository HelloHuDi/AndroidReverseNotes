package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.am */
final class C45598am extends C38299d {
    C45598am() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        String str2;
        AppMethodBeat.m2504i(102815);
        if (c2241c.asE().mo5849yd(str) == C45518j.OK) {
            str2 = "ok";
        } else {
            str2 = String.format("fail no such file or directory \"%s\"", new Object[]{str});
        }
        C10396a c10396a = new C10396a(str2, new Object[0]);
        AppMethodBeat.m2505o(102815);
        return c10396a;
    }
}
