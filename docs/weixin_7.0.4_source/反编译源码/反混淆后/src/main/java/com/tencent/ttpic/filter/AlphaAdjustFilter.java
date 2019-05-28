package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AlphaAdjustFilter extends BaseFilter {
    private static String FRAGMENT = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float filterAdjustParam;\n void main()\n {\n     vec4 c2 = texture2D(inputImageTexture2, textureCoordinate.xy);\n     vec4 c1 = texture2D(inputImageTexture, textureCoordinate.xy);\n     gl_FragColor = mix(c1,c2,filterAdjustParam);\n}\n";
    private float adjust = 0.2f;

    public AlphaAdjustFilter() {
        super(FRAGMENT);
    }

    public void setAdjustParam(float f) {
        AppMethodBeat.m2504i(81952);
        this.adjust = f;
        addParam(new C0933f("filterAdjustParam", this.adjust));
        AppMethodBeat.m2505o(81952);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(81953);
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        addParam(new C0933f("filterAdjustParam", this.adjust));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(81953);
    }
}
