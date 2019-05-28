package com.tencent.p177mm.plugin.appbrand.canvas.p886b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathBezierCurveToActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.d */
public final class C45533d implements C42399a {
    public final String getMethod() {
        return "bezierCurveTo";
    }

    /* renamed from: a */
    public final boolean mo21528a(Path path, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103672);
        if (jSONArray.length() < 6) {
            AppMethodBeat.m2505o(103672);
            return false;
        }
        boolean a = C45533d.m83965a(path, C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), C42668g.m75561d(jSONArray, 3), C42668g.m75561d(jSONArray, 4), C42668g.m75561d(jSONArray, 5));
        AppMethodBeat.m2505o(103672);
        return a;
    }

    /* renamed from: a */
    private static boolean m83965a(Path path, float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.m2504i(103673);
        path.cubicTo(f, f2, f3, f4, f5, f6);
        AppMethodBeat.m2505o(103673);
        return true;
    }

    /* renamed from: a */
    public final boolean mo21527a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.m2504i(103674);
        PathBezierCurveToActionArg pathBezierCurveToActionArg = (PathBezierCurveToActionArg) basePathActionArg;
        if (pathBezierCurveToActionArg == null) {
            AppMethodBeat.m2505o(103674);
            return false;
        }
        boolean a = C45533d.m83965a(path, pathBezierCurveToActionArg.f17176x1, pathBezierCurveToActionArg.f17179y1, pathBezierCurveToActionArg.f17177x2, pathBezierCurveToActionArg.f17180y2, pathBezierCurveToActionArg.f17178x3, pathBezierCurveToActionArg.f17181y3);
        AppMethodBeat.m2505o(103674);
        return a;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.m2504i(103675);
        PathBezierCurveToActionArg pathBezierCurveToActionArg = new PathBezierCurveToActionArg();
        AppMethodBeat.m2505o(103675);
        return pathBezierCurveToActionArg;
    }
}
