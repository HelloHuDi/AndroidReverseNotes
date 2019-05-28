package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.wxmm.v2helper;

public class SmoothBFilters_573 {
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
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private GPUImageTwoInputHighPassFilter mHighPassFilter = new GPUImageTwoInputHighPassFilter();
    private C41672h mHighPassFrame = new C41672h();
    private SmoothBProcessFilter_573 mProcessVarianceFilter = new SmoothBProcessFilter_573();
    private C41672h mProcessVarianceFrame1 = new C41672h();
    private SmoothBVarianceFilter_573 mVarianceFilter = new SmoothBVarianceFilter_573();
    private C41672h mVarianceFrame1 = new C41672h();
    private C41672h mVarianceFrame1_1 = new C41672h();

    public SmoothBFilters_573() {
        AppMethodBeat.m2504i(82885);
        AppMethodBeat.m2505o(82885);
    }

    public void initial() {
        AppMethodBeat.m2504i(82886);
        this.mClarityFilter.ApplyGLSLFilter();
        this.mBigBlurFilter.ApplyGLSLFilter();
        this.mVarianceFilter.ApplyGLSLFilter();
        this.mBoxFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
        this.mProcessVarianceFilter.ApplyGLSLFilter();
        this.mHighPassFilter.ApplyGLSLFilter();
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(82886);
    }

    public void updateAndRender(C41672h c41672h, C41672h c41672h2) {
        AppMethodBeat.m2504i(82887);
        if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01f) {
            int i = (c41672h.height * v2helper.VOIP_ENC_HEIGHT_LV1) / c41672h.width;
            this.mBoxFilter.updateParam(360.0f, (float) i);
            this.mBoxFilter.RenderProcess(c41672h.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame1);
            this.mVarianceFilter.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
            this.mVarianceFilter.RenderProcess(c41672h.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mVarianceFrame1);
            this.mBoxFilter.updateParam(360.0f, (float) i);
            this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i, -1, 0.0d, this.mBoxFrame2);
            this.mProcessVarianceFilter.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
            this.mProcessVarianceFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, c41672h2);
            AppMethodBeat.m2505o(82887);
            return;
        }
        this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, c41672h2);
        AppMethodBeat.m2505o(82887);
    }

    public void updateAndRenderHighQuality(C41672h c41672h, C41672h c41672h2) {
        AppMethodBeat.m2504i(82888);
        if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01f) {
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
            this.mClarityFilter.RenderProcess(this.mProcessVarianceFrame1.texture[0], c41672h.width, c41672h.height, -1, 0.0d, c41672h2);
            AppMethodBeat.m2505o(82888);
            return;
        }
        this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, c41672h2);
        AppMethodBeat.m2505o(82888);
    }

    public void clear() {
        AppMethodBeat.m2504i(82889);
        this.mClarityFilter.clearGLSLSelf();
        this.mBigBlurFilter.clearGLSLSelf();
        this.mVarianceFilter.clearGLSLSelf();
        this.mBoxFilter.ClearGLSL();
        this.mProcessVarianceFilter.clearGLSLSelf();
        this.mHighPassFilter.clearGLSLSelf();
        this.mCopyFilter.clearGLSLSelf();
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
        AppMethodBeat.m2505o(82889);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82890);
        this.mClarityFilter.setRenderMode(i);
        this.mBigBlurFilter.setRenderMode(i);
        this.mVarianceFilter.setRenderMode(i);
        this.mBoxFilter.setRenderMode(i);
        this.mProcessVarianceFilter.setRenderMode(i);
        this.mCopyFilter.setRenderMode(i);
        this.mHighPassFilter.setRenderMode(i);
        AppMethodBeat.m2505o(82890);
    }

    public void updateBlurAlpha(float f) {
        AppMethodBeat.m2504i(82891);
        this.mProcessVarianceFilter.updateBlurAlpha(0.8f * f);
        AppMethodBeat.m2505o(82891);
    }

    public void updateClarityAlpha(float f) {
        AppMethodBeat.m2504i(82892);
        this.mClarityFilter.updateAlpha(f);
        AppMethodBeat.m2505o(82892);
    }
}
