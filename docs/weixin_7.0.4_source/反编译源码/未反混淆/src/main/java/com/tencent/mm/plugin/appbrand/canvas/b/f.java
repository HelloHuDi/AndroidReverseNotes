package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg;
import org.json.JSONArray;

public final class f implements a {
    public final String getMethod() {
        return "closePath";
    }

    public final BasePathActionArg ayr() {
        AppMethodBeat.i(103685);
        PathClosePathActionArg pathClosePathActionArg = new PathClosePathActionArg();
        AppMethodBeat.o(103685);
        return pathClosePathActionArg;
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(103683);
        path.close();
        AppMethodBeat.o(103683);
        return true;
    }

    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(103684);
        path.close();
        AppMethodBeat.o(103684);
        return true;
    }
}
