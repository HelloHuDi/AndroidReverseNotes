package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
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
    private h emptyFrame = new h();
    private boolean needOriginFrame;
    private int renderId;
    private VideoFilterList videoFilterList;

    public MultiViewerFilter() {
        AppMethodBeat.i(82661);
        AppMethodBeat.o(82661);
    }

    static {
        AppMethodBeat.i(82672);
        AppMethodBeat.o(82672);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82662);
        if (this.videoFilterList != null) {
            this.videoFilterList.ApplyGLSLFilter();
        }
        if (this.effectFilter != null) {
            this.effectFilter.ApplyGLSLFilter(false, 0.0f, 0.0f);
        }
        AppMethodBeat.o(82662);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82663);
        if (this.videoFilterList != null) {
            this.videoFilterList.updateVideoSize(i, i2, d, 0);
        }
        AppMethodBeat.o(82663);
    }

    public h render(h hVar, h hVar2, PTFaceAttr pTFaceAttr) {
        h hVar3;
        AppMethodBeat.i(82664);
        Object obj = null;
        if (this.needOriginFrame) {
            hVar3 = hVar;
        } else {
            this.emptyFrame.a(-1, hVar2.width, hVar2.height, 0.0d);
            FrameUtil.clearFrame(this.emptyFrame, 0.0f, 0.0f, 0.0f, 0.0f, hVar2.width, hVar2.height);
            hVar3 = this.emptyFrame;
            obj = 1;
        }
        if (this.effectFilter != null) {
            BenchUtil.benchStart(TAG + " effectFilter.RenderProcess");
            this.effectFilter.RenderProcess(hVar3.texture[0], hVar2.width, hVar2.height, -1, 0.0d, hVar2);
            BenchUtil.benchEnd(TAG + " effectFilter.RenderProcess");
            hVar3 = FrameUtil.getLastRenderFrame(hVar2);
            obj = 1;
        }
        if (this.videoFilterList != null) {
            if (this.videoFilterList.getFastFaceStickerFilter() != null) {
                if (obj == null) {
                    this.videoFilterList.setMultiViewerSrcTexture(hVar3.texture[0]);
                    this.videoFilterList.setMultiViewerOutFrame(hVar2);
                } else {
                    this.videoFilterList.setMultiViewerSrcTexture(0);
                    this.videoFilterList.setMultiViewerOutFrame(hVar3);
                }
                hVar3 = renderStickers(hVar3, pTFaceAttr);
            } else {
                if (obj == null) {
                    copyFrame(hVar, hVar2);
                } else {
                    hVar2 = hVar3;
                }
                hVar3 = renderStickers(hVar2, pTFaceAttr);
            }
        }
        AppMethodBeat.o(82664);
        return hVar3;
    }

    private h renderStickers(h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(82665);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        List handPoints = pTFaceAttr.getHandPoints();
        BenchUtil.benchStart(TAG + " videoFilterList.process");
        this.videoFilterList.updateFaceParams(allFacePoints, allFaceAngles, handPoints, hVar.width);
        h updateAndRenderDynamicStickers = this.videoFilterList.updateAndRenderDynamicStickers(this.videoFilterList.processTransformRelatedFilters(hVar, pTFaceAttr), pTFaceAttr);
        BenchUtil.benchEnd(TAG + " videoFilterList.process");
        BenchUtil.benchStart(TAG + " videoFilterList.updateAndRenderStaticStickers");
        updateAndRenderDynamicStickers = this.videoFilterList.updateAndRenderStaticStickers(updateAndRenderDynamicStickers, pTFaceAttr);
        BenchUtil.benchEnd(TAG + " videoFilterList.updateAndRenderStaticStickers");
        AppMethodBeat.o(82665);
        return updateAndRenderDynamicStickers;
    }

    private void copyFrame(h hVar, h hVar2) {
        AppMethodBeat.i(82666);
        if (this.copyFilter == null) {
            this.copyFilter = new BaseFilter(GLSLRender.bJB);
            this.copyFilter.ApplyGLSLFilter();
        }
        this.copyFilter.RenderProcess(hVar.texture[0], hVar2.width, hVar2.height, -1, 0.0d, hVar2);
        AppMethodBeat.o(82666);
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
        AppMethodBeat.i(82667);
        boolean contains = this.activeParts.contains(Integer.valueOf(i));
        AppMethodBeat.o(82667);
        return contains;
    }

    public void clear() {
        AppMethodBeat.i(82668);
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
        AppMethodBeat.o(82668);
    }

    public void setRatioMode(RATIO_MODE ratio_mode) {
        AppMethodBeat.i(82669);
        if (this.videoFilterList != null) {
            this.videoFilterList.setRatioMode(ratio_mode);
        }
        AppMethodBeat.o(82669);
    }

    public void reset() {
        AppMethodBeat.i(82670);
        if (this.videoFilterList != null) {
            this.videoFilterList.reset();
        }
        AppMethodBeat.o(82670);
    }

    public void setAudioPause(boolean z) {
        AppMethodBeat.i(82671);
        if (this.videoFilterList != null) {
            this.videoFilterList.setAudioPause(z);
        }
        AppMethodBeat.o(82671);
    }
}
