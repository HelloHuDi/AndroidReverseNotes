package com.tencent.p177mm.plugin.appbrand.canvas.p886b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.i */
public final class C26821i implements C42399a {
    public final String getMethod() {
        return "quadraticCurveTo";
    }

    /* renamed from: a */
    public final boolean mo21528a(Path path, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103692);
        if (jSONArray.length() < 4) {
            AppMethodBeat.m2505o(103692);
            return false;
        }
        boolean a = C26821i.m42701a(path, C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), C42668g.m75561d(jSONArray, 3));
        AppMethodBeat.m2505o(103692);
        return a;
    }

    /* renamed from: a */
    private static boolean m42701a(Path path, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(103693);
        path.quadTo(f, f2, f3, f4);
        AppMethodBeat.m2505o(103693);
        return true;
    }

    /* renamed from: a */
    public final boolean mo21527a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.m2504i(103694);
        PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = (PathQuadraticCurveToActionArg) basePathActionArg;
        if (basePathActionArg == null) {
            AppMethodBeat.m2505o(103694);
            return false;
        }
        boolean a = C26821i.m42701a(path, pathQuadraticCurveToActionArg.f16144x1, pathQuadraticCurveToActionArg.f16146y1, pathQuadraticCurveToActionArg.f16145x2, pathQuadraticCurveToActionArg.f16147y2);
        AppMethodBeat.m2505o(103694);
        return a;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.m2504i(103695);
        PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = new PathQuadraticCurveToActionArg();
        AppMethodBeat.m2505o(103695);
        return pathQuadraticCurveToActionArg;
    }
}
