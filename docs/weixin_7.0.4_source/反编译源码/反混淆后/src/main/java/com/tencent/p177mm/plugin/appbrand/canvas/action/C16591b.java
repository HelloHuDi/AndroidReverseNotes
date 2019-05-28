package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import com.tencent.p177mm.plugin.appbrand.canvas.p886b.C10158e.C10159a;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.b */
public final class C16591b implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103176);
        PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper();
        AppMethodBeat.m2505o(103176);
        return pathActionArgWrapper;
    }

    public final String getMethod() {
        return "clip";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103177);
        canvas.clipPath(C10159a.hdT.mo21526g(jSONArray));
        AppMethodBeat.m2505o(103177);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103178);
        canvas.clipPath(C10159a.hdT.mo21525a((PathActionArgWrapper) drawActionArg));
        AppMethodBeat.m2505o(103178);
        return true;
    }
}
