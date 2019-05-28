package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.l;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r extends BaseFilter {
    float param = 1.0f;

    public r() {
        super(GLSLRender.bJB);
    }

    public final void setAdjustParam(float f) {
        this.param = f;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86458);
        if (z) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86458);
            return;
        }
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        float min = Math.min(f2, f);
        baseFilter.scaleFact = Math.min(200.0f / min, 1.0f);
        setNextFilter(baseFilter, null);
        int theFilterIndex = getTheFilterIndex(baseFilter) - 1;
        l lVar = new l();
        baseFilter.setNextFilter(lVar, new int[]{theFilterIndex + (this.srcTextureIndex + 1)});
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new f("contrast", 0.96f));
        baseFilter.addParam(new f("saturation", 0.766f));
        baseFilter.addParam(new f("brightness", 1.0f));
        lVar.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKd);
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bMn, GLSLRender.bKi);
        baseFilter.addParam(new f("sharpness", 0.377f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bJB);
        baseFilter2.scaleFact = Math.min(400.0f / min, 1.0f);
        baseFilter.setNextFilter(baseFilter2, null);
        int theFilterIndex2 = getTheFilterIndex(baseFilter2) - 1;
        k kVar = new k(baseFilter2.scaleFact);
        kVar.addParam(new f("strength", 50.0f));
        kVar.addParam(new f("highlight", 24.4f));
        kVar.addParam(new f("shadow", 26.7f));
        baseFilter2.setNextFilter(kVar, new int[]{theFilterIndex2 + (this.srcTextureIndex + 1)});
        kVar.setNextFilter(new BaseFilter(GLSLRender.bKe), null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86458);
    }
}
