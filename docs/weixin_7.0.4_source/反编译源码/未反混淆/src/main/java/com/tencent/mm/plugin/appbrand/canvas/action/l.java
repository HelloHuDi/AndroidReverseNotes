package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class l implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103212);
        DrawTextActionArg drawTextActionArg = new DrawTextActionArg();
        AppMethodBeat.o(103212);
        return drawTextActionArg;
    }

    public final String getMethod() {
        return "fillText";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103213);
        if (jSONArray.length() < 3) {
            AppMethodBeat.o(103213);
            return false;
        }
        boolean a = a(dVar, canvas, jSONArray.optString(0), g.d(jSONArray, 1), g.d(jSONArray, 2), g.d(jSONArray, 3));
        AppMethodBeat.o(103213);
        return a;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103215);
        DrawTextActionArg drawTextActionArg = (DrawTextActionArg) drawActionArg;
        if (drawTextActionArg == null) {
            AppMethodBeat.o(103215);
            return false;
        }
        boolean a = a(dVar, canvas, drawTextActionArg.text, drawTextActionArg.x, drawTextActionArg.y, drawTextActionArg.hcW);
        AppMethodBeat.o(103215);
        return a;
    }

    private static boolean a(d dVar, Canvas canvas, String str, float f, float f2, float f3) {
        AppMethodBeat.i(103214);
        FontMetrics fontMetrics = dVar.hcE.getFontMetrics();
        if (dVar.hcE.hdH == a.TOP) {
            f2 += Math.abs(fontMetrics.ascent);
        } else if (dVar.hcE.hdH == a.MIDDLE) {
            f2 += Math.abs((((-fontMetrics.ascent) + fontMetrics.descent) / 2.0f) - fontMetrics.descent);
        } else if (dVar.hcE.hdH == a.BOTTOM) {
            f2 -= Math.abs(fontMetrics.descent);
        }
        com.tencent.mm.plugin.appbrand.canvas.a.a aVar = dVar.hcF;
        float measureText = aVar.measureText(str);
        if (f3 <= 0.0f || f3 >= measureText) {
            canvas.drawText(str, f, f2, aVar);
        } else {
            canvas.save();
            measureText = f3 / measureText;
            canvas.translate(f, f2);
            canvas.scale(measureText, 1.0f);
            canvas.drawText(str, 0.0f, 0.0f, aVar);
            canvas.restore();
        }
        AppMethodBeat.o(103214);
        return true;
    }
}
