package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.at */
final class C42499at extends C38299d {
    C42499at() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102829);
        String format = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[]{str, jSONObject.optString("newPath")});
        String format2 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[]{str, r0});
        File Z = c2241c.asE().mo5832Z(str, true);
        C10396a c10396a;
        if (Z == null || !Z.exists()) {
            c10396a = new C10396a(format, new Object[0]);
            AppMethodBeat.m2505o(102829);
            return c10396a;
        } else if (C42367l.m74942F(Z)) {
            c10396a = new C10396a("fail \"%s\" not a regular file", str);
            AppMethodBeat.m2505o(102829);
            return c10396a;
        } else {
            C45518j a = c2241c.asE().mo5838a(r0, Z, true);
            switch (a) {
                case ERR_PERMISSION_DENIED:
                    c10396a = new C10396a(format2, new Object[0]);
                    AppMethodBeat.m2505o(102829);
                    return c10396a;
                case ERR_PARENT_DIR_NOT_EXISTS:
                    c10396a = new C10396a(format, new Object[0]);
                    AppMethodBeat.m2505o(102829);
                    return c10396a;
                case ERR_FS_NOT_MOUNTED:
                    c10396a = new C10396a("fail sdcard not mounted", new Object[0]);
                    AppMethodBeat.m2505o(102829);
                    return c10396a;
                case OK:
                    c10396a = new C10396a("ok", new Object[0]);
                    AppMethodBeat.m2505o(102829);
                    return c10396a;
                default:
                    c10396a = new C10396a("fail " + a.name(), new Object[0]);
                    AppMethodBeat.m2505o(102829);
                    return c10396a;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: y */
    public final String mo44689y(JSONObject jSONObject) {
        AppMethodBeat.m2504i(102830);
        String optString = jSONObject.optString("oldPath");
        AppMethodBeat.m2505o(102830);
        return optString;
    }
}
