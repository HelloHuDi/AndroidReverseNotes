package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONException;

public final class y implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103262);
        SetLineDashActionArg setLineDashActionArg = new SetLineDashActionArg();
        AppMethodBeat.o(103262);
        return setLineDashActionArg;
    }

    public final String getMethod() {
        return "setLineDash";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103263);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(103263);
            return false;
        }
        try {
            JSONArray jSONArray2 = jSONArray.getJSONArray(0);
            if (jSONArray2 == null) {
                AppMethodBeat.o(103263);
                return false;
            }
            float[] fArr = new float[jSONArray2.length()];
            for (int i = 0; i < fArr.length; i++) {
                fArr[i] = g.d(jSONArray2, i);
            }
            boolean a = a(dVar, fArr, g.d(jSONArray, 1));
            AppMethodBeat.o(103263);
            return a;
        } catch (JSONException e) {
            AppMethodBeat.o(103263);
            return false;
        }
    }

    private static boolean a(d dVar, float[] fArr, float f) {
        AppMethodBeat.i(103264);
        if (!(fArr == null || f == Float.MIN_VALUE)) {
            dVar.hcE.setPathEffect(new DashPathEffect(fArr, f));
        }
        AppMethodBeat.o(103264);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103265);
        SetLineDashActionArg setLineDashActionArg = (SetLineDashActionArg) drawActionArg;
        if (setLineDashActionArg == null) {
            AppMethodBeat.o(103265);
            return false;
        }
        boolean a = a(dVar, setLineDashActionArg.hdk, setLineDashActionArg.hdl);
        AppMethodBeat.o(103265);
        return a;
    }
}
