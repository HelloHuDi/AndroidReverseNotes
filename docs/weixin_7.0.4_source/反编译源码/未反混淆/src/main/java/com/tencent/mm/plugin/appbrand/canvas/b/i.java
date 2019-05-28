package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class i implements a {
    public final String getMethod() {
        return "quadraticCurveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(103692);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(103692);
            return false;
        }
        boolean a = a(path, g.d(jSONArray, 0), g.d(jSONArray, 1), g.d(jSONArray, 2), g.d(jSONArray, 3));
        AppMethodBeat.o(103692);
        return a;
    }

    private static boolean a(Path path, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(103693);
        path.quadTo(f, f2, f3, f4);
        AppMethodBeat.o(103693);
        return true;
    }

    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(103694);
        PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = (PathQuadraticCurveToActionArg) basePathActionArg;
        if (basePathActionArg == null) {
            AppMethodBeat.o(103694);
            return false;
        }
        boolean a = a(path, pathQuadraticCurveToActionArg.x1, pathQuadraticCurveToActionArg.y1, pathQuadraticCurveToActionArg.x2, pathQuadraticCurveToActionArg.y2);
        AppMethodBeat.o(103694);
        return a;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.i(103695);
        PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = new PathQuadraticCurveToActionArg();
        AppMethodBeat.o(103695);
        return pathQuadraticCurveToActionArg;
    }
}
