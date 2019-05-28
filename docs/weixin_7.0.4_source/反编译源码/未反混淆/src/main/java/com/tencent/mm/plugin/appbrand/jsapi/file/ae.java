package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public final class ae extends a {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    public final void a(final c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(102806);
        b.hJE.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102804);
                if (cVar.isRunning()) {
                    m.a d = ae.d(cVar, jSONObject);
                    cVar.M(i, ae.this.j(d.aIm, d.values));
                    AppMethodBeat.o(102804);
                    return;
                }
                AppMethodBeat.o(102804);
            }
        });
        AppMethodBeat.o(102806);
    }

    static m.a d(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(102807);
        String optString = jSONObject.optString("tempFilePath");
        String optString2 = jSONObject.optString("filePath");
        m.a aVar;
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            aVar = new m.a("fail", new Object[0]);
            AppMethodBeat.o(102807);
            return aVar;
        }
        File yg = cVar.asE().yg(optString);
        if (yg == null || !yg.exists()) {
            aVar = new m.a("fail tempFilePath file not exist", new Object[0]);
            AppMethodBeat.o(102807);
            return aVar;
        }
        j jVar = new j();
        optString = a(cVar, yg, optString2, jVar);
        HashMap hashMap = new HashMap();
        if ("ok".equals(optString)) {
            hashMap.put("savedFilePath", jVar.value);
        }
        aVar = new m.a(optString, new Object[0]).v(hashMap);
        AppMethodBeat.o(102807);
        return aVar;
    }

    public static String a(c cVar, File file, String str, j<String> jVar) {
        AppMethodBeat.i(102808);
        String str2;
        if (file == null || !file.exists()) {
            str2 = "fail:file not exists";
            AppMethodBeat.o(102808);
            return str2;
        }
        com.tencent.mm.plugin.appbrand.appstorage.j ye = cVar.asE().ye(str);
        if (ye != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
            try {
                j jVar2 = new j();
                ye = cVar.asE().a(file, str, jVar2);
                if (jVar != null) {
                    jVar.value = jVar2.value;
                }
            } catch (Exception e) {
                str2 = "fail:writeFile exception: " + e.toString();
                AppMethodBeat.o(102808);
                return str2;
            }
        }
        switch (ye) {
            case ERR_PERMISSION_DENIED:
                str2 = String.format("fail permission denied, open \"%s\"", new Object[]{str});
                AppMethodBeat.o(102808);
                return str2;
            case ERR_PARENT_DIR_NOT_EXISTS:
                str2 = String.format("fail no such file or directory \"%s\"", new Object[]{str});
                AppMethodBeat.o(102808);
                return str2;
            case ERR_IS_DIRECTORY:
                str2 = String.format("fail illegal operation on a directory, open \"%s\"", new Object[]{str});
                AppMethodBeat.o(102808);
                return str2;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                str2 = "fail the maximum size of the file storage limit is exceeded";
                AppMethodBeat.o(102808);
                return str2;
            case OK:
                str2 = "ok";
                AppMethodBeat.o(102808);
                return str2;
            default:
                str2 = "fail " + ye.name();
                AppMethodBeat.o(102808);
                return str2;
        }
    }
}
