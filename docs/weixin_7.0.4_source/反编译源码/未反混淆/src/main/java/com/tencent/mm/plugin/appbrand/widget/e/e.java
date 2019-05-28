package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public final double x;
    public final double y;

    public e(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.x == ((e) obj).x && this.y == ((e) obj).y;
        } else {
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(51275);
        String str = "Point{x=" + this.x + ", y=" + this.y + '}';
        AppMethodBeat.o(51275);
        return str;
    }
}
