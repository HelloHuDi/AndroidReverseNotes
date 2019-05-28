package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
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
    private C41672h[] mCopyFrame = new C41672h[2];
    public BaseFilter mEffectFilter;
    private C41672h mFilterFrame = new C41672h();
    private C41672h mGridFrame = new C41672h();
    private C41672h mLastRenderFrame;
    private BaseFilter mMaskFilter = new BaseFilter(VideoFilterFactory.FRAGMENT_SHADER_MASK);
    private C41672h mMotionBlurFrame = new C41672h();
    private C41672h mRotateScaleFrame = new C41672h();
    public ShakaFilterBase mShakaFilter;
    private C41672h mShakaFrame = new C41672h();
    private ShakaMotionBlurFilter motionBlurFilter = new ShakaMotionBlurFilter();
    public FabbyMvPart mvPart;
    private float progress;
    private RotateScaleFilter rotateScaleFilter = new RotateScaleFilter();
    private long startTimeStamp = -1;

    public FabbyMvFilter() {
        AppMethodBeat.m2504i(82264);
        AppMethodBeat.m2505o(82264);
    }

    public C41672h updateAndRender(C41672h c41672h, Map<Integer, C41672h> map, long j) {
        AppMethodBeat.m2504i(82265);
        if (isRenderReady()) {
            C41672h renderCoverFilter;
            if (this.mvPart.getGridType(this.progress) == 6) {
                int gridOrder = this.mvPart.getGridOrder(this.progress);
                BenchUtil.benchStart("[showPreview][FABBY] bg");
                C41672h renderBgFilter = renderBgFilter(c41672h);
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
                                drawOnFrame = this.mCanvasFilters.drawOnFrame(gridModel, updateAndRenderCameraFrame((C41672h) map.get(Integer.valueOf(gridModel.renderId)), this.progress), gridSetting.canvasRect.width, gridSetting.canvasRect.height);
                                if (drawOnFrame != null) {
                                    arrayList.add(drawOnFrame);
                                }
                            }
                        }
                    }
                    GlUtil.setBlendMode(true);
                    this.fastRenderFilter.render(arrayList, this.mGridFrame);
                    GlUtil.setBlendMode(false);
                    c41672h = this.mGridFrame;
                    BenchUtil.benchEnd("[showPreview][FABBY] grid");
                } else if (gridOrder == 1) {
                    BenchUtil.benchStart("[showPreview][FABBY] grid");
                    arrayList = new ArrayList();
                    gridSetting = this.mvPart.getGridSetting(this.progress);
                    if (gridSetting != null) {
                        for (GridModel gridModel2 : gridSetting.canvasRectList) {
                            if (map.containsKey(Integer.valueOf(gridModel2.renderId))) {
                                drawOnFrame = this.mCanvasFilters.drawOnFrame(gridModel2, (C41672h) map.get(Integer.valueOf(gridModel2.renderId)), gridSetting.canvasRect.width, gridSetting.canvasRect.height);
                                if (drawOnFrame != null) {
                                    arrayList.add(drawOnFrame);
                                }
                            }
                        }
                    }
                    GlUtil.setBlendMode(true);
                    this.fastRenderFilter.render(arrayList, this.mGridFrame);
                    GlUtil.setBlendMode(false);
                    c41672h = updateAndRenderCameraFrame(this.mGridFrame, this.progress);
                    BenchUtil.benchEnd("[showPreview][FABBY] grid");
                }
                BenchUtil.benchStart("[showPreview][FABBY] cover");
                renderCoverFilter = renderCoverFilter(c41672h);
                BenchUtil.benchEnd("[showPreview][FABBY] cover");
                BenchUtil.benchStart("[showPreview][FABBY] fg");
                renderCoverFilter = renderFgFilter(renderCoverFilter);
                BenchUtil.benchEnd("[showPreview][FABBY] fg");
                BenchUtil.benchStart("[showPreview][FABBY] effect");
                renderCoverFilter = updateAndRenderFilterEffect(renderCoverFilter, this.progress);
                BenchUtil.benchEnd("[showPreview][FABBY] effect");
            } else {
                renderCoverFilter = (C41672h) map.values().iterator().next();
                BenchUtil.benchStart("[showPreview][FABBY] bg");
                C41672h renderBgFilter2 = renderBgFilter(c41672h);
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
                C41672h renderFgFilter = renderFgFilter(renderCoverFilter);
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
            AppMethodBeat.m2505o(82265);
            return renderCoverFilter;
        }
        AppMethodBeat.m2505o(82265);
        return c41672h;
    }

    private boolean isRenderReady() {
        boolean z = true;
        AppMethodBeat.m2504i(82266);
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
        AppMethodBeat.m2505o(82266);
        return z;
    }

    public C41672h getLastRenderFrame() {
        return this.mLastRenderFrame;
    }

    private C41672h updateAndRenderCameraFrame(C41672h c41672h, float f) {
        C41672h c41672h2;
        AppMethodBeat.m2504i(82267);
        C41672h updateAndRenderShakaEffect = updateAndRenderShakaEffect(c41672h, f);
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
            c41672h2 = this.mRotateScaleFrame;
        } else {
            c41672h2 = updateAndRenderShakaEffect;
        }
        if (needMotionBlur((float) blurSize)) {
            FrameUtil.clearFrame(this.mMotionBlurFrame, 0.0f, 0.0f, 0.0f, 0.0f, c41672h2.width, c41672h2.height);
            this.motionBlurFilter.RenderProcess(c41672h2.texture[0], c41672h2.width, c41672h2.height, -1, 0.0d, this.mMotionBlurFrame);
            c41672h2 = FrameUtil.getLastRenderFrame(this.mMotionBlurFrame);
        }
        if (c41672h != c41672h2) {
            this.mCopyFilter.RenderProcess(c41672h2.texture[0], c41672h2.width, c41672h2.height, -1, 0.0d, c41672h);
        }
        AppMethodBeat.m2505o(82267);
        return c41672h;
    }

    private boolean needMotionBlur(float f) {
        AppMethodBeat.m2504i(82268);
        if (Float.compare(f, 0.0f) != 0) {
            AppMethodBeat.m2505o(82268);
            return true;
        }
        AppMethodBeat.m2505o(82268);
        return false;
    }

    private boolean needTransform(double d, double d2, double d3, PointF pointF, PointF pointF2) {
        AppMethodBeat.m2504i(82269);
        if (Double.compare(d, 1.0d) == 0 && d2 % 360.0d == 0.0d && Double.compare(d3, 1.0d) == 0 && Float.compare(pointF.x, 0.0f) == 0 && Float.compare(pointF.y, 0.0f) == 0 && Float.compare(pointF2.x, 0.0f) == 0 && Float.compare(pointF2.y, 0.0f) == 0) {
            AppMethodBeat.m2505o(82269);
            return false;
        }
        AppMethodBeat.m2505o(82269);
        return true;
    }

    private C41672h updateAndRenderShakaEffect(C41672h c41672h, float f) {
        AppMethodBeat.m2504i(82270);
        if (this.mShakaFilter == null) {
            AppMethodBeat.m2505o(82270);
            return c41672h;
        }
        this.mShakaFilter.setParameters(this.mvPart.getShakaValueMap(f));
        FrameUtil.clearFrame(this.mShakaFrame, 0.0f, 0.0f, 0.0f, 0.0f, c41672h.width, c41672h.height);
        this.mShakaFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mShakaFrame);
        c41672h = this.mShakaFrame;
        AppMethodBeat.m2505o(82270);
        return c41672h;
    }

    private C41672h updateAndRenderFilterEffect(C41672h c41672h, float f) {
        AppMethodBeat.m2504i(82271);
        int i = this.mvPart.getFilterParam(f) != 0 ? 1 : 0;
        if (this.mEffectFilter == null || i == 0) {
            AppMethodBeat.m2505o(82271);
            return c41672h;
        }
        this.mEffectFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mFilterFrame);
        c41672h = FrameUtil.getLastRenderFrame(this.mFilterFrame);
        AppMethodBeat.m2505o(82271);
        return c41672h;
    }

    private C41672h updateAndRenderGrid(C41672h c41672h, C41672h c41672h2, float f) {
        AppMethodBeat.m2504i(82272);
        this.gridEffectFilter.setGridType(this.mvPart.getGridType(f));
        c41672h.mo67189a(-1, c41672h.width, c41672h.height, 0.0d);
        GlUtil.setBlendMode(true);
        this.gridEffectFilter.OnDrawFrameGLSL();
        this.gridEffectFilter.renderTexture(c41672h2.texture[0], c41672h2.width, c41672h2.height);
        GlUtil.setBlendMode(false);
        AppMethodBeat.m2505o(82272);
        return c41672h;
    }

    public void reset() {
        AppMethodBeat.m2504i(82273);
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
        AppMethodBeat.m2505o(82273);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(82274);
        if (this.bgFilter != null) {
            this.bgFilter.updateVideoSize(i, i2, d);
        }
        if (this.fgFilter != null) {
            this.fgFilter.updateVideoSize(i, i2, d);
        }
        if (this.coverFilter != null) {
            this.coverFilter.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.m2505o(82274);
    }

    public C41672h renderBgFilter(C41672h c41672h) {
        AppMethodBeat.m2504i(82275);
        C41672h renderForStaticFilters = renderForStaticFilters(c41672h, this.bgFilter);
        AppMethodBeat.m2505o(82275);
        return renderForStaticFilters;
    }

    public C41672h renderCoverFilter(C41672h c41672h) {
        AppMethodBeat.m2504i(82276);
        C41672h renderForStaticFilters = renderForStaticFilters(c41672h, this.coverFilter);
        AppMethodBeat.m2505o(82276);
        return renderForStaticFilters;
    }

    public C41672h renderFgFilter(C41672h c41672h) {
        AppMethodBeat.m2504i(82277);
        C41672h renderForStaticFilters = renderForStaticFilters(c41672h, this.fgFilter);
        AppMethodBeat.m2505o(82277);
        return renderForStaticFilters;
    }

    private C41672h renderForStaticFilters(C41672h c41672h, StaticStickerFilter staticStickerFilter) {
        AppMethodBeat.m2504i(82278);
        c41672h.mo67189a(-1, c41672h.width, c41672h.height, 0.0d);
        if (staticStickerFilter == null || !staticStickerFilter.isRenderReady()) {
            AppMethodBeat.m2505o(82278);
        } else {
            C41672h c41672h2;
            staticStickerFilter.updateVideoSize(c41672h.width, c41672h.height, 0.0d);
            if (c41672h.texture[0] == this.mCopyFrame[0].texture[0]) {
                c41672h2 = this.mCopyFrame[1];
            } else {
                c41672h2 = this.mCopyFrame[0];
            }
            c41672h.mo67189a(-1, c41672h.width, c41672h.height, 0.0d);
            GlUtil.setBlendMode(true);
            if (VideoFilterUtil.canUseBlendMode(staticStickerFilter)) {
                BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
                staticStickerFilter.OnDrawFrameGLSL();
                staticStickerFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
                BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
            } else {
                C41672h renderProcessBySwitchFbo;
                if (VideoFilterUtil.needCopy(staticStickerFilter)) {
                    renderProcessBySwitchFbo = FrameUtil.renderProcessBySwitchFbo(c41672h.texture[0], c41672h.width, c41672h.height, this.mCopyFilter, c41672h, c41672h2);
                } else {
                    renderProcessBySwitchFbo = c41672h;
                }
                BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + staticStickerFilter.getClass().getName());
                c41672h = VideoFrameUtil.renderProcessBySwitchFbo(renderProcessBySwitchFbo.texture[0], renderProcessBySwitchFbo.width, renderProcessBySwitchFbo.height, staticStickerFilter, c41672h, c41672h2);
                BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + staticStickerFilter.getClass().getName());
            }
            GlUtil.setBlendMode(false);
            AppMethodBeat.m2505o(82278);
        }
        return c41672h;
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82279);
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
            this.mCopyFrame[i] = new C41672h();
        }
        this.motionBlurFilter.ApplyGLSLFilter(false, 0.0f, 0.0f);
        this.fastRenderFilter.applyGLSLFilter();
        AppMethodBeat.m2505o(82279);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82280);
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
        AppMethodBeat.m2505o(82280);
    }

    public void clear() {
        AppMethodBeat.m2504i(82281);
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
        for (C41672h clear : this.mCopyFrame) {
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
        AppMethodBeat.m2505o(82281);
    }

    public long getTimestamp() {
        return this.startTimeStamp;
    }

    private void mergeFrame(C41672h c41672h, C41672h c41672h2) {
        AppMethodBeat.m2504i(82282);
        c41672h.mo67189a(-1, c41672h.width, c41672h.height, 0.0d);
        GlUtil.setBlendMode(true);
        this.mMaskFilter.OnDrawFrameGLSL();
        this.mMaskFilter.renderTexture(c41672h2.texture[0], c41672h2.width, c41672h2.height);
        GlUtil.setBlendMode(false);
        AppMethodBeat.m2505o(82282);
    }

    public void updateTextureParam(long j) {
        AppMethodBeat.m2504i(82283);
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
        AppMethodBeat.m2505o(82283);
    }

    public Map<Integer, PointF> getGridScaleMap() {
        AppMethodBeat.m2504i(82284);
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
        AppMethodBeat.m2505o(82284);
        return hashMap;
    }
}
