package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.factory.ShakaFilterFactory;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFrameUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FabbyMvFilter {
    public StaticStickerFilter bgFilter;
    public StaticStickerFilter coverFilter;
    private FastRenderFilter fastRenderFilter = new FastRenderFilter();
    public StaticStickerFilter fgFilter;
    private GridEffectFilter gridEffectFilter = new GridEffectFilter();
    private CanvasFilters mCanvasFilters = new CanvasFilters();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private h[] mCopyFrame = new h[2];
    public BaseFilter mEffectFilter;
    private h mFilterFrame = new h();
    private h mGridFrame = new h();
    private h mLastRenderFrame;
    private BaseFilter mMaskFilter = new BaseFilter(VideoFilterFactory.FRAGMENT_SHADER_MASK);
    private h mMotionBlurFrame = new h();
    private h mRotateScaleFrame = new h();
    public ShakaFilterBase mShakaFilter;
    private h mShakaFrame = new h();
    private ShakaMotionBlurFilter motionBlurFilter = new ShakaMotionBlurFilter();
    public FabbyMvPart mvPart;
    private float progress;
    private RotateScaleFilter rotateScaleFilter = new RotateScaleFilter();
    private long startTimeStamp = -1;

    public FabbyMvFilter() {
        AppMethodBeat.i(82264);
        AppMethodBeat.o(82264);
    }

    public h updateAndRender(h hVar, Map<Integer, h> map, long j) {
        AppMethodBeat.i(82265);
        if (isRenderReady()) {
            h renderCoverFilter;
            if (this.mvPart.getGridType(this.progress) == 6) {
                int gridOrder = this.mvPart.getGridOrder(this.progress);
                BenchUtil.benchStart("[showPreview][FABBY] bg");
                h renderBgFilter = renderBgFilter(hVar);
                BenchUtil.benchEnd("[showPreview][FABBY] bg");
                this.mCopyFilter.RenderProcess(renderBgFilter.texture[0], renderBgFilter.width, renderBgFilter.height, -1, 0.0d, this.mGridFrame);
                ArrayList arrayList;
                GridSettingModel gridSetting;
                RenderParam drawOnFrame;
                if (gridOrder == 0) {
                    BenchUtil.benchStart("[showPreview][FABBY] grid");
                    arrayList = new ArrayList();
                    gridSetting = this.mvPart.getGridSetting(this.progress);
                    if (gridSetting != null) {
                        for (GridModel gridModel : gridSetting.canvasRectList) {
                            if (map.containsKey(Integer.valueOf(gridModel.renderId))) {
                                drawOnFrame = this.mCanvasFilters.drawOnFrame(gridModel, updateAndRenderCameraFrame((h) map.get(Integer.valueOf(gridModel.renderId)), this.progress), gridSetting.canvasRect.width, gridSetting.canvasRect.height);
                                if (drawOnFrame != null) {
                                    arrayList.add(drawOnFrame);
                                }
                            }
                        }
                    }
                    GlUtil.setBlendMode(true);
                    this.fastRenderFilter.render(arrayList, this.mGridFrame);
                    GlUtil.setBlendMode(false);
                    hVar = this.mGridFrame;
                    BenchUtil.benchEnd("[showPreview][FABBY] grid");
                } else if (gridOrder == 1) {
                    BenchUtil.benchStart("[showPreview][FABBY] grid");
                    arrayList = new ArrayList();
                    gridSetting = this.mvPart.getGridSetting(this.progress);
                    if (gridSetting != null) {
                        for (GridModel gridModel2 : gridSetting.canvasRectList) {
                            if (map.containsKey(Integer.valueOf(gridModel2.renderId))) {
                                drawOnFrame = this.mCanvasFilters.drawOnFrame(gridModel2, (h) map.get(Integer.valueOf(gridModel2.renderId)), gridSetting.canvasRect.width, gridSetting.canvasRect.height);
                                if (drawOnFrame != null) {
                                    arrayList.add(drawOnFrame);
                                }
                            }
                        }
                    }
                    GlUtil.setBlendMode(true);
                    this.fastRenderFilter.render(arrayList, this.mGridFrame);
                    GlUtil.setBlendMode(false);
                    hVar = updateAndRenderCameraFrame(this.mGridFrame, this.progress);
                    BenchUtil.benchEnd("[showPreview][FABBY] grid");
                }
                BenchUtil.benchStart("[showPreview][FABBY] cover");
                renderCoverFilter = renderCoverFilter(hVar);
                BenchUtil.benchEnd("[showPreview][FABBY] cover");
                BenchUtil.benchStart("[showPreview][FABBY] fg");
                renderCoverFilter = renderFgFilter(renderCoverFilter);
                BenchUtil.benchEnd("[showPreview][FABBY] fg");
                BenchUtil.benchStart("[showPreview][FABBY] effect");
                renderCoverFilter = updateAndRenderFilterEffect(renderCoverFilter, this.progress);
                BenchUtil.benchEnd("[showPreview][FABBY] effect");
            } else {
                renderCoverFilter = (h) map.values().iterator().next();
                BenchUtil.benchStart("[showPreview][FABBY] bg");
                h renderBgFilter2 = renderBgFilter(hVar);
                BenchUtil.benchEnd("[showPreview][FABBY] bg");
                int gridMode = this.mvPart.getGridMode(this.progress);
                int gridOrder2 = this.mvPart.getGridOrder(this.progress);
                if (gridMode == 0) {
                    BenchUtil.benchStart("[showPreview][FABBY] merge");
                    if (gridOrder2 == 0) {
                        mergeFrame(renderBgFilter2, updateAndRenderCameraFrame(renderCoverFilter, this.progress));
                    } else if (gridOrder2 == 1) {
                        mergeFrame(renderBgFilter2, renderCoverFilter);
                    }
                    BenchUtil.benchEnd("[showPreview][FABBY] merge");
                    renderCoverFilter = renderBgFilter2;
                } else {
                    this.mCopyFilter.RenderProcess(renderBgFilter2.texture[0], renderBgFilter2.width, renderBgFilter2.height, -1, 0.0d, this.mGridFrame);
                    renderCoverFilter = gridOrder2 == 0 ? updateAndRenderGrid(this.mGridFrame, updateAndRenderCameraFrame(renderCoverFilter, this.progress), this.progress) : gridOrder2 == 1 ? updateAndRenderCameraFrame(updateAndRenderGrid(this.mGridFrame, renderCoverFilter, this.progress), this.progress) : renderBgFilter2;
                }
                BenchUtil.benchStart("[showPreview][FABBY] cover");
                renderCoverFilter = renderCoverFilter(renderCoverFilter);
                BenchUtil.benchEnd("[showPreview][FABBY] cover");
                BenchUtil.benchStart("[showPreview][FABBY] fg");
                h renderFgFilter = renderFgFilter(renderCoverFilter);
                BenchUtil.benchEnd("[showPreview][FABBY] fg");
                if (gridMode == 0) {
                    BenchUtil.benchStart("[showPreview][FABBY] grid");
                    FrameUtil.clearFrame(this.mGridFrame, 0.0f, 0.0f, 0.0f, 0.0f, renderFgFilter.width, renderFgFilter.height);
                    renderCoverFilter = updateAndRenderGrid(this.mGridFrame, renderFgFilter, this.progress);
                    BenchUtil.benchEnd("[showPreview][FABBY] grid");
                    if (gridOrder2 == 1) {
                        renderCoverFilter = updateAndRenderCameraFrame(renderCoverFilter, this.progress);
                    }
                } else {
                    renderCoverFilter = renderFgFilter;
                }
                renderCoverFilter = updateAndRenderFilterEffect(renderCoverFilter, this.progress);
            }
            this.mLastRenderFrame = renderCoverFilter;
            AppMethodBeat.o(82265);
            return renderCoverFilter;
        }
        AppMethodBeat.o(82265);
        return hVar;
    }

    private boolean isRenderReady() {
        boolean z = true;
        AppMethodBeat.i(82266);
        boolean z2 = this.bgFilter != null ? this.bgFilter.isRenderReady() : true;
        if (this.coverFilter != null) {
            if (z2 && this.coverFilter.isRenderReady()) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (this.fgFilter == null) {
            z = z2;
        } else if (!(z2 && this.fgFilter.isRenderReady())) {
            z = false;
        }
        AppMethodBeat.o(82266);
        return z;
    }

    public h getLastRenderFrame() {
        return this.mLastRenderFrame;
    }

    private h updateAndRenderCameraFrame(h hVar, float f) {
        h hVar2;
        AppMethodBeat.i(82267);
        h updateAndRenderShakaEffect = updateAndRenderShakaEffect(hVar, f);
        double scale = this.mvPart.getScale(f);
        double degree = this.mvPart.getDegree(f);
        double alpha = this.mvPart.getAlpha(f);
        PointF anchor = this.mvPart.getAnchor(f);
        PointF translate = this.mvPart.getTranslate(f);
        double blurSize = this.mvPart.getBlurSize(f);
        double blurAngle = this.mvPart.getBlurAngle(f);
        this.rotateScaleFilter.updateParams((float) scale, (float) ((3.141592653589793d * degree) / 180.0d), (float) alpha, anchor, translate, new PointF((float) updateAndRenderShakaEffect.width, (float) updateAndRenderShakaEffect.height));
        this.motionBlurFilter.updateParams((float) blurSize, (float) blurAngle, updateAndRenderShakaEffect.width, updateAndRenderShakaEffect.height);
        if (needTransform(scale, degree, alpha, anchor, translate)) {
            FrameUtil.clearFrame(this.mRotateScaleFrame, 0.0f, 0.0f, 0.0f, 0.0f, updateAndRenderShakaEffect.width, updateAndRenderShakaEffect.height);
            this.rotateScaleFilter.RenderProcess(updateAndRenderShakaEffect.texture[0], updateAndRenderShakaEffect.width, updateAndRenderShakaEffect.height, -1, 0.0d, this.mRotateScaleFrame);
            hVar2 = this.mRotateScaleFrame;
        } else {
            hVar2 = updateAndRenderShakaEffect;
        }
        if (needMotionBlur((float) blurSize)) {
            FrameUtil.clearFrame(this.mMotionBlurFrame, 0.0f, 0.0f, 0.0f, 0.0f, hVar2.width, hVar2.height);
            this.motionBlurFilter.RenderProcess(hVar2.texture[0], hVar2.width, hVar2.height, -1, 0.0d, this.mMotionBlurFrame);
            hVar2 = FrameUtil.getLastRenderFrame(this.mMotionBlurFrame);
        }
        if (hVar != hVar2) {
            this.mCopyFilter.RenderProcess(hVar2.texture[0], hVar2.width, hVar2.height, -1, 0.0d, hVar);
        }
        AppMethodBeat.o(82267);
        return hVar;
    }

    private boolean needMotionBlur(float f) {
        AppMethodBeat.i(82268);
        if (Float.compare(f, 0.0f) != 0) {
            AppMethodBeat.o(82268);
            return true;
        }
        AppMethodBeat.o(82268);
        return false;
    }

    private boolean needTransform(double d, double d2, double d3, PointF pointF, PointF pointF2) {
        AppMethodBeat.i(82269);
        if (Double.compare(d, 1.0d) == 0 && d2 % 360.0d == 0.0d && Double.compare(d3, 1.0d) == 0 && Float.compare(pointF.x, 0.0f) == 0 && Float.compare(pointF.y, 0.0f) == 0 && Float.compare(pointF2.x, 0.0f) == 0 && Float.compare(pointF2.y, 0.0f) == 0) {
            AppMethodBeat.o(82269);
            return false;
        }
        AppMethodBeat.o(82269);
        return true;
    }

    private h updateAndRenderShakaEffect(h hVar, float f) {
        AppMethodBeat.i(82270);
        if (this.mShakaFilter == null) {
            AppMethodBeat.o(82270);
            return hVar;
        }
        this.mShakaFilter.setParameters(this.mvPart.getShakaValueMap(f));
        FrameUtil.clearFrame(this.mShakaFrame, 0.0f, 0.0f, 0.0f, 0.0f, hVar.width, hVar.height);
        this.mShakaFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mShakaFrame);
        hVar = this.mShakaFrame;
        AppMethodBeat.o(82270);
        return hVar;
    }

    private h updateAndRenderFilterEffect(h hVar, float f) {
        AppMethodBeat.i(82271);
        int i = this.mvPart.getFilterParam(f) != 0 ? 1 : 0;
        if (this.mEffectFilter == null || i == 0) {
            AppMethodBeat.o(82271);
            return hVar;
        }
        this.mEffectFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mFilterFrame);
        hVar = FrameUtil.getLastRenderFrame(this.mFilterFrame);
        AppMethodBeat.o(82271);
        return hVar;
    }

    private h updateAndRenderGrid(h hVar, h hVar2, float f) {
        AppMethodBeat.i(82272);
        this.gridEffectFilter.setGridType(this.mvPart.getGridType(f));
        hVar.a(-1, hVar.width, hVar.height, 0.0d);
        GlUtil.setBlendMode(true);
        this.gridEffectFilter.OnDrawFrameGLSL();
        this.gridEffectFilter.renderTexture(hVar2.texture[0], hVar2.width, hVar2.height);
        GlUtil.setBlendMode(false);
        AppMethodBeat.o(82272);
        return hVar;
    }

    public void reset() {
        AppMethodBeat.i(82273);
        this.startTimeStamp = -1;
        if (this.bgFilter != null) {
            this.bgFilter.resetFabbyProgress();
        }
        if (this.fgFilter != null) {
            this.fgFilter.resetFabbyProgress();
        }
        if (this.coverFilter != null) {
            this.coverFilter.resetFabbyProgress();
        }
        AppMethodBeat.o(82273);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82274);
        if (this.bgFilter != null) {
            this.bgFilter.updateVideoSize(i, i2, d);
        }
        if (this.fgFilter != null) {
            this.fgFilter.updateVideoSize(i, i2, d);
        }
        if (this.coverFilter != null) {
            this.coverFilter.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.o(82274);
    }

    public h renderBgFilter(h hVar) {
        AppMethodBeat.i(82275);
        h renderForStaticFilters = renderForStaticFilters(hVar, this.bgFilter);
        AppMethodBeat.o(82275);
        return renderForStaticFilters;
    }

    public h renderCoverFilter(h hVar) {
        AppMethodBeat.i(82276);
        h renderForStaticFilters = renderForStaticFilters(hVar, this.coverFilter);
        AppMethodBeat.o(82276);
        return renderForStaticFilters;
    }

    public h renderFgFilter(h hVar) {
        AppMethodBeat.i(82277);
        h renderForStaticFilters = renderForStaticFilters(hVar, this.fgFilter);
        AppMethodBeat.o(82277);
        return renderForStaticFilters;
    }

    private h renderForStaticFilters(h hVar, StaticStickerFilter staticStickerFilter) {
        AppMethodBeat.i(82278);
        hVar.a(-1, hVar.width, hVar.height, 0.0d);
        if (staticStickerFilter == null || !staticStickerFilter.isRenderReady()) {
            AppMethodBeat.o(82278);
        } else {
            h hVar2;
            staticStickerFilter.updateVideoSize(hVar.width, hVar.height, 0.0d);
            if (hVar.texture[0] == this.mCopyFrame[0].texture[0]) {
                hVar2 = this.mCopyFrame[1];
            } else {
                hVar2 = this.mCopyFrame[0];
            }
            hVar.a(-1, hVar.width, hVar.height, 0.0d);
            GlUtil.setBlendMode(true);
            if (VideoFilterUtil.canUseBlendMode(staticStickerFilter)) {
                BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
                staticStickerFilter.OnDrawFrameGLSL();
                staticStickerFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
                BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
            } else {
                h renderProcessBySwitchFbo;
                if (VideoFilterUtil.needCopy(staticStickerFilter)) {
                    renderProcessBySwitchFbo = FrameUtil.renderProcessBySwitchFbo(hVar.texture[0], hVar.width, hVar.height, this.mCopyFilter, hVar, hVar2);
                } else {
                    renderProcessBySwitchFbo = hVar;
                }
                BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + staticStickerFilter.getClass().getName());
                hVar = VideoFrameUtil.renderProcessBySwitchFbo(renderProcessBySwitchFbo.texture[0], renderProcessBySwitchFbo.width, renderProcessBySwitchFbo.height, staticStickerFilter, hVar, hVar2);
                BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + staticStickerFilter.getClass().getName());
            }
            GlUtil.setBlendMode(false);
            AppMethodBeat.o(82278);
        }
        return hVar;
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82279);
        if (this.bgFilter != null) {
            this.bgFilter.ApplyGLSLFilter();
        }
        if (this.fgFilter != null) {
            this.fgFilter.ApplyGLSLFilter();
        }
        if (this.coverFilter != null) {
            this.coverFilter.ApplyGLSLFilter();
        }
        this.mCopyFilter.ApplyGLSLFilter();
        this.mCanvasFilters.ApplyGLSLFilter();
        this.gridEffectFilter.ApplyGLSLFilter();
        this.rotateScaleFilter.ApplyGLSLFilter();
        this.mMaskFilter.ApplyGLSLFilter();
        if (this.mvPart.getShakaEffectItem() != null) {
            this.mShakaFilter = ShakaFilterFactory.create(this.mvPart.getShakaEffectItem().getFilterType());
            if (this.mShakaFilter != null) {
                this.mShakaFilter.ApplyGLSLFilter();
            }
        }
        if (this.mEffectFilter != null) {
            this.mEffectFilter.ApplyGLSLFilter(false, 0.0f, 0.0f);
        }
        for (int i = 0; i < this.mCopyFrame.length; i++) {
            this.mCopyFrame[i] = new h();
        }
        this.motionBlurFilter.ApplyGLSLFilter(false, 0.0f, 0.0f);
        this.fastRenderFilter.applyGLSLFilter();
        AppMethodBeat.o(82279);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82280);
        if (this.bgFilter != null) {
            VideoFilterUtil.setRenderMode(this.bgFilter, i);
        }
        if (this.fgFilter != null) {
            VideoFilterUtil.setRenderMode(this.fgFilter, i);
        }
        if (this.coverFilter != null) {
            VideoFilterUtil.setRenderMode(this.coverFilter, i);
        }
        if (this.mEffectFilter != null) {
            VideoFilterUtil.setRenderMode(this.mEffectFilter, i);
        }
        VideoFilterUtil.setRenderMode(this.gridEffectFilter, i);
        VideoFilterUtil.setRenderMode(this.rotateScaleFilter, i);
        this.mCanvasFilters.setRenderMode(i);
        AppMethodBeat.o(82280);
    }

    public void clear() {
        AppMethodBeat.i(82281);
        if (this.bgFilter != null) {
            this.bgFilter.clearGLSLSelf();
        }
        if (this.fgFilter != null) {
            this.fgFilter.clearGLSLSelf();
        }
        if (this.coverFilter != null) {
            this.coverFilter.clearGLSLSelf();
        }
        if (this.mEffectFilter != null) {
            this.mEffectFilter.clearGLSLSelf();
        }
        this.gridEffectFilter.clearGLSLSelf();
        this.rotateScaleFilter.clearGLSLSelf();
        this.mMaskFilter.clearGLSLSelf();
        this.mCopyFilter.clearGLSLSelf();
        this.mCanvasFilters.clearGLSLSelf();
        this.motionBlurFilter.ClearGLSL();
        for (h clear : this.mCopyFrame) {
            clear.clear();
        }
        this.mShakaFrame.clear();
        this.mMotionBlurFrame.clear();
        this.mRotateScaleFrame.clear();
        this.mFilterFrame.clear();
        if (this.mLastRenderFrame != null) {
            this.mLastRenderFrame.clear();
        }
        this.fastRenderFilter.clearGLSLSelf();
        if (this.mGridFrame != null) {
            this.mGridFrame.clear();
        }
        AppMethodBeat.o(82281);
    }

    public long getTimestamp() {
        return this.startTimeStamp;
    }

    private void mergeFrame(h hVar, h hVar2) {
        AppMethodBeat.i(82282);
        hVar.a(-1, hVar.width, hVar.height, 0.0d);
        GlUtil.setBlendMode(true);
        this.mMaskFilter.OnDrawFrameGLSL();
        this.mMaskFilter.renderTexture(hVar2.texture[0], hVar2.width, hVar2.height);
        GlUtil.setBlendMode(false);
        AppMethodBeat.o(82282);
    }

    public void updateTextureParam(long j) {
        AppMethodBeat.i(82283);
        if (this.startTimeStamp < 0) {
            this.startTimeStamp = j;
        }
        this.progress = ((float) (j - this.startTimeStamp)) / ((float) this.mvPart.duration);
        if (this.bgFilter != null) {
            this.bgFilter.updateFabbyProgress(j);
        }
        if (this.coverFilter != null) {
            this.coverFilter.updateFabbyProgress(j);
        }
        if (this.fgFilter != null) {
            this.fgFilter.updateFabbyProgress(j);
        }
        AppMethodBeat.o(82283);
    }

    public Map<Integer, PointF> getGridScaleMap() {
        AppMethodBeat.i(82284);
        HashMap hashMap = new HashMap();
        if (this.mvPart.getGridType(this.progress) == 6) {
            GridSettingModel gridSetting = this.mvPart.getGridSetting(this.progress);
            if (gridSetting != null) {
                for (GridModel gridModel : gridSetting.canvasRectList) {
                    float min = Math.min(Math.max(((float) gridModel.canvasRect.width) / ((float) gridSetting.canvasRect.width), ((float) gridModel.canvasRect.height) / ((float) gridSetting.canvasRect.height)), 1.0f);
                    if (hashMap.get(Integer.valueOf(gridModel.renderId)) != null) {
                        PointF pointF = (PointF) hashMap.get(Integer.valueOf(gridModel.renderId));
                        if (pointF.x < min || pointF.y < min) {
                            pointF.x = min;
                            pointF.y = min;
                            hashMap.put(Integer.valueOf(gridModel.renderId), pointF);
                        }
                    } else {
                        hashMap.put(Integer.valueOf(gridModel.renderId), new PointF(min, min));
                    }
                }
            }
        } else {
            hashMap.put(Integer.valueOf(0), new PointF(1.0f, 1.0f));
        }
        AppMethodBeat.o(82284);
        return hashMap;
    }
}
