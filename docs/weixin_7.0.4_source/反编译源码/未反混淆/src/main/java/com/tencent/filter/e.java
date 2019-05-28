package com.tencent.filter;

import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends BaseFilter {
    float[] bJw;

    public e() {
        super(GLSLRender.bJI);
        AppMethodBeat.i(86353);
        this.bJw = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        addParam(new g("colorMat", this.bJw));
        addParam(new g("transMat", new float[]{1.0f, 1.0f, 0.0f, 0.0f}));
        AppMethodBeat.o(86353);
    }

    public e(String str) {
        this();
        AppMethodBeat.i(86354);
        addParam(new o("inputImageTexture2", str, 33986));
        AppMethodBeat.o(86354);
    }

    public final void setMatrix(float[] fArr) {
        AppMethodBeat.i(86355);
        addParam(new g("colorMat", fArr));
        AppMethodBeat.o(86355);
    }
}
