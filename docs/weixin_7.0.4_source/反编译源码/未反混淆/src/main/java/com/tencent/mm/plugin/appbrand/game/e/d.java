package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.b;
import com.tencent.mm.plugin.appbrand.game.page.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.page.w;
import org.json.JSONObject;

public final class d extends u<b> {
    public static final int CTRL_INDEX = 401;
    public static final String NAME = "canvasToTempFilePathSync";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(130196);
        w aun = ((b) cVar).aun();
        String j;
        if (aun instanceof f) {
            a a = c.a((f) aun, jSONObject, true);
            j = j(a.aIm, a.values);
            AppMethodBeat.o(130196);
            return j;
        }
        j = j("fail", null);
        AppMethodBeat.o(130196);
        return j;
    }
}
