package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg;
import org.json.JSONArray;

public final class g implements a {
    public final String getMethod() {
        return "lineTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(103686);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(103686);
            return false;
        }
        path.lineTo(com.tencent.mm.plugin.appbrand.r.g.d(jSONArray, 0), com.tencent.mm.plugin.appbrand.r.g.d(jSONArray, 1));
        AppMethodBeat.o(103686);
        return true;
    }

    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(103687);
        PathLineToActionArg pathLineToActionArg = (PathLineToActionArg) basePathActionArg;
        if (pathLineToActionArg == null) {
            AppMethodBeat.o(103687);
            return false;
        }
        path.lineTo(pathLineToActionArg.x, pathLineToActionArg.y);
        AppMethodBeat.o(103687);
        return true;
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.i(103688);
        PathLineToActionArg pathLineToActionArg = new PathLineToActionArg();
        AppMethodBeat.o(103688);
        return pathLineToActionArg;
    }
}
