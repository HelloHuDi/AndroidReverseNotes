package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.FillRectActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class k implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103208);
        FillRectActionArg fillRectActionArg = new FillRectActionArg();
        AppMethodBeat.o(103208);
        return fillRectActionArg;
    }

    public final String getMethod() {
        return "fillRect";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103209);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(103209);
            return false;
        }
        boolean a = a(dVar, canvas, g.d(jSONArray, 0), g.d(jSONArray, 1), g.d(jSONArray, 2), g.d(jSONArray, 3));
        AppMethodBeat.o(103209);
        return a;
    }

    private static boolean a(d dVar, Canvas canvas, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(103210);
        canvas.drawRect(f, f2, f + f3, f2 + f4, dVar.hcF);
        AppMethodBeat.o(103210);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103211);
        FillRectActionArg fillRectActionArg = (FillRectActionArg) drawActionArg;
        if (fillRectActionArg == null) {
            AppMethodBeat.o(103211);
            return false;
        }
        boolean a = a(dVar, canvas, fillRectActionArg.x, fillRectActionArg.y, fillRectActionArg.width, fillRectActionArg.height);
        AppMethodBeat.o(103211);
        return a;
    }
}
