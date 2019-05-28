package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExposureFilter extends BaseFilter {
    private static final float EXPOSURE_MAX = 1.5f;
    private static final float EXPOSURE_MIN = -2.0f;
    private static final String FRAG_SHADER = " precision mediump float;\n varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform lowp float exposure;\n void main()\n {\n     vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(textureColor.rgb * pow(1.41, exposure), textureColor.a);\n }";
    private float mExposure = 0.0f;

    public ExposureFilter() {
        super(FRAG_SHADER);
        AppMethodBeat.i(82181);
        setExposureValue(0.0f);
        AppMethodBeat.o(82181);
    }

    public void setExposureValue(float f) {
        AppMethodBeat.i(82182);
        float max = Math.max(Math.min(f, 1.5f), EXPOSURE_MIN);
        this.mExposure = max;
        addParam(new f("exposure", max));
        AppMethodBeat.o(82182);
    }

    public void setExposureLevel(float f) {
        AppMethodBeat.i(82183);
        setExposureValue(transLevel2Value(f));
        AppMethodBeat.o(82183);
    }

    private float transLevel2Value(float f) {
        AppMethodBeat.i(82184);
        float abs;
        if (f < 50.0f) {
            abs = ((f - 50.0f) / 50.0f) * Math.abs(EXPOSURE_MIN);
            AppMethodBeat.o(82184);
            return abs;
        }
        abs = ((f - 50.0f) / 50.0f) * Math.abs(1.5f);
        AppMethodBeat.o(82184);
        return abs;
    }

    public boolean needRender() {
        AppMethodBeat.i(82185);
        if (Math.abs(this.mExposure) > 0.01f) {
            AppMethodBeat.o(82185);
            return true;
        }
        AppMethodBeat.o(82185);
        return false;
    }
}
