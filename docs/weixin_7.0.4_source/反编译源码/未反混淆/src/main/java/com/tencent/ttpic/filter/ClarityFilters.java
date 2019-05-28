package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;

public class ClarityFilters {
    public static final String PERF_LOG = "[ClarityFilters]";
    private float mClarityAlpha = 0.0f;
    private ClarityMaskFilter mClarityMaskFilter2 = new ClarityMaskFilter();

    public ClarityFilters() {
        AppMethodBeat.i(82103);
        AppMethodBeat.o(82103);
    }

    public void initial(int i, int i2) {
        AppMethodBeat.i(82104);
        this.mClarityMaskFilter2.ApplyGLSLFilter(false, (float) i, (float) i2);
        AppMethodBeat.o(82104);
    }

    public h updateAndRender(h hVar, h hVar2) {
        AppMethodBeat.i(82105);
        if (this.mClarityAlpha < 0.01f) {
            AppMethodBeat.o(82105);
            return hVar;
        }
        int i;
        int i2 = (hVar.height * 720) / hVar.width;
        if (hVar.width > hVar.height) {
            i = (hVar.width * 720) / hVar.height;
            i2 = 720;
        } else {
            i = 720;
        }
        BenchUtil.benchStart("[ClarityFilters]mClarityMaskFilter");
        this.mClarityMaskFilter2.updateSize(i, i2);
        this.mClarityMaskFilter2.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, hVar2);
        BenchUtil.benchEnd("[ClarityFilters]mClarityMaskFilter");
        AppMethodBeat.o(82105);
        return hVar2;
    }

    public void clear() {
        AppMethodBeat.i(82106);
        this.mClarityMaskFilter2.clearGLSLSelf();
        AppMethodBeat.o(82106);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82107);
        this.mClarityMaskFilter2.setRenderMode(i);
        AppMethodBeat.o(82107);
    }

    public void setClarityAlpha(float f) {
        AppMethodBeat.i(82108);
        this.mClarityAlpha = f;
        this.mClarityMaskFilter2.updateFactor(f);
        this.mClarityMaskFilter2.updateFactor(f);
        AppMethodBeat.o(82108);
    }
}
