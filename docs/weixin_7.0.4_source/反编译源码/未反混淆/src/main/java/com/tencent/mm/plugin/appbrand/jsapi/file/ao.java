package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ao extends d {
    ao() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        a aVar;
        j a;
        AppMethodBeat.i(102818);
        String optString = jSONObject.optString("destPath");
        String format = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        String format2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        File yg = cVar.asE().yg(str);
        if (yg == null || !yg.exists() || !yg.isFile()) {
            com.tencent.mm.plugin.appbrand.r.j jVar = new com.tencent.mm.plugin.appbrand.r.j();
            cVar.asE().b(str, jVar);
            if (jVar.value == null) {
                aVar = new a(format, new Object[0]);
                AppMethodBeat.o(102818);
                return aVar;
            }
            InputStream aVar2 = new com.tencent.luggage.g.a((ByteBuffer) jVar.value);
            a = cVar.asE().a(optString, aVar2, false);
            bo.b(aVar2);
        } else if (l.F(yg)) {
            aVar = new a("fail \"%s\" not a regular file", str);
            AppMethodBeat.o(102818);
            return aVar;
        } else {
            a = cVar.asE().a(optString, yg, false);
        }
        switch (a) {
            case ERR_PERMISSION_DENIED:
                aVar = new a(format2, new Object[0]);
                AppMethodBeat.o(102818);
                return aVar;
            case ERR_PARENT_DIR_NOT_EXISTS:
                aVar = new a(format, new Object[0]);
                AppMethodBeat.o(102818);
                return aVar;
            case ERR_FS_NOT_MOUNTED:
                aVar = new a("fail sdcard not mounted", new Object[0]);
                AppMethodBeat.o(102818);
                return aVar;
            case RET_ALREADY_EXISTS:
                aVar = new a("fail illegal operation on a directory, open \"%s\"", optString);
                AppMethodBeat.o(102818);
                return aVar;
            case ERR_SYMLINK:
                aVar = new a("fail \"%s\" is not a regular file", optString);
                AppMethodBeat.o(102818);
                return aVar;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                aVar = new a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                AppMethodBeat.o(102818);
                return aVar;
            case OK:
                aVar = new a("ok", new Object[0]);
                AppMethodBeat.o(102818);
                return aVar;
            default:
                a aVar3 = new a("fail " + a.name(), new Object[0]);
                AppMethodBeat.o(102818);
                return aVar3;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String y(JSONObject jSONObject) {
        AppMethodBeat.i(102819);
        String optString = jSONObject.optString("srcPath");
        AppMethodBeat.o(102819);
        return optString;
    }
}
