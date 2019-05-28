package com.tencent.map.lib.basemap.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b implements Cloneable {
    private double a = Double.MIN_VALUE;
    private double b = Double.MIN_VALUE;

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(97858);
        b c = c();
        AppMethodBeat.o(97858);
        return c;
    }

    public String toString() {
        AppMethodBeat.i(97851);
        String str = "x=" + this.b + ",y=" + this.a;
        AppMethodBeat.o(97851);
        return str;
    }

    public b(double d, double d2) {
        AppMethodBeat.i(97852);
        b(d);
        a(d2);
        AppMethodBeat.o(97852);
    }

    public double a() {
        return this.a;
    }

    public void a(double d) {
        AppMethodBeat.i(97853);
        this.a = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d));
        AppMethodBeat.o(97853);
    }

    public double b() {
        return this.b;
    }

    public void b(double d) {
        AppMethodBeat.i(97854);
        this.b = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d));
        AppMethodBeat.o(97854);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(97855);
        if (obj == this) {
            AppMethodBeat.o(97855);
            return true;
        } else if (obj.hashCode() != hashCode()) {
            AppMethodBeat.o(97855);
            return false;
        } else if (obj instanceof b) {
            b bVar = (b) obj;
            if (Double.doubleToLongBits(bVar.b) == Double.doubleToLongBits(this.b) && Double.doubleToLongBits(bVar.a) == Double.doubleToLongBits(this.a)) {
                AppMethodBeat.o(97855);
                return true;
            }
            AppMethodBeat.o(97855);
            return false;
        } else {
            AppMethodBeat.o(97855);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(97856);
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + ((((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32))) + 31) * 31);
        AppMethodBeat.o(97856);
        return i;
    }

    public b c() {
        AppMethodBeat.i(97857);
        b bVar = new b(this.b, this.a);
        AppMethodBeat.o(97857);
        return bVar;
    }
}
