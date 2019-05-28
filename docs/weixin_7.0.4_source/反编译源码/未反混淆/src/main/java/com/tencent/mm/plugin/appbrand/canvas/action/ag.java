package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class ag implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103290);
        SetTextAlignActionArg setTextAlignActionArg = new SetTextAlignActionArg();
        AppMethodBeat.o(103290);
        return setTextAlignActionArg;
    }

    public final String getMethod() {
        return "setTextAlign";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103291);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103291);
            return false;
        }
        boolean b = b(dVar, jSONArray.optString(0));
        AppMethodBeat.o(103291);
        return b;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(103292);
        if ("left".equalsIgnoreCase(str)) {
            dVar.hcE.setTextAlign(Align.LEFT);
            dVar.hcF.setTextAlign(Align.LEFT);
        } else if ("right".equalsIgnoreCase(str)) {
            dVar.hcE.setTextAlign(Align.RIGHT);
            dVar.hcF.setTextAlign(Align.RIGHT);
        } else if ("center".equalsIgnoreCase(str)) {
            dVar.hcE.setTextAlign(Align.CENTER);
            dVar.hcF.setTextAlign(Align.CENTER);
        }
        AppMethodBeat.o(103292);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103293);
        SetTextAlignActionArg setTextAlignActionArg = (SetTextAlignActionArg) drawActionArg;
        if (setTextAlignActionArg == null) {
            AppMethodBeat.o(103293);
            return false;
        }
        boolean b = b(dVar, setTextAlignActionArg.hdq);
        AppMethodBeat.o(103293);
        return b;
    }
}
