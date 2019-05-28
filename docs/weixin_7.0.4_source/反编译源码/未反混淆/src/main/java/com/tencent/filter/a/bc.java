package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bc extends BaseFilter {
    public bc() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86510);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/menghuan_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLP);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/menghuan_blend.png", this.needFlipBlend ? 1 : 0, (byte) 0));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bLT);
        float[] fArr = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr2 = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr3 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr4 = new float[]{1.0f, 1.0f, 1.0f};
        baseFilter3.addParam(new g("levelMinimum", new float[]{0.16078432f, 0.16078432f, 0.16078432f}));
        baseFilter3.addParam(new g("levelMiddle", fArr));
        baseFilter3.addParam(new g("levelMaximum", fArr2));
        baseFilter3.addParam(new g("minOutput", fArr3));
        baseFilter3.addParam(new g("maxOutput", fArr4));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86510);
    }
}
