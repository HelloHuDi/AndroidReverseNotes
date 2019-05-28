package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bu.b;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTSegAttr;
import com.tencent.ttpic.PTSegmentor;
import com.tencent.ttpic.PTSticker;
import com.tencent.ttpic.config.BeautyRealConfig;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.filter.BeautyFaceList;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.filter.BeautyTransformList;
import com.tencent.ttpic.filter.BrightnessAdjustmentFilter;
import com.tencent.ttpic.filter.RemodelFilter;
import com.tencent.ttpic.filter.SmoothBFilters;
import com.tencent.ttpic.util.BeautyRealUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.view.g;
import com.tencent.wxmm.v2helper;
import java.util.List;
import java.util.Map;

public final class a {
    public static boolean ENABLE_GESTURE = true;
    public static float FACE_DETECT_IMG_WIDTH = 180.0f;
    public static boolean lhg = true;
    private boolean bZi = false;
    public int eYQ;
    public int eYW;
    public int eYX;
    private int frameIndex = -1;
    public BrightnessAdjustmentFilter lhh;
    private boolean lhi = true;
    public BaseFilter lhj;
    private h lhk;
    private h lhl;
    public b lhm;
    public int lhn;
    private byte[] lho;
    public int lhp;
    public BeautyFaceList mBeautyFaceList;
    private h mBeautyFrame2;
    public BeautyParam mBeautyParam;
    private h mBeautyTransformCopyFrame;
    public BeautyTransformList mBeautyTransformList;
    public BaseFilter mCopyFilter;
    public PTSticker mPTSticker;
    public RemodelFilter mRemodelFilter;
    public SmoothBFilters mSmoothBFilters;
    public BaseFilter mSwapCopyFilter = new BaseFilter(GLSLRender.bJB);
    public h[] mSwapFrames = new h[2];
    private h mTempFrame;

    public a() {
        AppMethodBeat.i(2549);
        try {
            this.lhj = new BaseFilter(GLSLRender.bJB);
            this.lhk = new h();
            this.mCopyFilter = new BaseFilter(GLSLRender.bJB);
            this.mTempFrame = new h();
            this.lhh = new BrightnessAdjustmentFilter();
            this.mSmoothBFilters = new SmoothBFilters();
            this.mBeautyFaceList = new BeautyFaceList();
            this.mRemodelFilter = new RemodelFilter();
            this.mBeautyTransformList = new BeautyTransformList();
            this.lhl = new h();
            this.mBeautyTransformCopyFrame = new h();
            this.mBeautyFrame2 = new h();
            this.mBeautyParam = new BeautyParam(true);
            this.lhm = new b(0);
            AppMethodBeat.o(2549);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", e, "create FilterProcess error", new Object[0]);
            d dVar = d.lhz;
            d.bmX();
            AppMethodBeat.o(2549);
        }
    }

    public final void clear() {
        AppMethodBeat.i(2550);
        ab.i("MicroMsg.EmojiFilterProcess", "clear %s %d", this, Long.valueOf(Thread.currentThread().getId()));
        try {
            this.lhj.ClearGLSL();
            this.lhk.clear();
            this.mSwapCopyFilter.ClearGLSL();
            for (h hVar : this.mSwapFrames) {
                if (hVar != null) {
                    hVar.clear();
                }
            }
            this.mCopyFilter.ClearGLSL();
            this.mTempFrame.clear();
            this.lhh.ClearGLSL();
            this.mSmoothBFilters.clear();
            this.mBeautyFaceList.clear();
            this.mRemodelFilter.clear();
            this.mBeautyTransformList.clear();
            this.lhl.clear();
            this.mBeautyTransformCopyFrame.clear();
            this.mBeautyFrame2.clear();
            if (this.mPTSticker != null) {
                this.mPTSticker.destroy();
                this.mPTSticker = null;
            }
            this.lhm.destroy();
            PTSegmentor.getInstance().destroy();
            GLES20.glDeleteFramebuffers(1, new int[]{this.lhp}, 0);
            AppMethodBeat.o(2550);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", e, "clear error: %s", e.getMessage());
            d dVar = d.lhz;
            d.bmZ();
            AppMethodBeat.o(2550);
        }
    }

