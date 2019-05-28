package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import com.tencent.mm.plugin.appbrand.canvas.b.e.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class g implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103192);
        PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper();
        AppMethodBeat.o(103192);
        return pathActionArgWrapper;
    }

    public final String getMethod() {
        return "strokePath";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103193);
        boolean a = a(dVar, canvas, a.hdT.g(jSONArray));
        AppMethodBeat.o(103193);
        return a;
    }

    private static boolean a(d dVar, Canvas canvas, Path path) {
        AppMethodBeat.i(103194);
        canvas.drawPath(path, dVar.hcE);
        AppMethodBeat.o(103194);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103195);
        boolean a = a(dVar, canvas, a.hdT.a((PathActionArgWrapper) drawActionArg));
        AppMethodBeat.o(103195);
        return a;
    }
}
