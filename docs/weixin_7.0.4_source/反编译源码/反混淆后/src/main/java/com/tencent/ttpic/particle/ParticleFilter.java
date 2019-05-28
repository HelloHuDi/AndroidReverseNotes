package com.tencent.ttpic.particle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.ParticleParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class ParticleFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ParticleFragmentShader.dat");
    private static final String TAG = ParticleFilter.class.getSimpleName();
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ParticleVertexShader.dat");
    protected StickerItem item;
    private boolean mHasBodyDetected = false;
    private boolean mHasSeenValid = false;
    private List<PointF> mPreviousBodyPoints = null;
    private long mPreviousLostTime = System.currentTimeMillis();
    private long mTimesForLostProtect = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    private ParticleEmitter particleEmitter;
    private ParticleParam particleParam = new ParticleParam();
    protected TriggerCtrlItem triggerCtrlItem;
    protected boolean triggered = false;

    class ParticleEmitterParam {
        public PointF emitPosition;
        public float extraRotate;
        public float extraScale;

        private ParticleEmitterParam() {
            this.extraRotate = 0.0f;
            this.extraScale = 1.0f;
        }

        /* synthetic */ ParticleEmitterParam(ParticleFilter particleFilter, C59821 c59821) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(83631);
        AppMethodBeat.m2505o(83631);
    }

    public ParticleFilter(String str, StickerItem stickerItem) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(83619);
        this.item = stickerItem;
        this.particleEmitter = new ParticleEmitter();
        this.particleEmitter.initEmitter(str, stickerItem.particleConfig);
        this.triggerCtrlItem = new TriggerCtrlItem(stickerItem);
        initParams();
        setDrawMode(DRAW_MODE.TRIANGLES);
        AppMethodBeat.m2505o(83619);
    }

    private void resetParams() {
        int i = 1;
        AppMethodBeat.m2504i(83620);
        addParam(new C0935i("isPartical2", 1));
        String str = "u_opacityModifyRGB";
        if (!this.particleEmitter.opacityModifyRGB) {
            i = 0;
        }
        addParam(new C0935i(str, i));
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        setCoordNum(6);
        addAttribParam(new AttributeParam("position", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 3));
        addAttribParam(new AttributeParam("inputTextureCoordinate", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 2));
        addAttribParam(new AttributeParam("aColor", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 4));
        this.mHasSeenValid = false;
        this.mPreviousBodyPoints = null;
        this.particleParam.needRender = false;
        AppMethodBeat.m2505o(83620);
    }

    public void initParams() {
        int i = 1;
        AppMethodBeat.m2504i(83621);
        addParam(new C0935i("isPartical2", 1));
        String str = "u_opacityModifyRGB";
        if (!this.particleEmitter.opacityModifyRGB) {
            i = 0;
        }
        addParam(new C0935i(str, i));
        addParam(new C25627n("inputImageTexture2", 0, 33986));
        setCoordNum(6);
        this.particleParam.needRender = false;
        AppMethodBeat.m2505o(83621);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(83622);
        super.initAttribParams();
        addAttribParam(new AttributeParam("position", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 3));
        addAttribParam(new AttributeParam("inputTextureCoordinate", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 2));
        addAttribParam(new AttributeParam("aColor", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 4));
        AppMethodBeat.m2505o(83622);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(83623);
        if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
            avoidBodyPointsShake(pTDetectInfo);
        }
        updateActionTriggered(pTDetectInfo);
        if (!this.triggerCtrlItem.isTriggered()) {
            resetParams();
            AppMethodBeat.m2505o(83623);
        } else if (VideoMaterialUtil.isGestureItem(this.item)) {
            update(pTDetectInfo.handPoints, pTDetectInfo.faceAngles);
            AppMethodBeat.m2505o(83623);
        } else {
            if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
                update(pTDetectInfo.bodyPoints, pTDetectInfo.faceAngles);
                if (!this.mHasBodyDetected) {
                    pTDetectInfo.bodyPoints = null;
                    AppMethodBeat.m2505o(83623);
                    return;
                }
            }
            update(pTDetectInfo.facePoints, pTDetectInfo.faceAngles);
            AppMethodBeat.m2505o(83623);
        }
    }

    /* Access modifiers changed, original: protected */
    public void update(List<PointF> list, float[] fArr) {
        AppMethodBeat.m2504i(83624);
        updateParticle(updateEmitterParam(list, fArr));
        AppMethodBeat.m2505o(83624);
    }

    private ParticleEmitterParam updateEmitterParam(List<PointF> list, float[] fArr) {
        AppMethodBeat.m2504i(83625);
        ParticleEmitterParam particleEmitterParam = new ParticleEmitterParam(this, null);
        PointF pointF = null;
        int i;
        switch (this.item.type) {
            case 1:
                pointF = new PointF();
                if (((double) this.width) / ((double) this.height) < 0.75d) {
                    i = (int) (((double) this.height) * 0.75d);
                    int i2 = (int) (((double) this.height) * this.item.position[1]);
                    pointF.x = (float) (((int) (((double) i) * this.item.position[0])) - ((i - this.width) / 2));
                    pointF.y = (float) i2;
                    break;
                }
                i = (int) (((double) this.width) / 0.75d);
                i = ((int) (((double) i) * this.item.position[1])) - ((i - this.height) / 2);
                pointF.x = (float) ((int) (((double) this.width) * this.item.position[0]));
                pointF.y = (float) i;
                break;
            case 2:
            case 4:
            case 5:
            case 6:
                if (!(list == null || list.isEmpty())) {
                    float f;
                    PointF pointF2 = new PointF();
                    pointF = (PointF) list.get(this.item.alignFacePoints[0]);
                    if (this.item.alignFacePoints.length == 1) {
                        i = this.item.alignFacePoints[0];
                    } else {
                        i = this.item.alignFacePoints[1];
                    }
                    PointF pointF3 = (PointF) list.get(i);
                    PointF pointF4 = new PointF((pointF.x + pointF3.x) / 2.0f, (pointF.y + pointF3.y) / 2.0f);
                    pointF4.x = (float) (((double) pointF4.x) / this.mFaceDetScale);
                    pointF4.y = (float) (((double) pointF4.y) / this.mFaceDetScale);
                    pointF2.x = pointF4.x;
                    pointF2.y = pointF4.y;
                    pointF3 = new PointF(((PointF) list.get(this.item.scalePivots[0])).x, ((PointF) list.get(this.item.scalePivots[0])).y);
                    pointF3.x = (float) (((double) pointF3.x) / this.mFaceDetScale);
                    pointF3.y = (float) (((double) pointF3.y) / this.mFaceDetScale);
                    pointF4 = new PointF(((PointF) list.get(this.item.scalePivots[1])).x, ((PointF) list.get(this.item.scalePivots[1])).y);
                    pointF4.x = (float) (((double) pointF4.x) / this.mFaceDetScale);
                    pointF4.y = (float) (((double) pointF4.y) / this.mFaceDetScale);
                    double sqrt = Math.sqrt(Math.pow((double) (pointF3.y - pointF4.y), 2.0d) + Math.pow((double) (pointF3.x - pointF4.x), 2.0d)) / ((double) this.item.scaleFactor);
                    if (this.item.type == 2) {
                        particleEmitterParam.extraScale = (float) sqrt;
                    }
                    if (fArr == null || fArr.length < 3) {
                        f = 0.0f;
                    } else {
                        f = fArr[2];
                    }
                    particleEmitterParam.extraRotate = f;
                    pointF = pointF2;
                    break;
                }
                break;
        }
        particleEmitterParam.emitPosition = pointF;
        particleEmitterParam.extraScale *= (float) this.triggerCtrlItem.getAudioScaleFactor();
        particleEmitterParam.extraScale *= (((float) this.width) * 1.0f) / 720.0f;
        AppMethodBeat.m2505o(83625);
        return particleEmitterParam;
    }

    private void updateParticle(ParticleEmitterParam particleEmitterParam) {
        AppMethodBeat.m2504i(83626);
        PointF pointF = particleEmitterParam.emitPosition;
        float f = particleEmitterParam.extraScale;
        float f2 = particleEmitterParam.extraRotate;
        if (this.particleEmitter.totalFinished()) {
            this.particleEmitter.reset();
            this.particleEmitter.startTime = -1;
            this.particleEmitter.setSourcePosition(pointF != null ? new Vector2(pointF.x, ((float) this.height) - pointF.y) : new Vector2());
            this.particleEmitter.setExtraRotate(0.0f);
            this.particleEmitter.setExtraScale(1.0f);
            this.particleEmitter.startTime = System.currentTimeMillis();
        } else {
            float audioScaleFactor = (float) this.triggerCtrlItem.getAudioScaleFactor();
            LogUtils.m50202e(TAG, "AudioScaleFactor = ".concat(String.valueOf(audioScaleFactor)));
            this.particleEmitter.setExtraScale(audioScaleFactor);
            this.particleEmitter.setSourcePosition(pointF != null ? new Vector2(pointF.x, ((float) this.height) - pointF.y) : new Vector2());
            this.particleEmitter.setExtraScale(f);
            this.particleEmitter.setExtraRotate((float) Math.toDegrees((double) f2));
            BenchUtil.benchStart("updateWithCurrentTime");
            this.particleEmitter.updateWithCurrentTime(System.currentTimeMillis(), pointF != null);
            BenchUtil.benchEnd("updateWithCurrentTime");
        }
        int activeParticleCount = this.particleEmitter.activeParticleCount();
        if (activeParticleCount > 0) {
            float[] fArr = new float[(activeParticleCount * 18)];
            float[] fArr2 = new float[(activeParticleCount * 12)];
            float[] fArr3 = new float[(activeParticleCount * 24)];
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            BenchUtil.benchStart("setValue");
            for (int i7 = 0; i7 < this.particleEmitter.activeParticleCount(); i7++) {
                int i8;
                for (i8 = 0; i8 < 24; i8++) {
                    fArr3[i5 + i8] = this.particleEmitter.particleColors[i6 + i8];
                }
                for (i8 = 0; i8 < 18; i8++) {
                    if ((i8 + 2) % 3 == 0) {
                        fArr[i + i8] = ((float) this.height) - this.particleEmitter.particleVertices[i2 + i8];
                    } else {
                        fArr[i + i8] = this.particleEmitter.particleVertices[i2 + i8];
                    }
                }
                i8 = 0;
                while (true) {
                    int i9 = i8;
                    if (i9 >= 12) {
                        break;
                    }
                    fArr2[i3 + i9] = i9 % 2 != 0 ? 1.0f - this.particleEmitter.particleTextureCoordinates[i4 + i9] : this.particleEmitter.particleTextureCoordinates[i4 + i9];
                    i8 = i9 + 1;
                }
                i6 += 24;
                i2 += 18;
                i4 += 12;
                i5 += 24;
                i += 18;
                i3 += 12;
            }
            BenchUtil.benchEnd("setValue");
            setCoordNum(activeParticleCount * 6);
            addParam(new C25627n("inputImageTexture2", this.particleEmitter.texture, 33986));
            addParam(new C0935i("isPartical2", 1));
            addAttribParam(new AttributeParam("aColor", fArr3, 4));
            addAttribParam(new AttributeParam("position", normalizePosition(fArr, this.width, this.height), 3));
            setTexCords(fArr2);
            addParam(new C0935i("u_opacityModifyRGB", this.particleEmitter.opacityModifyRGB ? 1 : 0));
            if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
                if (this.particleParam == null) {
                    this.particleParam = new ParticleParam();
                }
                this.particleParam.f4885id = this.item.f18271id + this.item.alignFacePoints[0];
                this.particleParam.needRender = true;
                this.particleParam.coordNum = activeParticleCount * 6;
                this.particleParam.blendFuncSrc = this.particleEmitter.blendFuncSource;
                this.particleParam.blendFuncDst = this.particleEmitter.blendFuncDestination;
                this.particleParam.texture = this.particleEmitter.texture;
                this.particleParam.isPartical2 = 1;
                this.particleParam.u_opacityModifyRGB = this.particleEmitter.opacityModifyRGB ? 1 : 0;
                this.particleParam.maxParticleNum = this.item.particleConfig.getParticleEmitterConfig().getMaxParticles().getValue();
                this.particleParam.aColor = fArr3;
                this.particleParam.position = normalizePosition(fArr, this.width, this.height);
                this.particleParam.inputTextureCoordinate = fArr2;
            }
            AppMethodBeat.m2505o(83626);
            return;
        }
        resetParams();
        AppMethodBeat.m2505o(83626);
    }

    /* Access modifiers changed, original: protected */
    public TRIGGERED_STATUS updateActionTriggered(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(83627);
        TRIGGERED_STATUS triggeredStatus = this.triggerCtrlItem.getTriggeredStatus(pTDetectInfo);
        AppMethodBeat.m2505o(83627);
        return triggeredStatus;
    }

    private float[] normalizePosition(float[] fArr, int i, int i2) {
        float[] fArr2 = new float[fArr.length];
        for (int i3 = 0; i3 < fArr2.length / 3; i3++) {
            fArr2[i3 * 3] = ((fArr[i3 * 3] / ((float) i)) * 2.0f) - 1.0f;
            fArr2[(i3 * 3) + 1] = ((fArr[(i3 * 3) + 1] / ((float) i2)) * 2.0f) - 1.0f;
            fArr2[(i3 * 3) + 2] = fArr[(i3 * 3) + 2];
        }
        return fArr2;
    }

    public boolean isStatic() {
        if (this.item.type == POSITION_TYPE.STATIC.type || this.item.type == POSITION_TYPE.RELATIVE.type) {
            return true;
        }
        return false;
    }

    public boolean isBodyNeeded() {
        if (this.item.type == POSITION_TYPE.BODY.type) {
            return true;
        }
        return false;
    }

    public ParticleParam getParticleParam() {
        return this.particleParam;
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(83628);
        boolean z = GlUtil.curBlendModeEnabled;
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(this.particleEmitter.blendFuncSource, this.particleEmitter.blendFuncDestination);
        boolean renderTexture = super.renderTexture(i, i2, i3);
        GlUtil.setBlendMode(z);
        AppMethodBeat.m2505o(83628);
        return renderTexture;
    }

    public void clearGLSLSelf() {
        AppMethodBeat.m2504i(83629);
        super.clearGLSLSelf();
        this.particleEmitter.clear();
        AppMethodBeat.m2505o(83629);
    }

    private void avoidBodyPointsShake(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(83630);
        if (pTDetectInfo.bodyPoints == null || pTDetectInfo.bodyPoints.isEmpty()) {
            this.mHasBodyDetected = false;
            if (this.mHasSeenValid) {
                if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
                    pTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
                }
                AppMethodBeat.m2505o(83630);
                return;
            }
            this.mHasSeenValid = false;
            AppMethodBeat.m2505o(83630);
            return;
        }
        this.mHasBodyDetected = true;
        this.mHasSeenValid = true;
        this.mPreviousLostTime = System.currentTimeMillis();
        this.mPreviousBodyPoints = pTDetectInfo.bodyPoints;
        AppMethodBeat.m2505o(83630);
    }
}
