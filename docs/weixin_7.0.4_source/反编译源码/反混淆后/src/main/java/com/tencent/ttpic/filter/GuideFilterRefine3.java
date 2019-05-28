package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GuideFilterRefine3 extends BaseFilter {
    public static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\n   vec4 r = texture2D(inputImageTexture, textureCoordinate);\n   vec4 s = (texture2D(inputImageTexture2, textureCoordinate) - vec4(0.5, 0.5, 0.5, 0.5)) * 2.0;\n   float src = s.x * r.x + s.y * r.y + s.z * r.z + s.w * 2.0;\n   src = (src - 0.5) * 2.0 + 0.5;\n   if (src < 0.1) src = 0.0;\n   if (src > 0.9) src = 1.0;\n   gl_FragColor = vec4(src, src, src, 1.0);\n}";

    public GuideFilterRefine3() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82586);
        initParams();
        AppMethodBeat.m2505o(82586);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82587);
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        AppMethodBeat.m2505o(82587);
    }

    public void updateParams(int i) {
        AppMethodBeat.m2504i(82588);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        AppMethodBeat.m2505o(82588);
    }
}
