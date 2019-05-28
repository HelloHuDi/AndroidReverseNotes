package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.m */
public final class C42396m implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103216);
        DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg();
        AppMethodBeat.m2505o(103216);
        return defaultDrawActionArg;
    }

    public final String getMethod() {
        return "restore";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103217);
        boolean a = C42396m.m75035a(c2102d, canvas);
        AppMethodBeat.m2505o(103217);
        return a;
    }

    /* renamed from: a */
    private static boolean m75035a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103218);
        canvas.restore();
        c2102d.restore();
        AppMethodBeat.m2505o(103218);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103219);
        boolean a = C42396m.m75035a(c2102d, canvas);
        AppMethodBeat.m2505o(103219);
        return a;
    }
}
