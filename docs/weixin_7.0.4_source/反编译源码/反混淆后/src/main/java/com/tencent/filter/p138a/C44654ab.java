package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ab */
public class C44654ab extends BaseFilter {
    public static final String LOOKUP_FRAGMENT_SHADER1 = "varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform lowp float alpha;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\nnewColor = mix(newColor, textureColor, alpha);\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n";

    public C44654ab() {
        super(LOOKUP_FRAGMENT_SHADER1);
        AppMethodBeat.m2504i(86480);
        initParams();
        AppMethodBeat.m2505o(86480);
    }

    private void initParams() {
        AppMethodBeat.m2504i(86481);
        addParam(new C0933f("alpha", 0.0f));
        AppMethodBeat.m2505o(86481);
    }

    public void setAdjustParam(float f) {
        AppMethodBeat.m2504i(86482);
        addParam(new C0933f("alpha", f));
        AppMethodBeat.m2505o(86482);
    }
}
