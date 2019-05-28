package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class h implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103196);
        DrawRectActionArg drawRectActionArg = new DrawRectActionArg();
        AppMethodBeat.o(103196);
        return drawRectActionArg;
    }

    public final String getMethod() {
        return "strokeRect";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103197);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(103197);
            return false;
        }
        boolean a = a(dVar, canvas, g.d(jSONArray, 0), g.d(jSONArray, 1), g.d(jSONArray, 2), g.d(jSONArray, 3));
        AppMethodBeat.o(103197);
        return a;
    }

    private static boolean a(d dVar, Canvas canvas, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(103198);
        canvas.drawRect(f, f2, f + f3, f2 + f4, dVar.hcE);
        AppMethodBeat.o(103198);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103199);
        DrawRectActionArg drawRectActionArg = (DrawRectActionArg) drawActionArg;
        if (drawRectActionArg == null) {
            AppMethodBeat.o(103199);
            return false;
        }
        boolean a = a(dVar, canvas, drawRectActionArg.x, drawRectActionArg.y, drawRectActionArg.width, drawRectActionArg.height);
        AppMethodBeat.o(103199);
        return a;
    }
}
