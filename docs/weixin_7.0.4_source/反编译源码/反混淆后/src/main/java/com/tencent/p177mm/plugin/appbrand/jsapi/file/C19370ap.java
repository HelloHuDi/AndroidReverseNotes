package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.ap */
final class C19370ap extends C38299d {
    C19370ap() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.m2504i(102821);
        C45518j ye = c2241c.asE().mo5850ye(str);
        C10396a o;
        switch (ye) {
            case RET_NOT_EXISTS:
                C10396a c10396a = new C10396a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.m2505o(102821);
                return c10396a;
            case OK:
            case ERR_IS_FILE:
                C10396a c10396a2 = new C10396a("ok", new Object[0]);
                String str2 = "result";
                if (ye != C45518j.OK) {
                    z = false;
                }
                o = c10396a2.mo21867o(str2, Boolean.valueOf(z));
                AppMethodBeat.m2505o(102821);
                return o;
            default:
                o = new C10396a("fail " + ye.name(), new Object[0]);
                AppMethodBeat.m2505o(102821);
                return o;
        }
    }
}
