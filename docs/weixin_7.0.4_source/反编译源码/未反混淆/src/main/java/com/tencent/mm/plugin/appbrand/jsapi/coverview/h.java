package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class h extends b {
    private static final int CTRL_INDEX = 255;
    public static final String NAME = "removeTextView";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126312);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.o(126312);
        return i;
    }

    public final boolean b(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126313);
        eVar.aBf().pA(i);
        boolean b = super.b(eVar, i, view, jSONObject);
        AppMethodBeat.o(126313);
        return b;
    }
}
