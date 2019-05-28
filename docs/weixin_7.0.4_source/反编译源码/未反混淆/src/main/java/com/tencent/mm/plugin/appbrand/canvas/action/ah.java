package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class ah implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103294);
        SetTextBaseLineActionArg setTextBaseLineActionArg = new SetTextBaseLineActionArg();
        AppMethodBeat.o(103294);
        return setTextBaseLineActionArg;
    }

    public final String getMethod() {
        return "setTextBaseline";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103295);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103295);
            return false;
        }
        boolean b = b(dVar, jSONArray.optString(0));
        AppMethodBeat.o(103295);
        return b;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(103296);
        com.tencent.luggage.g.d.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", str);
        if ("top".equalsIgnoreCase(str)) {
            dVar.hcE.hdH = a.TOP;
            dVar.hcF.hdH = a.TOP;
        } else if ("middle".equalsIgnoreCase(str)) {
            dVar.hcE.hdH = a.MIDDLE;
            dVar.hcF.hdH = a.MIDDLE;
        } else if ("bottom".equalsIgnoreCase(str)) {
            dVar.hcE.hdH = a.BOTTOM;
            dVar.hcF.hdH = a.BOTTOM;
        } else if ("normal".equalsIgnoreCase(str)) {
            dVar.hcE.hdH = a.NORMAL;
            dVar.hcF.hdH = a.NORMAL;
        }
        AppMethodBeat.o(103296);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103297);
        SetTextBaseLineActionArg setTextBaseLineActionArg = (SetTextBaseLineActionArg) drawActionArg;
        if (setTextBaseLineActionArg == null) {
            AppMethodBeat.o(103297);
            return false;
        }
        boolean b = b(dVar, setTextBaseLineActionArg.hdq);
        AppMethodBeat.o(103297);
        return b;
    }
}
