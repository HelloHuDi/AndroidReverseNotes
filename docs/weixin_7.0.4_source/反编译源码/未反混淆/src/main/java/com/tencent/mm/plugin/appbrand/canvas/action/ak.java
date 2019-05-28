package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class ak implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103306);
        TranslateActionArg translateActionArg = new TranslateActionArg();
        AppMethodBeat.o(103306);
        return translateActionArg;
    }

    public final String getMethod() {
        return "translate";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103307);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(103307);
            return false;
        }
        canvas.translate(g.d(jSONArray, 0), g.d(jSONArray, 1));
        AppMethodBeat.o(103307);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103308);
        TranslateActionArg translateActionArg = (TranslateActionArg) drawActionArg;
        if (translateActionArg == null) {
            AppMethodBeat.o(103308);
            return false;
        }
        canvas.translate(translateActionArg.x, translateActionArg.y);
        AppMethodBeat.o(103308);
        return true;
    }
}
