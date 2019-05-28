package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class ab implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103271);
        SetLineWidthActionArg setLineWidthActionArg = new SetLineWidthActionArg();
        AppMethodBeat.o(103271);
        return setLineWidthActionArg;
    }

    public final String getMethod() {
        return "setLineWidth";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103272);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103272);
            return false;
        }
        boolean a = a(dVar, g.d(jSONArray, 0));
        AppMethodBeat.o(103272);
        return a;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103274);
        SetLineWidthActionArg setLineWidthActionArg = (SetLineWidthActionArg) drawActionArg;
        if (setLineWidthActionArg == null) {
            AppMethodBeat.o(103274);
            return false;
        }
        boolean a = a(dVar, setLineWidthActionArg.hdn);
        AppMethodBeat.o(103274);
        return a;
    }

    private static boolean a(d dVar, float f) {
        AppMethodBeat.i(103273);
        dVar.hcF.setStrokeWidth(f);
        dVar.hcE.setStrokeWidth(f);
        AppMethodBeat.o(103273);
        return true;
    }
}
