package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.bc */
public final class C25608bc extends BaseFilter {
    public C25608bc() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86510);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/menghuan_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLP);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/menghuan_blend.png", this.needFlipBlend ? 1 : 0, (byte) 0));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bLT);
        float[] fArr = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr2 = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr3 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr4 = new float[]{1.0f, 1.0f, 1.0f};
        baseFilter3.addParam(new C0934g("levelMinimum", new float[]{0.16078432f, 0.16078432f, 0.16078432f}));
        baseFilter3.addParam(new C0934g("levelMiddle", fArr));
        baseFilter3.addParam(new C0934g("levelMaximum", fArr2));
        baseFilter3.addParam(new C0934g("minOutput", fArr3));
        baseFilter3.addParam(new C0934g("maxOutput", fArr4));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86510);
    }
}
