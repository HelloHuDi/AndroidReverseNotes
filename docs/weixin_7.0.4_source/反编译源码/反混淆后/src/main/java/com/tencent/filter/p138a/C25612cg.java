package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.cg */
public final class C25612cg extends BaseFilter {
    int bJv;

    public C25612cg() {
        super(GLSLRender.bJB);
        this.bJv = 0;
    }

    public C25612cg(byte b) {
        super(GLSLRender.bJB);
        this.bJv = 0;
        this.bJv = 1;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86540);
        this.glsl_programID = GLSLRender.bJB;
        BaseFilter baseFilter;
        BaseFilter baseFilter2;
        if (this.bJv == 0) {
            baseFilter = new BaseFilter(GLSLRender.bKD);
            baseFilter.addParam(new C0936o("inputImageTexture2", "sh/shishang_sh_curve.png", 33986));
            setNextFilter(baseFilter, null);
            baseFilter2 = new BaseFilter(GLSLRender.bKK);
            baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/shishang_sh_blend.jpg", 33986));
            baseFilter.setNextFilter(baseFilter2, null);
        } else {
            baseFilter = new BaseFilter(GLSLRender.bKL);
            baseFilter.addParam(new C0936o("inputImageTexture2", "sh/fugu_sh_blend.jpg", 33986));
            setNextFilter(baseFilter, null);
            baseFilter2 = new BaseFilter(GLSLRender.bJE);
            baseFilter2.addParam(new C0933f("filterAdjustParam", 0.3f));
            baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex});
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86540);
    }
}
