package com.tencent.filter;

import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.k */
public final class C44677k extends BaseFilter {
    float bMH = 0.5f;
    float bMI = 0.5f;
    float bMJ = 0.5f;
    float bMK = -1.0f;
    float bML = -1.0f;
    float bMM = -1.0f;
    float bMN = -1.0f;
    int bMO = -1;

    public C44677k() {
        super(GLSLRender.bMe);
    }

    /* renamed from: a */
    public final void mo71704a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        int i;
        AppMethodBeat.m2504i(86383);
        this.bMK = f4 / 360.0f;
        this.bML = f5 / 360.0f;
        this.bMM = f6 / 360.0f;
        this.bMN = f7 / 360.0f;
        this.bMH = (f / 180.0f) * 0.5f;
        this.bMI = f2 / 100.0f;
        this.bMJ = f3 / 100.0f;
        double d = (double) f4;
        double d2 = (double) f5;
        double d3 = (double) f6;
        double d4 = (double) f7;
        if (d < d2 && d2 < d3 && d3 < d4) {
            i = 0;
        } else if (d < d2 && d3 < d4 && d > d4) {
            i = 1;
        } else if (d > d4 && d2 < d3 && d3 < d4) {
            i = 2;
        } else if (d >= d2 || d2 >= d3 || d <= d4 || (d == 303.0d && d2 == 323.0d)) {
            i = -1;
        } else {
            i = 3;
        }
        this.bMO = i;
        addParam(new C0933f("fh", this.bMH));
        addParam(new C0933f("fs", this.bMI));
        addParam(new C0933f("fv", this.bMJ));
        addParam(new C0933f("flb", this.bMK));
        addParam(new C0933f("fld", this.bML));
        addParam(new C0933f("frd", this.bMM));
        addParam(new C0933f("frb", this.bMN));
        addParam(new C0935i("channelflag", this.bMO));
        this.glsl_programID = GLSLRender.bMe;
        AppMethodBeat.m2505o(86383);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86384);
        switch (this.bMO) {
            case 0:
                this.glsl_programID = GLSLRender.bMa;
                break;
            case 1:
                this.glsl_programID = GLSLRender.bMb;
                break;
            case 2:
                this.glsl_programID = GLSLRender.bMc;
                break;
            case 3:
                this.glsl_programID = GLSLRender.bMd;
                break;
            default:
                this.glsl_programID = GLSLRender.bMe;
                break;
        }
        addParam(new C0933f("fh", this.bMH));
        addParam(new C0933f("fs", this.bMI));
        addParam(new C0933f("fv", this.bMJ));
        addParam(new C0933f("flb", this.bMK));
        addParam(new C0933f("fld", this.bML));
        addParam(new C0933f("frd", this.bMM));
        addParam(new C0933f("frb", this.bMN));
        addParam(new C0935i("channelflag", this.bMO));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86384);
    }
}
