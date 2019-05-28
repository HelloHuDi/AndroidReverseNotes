package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextureMergeFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n \n void main(void) {\n     vec4 fgColor = texture2D(inputImageTexture3, textureCoordinate);\n     if (fgColor.a >= 1.0) {\n         gl_FragColor = fgColor; \n     } else { \n          vec4 middleColor = texture2D(inputImageTexture, textureCoordinate);\n         if (middleColor.a >= 1.0) { \n             gl_FragColor = mix(middleColor, fgColor, fgColor.a); \n         } else {\n             vec4 bgColor = texture2D(inputImageTexture2, textureCoordinate);\n             vec4 bg_middle = mix(bgColor, middleColor, middleColor.a); \n             gl_FragColor = mix(bg_middle, fgColor, fgColor.a); \n         } \n     } \n }";
    private int mBgTex;
    private int mFgTex;

    public TextureMergeFilter() {
        super(FRAGMENT_SHADER);
    }

    public void setTex(int i, int i2) {
        this.mBgTex = i;
        this.mFgTex = i2;
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(82973);
        addParam(new n("inputImageTexture2", this.mBgTex, 33986));
        addParam(new n("inputImageTexture3", this.mFgTex, 33987));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(82973);
    }
}
