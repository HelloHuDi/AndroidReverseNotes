package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.e */
public final class C32128e extends BaseFilter {
    public C32128e() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86438);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKH);
        float[] fArr = new float[]{1.0f, 1.0f, 1.0f};
        baseFilter.addParam(new C0934g("channelparam", new float[]{0.4f, 0.4f, 0.2f}));
        baseFilter.addParam(new C0934g("mixparam", fArr));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/blackwhite.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLG);
        fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.2f, 0.2f, 0.2f};
        float[] fArr3 = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr4 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr5 = new float[]{1.0f, 1.0f, 1.0f};
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/blackwhite2levelmask.png", 33986));
        baseFilter.addParam(new C0934g("levelMinimum", fArr));
        baseFilter.addParam(new C0934g("levelMiddle", fArr2));
        baseFilter.addParam(new C0934g("levelMaximum", fArr3));
        baseFilter.addParam(new C0934g("minOutput", fArr4));
        baseFilter.addParam(new C0934g("maxOutput", fArr5));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKK);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/blackwhite2overlay.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86438);
    }
}
