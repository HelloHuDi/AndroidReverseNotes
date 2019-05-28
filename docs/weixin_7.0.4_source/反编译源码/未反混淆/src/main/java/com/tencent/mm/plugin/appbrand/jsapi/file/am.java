package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class am extends d {
    am() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        String str2;
        AppMethodBeat.i(102815);
        if (cVar.asE().yd(str) == j.OK) {
            str2 = "ok";
        } else {
            str2 = String.format("fail no such file or directory \"%s\"", new Object[]{str});
        }
        a aVar = new a(str2, new Object[0]);
        AppMethodBeat.o(102815);
        return aVar;
    }
}
