package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import java.util.List;
import java.util.Set;

public class MultiViewerFilter {
    private static final String TAG = MultiViewerFilter.class.getSimpleName();
    private Set<Integer> activeParts;
    private BaseFilter copyFilter;
    private BaseFilter effectFilter;
    private C41672h emptyFrame = new C41672h();
    private boolean needOriginFrame;
    private int renderId;
    private VideoFilterList videoFilterList;

    public MultiViewerFilter() {
        AppMethodBeat.m2504i(82661);
        AppMethodBeat.m2505o(82661);
    }

    static {
        AppMethodBeat.m2504i(82672);
        AppMethodBeat.m2505o(82672);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82662);
        if (this.videoFilterList != null) {
            this.videoFilterList.ApplyGLSLFilter();
        }
        if (this.effectFilter != null) {
            this.effectFilter.ApplyGLSLFilter(false, 0.0f, 0.0f);
        }
        AppMethodBeat.m2505o(82662);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(82663);
        if (this.videoFilterList != null) {
            this.videoFilterList.updateVideoSize(i, i2, d, 0);
        }
        AppMethodBeat.m2505o(82663);
    }

    public C41672h render(C41672h c41672h, C41672h c41672h2, PTFaceAttr pTFaceAttr) {
        C41672h c41672h3;
        AppMethodBeat.m2504i(82664);
        Object obj = null;
        if (this.needOriginFrame) {
            c41672h3 = c41672h;
        } else {
            this.emptyFrame.mo67189a(-1, c41672h2.width, c41672h2.height, 0.0d);
            FrameUtil.clearFrame(this.emptyFrame, 0.0f, 0.0f, 0.0f, 0.0f, c41672h2.width, c41672h2.height);
            c41672h3 = this.emptyFrame;
            obj = 1;
        }
        if (this.effectFilter != null) {
            BenchUtil.benchStart(TAG + " effectFilter.RenderProcess");
            this.effectFilter.RenderProcess(c41672h3.texture[0], c41672h2.width, c41672h2.height, -1, 0.0d, c41672h2);
            BenchUtil.benchEnd(TAG + " effectFilter.RenderProcess");
            c41672h3 = FrameUtil.getLastRenderFrame(c41672h2);
            obj = 1;
        }
        if (this.videoFilterList != null) {
            if (this.videoFilterList.getFastFaceStickerFilter() != null) {
                if (obj == null) {
                    this.videoFilterList.setMultiViewerSrcTexture(c41672h3.texture[0]);
                    this.videoFilterList.setMultiViewerOutFrame(c41672h2);
                } else {
                    this.videoFilterList.setMultiViewerSrcTexture(0);
                    this.videoFilterList.setMultiViewerOutFrame(c41672h3);
                }
                c41672h3 = renderStickers(c41672h3, pTFaceAttr);
            } else {
                if (obj == null) {
                    copyFrame(c41672h, c41672h2);
                } else {
                    c41672h2 = c41672h3;
                }
                c41672h3 = renderStickers(c41672h2, pTFaceAttr);
            }
        }
        AppMethodBeat.m2505o(82664);
        return c41672h3;
    }

    private C41672h renderStickers(C41672h c41672h, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.m2504i(82665);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        List handPoints = pTFaceAttr.getHandPoints();
        BenchUtil.benchStart(TAG + " videoFilterList.process");
        this.videoFilterList.updateFaceParams(allFacePoints, allFaceAngles, handPoints, c41672h.width);
        C41672h updateAndRenderDynamicStickers = this.videoFilterList.updateAndRenderDynamicStickers(this.videoFilterList.processTransformRelatedFilters(c41672h, pTFaceAttr), pTFaceAttr);
        BenchUtil.benchEnd(TAG + " videoFilterList.process");
        BenchUtil.benchStart(TAG + " videoFilterList.updateAndRenderStaticStickers");
        updateAndRenderDynamicStickers = this.videoFilterList.updateAndRenderStaticStickers(updateAndRenderDynamicStickers, pTFaceAttr);
        BenchUtil.benchEnd(TAG + " videoFilterList.updateAndRenderStaticStickers");
        AppMethodBeat.m2505o(82665);
        return updateAndRenderDynamicStickers;
    }

    private void copyFrame(C41672h c41672h, C41672h c41672h2) {
        AppMethodBeat.m2504i(82666);
        if (this.copyFilter == null) {
            this.copyFilter = new BaseFilter(GLSLRender.bJB);
            this.copyFilter.ApplyGLSLFilter();
        }
        this.copyFilter.RenderProcess(c41672h.texture[0], c41672h2.width, c41672h2.height, -1, 0.0d, c41672h2);
        AppMethodBeat.m2505o(82666);
    }

    public void setNeedOriginFrame(boolean z) {
        this.needOriginFrame = z;
    }

    public void setRenderId(int i) {
        this.renderId = i;
    }

    public void setEffectFilter(BaseFilter baseFilter) {
        this.effectFilter = baseFilter;
    }

    public void setVideoFilterList(VideoFilterList videoFilterList) {
        this.videoFilterList = videoFilterList;
    }

    public int getRenderId() {
        return this.renderId;
    }

    public void setActiveParts(Set<Integer> set) {
        this.activeParts = set;
    }

    public boolean needRenderThisPart(int i) {
        AppMethodBeat.m2504i(82667);
        boolean contains = this.activeParts.contains(Integer.valueOf(i));
        AppMethodBeat.m2505o(82667);
        return contains;
    }

    public void clear() {
        AppMethodBeat.m2504i(82668);
        if (this.videoFilterList != null) {
            this.videoFilterList.destroy();
        }
        if (this.effectFilter != null) {
            this.effectFilter.ClearGLSL();
        }
        if (this.copyFilter != null) {
            this.copyFilter.ClearGLSL();
        }
        if (this.emptyFrame != null) {
            this.emptyFrame.clear();
        }
        AppMethodBeat.m2505o(82668);
    }

    public void setRatioMode(RATIO_MODE ratio_mode) {
        AppMethodBeat.m2504i(82669);
        if (this.videoFilterList != null) {
            this.videoFilterList.setRatioMode(ratio_mode);
        }
        AppMethodBeat.m2505o(82669);
    }

    public void reset() {
        AppMethodBeat.m2504i(82670);
        if (this.videoFilterList != null) {
            this.videoFilterList.reset();
        }
        AppMethodBeat.m2505o(82670);
    }

    public void setAudioPause(boolean z) {
        AppMethodBeat.m2504i(82671);
        if (this.videoFilterList != null) {
            this.videoFilterList.setAudioPause(z);
        }
        AppMethodBeat.m2505o(82671);
    }
}
