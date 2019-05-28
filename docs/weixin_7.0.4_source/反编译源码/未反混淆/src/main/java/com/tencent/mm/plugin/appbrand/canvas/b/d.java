package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathBezierCurveToActionArg;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class d implements a {
    public final String getMethod() {
        return "bezierCurveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(103672);
        if (jSONArray.length() < 6) {
            AppMethodBeat.o(103672);
            return false;
        }
        boolean a = a(path, g.d(jSONArray, 0), g.d(jSONArray, 1), g.d(jSONArray, 2), g.d(jSONArray, 3), g.d(jSONArray, 4), g.d(jSONArray, 5));
        AppMethodBeat.o(103672);
        return a;
    }

    private static boolean a(Path path, float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.i(103673);
        path.cubicTo(f, f2, f3, f4, f5, f6);
        AppMethodBeat.o(103673);
        return true;
    }

    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(103674);
        PathBezierCurveToActionArg pathBezierCurveToActionArg = (PathBezierCurveToActionArg) basePathActionArg;
        if (pathBezierCurveToActionArg == null) {
            AppMethodBeat.o(103674);
            return false;
        }
        boolean a = a(path, pathBezierCurveToActionArg.x1, pathBezierCurveToActionArg.y1, pathBezierCurveToActionArg.x2, pathBezierCurveToActionArg.y2, pathBezierCurveToActionArg.x3, pathBezierCurveToActionArg.y3);
        AppMethodBeat.o(103674);
        return a;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.i(103675);
        PathBezierCurveToActionArg pathBezierCurveToActionArg = new PathBezierCurveToActionArg();
        AppMethodBeat.o(103675);
        return pathBezierCurveToActionArg;
    }
}
