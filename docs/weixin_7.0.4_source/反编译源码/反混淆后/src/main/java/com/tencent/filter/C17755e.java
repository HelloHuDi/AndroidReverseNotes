package com.tencent.filter;

import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.e */
public final class C17755e extends BaseFilter {
    float[] bJw;

    public C17755e() {
        super(GLSLRender.bJI);
        AppMethodBeat.m2504i(86353);
        this.bJw = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        addParam(new C0934g("colorMat", this.bJw));
        addParam(new C0934g("transMat", new float[]{1.0f, 1.0f, 0.0f, 0.0f}));
        AppMethodBeat.m2505o(86353);
    }

    public C17755e(String str) {
        this();
        AppMethodBeat.m2504i(86354);
        addParam(new C0936o("inputImageTexture2", str, 33986));
        AppMethodBeat.m2505o(86354);
    }

    public final void setMatrix(float[] fArr) {
        AppMethodBeat.m2504i(86355);
        addParam(new C0934g("colorMat", fArr));
        AppMethodBeat.m2505o(86355);
    }
}
