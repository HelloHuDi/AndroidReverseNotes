package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

public final class d extends a {
    public final /* synthetic */ Object d(JSONObject jSONObject, String str) {
        AppMethodBeat.i(10899);
        DrawCanvasArg c = c(jSONObject, str);
        AppMethodBeat.o(10899);
        return c;
    }

    public final DrawCanvasArg c(JSONObject jSONObject, String str) {
        AppMethodBeat.i(10898);
        DrawCanvasArg c = super.d(jSONObject, str);
        c.h(jSONObject.optJSONArray("actions"));
        AppMethodBeat.o(10898);
        return c;
    }

    public final int azV() {
        return 0;
    }
}
