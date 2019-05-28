package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.ClearRectActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class a implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103172);
        ClearRectActionArg clearRectActionArg = new ClearRectActionArg();
        AppMethodBeat.o(103172);
        return clearRectActionArg;
    }

    public final String getMethod() {
        return "clearRect";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103173);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(103173);
            return false;
        }
        boolean a = a(dVar, canvas, g.d(jSONArray, 0), g.d(jSONArray, 1), g.d(jSONArray, 2), g.d(jSONArray, 3));
        AppMethodBeat.o(103173);
        return a;
    }

    private static boolean a(d dVar, Canvas canvas, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(103174);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof f) {
                ((f) canvas).g(f, f2, f + f3, f2 + f4);
                com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                AppMethodBeat.o(103174);
                return true;
            } else if (dVar.hcJ != null) {
                canvas.drawRect(f, f2, f + f3, f2 + f4, dVar.hcJ);
                com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                AppMethodBeat.o(103174);
                return true;
            } else {
                com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                AppMethodBeat.o(103174);
                return false;
            }
        } else if (dVar.hcJ != null) {
            canvas.drawRect(f, f2, f + f3, f2 + f4, dVar.hcJ);
            com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
            AppMethodBeat.o(103174);
            return true;
        } else {
            canvas.drawRect(f, f2, f + f3, f2 + f4, dVar.hcI);
            com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
            AppMethodBeat.o(103174);
            return false;
        }
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103175);
        if (drawActionArg == null || !(drawActionArg instanceof ClearRectActionArg)) {
            AppMethodBeat.o(103175);
            return false;
        }
        ClearRectActionArg clearRectActionArg = (ClearRectActionArg) drawActionArg;
        boolean a = a(dVar, canvas, clearRectActionArg.x, clearRectActionArg.y, clearRectActionArg.width, clearRectActionArg.height);
        AppMethodBeat.o(103175);
        return a;
    }
}
