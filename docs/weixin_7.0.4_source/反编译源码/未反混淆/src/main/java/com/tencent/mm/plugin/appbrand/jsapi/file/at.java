package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

final class at extends d {
    at() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(102829);
        String format = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[]{str, jSONObject.optString("newPath")});
        String format2 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[]{str, r0});
        File Z = cVar.asE().Z(str, true);
        a aVar;
        if (Z == null || !Z.exists()) {
            aVar = new a(format, new Object[0]);
            AppMethodBeat.o(102829);
            return aVar;
        } else if (l.F(Z)) {
            aVar = new a("fail \"%s\" not a regular file", str);
            AppMethodBeat.o(102829);
            return aVar;
        } else {
            j a = cVar.asE().a(r0, Z, true);
            switch (a) {
                case ERR_PERMISSION_DENIED:
                    aVar = new a(format2, new Object[0]);
                    AppMethodBeat.o(102829);
                    return aVar;
                case ERR_PARENT_DIR_NOT_EXISTS:
                    aVar = new a(format, new Object[0]);
                    AppMethodBeat.o(102829);
                    return aVar;
                case ERR_FS_NOT_MOUNTED:
                    aVar = new a("fail sdcard not mounted", new Object[0]);
                    AppMethodBeat.o(102829);
                    return aVar;
                case OK:
                    aVar = new a("ok", new Object[0]);
                    AppMethodBeat.o(102829);
                    return aVar;
                default:
                    aVar = new a("fail " + a.name(), new Object[0]);
                    AppMethodBeat.o(102829);
                    return aVar;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String y(JSONObject jSONObject) {
        AppMethodBeat.i(102830);
        String optString = jSONObject.optString("oldPath");
        AppMethodBeat.o(102830);
        return optString;
    }
}
