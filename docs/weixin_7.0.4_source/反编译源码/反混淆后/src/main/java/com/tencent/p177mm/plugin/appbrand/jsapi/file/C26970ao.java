package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.ao */
final class C26970ao extends C38299d {
    C26970ao() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        C10396a c10396a;
        C45518j a;
        AppMethodBeat.m2504i(102818);
        String optString = jSONObject.optString("destPath");
        String format = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        String format2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        File yg = c2241c.asE().mo34314yg(str);
        if (yg == null || !yg.exists() || !yg.isFile()) {
            C19681j c19681j = new C19681j();
            c2241c.asE().mo5843b(str, c19681j);
            if (c19681j.value == null) {
                c10396a = new C10396a(format, new Object[0]);
                AppMethodBeat.m2505o(102818);
                return c10396a;
            }
            InputStream c37399a = new C37399a((ByteBuffer) c19681j.value);
            a = c2241c.asE().mo5839a(optString, c37399a, false);
            C5046bo.m7527b(c37399a);
        } else if (C42367l.m74942F(yg)) {
            c10396a = new C10396a("fail \"%s\" not a regular file", str);
            AppMethodBeat.m2505o(102818);
            return c10396a;
        } else {
            a = c2241c.asE().mo5838a(optString, yg, false);
        }
        switch (a) {
            case ERR_PERMISSION_DENIED:
                c10396a = new C10396a(format2, new Object[0]);
                AppMethodBeat.m2505o(102818);
                return c10396a;
            case ERR_PARENT_DIR_NOT_EXISTS:
                c10396a = new C10396a(format, new Object[0]);
                AppMethodBeat.m2505o(102818);
                return c10396a;
            case ERR_FS_NOT_MOUNTED:
                c10396a = new C10396a("fail sdcard not mounted", new Object[0]);
                AppMethodBeat.m2505o(102818);
                return c10396a;
            case RET_ALREADY_EXISTS:
                c10396a = new C10396a("fail illegal operation on a directory, open \"%s\"", optString);
                AppMethodBeat.m2505o(102818);
                return c10396a;
            case ERR_SYMLINK:
                c10396a = new C10396a("fail \"%s\" is not a regular file", optString);
                AppMethodBeat.m2505o(102818);
                return c10396a;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                c10396a = new C10396a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                AppMethodBeat.m2505o(102818);
                return c10396a;
            case OK:
                c10396a = new C10396a("ok", new Object[0]);
                AppMethodBeat.m2505o(102818);
                return c10396a;
            default:
                C10396a c10396a2 = new C10396a("fail " + a.name(), new Object[0]);
                AppMethodBeat.m2505o(102818);
                return c10396a2;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: y */
    public final String mo44689y(JSONObject jSONObject) {
        AppMethodBeat.m2504i(102819);
        String optString = jSONObject.optString("srcPath");
        AppMethodBeat.m2505o(102819);
        return optString;
    }
}
