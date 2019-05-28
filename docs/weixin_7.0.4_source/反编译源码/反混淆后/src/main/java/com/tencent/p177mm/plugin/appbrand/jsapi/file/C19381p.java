package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.p */
public final class C19381p extends C10296a {
    private static final int CTRL_INDEX = 116;
    private static final String NAME = "getSavedFileInfo";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102788);
        String optString = jSONObject.optString("filePath", "");
        if (C5046bo.isNullOrNil(optString)) {
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(102788);
            return;
        }
        File yg = c2241c.asE().mo34314yg(optString);
        if (yg == null) {
            c2241c.mo6107M(i, mo73394j(String.format(Locale.US, "fail no such file \"%s\"", new Object[]{optString}), null));
            AppMethodBeat.m2505o(102788);
            return;
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("size", Long.valueOf(yg.length()));
        hashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(yg.lastModified())));
        c2241c.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(102788);
    }
}
