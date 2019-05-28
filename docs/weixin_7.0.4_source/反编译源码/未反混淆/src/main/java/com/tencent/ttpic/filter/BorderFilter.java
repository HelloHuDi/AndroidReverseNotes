package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.e;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BorderFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform float borderWidth;\nuniform float width;\nuniform float height;\nuniform vec4 borderColor;\n\nvoid main()\n{\n    float borderX = borderWidth;\n    float borderY = borderWidth;\n    if (width > height) {\n        borderX = borderWidth * height / width;\n    } else {\n        borderY = borderWidth * width / height;\n    }\n    if (textureCoordinate.x < borderX || textureCoordinate.x > 1.0 - borderX || textureCoordinate.y < borderY || textureCoordinate.y > 1.0 - borderY) {\n        gl_FragColor = borderColor;\n    } else {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n}";

    public BorderFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82058);
        initParams();
        AppMethodBeat.o(82058);
    }

    private void initParams() {
        AppMethodBeat.i(82059);
        addParam(new f("borderWidth", 0.025f));
        addParam(new e("borderColor", 0.0f, 0.0f, 0.0f, 1.0f));
        AppMethodBeat.o(82059);
    }

    public void updateBorderWidth(float f) {
        AppMethodBeat.i(82060);
        addParam(new f("borderWidth", f));
        AppMethodBeat.o(82060);
    }

    public void updateBorderColor(float[] fArr) {
        AppMethodBeat.i(82061);
        addParam(new e("borderColor", fArr[0], fArr[1], fArr[2], fArr[3]));
        AppMethodBeat.o(82061);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(82062);
        addParam(new f("width", f));
        addParam(new f("height", f2));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(82062);
    }
}
