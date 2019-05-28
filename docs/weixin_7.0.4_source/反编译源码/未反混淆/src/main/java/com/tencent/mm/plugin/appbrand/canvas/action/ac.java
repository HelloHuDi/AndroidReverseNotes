package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class ac implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103275);
        SeMiterLimitActionArg seMiterLimitActionArg = new SeMiterLimitActionArg();
        AppMethodBeat.o(103275);
        return seMiterLimitActionArg;
    }

    public final String getMethod() {
        return "setMiterLimit";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103276);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103276);
            return false;
        }
        boolean a = a(dVar, (float) jSONArray.optDouble(0));
        AppMethodBeat.o(103276);
        return a;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103278);
        SeMiterLimitActionArg seMiterLimitActionArg = (SeMiterLimitActionArg) drawActionArg;
        if (seMiterLimitActionArg == null) {
            AppMethodBeat.o(103278);
            return false;
        }
        boolean a = a(dVar, seMiterLimitActionArg.hdf);
        AppMethodBeat.o(103278);
        return a;
    }

    private static boolean a(d dVar, float f) {
        AppMethodBeat.i(103277);
        dVar.hcF.setStrokeMiter(f);
        dVar.hcE.setStrokeMiter(f);
        AppMethodBeat.o(103277);
        return true;
    }
}
