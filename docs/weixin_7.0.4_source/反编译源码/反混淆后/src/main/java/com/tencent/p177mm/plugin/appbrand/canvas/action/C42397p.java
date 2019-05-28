package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.ScaleActionArg;
import com.tencent.ttpic.model.WMElement;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.p */
public final class C42397p implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103228);
        ScaleActionArg scaleActionArg = new ScaleActionArg();
        AppMethodBeat.m2505o(103228);
        return scaleActionArg;
    }

    public final String getMethod() {
        return WMElement.ANIMATE_TYPE_SCALE;
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103229);
        if (jSONArray.length() < 2) {
            AppMethodBeat.m2505o(103229);
            return false;
        }
        canvas.scale((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1));
        AppMethodBeat.m2505o(103229);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103230);
        ScaleActionArg scaleActionArg = (ScaleActionArg) drawActionArg;
        if (scaleActionArg == null) {
            AppMethodBeat.m2505o(103230);
            return false;
        }
        canvas.scale(scaleActionArg.hcX, scaleActionArg.hcY);
        AppMethodBeat.m2505o(103230);
        return true;
    }
}
