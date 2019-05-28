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

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.g */
public final class C42395g implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103192);
        PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper();
        AppMethodBeat.m2505o(103192);
        return pathActionArgWrapper;
    }

    public final String getMethod() {
        return "strokePath";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103193);
        boolean a = C42395g.m75032a(c2102d, canvas, C10159a.hdT.mo21526g(jSONArray));
        AppMethodBeat.m2505o(103193);
        return a;
    }

    /* renamed from: a */
    private static boolean m75032a(C2102d c2102d, Canvas canvas, Path path) {
        AppMethodBeat.m2504i(103194);
        canvas.drawPath(path, c2102d.hcE);
        AppMethodBeat.m2505o(103194);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103195);
        boolean a = C42395g.m75032a(c2102d, canvas, C10159a.hdT.mo21525a((PathActionArgWrapper) drawActionArg));
        AppMethodBeat.m2505o(103195);
        return a;
    }
}
