package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.filter.SplitFilter;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoSDKMaterialParser;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class PTSticker {
    public static final String PERF_LOG = "[showPreview]";
    private VideoPreviewFaceOutlineDetector faceDetector;
    private BaseFilter mCopyFilter;
    private C41672h mCopyFrame;
    private C41672h[] mInputFrame;
    private int[] mInputTex;
    private long mLastTimeStamp;
    private boolean mPause;
    private long mPauseTimeDiff;
    private SplitFilter mSplitFilter;
    private VideoFilterList mVideoFilters;
    private float splitScreen;

    public PTSticker(String str, VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
        AppMethodBeat.m2504i(81610);
        this.mCopyFilter = new BaseFilter(GLSLRender.bJB);
        this.mSplitFilter = new SplitFilter();
        this.mInputFrame = new C41672h[2];
        this.mCopyFrame = new C41672h();
        this.mInputTex = new int[1];
        construct(VideoSDKMaterialParser.parseVideoMaterial(str, "params"), videoPreviewFaceOutlineDetector);
        AppMethodBeat.m2505o(81610);
    }

    public PTSticker(VideoMaterial videoMaterial, VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
        AppMethodBeat.m2504i(81611);
        this.mCopyFilter = new BaseFilter(GLSLRender.bJB);
        this.mSplitFilter = new SplitFilter();
        this.mInputFrame = new C41672h[2];
        this.mCopyFrame = new C41672h();
        this.mInputTex = new int[1];
        construct(videoMaterial, videoPreviewFaceOutlineDetector);
        AppMethodBeat.m2505o(81611);
    }

    private void construct(VideoMaterial videoMaterial, VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
        AppMethodBeat.m2504i(81612);
        if (videoMaterial == null) {
            RuntimeException runtimeException = new RuntimeException("PTSticker init fail!");
            AppMethodBeat.m2505o(81612);
            throw runtimeException;
        }
        VideoMemoryManager.getInstance().loadAllImages(videoMaterial);
        this.mVideoFilters = VideoFilterUtil.createFilters(videoMaterial);
        videoPreviewFaceOutlineDetector.setRefine(VideoMaterialUtil.needOpenRefine(videoMaterial));
        videoPreviewFaceOutlineDetector.setFaceValueDetectType(videoMaterial.getFaceValueDetectType());
        videoPreviewFaceOutlineDetector.clearActionCounter();
        GestureDetector.getInstance().clearActionCounter();
        GestureDetector.getInstance().setConfig(videoMaterial.getHandBoostEnable());
        this.splitScreen = videoMaterial.getSplitScreen();
        this.faceDetector = videoPreviewFaceOutlineDetector;
        AppMethodBeat.m2505o(81612);
    }

    public void init() {
        AppMethodBeat.m2504i(81613);
        this.mCopyFilter.ApplyGLSLFilter();
        this.mVideoFilters.ApplyGLSLFilter();
        this.mSplitFilter.ApplyGLSLFilter();
        for (int i = 0; i < this.mInputFrame.length; i++) {
            this.mInputFrame[i] = new C41672h();
        }
        GLES20.glGenTextures(this.mInputTex.length, this.mInputTex, 0);
        AppMethodBeat.m2505o(81613);
    }

    public void destroy() {
        AppMethodBeat.m2504i(81614);
        destroy(true);
        AppMethodBeat.m2505o(81614);
    }

    public void destroy(boolean z) {
        AppMethodBeat.m2504i(81615);
        this.mCopyFilter.ClearGLSL();
        this.mSplitFilter.ClearGLSL();
        if (this.mVideoFilters != null) {
            this.mVideoFilters.destroy();
        }
        for (C41672h c41672h : this.mInputFrame) {
            if (c41672h != null) {
                c41672h.clear();
            }
        }
        this.mCopyFrame.clear();
        GLES20.glDeleteTextures(this.mInputTex.length, this.mInputTex, 0);
        this.faceDetector.setRefine(false);
        if (z) {
            VideoMemoryManager.getInstance().clear();
        }
        LogicDataManager.getInstance().destroy();
        AppMethodBeat.m2505o(81615);
    }

    public C41672h processTransformRelatedFilters(C41672h c41672h, PTFaceAttr pTFaceAttr, PTSegAttr pTSegAttr) {
        AppMethodBeat.m2504i(81616);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        List handPoints = pTFaceAttr.getHandPoints();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        long updateTimeStamp = getUpdateTimeStamp(pTFaceAttr.getTimeStamp());
        this.mVideoFilters.updateFaceParams(allFacePoints, allFaceAngles, handPoints, c41672h.width);
        BenchUtil.benchStart("updateTextureParam2");
        this.mVideoFilters.updateTextureParam(this.faceDetector.getFaceActionCounter(), triggeredExpression, updateTimeStamp);
        BenchUtil.benchEnd("updateTextureParam2");
        C41672h processTransformRelatedFilters = this.mVideoFilters.processTransformRelatedFilters(c41672h, pTFaceAttr);
        AppMethodBeat.m2505o(81616);
        return processTransformRelatedFilters;
    }

    private long getUpdateTimeStamp(long j) {
        long j2;
        if (this.mPause) {
            this.mPauseTimeDiff = j - this.mLastTimeStamp;
            j2 = this.mLastTimeStamp;
        } else {
            j2 = j - this.mPauseTimeDiff;
        }
        this.mLastTimeStamp = j2;
        return this.mLastTimeStamp;
    }

    public C41672h processStickerFilters(C41672h c41672h, PTFaceAttr pTFaceAttr, PTSegAttr pTSegAttr) {
        AppMethodBeat.m2504i(81617);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        long j = this.mLastTimeStamp;
        int rotation = pTFaceAttr.getRotation();
        C41672h maskFrame = pTSegAttr.getMaskFrame();
        if (pTSegAttr.getMaskFrame() == null || pTFaceAttr.getFaceCount() <= 0) {
            maskFrame = c41672h;
        } else {
            maskFrame = this.mVideoFilters.doFabbyStroke(c41672h, maskFrame);
        }
        this.mVideoFilters.renderARFilterIfNeeded(maskFrame);
        maskFrame = this.mVideoFilters.updateAndRenderHeadCropItemFilters(maskFrame, pTFaceAttr);
        if (this.mVideoFilters.isSegmentRequired()) {
            maskFrame = this.mVideoFilters.updateAndRenderBgFilters(maskFrame, pTFaceAttr);
        }
        if (this.mVideoFilters.render3DFirst()) {
            BenchUtil.benchStart("[showPreview]updateAndRender3DFilter");
            maskFrame = this.mVideoFilters.updateAndRender3DFilter(maskFrame, pTFaceAttr, rotation);
            BenchUtil.benchEnd("[showPreview]updateAndRender3DFilter");
        }
        BenchUtil.benchStart("[showPreview]updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
        maskFrame = this.mVideoFilters.updateAndRenderDynamicStickers(maskFrame, pTFaceAttr);
        BenchUtil.benchEnd("[showPreview]updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
        HashMap hashMap = new HashMap();
        this.mVideoFilters.updateAndRenderMultiViewerMaterial(hashMap, maskFrame, pTFaceAttr);
        C41672h updateAndRenderStaticStickers = this.mVideoFilters.updateAndRenderStaticStickers(maskFrame, pTFaceAttr);
        if (!this.mVideoFilters.render3DFirst()) {
            BenchUtil.benchStart("[showPreview]updateAndRender");
            updateAndRenderStaticStickers = this.mVideoFilters.updateAndRender3DFilter(updateAndRenderStaticStickers, pTFaceAttr, rotation);
            BenchUtil.benchEnd("[showPreview]updateAndRender");
        }
        BenchUtil.benchStart("updateAndRenderActMaterial");
        maskFrame = this.mVideoFilters.updateAndRenderActMaterial(updateAndRenderStaticStickers, allFacePoints, allFaceAngles, rotation, j);
        BenchUtil.benchEnd("updateAndRenderActMaterial");
        if (hashMap.isEmpty()) {
            hashMap.put(Integer.valueOf(0), maskFrame);
        }
        maskFrame = this.mVideoFilters.updateAndRenderFabbyMV(c41672h, hashMap, this.faceDetector.getFaceActionCounter(), triggeredExpression, j);
        AppMethodBeat.m2505o(81617);
        return maskFrame;
    }

    public void reset() {
        AppMethodBeat.m2504i(81618);
        this.mVideoFilters.reset();
        AppMethodBeat.m2505o(81618);
    }

    public void onResume() {
        AppMethodBeat.m2504i(81619);
        this.mVideoFilters.onResume();
        AppMethodBeat.m2505o(81619);
    }

    public void onPause() {
        AppMethodBeat.m2504i(81620);
        this.mVideoFilters.onPause();
        AppMethodBeat.m2505o(81620);
    }

    public void onStickerPause() {
        AppMethodBeat.m2504i(81621);
        if (isSupportPause()) {
            this.mPause = true;
            this.mVideoFilters.setAudioPause(this.mPause);
        }
        AppMethodBeat.m2505o(81621);
    }

    public void onStickerResume() {
        AppMethodBeat.m2504i(81622);
        if (isSupportPause()) {
            this.mPause = false;
            this.mVideoFilters.setAudioPause(this.mPause);
        }
        AppMethodBeat.m2505o(81622);
    }

    public boolean isSegmentRequired() {
        AppMethodBeat.m2504i(81623);
        boolean isSegmentRequired = this.mVideoFilters.isSegmentRequired();
        AppMethodBeat.m2505o(81623);
        return isSegmentRequired;
    }

    public boolean isSupportPause() {
        AppMethodBeat.m2504i(81624);
        boolean isSupportPause = this.mVideoFilters.isSupportPause();
        AppMethodBeat.m2505o(81624);
        return isSupportPause;
    }

    public boolean hasVoiceTextFilter() {
        AppMethodBeat.m2504i(81625);
        if (this.mVideoFilters == null || !this.mVideoFilters.hasVoiceTextFilter()) {
            AppMethodBeat.m2505o(81625);
            return false;
        }
        AppMethodBeat.m2505o(81625);
        return true;
    }

    public boolean hasParticleFilter() {
        AppMethodBeat.m2504i(81626);
        if (this.mVideoFilters == null || !this.mVideoFilters.hasParticleFilter()) {
            AppMethodBeat.m2505o(81626);
            return false;
        }
        AppMethodBeat.m2505o(81626);
        return true;
    }

    public boolean needDetectFace(int i) {
        AppMethodBeat.m2504i(81627);
        boolean needFaceInfo = this.mVideoFilters.needFaceInfo(i);
        AppMethodBeat.m2505o(81627);
        return needFaceInfo;
    }

    public boolean needDetectGesture() {
        AppMethodBeat.m2504i(81628);
        boolean needDetectGesture = this.mVideoFilters.needDetectGesture();
        AppMethodBeat.m2505o(81628);
        return needDetectGesture;
    }

    public void updateCosAlpha(int i) {
        AppMethodBeat.m2504i(81629);
        this.mVideoFilters.updateCosAlpha(i);
        AppMethodBeat.m2505o(81629);
    }

    public void updateVideoSize(int i, int i2, double d, int i3) {
        AppMethodBeat.m2504i(81630);
        this.mVideoFilters.updateVideoSize(i, i2, d, i3);
        AppMethodBeat.m2505o(81630);
    }

    public void setRatioMode(RATIO_MODE ratio_mode) {
        AppMethodBeat.m2504i(81631);
        this.mVideoFilters.setRatioMode(ratio_mode);
        AppMethodBeat.m2505o(81631);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(81632);
        this.mVideoFilters.setRenderMode(i);
        AppMethodBeat.m2505o(81632);
    }

    public boolean is3DMaterial() {
        AppMethodBeat.m2504i(81633);
        boolean is3DMaterial = VideoMaterialUtil.is3DMaterial(this.mVideoFilters.getMaterial());
        AppMethodBeat.m2505o(81633);
        return is3DMaterial;
    }

    public boolean isParticleMaterial() {
        AppMethodBeat.m2504i(81634);
        boolean is3DMaterial = VideoMaterialUtil.is3DMaterial(this.mVideoFilters.getMaterial());
        AppMethodBeat.m2505o(81634);
        return is3DMaterial;
    }

    public boolean needDetectBody() {
        AppMethodBeat.m2504i(81635);
        boolean isBodyDetectMaterial = VideoMaterialUtil.isBodyDetectMaterial(this.mVideoFilters.getMaterial());
        AppMethodBeat.m2505o(81635);
        return isBodyDetectMaterial;
    }

    public boolean needRecordTouchPoint() {
        AppMethodBeat.m2504i(81636);
        boolean needRecordTouchPoint = VideoFilterUtil.needRecordTouchPoint(this.mVideoFilters);
        AppMethodBeat.m2505o(81636);
        return needRecordTouchPoint;
    }

    public void addTouchPoint(PointF pointF) {
        AppMethodBeat.m2504i(81637);
        this.mVideoFilters.addTouchPoint(pointF);
        AppMethodBeat.m2505o(81637);
    }

    public C41672h processSplitFilters(C41672h c41672h, C41672h c41672h2) {
        AppMethodBeat.m2504i(81638);
        if (this.splitScreen <= 0.0f) {
            AppMethodBeat.m2505o(81638);
            return c41672h2;
        }
        C41672h c41672h3 = this.mCopyFrame;
        this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, c41672h2.width, c41672h2.height, -1, 0.0d, c41672h3);
        this.mSplitFilter.setxPos(this.splitScreen);
        this.mSplitFilter.RenderProcess(c41672h2.texture[0], c41672h2.width, c41672h2.height, -1, 0.0d, c41672h3);
        AppMethodBeat.m2505o(81638);
        return c41672h3;
    }
}
