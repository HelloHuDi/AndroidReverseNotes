package com.tencent.p177mm.plugin.appbrand.canvas.p886b;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.j */
public final class C38154j implements C42399a {
    public final String getMethod() {
        return "rect";
    }

    /* renamed from: a */
    public final boolean mo21528a(Path path, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103696);
        if (jSONArray.length() < 4) {
            AppMethodBeat.m2505o(103696);
            return false;
        }
        boolean a = C38154j.m64566a(path, C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), C42668g.m75561d(jSONArray, 3));
        AppMethodBeat.m2505o(103696);
        return a;
    }

    /* renamed from: a */
    private static boolean m64566a(Path path, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(103697);
        path.addRect(f, f2, f + f3, f2 + f4, Direction.CW);
        AppMethodBeat.m2505o(103697);
        return true;
    }

    /* renamed from: a */
    public final boolean mo21527a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.m2504i(103698);
        PathRectActionArg pathRectActionArg = (PathRectActionArg) basePathActionArg;
        if (pathRectActionArg == null) {
            AppMethodBeat.m2505o(103698);
            return false;
        }
        boolean a = C38154j.m64566a(path, pathRectActionArg.f13671x, pathRectActionArg.f13672y, pathRectActionArg.width, pathRectActionArg.height);
        AppMethodBeat.m2505o(103698);
        return a;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.m2504i(103699);
        PathRectActionArg pathRectActionArg = new PathRectActionArg();
        AppMethodBeat.m2505o(103699);
        return pathRectActionArg;
    }
}
