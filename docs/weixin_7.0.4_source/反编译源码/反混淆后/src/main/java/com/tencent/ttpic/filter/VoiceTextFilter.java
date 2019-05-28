package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TextRenderItem;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.model.WMGroup;
import com.tencent.ttpic.particlesystem2d.Particle;
import com.tencent.ttpic.particlesystem2d.ParticleItem;
import com.tencent.ttpic.particlesystem2d.ParticleSystem2D;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.PARTICLE_CLEAR_MODE;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class VoiceTextFilter extends VideoFilterBase {
    private static final String TAG = VoiceTextFilter.class.getSimpleName();
    private float faceDetScale;
    private FastRenderFilter fastRenderFilter = new FastRenderFilter();
    private int frameInterval;
    private boolean isBackground;
    private long lastFrameTimestamp = -1;
    private int lastHeight = -1;
    private int lastWidth = -1;
    private ParticleItem[] particleItems;
    private ParticleSystem2D particleSystem2D = new ParticleSystem2D(VideoGlobalContext.getContext());
    private List<RenderParam> renderParams = new ArrayList();
    private List<StickerItem> stickerItems;
    private List<TextRenderItem> textRenderItems = new ArrayList();
    private int zIndex;

    static {
        AppMethodBeat.m2504i(83178);
        AppMethodBeat.m2505o(83178);
    }

    public VoiceTextFilter(int i, List<StickerItem> list) {
        super(PROGRAM_TYPE.FAST_STICKER);
        AppMethodBeat.m2504i(83160);
        this.zIndex = i;
        this.isBackground = i < 0;
        this.stickerItems = list;
        initParticleItems(list);
        AppMethodBeat.m2505o(83160);
    }

    private void initParticleItems(List<StickerItem> list) {
        AppMethodBeat.m2504i(83161);
        if (list != null) {
            this.particleItems = new ParticleItem[list.size()];
            for (int i = 0; i < list.size(); i++) {
                StickerItem stickerItem = (StickerItem) list.get(i);
                if (stickerItem.wmGroupCopies != null) {
                    for (WMGroup init : stickerItem.wmGroupCopies) {
                        init.init();
                    }
                }
                ParticleItem particleItem = new ParticleItem(stickerItem);
                particleItem.triggerCtrlItem = new TriggerCtrlItem(stickerItem);
                particleItem.particles = new Particle[stickerItem.transition.particleCountMax];
                particleItem.maxRepeatCount = stickerItem.transition.repeatCount;
                particleItem.emissionMode = stickerItem.transition.emissionMode;
                particleItem.particleAlwaysUpdate = stickerItem.transition.particleAlwaysUpdate;
                particleItem.clearMode = stickerItem.transition.clearMode;
                for (int i2 = 0; i2 < particleItem.particles.length; i2++) {
                    particleItem.particles[i2] = new Particle();
                }
                this.particleItems[i] = particleItem;
            }
            this.particleSystem2D.createParticles(list);
        }
        AppMethodBeat.m2505o(83161);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(83162);
        super.ApplyGLSLFilter();
        this.fastRenderFilter.applyGLSLFilter();
        AppMethodBeat.m2505o(83162);
    }

    public boolean isBackground() {
        return this.isBackground;
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(83163);
        super.updateVideoSize(i, i2, d);
        this.fastRenderFilter.updateVideoSize(i, i2);
        this.faceDetScale = (float) d;
        for (TextRenderItem updateVideoSize : this.textRenderItems) {
            updateVideoSize.updateVideoSize(i, i2);
        }
        if (this.lastWidth > 0 && this.lastHeight > 0 && !(i == this.lastWidth && i2 == this.lastHeight)) {
            resetAll();
        }
        this.lastWidth = i;
        this.lastHeight = i2;
        AppMethodBeat.m2505o(83163);
    }

    private void resetAll() {
        AppMethodBeat.m2504i(83164);
        this.particleSystem2D.reset();
        for (ParticleItem reset : this.particleItems) {
            reset.reset();
        }
        AppMethodBeat.m2505o(83164);
    }

    private void reset(int i) {
        AppMethodBeat.m2504i(83165);
        this.particleSystem2D.clearParticles(i);
        if (this.particleItems != null && i < this.particleItems.length) {
            this.particleItems[i].reset();
        }
        AppMethodBeat.m2505o(83165);
    }

    public void initParams() {
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(83166);
        BenchUtil.benchStart(TAG + " updatePreview");
        if (this.lastFrameTimestamp != -1) {
            this.frameInterval = (int) (pTDetectInfo.timestamp - this.lastFrameTimestamp);
        }
        this.lastFrameTimestamp = pTDetectInfo.timestamp;
        BenchUtil.benchStart(TAG + " updateParticleItemTrigger");
        updateParticleItemTrigger(pTDetectInfo);
        BenchUtil.benchEnd(TAG + " updateParticleItemTrigger");
        BenchUtil.benchStart(TAG + " updateParticles");
        updateParticles(pTDetectInfo.facePoints, pTDetectInfo.handPoints, pTDetectInfo.timestamp);
        BenchUtil.benchEnd(TAG + " updateParticles");
        BenchUtil.benchStart(TAG + " particleSystem2D.advance");
        this.particleSystem2D.advance(this.particleItems, this.frameInterval);
        BenchUtil.benchEnd(TAG + " particleSystem2D.advance");
        BenchUtil.benchStart(TAG + " recycleUnusedWMGroups");
        recycleUnusedWMGroups();
        BenchUtil.benchEnd(TAG + " recycleUnusedWMGroups");
        BenchUtil.benchEnd(TAG + " updatePreview");
        AppMethodBeat.m2505o(83166);
    }

    private void recycleUnusedWMGroups() {
        AppMethodBeat.m2504i(83167);
        for (ParticleItem particleItem : this.particleItems) {
            if (particleItem.particles != null) {
                HashSet hashSet = new HashSet();
                for (Particle particle : particleItem.particles) {
                    if (particle.alive) {
                        hashSet.add(Integer.valueOf(particle.wmGroupId));
                    }
                }
                int i = 0;
                while (i < particleItem.stickerItem.wmGroupCopies.size()) {
                    if (!(hashSet.contains(Integer.valueOf(i)) || ((WMGroup) particleItem.stickerItem.wmGroupCopies.get(i)).isLock() || (i == particleItem.curWMGroupId && (i != particleItem.curWMGroupId || !particleItem.takenByParticle)))) {
                        particleItem.recycleWMGroup(i);
                    }
                    i++;
                }
            }
        }
        AppMethodBeat.m2505o(83167);
    }

    private void updateCurEmitterPos(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.m2504i(83168);
        for (ParticleItem particleItem : this.particleItems) {
            StickerItem stickerItem = particleItem.stickerItem;
            if (stickerItem != null) {
                switch (stickerItem.type) {
                    case 1:
                        int i;
                        if (((double) this.width) / ((double) this.height) < 0.75d) {
                            i = (int) (((double) this.height) * 0.75d);
                            int i2 = (int) (((double) this.height) * stickerItem.position[1]);
                            particleItem.emitterX = (float) (((int) (((double) i) * stickerItem.position[0])) - ((i - this.width) / 2));
                            particleItem.emitterY = (float) i2;
                            particleItem.screenRatioScale = (((float) this.height) * 1.0f) / 960.0f;
                            break;
                        }
                        i = (int) (((double) this.width) / 0.75d);
                        i = ((int) (((double) i) * stickerItem.position[1])) - ((i - this.height) / 2);
                        particleItem.emitterX = (float) ((int) (((double) this.width) * stickerItem.position[0]));
                        particleItem.emitterY = (float) i;
                        particleItem.screenRatioScale = (((float) this.width) * 1.0f) / 720.0f;
                        break;
                    case 2:
                    case 4:
                        List list3;
                        if (VideoMaterialUtil.isGestureItem(stickerItem)) {
                            list3 = list2;
                        } else {
                            List<PointF> list32 = list;
                        }
                        if (!(list32 == null || list32.isEmpty())) {
                            int i3;
                            PointF pointF = (PointF) list32.get(stickerItem.alignFacePoints[0]);
                            if (stickerItem.alignFacePoints.length == 1) {
                                i3 = stickerItem.alignFacePoints[0];
                            } else {
                                i3 = stickerItem.alignFacePoints[1];
                            }
                            PointF pointF2 = (PointF) list32.get(i3);
                            PointF pointF3 = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
                            pointF3.x /= this.faceDetScale;
                            pointF3.y /= this.faceDetScale;
                            particleItem.emitterX = pointF3.x;
                            particleItem.emitterY = pointF3.y;
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        AppMethodBeat.m2505o(83168);
    }

    private void updateParticleState(ParticleItem particleItem, int i, long j) {
        WMGroup availableWMGroup;
        AppMethodBeat.m2504i(83169);
        if (particleItem.particleReachMax && particleItem.clearMode == PARTICLE_CLEAR_MODE.CLEAR_ALL.value && particleItem.lastFrameParticleReachMax) {
            particleItem.canUpdateTexture = true;
        }
        if (particleItem.canUpdateTexture || (particleItem.clearMode == PARTICLE_CLEAR_MODE.CLEAR_ALL.value && particleItem.lastFrameParticleReachMax)) {
            if (particleItem.lockedWMGroups.isEmpty()) {
                availableWMGroup = particleItem.getAvailableWMGroup();
                if (availableWMGroup != null) {
                    if (availableWMGroup.updateTexture(j, true, false, true)) {
                        availableWMGroup.unlock();
                        particleItem.useWMGroup(availableWMGroup.f4886id);
                        particleItem.curTexture = availableWMGroup.getCurTexture();
                        particleItem.curWMGroupId = availableWMGroup.f4886id;
                        particleItem.curRepeatCount = 0;
                        particleItem.canUpdateTexture = false;
                        particleItem.takenByParticle = false;
                    } else if (availableWMGroup.isLock()) {
                        particleItem.useWMGroup(availableWMGroup.f4886id);
                        particleItem.lockedWMGroups.add(availableWMGroup);
                    } else {
                        particleItem.recycleWMGroup(availableWMGroup.f4886id);
                    }
                }
                if (particleItem.clearMode == PARTICLE_CLEAR_MODE.CLEAR_ALL.value && particleItem.lastFrameParticleReachMax && !particleItem.takenByParticle) {
                    this.particleSystem2D.clearParticles(i);
                    particleItem.resetWMGroup();
                    particleItem.useWMGroup(particleItem.curWMGroupId);
                    for (Particle particle : particleItem.particles) {
                        particle.alive = false;
                    }
                    this.particleSystem2D.advance(this.particleItems, this.frameInterval);
                    particleItem.lastFrameParticleReachMax = false;
                }
            } else {
                ArrayList arrayList = new ArrayList();
                for (WMGroup availableWMGroup2 : particleItem.lockedWMGroups) {
                    if (availableWMGroup2.isAsyncDrawFinished()) {
                        availableWMGroup2.updateTexture(j, true, false, true);
                        availableWMGroup2.unlock();
                        arrayList.add(availableWMGroup2);
                        particleItem.useWMGroup(availableWMGroup2.f4886id);
                        particleItem.curTexture = availableWMGroup2.getCurTexture();
                        particleItem.curWMGroupId = availableWMGroup2.f4886id;
                        particleItem.curRepeatCount = 0;
                        particleItem.canUpdateTexture = false;
                        particleItem.takenByParticle = false;
                        if (particleItem.clearMode == PARTICLE_CLEAR_MODE.CLEAR_ALL.value && particleItem.lastFrameParticleReachMax) {
                            this.particleSystem2D.clearParticles(i);
                            particleItem.resetWMGroup();
                            particleItem.useWMGroup(availableWMGroup2.f4886id);
                            for (Particle particle2 : particleItem.particles) {
                                particle2.alive = false;
                            }
                            this.particleSystem2D.advance(this.particleItems, this.frameInterval);
                            particleItem.lastFrameParticleReachMax = false;
                        }
                    }
                }
                particleItem.lockedWMGroups.removeAll(arrayList);
            }
        }
        if (particleItem.particleAlwaysUpdate) {
            for (WMGroup availableWMGroup22 : particleItem.getActiveWMGroups()) {
                if (availableWMGroup22.updateTexture(j, true, false, true)) {
                    availableWMGroup22.unlock();
                }
            }
        }
        for (WMGroup availableWMGroup222 : particleItem.getActiveWMGroups()) {
            availableWMGroup222.updateTexture(j, false, true, true);
        }
        AppMethodBeat.m2505o(83169);
    }

    private void buildRenderParams(ParticleItem particleItem) {
        AppMethodBeat.m2504i(83170);
        if (particleItem.particles != null) {
            for (Particle particle : particleItem.particles) {
                if (particle.texture > 0 && particle.alive) {
                    float f;
                    int i;
                    RenderParam renderParam = new RenderParam();
                    renderParam.texture = particle.texture;
                    float f2 = 0.0f;
                    switch (particleItem.emissionMode) {
                        case 0:
                            f2 = particle.startX + (particle.positionX * particleItem.screenRatioScale);
                            f = particle.startY + (particle.positionY * particleItem.screenRatioScale);
                            break;
                        case 1:
                            f2 = particleItem.emitterX + (particle.positionX * particleItem.screenRatioScale);
                            f = particleItem.emitterY + (particle.positionY * particleItem.screenRatioScale);
                            break;
                        case 2:
                            f2 = particle.positionX * particleItem.screenRatioScale;
                            f = particle.positionY * particleItem.screenRatioScale;
                            break;
                        default:
                            f = 0.0f;
                            break;
                    }
                    int i2 = 0;
                    if (particleItem.stickerItem.anchorPoint != null) {
                        i2 = particleItem.stickerItem.anchorPoint[0];
                        i = particleItem.stickerItem.anchorPoint[1];
                    } else {
                        i = 0;
                    }
                    float f3 = f2 - ((float) i2);
                    float f4 = f - ((float) i);
                    f2 = f3 + (((float) particleItem.stickerItem.width) * particleItem.screenRatioScale);
                    f = (((float) particleItem.stickerItem.height) * particleItem.screenRatioScale) + f4;
                    renderParam.texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
                    renderParam.texScale = particle.scale;
                    renderParam.texAnchor[0] = ((f3 + f2) / 2.0f) - ((float) (this.width / 2));
                    renderParam.texAnchor[1] = ((f + f4) / 2.0f) - ((float) (this.height / 2));
                    renderParam.texRotate[2] = particle.rotate;
                    renderParam.position = AlgoUtils.calPositionsTriangles(f3, f, f2, f4, this.width, this.height);
                    this.renderParams.add(renderParam);
                }
            }
        }
        AppMethodBeat.m2505o(83170);
    }

    private void updateParticleStateAndBuildRenderParams(long j) {
        AppMethodBeat.m2504i(83171);
        this.renderParams.clear();
        for (int i = 0; i < this.particleItems.length; i++) {
            ParticleItem particleItem = this.particleItems[i];
            if ((!this.isBackground || particleItem.stickerItem.zIndex < 0) && (this.isBackground || particleItem.stickerItem.zIndex >= 0)) {
                if (!particleItem.triggered || particleItem.stickerItem.wmGroupCopies == null) {
                    reset(i);
                } else {
                    updateParticleState(particleItem, i, j);
                    buildRenderParams(particleItem);
                }
                if (particleItem.clearMode == PARTICLE_CLEAR_MODE.CLEAR_ALL.value && !particleItem.lastFrameParticleReachMax) {
                    particleItem.lastFrameParticleReachMax = particleItem.particleReachMax;
                }
            }
        }
        AppMethodBeat.m2505o(83171);
    }

    private void updateParticles(List<PointF> list, List<PointF> list2, long j) {
        AppMethodBeat.m2504i(83172);
        if (this.particleItems != null) {
            updateCurEmitterPos(list, list2);
            updateParticleStateAndBuildRenderParams(j);
        }
        AppMethodBeat.m2505o(83172);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(83173);
        updateAndRender(null, System.currentTimeMillis(), this.isBackground);
        AppMethodBeat.m2505o(83173);
        return true;
    }

    public void updateAndRender(C41672h c41672h, long j, boolean z) {
        AppMethodBeat.m2504i(83174);
        if (!this.renderParams.isEmpty()) {
            BenchUtil.benchStart(TAG + " fastRenderFilter.render");
            this.fastRenderFilter.render(this.renderParams, c41672h, true);
            BenchUtil.benchEnd(TAG + " fastRenderFilter.render");
        }
        AppMethodBeat.m2505o(83174);
    }

    private void updateParticleItemTrigger(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(83175);
        if (this.particleItems != null) {
            for (ParticleItem particleItem : this.particleItems) {
                boolean z;
                TRIGGERED_STATUS triggeredStatus = particleItem.triggerCtrlItem.getTriggeredStatus(pTDetectInfo);
                if (triggeredStatus == TRIGGERED_STATUS.FIRST_TRIGGERED || triggeredStatus == TRIGGERED_STATUS.TRIGGERED) {
                    z = true;
                } else {
                    z = false;
                }
                particleItem.triggered = z;
            }
        }
        AppMethodBeat.m2505o(83175);
    }

    public void setTriggerWords(String str) {
        AppMethodBeat.m2504i(83176);
        if (this.particleItems != null) {
            for (ParticleItem particleItem : this.particleItems) {
                particleItem.triggerCtrlItem.setTriggerWords(TextUtils.isEmpty(particleItem.stickerItem.triggerWords) ? str : particleItem.stickerItem.triggerWords);
            }
        }
        AppMethodBeat.m2505o(83176);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.m2504i(83177);
        super.clearGLSLSelf();
        for (TextRenderItem clear : this.textRenderItems) {
            clear.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.stickerItems.size()) {
                StickerItem stickerItem = (StickerItem) this.stickerItems.get(i2);
                if (stickerItem.wmGroupCopies != null) {
                    for (WMGroup clear2 : stickerItem.wmGroupCopies) {
                        clear2.clear();
                    }
                }
                i = i2 + 1;
            } else {
                this.fastRenderFilter.clearGLSLSelf();
                this.particleSystem2D.release();
                LogicDataManager.getInstance().clearVoiceTexts();
                AppMethodBeat.m2505o(83177);
                return;
            }
        }
    }
}
