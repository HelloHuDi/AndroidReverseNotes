package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a.C10149a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.i */
public final class C26816i implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103200);
        DrawTextActionArg drawTextActionArg = new DrawTextActionArg();
        AppMethodBeat.m2505o(103200);
        return drawTextActionArg;
    }

    public final String getMethod() {
        return "strokeText";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103201);
        if (jSONArray.length() < 3) {
            AppMethodBeat.m2505o(103201);
            return false;
        }
        boolean a = C26816i.m42687a(c2102d, canvas, jSONArray.optString(0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), C42668g.m75561d(jSONArray, 3));
        AppMethodBeat.m2505o(103201);
        return a;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103203);
        DrawTextActionArg drawTextActionArg = (DrawTextActionArg) drawActionArg;
        if (drawTextActionArg == null) {
            AppMethodBeat.m2505o(103203);
            return false;
        }
        boolean a = C26816i.m42687a(c2102d, canvas, drawTextActionArg.text, drawTextActionArg.f3570x, drawTextActionArg.f3571y, drawTextActionArg.hcW);
        AppMethodBeat.m2505o(103203);
        return a;
    }

    /* renamed from: a */
    private static boolean m42687a(C2102d c2102d, Canvas canvas, String str, float f, float f2, float f3) {
        AppMethodBeat.m2504i(103202);
        FontMetrics fontMetrics = c2102d.hcE.getFontMetrics();
        if (c2102d.hcE.hdH == C10149a.TOP) {
            f2 += Math.abs(fontMetrics.ascent);
        } else if (c2102d.hcE.hdH == C10149a.MIDDLE) {
            f2 += Math.abs((((-fontMetrics.ascent) + fontMetrics.descent) / 2.0f) - fontMetrics.descent);
        } else if (c2102d.hcE.hdH == C10149a.BOTTOM) {
            f2 -= Math.abs(fontMetrics.descent);
        }
        C10148a c10148a = c2102d.hcE;
        float measureText = c10148a.measureText(str);
        if (f3 <= 0.0f || f3 >= measureText) {
            canvas.drawText(str, f, f2, c10148a);
        } else {
            canvas.save();
            measureText = f3 / measureText;
            canvas.translate(f, f2);
            canvas.scale(measureText, 1.0f);
            canvas.drawText(str, 0.0f, 0.0f, c10148a);
            canvas.restore();
        }
        AppMethodBeat.m2505o(103202);
        return true;
    }
}
