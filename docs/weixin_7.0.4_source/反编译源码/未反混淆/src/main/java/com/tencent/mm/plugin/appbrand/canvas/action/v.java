package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;
import org.json.JSONException;

public final class v implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103250);
        SetGlobalAlphaActionArg setGlobalAlphaActionArg = new SetGlobalAlphaActionArg();
        AppMethodBeat.o(103250);
        return setGlobalAlphaActionArg;
    }

    public final String getMethod() {
        return "setGlobalAlpha";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.i(103251);
        try {
            z = a(dVar, jSONArray.getInt(0));
            AppMethodBeat.o(103251);
            return z;
        } catch (JSONException e) {
            com.tencent.luggage.g.d.e("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", e);
            AppMethodBeat.o(103251);
            return z;
        }
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103253);
        SetGlobalAlphaActionArg setGlobalAlphaActionArg = (SetGlobalAlphaActionArg) drawActionArg;
        if (setGlobalAlphaActionArg == null) {
            AppMethodBeat.o(103253);
            return false;
        }
        boolean a = a(dVar, setGlobalAlphaActionArg.alpha);
        AppMethodBeat.o(103253);
        return a;
    }

    private static boolean a(d dVar, int i) {
        AppMethodBeat.i(103252);
        dVar.hcE.ai(((float) i) / 255.0f);
        dVar.hcF.ai(((float) i) / 255.0f);
        AppMethodBeat.o(103252);
        return true;
    }
}
