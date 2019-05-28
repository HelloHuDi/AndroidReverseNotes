package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ci */
public final class C45092ci extends BaseFilter {
    public C45092ci() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86542);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/snow_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.09803922f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{-0.05882353f, 0.0f, 0.0f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{-0.09411765f, 0.0f, 0.0f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter2.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKE);
        baseFilter.addParam(new C0933f("scaleC", -0.354f));
        baseFilter.addParam(new C0933f("scaleT", 0.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bLF);
        baseFilter2.addParam(new C0933f("inputH", 1.0f));
        baseFilter2.addParam(new C0933f("inputS", 1.0f));
        baseFilter2.addParam(new C0933f("inputV", 1.05f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter("precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float param;\n void main(void)\n {\n     vec4 color  = texture2D(inputImageTexture, textureCoordinate);\n     vec4 color2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec3 ret=color.rgb+color2.rgb*param;\n     gl_FragColor = vec4(ret.rgb,1.0);\n }\n");
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/snow.png", (double) (f / f2)));
        baseFilter.addParam(new C0933f("param", 0.35f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86542);
    }
}
