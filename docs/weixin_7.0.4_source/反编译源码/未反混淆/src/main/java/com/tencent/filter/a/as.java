package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as extends BaseFilter {
    public as() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86500);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKE);
        baseFilter.addParam(new f("scaleC", -0.549f));
        baseFilter.addParam(new f("scaleT", 0.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKM);
        baseFilter2.addParam(new g("color2", new float[]{0.5921569f, 0.7647059f, 0.8392157f, 1.0f}));
        baseFilter2.addParam(new f("transparency", 0.58f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLE);
        baseFilter.addParam(new o("inputImageTexture2", "sh/lan_curve1.png", 33986));
        baseFilter.addParam(new o("inputImageTexture3", "sh/lan_curve1mask.png", 33987));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/lan_curve2.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        baseFilter.addParam(new g("shadowsShift", new float[]{-0.019607844f, 0.0f, 0.019607844f}));
        baseFilter.addParam(new g("midtonesShift", fArr));
        baseFilter.addParam(new g("highlightsShift", fArr2));
        baseFilter.addParam(new i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86500);
    }
}
