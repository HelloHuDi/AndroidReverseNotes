package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.o */
public final class C38149o implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103224);
        DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg();
        AppMethodBeat.m2505o(103224);
        return defaultDrawActionArg;
    }

    public final String getMethod() {
        return "save";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103225);
        boolean a = C38149o.m64554a(c2102d, canvas);
        AppMethodBeat.m2505o(103225);
        return a;
    }

    /* renamed from: a */
    private static boolean m64554a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103226);
        canvas.save();
        c2102d.save();
        AppMethodBeat.m2505o(103226);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103227);
        boolean a = C38149o.m64554a(c2102d, canvas);
        AppMethodBeat.m2505o(103227);
        return a;
    }
}
