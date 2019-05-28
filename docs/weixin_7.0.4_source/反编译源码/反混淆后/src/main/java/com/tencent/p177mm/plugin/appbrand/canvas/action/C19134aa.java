package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Join;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.aa */
public final class C19134aa implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103267);
        SetLineJoinActionArg setLineJoinActionArg = new SetLineJoinActionArg();
        AppMethodBeat.m2505o(103267);
        return setLineJoinActionArg;
    }

    public final String getMethod() {
        return "setLineJoin";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103268);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103268);
            return false;
        }
        boolean b = C19134aa.m29753b(c2102d, jSONArray.optString(0));
        AppMethodBeat.m2505o(103268);
        return b;
    }

    /* renamed from: b */
    private static boolean m29753b(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(103269);
        if ("miter".equalsIgnoreCase(str)) {
            c2102d.hcF.setStrokeJoin(Join.MITER);
            c2102d.hcE.setStrokeJoin(Join.MITER);
        } else if ("round".equalsIgnoreCase(str)) {
            c2102d.hcF.setStrokeJoin(Join.ROUND);
            c2102d.hcE.setStrokeJoin(Join.ROUND);
        } else if ("bevel".equalsIgnoreCase(str)) {
            c2102d.hcF.setStrokeJoin(Join.BEVEL);
            c2102d.hcE.setStrokeJoin(Join.BEVEL);
        }
        AppMethodBeat.m2505o(103269);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103270);
        SetLineJoinActionArg setLineJoinActionArg = (SetLineJoinActionArg) drawActionArg;
        if (setLineJoinActionArg == null) {
            AppMethodBeat.m2505o(103270);
            return false;
        }
        boolean b = C19134aa.m29753b(c2102d, setLineJoinActionArg.hdm);
        AppMethodBeat.m2505o(103270);
        return b;
    }
}
