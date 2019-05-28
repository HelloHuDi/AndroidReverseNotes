package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.e */
public final class C45528e implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103182);
        DrawArcActionArg drawArcActionArg = new DrawArcActionArg();
        AppMethodBeat.m2505o(103182);
        return drawArcActionArg;
    }

    public final String getMethod() {
        return "arc";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103183);
        if (jSONArray.length() < 5) {
            AppMethodBeat.m2505o(103183);
            return false;
        }
        boolean a = C45528e.m83950a(c2102d, canvas, C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), (float) jSONArray.optDouble(3), (float) jSONArray.optDouble(4));
        AppMethodBeat.m2505o(103183);
        return a;
    }

    /* renamed from: a */
    private static boolean m83950a(C2102d c2102d, Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        AppMethodBeat.m2504i(103184);
        canvas.drawArc(new RectF(f - f3, f2 - f3, f + f3, f2 + f3), (float) ((((double) f4) / 3.141592653589793d) * 180.0d), (float) ((((double) f5) / 3.141592653589793d) * 180.0d), true, c2102d.hcE);
        AppMethodBeat.m2505o(103184);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103185);
        DrawArcActionArg drawArcActionArg = (DrawArcActionArg) drawActionArg;
        if (drawArcActionArg == null) {
            AppMethodBeat.m2505o(103185);
            return false;
        }
        boolean a = C45528e.m83950a(c2102d, canvas, drawArcActionArg.f15027x, drawArcActionArg.f15028y, drawArcActionArg.radius, drawArcActionArg.hcR, drawArcActionArg.hcS);
        AppMethodBeat.m2505o(103185);
        return a;
    }
}
