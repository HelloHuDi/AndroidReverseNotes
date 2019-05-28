package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C26974e.C10390a;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.ay */
class C19375ay extends C38299d {
    C19375ay() {
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        C10396a c10396a;
        InputStream c37399a;
        AppMethodBeat.m2504i(102843);
        boolean optBoolean = jSONObject.optBoolean("append", false);
        String optString = jSONObject.optString("encoding");
        C27295q.m43334a(c2241c.aBx(), jSONObject, (C27296a) c2241c.mo5937aa(C27296a.class));
        Object opt = jSONObject.opt("data");
        if (opt instanceof String) {
            C26974e c26974e;
            if (C5046bo.isNullOrNil(optString)) {
                c26974e = (C26974e) C10390a.hJH.get("utf8");
            } else {
                C26974e c26974e2 = (C26974e) C10390a.hJH.get(optString.toLowerCase());
                if (c26974e2 == null) {
                    c10396a = new C10396a("fail invalid encoding", new Object[0]);
                    AppMethodBeat.m2505o(102843);
                    return c10396a;
                }
                c26974e = c26974e2;
            }
            try {
                c37399a = new C37399a(c26974e.mo21864AY((String) opt));
            } catch (Exception e) {
                c10396a = new C10396a("fail " + e.getMessage(), new Object[0]);
                AppMethodBeat.m2505o(102843);
                return c10396a;
            }
        } else if (opt instanceof ByteBuffer) {
            c37399a = new C37399a((ByteBuffer) opt);
        } else if (opt != null) {
            c10396a = new C10396a("fail invalid data", new Object[0]);
            AppMethodBeat.m2505o(102843);
            return c10396a;
        } else if (optBoolean) {
            c10396a = new C10396a("ok", new Object[0]);
            AppMethodBeat.m2505o(102843);
            return c10396a;
        } else {
            c37399a = new ByteArrayInputStream(new byte[0]);
        }
        C45518j a = c2241c.asE().mo5839a(str, c37399a, optBoolean);
        switch (a) {
            case ERR_PARENT_DIR_NOT_EXISTS:
                c10396a = new C10396a("fail no such file or directory, open \"%s\"", str);
                AppMethodBeat.m2505o(102843);
                return c10396a;
            case RET_NOT_EXISTS:
                c10396a = new C10396a("fail no such file \"%s\"", str);
                AppMethodBeat.m2505o(102843);
                return c10396a;
            case RET_ALREADY_EXISTS:
                c10396a = new C10396a("fail illegal operation on a directory, open \"%s\"", str);
                AppMethodBeat.m2505o(102843);
                return c10396a;
            case ERR_PERMISSION_DENIED:
                c10396a = new C10396a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.m2505o(102843);
                return c10396a;
            case ERR_SYMLINK:
                c10396a = new C10396a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.m2505o(102843);
                return c10396a;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                c10396a = new C10396a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                AppMethodBeat.m2505o(102843);
                return c10396a;
            case OK:
                c10396a = new C10396a("ok", new Object[0]);
                AppMethodBeat.m2505o(102843);
                return c10396a;
            default:
                c10396a = new C10396a("fail " + a.name(), new Object[0]);
                AppMethodBeat.m2505o(102843);
                return c10396a;
        }
    }
}
