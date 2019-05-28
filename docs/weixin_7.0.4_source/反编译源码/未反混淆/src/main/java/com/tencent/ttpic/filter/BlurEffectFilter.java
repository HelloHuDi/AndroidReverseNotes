package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.a.s;
import com.tencent.filter.a.t;
import com.tencent.filter.h;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BlurEffectFilter extends BaseFilter {
    private s mBlendFilter = new s();
    private h mBlendFrame = new h();
    private t mBlurFilter = new t();
    private h mBlurFrame1 = new h();
    private h mBlurFrame2 = new h();
    private double mStrength;

    public BlurEffectFilter() {
        super(GLSLRender.bJB);
        AppMethodBeat.i(82044);
        AppMethodBeat.o(82044);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(82045);
        this.mBlurFilter.ApplyGLSLFilter();
        this.mBlendFilter.ApplyGLSLFilter();
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(82045);
    }

    public void ClearGLSL() {
        AppMethodBeat.i(82046);
        this.mBlurFilter.clearGLSLSelf();
        this.mBlendFilter.clearGLSLSelf();
        this.mBlurFrame1.clear();
        this.mBlurFrame2.clear();
        this.mBlendFrame.clear();
        super.ClearGLSL();
        AppMethodBeat.o(82046);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82047);
        this.mBlurFilter.clearGLSLSelf();
        this.mBlendFilter.clearGLSLSelf();
        this.mBlurFrame1.clear();
        this.mBlurFrame2.clear();
        this.mBlendFrame.clear();
        super.clearGLSLSelf();
        AppMethodBeat.o(82047);
    }

    public void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.i(82048);
        super.beforeRender(i, i2, i3);
        if (i2 <= 0 || i3 <= 0) {
            AppMethodBeat.o(82048);
            return;
        }
        int i4 = (i3 * 400) / i2;
        this.mBlurFilter.y(0.0025f, 0.0f);
        this.mBlurFilter.RenderProcess(i, 400, i4, -1, 0.0d, this.mBlurFrame1);
        this.mBlurFilter.y(0.0f, 1.0f / ((float) i4));
        this.mBlurFilter.RenderProcess(this.mBlurFrame1.texture[0], 400, i4, -1, 0.0d, this.mBlurFrame2);
        this.mBlendFilter.addParam(new n("inputImageTexture2", i, 33986));
        this.mBlendFilter.RenderProcess(this.mBlurFrame2.texture[0], i2, i3, -1, 0.0d, this.mBlendFrame);
        AppMethodBeat.o(82048);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(82049);
        boolean renderTexture;
        if (this.mBlendFrame.texture[0] > 0) {
            renderTexture = super.renderTexture(this.mBlendFrame.texture[0], i2, i3);
            AppMethodBeat.o(82049);
            return renderTexture;
        }
        renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.o(82049);
        return renderTexture;
    }

    public void updateFilterBlurStrength(double d) {
        AppMethodBeat.i(82050);
        this.mStrength = d;
        this.mBlendFilter.addParam(new f("alpha", (float) d));
        AppMethodBeat.o(82050);
    }

    public double getStrength() {
        return this.mStrength;
    }
}
