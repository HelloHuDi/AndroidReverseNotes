package com.tencent.p177mm.plugin.emojicapture.p386d;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p206bu.C1333b;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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
import com.tencent.view.C41106g;
import com.tencent.wxmm.v2helper;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.emojicapture.d.a */
public final class C2954a {
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
    private C41672h lhk;
    private C41672h lhl;
    public C1333b lhm;
    public int lhn;
    private byte[] lho;
    public int lhp;
    public BeautyFaceList mBeautyFaceList;
    private C41672h mBeautyFrame2;
    public BeautyParam mBeautyParam;
    private C41672h mBeautyTransformCopyFrame;
    public BeautyTransformList mBeautyTransformList;
    public BaseFilter mCopyFilter;
    public PTSticker mPTSticker;
    public RemodelFilter mRemodelFilter;
    public SmoothBFilters mSmoothBFilters;
    public BaseFilter mSwapCopyFilter = new BaseFilter(GLSLRender.bJB);
    public C41672h[] mSwapFrames = new C41672h[2];
    private C41672h mTempFrame;

    public C2954a() {
        AppMethodBeat.m2504i(2549);
        try {
            this.lhj = new BaseFilter(GLSLRender.bJB);
            this.lhk = new C41672h();
            this.mCopyFilter = new BaseFilter(GLSLRender.bJB);
            this.mTempFrame = new C41672h();
            this.lhh = new BrightnessAdjustmentFilter();
            this.mSmoothBFilters = new SmoothBFilters();
            this.mBeautyFaceList = new BeautyFaceList();
            this.mRemodelFilter = new RemodelFilter();
            this.mBeautyTransformList = new BeautyTransformList();
            this.lhl = new C41672h();
            this.mBeautyTransformCopyFrame = new C41672h();
            this.mBeautyFrame2 = new C41672h();
            this.mBeautyParam = new BeautyParam(true);
            this.lhm = new C1333b(0);
            AppMethodBeat.m2505o(2549);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", e, "create FilterProcess error", new Object[0]);
            C34007d c34007d = C34007d.lhz;
            C34007d.bmX();
            AppMethodBeat.m2505o(2549);
        }
    }

