package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.x */
public final class C38151x implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103258);
        SetLineCapActionArg setLineCapActionArg = new SetLineCapActionArg();
        AppMethodBeat.m2505o(103258);
        return setLineCapActionArg;
    }

    public final String getMethod() {
        return "setLineCap";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103259);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103259);
            return false;
        }
        boolean b = C38151x.m64560b(c2102d, jSONArray.optString(0));
        AppMethodBeat.m2505o(103259);
        return b;
    }

    /* renamed from: b */
    private static boolean m64560b(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(103260);
        if ("butt".equalsIgnoreCase(str)) {
            c2102d.hcF.setStrokeCap(Cap.BUTT);
            c2102d.hcE.setStrokeCap(Cap.BUTT);
        } else if ("round".equalsIgnoreCase(str)) {
            c2102d.hcF.setStrokeCap(Cap.ROUND);
            c2102d.hcE.setStrokeCap(Cap.ROUND);
        } else if (MessengerShareContentUtility.IMAGE_RATIO_SQUARE.equalsIgnoreCase(str)) {
            c2102d.hcF.setStrokeCap(Cap.SQUARE);
            c2102d.hcE.setStrokeCap(Cap.SQUARE);
        }
        AppMethodBeat.m2505o(103260);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103261);
        SetLineCapActionArg setLineCapActionArg = (SetLineCapActionArg) drawActionArg;
        if (setLineCapActionArg == null) {
            AppMethodBeat.m2505o(103261);
            return false;
        }
        boolean b = C38151x.m64560b(c2102d, setLineCapActionArg.hdj);
        AppMethodBeat.m2505o(103261);
        return b;
    }
}
