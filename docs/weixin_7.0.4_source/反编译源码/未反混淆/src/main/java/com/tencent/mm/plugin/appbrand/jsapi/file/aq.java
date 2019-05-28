package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class aq extends d {
    aq() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(102823);
        j X = cVar.asE().X(str, jSONObject.optBoolean("recursive", false));
        a aVar;
        switch (X) {
            case ERR_PARENT_DIR_NOT_EXISTS:
                aVar = new a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(102823);
                return aVar;
            case ERR_PERMISSION_DENIED:
                aVar = new a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(102823);
                return aVar;
            case RET_ALREADY_EXISTS:
                aVar = new a("fail file already exists \"%s\"", str);
                AppMethodBeat.o(102823);
                return aVar;
            case OK:
                aVar = new a("ok", new Object[0]);
                AppMethodBeat.o(102823);
                return aVar;
            default:
                aVar = new a("fail " + X.name(), new Object[0]);
                AppMethodBeat.o(102823);
                return aVar;
        }
    }
}
