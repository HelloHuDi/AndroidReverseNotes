package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;

public class ChannelSplitFilter extends BaseFilter {
    private static String BLEND_FRAGMENt_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n\n    float sx=clamp(textureCoordinate.x-0.03, 0.0, 1.0);\n    vec2 newloc = vec2(sx, textureCoordinate.y);\n    vec4 textureColor1 = texture2D(inputImageTexture, newloc);\n    sx=clamp(textureCoordinate.x+0.03, 0.0, 1.0);\n    newloc = vec2(sx, textureCoordinate.y);\n    vec4 textureColor2 = texture2D(inputImageTexture, newloc);\n    gl_FragColor = vec4(textureColor1.r, textureColor.g, textureColor2.b, textureColor.a);\n}";

    public ChannelSplitFilter() {
        super(BLEND_FRAGMENt_SHADER);
    }
}
