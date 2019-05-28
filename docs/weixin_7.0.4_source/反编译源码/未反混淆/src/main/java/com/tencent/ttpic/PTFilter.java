package com.tencent.ttpic;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.a.a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.e;
import com.tencent.filter.h;
import com.tencent.filter.m;
import com.tencent.filter.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.filter.AlphaAdjustFilter;
import com.tencent.ttpic.filter.ClarityMaskFilter;
import com.tencent.ttpic.filter.FaceBeautysRealAutoFilter;
import com.tencent.ttpic.filter.FaceColorAndBrightnessFilter;
import com.tencent.ttpic.filter.GPUImageTwoInputHighPassFilter;
import com.tencent.ttpic.filter.LongLegFilter;
import com.tencent.ttpic.filter.NewFaceColorFilter;
import com.tencent.ttpic.filter.SlimWaistFilter;
import com.tencent.ttpic.filter.SmoothBBoxFilter;
import com.tencent.ttpic.filter.SmoothBClarifyFilter;
import com.tencent.ttpic.filter.SmoothBLargeBlurFilter;
import com.tencent.ttpic.filter.SmoothBProcessFilter;
import com.tencent.ttpic.filter.SmoothBVarianceFilter;
import com.tencent.ttpic.filter.SmoothSharpenFilter;
import com.tencent.ttpic.filter.ThinBodyFilter;
import com.tencent.ttpic.filter.ThinShoulderFilter;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.model.CameraFilterParamSDK;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.wxmm.v2helper;
import java.util.List;

public class PTFilter {
    protected BaseFilter mFilter = new BaseFilter(GLSLRender.bJB);
    protected h mFilterFrame = new h();

    public static class PTSlimWaistFilter extends PTFilter {
        private boolean enable = true;
        private SlimWaistFilter mSlimWaistFilter = new SlimWaistFilter();
        private h mSlimWaistFrame = new h();
        private float strength = 0.0f;

        public PTSlimWaistFilter() {
            AppMethodBeat.i(80664);
            AppMethodBeat.o(80664);
        }

        public int init() {
            AppMethodBeat.i(80665);
            int init = super.init();
            this.mSlimWaistFilter.ApplyGLSLFilter();
            AppMethodBeat.o(80665);
            return init;
        }

        public h process(h hVar, int i, int i2) {
            AppMethodBeat.i(80666);
            this.mSlimWaistFilter.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, this.mSlimWaistFrame);
            h hVar2 = this.mSlimWaistFrame;
            AppMethodBeat.o(80666);
            return hVar2;
        }

        public void setStatusReset() {
            AppMethodBeat.i(80667);
            this.mSlimWaistFilter.setStatusReset();
            AppMethodBeat.o(80667);
        }

        public boolean setWaistRectangle(List<PointF> list, int i, int i2) {
            AppMethodBeat.i(80668);
            boolean waistRectangle = this.mSlimWaistFilter.setWaistRectangle(list, i, i2);
            AppMethodBeat.o(80668);
            return waistRectangle;
        }

        public void setStrength(float f) {
            AppMethodBeat.i(80669);
            this.mSlimWaistFilter.setStrength(f);
            this.strength = f;
            AppMethodBeat.o(80669);
        }

        public float getStrength() {
            return this.strength;
        }

