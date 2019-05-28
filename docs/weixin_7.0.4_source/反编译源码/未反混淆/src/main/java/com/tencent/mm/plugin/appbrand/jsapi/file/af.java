package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public final class af extends u {
    private static final int CTRL_INDEX = 396;
    private static final String NAME = "saveFileSync";

    public final String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(102809);
        a d = ae.d(cVar, jSONObject);
        String j = j(d.aIm, d.values);
        AppMethodBeat.o(102809);
        return j;
    }
}
