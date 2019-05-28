package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONException;

public final class ai implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103298);
        SetTransformActionArg setTransformActionArg = new SetTransformActionArg();
        AppMethodBeat.o(103298);
        return setTransformActionArg;
    }

    public final String getMethod() {
        return "setTransform";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103299);
        if (jSONArray.length() < 6) {
            AppMethodBeat.o(103299);
            return false;
        }
        try {
            boolean a = a(canvas, (float) jSONArray.getDouble(0), (float) jSONArray.getDouble(1), (float) jSONArray.getDouble(2), (float) jSONArray.getDouble(3), g.c(jSONArray, 4), g.c(jSONArray, 5));
            AppMethodBeat.o(103299);
            return a;
        } catch (JSONException e) {
            AppMethodBeat.o(103299);
            return false;
        }
    }

    private static boolean a(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.i(103300);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setValues(new float[]{f, f3, f5, f2, f4, f6, 0.0f, 0.0f, 1.0f});
        canvas.setMatrix(matrix);
        AppMethodBeat.o(103300);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103301);
        SetTransformActionArg setTransformActionArg = (SetTransformActionArg) drawActionArg;
        if (setTransformActionArg == null) {
            AppMethodBeat.o(103301);
            return false;
        }
        boolean a = a(canvas, setTransformActionArg.scaleX, setTransformActionArg.hdr, setTransformActionArg.hds, setTransformActionArg.scaleY, setTransformActionArg.translateX, setTransformActionArg.translateY);
        AppMethodBeat.o(103301);
        return a;
    }
}
