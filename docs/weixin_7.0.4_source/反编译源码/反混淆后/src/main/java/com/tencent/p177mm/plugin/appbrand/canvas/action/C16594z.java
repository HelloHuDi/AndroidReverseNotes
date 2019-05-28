package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONException;

@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.z */
public final class C16594z implements C10155d {
    public final BaseDrawActionArg ayf() {
        return null;
    }

    public final String getMethod() {
        return "setLineHeight";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103266);
        if (jSONArray.length() == 0) {
            AppMethodBeat.m2505o(103266);
        } else {
            try {
                C42668g.m75568o(jSONArray);
            } catch (JSONException e) {
                C45124d.m82929i("MicroMsg.SetLineHeight", "get 'lineHeight' error");
            }
            AppMethodBeat.m2505o(103266);
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        return false;
    }
}
