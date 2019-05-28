package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class k extends BaseFilter {
    float bMG = 1.0f;
    int paramTEXTRUEID = 0;

    public k(float f) {
        super(GLSLRender.bLL);
        this.bMG = f;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86448);
        this.paramTEXTRUEID = g.dSO();
        addParam(new f("edge", 0.5f));
        addParam(new f("vmin", 0.0f));
        addParam(new f("vmax", 1.0f));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86448);
    }

    public final void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.i(86449);
        QImage aL = g.aL(i, i2, i3);
        QImage InplaceBlur8bitQImage = aL.InplaceBlur8bitQImage(1, (int) (80.0f * this.bMG));
        float[] nativeGetMaxAndMin = FilterAlgorithm.nativeGetMaxAndMin(InplaceBlur8bitQImage);
        aL.Dispose();
        addParam(new f("edge", (nativeGetMaxAndMin[0] + nativeGetMaxAndMin[1]) / 510.0f));
        addParam(new f("vmin", nativeGetMaxAndMin[0] / 255.0f));
        addParam(new f("vmax", nativeGetMaxAndMin[1] / 255.0f));
        GLSLRender.nativeTextImage(InplaceBlur8bitQImage, this.paramTEXTRUEID);
        InplaceBlur8bitQImage.Dispose();
        AppMethodBeat.o(86449);
    }

    public final boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(86450);
        boolean renderTexture = super.renderTexture(this.paramTEXTRUEID, i2, i3);
        AppMethodBeat.o(86450);
        return renderTexture;
    }

    public final void ClearGLSL() {
        AppMethodBeat.i(86451);
        g.Sk(this.paramTEXTRUEID);
        super.ClearGLSL();
        AppMethodBeat.o(86451);
    }
}
