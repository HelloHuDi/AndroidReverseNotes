package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a.C10149a;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.ah */
public final class C45526ah implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103294);
        SetTextBaseLineActionArg setTextBaseLineActionArg = new SetTextBaseLineActionArg();
        AppMethodBeat.m2505o(103294);
        return setTextBaseLineActionArg;
    }

    public final String getMethod() {
        return "setTextBaseline";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103295);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103295);
            return false;
        }
        boolean b = C45526ah.m83941b(c2102d, jSONArray.optString(0));
        AppMethodBeat.m2505o(103295);
        return b;
    }

    /* renamed from: b */
    private static boolean m83941b(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(103296);
        C45124d.m82930i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", str);
        if ("top".equalsIgnoreCase(str)) {
            c2102d.hcE.hdH = C10149a.TOP;
            c2102d.hcF.hdH = C10149a.TOP;
        } else if ("middle".equalsIgnoreCase(str)) {
            c2102d.hcE.hdH = C10149a.MIDDLE;
            c2102d.hcF.hdH = C10149a.MIDDLE;
        } else if ("bottom".equalsIgnoreCase(str)) {
            c2102d.hcE.hdH = C10149a.BOTTOM;
            c2102d.hcF.hdH = C10149a.BOTTOM;
        } else if ("normal".equalsIgnoreCase(str)) {
            c2102d.hcE.hdH = C10149a.NORMAL;
            c2102d.hcF.hdH = C10149a.NORMAL;
        }
        AppMethodBeat.m2505o(103296);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103297);
        SetTextBaseLineActionArg setTextBaseLineActionArg = (SetTextBaseLineActionArg) drawActionArg;
        if (setTextBaseLineActionArg == null) {
            AppMethodBeat.m2505o(103297);
            return false;
        }
        boolean b = C45526ah.m83941b(c2102d, setTextBaseLineActionArg.hdq);
        AppMethodBeat.m2505o(103297);
        return b;
    }
}
