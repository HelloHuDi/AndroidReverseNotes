package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

public final class c extends a {
    public final /* synthetic */ Object d(JSONObject jSONObject, String str) {
        AppMethodBeat.i(10897);
        DrawCanvasArg c = c(jSONObject, str);
        AppMethodBeat.o(10897);
        return c;
    }

    public final DrawCanvasArg c(JSONObject jSONObject, String str) {
        AppMethodBeat.i(10896);
        DrawCanvasArg c = super.d(jSONObject, str);
        c.hdX = true;
        AppMethodBeat.o(10896);
        return c;
    }

    public final int azV() {
        return 2;
    }
}
