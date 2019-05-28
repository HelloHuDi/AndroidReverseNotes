package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class p extends a {
    private static final int CTRL_INDEX = 116;
    private static final String NAME = "getSavedFileInfo";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102788);
        String optString = jSONObject.optString("filePath", "");
        if (bo.isNullOrNil(optString)) {
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(102788);
            return;
        }
        File yg = cVar.asE().yg(optString);
        if (yg == null) {
            cVar.M(i, j(String.format(Locale.US, "fail no such file \"%s\"", new Object[]{optString}), null));
            AppMethodBeat.o(102788);
            return;
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("size", Long.valueOf(yg.length()));
        hashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(yg.lastModified())));
        cVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(102788);
    }
}
