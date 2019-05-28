package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class j implements a {
    public final String getMethod() {
        return "rect";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(103696);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(103696);
            return false;
        }
        boolean a = a(path, g.d(jSONArray, 0), g.d(jSONArray, 1), g.d(jSONArray, 2), g.d(jSONArray, 3));
        AppMethodBeat.o(103696);
        return a;
    }

    private static boolean a(Path path, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(103697);
        path.addRect(f, f2, f + f3, f2 + f4, Direction.CW);
        AppMethodBeat.o(103697);
        return true;
    }

    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(103698);
        PathRectActionArg pathRectActionArg = (PathRectActionArg) basePathActionArg;
        if (pathRectActionArg == null) {
            AppMethodBeat.o(103698);
            return false;
        }
        boolean a = a(path, pathRectActionArg.x, pathRectActionArg.y, pathRectActionArg.width, pathRectActionArg.height);
        AppMethodBeat.o(103698);
        return a;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.i(103699);
        PathRectActionArg pathRectActionArg = new PathRectActionArg();
        AppMethodBeat.o(103699);
        return pathRectActionArg;
    }
}
