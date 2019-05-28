package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class g extends b {
    public static final int CTRL_INDEX = 299;
    public static final String NAME = "removeHTMLWebView";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(131676);
        int i = jSONObject.getInt("htmlId");
        AppMethodBeat.o(131676);
        return i;
    }
}
