package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bj extends BaseFilter {
    public bj() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86517);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bLE);
        baseFilter.addParam(new o("inputImageTexture2", "sh/nextdoor_center_curve.png", 33986));
        baseFilter.addParam(new o("inputImageTexture3", "sh/nextdoor_center_curve_mask.png", 33987));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLE);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/nextdoor_edge_curve.png", 33986));
        baseFilter2.addParam(new o("inputImageTexture3", "sh/nextdoor_edge_curve_mask.png", 33987));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, -0.08627451f, 0.0f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        baseFilter.addParam(new g("shadowsShift", new float[]{0.0f, -0.05490196f, 0.101960786f}));
        baseFilter.addParam(new g("midtonesShift", fArr));
        baseFilter.addParam(new g("highlightsShift", fArr2));
        baseFilter.addParam(new i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bKI);
        baseFilter3.addParam(new g("color2", new float[]{0.99215686f, 0.84705883f, 0.6392157f, 1.0f}));
        baseFilter3.addParam(new f("transparency", 0.3f));
        baseFilter.setNextFilter(baseFilter3, null);
        k kVar = new k();
        kVar.a(1.0f, 20.0f, 0.0f, 335.0f, 352.0f, 16.0f, 28.0f);
        baseFilter3.setNextFilter(kVar, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new f("contrast", 1.1f));
        baseFilter.addParam(new f("saturation", 1.0f));
        baseFilter.addParam(new f("brightness", 1.0f));
        kVar.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86517);
    }
}
