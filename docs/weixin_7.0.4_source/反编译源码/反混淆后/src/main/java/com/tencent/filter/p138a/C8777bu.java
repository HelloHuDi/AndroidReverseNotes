package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.bu */
public final class C8777bu extends BaseFilter {
    public C8777bu() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86528);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/wenyifan_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLM);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.9764706f, 0.29803923f, 0.29803923f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 0.17f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{-0.047058824f, -0.039215688f, 0.0f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{-0.050980393f, 0.0f, 0.0f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKI);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.7882353f, 0.9019608f, 0.8862745f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 1.0f));
        baseFilter.addParam(new C0933f("saturation", 1.1f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86528);
    }
}
