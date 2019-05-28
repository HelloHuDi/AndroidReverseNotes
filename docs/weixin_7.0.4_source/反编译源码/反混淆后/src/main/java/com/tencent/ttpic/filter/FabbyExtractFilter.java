package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FabbyExtractFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n     vec4 cameraColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     \n     gl_FragColor = cameraColor * step(0.1, maskColor.r); \n }";

    public FabbyExtractFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82246);
        initParams();
        AppMethodBeat.m2505o(82246);
    }

    public void setTex(int i) {
        AppMethodBeat.m2504i(82247);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        AppMethodBeat.m2505o(82247);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82248);
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        AppMethodBeat.m2505o(82248);
    }
}
