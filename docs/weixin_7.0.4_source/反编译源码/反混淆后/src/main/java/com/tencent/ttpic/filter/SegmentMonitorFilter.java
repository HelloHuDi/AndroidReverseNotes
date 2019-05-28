package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

public class SegmentMonitorFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = " precision mediump float;\n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int segSlow;\n \n void main(void) {\n    if(segSlow == 1){\n        gl_FragColor = vec4(1, 0, 0, 0.5); \n    } else{\n        gl_FragColor = vec4(0, 1, 0, 0.5); \n    }\n}";

    public SegmentMonitorFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82833);
        initParams();
        AppMethodBeat.m2505o(82833);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82834);
        addParam(new C0935i("segSlow", 0));
        AppMethodBeat.m2505o(82834);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82835);
        super.ApplyGLSLFilter();
        setPositions(new float[]{-1.0f, -1.0f, -1.0f, -0.25f, -0.25f, -0.25f, -0.25f, -1.0f});
        AppMethodBeat.m2505o(82835);
    }

    public C41672h updateAndRender(int i, C41672h c41672h) {
        AppMethodBeat.m2504i(82836);
        addParam(new C0935i("segSlow", i));
        GlUtil.setBlendMode(true);
        OnDrawFrameGLSL();
        renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
        GlUtil.setBlendMode(false);
        AppMethodBeat.m2505o(82836);
        return c41672h;
    }
}
