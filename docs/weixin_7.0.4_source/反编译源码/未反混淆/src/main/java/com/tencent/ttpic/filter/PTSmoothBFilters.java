package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.wxmm.v2helper;

public class PTSmoothBFilters {
    private SmoothBLargeBlurFilter mBigBlurFilter = new SmoothBLargeBlurFilter();
    private h mBigBlurFrame1 = new h();
    private SmoothBBoxFilter mBoxFilter = new SmoothBBoxFilter();
    private h mBoxFrame1 = new h();
    private h mBoxFrame1_1 = new h();
    private h mBoxFrame2 = new h();
    private h mBoxFrame2_1 = new h();
    private h mBoxFrame3 = new h();
    private SmoothBClarifyFilter mClarityFilter = new SmoothBClarifyFilter();
    private h mClarityFrame1 = new h();
    private GPUImageTwoInputHighPassFilter mHighPassFilter = new GPUImageTwoInputHighPassFilter();
    private h mHighPassFrame = new h();
    private h mOutFrame = new h();
    private SmoothBProcessFilter mProcessVarianceFilter = new SmoothBProcessFilter();
    private h mProcessVarianceFrame1 = new h();
    private SmoothBVarianceFilter mVarianceFilter = new SmoothBVarianceFilter();
    private h mVarianceFrame1 = new h();
    private h mVarianceFrame1_1 = new h();

    public PTSmoothBFilters() {
        AppMethodBeat.i(82711);
        AppMethodBeat.o(82711);
    }

    public void initial() {
        AppMethodBeat.i(82712);
        this.mClarityFilter.ApplyGLSLFilter();
        this.mBigBlurFilter.ApplyGLSLFilter();
        this.mVarianceFilter.ApplyGLSLFilter();
        this.mBoxFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
        this.mProcessVarianceFilter.ApplyGLSLFilter();
        this.mHighPassFilter.ApplyGLSLFilter();
        AppMethodBeat.o(82712);
    }

    public h updateAndRender(h hVar) {
        AppMethodBeat.i(82713);
        if (this.mProcessVarianceFilter.getBlurAlpha() <= 0.01f) {
            AppMethodBeat.o(82713);
            return hVar;
        }
        int i = (hVar.height * v2helper.VOIP_ENC_HEIGHT_LV1) / hVar.width;
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(hVar.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame1);
        this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
        this.mVarianceFilter.RenderProcess(hVar.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mVarianceFrame1);
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame2);
        this.mProcessVarianceFilter.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
        this.mProcessVarianceFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mProcessVarianceFrame1);
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame3);
        this.mBigBlurFilter.updateParam(360.0f, (float) i);
        this.mBigBlurFilter.RenderProcess(FrameUtil.getLastRenderFrame(this.mBoxFrame3).texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBigBlurFrame1);
        this.mClarityFilter.updateTexture(this.mBigBlurFrame1.texture[0]);
        this.mClarityFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mOutFrame);
        hVar = this.mOutFrame;
        AppMethodBeat.o(82713);
        return hVar;
    }

    private h updateAndRenderHighQuality(h hVar) {
        AppMethodBeat.i(82714);
        if (this.mProcessVarianceFilter.getBlurAlpha() <= 0.01f) {
            AppMethodBeat.o(82714);
            return hVar;
        }
        int i = (hVar.height * v2helper.VOIP_ENC_HEIGHT_LV1) / hVar.width;
        int i2 = (hVar.height * 720) / hVar.width;
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(hVar.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame1);
        this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
        this.mVarianceFilter.RenderProcess(hVar.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mVarianceFrame1);
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame2);
        this.mBoxFilter.updateParam(720.0f, (float) i2);
        this.mBoxFilter.RenderProcess(hVar.texture[0], 720, i2, -1, 0.0d, this.mBoxFrame1_1);
        this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1_1).texture[0]);
        this.mVarianceFilter.RenderProcess(hVar.texture[0], 720, i2, -1, 0.0d, this.mVarianceFrame1_1);
        this.mBoxFilter.updateParam(720.0f, (float) i2);
        this.mBoxFilter.RenderProcess(this.mVarianceFrame1_1.texture[0], 720, i2, -1, 0.0d, this.mBoxFrame2_1);
        this.mHighPassFilter.updateTexture(FrameUtil.getLastRenderFrame(this.mBoxFrame2_1).texture[0]);
        this.mHighPassFilter.RenderProcess(FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0], 720, i2, -1, 0.0d, this.mHighPassFrame);
        this.mProcessVarianceFilter.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mHighPassFrame).texture[0]);
        this.mProcessVarianceFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mProcessVarianceFrame1);
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame3);
        this.mBigBlurFilter.updateParam(360.0f, (float) i);
        this.mBigBlurFilter.RenderProcess(FrameUtil.getLastRenderFrame(this.mBoxFrame3).texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBigBlurFrame1);
        this.mClarityFilter.updateTexture(this.mBigBlurFrame1.texture[0]);
        this.mClarityFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mOutFrame);
        hVar = this.mOutFrame;
        AppMethodBeat.o(82714);
        return hVar;
    }

    public h process(h hVar) {
        AppMethodBeat.i(82715);
        h updateAndRenderHighQuality = updateAndRenderHighQuality(hVar);
        AppMethodBeat.o(82715);
        return updateAndRenderHighQuality;
    }

    public void clear() {
        AppMethodBeat.i(82716);
        this.mClarityFilter.clearGLSLSelf();
        this.mBigBlurFilter.clearGLSLSelf();
        this.mVarianceFilter.clearGLSLSelf();
        this.mBoxFilter.ClearGLSL();
        this.mProcessVarianceFilter.clearGLSLSelf();
        this.mHighPassFilter.clearGLSLSelf();
        this.mBoxFrame1.clear();
        this.mBoxFrame1_1.clear();
        this.mVarianceFrame1.clear();
        this.mVarianceFrame1_1.clear();
        this.mProcessVarianceFrame1.clear();
        this.mBoxFrame2.clear();
        this.mBoxFrame2_1.clear();
        this.mBoxFrame3.clear();
        this.mBigBlurFrame1.clear();
        this.mClarityFrame1.clear();
        this.mHighPassFrame.clear();
        this.mOutFrame.clear();
        AppMethodBeat.o(82716);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82717);
        this.mClarityFilter.setRenderMode(i);
        this.mBigBlurFilter.setRenderMode(i);
        this.mVarianceFilter.setRenderMode(i);
        this.mBoxFilter.setRenderMode(i);
        this.mProcessVarianceFilter.setRenderMode(i);
        this.mHighPassFilter.setRenderMode(i);
        AppMethodBeat.o(82717);
    }

    public void updateBlurAlpha(float f) {
        AppMethodBeat.i(82718);
        this.mProcessVarianceFilter.updateBlurAlpha(f);
        AppMethodBeat.o(82718);
    }

    public void updateClarityAlpha(float f) {
        AppMethodBeat.i(82719);
        this.mClarityFilter.updateAlpha(f);
        AppMethodBeat.o(82719);
    }
}
