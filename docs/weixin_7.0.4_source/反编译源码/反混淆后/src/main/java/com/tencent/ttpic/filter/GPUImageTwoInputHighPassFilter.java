package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GPUImageTwoInputHighPassFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n void main() {\n     lowp vec3 color_0 = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp vec3 color_1 = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     color_0 = max(color_0, color_1);\n     gl_FragColor = vec4(color_0, 1.0);\n }\n";

    public GPUImageTwoInputHighPassFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82551);
        initParams();
        AppMethodBeat.m2505o(82551);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82552);
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        AppMethodBeat.m2505o(82552);
    }

    public void updateTexture(int i) {
        AppMethodBeat.m2504i(82553);
        addParam(new C25627n("inputImageTexture2", i, 33986));
        AppMethodBeat.m2505o(82553);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(82554);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(82554);
    }
}
