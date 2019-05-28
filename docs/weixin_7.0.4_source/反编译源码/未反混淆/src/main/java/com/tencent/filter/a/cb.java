package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cb extends BaseFilter {
    public cb() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86535);
        k kVar = new k();
        kVar.a(0.0f, -19.0f, 8.0f, 354.0f, 20.0f, 52.0f, 77.0f);
        setNextFilter(kVar, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/richblue_curve.png", 33986));
        kVar.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.023529412f, -0.007843138f, 0.078431375f};
        float[] fArr2 = new float[]{0.03137255f, 0.0f, 0.0f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{-0.17254902f, -0.039215688f, 0.16470589f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new f("contrast", 0.97f));
        baseFilter.addParam(new f("saturation", 1.0f));
        baseFilter.addParam(new f("brightness", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86535);
    }
}
