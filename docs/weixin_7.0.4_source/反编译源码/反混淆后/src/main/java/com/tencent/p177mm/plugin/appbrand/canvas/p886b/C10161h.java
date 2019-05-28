package com.tencent.p177mm.plugin.appbrand.canvas.p886b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.h */
public final class C10161h implements C42399a {
    public final String getMethod() {
        return "moveTo";
    }

    /* renamed from: a */
    public final boolean mo21528a(Path path, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103689);
        if (jSONArray.length() < 2) {
            AppMethodBeat.m2505o(103689);
            return false;
        }
        path.moveTo(C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1));
        AppMethodBeat.m2505o(103689);
        return true;
    }

    /* renamed from: a */
    public final boolean mo21527a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.m2504i(103690);
        PathMoveToActionArg pathMoveToActionArg = (PathMoveToActionArg) basePathActionArg;
        if (pathMoveToActionArg == null) {
            AppMethodBeat.m2505o(103690);
            return false;
        }
        path.moveTo(pathMoveToActionArg.f3603x, pathMoveToActionArg.f3604y);
        AppMethodBeat.m2505o(103690);
        return true;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.m2504i(103691);
        PathMoveToActionArg pathMoveToActionArg = new PathMoveToActionArg();
        AppMethodBeat.m2505o(103691);
        return pathMoveToActionArg;
    }
}
