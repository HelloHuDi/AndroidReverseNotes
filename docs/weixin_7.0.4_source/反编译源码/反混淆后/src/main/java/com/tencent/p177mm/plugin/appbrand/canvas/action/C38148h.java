package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.h */
public final class C38148h implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103196);
        DrawRectActionArg drawRectActionArg = new DrawRectActionArg();
        AppMethodBeat.m2505o(103196);
        return drawRectActionArg;
    }

    public final String getMethod() {
        return "strokeRect";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103197);
        if (jSONArray.length() < 4) {
            AppMethodBeat.m2505o(103197);
            return false;
        }
        boolean a = C38148h.m64551a(c2102d, canvas, C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), C42668g.m75561d(jSONArray, 3));
        AppMethodBeat.m2505o(103197);
        return a;
    }

    /* renamed from: a */
    private static boolean m64551a(C2102d c2102d, Canvas canvas, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(103198);
        canvas.drawRect(f, f2, f + f3, f2 + f4, c2102d.hcE);
        AppMethodBeat.m2505o(103198);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103199);
        DrawRectActionArg drawRectActionArg = (DrawRectActionArg) drawActionArg;
        if (drawRectActionArg == null) {
            AppMethodBeat.m2505o(103199);
            return false;
        }
        boolean a = C38148h.m64551a(c2102d, canvas, drawRectActionArg.f4344x, drawRectActionArg.f4345y, drawRectActionArg.width, drawRectActionArg.height);
        AppMethodBeat.m2505o(103199);
        return a;
    }
}
