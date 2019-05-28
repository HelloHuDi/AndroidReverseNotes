package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class an extends ay {
    an() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(102816);
        a a;
        try {
            jSONObject.put("append", true);
            a = super.a(cVar, str, jSONObject);
            AppMethodBeat.o(102816);
            return a;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", str, e);
            a = new a("fail " + j.ERR_OP_FAIL.name(), new Object[0]);
            AppMethodBeat.o(102816);
            return a;
        }
    }
}
