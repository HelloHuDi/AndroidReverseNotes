package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.p */
public final class C32130p extends BaseFilter {
    private BaseFilter bNF = null;
    private int bNS = 0;

    public C32130p() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86456);
        this.bNF = new BaseFilter(GLSLRender.bLG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.3f, 0.3f, 0.3f};
        float[] fArr3 = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr4 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr5 = new float[]{1.0f, 1.0f, 1.0f};
        this.bNF.addParam(new C0936o("inputImageTexture2", "sh/darkcornermask_s.png", 33986));
        this.bNF.addParam(new C0936o("inputImageTexture3", "sh/darkcornermask_l.png", 33987));
        this.bNF.addParam(new C0934g("levelMinimum", fArr));
        this.bNF.addParam(new C0934g("levelMiddle", fArr2));
        this.bNF.addParam(new C0934g("levelMaximum", fArr3));
        this.bNF.addParam(new C0934g("minOutput", fArr4));
        this.bNF.addParam(new C0934g("maxOutput", fArr5));
        this.bNF.addParam(new C0935i("maskType", this.bNS));
        setNextFilter(this.bNF, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86456);
    }
}
