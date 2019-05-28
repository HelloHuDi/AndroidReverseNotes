package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.y */
public final class C45531y implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103262);
        SetLineDashActionArg setLineDashActionArg = new SetLineDashActionArg();
        AppMethodBeat.m2505o(103262);
        return setLineDashActionArg;
    }

    public final String getMethod() {
        return "setLineDash";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103263);
        if (jSONArray.length() < 2) {
            AppMethodBeat.m2505o(103263);
            return false;
        }
        try {
            JSONArray jSONArray2 = jSONArray.getJSONArray(0);
            if (jSONArray2 == null) {
                AppMethodBeat.m2505o(103263);
                return false;
            }
            float[] fArr = new float[jSONArray2.length()];
            for (int i = 0; i < fArr.length; i++) {
                fArr[i] = C42668g.m75561d(jSONArray2, i);
            }
            boolean a = C45531y.m83959a(c2102d, fArr, C42668g.m75561d(jSONArray, 1));
            AppMethodBeat.m2505o(103263);
            return a;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(103263);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m83959a(C2102d c2102d, float[] fArr, float f) {
        AppMethodBeat.m2504i(103264);
        if (!(fArr == null || f == Float.MIN_VALUE)) {
            c2102d.hcE.setPathEffect(new DashPathEffect(fArr, f));
        }
        AppMethodBeat.m2505o(103264);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103265);
        SetLineDashActionArg setLineDashActionArg = (SetLineDashActionArg) drawActionArg;
        if (setLineDashActionArg == null) {
            AppMethodBeat.m2505o(103265);
            return false;
        }
        boolean a = C45531y.m83959a(c2102d, setLineDashActionArg.hdk, setLineDashActionArg.hdl);
        AppMethodBeat.m2505o(103265);
        return a;
    }
}
