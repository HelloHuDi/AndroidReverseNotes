package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C26974e.C10390a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.as */
final class C42497as extends C38299d {
    C42497as() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        C26974e c26974e;
        C10396a c10396a;
        AppMethodBeat.m2504i(102827);
        String optString = jSONObject.optString("encoding");
        C4990ab.m7417i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", str, optString);
        if (C5046bo.isNullOrNil(optString)) {
            c26974e = null;
        } else {
            C26974e c26974e2 = (C26974e) C10390a.hJH.get(optString.toLowerCase());
            if (c26974e2 == null) {
                c10396a = new C10396a("fail invalid encoding", new Object[0]);
                AppMethodBeat.m2505o(102827);
                return c10396a;
            }
            c26974e = c26974e2;
        }
        C19681j c19681j = new C19681j();
        C45518j b = c2241c.asE().mo5843b(str, c19681j);
        if (b == C45518j.OK) {
            Object obj;
            if (c26974e == null) {
                obj = (Comparable) c19681j.value;
            } else {
                String obj2 = c26974e.mo21865o((ByteBuffer) c19681j.value);
            }
            if (!(obj2 instanceof ByteBuffer)) {
                C37399a.m63003j((ByteBuffer) c19681j.value);
            }
            c10396a = new C10396a("ok", new Object[0]).mo21867o("data", obj2);
            AppMethodBeat.m2505o(102827);
            return c10396a;
        }
        switch (b) {
            case RET_NOT_EXISTS:
                c10396a = new C10396a("fail no such file \"%s\"", str);
                AppMethodBeat.m2505o(102827);
                return c10396a;
            case ERR_PERMISSION_DENIED:
                c10396a = new C10396a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.m2505o(102827);
                return c10396a;
            case ERR_SYMLINK:
                c10396a = new C10396a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.m2505o(102827);
                return c10396a;
            default:
                c10396a = new C10396a("fail " + b.name(), new Object[0]);
                AppMethodBeat.m2505o(102827);
                return c10396a;
        }
    }
}
