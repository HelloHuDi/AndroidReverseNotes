package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;
import java.util.List;

public class SmoothBFilters {
    private SmoothBLargeBlurFilter mBigBlurFilter = new SmoothBLargeBlurFilter();
    private SmoothBBoxFilter mBoxFilter = new SmoothBBoxFilter();
    private h mBoxFrame1 = new h();
    private h mBoxFrame2 = new h();
    private SmoothBClarifyFilter mClarityFilter = new SmoothBClarifyFilter();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private GPUImageTwoInputHighPassFilter mHighPassFilter = new GPUImageTwoInputHighPassFilter();
    private SmoothBProcessFilter mProcessVarianceFilter = new SmoothBProcessFilter();
    private SmoothBVarianceFilter mVarianceFilter = new SmoothBVarianceFilter();
    private h mVarianceFrame1 = new h();

    public SmoothBFilters() {
        AppMethodBeat.i(82878);
        AppMethodBeat.o(82878);
    }

    public void initial() {
        AppMethodBeat.i(82879);
        this.mClarityFilter.ApplyGLSLFilter();
        this.mBigBlurFilter.ApplyGLSLFilter();
        this.mVarianceFilter.ApplyGLSLFilter();
        this.mBoxFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
        this.mProcessVarianceFilter.ApplyGLSLFilter();
        this.mHighPassFilter.ApplyGLSLFilter();
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.o(82879);
    }

    public void setOnlyDetFaceRectSkin(boolean z) {
    }

    public void updateAndRender(h hVar, h hVar2, List<List<PointF>> list, int i, int i2, int i3) {
        AppMethodBeat.i(82880);
        if (this.mProcessVarianceFilter.getBlurAlpha() <= 0.01f || list == null || list.size() <= 0) {
            this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, hVar2);
            AppMethodBeat.o(82880);
            return;
        }
        int i4 = (hVar.height * v2helper.VOIP_ENC_HEIGHT_LV1) / hVar.width;
        this.mBoxFilter.updateParam(360.0f, (float) i4);
        this.mBoxFilter.RenderProcess(hVar.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i4, -1, 0.0d, this.mBoxFrame1);
        this.mVarianceFilter.setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        this.mVarianceFilter.setTexCords(GlUtil.ORIGIN_TEX_COORDS);
        this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
        FrameUtil.clearFrame(this.mVarianceFrame1, 0.0f, 1.0f, 0.0f, 1.0f, v2helper.VOIP_ENC_HEIGHT_LV1, i4);
        this.mVarianceFilter.setInFaceRect(1);
        this.mVarianceFilter.setRotation(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < list.size()) {
                RectF faceRectF = AlgoUtils.getFaceRectF((List) list.get(i6));
                if (faceRectF != null) {
                    float width;
                    float height;
                    if (i3 == 0) {
                        width = faceRectF.width();
                        height = faceRectF.height();
                        faceRectF.left -= 0.1f * width;
                        faceRectF.top -= 0.2f * height;
                        faceRectF.right = (width * 0.1f) + faceRectF.right;
                        faceRectF.bottom += height * 0.6f;
                    } else if (i3 == 90) {
                        width = faceRectF.width();
                        height = faceRectF.height();
                        faceRectF.left -= 0.6f * width;
                        faceRectF.top -= 0.1f * height;
                        faceRectF.right = (width * 0.2f) + faceRectF.right;
                        faceRectF.bottom += height * 0.1f;
                    } else if (i3 == 180) {
                        width = faceRectF.width();
                        height = faceRectF.height();
                        faceRectF.left -= 0.1f * width;
                        faceRectF.top -= 0.6f * height;
                        faceRectF.right = (width * 0.1f) + faceRectF.right;
                        faceRectF.bottom += height * 0.2f;
                    } else {
                        width = faceRectF.width();
                        height = faceRectF.height();
                        faceRectF.left -= 0.2f * width;
                        faceRectF.top -= 0.1f * height;
                        faceRectF.right = (width * 0.6f) + faceRectF.right;
                        faceRectF.bottom += height * 0.1f;
                    }
                    this.mVarianceFilter.setPositions(AlgoUtils.calPositions(faceRectF.left, faceRectF.top, faceRectF.right, faceRectF.bottom, i, i2));
                    this.mVarianceFilter.OnDrawFrameGLSL();
                    this.mVarianceFilter.renderTexture(hVar.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i4);
                }
                i5 = i6 + 1;
            } else {
                this.mBoxFilter.updateParam(360.0f, (float) i4);
                this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i4, -1, 0.0d, this.mBoxFrame2);
                this.mProcessVarianceFilter.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
                this.mProcessVarianceFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, hVar2);
                AppMethodBeat.o(82880);
                return;
            }
        }
    }

    public void clear() {
        AppMethodBeat.i(82881);
        this.mClarityFilter.clearGLSLSelf();
        this.mBigBlurFilter.clearGLSLSelf();
        this.mVarianceFilter.clearGLSLSelf();
        this.mBoxFilter.ClearGLSL();
        this.mProcessVarianceFilter.clearGLSLSelf();
        this.mHighPassFilter.clearGLSLSelf();
        this.mCopyFilter.clearGLSLSelf();
        this.mBoxFrame1.clear();
        this.mVarianceFrame1.clear();
        this.mBoxFrame2.clear();
        AppMethodBeat.o(82881);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82882);
        VideoFilterUtil.setRenderMode(this.mClarityFilter, i);
        VideoFilterUtil.setRenderMode(this.mBigBlurFilter, i);
        VideoFilterUtil.setRenderMode(this.mVarianceFilter, i);
        VideoFilterUtil.setRenderMode(this.mBoxFilter, i);
        VideoFilterUtil.setRenderMode(this.mProcessVarianceFilter, i);
        VideoFilterUtil.setRenderMode(this.mCopyFilter, i);
        VideoFilterUtil.setRenderMode(this.mHighPassFilter, i);
        AppMethodBeat.o(82882);
    }

    public void updateBlurAlpha(float f) {
        AppMethodBeat.i(82883);
        this.mProcessVarianceFilter.updateBlurAlpha((0.7f * f) * 0.8f);
        AppMethodBeat.o(82883);
    }

    public void updateClarityAlpha(float f) {
        AppMethodBeat.i(82884);
        this.mClarityFilter.updateAlpha(f);
        AppMethodBeat.o(82884);
    }

    public h getVarianceFrame() {
        return this.mBoxFrame2;
    }
}
