package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m.C38338a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.ae */
public final class C33307ae extends C10296a {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(102806);
        C38298b.hJE.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102804);
                if (c2241c.isRunning()) {
                    C38338a d = C33307ae.m54482d(c2241c, jSONObject);
                    c2241c.mo6107M(i, C33307ae.this.mo73394j(d.aIm, d.values));
                    AppMethodBeat.m2505o(102804);
                    return;
                }
                AppMethodBeat.m2505o(102804);
            }
        });
        AppMethodBeat.m2505o(102806);
    }

    /* renamed from: d */
    static C38338a m54482d(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102807);
        String optString = jSONObject.optString("tempFilePath");
        String optString2 = jSONObject.optString("filePath");
        C38338a c38338a;
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            c38338a = new C38338a("fail", new Object[0]);
            AppMethodBeat.m2505o(102807);
            return c38338a;
        }
        File yg = c2241c.asE().mo34314yg(optString);
        if (yg == null || !yg.exists()) {
            c38338a = new C38338a("fail tempFilePath file not exist", new Object[0]);
            AppMethodBeat.m2505o(102807);
            return c38338a;
        }
        C19681j c19681j = new C19681j();
        optString = C33307ae.m54481a(c2241c, yg, optString2, c19681j);
        HashMap hashMap = new HashMap();
        if ("ok".equals(optString)) {
            hashMap.put("savedFilePath", c19681j.value);
        }
        c38338a = new C38338a(optString, new Object[0]).mo21868v(hashMap);
        AppMethodBeat.m2505o(102807);
        return c38338a;
    }

    /* renamed from: a */
    public static String m54481a(C2241c c2241c, File file, String str, C19681j<String> c19681j) {
        AppMethodBeat.m2504i(102808);
        String str2;
        if (file == null || !file.exists()) {
            str2 = "fail:file not exists";
            AppMethodBeat.m2505o(102808);
            return str2;
        }
        C45518j ye = c2241c.asE().mo5850ye(str);
        if (ye != C45518j.OK) {
            try {
                C19681j c19681j2 = new C19681j();
                ye = c2241c.asE().mo5834a(file, str, c19681j2);
                if (c19681j != null) {
                    c19681j.value = c19681j2.value;
                }
            } catch (Exception e) {
                str2 = "fail:writeFile exception: " + e.toString();
                AppMethodBeat.m2505o(102808);
                return str2;
            }
        }
        switch (ye) {
            case ERR_PERMISSION_DENIED:
                str2 = String.format("fail permission denied, open \"%s\"", new Object[]{str});
                AppMethodBeat.m2505o(102808);
                return str2;
            case ERR_PARENT_DIR_NOT_EXISTS:
                str2 = String.format("fail no such file or directory \"%s\"", new Object[]{str});
                AppMethodBeat.m2505o(102808);
                return str2;
            case ERR_IS_DIRECTORY:
                str2 = String.format("fail illegal operation on a directory, open \"%s\"", new Object[]{str});
                AppMethodBeat.m2505o(102808);
                return str2;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                str2 = "fail the maximum size of the file storage limit is exceeded";
                AppMethodBeat.m2505o(102808);
                return str2;
            case OK:
                str2 = "ok";
                AppMethodBeat.m2505o(102808);
                return str2;
            default:
                str2 = "fail " + ye.name();
                AppMethodBeat.m2505o(102808);
                return str2;
        }
    }
}
