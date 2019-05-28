package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.aw */
final class C19373aw extends C38299d {
    C19373aw() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102838);
        C45518j yf = c2241c.asE().mo5851yf(str);
        C10396a c10396a;
        switch (yf) {
            case ERR_PERMISSION_DENIED:
                c10396a = new C10396a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.m2505o(102838);
                return c10396a;
            case RET_NOT_EXISTS:
                c10396a = new C10396a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.m2505o(102838);
                return c10396a;
            case ERR_IS_DIRECTORY:
                c10396a = new C10396a("fail operation not permitted, unlink \"%s\"", str);
                AppMethodBeat.m2505o(102838);
                return c10396a;
            case OK:
                c10396a = new C10396a("ok", new Object[0]);
                AppMethodBeat.m2505o(102838);
                return c10396a;
            default:
                c10396a = new C10396a("fail " + yf.name(), new Object[0]);
                AppMethodBeat.m2505o(102838);
                return c10396a;
        }
    }
}
