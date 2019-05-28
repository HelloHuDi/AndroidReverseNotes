package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C19151f;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.ClearRectActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.a */
public final class C2091a implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103172);
        ClearRectActionArg clearRectActionArg = new ClearRectActionArg();
        AppMethodBeat.m2505o(103172);
        return clearRectActionArg;
    }

    public final String getMethod() {
        return "clearRect";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103173);
        if (jSONArray.length() < 4) {
            AppMethodBeat.m2505o(103173);
            return false;
        }
        boolean a = C2091a.m4282a(c2102d, canvas, C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), C42668g.m75561d(jSONArray, 3));
        AppMethodBeat.m2505o(103173);
        return a;
    }

    /* renamed from: a */
    private static boolean m4282a(C2102d c2102d, Canvas canvas, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(103174);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof C19151f) {
                ((C19151f) canvas).mo34373g(f, f2, f + f3, f2 + f4);
                C45124d.m82932v("MicroMsg.ClearRectAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                AppMethodBeat.m2505o(103174);
                return true;
            } else if (c2102d.hcJ != null) {
                canvas.drawRect(f, f2, f + f3, f2 + f4, c2102d.hcJ);
                C45124d.m82932v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                AppMethodBeat.m2505o(103174);
                return true;
            } else {
                C45124d.m82932v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                AppMethodBeat.m2505o(103174);
                return false;
            }
        } else if (c2102d.hcJ != null) {
            canvas.drawRect(f, f2, f + f3, f2 + f4, c2102d.hcJ);
            C45124d.m82932v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
            AppMethodBeat.m2505o(103174);
            return true;
        } else {
            canvas.drawRect(f, f2, f + f3, f2 + f4, c2102d.hcI);
            C45124d.m82932v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
            AppMethodBeat.m2505o(103174);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103175);
        if (drawActionArg == null || !(drawActionArg instanceof ClearRectActionArg)) {
            AppMethodBeat.m2505o(103175);
            return false;
        }
        ClearRectActionArg clearRectActionArg = (ClearRectActionArg) drawActionArg;
        boolean a = C2091a.m4282a(c2102d, canvas, clearRectActionArg.f4342x, clearRectActionArg.f4343y, clearRectActionArg.width, clearRectActionArg.height);
        AppMethodBeat.m2505o(103175);
        return a;
    }
}