    public final void clear() {
        AppMethodBeat.m2504i(2550);
        C4990ab.m7417i("MicroMsg.EmojiFilterProcess", "clear %s %d", this, Long.valueOf(Thread.currentThread().getId()));
        try {
            this.lhj.ClearGLSL();
            this.lhk.clear();
            this.mSwapCopyFilter.ClearGLSL();
            for (C41672h c41672h : this.mSwapFrames) {
                if (c41672h != null) {
                    c41672h.clear();
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
            AppMethodBeat.m2505o(2550);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", e, "clear error: %s", e.getMessage());
            C34007d c34007d = C34007d.lhz;
            C34007d.bmZ();
            AppMethodBeat.m2505o(2550);
        }
    }

    public final void bmD() {
        AppMethodBeat.m2504i(2551);
        long yz = C5046bo.m7588yz();
        try {
            this.frameIndex = (this.frameIndex + 1) % 2;
            this.lhj.RenderProcess(this.eYQ, this.eYW, this.eYX, -1, 1.0d, this.lhk);
            this.mSwapCopyFilter.RenderProcess(FrameUtil.getLastRenderFrame(this.lhk).texture[0], this.eYW, this.eYX, -1, 0.0d, this.mSwapFrames[this.frameIndex]);
            C41672h c41672h = this.mSwapFrames[this.frameIndex];
            if (lhg) {
                boolean z;
                C41672h origFrame;
                int intValue;
                C41672h c41672h2;
                List allFacePoints;
                int i = (VideoFilterUtil.get4DirectionAngle((double) this.lhm.getPhotoAngle()) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                if (bmE()) {
                    GLES20.glFinish();
                }
                C1333b c1333b = this.lhm;
                if (this.mPTSticker == null || !this.mPTSticker.needDetectGesture()) {
                    z = false;
                } else {
                    z = true;
                }
                PTFaceAttr a = c1333b.mo4681a(c41672h, z, false, false);
                PTSegmentor instance = PTSegmentor.getInstance();
                if (this.mPTSticker == null || !this.mPTSticker.isSegmentRequired()) {
                    z = false;
                } else {
                    z = true;
                }
                PTSegAttr detectFrame = instance.detectFrame(c41672h, i, z);
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
                    c41672h = origFrame;
                }
                if (a == null || a.getBrightnessAdjustmentCurve() == null) {
                    origFrame = c41672h;
                } else {
                    this.lhh.updateCurve(a.getBrightnessAdjustmentCurve(), true);
                    this.lhh.RenderProcess(c41672h.texture[0], this.eYW, this.eYX, -1, 0.0d, this.lhl);
                    origFrame = this.lhl;
                }
                if (origFrame.width <= 0 || origFrame.height <= 0 || a == null) {
                    c41672h2 = origFrame;
                } else {
                    allFacePoints = a.getAllFacePoints();
                    int faceDetectScale = (int) (((double) origFrame.width) * a.getFaceDetectScale());
                    int faceDetectScale2 = (int) (((double) origFrame.height) * a.getFaceDetectScale());
                    int rotation = a.getRotation();
                    this.mSmoothBFilters.setOnlyDetFaceRectSkin(!this.lhi);
                    this.mSmoothBFilters.updateAndRender(origFrame, this.mBeautyFrame2, allFacePoints, faceDetectScale, faceDetectScale2, rotation);
                    c41672h2 = this.mBeautyFrame2;
                }
                if (a != null) {
                    this.mBeautyFaceList.updateVideoSize(this.eYW, this.eYX, a.getFaceDetectScale());
                    this.mBeautyFaceList.setLightRemovePouchSkinTexture(this.mSmoothBFilters.getVarianceFrame().texture[0]);
                    c41672h2 = this.mBeautyFaceList.render(c41672h2, a.getAllFacePoints());
                }
                if (this.mBeautyTransformList == null || a == null) {
                    c41672h = c41672h2;
                } else {
                    allFacePoints = a.getAllFacePoints();
                    double faceDetectScale3 = a.getFaceDetectScale();
                    List allFaceAngles = a.getAllFaceAngles();
                    intValue = a.getRotation();
                    C41672h process = this.mBeautyTransformList.process(c41672h2, allFacePoints, faceDetectScale3, allFaceAngles, (float) intValue);
                    if (detectFrame.getMaskFrame() != null) {
                        origFrame = detectFrame.getMaskFrame();
                        this.mCopyFilter.RenderProcess(origFrame.texture[0], origFrame.width, origFrame.height, -1, 0.0d, this.mBeautyTransformCopyFrame);
                        detectFrame.setMaskFrame(this.mBeautyTransformList.process(this.mBeautyTransformCopyFrame, allFacePoints, faceDetectScale3, allFaceAngles, (float) intValue));
                    }
                    c41672h = this.mRemodelFilter.process(process, allFacePoints, allFaceAngles, faceDetectScale3);
                }
                if (bmE() && a != null) {
                    this.mPTSticker.updateVideoSize(this.eYW, this.eYX, a.getFaceDetectScale(), a.getRotation());
                    c41672h = this.mPTSticker.processStickerFilters(this.mPTSticker.processTransformRelatedFilters(c41672h, a, detectFrame), a, detectFrame);
                }
                this.mCopyFilter.RenderProcess(c41672h.texture[0], this.eYW, this.eYX, this.lhn, 1.0d, this.mTempFrame);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindTexture(3553, 0);
                C4990ab.m7411d("MicroMsg.EmojiFilterProcess", "filterProcess: cost %s", Long.valueOf(C5046bo.m7525az(yz)));
                AppMethodBeat.m2505o(2551);
                return;
            }
            this.mCopyFilter.RenderProcess(c41672h.texture[0], this.eYW, this.eYX, this.lhn, 1.0d, this.mTempFrame);
            if (this.lho != null) {
                C41106g.m71540a(c41672h.texture[0], this.eYW, this.eYX, this.lho, this.lhp);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.m2505o(2551);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", e, "filterProcess error", new Object[0]);
            C34007d c34007d = C34007d.lhz;
            C34007d.bmY();
        }
    }

    private boolean bmE() {
        return this.mPTSticker != null;
    }

    /* renamed from: a */
    public final void mo7161a(TYPE type, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(2552);
        if (BeautyRealUtil.isCombinedType(type.value)) {
            Map beautyLevels = BeautyRealUtil.getBeautyLevels(type.value, false);
            if (beautyLevels.containsKey(TYPE.BEAUTY)) {
                m5249b(TYPE.BEAUTY, ((Integer) beautyLevels.get(TYPE.BEAUTY)).intValue());
            }
            if (beautyLevels.containsKey(TYPE.BASIC3)) {
                m5249b(TYPE.BASIC3, ((Integer) beautyLevels.get(TYPE.BASIC3)).intValue());
            }
            TYPE[] typeArr = BeautyRealConfig.SINGLE_TRANS_TYPE;
            int length = typeArr.length;
            while (i2 < length) {
                Object obj = typeArr[i2];
                m5249b(obj, ((Integer) beautyLevels.get(obj)).intValue());
                i2++;
            }
            AppMethodBeat.m2505o(2552);
        } else if (type == TYPE.LIPS_THICKNESS) {
            m5249b(type, 0 - i);
            AppMethodBeat.m2505o(2552);
        } else {
            m5249b(type, i);
            AppMethodBeat.m2505o(2552);
        }
    }

    /* renamed from: ch */
    public final void mo7163ch(int i, int i2) {
        this.eYW = i;
        this.eYX = i2;
        MediaConfig.VIDEO_OUTPUT_WIDTH = i;
        MediaConfig.VIDEO_OUTPUT_HEIGHT = i2;
    }

    /* renamed from: b */
    private void m5249b(TYPE type, int i) {
        AppMethodBeat.m2504i(2553);
        C4990ab.m7417i("MicroMsg.EmojiFilterProcess", "setupCosmeticsLevelInner: %s, %s", type, Integer.valueOf(i));
        switch (type) {
            case BEAUTY:
                this.mSmoothBFilters.updateBlurAlpha((((float) i) * 0.6f) / 100.0f);
                if (this.mBeautyFaceList != null) {
                    this.mBeautyFaceList.setLightRemovePouchAlpha((((float) i) * 0.6f) / 100.0f);
                    AppMethodBeat.m2505o(2553);
                    return;
                }
                break;
            case COLOR_TONE:
                AppMethodBeat.m2505o(2553);
                return;
            case REMOVE_POUNCH:
                if (this.mBeautyFaceList != null) {
                    this.mBeautyFaceList.setRemovePounchAlpha(((float) i) / 100.0f);
                    AppMethodBeat.m2505o(2553);
                    return;
                }
                break;
            case EYE_LIGHTEN:
                if (this.mBeautyFaceList != null) {
                    this.mBeautyFaceList.setEyeLightenAlpha(((float) i) / 100.0f);
                    AppMethodBeat.m2505o(2553);
                    return;
                }
                break;
            case TOOTH_WHITEN:
                if (this.mBeautyFaceList != null) {
                    this.mBeautyFaceList.setToothWhitenAlpha(((float) i) / 80.0f);
                    AppMethodBeat.m2505o(2553);
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
                AppMethodBeat.m2505o(2553);
                return;
            case BASIC3:
            case FACE_SHORTEN:
            case NOSE:
                if (!(this.mBeautyParam == null || this.mBeautyTransformList == null)) {
                    this.mBeautyTransformList.setBeautyParam(type.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(type.value), i, type.value));
                    break;
                }
        }
        AppMethodBeat.m2505o(2553);
    }
}
