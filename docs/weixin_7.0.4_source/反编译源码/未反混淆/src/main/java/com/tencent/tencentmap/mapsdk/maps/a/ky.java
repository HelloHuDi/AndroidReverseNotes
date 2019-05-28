package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class ky implements kt, kv {
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    protected ky(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(100280);
        this.a = Math.min(f, f3);
        this.b = Math.min(f2, f4);
        this.c = Math.max(f, f3);
        this.d = Math.max(f2, f4);
        AppMethodBeat.o(100280);
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public final float e() {
        return this.c;
    }

    public final float f() {
        return this.d;
    }

    public final float g() {
        return (this.c - this.a) * (this.d - this.b);
    }

    public final ky b(ky kyVar) {
        AppMethodBeat.i(100281);
        ky kyVar2 = new ky(Math.min(this.a, kyVar.a), Math.min(this.b, kyVar.b), Math.max(this.c, kyVar.c), Math.max(this.d, kyVar.d));
        AppMethodBeat.o(100281);
        return kyVar2;
    }

    public static ky a(double d, double d2, double d3, double d4) {
        AppMethodBeat.i(100282);
        ky kyVar = new ky((float) d, (float) d2, (float) d3, (float) d4);
        AppMethodBeat.o(100282);
        return kyVar;
    }

    public static ky a(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(100283);
        ky kyVar = new ky(f, f2, f3, f4);
        AppMethodBeat.o(100283);
        return kyVar;
    }

    public final boolean a(ky kyVar) {
        AppMethodBeat.i(100284);
        if (Math.min(this.c, kyVar.c) < Math.max(this.a, kyVar.a)) {
            AppMethodBeat.o(100284);
            return false;
        }
        if (Math.min(this.d, kyVar.d) >= Math.max(this.b, kyVar.b)) {
            AppMethodBeat.o(100284);
            return true;
        }
        AppMethodBeat.o(100284);
        return false;
    }

    public final ky a() {
        return this;
    }

    public final String toString() {
        AppMethodBeat.i(100285);
        String str = "Rectangle [x1=" + this.a + ", y1=" + this.b + ", x2=" + this.c + ", y2=" + this.d + "]";
        AppMethodBeat.o(100285);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.i(100286);
        int hashCode = Arrays.hashCode(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d)});
        AppMethodBeat.o(100286);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100287);
        if (obj == null) {
            AppMethodBeat.o(100287);
            return false;
        } else if (obj instanceof ky) {
            ky kyVar = (ky) obj;
            if (a(this.a, kyVar.a) && a(this.c, kyVar.c) && a(this.b, kyVar.b) && a(this.d, kyVar.d)) {
                AppMethodBeat.o(100287);
                return true;
            }
            AppMethodBeat.o(100287);
            return false;
        } else {
            AppMethodBeat.o(100287);
            return false;
        }
    }

    private boolean a(float f, float f2) {
        AppMethodBeat.i(100288);
        if (Float.floatToIntBits(f) == Float.floatToIntBits(f2)) {
            AppMethodBeat.o(100288);
            return true;
        }
        AppMethodBeat.o(100288);
        return false;
    }

    public final float c(ky kyVar) {
        AppMethodBeat.i(100289);
        if (a(kyVar)) {
            float g = a(Math.max(this.a, kyVar.a), Math.max(this.b, kyVar.b), Math.min(this.c, kyVar.c), Math.min(this.d, kyVar.d)).g();
            AppMethodBeat.o(100289);
            return g;
        }
        AppMethodBeat.o(100289);
        return 0.0f;
    }

    public final float h() {
        return ((this.c - this.a) * 2.0f) + ((this.d - this.b) * 2.0f);
    }

    public final kt b() {
        return this;
    }
}
