package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class i extends b<e> {
    public static final int CTRL_INDEX = 68;
    public static final String NAME = "removeCanvas";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(103856);
        int optInt = jSONObject.optInt("canvasId");
        AppMethodBeat.o(103856);
        return optInt;
    }
}
