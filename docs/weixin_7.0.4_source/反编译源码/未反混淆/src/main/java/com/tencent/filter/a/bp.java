package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bp extends BaseFilter {
    public bp() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86523);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKF);
        baseFilter.addParam(new g("color2", new float[]{0.011764706f, 0.30980393f, 0.47843137f, 1.0f}));
        baseFilter.addParam(new f("transparency", 0.39f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/lengmeiren_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, -0.03529412f};
        float[] fArr2 = new float[]{0.0f, -0.05490196f, 0.0f};
        baseFilter.addParam(new g("shadowsShift", new float[]{-0.02745098f, 0.0f, 0.0f}));
        baseFilter.addParam(new g("midtonesShift", fArr));
        baseFilter.addParam(new g("highlightsShift", fArr2));
        baseFilter.addParam(new i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86523);
    }
}
