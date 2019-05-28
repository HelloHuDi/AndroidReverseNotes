package com.tencent.map.lib.gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class c {
    private e a;
    private e b;
    private e c;
    private f d;

    public c() {
        AppMethodBeat.i(98144);
        this.d = new f();
        AppMethodBeat.o(98144);
    }

    public c(e eVar, e eVar2, e eVar3) {
        this();
        AppMethodBeat.i(98145);
        a(eVar, eVar2, eVar3);
        AppMethodBeat.o(98145);
    }

    public c(float[] fArr) {
        this();
        AppMethodBeat.i(98146);
        a(new e(fArr[0], fArr[1], fArr[2]), new e(fArr[3], fArr[4], fArr[5]), new e(fArr[6], fArr[7], fArr[8]));
        AppMethodBeat.o(98146);
    }

    private void a(e eVar, e eVar2, e eVar3) {
        AppMethodBeat.i(98147);
        this.a = eVar;
        this.b = eVar2;
        this.c = eVar3;
        this.d.a(eVar);
        this.d.a(eVar2);
        this.d.a(eVar3);
        AppMethodBeat.o(98147);
    }

    public boolean a(float[] fArr) {
        AppMethodBeat.i(98148);
        e eVar = new e(fArr[0], fArr[1], fArr[2]);
        if (((double) Math.abs(b() - ((new c(eVar, this.a, this.b).b() + new c(eVar, this.a, this.c).b()) + new c(eVar, this.b, this.c).b()))) < 0.001d) {
            AppMethodBeat.o(98148);
            return true;
        }
        AppMethodBeat.o(98148);
        return false;
    }

    public float[] a() {
        AppMethodBeat.i(98149);
        float[] a = this.d.a();
        AppMethodBeat.o(98149);
        return a;
    }

    private float b() {
        AppMethodBeat.i(98150);
        float[] a = this.d.a();
        float a2 = a(a[0], a[1], a[2], a[3], a[4], a[5]);
        float a3 = a(a[3], a[4], a[5], a[6], a[7], a[8]);
        float a4 = a(a[0], a[1], a[2], a[6], a[7], a[8]);
        float f = ((a2 + a3) + a4) / 2.0f;
        a4 = (float) Math.sqrt((double) ((f - a4) * (((f - a2) * f) * (f - a3))));
        AppMethodBeat.o(98150);
        return a4;
    }

    private float a(float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.i(98151);
        float sqrt = (float) Math.sqrt((double) ((((f - f4) * (f - f4)) + ((f2 - f5) * (f2 - f5))) + ((f3 - f6) * (f3 - f6))));
        AppMethodBeat.o(98151);
        return sqrt;
    }
}
