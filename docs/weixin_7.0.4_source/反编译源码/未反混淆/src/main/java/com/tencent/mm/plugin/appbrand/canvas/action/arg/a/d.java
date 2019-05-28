package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.c;

public final class d {
    private static d hdB = new d();
    public c<DrawActionWrapper> hdA = new c(500);
    public c<DrawCanvasArg> hdz = new c(5);

    static {
        AppMethodBeat.i(103637);
        AppMethodBeat.o(103637);
    }

    private d() {
        AppMethodBeat.i(103636);
        AppMethodBeat.o(103636);
    }

    public static d ayk() {
        return hdB;
    }
}
