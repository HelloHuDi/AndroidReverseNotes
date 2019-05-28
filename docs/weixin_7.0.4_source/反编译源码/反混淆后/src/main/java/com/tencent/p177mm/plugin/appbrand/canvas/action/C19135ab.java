package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.ab */
public final class C19135ab implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103271);
        SetLineWidthActionArg setLineWidthActionArg = new SetLineWidthActionArg();
        AppMethodBeat.m2505o(103271);
        return setLineWidthActionArg;
    }

    public final String getMethod() {
        return "setLineWidth";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103272);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103272);
            return false;
        }
        boolean a = C19135ab.m29756a(c2102d, C42668g.m75561d(jSONArray, 0));
        AppMethodBeat.m2505o(103272);
        return a;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103274);
        SetLineWidthActionArg setLineWidthActionArg = (SetLineWidthActionArg) drawActionArg;
        if (setLineWidthActionArg == null) {
            AppMethodBeat.m2505o(103274);
            return false;
        }
        boolean a = C19135ab.m29756a(c2102d, setLineWidthActionArg.hdn);
        AppMethodBeat.m2505o(103274);
        return a;
    }

    /* renamed from: a */
    private static boolean m29756a(C2102d c2102d, float f) {
        AppMethodBeat.m2504i(103273);
        c2102d.hcF.setStrokeWidth(f);
        c2102d.hcE.setStrokeWidth(f);
        AppMethodBeat.m2505o(103273);
        return true;
    }
}
