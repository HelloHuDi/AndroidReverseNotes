package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
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
    private h mCopyFrame;
    private h[] mInputFrame;
    private int[] mInputTex;
    private long mLastTimeStamp;
    private boolean mPause;
    private long mPauseTimeDiff;
    private SplitFilter mSplitFilter;
    private VideoFilterList mVideoFilters;
    private float splitScreen;

    public PTSticker(String str, VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
        AppMethodBeat.i(81610);
        this.mCopyFilter = new BaseFilter(GLSLRender.bJB);
        this.mSplitFilter = new SplitFilter();
        this.mInputFrame = new h[2];
        this.mCopyFrame = new h();
        this.mInputTex = new int[1];
        construct(VideoSDKMaterialParser.parseVideoMaterial(str, "params"), videoPreviewFaceOutlineDetector);
        AppMethodBeat.o(81610);
    }

    public PTSticker(VideoMaterial videoMaterial, VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
        AppMethodBeat.i(81611);
        this.mCopyFilter = new BaseFilter(GLSLRender.bJB);
        this.mSplitFilter = new SplitFilter();
        this.mInputFrame = new h[2];
        this.mCopyFrame = new h();
        this.mInputTex = new int[1];
        construct(videoMaterial, videoPreviewFaceOutlineDetector);
        AppMethodBeat.o(81611);
    }

    private void construct(VideoMaterial videoMaterial, VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
        AppMethodBeat.i(81612);
        if (videoMaterial == null) {
            RuntimeException runtimeException = new RuntimeException("PTSticker init fail!");
            AppMethodBeat.o(81612);
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
        AppMethodBeat.o(81612);
    }

    public void init() {
        AppMethodBeat.i(81613);
        this.mCopyFilter.ApplyGLSLFilter();
        this.mVideoFilters.ApplyGLSLFilter();
        this.mSplitFilter.ApplyGLSLFilter();
        for (int i = 0; i < this.mInputFrame.length; i++) {
            this.mInputFrame[i] = new h();
        }
        GLES20.glGenTextures(this.mInputTex.length, this.mInputTex, 0);
        AppMethodBeat.o(81613);
    }

    public void destroy() {
        AppMethodBeat.i(81614);
        destroy(true);
        AppMethodBeat.o(81614);
    }

    public void destroy(boolean z) {
        AppMethodBeat.i(81615);
        this.mCopyFilter.ClearGLSL();
        this.mSplitFilter.ClearGLSL();
        if (this.mVideoFilters != null) {
            this.mVideoFilters.destroy();
        }
        for (h hVar : this.mInputFrame) {
            if (hVar != null) {
                hVar.clear();
            }
        }
        this.mCopyFrame.clear();
        GLES20.glDeleteTextures(this.mInputTex.length, this.mInputTex, 0);
        this.faceDetector.setRefine(false);
        if (z) {
            VideoMemoryManager.getInstance().clear();
        }
        LogicDataManager.getInstance().destroy();
        AppMethodBeat.o(81615);
    }

    public h processTransformRelatedFilters(h hVar, PTFaceAttr pTFaceAttr, PTSegAttr pTSegAttr) {
        AppMethodBeat.i(81616);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        List handPoints = pTFaceAttr.getHandPoints();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        long updateTimeStamp = getUpdateTimeStamp(pTFaceAttr.getTimeStamp());
        this.mVideoFilters.updateFaceParams(allFacePoints, allFaceAngles, handPoints, hVar.width);
        BenchUtil.benchStart("updateTextureParam2");
        this.mVideoFilters.updateTextureParam(this.faceDetector.getFaceActionCounter(), triggeredExpression, updateTimeStamp);
        BenchUtil.benchEnd("updateTextureParam2");
        h processTransformRelatedFilters = this.mVideoFilters.processTransformRelatedFilters(hVar, pTFaceAttr);
        AppMethodBeat.o(81616);
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

    public h processStickerFilters(h hVar, PTFaceAttr pTFaceAttr, PTSegAttr pTSegAttr) {
        AppMethodBeat.i(81617);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        long j = this.mLastTimeStamp;
        int rotation = pTFaceAttr.getRotation();
        h maskFrame = pTSegAttr.getMaskFrame();
        if (pTSegAttr.getMaskFrame() == null || pTFaceAttr.getFaceCount() <= 0) {
            maskFrame = hVar;
        } else {
            maskFrame = this.mVideoFilters.doFabbyStroke(hVar, maskFrame);
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
        h updateAndRenderStaticStickers = this.mVideoFilters.updateAndRenderStaticStickers(maskFrame, pTFaceAttr);
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
        maskFrame = this.mVideoFilters.updateAndRenderFabbyMV(hVar, hashMap, this.faceDetector.getFaceActionCounter(), triggeredExpression, j);
        AppMethodBeat.o(81617);
        return maskFrame;
    }

    public void reset() {
        AppMethodBeat.i(81618);
        this.mVideoFilters.reset();
        AppMethodBeat.o(81618);
    }

    public void onResume() {
        AppMethodBeat.i(81619);
        this.mVideoFilters.onResume();
        AppMethodBeat.o(81619);
    }

    public void onPause() {
        AppMethodBeat.i(81620);
        this.mVideoFilters.onPause();
        AppMethodBeat.o(81620);
    }

    public void onStickerPause() {
        AppMethodBeat.i(81621);
        if (isSupportPause()) {
            this.mPause = true;
            this.mVideoFilters.setAudioPause(this.mPause);
        }
        AppMethodBeat.o(81621);
    }

    public void onStickerResume() {
        AppMethodBeat.i(81622);
        if (isSupportPause()) {
            this.mPause = false;
            this.mVideoFilters.setAudioPause(this.mPause);
        }
        AppMethodBeat.o(81622);
    }

    public boolean isSegmentRequired() {
        AppMethodBeat.i(81623);
        boolean isSegmentRequired = this.mVideoFilters.isSegmentRequired();
        AppMethodBeat.o(81623);
        return isSegmentRequired;
    }

    public boolean isSupportPause() {
        AppMethodBeat.i(81624);
        boolean isSupportPause = this.mVideoFilters.isSupportPause();
        AppMethodBeat.o(81624);
        return isSupportPause;
    }

    public boolean hasVoiceTextFilter() {
        AppMethodBeat.i(81625);
        if (this.mVideoFilters == null || !this.mVideoFilters.hasVoiceTextFilter()) {
            AppMethodBeat.o(81625);
            return false;
        }
        AppMethodBeat.o(81625);
        return true;
    }

    public boolean hasParticleFilter() {
        AppMethodBeat.i(81626);
        if (this.mVideoFilters == null || !this.mVideoFilters.hasParticleFilter()) {
            AppMethodBeat.o(81626);
            return false;
        }
        AppMethodBeat.o(81626);
        return true;
    }

    public boolean needDetectFace(int i) {
        AppMethodBeat.i(81627);
        boolean needFaceInfo = this.mVideoFilters.needFaceInfo(i);
        AppMethodBeat.o(81627);
        return needFaceInfo;
    }

    public boolean needDetectGesture() {
        AppMethodBeat.i(81628);
        boolean needDetectGesture = this.mVideoFilters.needDetectGesture();
        AppMethodBeat.o(81628);
        return needDetectGesture;
    }

    public void updateCosAlpha(int i) {
        AppMethodBeat.i(81629);
        this.mVideoFilters.updateCosAlpha(i);
        AppMethodBeat.o(81629);
    }

    public void updateVideoSize(int i, int i2, double d, int i3) {
        AppMethodBeat.i(81630);
        this.mVideoFilters.updateVideoSize(i, i2, d, i3);
        AppMethodBeat.o(81630);
    }

    public void setRatioMode(RATIO_MODE ratio_mode) {
        AppMethodBeat.i(81631);
        this.mVideoFilters.setRatioMode(ratio_mode);
        AppMethodBeat.o(81631);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(81632);
        this.mVideoFilters.setRenderMode(i);
        AppMethodBeat.o(81632);
    }

    public boolean is3DMaterial() {
        AppMethodBeat.i(81633);
        boolean is3DMaterial = VideoMaterialUtil.is3DMaterial(this.mVideoFilters.getMaterial());
        AppMethodBeat.o(81633);
        return is3DMaterial;
    }

    public boolean isParticleMaterial() {
        AppMethodBeat.i(81634);
        boolean is3DMaterial = VideoMaterialUtil.is3DMaterial(this.mVideoFilters.getMaterial());
        AppMethodBeat.o(81634);
        return is3DMaterial;
    }

    public boolean needDetectBody() {
        AppMethodBeat.i(81635);
        boolean isBodyDetectMaterial = VideoMaterialUtil.isBodyDetectMaterial(this.mVideoFilters.getMaterial());
        AppMethodBeat.o(81635);
        return isBodyDetectMaterial;
    }

    public boolean needRecordTouchPoint() {
        AppMethodBeat.i(81636);
        boolean needRecordTouchPoint = VideoFilterUtil.needRecordTouchPoint(this.mVideoFilters);
        AppMethodBeat.o(81636);
        return needRecordTouchPoint;
    }

    public void addTouchPoint(PointF pointF) {
        AppMethodBeat.i(81637);
        this.mVideoFilters.addTouchPoint(pointF);
        AppMethodBeat.o(81637);
    }

    public h processSplitFilters(h hVar, h hVar2) {
        AppMethodBeat.i(81638);
        if (this.splitScreen <= 0.0f) {
            AppMethodBeat.o(81638);
            return hVar2;
        }
        h hVar3 = this.mCopyFrame;
        this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, hVar2.width, hVar2.height, -1, 0.0d, hVar3);
        this.mSplitFilter.setxPos(this.splitScreen);
        this.mSplitFilter.RenderProcess(hVar2.texture[0], hVar2.width, hVar2.height, -1, 0.0d, hVar3);
        AppMethodBeat.o(81638);
        return hVar3;
    }
}