    public final void bmD() {
        AppMethodBeat.i(2551);
        long yz = bo.yz();
        try {
            this.frameIndex = (this.frameIndex + 1) % 2;
            this.lhj.RenderProcess(this.eYQ, this.eYW, this.eYX, -1, 1.0d, this.lhk);
            this.mSwapCopyFilter.RenderProcess(FrameUtil.getLastRenderFrame(this.lhk).texture[0], this.eYW, this.eYX, -1, 0.0d, this.mSwapFrames[this.frameIndex]);
            h hVar = this.mSwapFrames[this.frameIndex];
            if (lhg) {
                boolean z;
                h origFrame;
                int intValue;
                h hVar2;
                List allFacePoints;
                int i = (VideoFilterUtil.get4DirectionAngle((double) this.lhm.getPhotoAngle()) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                if (bmE()) {
                    GLES20.glFinish();
                }
                b bVar = this.lhm;
                if (this.mPTSticker == null || !this.mPTSticker.needDetectGesture()) {
                    z = false;
                } else {
                    z = true;
                }
                PTFaceAttr a = bVar.a(hVar, z, false, false);
                PTSegmentor instance = PTSegmentor.getInstance();
                if (this.mPTSticker == null || !this.mPTSticker.isSegmentRequired()) {
                    z = false;
                } else {
                    z = true;
                }
                PTSegAttr detectFrame = instance.detectFrame(hVar, i, z);
                if (a != null) {
                    float f;
                    origFrame = a.getOrigFrame();
                    intValue = ((Integer) a.getHistogram().first).intValue();
                    if (intValue <= 40) {
                        f = 0.0f;
                    } else if (intValue >= 80) {
                        f = 1.0f;
                    } else {
                        f = (((float) intValue) - 40.0f) / 40.0f;
                    }
                    this.mBeautyFaceList.setNormalAlphaFactor(f);
                    hVar = origFrame;
                }
                if (a == null || a.getBrightnessAdjustmentCurve() == null) {
                    origFrame = hVar;
                } else {
                    this.lhh.updateCurve(a.getBrightnessAdjustmentCurve(), true);
                    this.lhh.RenderProcess(hVar.texture[0], this.eYW, this.eYX, -1, 0.0d, this.lhl);
                    origFrame = this.lhl;
                }
                if (origFrame.width <= 0 || origFrame.height <= 0 || a == null) {
                    hVar2 = origFrame;
                } else {
                    allFacePoints = a.getAllFacePoints();
                    int faceDetectScale = (int) (((double) origFrame.width) * a.getFaceDetectScale());
                    int faceDetectScale2 = (int) (((double) origFrame.height) * a.getFaceDetectScale());
                    int rotation = a.getRotation();
                    this.mSmoothBFilters.setOnlyDetFaceRectSkin(!this.lhi);
                    this.mSmoothBFilters.updateAndRender(origFrame, this.mBeautyFrame2, allFacePoints, faceDetectScale, faceDetectScale2, rotation);
                    hVar2 = this.mBeautyFrame2;
                }
                if (a != null) {
                    this.mBeautyFaceList.updateVideoSize(this.eYW, this.eYX, a.getFaceDetectScale());
                    this.mBeautyFaceList.setLightRemovePouchSkinTexture(this.mSmoothBFilters.getVarianceFrame().texture[0]);
                    hVar2 = this.mBeautyFaceList.render(hVar2, a.getAllFacePoints());
                }
                if (this.mBeautyTransformList == null || a == null) {
                    hVar = hVar2;
                } else {
                    allFacePoints = a.getAllFacePoints();
                    double faceDetectScale3 = a.getFaceDetectScale();
                    List allFaceAngles = a.getAllFaceAngles();
                    intValue = a.getRotation();
                    h process = this.mBeautyTransformList.process(hVar2, allFacePoints, faceDetectScale3, allFaceAngles, (float) intValue);
                    if (detectFrame.getMaskFrame() != null) {
                        origFrame = detectFrame.getMaskFrame();
                        this.mCopyFilter.RenderProcess(origFrame.texture[0], origFrame.width, origFrame.height, -1, 0.0d, this.mBeautyTransformCopyFrame);
                        detectFrame.setMaskFrame(this.mBeautyTransformList.process(this.mBeautyTransformCopyFrame, allFacePoints, faceDetectScale3, allFaceAngles, (float) intValue));
                    }
                    hVar = this.mRemodelFilter.process(process, allFacePoints, allFaceAngles, faceDetectScale3);
                }
                if (bmE() && a != null) {
                    this.mPTSticker.updateVideoSize(this.eYW, this.eYX, a.getFaceDetectScale(), a.getRotation());
                    hVar = this.mPTSticker.processStickerFilters(this.mPTSticker.processTransformRelatedFilters(hVar, a, detectFrame), a, detectFrame);
                }
                this.mCopyFilter.RenderProcess(hVar.texture[0], this.eYW, this.eYX, this.lhn, 1.0d, this.mTempFrame);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindTexture(3553, 0);
                ab.d("MicroMsg.EmojiFilterProcess", "filterProcess: cost %s", Long.valueOf(bo.az(yz)));
                AppMethodBeat.o(2551);
                return;
            }
            this.mCopyFilter.RenderProcess(hVar.texture[0], this.eYW, this.eYX, this.lhn, 1.0d, this.mTempFrame);
            if (this.lho != null) {
                g.a(hVar.texture[0], this.eYW, this.eYX, this.lho, this.lhp);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.o(2551);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", e, "filterProcess error", new Object[0]);
            d dVar = d.lhz;
            d.bmY();
        }
    }

    private boolean bmE() {
        return this.mPTSticker != null;
    }

    public final void a(TYPE type, int i) {
        int i2 = 0;
        AppMethodBeat.i(2552);
        if (BeautyRealUtil.isCombinedType(type.value)) {
            Map beautyLevels = BeautyRealUtil.getBeautyLevels(type.value, false);
            if (beautyLevels.containsKey(TYPE.BEAUTY)) {
                b(TYPE.BEAUTY, ((Integer) beautyLevels.get(TYPE.BEAUTY)).intValue());
            }
            if (beautyLevels.containsKey(TYPE.BASIC3)) {
                b(TYPE.BASIC3, ((Integer) beautyLevels.get(TYPE.BASIC3)).intValue());
            }
            TYPE[] typeArr = BeautyRealConfig.SINGLE_TRANS_TYPE;
            int length = typeArr.length;
            while (i2 < length) {
                Object obj = typeArr[i2];
                b(obj, ((Integer) beautyLevels.get(obj)).intValue());
                i2++;
            }
            AppMethodBeat.o(2552);
        } else if (type == TYPE.LIPS_THICKNESS) {
            b(type, 0 - i);
            AppMethodBeat.o(2552);
        } else {
            b(type, i);
            AppMethodBeat.o(2552);
        }
    }

    public final void ch(int i, int i2) {
        this.eYW = i;
        this.eYX = i2;
        MediaConfig.VIDEO_OUTPUT_WIDTH = i;
        MediaConfig.VIDEO_OUTPUT_HEIGHT = i2;
    }

    private void b(TYPE type, int i) {
        AppMethodBeat.i(2553);
        ab.i("MicroMsg.EmojiFilterProcess", "setupCosmeticsLevelInner: %s, %s", type, Integer.valueOf(i));
        switch (type) {
            case BEAUTY:
                this.mSmoothBFilters.updateBlurAlpha((((float) i) * 0.6f) / 100.0f);
                if (this.mBeautyFaceList != null) {
                    this.mBeautyFaceList.setLightRemovePouchAlpha((((float) i) * 0.6f) / 100.0f);
                    AppMethodBeat.o(2553);
                    return;
                }
                break;
            case COLOR_TONE:
                AppMethodBeat.o(2553);
                return;
            case REMOVE_POUNCH:
                if (this.mBeautyFaceList != null) {
                    this.mBeautyFaceList.setRemovePounchAlpha(((float) i) / 100.0f);
                    AppMethodBeat.o(2553);
                    return;
                }
                break;
            case EYE_LIGHTEN:
                if (this.mBeautyFaceList != null) {
                    this.mBeautyFaceList.setEyeLightenAlpha(((float) i) / 100.0f);
                    AppMethodBeat.o(2553);
                    return;
                }
                break;
            case TOOTH_WHITEN:
                if (this.mBeautyFaceList != null) {
                    this.mBeautyFaceList.setToothWhitenAlpha(((float) i) / 80.0f);
                    AppMethodBeat.o(2553);
                    return;
                }
                break;
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
                AppMethodBeat.o(2553);
                return;
            case BASIC3:
            case FACE_SHORTEN:
            case NOSE:
                if (!(this.mBeautyParam == null || this.mBeautyTransformList == null)) {
                    this.mBeautyTransformList.setBeautyParam(type.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(type.value), i, type.value));
                    break;
                }
        }
        AppMethodBeat.o(2553);
    }
}
