package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GuideFilterRefine {
    private GuideFilterRefine1 mFilter1 = new GuideFilterRefine1();
    private GuideFilterRefine2 mFilter2 = new GuideFilterRefine2();
    private GuideFilterRefine3 mFilter3 = new GuideFilterRefine3();
    private h mFrame1 = new h();
    private h mFrame2 = new h();

    public GuideFilterRefine() {
        AppMethodBeat.i(82576);
        AppMethodBeat.o(82576);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82577);
        this.mFilter1.ApplyGLSLFilter();
        this.mFilter2.ApplyGLSLFilter();
        this.mFilter3.ApplyGLSLFilter();
        AppMethodBeat.o(82577);
    }

    public void updateAndRender(h hVar, h hVar2, h hVar3) {
        AppMethodBeat.i(82578);
        int i = hVar.width;
        int i2 = hVar.height;
        this.mFilter1.updateParams(hVar2.texture[0], i, i2);
        this.mFilter1.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, this.mFrame1);
        this.mFilter2.updateParams(i, i2);
        this.mFilter2.RenderProcess(this.mFrame1.texture[0], i, i2, -1, 0.0d, this.mFrame2);
        this.mFilter3.updateParams(this.mFrame2.texture[0]);
        this.mFilter3.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, hVar3);
        AppMethodBeat.o(82578);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82579);
        this.mFilter1.clearGLSLSelf();
        this.mFilter2.clearGLSLSelf();
        this.mFilter3.clearGLSLSelf();
        this.mFrame1.clear();
        this.mFrame2.clear();
        AppMethodBeat.o(82579);
    }
}
