package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.s */
public final class C26818s implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103238);
        SetFontSizeActionArg setFontSizeActionArg = new SetFontSizeActionArg();
        AppMethodBeat.m2505o(103238);
        return setFontSizeActionArg;
    }

    public final String getMethod() {
        return "setFontSize";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103239);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103239);
            return false;
        }
        boolean a = C26818s.m42693a(c2102d, C42668g.m75554a(jSONArray, 0));
        AppMethodBeat.m2505o(103239);
        return a;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103241);
        SetFontSizeActionArg setFontSizeActionArg = (SetFontSizeActionArg) drawActionArg;
        if (setFontSizeActionArg == null) {
            AppMethodBeat.m2505o(103241);
            return false;
        }
        boolean a = C26818s.m42693a(c2102d, setFontSizeActionArg.size);
        AppMethodBeat.m2505o(103241);
        return a;
    }

    /* renamed from: a */
    private static boolean m42693a(C2102d c2102d, int i) {
        AppMethodBeat.m2504i(103240);
        c2102d.hcF.setTextSize((float) i);
        c2102d.hcE.setTextSize((float) i);
        AppMethodBeat.m2505o(103240);
        return true;
    }
}
