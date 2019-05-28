package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

public class SegmentMonitorFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int segSlow;\n \n void main(void) {\n    if(segSlow == 1){\n        gl_FragColor = vec4(1, 0, 0, 0.5); \n    } else{\n        gl_FragColor = vec4(0, 1, 0, 0.5); \n    }\n}";

    public SegmentMonitorFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82833);
        initParams();
        AppMethodBeat.o(82833);
    }

    private void initParams() {
        AppMethodBeat.i(82834);
        addParam(new i("segSlow", 0));
        AppMethodBeat.o(82834);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82835);
        super.ApplyGLSLFilter();
        setPositions(new float[]{-1.0f, -1.0f, -1.0f, -0.25f, -0.25f, -0.25f, -0.25f, -1.0f});
        AppMethodBeat.o(82835);
    }

    public h updateAndRender(int i, h hVar) {
        AppMethodBeat.i(82836);
        addParam(new i("segSlow", i));
        GlUtil.setBlendMode(true);
        OnDrawFrameGLSL();
        renderTexture(hVar.texture[0], hVar.width, hVar.height);
        GlUtil.setBlendMode(false);
        AppMethodBeat.o(82836);
        return hVar;
    }
}
