package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.r.g;

public final class e extends b {
    private static e hdC = new e();

    static {
        AppMethodBeat.i(103640);
        AppMethodBeat.o(103640);
    }

    private e() {
    }

    public static e ayl() {
        return hdC;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(103638);
        aVar.reset();
        aVar.release();
        aVar.setStyle(Style.FILL);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth((float) g.qb(1));
        super.a(aVar);
        AppMethodBeat.o(103638);
    }

    public final a ayi() {
        AppMethodBeat.i(103639);
        a aVar = new a();
        aVar.setStyle(Style.FILL);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth((float) g.qb(1));
        AppMethodBeat.o(103639);
        return aVar;
    }
}
