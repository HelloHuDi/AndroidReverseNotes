package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.r.g;

public final class i extends b {
    public static final i hdG = new i();

    static {
        AppMethodBeat.i(103649);
        AppMethodBeat.o(103649);
    }

    public static i ayp() {
        return hdG;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(103647);
        aVar.reset();
        aVar.release();
        aVar.setStyle(Style.STROKE);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth((float) g.qb(1));
        super.a(aVar);
        AppMethodBeat.o(103647);
    }

    public final a ayi() {
        AppMethodBeat.i(103648);
        a aVar = new a();
        aVar.setStyle(Style.STROKE);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth((float) g.qb(1));
        AppMethodBeat.o(103648);
        return aVar;
    }
}
