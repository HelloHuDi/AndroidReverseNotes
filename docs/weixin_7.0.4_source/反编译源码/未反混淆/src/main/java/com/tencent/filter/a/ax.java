package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax extends BaseFilter {
    public ax() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86505);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKI);
        baseFilter.addParam(new g("color2", new float[]{0.3882353f, 0.9490196f, 0.99607843f, 1.0f}));
        baseFilter.addParam(new f("transparency", 0.18f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.0627451f, -0.007843138f, 0.03137255f};
        float[] fArr2 = new float[]{0.0f, -0.039215688f, 0.03137255f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{-0.039215688f, -0.047058824f, 0.03137255f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bKD);
        baseFilter3.addParam(new o("inputImageTexture2", "sh/lolly_curve.png", 33986));
        baseFilter2.setNextFilter(baseFilter3, null);
        k kVar = new k();
        kVar.a(7.0f, 30.0f, 0.0f, 306.0f, 336.0f, 6.0f, 36.0f);
        baseFilter3.setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(-14.0f, 24.0f, 0.0f, 169.0f, 180.0f, 229.0f, 259.0f);
        kVar.setNextFilter(kVar2, null);
        kVar = new k();
        kVar.a(0.0f, 30.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        kVar2.setNextFilter(kVar, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86505);
    }
}
