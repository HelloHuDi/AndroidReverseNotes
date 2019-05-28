package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFilter.PTAlphaFilter;
import com.tencent.ttpic.PTFilter.PTLongLegFilter;
import com.tencent.ttpic.PTFilter.PTSlimWaistFilter;
import com.tencent.ttpic.config.BeautyRealConfig;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.BeautyFaceList;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.filter.BeautyTransformList;
import com.tencent.ttpic.filter.ColorToneFilter;
import com.tencent.ttpic.filter.RemodelFilter;
import com.tencent.ttpic.filter.SmoothBFilters;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.BeautyRealUtil;
import com.tencent.ttpic.util.BenchUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PTGlamorize {
    public static boolean ENABLE_GESTURE = true;
    public static final String TAG = PTGlamorize.class.getSimpleName();
    private static boolean isFaceDetectInited = false;
    private float FACE_DETECT_IMG_WIDTH = 180.0f;
    private boolean isUnInitSwapCopyFilter = true;
    private double mAspectRatio = 0.5625d;
    private BeautyFaceList mBeautyFaceList = new BeautyFaceList();
    private C41672h mBeautyFrame2 = new C41672h();
    private BeautyParam mBeautyParam;
    private C41672h mBeautyTransformCopyFrame = new C41672h();
    private BeautyTransformList mBeautyTransformList = new BeautyTransformList();
    private ColorToneFilter mColorToneFilter = new ColorToneFilter();
    private C41672h mColorToneFrame = new C41672h();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private boolean mEnableLongLeg = true;
    private boolean mEnableSlimWaist = true;
    private PTFaceAttr mFaceAttr;
    private double mFaceDetectScale = 0.1666666716337204d;
    private int mFrameIndex = -1;
    private int mHeightFrame = 0;
    private PTFilter mPTAlphaFilter = new PTAlphaFilter();
    private PTFilter mPTFilter;
    private PTLongLegFilter mPTLongLegFilter = new PTLongLegFilter();
    PTSegmentor mPTSegmentor = PTSegmentor.getInstance();
    private PTSlimWaistFilter mPTSlimWaistFilter = new PTSlimWaistFilter();
    private PTSticker mPTSticker;
    private PTFaceDetector mPTfaceDectector = new PTFaceDetector();
    private RemodelFilter mRemodelFilter = new RemodelFilter();
    private int mRotationDegree = 0;
    private PTSegAttr mSegAttr;
    private SmoothBFilters mSmoothBFilters = new SmoothBFilters();
    private BaseFilter mSwapCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h[] mSwapFrames = new C41672h[2];
    private C41672h mTempFrame = new C41672h();
    private int mWidthFrame = 0;

    public PTGlamorize() {
        AppMethodBeat.m2504i(80710);
        AppMethodBeat.m2505o(80710);
    }

    static {
        AppMethodBeat.m2504i(80730);
        AppMethodBeat.m2505o(80730);
    }

    public void init() {
        int i = 0;
        AppMethodBeat.m2504i(80711);
        this.mSmoothBFilters.initial();
        this.mSmoothBFilters.setOnlyDetFaceRectSkin(false);
        this.mBeautyTransformList.initial();
        this.mColorToneFilter.ApplyGLSLFilter();
        this.mBeautyFaceList.initial();
        this.mRemodelFilter.init();
        if (this.mPTFilter != null) {
            this.mPTFilter.init();
        }
        this.mPTAlphaFilter.init();
        this.mPTLongLegFilter.init();
        this.mPTSlimWaistFilter.init();
        this.mBeautyParam = new BeautyParam(true);
        this.mBeautyParam.changeFaceMeshSet(1);
        while (i < this.mSwapFrames.length) {
            this.mSwapFrames[i] = new C41672h();
            i++;
        }
        try {
            this.mPTfaceDectector.init();
            this.mPTfaceDectector.getFaceDetector().clearActionCounter();
            this.mPTSegmentor.init();
            isFaceDetectInited = true;
            AppMethodBeat.m2505o(80711);
        } catch (Exception e) {
            AppMethodBeat.m2505o(80711);
        }
    }

    public void init(BeautyParam beautyParam) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ad A:{Catch:{ Exception -> 0x0201 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01db A:{Catch:{ Exception -> 0x0204 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C41672h process(C41672h c41672h) {
        C41672h c41672h2;
        AppMethodBeat.m2504i(80712);
        if (!(this.mWidthFrame == c41672h.width && this.mHeightFrame == c41672h.height)) {
            this.mWidthFrame = c41672h.width;
            this.mHeightFrame = c41672h.height;
            this.mFaceDetectScale = (double) (180.0f / ((float) this.mWidthFrame));
            if (this.mHeightFrame != 0) {
                this.mAspectRatio = ((double) this.mWidthFrame) / ((double) this.mHeightFrame);
            }
        }
        this.mFrameIndex = (this.mFrameIndex + 1) % 2;
        if (this.isUnInitSwapCopyFilter) {
            this.mSwapCopyFilter.ApplyGLSLFilter(true, (float) this.mWidthFrame, (float) this.mHeightFrame);
            this.isUnInitSwapCopyFilter = false;
        }
        this.mSwapCopyFilter.nativeSetRotationAndFlip(0, 0, 1);
        this.mSwapCopyFilter.RenderProcess(c41672h.texture[0], this.mWidthFrame, this.mHeightFrame, -1, 0.0d, this.mSwapFrames[this.mFrameIndex]);
        C41672h c41672h3 = this.mSwapFrames[this.mFrameIndex];
        this.mRotationDegree = 0;
        if (this.mPTSticker != null) {
            GLES20.glFinish();
        }
        this.mFaceAttr = detectFace(c41672h3, this.mRotationDegree, this.mWidthFrame);
        PTSegmentor pTSegmentor = this.mPTSegmentor;
        int i = this.mRotationDegree;
        boolean z = this.mPTSticker != null && this.mPTSticker.isSegmentRequired();
        this.mSegAttr = pTSegmentor.detectFrame(c41672h3, i, z);
        updateBeautyNormalFactor(((Integer) this.mFaceAttr.getHistogram().first).intValue());
        C41672h origFrame = this.mFaceAttr.getOrigFrame();
        if (this.mPTFilter != null) {
            c41672h3 = this.mPTFilter.process(origFrame, this.mWidthFrame, this.mHeightFrame);
            this.mPTAlphaFilter.getFilter().addParam(new C25627n("inputImageTexture2", origFrame.texture[0], 33986));
            origFrame = this.mPTAlphaFilter.process(c41672h3, this.mWidthFrame, this.mHeightFrame);
        }
        origFrame = renderBeautyFilter(origFrame, this.mFaceDetectScale);
        if (this.mBeautyFaceList != null) {
            this.mBeautyFaceList.updateVideoSize(this.mWidthFrame, this.mHeightFrame, this.mFaceDetectScale);
        }
        origFrame = renderBeautyFaceList(origFrame, this.mFaceAttr);
        if (this.mColorToneFilter.needRender()) {
            this.mColorToneFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mColorToneFrame);
            c41672h2 = this.mColorToneFrame;
        } else {
            c41672h2 = origFrame;
        }
        if (this.mFaceAttr != null && (this.mEnableLongLeg || this.mEnableSlimWaist)) {
            List bodyPoints = this.mFaceAttr.getBodyPoints();
            ArrayList arrayList = new ArrayList();
            if (!bodyPoints.isEmpty()) {
                bodyPoints = (List) bodyPoints.get(0);
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= bodyPoints.size()) {
                        break;
                    }
                    arrayList.add(new PointF((float) (((double) ((PointF) bodyPoints.get(i)).x) / this.mFaceAttr.getFaceDetectScale()), (float) (((double) ((PointF) bodyPoints.get(i)).y) / this.mFaceAttr.getFaceDetectScale())));
                    i2 = i + 1;
                }
            }
            if (this.mEnableLongLeg) {
                this.mPTLongLegFilter.setWaistLine(arrayList, this.mHeightFrame);
                c41672h2 = this.mPTLongLegFilter.process(c41672h2, this.mWidthFrame, this.mHeightFrame);
            }
            if (this.mEnableSlimWaist && this.mPTSlimWaistFilter.setWaistRectangle(arrayList, this.mWidthFrame, this.mHeightFrame)) {
                origFrame = this.mPTSlimWaistFilter.process(c41672h2, this.mWidthFrame, this.mHeightFrame);
                if (this.mPTSticker != null) {
                    this.mPTSticker.updateVideoSize(this.mWidthFrame, this.mHeightFrame, this.mFaceAttr.getFaceDetectScale(), this.mRotationDegree);
                    origFrame = this.mPTSticker.processTransformRelatedFilters(origFrame, this.mFaceAttr, this.mSegAttr);
                }
                c41672h3 = origFrame;
                origFrame = renderBeautyTransformList(c41672h3, this.mFaceAttr, this.mSegAttr, this.mFaceDetectScale, (float) this.mRotationDegree);
                if (this.mPTSticker != null) {
                    origFrame = this.mPTSticker.processStickerFilters(origFrame, this.mFaceAttr, this.mSegAttr);
                }
                this.mSwapCopyFilter.RenderProcess(origFrame.texture[0], this.mWidthFrame, this.mHeightFrame, -1, 0.0d, this.mTempFrame);
                origFrame = this.mTempFrame;
                AppMethodBeat.m2505o(80712);
                return origFrame;
            }
        }
        origFrame = c41672h2;
        try {
            if (this.mPTSticker != null) {
            }
            c41672h3 = origFrame;
        } catch (Exception e) {
            c41672h3 = origFrame;
        }
        origFrame = renderBeautyTransformList(c41672h3, this.mFaceAttr, this.mSegAttr, this.mFaceDetectScale, (float) this.mRotationDegree);
        try {
            if (this.mPTSticker != null) {
            }
        } catch (Exception e2) {
        }
        this.mSwapCopyFilter.RenderProcess(origFrame.texture[0], this.mWidthFrame, this.mHeightFrame, -1, 0.0d, this.mTempFrame);
        origFrame = this.mTempFrame;
        AppMethodBeat.m2505o(80712);
        return origFrame;
    }

    private void updateBeautyNormalFactor(int i) {
        AppMethodBeat.m2504i(80713);
        if (this.mBeautyFaceList != null) {
            float f;
            if (i <= 40) {
                f = 0.0f;
            } else if (i >= 80) {
                f = 1.0f;
            } else {
                f = (((float) i) - 40.0f) / 40.0f;
            }
            this.mBeautyFaceList.setNormalAlphaFactor(f);
        }
        AppMethodBeat.m2505o(80713);
    }

    private PTFaceAttr detectFace(C41672h c41672h, int i, int i2) {
        boolean z;
        AppMethodBeat.m2504i(80714);
        float f = this.FACE_DETECT_IMG_WIDTH / ((float) i2);
        boolean z2 = ENABLE_GESTURE && this.mPTSticker != null && this.mPTSticker.needDetectGesture();
        BenchUtil.benchStart("PTFaceDetector");
        PTFaceDetector pTFaceDetector = this.mPTfaceDectector;
        if (this.mEnableLongLeg || this.mEnableSlimWaist) {
            z = true;
        } else {
            z = false;
        }
        PTFaceAttr detectFrame = pTFaceDetector.detectFrame(c41672h, null, i, true, z2, z, (double) f);
        BenchUtil.benchEnd("PTFaceDetector");
        AppMethodBeat.m2505o(80714);
        return detectFrame;
    }

    private C41672h renderBeautyFaceList(C41672h c41672h, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.m2504i(80715);
        if (!(this.mBeautyFaceList == null || pTFaceAttr == null || this.mSmoothBFilters == null)) {
            this.mBeautyFaceList.setLightRemovePouchSkinTexture(this.mSmoothBFilters.getVarianceFrame().texture[0]);
            c41672h = this.mBeautyFaceList.render(c41672h, pTFaceAttr.getAllFacePoints());
        }
        AppMethodBeat.m2505o(80715);
        return c41672h;
    }

    private C41672h renderBeautyTransformList(C41672h c41672h, PTFaceAttr pTFaceAttr, PTSegAttr pTSegAttr, double d, float f) {
        AppMethodBeat.m2504i(80716);
        if (this.mBeautyTransformList == null || pTFaceAttr == null) {
            AppMethodBeat.m2505o(80716);
            return c41672h;
        }
        C41672h process = this.mBeautyTransformList.process(c41672h, pTFaceAttr.getAllFacePoints(), d, pTFaceAttr.getAllFaceAngles(), f);
        if (!(pTSegAttr == null || pTSegAttr.getMaskFrame() == null)) {
            C41672h maskFrame = pTSegAttr.getMaskFrame();
            this.mCopyFilter.RenderProcess(maskFrame.texture[0], maskFrame.width, maskFrame.height, -1, 0.0d, this.mBeautyTransformCopyFrame);
            pTSegAttr.setMaskFrame(this.mBeautyTransformList.process(this.mBeautyTransformCopyFrame, pTFaceAttr.getAllFacePoints(), this.mFaceDetectScale, pTFaceAttr.getAllFaceAngles(), (float) this.mRotationDegree));
        }
        c41672h = this.mRemodelFilter.process(process, pTFaceAttr.getAllFacePoints(), pTFaceAttr.getAllFaceAngles(), d);
        AppMethodBeat.m2505o(80716);
        return c41672h;
    }

    private C41672h renderBeautyFilter(C41672h c41672h, double d) {
        AppMethodBeat.m2504i(80717);
        if (c41672h.width > 0 && c41672h.height > 0) {
            List arrayList = new ArrayList();
            if (this.mFaceAttr != null) {
                arrayList = this.mFaceAttr.getAllFacePoints();
            }
            this.mSmoothBFilters.updateAndRender(c41672h, this.mBeautyFrame2, arrayList, (int) (((double) c41672h.width) * d), (int) (((double) c41672h.height) * d), this.mRotationDegree);
            c41672h = this.mBeautyFrame2;
        }
        AppMethodBeat.m2505o(80717);
        return c41672h;
    }

    public void clear() {
        AppMethodBeat.m2504i(80718);
        this.mPTfaceDectector.destroy();
        this.mPTSegmentor.destroy();
        this.mSmoothBFilters.clear();
        this.mBeautyTransformList.clear();
        this.mColorToneFilter.clearGLSLSelf();
        this.mBeautyFaceList.clear();
        this.mRemodelFilter.clear();
        if (this.mPTFilter != null) {
            this.mPTFilter.destroy();
        }
        this.mPTAlphaFilter.destroy();
        this.mPTLongLegFilter.destroy();
        this.mPTSlimWaistFilter.destroy();
        if (this.mPTSticker != null) {
            this.mPTSticker.destroy();
        }
        this.mSwapCopyFilter.ClearGLSL();
        this.mCopyFilter.ClearGLSL();
        clearFrames();
        AppMethodBeat.m2505o(80718);
    }

    private void clearFrames() {
        AppMethodBeat.m2504i(80719);
        this.mBeautyTransformCopyFrame.clear();
        for (C41672h c41672h : this.mSwapFrames) {
            if (c41672h != null) {
                c41672h.clear();
            }
        }
        this.mColorToneFrame.clear();
        this.mBeautyFrame2.clear();
        this.mTempFrame.clear();
        AppMethodBeat.m2505o(80719);
    }

    public void setBeautyLevel(TYPE type, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(80720);
        if (BeautyRealUtil.isCombinedType(type.value)) {
            Map beautyLevels = BeautyRealUtil.getBeautyLevels(type.value, false);
            if (beautyLevels.containsKey(TYPE.BEAUTY)) {
                setAtomBeautyLevel(TYPE.BEAUTY, ((Integer) beautyLevels.get(TYPE.BEAUTY)).intValue());
            }
            if (beautyLevels.containsKey(TYPE.BASIC3)) {
                setAtomBeautyLevel(TYPE.BASIC3, ((Integer) beautyLevels.get(TYPE.BASIC3)).intValue());
            }
            TYPE[] typeArr = BeautyRealConfig.SINGLE_TRANS_TYPE_574;
            int length = typeArr.length;
            while (i2 < length) {
                Object obj = typeArr[i2];
                setAtomBeautyLevel(obj, ((Integer) beautyLevels.get(obj)).intValue());
                i2++;
            }
            AppMethodBeat.m2505o(80720);
        } else if (type == TYPE.LIPS_THICKNESS) {
            setAtomBeautyLevel(type, 0 - i);
            AppMethodBeat.m2505o(80720);
        } else {
            setAtomBeautyLevel(type, i);
            AppMethodBeat.m2505o(80720);
        }
    }

    private void setAtomBeautyLevel(TYPE type, int i) {
        AppMethodBeat.m2504i(80721);
        switch (type) {
            case BEAUTY:
                this.mSmoothBFilters.updateBlurAlpha((((float) i) * 0.8f) / 100.0f);
                AppMethodBeat.m2505o(80721);
                return;
            case COLOR_TONE:
                this.mColorToneFilter.updateAlpha(((float) i) / 100.0f);
                AppMethodBeat.m2505o(80721);
                return;
            case REMOVE_POUNCH:
                this.mBeautyFaceList.setRemovePounchAlpha(((float) i) / 100.0f);
                AppMethodBeat.m2505o(80721);
                return;
            case EYE_LIGHTEN:
                this.mBeautyFaceList.setEyeLightenAlpha(((float) i) / 100.0f);
                AppMethodBeat.m2505o(80721);
                return;
            case TOOTH_WHITEN:
                this.mBeautyFaceList.setToothWhitenAlpha(((float) i) / 80.0f);
                AppMethodBeat.m2505o(80721);
                return;
            case FOREHEAD:
            case EYE:
            case EYE_DISTANCE:
            case EYE_ANGLE:
            case MOUTH_SHAPE:
            case CHIN:
            case FACE_THIN:
            case FACE_V:
            case NOSE_WING:
            case NOSE_POSITION:
            case LIPS_THICKNESS:
            case LIPS_WIDTH:
                this.mRemodelFilter.setParam(type.value, (float) i);
                AppMethodBeat.m2505o(80721);
                return;
            case BASIC3:
            case FACE_SHORTEN:
            case NOSE:
                this.mBeautyTransformList.setBeautyParam(type.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(type.value), i, type.value));
                break;
        }
        AppMethodBeat.m2505o(80721);
    }

    public void setCosmeticMaterial(VideoMaterial videoMaterial, int i) {
        AppMethodBeat.m2504i(80722);
        if (this.mPTSticker != null) {
            this.mPTSticker.destroy();
            this.mPTSticker = null;
        }
        if (!(videoMaterial == null || videoMaterial.getDataPath() == null || videoMaterial.getId() == null)) {
            this.mPTSticker = new PTSticker(videoMaterial, this.mPTfaceDectector.getFaceDetector());
            this.mPTSticker.init();
            setCosmeticAlpha(i);
        }
        AppMethodBeat.m2505o(80722);
    }

    public void setCosmeticAlpha(int i) {
        AppMethodBeat.m2504i(80723);
        if (this.mPTSticker != null) {
            this.mPTSticker.updateCosAlpha(i);
        }
        AppMethodBeat.m2505o(80723);
    }

    public void changeFilter(int i, int i2) {
        AppMethodBeat.m2504i(80724);
        if (this.mPTFilter != null) {
            this.mPTFilter.destroy();
            this.mPTFilter = null;
        }
        if (FilterEnum4Shaka.contains(i)) {
            this.mPTFilter = new PTFilter();
            this.mPTFilter.setFilter(FilterPlus.createFilter(i));
            this.mPTFilter.getFilter().needFlipBlend = true;
            this.mPTFilter.getFilter().setEffectIndex(i2);
        } else {
            this.mPTFilter = PTFilter.createById(i, i2);
        }
        if (this.mPTFilter == null) {
            AppMethodBeat.m2505o(80724);
            return;
        }
        this.mPTFilter.init();
        AppMethodBeat.m2505o(80724);
    }

    public void adjustFilterParam(float f) {
        AppMethodBeat.m2504i(80725);
        if (this.mPTAlphaFilter != null) {
            this.mPTAlphaFilter.getFilter().setAdjustParam(1.0f - f);
        }
        AppMethodBeat.m2505o(80725);
    }

    public void setEnableLongLeg(boolean z) {
        AppMethodBeat.m2504i(80726);
        this.mEnableLongLeg = z;
        if (this.mEnableLongLeg && ((double) this.mPTLongLegFilter.getStrength()) < 1.0E-5d) {
            this.mEnableLongLeg = false;
        }
        AppMethodBeat.m2505o(80726);
    }

    public void setLongLegStrength(float f) {
        AppMethodBeat.m2504i(80727);
        if (this.mPTLongLegFilter != null) {
            this.mPTLongLegFilter.setStrength(f);
            if (((double) this.mPTLongLegFilter.getStrength()) < 1.0E-5d) {
                this.mEnableLongLeg = false;
                AppMethodBeat.m2505o(80727);
                return;
            }
            this.mEnableLongLeg = true;
        }
        AppMethodBeat.m2505o(80727);
    }

    public void setmEnableSlimWaist(boolean z) {
        AppMethodBeat.m2504i(80728);
        this.mEnableSlimWaist = z;
        if (this.mEnableSlimWaist && ((double) this.mPTSlimWaistFilter.getStrength()) < 1.0E-5d) {
            this.mEnableSlimWaist = false;
        }
        AppMethodBeat.m2505o(80728);
    }

    public void setSlimWaistStrength(float f) {
        AppMethodBeat.m2504i(80729);
        if (this.mPTSlimWaistFilter != null) {
            this.mPTSlimWaistFilter.setStrength(f);
            if (((double) this.mPTSlimWaistFilter.getStrength()) < 1.0E-5d) {
                this.mEnableSlimWaist = false;
                AppMethodBeat.m2505o(80729);
                return;
            }
            this.mEnableSlimWaist = true;
        }
        AppMethodBeat.m2505o(80729);
    }
}
