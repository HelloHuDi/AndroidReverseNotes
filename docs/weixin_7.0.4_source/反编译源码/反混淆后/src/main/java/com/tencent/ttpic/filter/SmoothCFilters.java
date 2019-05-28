package com.tencent.ttpic.filter;

import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SmoothCFilters {
    private SmoothCBiFilter mBilateralFilter = new SmoothCBiFilter();
    private C41672h mBilateralFrame;
    private SmoothCProcessFilter mProcessFilter = new SmoothCProcessFilter();

    public SmoothCFilters() {
        AppMethodBeat.m2504i(82918);
        AppMethodBeat.m2505o(82918);
    }

    public void initial() {
        AppMethodBeat.m2504i(82919);
        this.mBilateralFilter.ApplyGLSLFilter();
        this.mProcessFilter.ApplyGLSLFilter();
        this.mBilateralFrame = new C41672h();
        AppMethodBeat.m2505o(82919);
    }

    public void clear() {
        AppMethodBeat.m2504i(82920);
        this.mBilateralFilter.clearGLSLSelf();
        this.mProcessFilter.clearGLSLSelf();
        this.mBilateralFrame.clear();
        AppMethodBeat.m2505o(82920);
    }

    public void updateSmoothOpacity(float f) {
        AppMethodBeat.m2504i(82921);
        this.mProcessFilter.updateSmoothOpacity(f);
        AppMethodBeat.m2505o(82921);
    }

    public void updateAndRender(C41672h c41672h, C41672h c41672h2) {
        AppMethodBeat.m2504i(82922);
        this.mBilateralFilter.updateSize((float) c41672h.width, (float) c41672h.height);
        this.mBilateralFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mBilateralFrame);
        this.mProcessFilter.setTexture2(this.mBilateralFrame);
        this.mProcessFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, c41672h2);
        AppMethodBeat.m2505o(82922);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82923);
        this.mBilateralFilter.setRenderMode(i);
        this.mProcessFilter.setRenderMode(i);
        AppMethodBeat.m2505o(82923);
    }
}
