package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.v */
public final class C38150v implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103250);
        SetGlobalAlphaActionArg setGlobalAlphaActionArg = new SetGlobalAlphaActionArg();
        AppMethodBeat.m2505o(103250);
        return setGlobalAlphaActionArg;
    }

    public final String getMethod() {
        return "setGlobalAlpha";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.m2504i(103251);
        try {
            z = C38150v.m64557a(c2102d, jSONArray.getInt(0));
            AppMethodBeat.m2505o(103251);
            return z;
        } catch (JSONException e) {
            C45124d.m82928e("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", e);
            AppMethodBeat.m2505o(103251);
            return z;
        }
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103253);
        SetGlobalAlphaActionArg setGlobalAlphaActionArg = (SetGlobalAlphaActionArg) drawActionArg;
        if (setGlobalAlphaActionArg == null) {
            AppMethodBeat.m2505o(103253);
            return false;
        }
        boolean a = C38150v.m64557a(c2102d, setGlobalAlphaActionArg.alpha);
        AppMethodBeat.m2505o(103253);
        return a;
    }

    /* renamed from: a */
    private static boolean m64557a(C2102d c2102d, int i) {
        AppMethodBeat.m2504i(103252);
        c2102d.hcE.mo21503ai(((float) i) / 255.0f);
        c2102d.hcF.mo21503ai(((float) i) / 255.0f);
        AppMethodBeat.m2505o(103252);
        return true;
    }
}
