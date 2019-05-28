package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac extends BaseFilter {
    public ac() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86478);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/gaoguanglanzi.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.052941177f, 0.0f, 0.06784314f};
        float[] fArr2 = new float[]{-0.12529412f, 0.0f, 0.13568628f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{-0.052941177f, 0.0f, 0.06784314f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter2.addParam(new i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKJ);
        baseFilter.addParam(new f("inputH", 1.0f));
        baseFilter.addParam(new f("inputS", 1.0f));
        baseFilter.addParam(new f("inputV", 1.094f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86478);
    }
}
