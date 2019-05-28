package com.tencent.ttpic.filter;

import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GuideFilterRefine {
    private GuideFilterRefine1 mFilter1 = new GuideFilterRefine1();
    private GuideFilterRefine2 mFilter2 = new GuideFilterRefine2();
    private GuideFilterRefine3 mFilter3 = new GuideFilterRefine3();
    private C41672h mFrame1 = new C41672h();
    private C41672h mFrame2 = new C41672h();

    public GuideFilterRefine() {
        AppMethodBeat.m2504i(82576);
        AppMethodBeat.m2505o(82576);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82577);
        this.mFilter1.ApplyGLSLFilter();
        this.mFilter2.ApplyGLSLFilter();
        this.mFilter3.ApplyGLSLFilter();
        AppMethodBeat.m2505o(82577);
    }

    public void updateAndRender(C41672h c41672h, C41672h c41672h2, C41672h c41672h3) {
        AppMethodBeat.m2504i(82578);
        int i = c41672h.width;
        int i2 = c41672h.height;
        this.mFilter1.updateParams(c41672h2.texture[0], i, i2);
        this.mFilter1.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, this.mFrame1);
        this.mFilter2.updateParams(i, i2);
        this.mFilter2.RenderProcess(this.mFrame1.texture[0], i, i2, -1, 0.0d, this.mFrame2);
        this.mFilter3.updateParams(this.mFrame2.texture[0]);
        this.mFilter3.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, c41672h3);
        AppMethodBeat.m2505o(82578);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.m2504i(82579);
        this.mFilter1.clearGLSLSelf();
        this.mFilter2.clearGLSLSelf();
        this.mFilter3.clearGLSLSelf();
        this.mFrame1.clear();
        this.mFrame2.clear();
        AppMethodBeat.m2505o(82579);
    }
}
