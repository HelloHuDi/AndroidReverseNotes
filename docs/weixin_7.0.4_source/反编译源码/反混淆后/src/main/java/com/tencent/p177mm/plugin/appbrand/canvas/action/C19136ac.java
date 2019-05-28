package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.ac */
public final class C19136ac implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103275);
        SeMiterLimitActionArg seMiterLimitActionArg = new SeMiterLimitActionArg();
        AppMethodBeat.m2505o(103275);
        return seMiterLimitActionArg;
    }

    public final String getMethod() {
        return "setMiterLimit";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103276);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103276);
            return false;
        }
        boolean a = C19136ac.m29759a(c2102d, (float) jSONArray.optDouble(0));
        AppMethodBeat.m2505o(103276);
        return a;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103278);
        SeMiterLimitActionArg seMiterLimitActionArg = (SeMiterLimitActionArg) drawActionArg;
        if (seMiterLimitActionArg == null) {
            AppMethodBeat.m2505o(103278);
            return false;
        }
        boolean a = C19136ac.m29759a(c2102d, seMiterLimitActionArg.hdf);
        AppMethodBeat.m2505o(103278);
        return a;
    }

    /* renamed from: a */
    private static boolean m29759a(C2102d c2102d, float f) {
        AppMethodBeat.m2504i(103277);
        c2102d.hcF.setStrokeMiter(f);
        c2102d.hcE.setStrokeMiter(f);
        AppMethodBeat.m2505o(103277);
        return true;
    }
}
