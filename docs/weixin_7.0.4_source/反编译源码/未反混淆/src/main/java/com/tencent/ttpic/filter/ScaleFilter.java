package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;

public class ScaleFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform float scale;\n \n void main(void) {\n       float x = 0.5 + (textureCoordinate.x - 0.5) / scale; \n       float y = 0.5 + (textureCoordinate.y - 0.5) / scale; \n       if (x < 0.0 || x > 1.0 || y < 0.0 || y > 1.0) { \n           gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0); \n       } else { \n           gl_FragColor = texture2D(inputImageTexture, vec2(x, y)); \n       } \n }";

    public ScaleFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82830);
        initParams();
        AppMethodBeat.o(82830);
    }

    private void initParams() {
        AppMethodBeat.i(82831);
        addParam(new f(WMElement.ANIMATE_TYPE_SCALE, 0.0f));
        AppMethodBeat.o(82831);
    }

    public void setScale(float f) {
        AppMethodBeat.i(82832);
        addParam(new f(WMElement.ANIMATE_TYPE_SCALE, f));
        AppMethodBeat.o(82832);
    }
}
