package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import com.tencent.mm.plugin.appbrand.canvas.b.e.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class c implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103179);
        PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper();
        AppMethodBeat.o(103179);
        return pathActionArgWrapper;
    }

    public final String getMethod() {
        return "clipPath";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103180);
        canvas.clipPath(a.hdT.g(jSONArray));
        AppMethodBeat.o(103180);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103181);
        canvas.clipPath(a.hdT.a((PathActionArgWrapper) drawActionArg));
        AppMethodBeat.o(103181);
        return true;
    }
}
