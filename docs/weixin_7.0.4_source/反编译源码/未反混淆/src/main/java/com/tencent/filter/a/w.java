package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w extends BaseFilter {
    public w() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86472);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.03137255f, -0.015882352f, 0.0f};
        baseFilter.addParam(new g("shadowsShift", new float[]{0.0f, -0.06411765f, 0.03137255f}));
        baseFilter.addParam(new g("midtonesShift", fArr));
        baseFilter.addParam(new g("highlightsShift", fArr2));
        baseFilter.addParam(new i("preserveLuminosity", 1));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKF);
        baseFilter2.addParam(new g("color2", new float[]{0.38039216f, 0.30588236f, 0.4117647f, 1.0f}));
        baseFilter2.addParam(new f("transparency", 0.3f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/fen.png", 33986));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKG);
        fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr3 = new float[]{0.018431371f, 0.0f, -0.037254903f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new g("midtonesShift", fArr2));
        baseFilter2.addParam(new g("highlightsShift", fArr3));
        baseFilter2.addParam(new i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86472);
    }
}
