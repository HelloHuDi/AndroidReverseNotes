package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.ai */
public final class C19137ai implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103298);
        SetTransformActionArg setTransformActionArg = new SetTransformActionArg();
        AppMethodBeat.m2505o(103298);
        return setTransformActionArg;
    }

    public final String getMethod() {
        return "setTransform";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103299);
        if (jSONArray.length() < 6) {
            AppMethodBeat.m2505o(103299);
            return false;
        }
        try {
            boolean a = C19137ai.m29762a(canvas, (float) jSONArray.getDouble(0), (float) jSONArray.getDouble(1), (float) jSONArray.getDouble(2), (float) jSONArray.getDouble(3), C42668g.m75560c(jSONArray, 4), C42668g.m75560c(jSONArray, 5));
            AppMethodBeat.m2505o(103299);
            return a;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(103299);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m29762a(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.m2504i(103300);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setValues(new float[]{f, f3, f5, f2, f4, f6, 0.0f, 0.0f, 1.0f});
        canvas.setMatrix(matrix);
        AppMethodBeat.m2505o(103300);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103301);
        SetTransformActionArg setTransformActionArg = (SetTransformActionArg) drawActionArg;
        if (setTransformActionArg == null) {
            AppMethodBeat.m2505o(103301);
            return false;
        }
        boolean a = C19137ai.m29762a(canvas, setTransformActionArg.scaleX, setTransformActionArg.hdr, setTransformActionArg.hds, setTransformActionArg.scaleY, setTransformActionArg.translateX, setTransformActionArg.translateY);
        AppMethodBeat.m2505o(103301);
        return a;
    }
}
