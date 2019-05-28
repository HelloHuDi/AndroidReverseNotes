package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cg extends BaseFilter {
    int bJv;

    public cg() {
        super(GLSLRender.bJB);
        this.bJv = 0;
    }

    public cg(byte b) {
        super(GLSLRender.bJB);
        this.bJv = 0;
        this.bJv = 1;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86540);
        this.glsl_programID = GLSLRender.bJB;
        BaseFilter baseFilter;
        BaseFilter baseFilter2;
        if (this.bJv == 0) {
            baseFilter = new BaseFilter(GLSLRender.bKD);
            baseFilter.addParam(new o("inputImageTexture2", "sh/shishang_sh_curve.png", 33986));
            setNextFilter(baseFilter, null);
            baseFilter2 = new BaseFilter(GLSLRender.bKK);
            baseFilter2.addParam(new o("inputImageTexture2", "sh/shishang_sh_blend.jpg", 33986));
            baseFilter.setNextFilter(baseFilter2, null);
        } else {
            baseFilter = new BaseFilter(GLSLRender.bKL);
            baseFilter.addParam(new o("inputImageTexture2", "sh/fugu_sh_blend.jpg", 33986));
            setNextFilter(baseFilter, null);
            baseFilter2 = new BaseFilter(GLSLRender.bJE);
            baseFilter2.addParam(new f("filterAdjustParam", 0.3f));
            baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex});
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86540);
    }
}
