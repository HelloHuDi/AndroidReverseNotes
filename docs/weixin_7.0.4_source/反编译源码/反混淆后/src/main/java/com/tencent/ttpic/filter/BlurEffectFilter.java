package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.p138a.C17750s;
import com.tencent.filter.p138a.C44667t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BlurEffectFilter extends BaseFilter {
    private C17750s mBlendFilter = new C17750s();
    private C41672h mBlendFrame = new C41672h();
    private C44667t mBlurFilter = new C44667t();
    private C41672h mBlurFrame1 = new C41672h();
    private C41672h mBlurFrame2 = new C41672h();
    private double mStrength;

    public BlurEffectFilter() {
        super(GLSLRender.bJB);
        AppMethodBeat.m2504i(82044);
        AppMethodBeat.m2505o(82044);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(82045);
        this.mBlurFilter.ApplyGLSLFilter();
        this.mBlendFilter.ApplyGLSLFilter();
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(82045);
    }

    public void ClearGLSL() {
        AppMethodBeat.m2504i(82046);
        this.mBlurFilter.clearGLSLSelf();
        this.mBlendFilter.clearGLSLSelf();
        this.mBlurFrame1.clear();
        this.mBlurFrame2.clear();
        this.mBlendFrame.clear();
        super.ClearGLSL();
        AppMethodBeat.m2505o(82046);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.m2504i(82047);
        this.mBlurFilter.clearGLSLSelf();
        this.mBlendFilter.clearGLSLSelf();
        this.mBlurFrame1.clear();
        this.mBlurFrame2.clear();
        this.mBlendFrame.clear();
        super.clearGLSLSelf();
        AppMethodBeat.m2505o(82047);
    }

    public void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82048);
        super.beforeRender(i, i2, i3);
        if (i2 <= 0 || i3 <= 0) {
            AppMethodBeat.m2505o(82048);
            return;
        }
        int i4 = (i3 * 400) / i2;
        this.mBlurFilter.mo71702y(0.0025f, 0.0f);
        this.mBlurFilter.RenderProcess(i, 400, i4, -1, 0.0d, this.mBlurFrame1);
        this.mBlurFilter.mo71702y(0.0f, 1.0f / ((float) i4));
        this.mBlurFilter.RenderProcess(this.mBlurFrame1.texture[0], 400, i4, -1, 0.0d, this.mBlurFrame2);
        this.mBlendFilter.addParam(new C25627n("inputImageTexture2", i, 33986));
        this.mBlendFilter.RenderProcess(this.mBlurFrame2.texture[0], i2, i3, -1, 0.0d, this.mBlendFrame);
        AppMethodBeat.m2505o(82048);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82049);
        boolean renderTexture;
        if (this.mBlendFrame.texture[0] > 0) {
            renderTexture = super.renderTexture(this.mBlendFrame.texture[0], i2, i3);
            AppMethodBeat.m2505o(82049);
            return renderTexture;
        }
        renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.m2505o(82049);
        return renderTexture;
    }

    public void updateFilterBlurStrength(double d) {
        AppMethodBeat.m2504i(82050);
        this.mStrength = d;
        this.mBlendFilter.addParam(new C0933f("alpha", (float) d));
        AppMethodBeat.m2505o(82050);
    }

    public double getStrength() {
        return this.mStrength;
    }
}
