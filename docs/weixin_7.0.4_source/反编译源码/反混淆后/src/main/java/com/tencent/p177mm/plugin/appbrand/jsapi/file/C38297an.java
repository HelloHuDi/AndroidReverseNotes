package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.an */
final class C38297an extends C19375ay {
    C38297an() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102816);
        C10396a a;
        try {
            jSONObject.put("append", true);
            a = super.mo21863a(c2241c, str, jSONObject);
            AppMethodBeat.m2505o(102816);
            return a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", str, e);
            a = new C10396a("fail " + C45518j.ERR_OP_FAIL.name(), new Object[0]);
            AppMethodBeat.m2505o(102816);
            return a;
        }
    }
}
