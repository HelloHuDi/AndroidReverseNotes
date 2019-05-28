package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.filter.m.n;
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
    private h mBeautyFrame2 = new h();
    private BeautyParam mBeautyParam;
    private h mBeautyTransformCopyFrame = new h();
    private BeautyTransformList mBeautyTransformList = new BeautyTransformList();
    private ColorToneFilter mColorToneFilter = new ColorToneFilter();
    private h mColorToneFrame = new h();
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
    private h[] mSwapFrames = new h[2];
    private h mTempFrame = new h();
    private int mWidthFrame = 0;

    public PTGlamorize() {
        AppMethodBeat.i(80710);
        AppMethodBeat.o(80710);
    }

    static {
        AppMethodBeat.i(80730);
        AppMethodBeat.o(80730);
    }

    public void init() {
        int i = 0;
        AppMethodBeat.i(80711);
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
            this.mSwapFrames[i] = new h();
            i++;
        }
        try {
            this.mPTfaceDectector.init();
            this.mPTfaceDectector.getFaceDetector().clearActionCounter();
            this.mPTSegmentor.init();
            isFaceDetectInited = true;
            AppMethodBeat.o(80711);
        } catch (Exception e) {
            AppMethodBeat.o(80711);
        }
    }

    public void init(BeautyParam beautyParam) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ad A:{Catch:{ Exception -> 0x0201 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01db A:{Catch:{ Exception -> 0x0204 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h process(h hVar) {
        h hVar2;
        AppMethodBeat.i(80712);
        if (!(this.mWidthFrame == hVar.width && this.mHeightFrame == hVar.height)) {
            this.mWidthFrame = hVar.width;
            this.mHeightFrame = hVar.height;
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
        this.mSwapCopyFilter.RenderProcess(hVar.texture[0], this.mWidthFrame, this.mHeightFrame, -1, 0.0d, this.mSwapFrames[this.mFrameIndex]);
        h hVar3 = this.mSwapFrames[this.mFrameIndex];
        this.mRotationDegree = 0;
        if (this.mPTSticker != null) {
            GLES20.glFinish();
        }
        this.mFaceAttr = detectFace(hVar3, this.mRotationDegree, this.mWidthFrame);
        PTSegmentor pTSegmentor = this.mPTSegmentor;
        int i = this.mRotationDegree;
        boolean z = this.mPTSticker != null && this.mPTSticker.isSegmentRequired();
        this.mSegAttr = pTSegmentor.detectFrame(hVar3, i, z);
        updateBeautyNormalFactor(((Integer) this.mFaceAttr.getHistogram().first).intValue());
        h origFrame = this.mFaceAttr.getOrigFrame();
        if (this.mPTFilter != null) {
            hVar3 = this.mPTFilter.process(origFrame, this.mWidthFrame, this.mHeightFrame);
            this.mPTAlphaFilter.getFilter().addParam(new n("inputImageTexture2", origFrame.texture[0], 33986));
            origFrame = this.mPTAlphaFilter.process(hVar3, this.mWidthFrame, this.mHeightFrame);
        }
        origFrame = renderBeautyFilter(origFrame, this.mFaceDetectScale);
        if (this.mBeautyFaceList != null) {
            this.mBeautyFaceList.updateVideoSize(this.mWidthFrame, this.mHeightFrame, this.mFaceDetectScale);
        }
        origFrame = renderBeautyFaceList(origFrame, this.mFaceAttr);
        if (this.mColorToneFilter.needRender()) {
            this.mColorToneFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mColorToneFrame);
            hVar2 = this.mColorToneFrame;
        } else {
            hVar2 = origFrame;
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
                hVar2 = this.mPTLongLegFilter.process(hVar2, this.mWidthFrame, this.mHeightFrame);
            }
            if (this.mEnableSlimWaist && this.mPTSlimWaistFilter.setWaistRectangle(arrayList, this.mWidthFrame, this.mHeightFrame)) {
                origFrame = this.mPTSlimWaistFilter.process(hVar2, this.mWidthFrame, this.mHeightFrame);
                if (this.mPTSticker != null) {
                    this.mPTSticker.updateVideoSize(this.mWidthFrame, this.mHeightFrame, this.mFaceAttr.getFaceDetectScale(), this.mRotationDegree);
                    origFrame = this.mPTSticker.processTransformRelatedFilters(origFrame, this.mFaceAttr, this.mSegAttr);
                }
                hVar3 = origFrame;
                origFrame = renderBeautyTransformList(hVar3, this.mFaceAttr, this.mSegAttr, this.mFaceDetectScale, (float) this.mRotationDegree);
                if (this.mPTSticker != null) {
                    origFrame = this.mPTSticker.processStickerFilters(origFrame, this.mFaceAttr, this.mSegAttr);
                }
                this.mSwapCopyFilter.RenderProcess(origFrame.texture[0], this.mWidthFrame, this.mHeightFrame, -1, 0.0d, this.mTempFrame);
                origFrame = this.mTempFrame;
                AppMethodBeat.o(80712);
                return origFrame;
            }
        }
        origFrame = hVar2;
        try {
            if (this.mPTSticker != null) {
            }
            hVar3 = origFrame;
        } catch (Exception e) {
            hVar3 = origFrame;
        }
        origFrame = renderBeautyTransformList(hVar3, this.mFaceAttr, this.mSegAttr, this.mFaceDetectScale, (float) this.mRotationDegree);
        try {
            if (this.mPTSticker != null) {
            }
        } catch (Exception e2) {
        }
        this.mSwapCopyFilter.RenderProcess(origFrame.texture[0], this.mWidthFrame, this.mHeightFrame, -1, 0.0d, this.mTempFrame);
        origFrame = this.mTempFrame;
        AppMethodBeat.o(80712);
        return origFrame;
    }

    private void updateBeautyNormalFactor(int i) {
        AppMethodBeat.i(80713);
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
        AppMethodBeat.o(80713);
    }

    private PTFaceAttr detectFace(h hVar, int i, int i2) {
        boolean z;
        AppMethodBeat.i(80714);
        float f = this.FACE_DETECT_IMG_WIDTH / ((float) i2);
        boolean z2 = ENABLE_GESTURE && this.mPTSticker != null && this.mPTSticker.needDetectGesture();
        BenchUtil.benchStart("PTFaceDetector");
        PTFaceDetector pTFaceDetector = this.mPTfaceDectector;
        if (this.mEnableLongLeg || this.mEnableSlimWaist) {
            z = true;
        } else {
            z = false;
        }
        PTFaceAttr detectFrame = pTFaceDetector.detectFrame(hVar, null, i, true, z2, z, (double) f);
        BenchUtil.benchEnd("PTFaceDetector");
        AppMethodBeat.o(80714);
        return detectFrame;
    }

    private h renderBeautyFaceList(h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(80715);
        if (!(this.mBeautyFaceList == null || pTFaceAttr == null || this.mSmoothBFilters == null)) {
            this.mBeautyFaceList.setLightRemovePouchSkinTexture(this.mSmoothBFilters.getVarianceFrame().texture[0]);
            hVar = this.mBeautyFaceList.render(hVar, pTFaceAttr.getAllFacePoints());
        }
        AppMethodBeat.o(80715);
        return hVar;
    }

    private h renderBeautyTransformList(h hVar, PTFaceAttr pTFaceAttr, PTSegAttr pTSegAttr, double d, float f) {
        AppMethodBeat.i(80716);
        if (this.mBeautyTransformList == null || pTFaceAttr == null) {
            AppMethodBeat.o(80716);
            return hVar;
        }
        h process = this.mBeautyTransformList.process(hVar, pTFaceAttr.getAllFacePoints(), d, pTFaceAttr.getAllFaceAngles(), f);
        if (!(pTSegAttr == null || pTSegAttr.getMaskFrame() == null)) {
            h maskFrame = pTSegAttr.getMaskFrame();
            this.mCopyFilter.RenderProcess(maskFrame.texture[0], maskFrame.width, maskFrame.height, -1, 0.0d, this.mBeautyTransformCopyFrame);
            pTSegAttr.setMaskFrame(this.mBeautyTransformList.process(this.mBeautyTransformCopyFrame, pTFaceAttr.getAllFacePoints(), this.mFaceDetectScale, pTFaceAttr.getAllFaceAngles(), (float) this.mRotationDegree));
        }
        hVar = this.mRemodelFilter.process(process, pTFaceAttr.getAllFacePoints(), pTFaceAttr.getAllFaceAngles(), d);
        AppMethodBeat.o(80716);
        return hVar;
    }

    private h renderBeautyFilter(h hVar, double d) {
        AppMethodBeat.i(80717);
        if (hVar.width > 0 && hVar.height > 0) {
            List arrayList = new ArrayList();
            if (this.mFaceAttr != null) {
                arrayList = this.mFaceAttr.getAllFacePoints();
            }
            this.mSmoothBFilters.updateAndRender(hVar, this.mBeautyFrame2, arrayList, (int) (((double) hVar.width) * d), (int) (((double) hVar.height) * d), this.mRotationDegree);
            hVar = this.mBeautyFrame2;
        }
        AppMethodBeat.o(80717);
        return hVar;
    }

    public void clear() {
        AppMethodBeat.i(80718);
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
        AppMethodBeat.o(80718);
    }

    private void clearFrames() {
        AppMethodBeat.i(80719);
        this.mBeautyTransformCopyFrame.clear();
        for (h hVar : this.mSwapFrames) {
            if (hVar != null) {
                hVar.clear();
            }
        }
        this.mColorToneFrame.clear();
        this.mBeautyFrame2.clear();
        this.mTempFrame.clear();
        AppMethodBeat.o(80719);
    }

    public void setBeautyLevel(TYPE type, int i) {
        int i2 = 0;
        AppMethodBeat.i(80720);
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
            AppMethodBeat.o(80720);
        } else if (type == TYPE.LIPS_THICKNESS) {
            setAtomBeautyLevel(type, 0 - i);
            AppMethodBeat.o(80720);
        } else {
            setAtomBeautyLevel(type, i);
            AppMethodBeat.o(80720);
        }
    }

    private void setAtomBeautyLevel(TYPE type, int i) {
        AppMethodBeat.i(80721);
        switch (type) {
            case BEAUTY:
                this.mSmoothBFilters.updateBlurAlpha((((float) i) * 0.8f) / 100.0f);
                AppMethodBeat.o(80721);
                return;
            case COLOR_TONE:
                this.mColorToneFilter.updateAlpha(((float) i) / 100.0f);
                AppMethodBeat.o(80721);
                return;
            case REMOVE_POUNCH:
                this.mBeautyFaceList.setRemovePounchAlpha(((float) i) / 100.0f);
                AppMethodBeat.o(80721);
                return;
            case EYE_LIGHTEN:
                this.mBeautyFaceList.setEyeLightenAlpha(((float) i) / 100.0f);
                AppMethodBeat.o(80721);
                return;
            case TOOTH_WHITEN:
                this.mBeautyFaceList.setToothWhitenAlpha(((float) i) / 80.0f);
                AppMethodBeat.o(80721);
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
                AppMethodBeat.o(80721);
                return;
            case BASIC3:
            case FACE_SHORTEN:
            case NOSE:
                this.mBeautyTransformList.setBeautyParam(type.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(type.value), i, type.value));
                break;
        }
        AppMethodBeat.o(80721);
    }

    public void setCosmeticMaterial(VideoMaterial videoMaterial, int i) {
        AppMethodBeat.i(80722);
        if (this.mPTSticker != null) {
            this.mPTSticker.destroy();
            this.mPTSticker = null;
        }
        if (!(videoMaterial == null || videoMaterial.getDataPath() == null || videoMaterial.getId() == null)) {
            this.mPTSticker = new PTSticker(videoMaterial, this.mPTfaceDectector.getFaceDetector());
            this.mPTSticker.init();
            setCosmeticAlpha(i);
        }
        AppMethodBeat.o(80722);
    }

    public void setCosmeticAlpha(int i) {
        AppMethodBeat.i(80723);
        if (this.mPTSticker != null) {
            this.mPTSticker.updateCosAlpha(i);
        }
        AppMethodBeat.o(80723);
    }

    public void changeFilter(int i, int i2) {
        AppMethodBeat.i(80724);
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
            AppMethodBeat.o(80724);
            return;
        }
        this.mPTFilter.init();
        AppMethodBeat.o(80724);
    }

    public void adjustFilterParam(float f) {
        AppMethodBeat.i(80725);
        if (this.mPTAlphaFilter != null) {
            this.mPTAlphaFilter.getFilter().setAdjustParam(1.0f - f);
        }
        AppMethodBeat.o(80725);
    }

    public void setEnableLongLeg(boolean z) {
        AppMethodBeat.i(80726);
        this.mEnableLongLeg = z;
        if (this.mEnableLongLeg && ((double) this.mPTLongLegFilter.getStrength()) < 1.0E-5d) {
            this.mEnableLongLeg = false;
        }
        AppMethodBeat.o(80726);
    }

    public void setLongLegStrength(float f) {
        AppMethodBeat.i(80727);
        if (this.mPTLongLegFilter != null) {
            this.mPTLongLegFilter.setStrength(f);
            if (((double) this.mPTLongLegFilter.getStrength()) < 1.0E-5d) {
                this.mEnableLongLeg = false;
                AppMethodBeat.o(80727);
                return;
            }
            this.mEnableLongLeg = true;
        }
        AppMethodBeat.o(80727);
    }

    public void setmEnableSlimWaist(boolean z) {
        AppMethodBeat.i(80728);
        this.mEnableSlimWaist = z;
        if (this.mEnableSlimWaist && ((double) this.mPTSlimWaistFilter.getStrength()) < 1.0E-5d) {
            this.mEnableSlimWaist = false;
        }
        AppMethodBeat.o(80728);
    }

    public void setSlimWaistStrength(float f) {
        AppMethodBeat.i(80729);
        if (this.mPTSlimWaistFilter != null) {
            this.mPTSlimWaistFilter.setStrength(f);
            if (((double) this.mPTSlimWaistFilter.getStrength()) < 1.0E-5d) {
                this.mEnableSlimWaist = false;
                AppMethodBeat.o(80729);
                return;
            }
            this.mEnableSlimWaist = true;
        }
        AppMethodBeat.o(80729);
    }
}
