package com.tencent.mm.plugin.appbrand.jsapi.container;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.base.b {
    public static final int CTRL_INDEX = 512;
    public static final String NAME = "removePositioningContainer";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126280);
        int i = jSONObject.getInt("containerId");
        AppMethodBeat.o(126280);
        return i;
    }
}
