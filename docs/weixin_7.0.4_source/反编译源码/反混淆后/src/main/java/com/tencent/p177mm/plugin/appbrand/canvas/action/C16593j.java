package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import com.tencent.p177mm.plugin.appbrand.canvas.p886b.C10158e.C10159a;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.j */
public final class C16593j implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103204);
        PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper();
        AppMethodBeat.m2505o(103204);
        return pathActionArgWrapper;
    }

    public final String getMethod() {
        return "fillPath";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103205);
        boolean a = C16593j.m25494a(c2102d, canvas, C10159a.hdT.mo21526g(jSONArray));
        AppMethodBeat.m2505o(103205);
        return a;
    }

    /* renamed from: a */
    private static boolean m25494a(C2102d c2102d, Canvas canvas, Path path) {
        AppMethodBeat.m2504i(103206);
        canvas.drawPath(path, c2102d.hcF);
        AppMethodBeat.m2505o(103206);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103207);
        boolean a = C16593j.m25494a(c2102d, canvas, C10159a.hdT.mo21525a((PathActionArgWrapper) drawActionArg));
        AppMethodBeat.m2505o(103207);
        return a;
    }
}
