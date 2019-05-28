package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameOverlayFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n\n void main(void) {\n     vec4 canvasColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = mix(canvasColor, maskColor, maskColor.a);\n }";
    private static final String VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";

    public GameOverlayFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82570);
        initParams();
        AppMethodBeat.m2505o(82570);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82571);
        setMaskTexture(0);
        AppMethodBeat.m2505o(82571);
    }

    public void setMaskTexture(int i) {
        AppMethodBeat.m2504i(82572);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        AppMethodBeat.m2505o(82572);
    }
}
