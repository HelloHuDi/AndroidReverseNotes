package com.tencent.a.a;

import com.microrapid.opencv.OpencvAlgorithm;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class a extends BaseFilter {
    int paramTEXTRUEID = 0;
    float strength = 5.0f;

    public a() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86269);
        this.paramTEXTRUEID = g.dSO();
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86269);
    }

    public final void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.i(86270);
        QImage aL = g.aL(i, i2, i3);
        OpencvAlgorithm.nativeDetailEnhanceFilter(aL, this.strength);
        GLSLRender.nativeTextImage(aL, this.paramTEXTRUEID);
        aL.Dispose();
        AppMethodBeat.o(86270);
    }

    public final boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(86271);
        boolean renderTexture = super.renderTexture(this.paramTEXTRUEID, i2, i3);
        AppMethodBeat.o(86271);
        return renderTexture;
    }

    public final void ClearGLSL() {
        AppMethodBeat.i(86272);
        g.Sk(this.paramTEXTRUEID);
        super.ClearGLSL();
        AppMethodBeat.o(86272);
    }
}
