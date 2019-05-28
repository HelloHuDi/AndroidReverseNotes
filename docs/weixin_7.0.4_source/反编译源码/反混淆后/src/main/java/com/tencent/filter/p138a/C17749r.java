package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C17757l;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.r */
public final class C17749r extends BaseFilter {
    float param = 1.0f;

    public C17749r() {
        super(GLSLRender.bJB);
    }

    public final void setAdjustParam(float f) {
        this.param = f;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86458);
        if (z) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86458);
            return;
        }
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        float min = Math.min(f2, f);
        baseFilter.scaleFact = Math.min(200.0f / min, 1.0f);
        setNextFilter(baseFilter, null);
        int theFilterIndex = getTheFilterIndex(baseFilter) - 1;
        C17757l c17757l = new C17757l();
        baseFilter.setNextFilter(c17757l, new int[]{theFilterIndex + (this.srcTextureIndex + 1)});
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 0.96f));
        baseFilter.addParam(new C0933f("saturation", 0.766f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        c17757l.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKd);
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bMn, GLSLRender.bKi);
        baseFilter.addParam(new C0933f("sharpness", 0.377f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bJB);
        baseFilter2.scaleFact = Math.min(400.0f / min, 1.0f);
        baseFilter.setNextFilter(baseFilter2, null);
        int theFilterIndex2 = getTheFilterIndex(baseFilter2) - 1;
        C45094k c45094k = new C45094k(baseFilter2.scaleFact);
        c45094k.addParam(new C0933f("strength", 50.0f));
        c45094k.addParam(new C0933f("highlight", 24.4f));
        c45094k.addParam(new C0933f("shadow", 26.7f));
        baseFilter2.setNextFilter(c45094k, new int[]{theFilterIndex2 + (this.srcTextureIndex + 1)});
        c45094k.setNextFilter(new BaseFilter(GLSLRender.bKe), null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86458);
    }
}
