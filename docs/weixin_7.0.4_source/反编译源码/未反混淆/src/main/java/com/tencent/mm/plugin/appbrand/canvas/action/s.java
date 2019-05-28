package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class s implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103238);
        SetFontSizeActionArg setFontSizeActionArg = new SetFontSizeActionArg();
        AppMethodBeat.o(103238);
        return setFontSizeActionArg;
    }

    public final String getMethod() {
        return "setFontSize";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103239);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103239);
            return false;
        }
        boolean a = a(dVar, g.a(jSONArray, 0));
        AppMethodBeat.o(103239);
        return a;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103241);
        SetFontSizeActionArg setFontSizeActionArg = (SetFontSizeActionArg) drawActionArg;
        if (setFontSizeActionArg == null) {
            AppMethodBeat.o(103241);
            return false;
        }
        boolean a = a(dVar, setFontSizeActionArg.size);
        AppMethodBeat.o(103241);
        return a;
    }

    private static boolean a(d dVar, int i) {
        AppMethodBeat.i(103240);
        dVar.hcF.setTextSize((float) i);
        dVar.hcE.setTextSize((float) i);
        AppMethodBeat.o(103240);
        return true;
    }
}
