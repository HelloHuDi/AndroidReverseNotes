package com.tencent.map.lib.gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d {
    private float a;
    private float b;
    private float c;

    public d(float f, float f2, float f3) {
        AppMethodBeat.i(98152);
        this.a = f;
        this.b = f2;
        this.c = f3;
        c();
        AppMethodBeat.o(98152);
    }

    public float[] a() {
        return new float[]{this.a, this.b, this.c};
    }

    public double b() {
        AppMethodBeat.i(98153);
        double sqrt = Math.sqrt((double) (((this.a * this.a) + (this.b * this.b)) + (this.c * this.c)));
        AppMethodBeat.o(98153);
        return sqrt;
    }

    private void c() {
        AppMethodBeat.i(98154);
        double b = b();
        if (b == 0.0d) {
            AppMethodBeat.o(98154);
            return;
        }
        this.a = (float) (((double) this.a) / b);
        this.b = (float) (((double) this.b) / b);
        this.c = (float) (((double) this.c) / b);
        AppMethodBeat.o(98154);
    }

    public String toString() {
        AppMethodBeat.i(98155);
        String str = this.a + "," + this.b + "," + this.c;
        AppMethodBeat.o(98155);
        return str;
    }
}
