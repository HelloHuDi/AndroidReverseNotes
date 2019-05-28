package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class o implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103224);
        DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg();
        AppMethodBeat.o(103224);
        return defaultDrawActionArg;
    }

    public final String getMethod() {
        return "save";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103225);
        boolean a = a(dVar, canvas);
        AppMethodBeat.o(103225);
        return a;
    }

    private static boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103226);
        canvas.save();
        dVar.save();
        AppMethodBeat.o(103226);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103227);
        boolean a = a(dVar, canvas);
        AppMethodBeat.o(103227);
        return a;
    }
}