        public void destroy() {
            AppMethodBeat.i(80670);
            this.mSlimWaistFilter.clearGLSLSelf();
            this.mSlimWaistFrame.clear();
            super.destroy();
            AppMethodBeat.o(80670);
        }
    }

    public static class PTCropFilter extends PTFilter {
        private float bottom = 0.0f;
        private float left = 0.0f;

        public void updateCorpRect(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(80653);
            float f = (((float) (i3 - i)) / 2.0f) / ((float) i3);
            float f2 = 1.0f - f;
            float f3 = (((float) (i4 - i2)) / 2.0f) / ((float) i4);
            float f4 = 1.0f - f3;
            if (Float.compare(f, this.left) == 0 && Float.compare(f3, this.bottom) == 0) {
                AppMethodBeat.o(80653);
                return;
            }
            this.left = f;
            this.bottom = f3;
            this.mFilter.setTexCords(new float[]{f, f3, f, f4, f2, f4, f2, f3});
            AppMethodBeat.o(80653);
        }
    }

    public static class PTLongLegFilter extends PTFilter {
        private boolean enable = true;
        private LongLegFilter mLongLegFilter = new LongLegFilter();
        private h mLongLegFrame = new h();
        private float strength = 0.0f;

        public PTLongLegFilter() {
            AppMethodBeat.i(80656);
            AppMethodBeat.o(80656);
        }

        public int init() {
            AppMethodBeat.i(80657);
            int init = super.init();
            this.mLongLegFilter.ApplyGLSLFilter();
            AppMethodBeat.o(80657);
            return init;
        }

        public void setEnable(boolean z) {
            this.enable = z;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public h process(h hVar, int i, int i2) {
            AppMethodBeat.i(80658);
            if (this.enable) {
                this.mLongLegFilter.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, this.mLongLegFrame);
                hVar = this.mLongLegFrame;
                AppMethodBeat.o(80658);
                return hVar;
            }
            AppMethodBeat.o(80658);
            return hVar;
        }

        public void setWaistLine(List<PointF> list, int i) {
            AppMethodBeat.i(80659);
            this.mLongLegFilter.setWaistLine((List) list, i);
            AppMethodBeat.o(80659);
        }

        public void setStrength(float f) {
            AppMethodBeat.i(80660);
            this.mLongLegFilter.setStrength(f);
            this.strength = f;
            AppMethodBeat.o(80660);
        }

        public float getStrength() {
            return this.strength;
        }

        public void destroy() {
            AppMethodBeat.i(80661);
            this.mLongLegFilter.clearGLSLSelf();
            this.mLongLegFrame.clear();
            super.destroy();
            AppMethodBeat.o(80661);
        }
    }

    public static class PTYUV2RGBAFilter extends PTFilter {
        public PTYUV2RGBAFilter() {
            AppMethodBeat.i(80692);
            this.mFilter = new o();
            AppMethodBeat.o(80692);
        }

        public void setRotationAndFlip(int i, boolean z, boolean z2) {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(80693);
            BaseFilter baseFilter = this.mFilter;
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (!z2) {
                i3 = 0;
            }
            baseFilter.nativeSetRotationAndFlip(i, i2, i3);
            AppMethodBeat.o(80693);
        }

        public void setTextureCoordsMatrix(float[] fArr) {
            AppMethodBeat.i(80694);
            this.mFilter.nativeUpdateMatrix(fArr);
            AppMethodBeat.o(80694);
        }
    }

    public static class PTAlphaFilter extends PTFilter {
        public PTAlphaFilter() {
            AppMethodBeat.i(80646);
            this.mFilter = new AlphaAdjustFilter();
            AppMethodBeat.o(80646);
        }

        public int init() {
            AppMethodBeat.i(80647);
            int init = super.init();
            this.mFilter.setAdjustParam(0.0f);
            this.mFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
            AppMethodBeat.o(80647);
            return init;
        }
    }

    public static class PTFaceColorAndBrightnessFilter extends PTFilter {
        public PTFaceColorAndBrightnessFilter() {
            AppMethodBeat.i(80654);
            this.mFilter = new FaceColorAndBrightnessFilter();
            AppMethodBeat.o(80654);
        }

        public void updateCurve(int[] iArr, boolean z) {
            AppMethodBeat.i(80655);
            ((FaceColorAndBrightnessFilter) this.mFilter).updateCurve(iArr, z);
            AppMethodBeat.o(80655);
        }
    }

    public static class PTNewFaceColorFilter extends PTFilter {
        public PTNewFaceColorFilter() {
            AppMethodBeat.i(80662);
            this.mFilter = new NewFaceColorFilter();
            AppMethodBeat.o(80662);
        }

        public int init() {
            AppMethodBeat.i(80663);
            int init = super.init();
            new m.o("inputImageTexture2", "sh/facecolor_b.png", 33986).initialParams(this.mFilter.getmProgramIds());
            AppMethodBeat.o(80663);
            return init;
        }
    }

    public static class PTSmoothSkin extends PTFilter {
        private CameraFilterParamSDK mBeautyParam;

        public PTSmoothSkin() {
            AppMethodBeat.i(80676);
            this.mFilter = new FaceBeautysRealAutoFilter();
            this.mBeautyParam = new CameraFilterParamSDK();
            setBeautyLevel(1);
            AppMethodBeat.o(80676);
        }

        public void setBeautyLevel(int i) {
            AppMethodBeat.i(80677);
            this.mBeautyParam.smoothLevel = i;
            this.mFilter.setParameterDic(this.mBeautyParam.getSmoothMap());
            AppMethodBeat.o(80677);
        }

        public int getBeautyLevel() {
            return this.mBeautyParam.smoothLevel;
        }
    }

    public static class PTThinBodyFilter extends PTFilter {
        private boolean enable = true;
        private ThinBodyFilter mThinBodyFilter = new ThinBodyFilter();
        private h mThinBodyFrame = new h();
        private float strength = 0.0f;

        public PTThinBodyFilter() {
            AppMethodBeat.i(80678);
            AppMethodBeat.o(80678);
        }

        public int init() {
            AppMethodBeat.i(80679);
            int init = super.init();
            this.mThinBodyFilter.ApplyGLSLFilter();
            AppMethodBeat.o(80679);
            return init;
        }

        public void setEnable(boolean z) {
            AppMethodBeat.i(80680);
            this.mThinBodyFilter.setShowMark(true);
            this.mThinBodyFilter.setEnable(z);
            this.enable = z;
            AppMethodBeat.o(80680);
        }

        public boolean isEnable() {
            return this.enable;
        }

        public void setBodyPoints(List<PointF> list, int i, int i2) {
            AppMethodBeat.i(80681);
            if (list != null && list.size() > 0) {
                this.mThinBodyFilter.setupBodyPoints(list, i, i2);
            }
            AppMethodBeat.o(80681);
        }

        public h process(h hVar, int i, int i2) {
            AppMethodBeat.i(80682);
            if (this.enable) {
                this.mThinBodyFilter.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, this.mThinBodyFrame);
                hVar = this.mThinBodyFrame;
                AppMethodBeat.o(80682);
                return hVar;
            }
            AppMethodBeat.o(80682);
            return hVar;
        }

        public void setStrength(float f) {
            AppMethodBeat.i(80683);
            this.mThinBodyFilter.setStrength(f);
            this.strength = f;
            AppMethodBeat.o(80683);
        }

        public float getStrength() {
            return this.strength;
        }

        public void destroy() {
            AppMethodBeat.i(80684);
            this.mThinBodyFilter.clearGLSLSelf();
            this.mThinBodyFrame.clear();
            super.destroy();
            AppMethodBeat.o(80684);
        }
    }

    public static class PTThinShoulderFilter extends PTFilter {
        private boolean enable = true;
        private ThinShoulderFilter mThinShoulderFilter = new ThinShoulderFilter();
        private h mThinShoulderFrame = new h();
        private float strength = 0.0f;

        public PTThinShoulderFilter() {
            AppMethodBeat.i(80685);
            AppMethodBeat.o(80685);
        }

        public int init() {
            AppMethodBeat.i(80686);
            int init = super.init();
            this.mThinShoulderFilter.ApplyGLSLFilter();
            AppMethodBeat.o(80686);
            return init;
        }

        public void setEnable(boolean z) {
            AppMethodBeat.i(80687);
            this.mThinShoulderFilter.setShowMark(true);
            this.mThinShoulderFilter.setEnable(z);
            this.enable = z;
            AppMethodBeat.o(80687);
        }

        public boolean isEnable() {
            return this.enable;
        }

        public boolean setBodyPoints(List<PointF> list, int i, int i2) {
            AppMethodBeat.i(80688);
            boolean z = this.mThinShoulderFilter.setupBodyPoints(list, i, i2);
            AppMethodBeat.o(80688);
            return z;
        }

        public h process(h hVar, int i, int i2) {
            AppMethodBeat.i(80689);
            if (this.enable) {
                this.mThinShoulderFilter.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, this.mThinShoulderFrame);
                hVar = this.mThinShoulderFrame;
                AppMethodBeat.o(80689);
                return hVar;
            }
            AppMethodBeat.o(80689);
            return hVar;
        }

        public void setStrength(float f) {
            AppMethodBeat.i(80690);
            this.mThinShoulderFilter.setStrength(f);
            this.strength = f;
            AppMethodBeat.o(80690);
        }

        public float getStrength() {
            return this.strength;
        }

        public void destroy() {
            AppMethodBeat.i(80691);
            this.mThinShoulderFilter.clearGLSLSelf();
            this.mThinShoulderFrame.clear();
            super.destroy();
            AppMethodBeat.o(80691);
        }
    }

    public static class PTCopyFilter extends PTFilter {
        public void setRotationAndFlip(int i, boolean z, boolean z2) {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(80652);
            BaseFilter baseFilter = this.mFilter;
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (!z2) {
                i3 = 0;
            }
            baseFilter.nativeSetRotationAndFlip(i, i2, i3);
            AppMethodBeat.o(80652);
        }
    }

    public static class PTClarityMaskFilter extends PTFilter {
        private boolean hasApply = false;
        private ClarityMaskFilter mClarityMaskFilter = new ClarityMaskFilter();
        private h mClarityMaskFrame = new h();
        private SmoothSharpenFilter mSmoothSharpenFilter = new SmoothSharpenFilter();
        private h mSmoothSharpenFrame = new h();

        public PTClarityMaskFilter() {
            AppMethodBeat.i(80648);
            AppMethodBeat.o(80648);
        }

        public int init() {
            AppMethodBeat.i(80649);
            int init = super.init();
            AppMethodBeat.o(80649);
            return init;
        }

        public h process(h hVar, int i, int i2) {
            AppMethodBeat.i(80650);
            if (!this.hasApply) {
                this.mClarityMaskFilter.ApplyGLSLFilter(true, (float) i, (float) i2);
                this.mSmoothSharpenFilter.ApplyGLSLFilter(true, (float) i, (float) i2);
                this.hasApply = true;
            }
            int i3 = (hVar.height * 720) / hVar.width;
            this.mClarityMaskFilter.updateSize(720, i3);
            this.mClarityMaskFilter.RenderProcess(hVar.texture[0], 720, i3, -1, 0.0d, this.mClarityMaskFrame);
            this.mSmoothSharpenFilter.updateTexture(this.mClarityMaskFrame.texture[0]);
            this.mSmoothSharpenFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mSmoothSharpenFrame);
            h hVar2 = this.mSmoothSharpenFrame;
            AppMethodBeat.o(80650);
            return hVar2;
        }

        public void destroy() {
            AppMethodBeat.i(80651);
            this.mClarityMaskFilter.clearGLSLSelf();
            this.mSmoothSharpenFilter.clearGLSLSelf();
            this.mClarityMaskFrame.clear();
            this.mSmoothSharpenFrame.clear();
            this.hasApply = false;
            super.destroy();
            AppMethodBeat.o(80651);
        }
    }

    public static class PTSmoothBFilters extends PTFilter {
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
        private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
        private GPUImageTwoInputHighPassFilter mHighPassFilter = new GPUImageTwoInputHighPassFilter();
        private h mHighPassFrame = new h();
        private SmoothBProcessFilter mProcessVarianceFilter = new SmoothBProcessFilter();
        private SmoothBProcessFilter mProcessVarianceFilter2 = new SmoothBProcessFilter();
        private h mProcessVarianceFrame1 = new h();
        private SmoothBVarianceFilter mVarianceFilter = new SmoothBVarianceFilter();
        private SmoothBVarianceFilter mVarianceFilter2 = new SmoothBVarianceFilter();
        private h mVarianceFrame1 = new h();
        private h mVarianceFrame1_1 = new h();
        private h outputFrame = new h();

        public PTSmoothBFilters() {
            AppMethodBeat.i(80671);
            AppMethodBeat.o(80671);
        }

        public int init() {
            AppMethodBeat.i(80672);
            int init = super.init();
            this.mClarityFilter.ApplyGLSLFilter();
            this.mBigBlurFilter.ApplyGLSLFilter();
            this.mVarianceFilter.ApplyGLSLFilter();
            this.mVarianceFilter2.ApplyGLSLFilter();
            this.mBoxFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
            this.mProcessVarianceFilter.ApplyGLSLFilter();
            this.mProcessVarianceFilter2.ApplyGLSLFilter();
            this.mHighPassFilter.ApplyGLSLFilter();
            this.mCopyFilter.ApplyGLSLFilter();
            AppMethodBeat.o(80672);
            return init;
        }

        public h process(h hVar, int i, int i2) {
            AppMethodBeat.i(80673);
            if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01f) {
                int i3 = (hVar.height * v2helper.VOIP_ENC_HEIGHT_LV1) / hVar.width;
                this.mBoxFilter.updateParam(360.0f, (float) i3);
                this.mBoxFilter.RenderProcess(hVar.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i3, -1, 0.0d, this.mBoxFrame1);
                this.mVarianceFilter2.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
                this.mVarianceFilter2.RenderProcess(hVar.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i3, -1, 0.0d, this.mVarianceFrame1);
                this.mBoxFilter.updateParam(360.0f, (float) i3);
                this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i3, -1, 0.0d, this.mBoxFrame2);
                this.mProcessVarianceFilter2.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
                this.mProcessVarianceFilter2.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.outputFrame);
            } else {
                this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.outputFrame);
            }
            h hVar2 = this.outputFrame;
            AppMethodBeat.o(80673);
            return hVar2;
        }

        public void updateBlurAlpha(float f) {
            AppMethodBeat.i(80674);
            this.mProcessVarianceFilter.updateBlurAlpha(0.8f * f);
            this.mProcessVarianceFilter2.updateBlurAlpha(0.8f * f);
            AppMethodBeat.o(80674);
        }

        public void destroy() {
            AppMethodBeat.i(80675);
            this.mClarityFilter.ClearGLSL();
            this.mBigBlurFilter.ClearGLSL();
            this.mVarianceFilter.ClearGLSL();
            this.mVarianceFilter2.ClearGLSL();
            this.mBoxFilter.ClearGLSL();
            this.mProcessVarianceFilter.ClearGLSL();
            this.mProcessVarianceFilter2.ClearGLSL();
            this.mHighPassFilter.ClearGLSL();
            this.mCopyFilter.ClearGLSL();
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
            this.outputFrame.clear();
            super.destroy();
            AppMethodBeat.o(80675);
        }
    }

    static {
        AppMethodBeat.i(80708);
        if (FeatureManager.isFilterReady()) {
            try {
                FeatureManager.loadLibrary("image_filter_cpu");
                AppMethodBeat.o(80708);
                return;
            } catch (UnsatisfiedLinkError e) {
                LogUtils.e(e);
                AppMethodBeat.o(80708);
                return;
            } catch (RuntimeException e2) {
                LogUtils.e(e2);
                AppMethodBeat.o(80708);
                return;
            } catch (Exception e3) {
                LogUtils.e(e3);
            }
        }
        AppMethodBeat.o(80708);
    }

    public PTFilter() {
        AppMethodBeat.i(80695);
        AppMethodBeat.o(80695);
    }

    public void setFilter(BaseFilter baseFilter) {
        this.mFilter = baseFilter;
    }

    public BaseFilter getFilter() {
        return this.mFilter;
    }

    public static PTFilter createById(int i, int i2) {
        AppMethodBeat.i(80696);
        PTFilter pTFilter = new PTFilter();
        pTFilter.mFilter = a.createFilter(i);
        pTFilter.mFilter.needFlipBlend = true;
        pTFilter.mFilter.setSrcFilterIndex(-1);
        pTFilter.mFilter.setEffectIndex(i2);
        AppMethodBeat.o(80696);
        return pTFilter;
    }

    @Deprecated
    public static PTFilter createByFile(String str) {
        return null;
    }

    public static PTFilter createByLut(String str) {
        AppMethodBeat.i(80697);
        PTFilter pTFilter = new PTFilter();
        Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), str, 1);
        if (decodeSampleBitmap == null) {
            decodeSampleBitmap = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(str);
        }
        pTFilter.mFilter = TTPicFilterFactoryLocal.lutFilterWithBitmap(decodeSampleBitmap);
        if (pTFilter.mFilter == null) {
            AppMethodBeat.o(80697);
            return null;
        }
        pTFilter.mFilter.needFlipBlend = true;
        pTFilter.mFilter.setSrcFilterIndex(-1);
        pTFilter.mFilterFrame = new h();
        AppMethodBeat.o(80697);
        return pTFilter;
    }

    public static PTFilter createCurve2D(String str) {
        AppMethodBeat.i(80698);
        PTFilter createCurve2D = createCurve2D(str, null);
        AppMethodBeat.o(80698);
        return createCurve2D;
    }

    public static PTFilter createCurve2D(String str, float[] fArr) {
        AppMethodBeat.i(80699);
        PTFilter pTFilter = new PTFilter();
        e eVar = new e(str);
        if (fArr != null) {
            eVar.setMatrix(fArr);
        }
        pTFilter.mFilter = eVar;
        pTFilter.mFilter.needFlipBlend = true;
        pTFilter.mFilter.setSrcFilterIndex(-1);
        pTFilter.mFilterFrame = new h();
        AppMethodBeat.o(80699);
        return pTFilter;
    }

    public static PTFilter createCopyFilter() {
        AppMethodBeat.i(80700);
        PTCopyFilter pTCopyFilter = new PTCopyFilter();
        AppMethodBeat.o(80700);
        return pTCopyFilter;
    }

    public static PTFilter createYUV2RGBAFilter() {
        AppMethodBeat.i(80701);
        PTFilter pTFilter = new PTFilter();
        pTFilter.mFilter = new o();
        AppMethodBeat.o(80701);
        return pTFilter;
    }

    public int init() {
        AppMethodBeat.i(80702);
        this.mFilter.ApplyGLSLFilter(true, 1.0f, 1.0f);
        AppMethodBeat.o(80702);
        return 0;
    }

    public void destroy() {
        AppMethodBeat.i(80703);
        this.mFilter.ClearGLSL();
        this.mFilterFrame.clear();
        AppMethodBeat.o(80703);
    }

    public h process(h hVar) {
        AppMethodBeat.i(80704);
        this.mFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mFilterFrame);
        h lastRenderFrame = FrameUtil.getLastRenderFrame(this.mFilterFrame);
        AppMethodBeat.o(80704);
        return lastRenderFrame;
    }

    public h process(h hVar, int i, int i2) {
        AppMethodBeat.i(80705);
        this.mFilter.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, this.mFilterFrame);
        h lastRenderFrame = FrameUtil.getLastRenderFrame(this.mFilterFrame);
        AppMethodBeat.o(80705);
        return lastRenderFrame;
    }

    public void processToScreen(h hVar, int i, int i2) {
        AppMethodBeat.i(80706);
        this.mFilter.RenderProcess(hVar.texture[0], i, i2, 0, 0.0d, this.mFilterFrame);
        AppMethodBeat.o(80706);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(80707);
        this.mFilter.setRenderMode(i);
        AppMethodBeat.o(80707);
    }
}
