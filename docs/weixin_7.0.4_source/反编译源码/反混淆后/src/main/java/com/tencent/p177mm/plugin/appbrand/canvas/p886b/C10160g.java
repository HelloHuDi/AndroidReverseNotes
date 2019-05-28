package com.tencent.p177mm.plugin.appbrand.canvas.p886b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.g */
public final class C10160g implements C42399a {
    public final String getMethod() {
        return "lineTo";
    }

    /* renamed from: a */
    public final boolean mo21528a(Path path, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103686);
        if (jSONArray.length() < 2) {
            AppMethodBeat.m2505o(103686);
            return false;
        }
        path.lineTo(C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1));
        AppMethodBeat.m2505o(103686);
        return true;
    }

    /* renamed from: a */
    public final boolean mo21527a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.m2504i(103687);
        PathLineToActionArg pathLineToActionArg = (PathLineToActionArg) basePathActionArg;
        if (pathLineToActionArg == null) {
            AppMethodBeat.m2505o(103687);
            return false;
        }
        path.lineTo(pathLineToActionArg.f16142x, pathLineToActionArg.f16143y);
        AppMethodBeat.m2505o(103687);
        return true;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.m2504i(103688);
        PathLineToActionArg pathLineToActionArg = new PathLineToActionArg();
        AppMethodBeat.m2505o(103688);
        return pathLineToActionArg;
    }
}
