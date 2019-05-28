package com.tencent.map.lib.p822gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.map.lib.gl.model.d */
public class C41720d {
    /* renamed from: a */
    private float f17158a;
    /* renamed from: b */
    private float f17159b;
    /* renamed from: c */
    private float f17160c;

    public C41720d(float f, float f2, float f3) {
        AppMethodBeat.m2504i(98152);
        this.f17158a = f;
        this.f17159b = f2;
        this.f17160c = f3;
        m73433c();
        AppMethodBeat.m2505o(98152);
    }

    /* renamed from: a */
    public float[] mo67460a() {
        return new float[]{this.f17158a, this.f17159b, this.f17160c};
    }

    /* renamed from: b */
    public double mo67461b() {
        AppMethodBeat.m2504i(98153);
        double sqrt = Math.sqrt((double) (((this.f17158a * this.f17158a) + (this.f17159b * this.f17159b)) + (this.f17160c * this.f17160c)));
        AppMethodBeat.m2505o(98153);
        return sqrt;
    }

    /* renamed from: c */
    private void m73433c() {
        AppMethodBeat.m2504i(98154);
        double b = mo67461b();
        if (b == 0.0d) {
            AppMethodBeat.m2505o(98154);
            return;
        }
        this.f17158a = (float) (((double) this.f17158a) / b);
        this.f17159b = (float) (((double) this.f17159b) / b);
        this.f17160c = (float) (((double) this.f17160c) / b);
        AppMethodBeat.m2505o(98154);
    }

    public String toString() {
        AppMethodBeat.m2504i(98155);
        String str = this.f17158a + "," + this.f17159b + "," + this.f17160c;
        AppMethodBeat.m2505o(98155);
        return str;
    }
}
