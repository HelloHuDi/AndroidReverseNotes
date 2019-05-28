package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class m implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103216);
        DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg();
        AppMethodBeat.o(103216);
        return defaultDrawActionArg;
    }

    public final String getMethod() {
        return "restore";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103217);
        boolean a = a(dVar, canvas);
        AppMethodBeat.o(103217);
        return a;
    }

    private static boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103218);
        canvas.restore();
        dVar.restore();
        AppMethodBeat.o(103218);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103219);
        boolean a = a(dVar, canvas);
        AppMethodBeat.o(103219);
        return a;
    }
}
