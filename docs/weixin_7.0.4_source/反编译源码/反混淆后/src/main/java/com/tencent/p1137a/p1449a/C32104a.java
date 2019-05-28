package com.tencent.p1137a.p1449a;

import com.microrapid.opencv.OpencvAlgorithm;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C41106g;

/* renamed from: com.tencent.a.a.a */
public final class C32104a extends BaseFilter {
    int paramTEXTRUEID = 0;
    float strength = 5.0f;

    public C32104a() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86269);
        this.paramTEXTRUEID = C41106g.dSO();
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86269);
    }

    public final void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86270);
        QImage aL = C41106g.m71542aL(i, i2, i3);
        OpencvAlgorithm.nativeDetailEnhanceFilter(aL, this.strength);
        GLSLRender.nativeTextImage(aL, this.paramTEXTRUEID);
        aL.Dispose();
        AppMethodBeat.m2505o(86270);
    }

    public final boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86271);
        boolean renderTexture = super.renderTexture(this.paramTEXTRUEID, i2, i3);
        AppMethodBeat.m2505o(86271);
        return renderTexture;
    }

    public final void ClearGLSL() {
        AppMethodBeat.m2504i(86272);
        C41106g.m71538Sk(this.paramTEXTRUEID);
        super.ClearGLSL();
        AppMethodBeat.m2505o(86272);
    }
}
