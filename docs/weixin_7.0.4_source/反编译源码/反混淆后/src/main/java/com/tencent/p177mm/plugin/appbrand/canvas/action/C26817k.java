package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.FillRectActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.k */
public final class C26817k implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103208);
        FillRectActionArg fillRectActionArg = new FillRectActionArg();
        AppMethodBeat.m2505o(103208);
        return fillRectActionArg;
    }

    public final String getMethod() {
        return "fillRect";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103209);
        if (jSONArray.length() < 4) {
            AppMethodBeat.m2505o(103209);
            return false;
        }
        boolean a = C26817k.m42690a(c2102d, canvas, C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), C42668g.m75561d(jSONArray, 3));
        AppMethodBeat.m2505o(103209);
        return a;
    }

    /* renamed from: a */
    private static boolean m42690a(C2102d c2102d, Canvas canvas, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(103210);
        canvas.drawRect(f, f2, f + f3, f2 + f4, c2102d.hcF);
        AppMethodBeat.m2505o(103210);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103211);
        FillRectActionArg fillRectActionArg = (FillRectActionArg) drawActionArg;
        if (fillRectActionArg == null) {
            AppMethodBeat.m2505o(103211);
            return false;
        }
        boolean a = C26817k.m42690a(c2102d, canvas, fillRectActionArg.f1241x, fillRectActionArg.f1242y, fillRectActionArg.width, fillRectActionArg.height);
        AppMethodBeat.m2505o(103211);
        return a;
    }
}
