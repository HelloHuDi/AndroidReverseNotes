package com.tencent.map.lib.p822gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.map.lib.gl.model.c */
public class C37426c {
    /* renamed from: a */
    private C45136e f16107a;
    /* renamed from: b */
    private C45136e f16108b;
    /* renamed from: c */
    private C45136e f16109c;
    /* renamed from: d */
    private C37427f f16110d;

    public C37426c() {
        AppMethodBeat.m2504i(98144);
        this.f16110d = new C37427f();
        AppMethodBeat.m2505o(98144);
    }

    public C37426c(C45136e c45136e, C45136e c45136e2, C45136e c45136e3) {
        this();
        AppMethodBeat.m2504i(98145);
        m63080a(c45136e, c45136e2, c45136e3);
        AppMethodBeat.m2505o(98145);
    }

    public C37426c(float[] fArr) {
        this();
        AppMethodBeat.m2504i(98146);
        m63080a(new C45136e(fArr[0], fArr[1], fArr[2]), new C45136e(fArr[3], fArr[4], fArr[5]), new C45136e(fArr[6], fArr[7], fArr[8]));
        AppMethodBeat.m2505o(98146);
    }

    /* renamed from: a */
    private void m63080a(C45136e c45136e, C45136e c45136e2, C45136e c45136e3) {
        AppMethodBeat.m2504i(98147);
        this.f16107a = c45136e;
        this.f16108b = c45136e2;
        this.f16109c = c45136e3;
        this.f16110d.mo60291a(c45136e);
        this.f16110d.mo60291a(c45136e2);
        this.f16110d.mo60291a(c45136e3);
        AppMethodBeat.m2505o(98147);
    }

    /* renamed from: a */
    public boolean mo60288a(float[] fArr) {
        AppMethodBeat.m2504i(98148);
        C45136e c45136e = new C45136e(fArr[0], fArr[1], fArr[2]);
        if (((double) Math.abs(m63081b() - ((new C37426c(c45136e, this.f16107a, this.f16108b).m63081b() + new C37426c(c45136e, this.f16107a, this.f16109c).m63081b()) + new C37426c(c45136e, this.f16108b, this.f16109c).m63081b()))) < 0.001d) {
            AppMethodBeat.m2505o(98148);
            return true;
        }
        AppMethodBeat.m2505o(98148);
        return false;
    }

    /* renamed from: a */
    public float[] mo60289a() {
        AppMethodBeat.m2504i(98149);
        float[] a = this.f16110d.mo60292a();
        AppMethodBeat.m2505o(98149);
        return a;
    }

    /* renamed from: b */
    private float m63081b() {
        AppMethodBeat.m2504i(98150);
        float[] a = this.f16110d.mo60292a();
        float a2 = m63079a(a[0], a[1], a[2], a[3], a[4], a[5]);
        float a3 = m63079a(a[3], a[4], a[5], a[6], a[7], a[8]);
        float a4 = m63079a(a[0], a[1], a[2], a[6], a[7], a[8]);
        float f = ((a2 + a3) + a4) / 2.0f;
        a4 = (float) Math.sqrt((double) ((f - a4) * (((f - a2) * f) * (f - a3))));
        AppMethodBeat.m2505o(98150);
        return a4;
    }

    /* renamed from: a */
    private float m63079a(float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.m2504i(98151);
        float sqrt = (float) Math.sqrt((double) ((((f - f4) * (f - f4)) + ((f2 - f5) * (f2 - f5))) + ((f3 - f6) * (f3 - f6))));
        AppMethodBeat.m2505o(98151);
        return sqrt;
    }
}
