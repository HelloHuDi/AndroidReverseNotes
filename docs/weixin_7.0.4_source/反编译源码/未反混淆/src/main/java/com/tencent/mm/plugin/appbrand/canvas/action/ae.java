package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class ae implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103283);
        SetShadowActionArg setShadowActionArg = new SetShadowActionArg();
        AppMethodBeat.o(103283);
        return setShadowActionArg;
    }

    public final String getMethod() {
        return "setShadow";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103284);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(103284);
            return false;
        }
        float d = g.d(jSONArray, 0);
        float d2 = g.d(jSONArray, 1);
        float d3 = g.d(jSONArray, 2);
        JSONArray optJSONArray = jSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(103284);
            return false;
        }
        boolean a = a(dVar, d, d2, d3, g.n(optJSONArray));
        AppMethodBeat.o(103284);
        return a;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103286);
        SetShadowActionArg setShadowActionArg = (SetShadowActionArg) drawActionArg;
        if (setShadowActionArg == null) {
            AppMethodBeat.o(103286);
            return false;
        }
        boolean a = a(dVar, setShadowActionArg.x, setShadowActionArg.y, setShadowActionArg.hdo, setShadowActionArg.color);
        AppMethodBeat.o(103286);
        return a;
    }

    private static boolean a(d dVar, float f, float f2, float f3, int i) {
        AppMethodBeat.i(103285);
        dVar.hcF.setShadowLayer(f3, f, f2, i);
        dVar.hcE.setShadowLayer(f3, f, f2, i);
        AppMethodBeat.o(103285);
        return true;
    }
}
