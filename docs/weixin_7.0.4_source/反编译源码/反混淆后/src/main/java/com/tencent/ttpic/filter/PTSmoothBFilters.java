package com.tencent.ttpic.filter;

import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.wxmm.v2helper;

public class PTSmoothBFilters {
    private SmoothBLargeBlurFilter mBigBlurFilter = new SmoothBLargeBlurFilter();
    private C41672h mBigBlurFrame1 = new C41672h();
    private SmoothBBoxFilter mBoxFilter = new SmoothBBoxFilter();
    private C41672h mBoxFrame1 = new C41672h();
    private C41672h mBoxFrame1_1 = new C41672h();
    private C41672h mBoxFrame2 = new C41672h();
    private C41672h mBoxFrame2_1 = new C41672h();
    private C41672h mBoxFrame3 = new C41672h();
    private SmoothBClarifyFilter mClarityFilter = new SmoothBClarifyFilter();
    private C41672h mClarityFrame1 = new C41672h();
    private GPUImageTwoInputHighPassFilter mHighPassFilter = new GPUImageTwoInputHighPassFilter();
    private C41672h mHighPassFrame = new C41672h();
    private C41672h mOutFrame = new C41672h();
    private SmoothBProcessFilter mProcessVarianceFilter = new SmoothBProcessFilter();
    private C41672h mProcessVarianceFrame1 = new C41672h();
    private SmoothBVarianceFilter mVarianceFilter = new SmoothBVarianceFilter();
    private C41672h mVarianceFrame1 = new C41672h();
    private C41672h mVarianceFrame1_1 = new C41672h();

    public PTSmoothBFilters() {
        AppMethodBeat.m2504i(82711);
        AppMethodBeat.m2505o(82711);
    }

    public void initial() {
        AppMethodBeat.m2504i(82712);
        this.mClarityFilter.ApplyGLSLFilter();
        this.mBigBlurFilter.ApplyGLSLFilter();
        this.mVarianceFilter.ApplyGLSLFilter();
        this.mBoxFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
        this.mProcessVarianceFilter.ApplyGLSLFilter();
        this.mHighPassFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(82712);
    }

    public C41672h updateAndRender(C41672h c41672h) {
        AppMethodBeat.m2504i(82713);
        if (this.mProcessVarianceFilter.getBlurAlpha() <= 0.01f) {
            AppMethodBeat.m2505o(82713);
            return c41672h;
        }
        int i = (c41672h.height * v2helper.VOIP_ENC_HEIGHT_LV1) / c41672h.width;
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(c41672h.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame1);
        this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
        this.mVarianceFilter.RenderProcess(c41672h.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mVarianceFrame1);
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame2);
        this.mProcessVarianceFilter.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
        this.mProcessVarianceFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mProcessVarianceFrame1);
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame3);
        this.mBigBlurFilter.updateParam(360.0f, (float) i);
        this.mBigBlurFilter.RenderProcess(FrameUtil.getLastRenderFrame(this.mBoxFrame3).texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBigBlurFrame1);
        this.mClarityFilter.updateTexture(this.mBigBlurFrame1.texture[0]);
        this.mClarityFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mOutFrame);
        c41672h = this.mOutFrame;
        AppMethodBeat.m2505o(82713);
        return c41672h;
    }

    private C41672h updateAndRenderHighQuality(C41672h c41672h) {
        AppMethodBeat.m2504i(82714);
        if (this.mProcessVarianceFilter.getBlurAlpha() <= 0.01f) {
            AppMethodBeat.m2505o(82714);
            return c41672h;
        }
        int i = (c41672h.height * v2helper.VOIP_ENC_HEIGHT_LV1) / c41672h.width;
        int i2 = (c41672h.height * 720) / c41672h.width;
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(c41672h.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame1);
        this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
        this.mVarianceFilter.RenderProcess(c41672h.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mVarianceFrame1);
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame2);
        this.mBoxFilter.updateParam(720.0f, (float) i2);
        this.mBoxFilter.RenderProcess(c41672h.texture[0], 720, i2, -1, 0.0d, this.mBoxFrame1_1);
        this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1_1).texture[0]);
        this.mVarianceFilter.RenderProcess(c41672h.texture[0], 720, i2, -1, 0.0d, this.mVarianceFrame1_1);
        this.mBoxFilter.updateParam(720.0f, (float) i2);
        this.mBoxFilter.RenderProcess(this.mVarianceFrame1_1.texture[0], 720, i2, -1, 0.0d, this.mBoxFrame2_1);
        this.mHighPassFilter.updateTexture(FrameUtil.getLastRenderFrame(this.mBoxFrame2_1).texture[0]);
        this.mHighPassFilter.RenderProcess(FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0], 720, i2, -1, 0.0d, this.mHighPassFrame);
        this.mProcessVarianceFilter.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mHighPassFrame).texture[0]);
        this.mProcessVarianceFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mProcessVarianceFrame1);
        this.mBoxFilter.updateParam(360.0f, (float) i);
        this.mBoxFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame3);
        this.mBigBlurFilter.updateParam(360.0f, (float) i);
        this.mBigBlurFilter.RenderProcess(FrameUtil.getLastRenderFrame(this.mBoxFrame3).texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBigBlurFrame1);
        this.mClarityFilter.updateTexture(this.mBigBlurFrame1.texture[0]);
        this.mClarityFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mOutFrame);
        c41672h = this.mOutFrame;
        AppMethodBeat.m2505o(82714);
        return c41672h;
    }

    public C41672h process(C41672h c41672h) {
        AppMethodBeat.m2504i(82715);
        C41672h updateAndRenderHighQuality = updateAndRenderHighQuality(c41672h);
        AppMethodBeat.m2505o(82715);
        return updateAndRenderHighQuality;
    }

    public void clear() {
        AppMethodBeat.m2504i(82716);
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
        AppMethodBeat.m2505o(82716);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82717);
        this.mClarityFilter.setRenderMode(i);
        this.mBigBlurFilter.setRenderMode(i);
        this.mVarianceFilter.setRenderMode(i);
        this.mBoxFilter.setRenderMode(i);
        this.mProcessVarianceFilter.setRenderMode(i);
        this.mHighPassFilter.setRenderMode(i);
        AppMethodBeat.m2505o(82717);
    }

    public void updateBlurAlpha(float f) {
        AppMethodBeat.m2504i(82718);
        this.mProcessVarianceFilter.updateBlurAlpha(f);
        AppMethodBeat.m2505o(82718);
    }

    public void updateClarityAlpha(float f) {
        AppMethodBeat.m2504i(82719);
        this.mClarityFilter.updateAlpha(f);
        AppMethodBeat.m2505o(82719);
    }
}
