package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class au extends d {
    au() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(102832);
        j Y = cVar.asE().Y(str, jSONObject.optBoolean("recursive", false));
        a aVar;
        switch (Y) {
            case ERR_PARENT_DIR_NOT_EXISTS:
            case RET_NOT_EXISTS:
                aVar = new a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(102832);
                return aVar;
            case ERR_DIR_NOT_EMPTY:
                aVar = new a("fail directory not empty", new Object[0]);
                AppMethodBeat.o(102832);
                return aVar;
            case ERR_PERMISSION_DENIED:
                aVar = new a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(102832);
                return aVar;
            case OK:
                aVar = new a("ok", new Object[0]);
                AppMethodBeat.o(102832);
                return aVar;
            default:
                aVar = new a("fail " + Y.name(), new Object[0]);
                AppMethodBeat.o(102832);
                return aVar;
        }
    }
}
