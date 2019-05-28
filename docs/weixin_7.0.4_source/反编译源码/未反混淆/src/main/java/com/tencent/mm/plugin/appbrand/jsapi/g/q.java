package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class q extends b {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(93867);
        int B = f.B(jSONObject);
        AppMethodBeat.o(93867);
        return B;
    }

    public final boolean b(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(93868);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiRemoveMap", "data is null");
            AppMethodBeat.o(93868);
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(6);
        if (g.ck(eVar.getAppId(), f.g(eVar, jSONObject))) {
            com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(7);
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(8);
        }
        AppMethodBeat.o(93868);
        return true;
    }
}
