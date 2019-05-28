package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.ae */
public final class C42389ae implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103283);
        SetShadowActionArg setShadowActionArg = new SetShadowActionArg();
        AppMethodBeat.m2505o(103283);
        return setShadowActionArg;
    }

    public final String getMethod() {
        return "setShadow";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103284);
        if (jSONArray.length() < 4) {
            AppMethodBeat.m2505o(103284);
            return false;
        }
        float d = C42668g.m75561d(jSONArray, 0);
        float d2 = C42668g.m75561d(jSONArray, 1);
        float d3 = C42668g.m75561d(jSONArray, 2);
        JSONArray optJSONArray = jSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.m2505o(103284);
            return false;
        }
        boolean a = C42389ae.m75007a(c2102d, d, d2, d3, C42668g.m75567n(optJSONArray));
        AppMethodBeat.m2505o(103284);
        return a;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103286);
        SetShadowActionArg setShadowActionArg = (SetShadowActionArg) drawActionArg;
        if (setShadowActionArg == null) {
            AppMethodBeat.m2505o(103286);
            return false;
        }
        boolean a = C42389ae.m75007a(c2102d, setShadowActionArg.f1245x, setShadowActionArg.f1246y, setShadowActionArg.hdo, setShadowActionArg.color);
        AppMethodBeat.m2505o(103286);
        return a;
    }

    /* renamed from: a */
    private static boolean m75007a(C2102d c2102d, float f, float f2, float f3, int i) {
        AppMethodBeat.m2504i(103285);
        c2102d.hcF.setShadowLayer(f3, f, f2, i);
        c2102d.hcE.setShadowLayer(f3, f, f2, i);
        AppMethodBeat.m2505o(103285);
        return true;
    }
}
