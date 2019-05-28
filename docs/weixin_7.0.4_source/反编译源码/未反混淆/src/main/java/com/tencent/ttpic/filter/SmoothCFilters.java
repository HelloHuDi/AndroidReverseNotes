package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SmoothCFilters {
    private SmoothCBiFilter mBilateralFilter = new SmoothCBiFilter();
    private h mBilateralFrame;
    private SmoothCProcessFilter mProcessFilter = new SmoothCProcessFilter();

    public SmoothCFilters() {
        AppMethodBeat.i(82918);
        AppMethodBeat.o(82918);
    }

    public void initial() {
        AppMethodBeat.i(82919);
        this.mBilateralFilter.ApplyGLSLFilter();
        this.mProcessFilter.ApplyGLSLFilter();
        this.mBilateralFrame = new h();
        AppMethodBeat.o(82919);
    }

    public void clear() {
        AppMethodBeat.i(82920);
        this.mBilateralFilter.clearGLSLSelf();
        this.mProcessFilter.clearGLSLSelf();
        this.mBilateralFrame.clear();
        AppMethodBeat.o(82920);
    }

    public void updateSmoothOpacity(float f) {
        AppMethodBeat.i(82921);
        this.mProcessFilter.updateSmoothOpacity(f);
        AppMethodBeat.o(82921);
    }

    public void updateAndRender(h hVar, h hVar2) {
        AppMethodBeat.i(82922);
        this.mBilateralFilter.updateSize((float) hVar.width, (float) hVar.height);
        this.mBilateralFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mBilateralFrame);
        this.mProcessFilter.setTexture2(this.mBilateralFrame);
        this.mProcessFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, hVar2);
        AppMethodBeat.o(82922);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82923);
        this.mBilateralFilter.setRenderMode(i);
        this.mProcessFilter.setRenderMode(i);
        AppMethodBeat.o(82923);
    }
}
