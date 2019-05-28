package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.cm */
public final class C17742cm extends BaseFilter {
    public C17742cm() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86545);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bLW);
        float[] fArr = new float[]{0.04f, 1.0f, 1.0f};
        float[] fArr2 = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr3 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr4 = new float[]{1.0f, 1.0f, 1.0f};
        baseFilter.addParam(new C0934g("levelMinimum", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter.addParam(new C0934g("levelMiddle", fArr));
        baseFilter.addParam(new C0934g("levelMaximum", fArr2));
        baseFilter.addParam(new C0934g("minOutput", fArr3));
        baseFilter.addParam(new C0934g("maxOutput", fArr4));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLX);
        baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex + 1});
        baseFilter = new BaseFilter(GLSLRender.bLW);
        fArr2 = new float[]{1.0f, 0.02f, 1.0f};
        fArr3 = new float[]{1.0f, 1.0f, 1.0f};
        fArr4 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr5 = new float[]{1.0f, 1.0f, 1.0f};
        baseFilter.addParam(new C0934g("levelMinimum", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter.addParam(new C0934g("levelMiddle", fArr2));
        baseFilter.addParam(new C0934g("levelMaximum", fArr3));
        baseFilter.addParam(new C0934g("minOutput", fArr4));
        baseFilter.addParam(new C0934g("maxOutput", fArr5));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bLY);
        baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex + 2});
        baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/3d_curve.png", 33986));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86545);
    }
}
