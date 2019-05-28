package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25633e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BorderFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform float borderWidth;\nuniform float width;\nuniform float height;\nuniform vec4 borderColor;\n\nvoid main()\n{\n    float borderX = borderWidth;\n    float borderY = borderWidth;\n    if (width > height) {\n        borderX = borderWidth * height / width;\n    } else {\n        borderY = borderWidth * width / height;\n    }\n    if (textureCoordinate.x < borderX || textureCoordinate.x > 1.0 - borderX || textureCoordinate.y < borderY || textureCoordinate.y > 1.0 - borderY) {\n        gl_FragColor = borderColor;\n    } else {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n}";

    public BorderFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82058);
        initParams();
        AppMethodBeat.m2505o(82058);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82059);
        addParam(new C0933f("borderWidth", 0.025f));
        addParam(new C25633e("borderColor", 0.0f, 0.0f, 0.0f, 1.0f));
        AppMethodBeat.m2505o(82059);
    }

    public void updateBorderWidth(float f) {
        AppMethodBeat.m2504i(82060);
        addParam(new C0933f("borderWidth", f));
        AppMethodBeat.m2505o(82060);
    }

    public void updateBorderColor(float[] fArr) {
        AppMethodBeat.m2504i(82061);
        addParam(new C25633e("borderColor", fArr[0], fArr[1], fArr[2], fArr[3]));
        AppMethodBeat.m2505o(82061);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(82062);
        addParam(new C0933f("width", f));
        addParam(new C0933f("height", f2));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(82062);
    }
}
