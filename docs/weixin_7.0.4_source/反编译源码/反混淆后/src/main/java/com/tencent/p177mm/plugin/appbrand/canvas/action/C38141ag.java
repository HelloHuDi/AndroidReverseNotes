package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.ag */
public final class C38141ag implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103290);
        SetTextAlignActionArg setTextAlignActionArg = new SetTextAlignActionArg();
        AppMethodBeat.m2505o(103290);
        return setTextAlignActionArg;
    }

    public final String getMethod() {
        return "setTextAlign";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103291);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103291);
            return false;
        }
        boolean b = C38141ag.m64532b(c2102d, jSONArray.optString(0));
        AppMethodBeat.m2505o(103291);
        return b;
    }

    /* renamed from: b */
    private static boolean m64532b(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(103292);
        if ("left".equalsIgnoreCase(str)) {
            c2102d.hcE.setTextAlign(Align.LEFT);
            c2102d.hcF.setTextAlign(Align.LEFT);
        } else if ("right".equalsIgnoreCase(str)) {
            c2102d.hcE.setTextAlign(Align.RIGHT);
            c2102d.hcF.setTextAlign(Align.RIGHT);
        } else if ("center".equalsIgnoreCase(str)) {
            c2102d.hcE.setTextAlign(Align.CENTER);
            c2102d.hcF.setTextAlign(Align.CENTER);
        }
        AppMethodBeat.m2505o(103292);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103293);
        SetTextAlignActionArg setTextAlignActionArg = (SetTextAlignActionArg) drawActionArg;
        if (setTextAlignActionArg == null) {
            AppMethodBeat.m2505o(103293);
            return false;
        }
        boolean b = C38141ag.m64532b(c2102d, setTextAlignActionArg.hdq);
        AppMethodBeat.m2505o(103293);
        return b;
    }
}
