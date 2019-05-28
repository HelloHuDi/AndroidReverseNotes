package com.tencent.ttpic.filter;

import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;

public class ClarityFilters {
    public static final String PERF_LOG = "[ClarityFilters]";
    private float mClarityAlpha = 0.0f;
    private ClarityMaskFilter mClarityMaskFilter2 = new ClarityMaskFilter();

    public ClarityFilters() {
        AppMethodBeat.m2504i(82103);
        AppMethodBeat.m2505o(82103);
    }

    public void initial(int i, int i2) {
        AppMethodBeat.m2504i(82104);
        this.mClarityMaskFilter2.ApplyGLSLFilter(false, (float) i, (float) i2);
        AppMethodBeat.m2505o(82104);
    }

    public C41672h updateAndRender(C41672h c41672h, C41672h c41672h2) {
        AppMethodBeat.m2504i(82105);
        if (this.mClarityAlpha < 0.01f) {
            AppMethodBeat.m2505o(82105);
            return c41672h;
        }
        int i;
        int i2 = (c41672h.height * 720) / c41672h.width;
        if (c41672h.width > c41672h.height) {
            i = (c41672h.width * 720) / c41672h.height;
            i2 = 720;
        } else {
            i = 720;
        }
        BenchUtil.benchStart("[ClarityFilters]mClarityMaskFilter");
        this.mClarityMaskFilter2.updateSize(i, i2);
        this.mClarityMaskFilter2.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, c41672h2);
        BenchUtil.benchEnd("[ClarityFilters]mClarityMaskFilter");
        AppMethodBeat.m2505o(82105);
        return c41672h2;
    }

    public void clear() {
        AppMethodBeat.m2504i(82106);
        this.mClarityMaskFilter2.clearGLSLSelf();
        AppMethodBeat.m2505o(82106);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82107);
        this.mClarityMaskFilter2.setRenderMode(i);
        AppMethodBeat.m2505o(82107);
    }

    public void setClarityAlpha(float f) {
        AppMethodBeat.m2504i(82108);
        this.mClarityAlpha = f;
        this.mClarityMaskFilter2.updateFactor(f);
        this.mClarityMaskFilter2.updateFactor(f);
        AppMethodBeat.m2505o(82108);
    }
}
