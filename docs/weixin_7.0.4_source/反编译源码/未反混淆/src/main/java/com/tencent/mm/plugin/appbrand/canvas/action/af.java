package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class af implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103287);
        SetStrokeStyleActionArg setStrokeStyleActionArg = new SetStrokeStyleActionArg();
        AppMethodBeat.o(103287);
        return setStrokeStyleActionArg;
    }

    public final String getMethod() {
        return "setStrokeStyle";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103288);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(103288);
            return false;
        }
        String optString = jSONArray.optString(0);
        JSONArray optJSONArray;
        float d;
        float d2;
        float d3;
        JSONArray optJSONArray2;
        int i;
        if ("linear".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                AppMethodBeat.o(103288);
                return false;
            }
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                AppMethodBeat.o(103288);
                return false;
            }
            d = g.d(optJSONArray, 0);
            d2 = g.d(optJSONArray, 1);
            d3 = g.d(optJSONArray, 2);
            float d4 = g.d(optJSONArray, 3);
            optJSONArray2 = jSONArray.optJSONArray(2);
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                AppMethodBeat.o(103288);
                return false;
            }
            int[] iArr = new int[optJSONArray2.length()];
            float[] fArr = new float[optJSONArray2.length()];
            for (i = 0; i < optJSONArray2.length(); i++) {
                JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i);
                if (optJSONArray3.length() >= 2) {
                    fArr[i] = (float) optJSONArray3.optDouble(0);
                    iArr[i] = g.n(optJSONArray3.optJSONArray(1));
                }
            }
            dVar.hcE.setShader(new LinearGradient(d, d2, d3, d4, iArr, fArr, TileMode.CLAMP));
        } else if ("radial".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                AppMethodBeat.o(103288);
                return false;
            }
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 3) {
                AppMethodBeat.o(103288);
                return false;
            }
            d = g.d(optJSONArray, 1);
            d2 = g.d(optJSONArray, 2);
            d3 = g.d(optJSONArray, 3);
            JSONArray optJSONArray4 = jSONArray.optJSONArray(2);
            int[] iArr2 = new int[optJSONArray4.length()];
            float[] fArr2 = new float[optJSONArray4.length()];
            for (i = 0; i < optJSONArray4.length(); i++) {
                optJSONArray2 = optJSONArray4.optJSONArray(i);
                if (optJSONArray2.length() >= 2) {
                    fArr2[i] = (float) optJSONArray2.optDouble(0);
                    iArr2[i] = g.n(optJSONArray2.optJSONArray(1));
                }
            }
            dVar.hcE.setShader(new RadialGradient(d, d2, d3, iArr2, fArr2, TileMode.CLAMP));
        } else if ("normal".equalsIgnoreCase(optString)) {
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                AppMethodBeat.o(103288);
                return false;
            }
            dVar.hcE.setColor(g.n(optJSONArray));
        }
        AppMethodBeat.o(103288);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103289);
        SetStrokeStyleActionArg setStrokeStyleActionArg = (SetStrokeStyleActionArg) drawActionArg;
        if (setStrokeStyleActionArg == null) {
            AppMethodBeat.o(103289);
            return false;
        }
        boolean a = setStrokeStyleActionArg.a(dVar, canvas);
        AppMethodBeat.o(103289);
        return a;
    }
}
