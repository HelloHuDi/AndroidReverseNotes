package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class h implements a {
    public final String getMethod() {
        return "moveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(103689);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(103689);
            return false;
        }
        path.moveTo(g.d(jSONArray, 0), g.d(jSONArray, 1));
        AppMethodBeat.o(103689);
        return true;
    }

    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(103690);
        PathMoveToActionArg pathMoveToActionArg = (PathMoveToActionArg) basePathActionArg;
        if (pathMoveToActionArg == null) {
            AppMethodBeat.o(103690);
            return false;
        }
        path.moveTo(pathMoveToActionArg.x, pathMoveToActionArg.y);
        AppMethodBeat.o(103690);
        return true;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.i(103691);
        PathMoveToActionArg pathMoveToActionArg = new PathMoveToActionArg();
        AppMethodBeat.o(103691);
        return pathMoveToActionArg;
    }
}
