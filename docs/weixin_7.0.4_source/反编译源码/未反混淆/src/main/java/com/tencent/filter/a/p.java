package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p extends BaseFilter {
    private BaseFilter bNF = null;
    private int bNS = 0;

    public p() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86456);
        this.bNF = new BaseFilter(GLSLRender.bLG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.3f, 0.3f, 0.3f};
        float[] fArr3 = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr4 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr5 = new float[]{1.0f, 1.0f, 1.0f};
        this.bNF.addParam(new o("inputImageTexture2", "sh/darkcornermask_s.png", 33986));
        this.bNF.addParam(new o("inputImageTexture3", "sh/darkcornermask_l.png", 33987));
        this.bNF.addParam(new g("levelMinimum", fArr));
        this.bNF.addParam(new g("levelMiddle", fArr2));
        this.bNF.addParam(new g("levelMaximum", fArr3));
        this.bNF.addParam(new g("minOutput", fArr4));
        this.bNF.addParam(new g("maxOutput", fArr5));
        this.bNF.addParam(new i("maskType", this.bNS));
        setNextFilter(this.bNF, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86456);
    }
}
