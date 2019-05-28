package com.tencent.p177mm.plugin.appbrand.canvas.p886b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.f */
public final class C26820f implements C42399a {
    public final String getMethod() {
        return "closePath";
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.m2504i(103685);
        PathClosePathActionArg pathClosePathActionArg = new PathClosePathActionArg();
        AppMethodBeat.m2505o(103685);
        return pathClosePathActionArg;
    }

    /* renamed from: a */
    public final boolean mo21528a(Path path, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103683);
        path.close();
        AppMethodBeat.m2505o(103683);
        return true;
    }

    /* renamed from: a */
    public final boolean mo21527a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.m2504i(103684);
        path.close();
        AppMethodBeat.m2505o(103684);
        return true;
    }
}
