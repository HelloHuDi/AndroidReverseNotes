package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Join;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class aa implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103267);
        SetLineJoinActionArg setLineJoinActionArg = new SetLineJoinActionArg();
        AppMethodBeat.o(103267);
        return setLineJoinActionArg;
    }

    public final String getMethod() {
        return "setLineJoin";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103268);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103268);
            return false;
        }
        boolean b = b(dVar, jSONArray.optString(0));
        AppMethodBeat.o(103268);
        return b;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(103269);
        if ("miter".equalsIgnoreCase(str)) {
            dVar.hcF.setStrokeJoin(Join.MITER);
            dVar.hcE.setStrokeJoin(Join.MITER);
        } else if ("round".equalsIgnoreCase(str)) {
            dVar.hcF.setStrokeJoin(Join.ROUND);
            dVar.hcE.setStrokeJoin(Join.ROUND);
        } else if ("bevel".equalsIgnoreCase(str)) {
            dVar.hcF.setStrokeJoin(Join.BEVEL);
            dVar.hcE.setStrokeJoin(Join.BEVEL);
        }
        AppMethodBeat.o(103269);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103270);
        SetLineJoinActionArg setLineJoinActionArg = (SetLineJoinActionArg) drawActionArg;
        if (setLineJoinActionArg == null) {
            AppMethodBeat.o(103270);
            return false;
        }
        boolean b = b(dVar, setLineJoinActionArg.hdm);
        AppMethodBeat.o(103270);
        return b;
    }
}
