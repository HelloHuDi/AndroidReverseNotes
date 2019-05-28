package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class kx implements kt {
    private final ky a;

    protected kx(float f, float f2) {
        AppMethodBeat.i(100272);
        this.a = ky.a(f, f2, f, f2);
        AppMethodBeat.o(100272);
    }

    public static kx a(double d, double d2) {
        AppMethodBeat.i(100273);
        kx kxVar = new kx((float) d, (float) d2);
        AppMethodBeat.o(100273);
        return kxVar;
    }

    public final ky a() {
        return this.a;
    }

    public final boolean a(ky kyVar) {
        AppMethodBeat.i(100274);
        boolean a = this.a.a(kyVar);
        AppMethodBeat.o(100274);
        return a;
    }

    public final float b() {
        AppMethodBeat.i(100275);
        float c = this.a.c();
        AppMethodBeat.o(100275);
        return c;
    }

    public final float c() {
        AppMethodBeat.i(100276);
        float d = this.a.d();
        AppMethodBeat.o(100276);
        return d;
    }

    public final int hashCode() {
        AppMethodBeat.i(100277);
        int hashCode = Arrays.hashCode(new Object[]{this.a});
        AppMethodBeat.o(100277);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100278);
        if (obj == null) {
            AppMethodBeat.o(100278);
            return false;
        } else if (obj instanceof kx) {
            kx kxVar = (kx) obj;
            if (this.a == kxVar.a() || (this.a != null && this.a.equals(kxVar.a()))) {
                AppMethodBeat.o(100278);
                return true;
            }
            AppMethodBeat.o(100278);
            return false;
        } else {
            AppMethodBeat.o(100278);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(100279);
        String str = "Point [x=" + b() + ", y=" + c() + "]";
        AppMethodBeat.o(100279);
        return str;
    }
}
