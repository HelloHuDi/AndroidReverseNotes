package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class k extends c {
    public static final int CTRL_INDEX = 83;
    public static final String NAME = "updateCanvas";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(103857);
        int optInt = jSONObject.optInt("canvasId");
        AppMethodBeat.o(103857);
        return optInt;
    }

    public final boolean aCF() {
        return true;
    }
}
