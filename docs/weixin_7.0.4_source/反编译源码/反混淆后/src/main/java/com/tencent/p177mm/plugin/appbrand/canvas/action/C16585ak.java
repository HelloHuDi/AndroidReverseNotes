package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.TranslateActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.ak */
public final class C16585ak implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103306);
        TranslateActionArg translateActionArg = new TranslateActionArg();
        AppMethodBeat.m2505o(103306);
        return translateActionArg;
    }

    public final String getMethod() {
        return "translate";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103307);
        if (jSONArray.length() < 2) {
            AppMethodBeat.m2505o(103307);
            return false;
        }
        canvas.translate(C42668g.m75561d(jSONArray, 0), C42668g.m75561d(jSONArray, 1));
        AppMethodBeat.m2505o(103307);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103308);
        TranslateActionArg translateActionArg = (TranslateActionArg) drawActionArg;
        if (translateActionArg == null) {
            AppMethodBeat.m2505o(103308);
            return false;
        }
        canvas.translate(translateActionArg.f4346x, translateActionArg.f4347y);
        AppMethodBeat.m2505o(103308);
        return true;
    }
}
