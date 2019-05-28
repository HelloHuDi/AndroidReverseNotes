package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class e implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103182);
        DrawArcActionArg drawArcActionArg = new DrawArcActionArg();
        AppMethodBeat.o(103182);
        return drawArcActionArg;
    }

    public final String getMethod() {
        return "arc";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103183);
        if (jSONArray.length() < 5) {
            AppMethodBeat.o(103183);
            return false;
        }
        boolean a = a(dVar, canvas, g.d(jSONArray, 0), g.d(jSONArray, 1), g.d(jSONArray, 2), (float) jSONArray.optDouble(3), (float) jSONArray.optDouble(4));
        AppMethodBeat.o(103183);
        return a;
    }

    private static boolean a(d dVar, Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(103184);
        canvas.drawArc(new RectF(f - f3, f2 - f3, f + f3, f2 + f3), (float) ((((double) f4) / 3.141592653589793d) * 180.0d), (float) ((((double) f5) / 3.141592653589793d) * 180.0d), true, dVar.hcE);
        AppMethodBeat.o(103184);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103185);
        DrawArcActionArg drawArcActionArg = (DrawArcActionArg) drawActionArg;
        if (drawArcActionArg == null) {
            AppMethodBeat.o(103185);
            return false;
        }
        boolean a = a(dVar, canvas, drawArcActionArg.x, drawArcActionArg.y, drawArcActionArg.radius, drawArcActionArg.hcR, drawArcActionArg.hcS);
        AppMethodBeat.o(103185);
        return a;
    }
}
