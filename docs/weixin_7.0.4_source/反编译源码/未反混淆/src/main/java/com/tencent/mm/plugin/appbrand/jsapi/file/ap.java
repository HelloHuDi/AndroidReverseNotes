package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class ap extends d {
    ap() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(102821);
        j ye = cVar.asE().ye(str);
        a o;
        switch (ye) {
            case RET_NOT_EXISTS:
                a aVar = new a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(102821);
                return aVar;
            case OK:
            case ERR_IS_FILE:
                a aVar2 = new a("ok", new Object[0]);
                String str2 = "result";
                if (ye != j.OK) {
                    z = false;
                }
                o = aVar2.o(str2, Boolean.valueOf(z));
                AppMethodBeat.o(102821);
                return o;
            default:
                o = new a("fail " + ye.name(), new Object[0]);
                AppMethodBeat.o(102821);
                return o;
        }
    }
}
