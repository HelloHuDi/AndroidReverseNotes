package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai {
    private ce a;

    ai(ce ceVar) {
        this.a = ceVar;
    }

    /* Access modifiers changed, original: final */
    public final void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public final db a(Point point) {
        AppMethodBeat.i(98307);
        db a = this.a.a(point);
        AppMethodBeat.o(98307);
        return a;
    }

    public final Point a(db dbVar) {
        AppMethodBeat.i(98308);
        Point a = this.a.a(dbVar);
        AppMethodBeat.o(98308);
        return a;
    }

    public final double a(double d) {
        AppMethodBeat.i(98309);
        double a = this.a.a(d);
        AppMethodBeat.o(98309);
        return a;
    }

    public final do b() {
        AppMethodBeat.i(98310);
        do e = this.a.e();
        AppMethodBeat.o(98310);
        return e;
    }
}
