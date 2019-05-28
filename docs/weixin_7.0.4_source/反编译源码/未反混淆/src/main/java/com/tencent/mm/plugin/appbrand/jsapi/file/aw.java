package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class aw extends d {
    aw() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(102838);
        j yf = cVar.asE().yf(str);
        a aVar;
        switch (yf) {
            case ERR_PERMISSION_DENIED:
                aVar = new a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(102838);
                return aVar;
            case RET_NOT_EXISTS:
                aVar = new a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(102838);
                return aVar;
            case ERR_IS_DIRECTORY:
                aVar = new a("fail operation not permitted, unlink \"%s\"", str);
                AppMethodBeat.o(102838);
                return aVar;
            case OK:
                aVar = new a("ok", new Object[0]);
                AppMethodBeat.o(102838);
                return aVar;
            default:
                aVar = new a("fail " + yf.name(), new Object[0]);
                AppMethodBeat.o(102838);
                return aVar;
        }
    }
}
