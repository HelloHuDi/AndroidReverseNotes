package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C41106g;

/* renamed from: com.tencent.filter.a.k */
public final class C45094k extends BaseFilter {
    float bMG = 1.0f;
    int paramTEXTRUEID = 0;

    public C45094k(float f) {
        super(GLSLRender.bLL);
        this.bMG = f;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86448);
        this.paramTEXTRUEID = C41106g.dSO();
        addParam(new C0933f("edge", 0.5f));
        addParam(new C0933f("vmin", 0.0f));
        addParam(new C0933f("vmax", 1.0f));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86448);
    }

    public final void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86449);
        QImage aL = C41106g.m71542aL(i, i2, i3);
        QImage InplaceBlur8bitQImage = aL.InplaceBlur8bitQImage(1, (int) (80.0f * this.bMG));
        float[] nativeGetMaxAndMin = FilterAlgorithm.nativeGetMaxAndMin(InplaceBlur8bitQImage);
        aL.Dispose();
        addParam(new C0933f("edge", (nativeGetMaxAndMin[0] + nativeGetMaxAndMin[1]) / 510.0f));
        addParam(new C0933f("vmin", nativeGetMaxAndMin[0] / 255.0f));
        addParam(new C0933f("vmax", nativeGetMaxAndMin[1] / 255.0f));
        GLSLRender.nativeTextImage(InplaceBlur8bitQImage, this.paramTEXTRUEID);
        InplaceBlur8bitQImage.Dispose();
        AppMethodBeat.m2505o(86449);
    }

    public final boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86450);
        boolean renderTexture = super.renderTexture(this.paramTEXTRUEID, i2, i3);
        AppMethodBeat.m2505o(86450);
        return renderTexture;
    }

    public final void ClearGLSL() {
        AppMethodBeat.m2504i(86451);
        C41106g.m71538Sk(this.paramTEXTRUEID);
        super.ClearGLSL();
        AppMethodBeat.m2505o(86451);
    }
}
