package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class kb {
    private DoublePoint a;
    private double b;

    public boolean equals(Object obj) {
        AppMethodBeat.i(100196);
        if ((obj instanceof kb) && ((kb) obj).a.equals(this.a)) {
            AppMethodBeat.o(100196);
            return true;
        }
        AppMethodBeat.o(100196);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.i(100197);
        int hashCode = this.a.hashCode();
        AppMethodBeat.o(100197);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(100198);
        String str = "x:" + this.a.x + ", y:" + this.a.y;
        AppMethodBeat.o(100198);
        return str;
    }

    public kb(jz jzVar, double d) {
        AppMethodBeat.i(100199);
        this.a = new DoublePoint(jzVar.a, jzVar.b);
        this.b = d;
        AppMethodBeat.o(100199);
    }

    public DoublePoint a() {
        return this.a;
    }

    public double b() {
        return this.b;
    }

    public void a(double d) {
        this.b = d;
    }
}
