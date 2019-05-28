package com.tencent.ttpic;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C17755e;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C25635o;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p1137a.C16516a;
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
    protected C41672h mFilterFrame = new C41672h();

    public static class PTSlimWaistFilter extends PTFilter {
        private boolean enable = true;
        private SlimWaistFilter mSlimWaistFilter = new SlimWaistFilter();
        private C41672h mSlimWaistFrame = new C41672h();
        private float strength = 0.0f;

        public PTSlimWaistFilter() {
            AppMethodBeat.m2504i(80664);
            AppMethodBeat.m2505o(80664);
        }

        public int init() {
            AppMethodBeat.m2504i(80665);
            int init = super.init();
            this.mSlimWaistFilter.ApplyGLSLFilter();
            AppMethodBeat.m2505o(80665);
            return init;
        }

        public C41672h process(C41672h c41672h, int i, int i2) {
            AppMethodBeat.m2504i(80666);
            this.mSlimWaistFilter.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, this.mSlimWaistFrame);
            C41672h c41672h2 = this.mSlimWaistFrame;
            AppMethodBeat.m2505o(80666);
            return c41672h2;
        }

        public void setStatusReset() {
            AppMethodBeat.m2504i(80667);
            this.mSlimWaistFilter.setStatusReset();
            AppMethodBeat.m2505o(80667);
        }

        public boolean setWaistRectangle(List<PointF> list, int i, int i2) {
            AppMethodBeat.m2504i(80668);
            boolean waistRectangle = this.mSlimWaistFilter.setWaistRectangle(list, i, i2);
            AppMethodBeat.m2505o(80668);
            return waistRectangle;
        }

        public void setStrength(float f) {
            AppMethodBeat.m2504i(80669);
            this.mSlimWaistFilter.setStrength(f);
            this.strength = f;
            AppMethodBeat.m2505o(80669);
        }

        public float getStrength() {
            return this.strength;
        }

        public void destroy() {
            AppMethodBeat.m2504i(80670);
            this.mSlimWaistFilter.clearGLSLSelf();
            this.mSlimWaistFrame.clear();
            super.destroy();
            AppMethodBeat.m2505o(80670);
        }
    }

    public static class PTCropFilter extends PTFilter {
        private float bottom = 0.0f;
        private float left = 0.0f;

        public void updateCorpRect(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(80653);
            float f = (((float) (i3 - i)) / 2.0f) / ((float) i3);
            float f2 = 1.0f - f;
            float f3 = (((float) (i4 - i2)) / 2.0f) / ((float) i4);
            float f4 = 1.0f - f3;
            if (Float.compare(f, this.left) == 0 && Float.compare(f3, this.bottom) == 0) {
                AppMethodBeat.m2505o(80653);
                return;
            }
            this.left = f;
            this.bottom = f3;
            this.mFilter.setTexCords(new float[]{f, f3, f, f4, f2, f4, f2, f3});
            AppMethodBeat.m2505o(80653);
        }
    }

    public static class PTLongLegFilter extends PTFilter {
        private boolean enable = true;
        private LongLegFilter mLongLegFilter = new LongLegFilter();
        private C41672h mLongLegFrame = new C41672h();
        private float strength = 0.0f;

        public PTLongLegFilter() {
            AppMethodBeat.m2504i(80656);
            AppMethodBeat.m2505o(80656);
        }

        public int init() {
            AppMethodBeat.m2504i(80657);
            int init = super.init();
            this.mLongLegFilter.ApplyGLSLFilter();
            AppMethodBeat.m2505o(80657);
            return init;
        }

        public void setEnable(boolean z) {
            this.enable = z;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public C41672h process(C41672h c41672h, int i, int i2) {
            AppMethodBeat.m2504i(80658);
            if (this.enable) {
                this.mLongLegFilter.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, this.mLongLegFrame);
                c41672h = this.mLongLegFrame;
                AppMethodBeat.m2505o(80658);
                return c41672h;
            }
            AppMethodBeat.m2505o(80658);
            return c41672h;
        }

        public void setWaistLine(List<PointF> list, int i) {
            AppMethodBeat.m2504i(80659);
            this.mLongLegFilter.setWaistLine((List) list, i);
            AppMethodBeat.m2505o(80659);
        }

        public void setStrength(float f) {
            AppMethodBeat.m2504i(80660);
            this.mLongLegFilter.setStrength(f);
            this.strength = f;
            AppMethodBeat.m2505o(80660);
        }

        public float getStrength() {
            return this.strength;
        }

        public void destroy() {
            AppMethodBeat.m2504i(80661);
            this.mLongLegFilter.clearGLSLSelf();
            this.mLongLegFrame.clear();
            super.destroy();
            AppMethodBeat.m2505o(80661);
        }
    }

    public static class PTYUV2RGBAFilter extends PTFilter {
        public PTYUV2RGBAFilter() {
            AppMethodBeat.m2504i(80692);
            this.mFilter = new C25635o();
            AppMethodBeat.m2505o(80692);
        }

        public void setRotationAndFlip(int i, boolean z, boolean z2) {
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(80693);
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
            AppMethodBeat.m2505o(80693);
        }

        public void setTextureCoordsMatrix(float[] fArr) {
            AppMethodBeat.m2504i(80694);
            this.mFilter.nativeUpdateMatrix(fArr);
            AppMethodBeat.m2505o(80694);
        }
    }

    public static class PTAlphaFilter extends PTFilter {
        public PTAlphaFilter() {
            AppMethodBeat.m2504i(80646);
            this.mFilter = new AlphaAdjustFilter();
            AppMethodBeat.m2505o(80646);
        }

        public int init() {
            AppMethodBeat.m2504i(80647);
            int init = super.init();
            this.mFilter.setAdjustParam(0.0f);
            this.mFilter.ApplyGLSLFilter(true, 0.0f, 0.0f);
            AppMethodBeat.m2505o(80647);
            return init;
        }
    }

    public static class PTFaceColorAndBrightnessFilter extends PTFilter {
        public PTFaceColorAndBrightnessFilter() {
            AppMethodBeat.m2504i(80654);
            this.mFilter = new FaceColorAndBrightnessFilter();
            AppMethodBeat.m2505o(80654);
        }

        public void updateCurve(int[] iArr, boolean z) {
            AppMethodBeat.m2504i(80655);
            ((FaceColorAndBrightnessFilter) this.mFilter).updateCurve(iArr, z);
            AppMethodBeat.m2505o(80655);
        }
    }

    public static class PTNewFaceColorFilter extends PTFilter {
        public PTNewFaceColorFilter() {
            AppMethodBeat.m2504i(80662);
            this.mFilter = new NewFaceColorFilter();
            AppMethodBeat.m2505o(80662);
        }

        public int init() {
            AppMethodBeat.m2504i(80663);
            int init = super.init();
            new C0936o("inputImageTexture2", "sh/facecolor_b.png", 33986).initialParams(this.mFilter.getmProgramIds());
            AppMethodBeat.m2505o(80663);
            return init;
        }
    }

    public static class PTSmoothSkin extends PTFilter {
        private CameraFilterParamSDK mBeautyParam;

        public PTSmoothSkin() {
            AppMethodBeat.m2504i(80676);
            this.mFilter = new FaceBeautysRealAutoFilter();
            this.mBeautyParam = new CameraFilterParamSDK();
            setBeautyLevel(1);
            AppMethodBeat.m2505o(80676);
        }

        public void setBeautyLevel(int i) {
            AppMethodBeat.m2504i(80677);
            this.mBeautyParam.smoothLevel = i;
            this.mFilter.setParameterDic(this.mBeautyParam.getSmoothMap());
            AppMethodBeat.m2505o(80677);
        }

        public int getBeautyLevel() {
            return this.mBeautyParam.smoothLevel;
        }
    }

    public static class PTThinBodyFilter extends PTFilter {
        private boolean enable = true;
        private ThinBodyFilter mThinBodyFilter = new ThinBodyFilter();
        private C41672h mThinBodyFrame = new C41672h();
        private float strength = 0.0f;

        public PTThinBodyFilter() {
            AppMethodBeat.m2504i(80678);
            AppMethodBeat.m2505o(80678);
        }

        public int init() {
            AppMethodBeat.m2504i(80679);
            int init = super.init();
            this.mThinBodyFilter.ApplyGLSLFilter();
            AppMethodBeat.m2505o(80679);
            return init;
        }

        public void setEnable(boolean z) {
            AppMethodBeat.m2504i(80680);
            this.mThinBodyFilter.setShowMark(true);
            this.mThinBodyFilter.setEnable(z);
            this.enable = z;
            AppMethodBeat.m2505o(80680);
        }

        public boolean isEnable() {
            return this.enable;
        }

        public void setBodyPoints(List<PointF> list, int i, int i2) {
            AppMethodBeat.m2504i(80681);
            if (list != null && list.size() > 0) {
                this.mThinBodyFilter.setupBodyPoints(list, i, i2);
            }
            AppMethodBeat.m2505o(80681);
        }

        public C41672h process(C41672h c41672h, int i, int i2) {
            AppMethodBeat.m2504i(80682);
            if (this.enable) {
                this.mThinBodyFilter.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, this.mThinBodyFrame);
                c41672h = this.mThinBodyFrame;
                AppMethodBeat.m2505o(80682);
                return c41672h;
            }
            AppMethodBeat.m2505o(80682);
            return c41672h;
        }

        public void setStrength(float f) {
            AppMethodBeat.m2504i(80683);
            this.mThinBodyFilter.setStrength(f);
            this.strength = f;
            AppMethodBeat.m2505o(80683);
        }

        public float getStrength() {
            return this.strength;
        }

        public void destroy() {
            AppMethodBeat.m2504i(80684);
            this.mThinBodyFilter.clearGLSLSelf();
            this.mThinBodyFrame.clear();
            super.destroy();
            AppMethodBeat.m2505o(80684);
        }
    }

    public static class PTThinShoulderFilter extends PTFilter {
        private boolean enable = true;
        private ThinShoulderFilter mThinShoulderFilter = new ThinShoulderFilter();
        private C41672h mThinShoulderFrame = new C41672h();
        private float strength = 0.0f;

        public PTThinShoulderFilter() {
            AppMethodBeat.m2504i(80685);
            AppMethodBeat.m2505o(80685);
        }

        public int init() {
            AppMethodBeat.m2504i(80686);
            int init = super.init();
            this.mThinShoulderFilter.ApplyGLSLFilter();
            AppMethodBeat.m2505o(80686);
            return init;
        }

        public void setEnable(boolean z) {
            AppMethodBeat.m2504i(80687);
            this.mThinShoulderFilter.setShowMark(true);
            this.mThinShoulderFilter.setEnable(z);
            this.enable = z;
            AppMethodBeat.m2505o(80687);
        }

        public boolean isEnable() {
            return this.enable;
        }

        public boolean setBodyPoints(List<PointF> list, int i, int i2) {
            AppMethodBeat.m2504i(80688);
            boolean z = this.mThinShoulderFilter.setupBodyPoints(list, i, i2);
            AppMethodBeat.m2505o(80688);
            return z;
        }

        public C41672h process(C41672h c41672h, int i, int i2) {
            AppMethodBeat.m2504i(80689);
            if (this.enable) {
                this.mThinShoulderFilter.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, this.mThinShoulderFrame);
                c41672h = this.mThinShoulderFrame;
                AppMethodBeat.m2505o(80689);
                return c41672h;
            }
            AppMethodBeat.m2505o(80689);
            return c41672h;
        }

        public void setStrength(float f) {
            AppMethodBeat.m2504i(80690);
            this.mThinShoulderFilter.setStrength(f);
            this.strength = f;
            AppMethodBeat.m2505o(80690);
        }

        public float getStrength() {
            return this.strength;
        }

        public void destroy() {
            AppMethodBeat.m2504i(80691);
            this.mThinShoulderFilter.clearGLSLSelf();
            this.mThinShoulderFrame.clear();
            super.destroy();
            AppMethodBeat.m2505o(80691);
        }
    }

    public static class PTCopyFilter extends PTFilter {
        public void setRotationAndFlip(int i, boolean z, boolean z2) {
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(80652);
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
            AppMethodBeat.m2505o(80652);
        }
    }

    public static class PTClarityMaskFilter extends PTFilter {
        private boolean hasApply = false;
        private ClarityMaskFilter mClarityMaskFilter = new ClarityMaskFilter();
        private C41672h mClarityMaskFrame = new C41672h();
        private SmoothSharpenFilter mSmoothSharpenFilter = new SmoothSharpenFilter();
        private C41672h mSmoothSharpenFrame = new C41672h();

        public PTClarityMaskFilter() {
            AppMethodBeat.m2504i(80648);
            AppMethodBeat.m2505o(80648);
        }

        public int init() {
            AppMethodBeat.m2504i(80649);
            int init = super.init();
            AppMethodBeat.m2505o(80649);
            return init;
        }

        public C41672h process(C41672h c41672h, int i, int i2) {
            AppMethodBeat.m2504i(80650);
            if (!this.hasApply) {
                this.mClarityMaskFilter.ApplyGLSLFilter(true, (float) i, (float) i2);
                this.mSmoothSharpenFilter.ApplyGLSLFilter(true, (float) i, (float) i2);
                this.hasApply = true;
            }
            int i3 = (c41672h.height * 720) / c41672h.width;
            this.mClarityMaskFilter.updateSize(720, i3);
            this.mClarityMaskFilter.RenderProcess(c41672h.texture[0], 720, i3, -1, 0.0d, this.mClarityMaskFrame);
            this.mSmoothSharpenFilter.updateTexture(this.mClarityMaskFrame.texture[0]);
            this.mSmoothSharpenFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mSmoothSharpenFrame);
            C41672h c41672h2 = this.mSmoothSharpenFrame;
            AppMethodBeat.m2505o(80650);
            return c41672h2;
        }

        public void destroy() {
            AppMethodBeat.m2504i(80651);
            this.mClarityMaskFilter.clearGLSLSelf();
            this.mSmoothSharpenFilter.clearGLSLSelf();
            this.mClarityMaskFrame.clear();
            this.mSmoothSharpenFrame.clear();
            this.hasApply = false;
            super.destroy();
            AppMethodBeat.m2505o(80651);
        }
    }

    public static class PTSmoothBFilters extends PTFilter {
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
        private SmoothBProcessFilter mProcessVarianceFilter = new SmoothBProcessFilter();
        private SmoothBProcessFilter mProcessVarianceFilter2 = new SmoothBProcessFilter();
        private C41672h mProcessVarianceFrame1 = new C41672h();
        private SmoothBVarianceFilter mVarianceFilter = new SmoothBVarianceFilter();
        private SmoothBVarianceFilter mVarianceFilter2 = new SmoothBVarianceFilter();
        private C41672h mVarianceFrame1 = new C41672h();
        private C41672h mVarianceFrame1_1 = new C41672h();
        private C41672h outputFrame = new C41672h();

        public PTSmoothBFilters() {
            AppMethodBeat.m2504i(80671);
            AppMethodBeat.m2505o(80671);
        }

        public int init() {
            AppMethodBeat.m2504i(80672);
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
            AppMethodBeat.m2505o(80672);
            return init;
        }

        public C41672h process(C41672h c41672h, int i, int i2) {
            AppMethodBeat.m2504i(80673);
            if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01f) {
                int i3 = (c41672h.height * v2helper.VOIP_ENC_HEIGHT_LV1) / c41672h.width;
                this.mBoxFilter.updateParam(360.0f, (float) i3);
                this.mBoxFilter.RenderProcess(c41672h.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i3, -1, 0.0d, this.mBoxFrame1);
                this.mVarianceFilter2.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0]);
                this.mVarianceFilter2.RenderProcess(c41672h.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i3, -1, 0.0d, this.mVarianceFrame1);
                this.mBoxFilter.updateParam(360.0f, (float) i3);
                this.mBoxFilter.RenderProcess(this.mVarianceFrame1.texture[0], v2helper.VOIP_ENC_HEIGHT_LV1, i3, -1, 0.0d, this.mBoxFrame2);
                this.mProcessVarianceFilter2.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).texture[0], FrameUtil.getLastRenderFrame(this.mBoxFrame2).texture[0]);
                this.mProcessVarianceFilter2.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.outputFrame);
            } else {
                this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.outputFrame);
            }
            C41672h c41672h2 = this.outputFrame;
            AppMethodBeat.m2505o(80673);
            return c41672h2;
        }

        public void updateBlurAlpha(float f) {
            AppMethodBeat.m2504i(80674);
            this.mProcessVarianceFilter.updateBlurAlpha(0.8f * f);
            this.mProcessVarianceFilter2.updateBlurAlpha(0.8f * f);
            AppMethodBeat.m2505o(80674);
        }

        public void destroy() {
            AppMethodBeat.m2504i(80675);
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
            AppMethodBeat.m2505o(80675);
        }
    }

    static {
        AppMethodBeat.m2504i(80708);
        if (FeatureManager.isFilterReady()) {
            try {
                FeatureManager.loadLibrary("image_filter_cpu");
                AppMethodBeat.m2505o(80708);
                return;
            } catch (UnsatisfiedLinkError e) {
                LogUtils.m50206e(e);
                AppMethodBeat.m2505o(80708);
                return;
            } catch (RuntimeException e2) {
                LogUtils.m50206e(e2);
                AppMethodBeat.m2505o(80708);
                return;
            } catch (Exception e3) {
                LogUtils.m50206e(e3);
            }
        }
        AppMethodBeat.m2505o(80708);
    }

    public PTFilter() {
        AppMethodBeat.m2504i(80695);
        AppMethodBeat.m2505o(80695);
    }

    public void setFilter(BaseFilter baseFilter) {
        this.mFilter = baseFilter;
    }

    public BaseFilter getFilter() {
        return this.mFilter;
    }

    public static PTFilter createById(int i, int i2) {
        AppMethodBeat.m2504i(80696);
        PTFilter pTFilter = new PTFilter();
        pTFilter.mFilter = C16516a.createFilter(i);
        pTFilter.mFilter.needFlipBlend = true;
        pTFilter.mFilter.setSrcFilterIndex(-1);
        pTFilter.mFilter.setEffectIndex(i2);
        AppMethodBeat.m2505o(80696);
        return pTFilter;
    }

    @Deprecated
    public static PTFilter createByFile(String str) {
        return null;
    }

    public static PTFilter createByLut(String str) {
        AppMethodBeat.m2504i(80697);
        PTFilter pTFilter = new PTFilter();
        Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), str, 1);
        if (decodeSampleBitmap == null) {
            decodeSampleBitmap = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(str);
        }
        pTFilter.mFilter = TTPicFilterFactoryLocal.lutFilterWithBitmap(decodeSampleBitmap);
        if (pTFilter.mFilter == null) {
            AppMethodBeat.m2505o(80697);
            return null;
        }
        pTFilter.mFilter.needFlipBlend = true;
        pTFilter.mFilter.setSrcFilterIndex(-1);
        pTFilter.mFilterFrame = new C41672h();
        AppMethodBeat.m2505o(80697);
        return pTFilter;
    }

    public static PTFilter createCurve2D(String str) {
        AppMethodBeat.m2504i(80698);
        PTFilter createCurve2D = createCurve2D(str, null);
        AppMethodBeat.m2505o(80698);
        return createCurve2D;
    }

    public static PTFilter createCurve2D(String str, float[] fArr) {
        AppMethodBeat.m2504i(80699);
        PTFilter pTFilter = new PTFilter();
        C17755e c17755e = new C17755e(str);
        if (fArr != null) {
            c17755e.setMatrix(fArr);
        }
        pTFilter.mFilter = c17755e;
        pTFilter.mFilter.needFlipBlend = true;
        pTFilter.mFilter.setSrcFilterIndex(-1);
        pTFilter.mFilterFrame = new C41672h();
        AppMethodBeat.m2505o(80699);
        return pTFilter;
    }

    public static PTFilter createCopyFilter() {
        AppMethodBeat.m2504i(80700);
        PTCopyFilter pTCopyFilter = new PTCopyFilter();
        AppMethodBeat.m2505o(80700);
        return pTCopyFilter;
    }

    public static PTFilter createYUV2RGBAFilter() {
        AppMethodBeat.m2504i(80701);
        PTFilter pTFilter = new PTFilter();
        pTFilter.mFilter = new C25635o();
        AppMethodBeat.m2505o(80701);
        return pTFilter;
    }

    public int init() {
        AppMethodBeat.m2504i(80702);
        this.mFilter.ApplyGLSLFilter(true, 1.0f, 1.0f);
        AppMethodBeat.m2505o(80702);
        return 0;
    }

    public void destroy() {
        AppMethodBeat.m2504i(80703);
        this.mFilter.ClearGLSL();
        this.mFilterFrame.clear();
        AppMethodBeat.m2505o(80703);
    }

    public C41672h process(C41672h c41672h) {
        AppMethodBeat.m2504i(80704);
        this.mFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mFilterFrame);
        C41672h lastRenderFrame = FrameUtil.getLastRenderFrame(this.mFilterFrame);
        AppMethodBeat.m2505o(80704);
        return lastRenderFrame;
    }

    public C41672h process(C41672h c41672h, int i, int i2) {
        AppMethodBeat.m2504i(80705);
        this.mFilter.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, this.mFilterFrame);
        C41672h lastRenderFrame = FrameUtil.getLastRenderFrame(this.mFilterFrame);
        AppMethodBeat.m2505o(80705);
        return lastRenderFrame;
    }

    public void processToScreen(C41672h c41672h, int i, int i2) {
        AppMethodBeat.m2504i(80706);
        this.mFilter.RenderProcess(c41672h.texture[0], i, i2, 0, 0.0d, this.mFilterFrame);
        AppMethodBeat.m2505o(80706);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(80707);
        this.mFilter.setRenderMode(i);
        AppMethodBeat.m2505o(80707);
    }
}
