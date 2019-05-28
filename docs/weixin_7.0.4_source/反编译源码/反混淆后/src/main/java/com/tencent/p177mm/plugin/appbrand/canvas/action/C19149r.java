package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.r */
public final class C19149r implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103234);
        SetFontFamilyActionArg setFontFamilyActionArg = new SetFontFamilyActionArg();
        AppMethodBeat.m2505o(103234);
        return setFontFamilyActionArg;
    }

    public final String getMethod() {
        return "setFontFamily";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.m2504i(103235);
        if (jSONArray.length() == 0) {
            AppMethodBeat.m2505o(103235);
            return z;
        }
        try {
            z = C19149r.m29787b(c2102d, jSONArray.getString(0));
            AppMethodBeat.m2505o(103235);
            return z;
        } catch (JSONException e) {
            C45124d.m82929i("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
            AppMethodBeat.m2505o(103235);
            return z;
        }
    }

    /* renamed from: b */
    private static boolean m29787b(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(103236);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(103236);
            return false;
        }
        c2102d.hcE.mo21511yB(str);
        c2102d.hcF.mo21511yB(str);
        AppMethodBeat.m2505o(103236);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103237);
        SetFontFamilyActionArg setFontFamilyActionArg = (SetFontFamilyActionArg) drawActionArg;
        if (setFontFamilyActionArg == null) {
            AppMethodBeat.m2505o(103237);
            return false;
        }
        boolean b = C19149r.m29787b(c2102d, setFontFamilyActionArg.bnS);
        AppMethodBeat.m2505o(103237);
        return b;
    }
}
