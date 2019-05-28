package com.tencent.ttpic.filter;

import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FabbyFilters {
    private final String audioFile;
    private final String dataPath;
    private List<FabbyMvFilter> fabbyMvFilters = new ArrayList();
    private boolean mAudioPause;
    private List<Long> mBaseOffsetTimeList = new ArrayList();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private int mLastRenderPartIndex;
    private long mLastTriggerTime;
    private int mMvPartIndex;
    private long mOffsetTimeFromTrigger;
    private Player mPlayer;
    private long mStartTime;
    private long mTransitionDeadLine;
    private C41672h mTransitionFrame = new C41672h();
    private TransitionFilter transitionFilter = new TransitionFilter();

    public FabbyFilters(List<FabbyMvFilter> list, String str, String str2) {
        AppMethodBeat.m2504i(82250);
        this.fabbyMvFilters = list;
        this.dataPath = str;
        this.audioFile = str2;
        initBaseOffsetTime();
        AppMethodBeat.m2505o(82250);
    }

    private void initBaseOffsetTime() {
        AppMethodBeat.m2504i(82251);
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fabbyMvFilters.size()) {
                j += ((FabbyMvFilter) this.fabbyMvFilters.get(i2)).mvPart.duration;
                this.mBaseOffsetTimeList.add(Long.valueOf(j));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(82251);
                return;
            }
        }
    }

    private void updateTransitionParam(long j) {
        AppMethodBeat.m2504i(82252);
        FabbyMvFilter fabbyMvFilter = (FabbyMvFilter) this.fabbyMvFilters.get(this.mLastRenderPartIndex);
        if (fabbyMvFilter == null || fabbyMvFilter.mvPart == null || fabbyMvFilter.getLastRenderFrame() == null) {
            this.mTransitionDeadLine = 0;
            AppMethodBeat.m2505o(82252);
            return;
        }
        BenchUtil.benchStart("[showPreview][FABBY] setTransitionParam");
        this.transitionFilter.setMvPart(((FabbyMvFilter) this.fabbyMvFilters.get(this.mLastRenderPartIndex)).mvPart);
        this.transitionFilter.setLastTex(((FabbyMvFilter) this.fabbyMvFilters.get(this.mLastRenderPartIndex)).getLastRenderFrame().texture[0]);
        BenchUtil.benchEnd("[showPreview][FABBY] setTransitionParam");
        this.mTransitionDeadLine = j;
        AppMethodBeat.m2505o(82252);
    }

    private boolean isCurrentPartActionTrigger() {
        AppMethodBeat.m2504i(82253);
        FabbyMvFilter fabbyMvFilter = (FabbyMvFilter) this.fabbyMvFilters.get(this.mMvPartIndex);
        if (fabbyMvFilter.mvPart.transitionItem == null || fabbyMvFilter.mvPart.transitionItem.triggerType <= 1) {
            AppMethodBeat.m2505o(82253);
            return false;
        }
        AppMethodBeat.m2505o(82253);
        return true;
    }

    /* JADX WARNING: Missing block: B:7:0x0036, code skipped:
            if ((r12 - r10.mLastTriggerTime) > 1000) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateCurrentPartIndex(Set<Integer> set, long j) {
        Object obj = 1;
        Object obj2 = null;
        AppMethodBeat.m2504i(82254);
        int i;
        if (isCurrentPartActionTrigger()) {
            FabbyMvFilter fabbyMvFilter = (FabbyMvFilter) this.fabbyMvFilters.get(this.mMvPartIndex);
            i = fabbyMvFilter.mvPart.transitionItem.triggerType;
            if (VideoMaterialUtil.isFaceTriggerType(i) ? set.contains(Integer.valueOf(i)) : GestureDetector.getInstance().isGestureTriggered(i)) {
            }
            obj = null;
            if (obj != null) {
                this.mLastTriggerTime = j;
                this.mOffsetTimeFromTrigger = j - (((Long) this.mBaseOffsetTimeList.get(this.mMvPartIndex)).longValue() + this.mStartTime);
                updateTransitionParam(fabbyMvFilter.mvPart.transitionDuration + j);
                this.mMvPartIndex = (this.mMvPartIndex + 1) % this.fabbyMvFilters.size();
                if (this.mMvPartIndex == 0) {
                    reset(j);
                }
            }
        } else {
            long j2 = (j - this.mStartTime) - this.mOffsetTimeFromTrigger;
            for (i = 0; i < this.fabbyMvFilters.size(); i++) {
                if (((Long) this.mBaseOffsetTimeList.get(i)).longValue() >= j2) {
                    this.mMvPartIndex = i;
                    break;
                }
            }
            int obj22 = 1;
            if (obj22 != null) {
                reset(j);
            } else if (this.mMvPartIndex != this.mLastRenderPartIndex) {
                updateTransitionParam((((FabbyMvFilter) this.fabbyMvFilters.get(this.mLastRenderPartIndex)).mvPart.transitionDuration + (this.mStartTime + ((Long) this.mBaseOffsetTimeList.get(this.mLastRenderPartIndex)).longValue())) + this.mOffsetTimeFromTrigger);
            }
        }
        this.mLastRenderPartIndex = this.mMvPartIndex;
        AppMethodBeat.m2505o(82254);
    }

    public C41672h updateAndRender(C41672h c41672h, Map<Integer, C41672h> map, Map<Integer, FaceActionCounter> map2, Set<Integer> set, long j) {
        AppMethodBeat.m2504i(82255);
        FabbyMvFilter fabbyMvFilter = (FabbyMvFilter) this.fabbyMvFilters.get(this.mMvPartIndex);
        if (VideoPrefsUtil.getMaterialMute() || this.mAudioPause) {
            destroyAudio();
        } else if (this.mPlayer == null) {
            createAudioPlayer();
            PlayerUtil.seekPlayer(this.mPlayer, (int) ((j - this.mStartTime) % 16843160));
        }
        C41672h updateAndRender = fabbyMvFilter.updateAndRender(c41672h, map, j);
        if (j > this.mTransitionDeadLine || !this.transitionFilter.needRender()) {
            this.transitionFilter.reset();
            this.mTransitionDeadLine = 0;
        } else {
            BenchUtil.benchStart("[showPreview][FABBY] transition");
            this.transitionFilter.updatePreview(j);
            this.transitionFilter.RenderProcess(updateAndRender.texture[0], updateAndRender.width, updateAndRender.height, -1, 0.0d, this.mTransitionFrame);
            updateAndRender = this.mTransitionFrame;
            BenchUtil.benchEnd("[showPreview][FABBY] transition");
        }
        AppMethodBeat.m2505o(82255);
        return updateAndRender;
    }

    private void reset(long j) {
        AppMethodBeat.m2504i(82256);
        this.mStartTime = j;
        this.mMvPartIndex = 0;
        this.mLastRenderPartIndex = 0;
        this.mOffsetTimeFromTrigger = 0;
        createAudioPlayer();
        PlayerUtil.startPlayer(this.mPlayer, true);
        for (FabbyMvFilter reset : this.fabbyMvFilters) {
            reset.reset();
        }
        AppMethodBeat.m2505o(82256);
    }

    public void reset() {
        this.mStartTime = 0;
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(82257);
        for (FabbyMvFilter updateVideoSize : this.fabbyMvFilters) {
            updateVideoSize.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.m2505o(82257);
    }

    public void clear() {
        AppMethodBeat.m2504i(82258);
        for (FabbyMvFilter clear : this.fabbyMvFilters) {
            clear.clear();
        }
        this.mTransitionFrame.clear();
        this.transitionFilter.ClearGLSL();
        this.mCopyFilter.clearGLSLSelf();
        AppMethodBeat.m2505o(82258);
    }

    public void destroyAudio() {
        AppMethodBeat.m2504i(82259);
        PlayerUtil.destroyPlayer(this.mPlayer);
        this.mPlayer = null;
        AppMethodBeat.m2505o(82259);
    }

    public void ApplyGLSLFilter(String str) {
        AppMethodBeat.m2504i(82260);
        for (FabbyMvFilter ApplyGLSLFilter : this.fabbyMvFilters) {
            ApplyGLSLFilter.ApplyGLSLFilter();
        }
        this.transitionFilter.ApplyGLSLFilter(str);
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(82260);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82261);
        for (FabbyMvFilter renderMode : this.fabbyMvFilters) {
            renderMode.setRenderMode(i);
        }
        this.transitionFilter.setRenderMode(i);
        AppMethodBeat.m2505o(82261);
    }

    private void createAudioPlayer() {
        AppMethodBeat.m2504i(82262);
        if (!(TextUtils.isEmpty(this.audioFile) || this.mPlayer != null || VideoPrefsUtil.getMaterialMute())) {
            this.mPlayer = PlayerUtil.createPlayer(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.audioFile, true);
        }
        AppMethodBeat.m2505o(82262);
    }

    public void updateTextureParam(Map<Integer, FaceActionCounter> map, Set<Integer> set, long j) {
        AppMethodBeat.m2504i(82263);
        if (this.mStartTime <= 0) {
            reset(j);
        }
        updateCurrentPartIndex(set, j);
        ((FabbyMvFilter) this.fabbyMvFilters.get(this.mMvPartIndex)).updateTextureParam(j);
        FaceActionCounter faceActionCounter = (FaceActionCounter) map.get(Integer.valueOf(PTExpression.MV_PART_INDEX.value));
        if (faceActionCounter == null) {
            FabbyFaceActionCounter fabbyFaceActionCounter = new FabbyFaceActionCounter(this.mMvPartIndex, j);
            fabbyFaceActionCounter.scaleMap = ((FabbyMvFilter) this.fabbyMvFilters.get(this.mMvPartIndex)).getGridScaleMap();
            map.put(Integer.valueOf(PTExpression.MV_PART_INDEX.value), fabbyFaceActionCounter);
            AppMethodBeat.m2505o(82263);
            return;
        }
        if (faceActionCounter instanceof FabbyFaceActionCounter) {
            FabbyFaceActionCounter fabbyFaceActionCounter2 = (FabbyFaceActionCounter) faceActionCounter;
            fabbyFaceActionCounter2.count = this.mMvPartIndex;
            fabbyFaceActionCounter2.updateTime = j;
            fabbyFaceActionCounter2.scaleMap = ((FabbyMvFilter) this.fabbyMvFilters.get(this.mMvPartIndex)).getGridScaleMap();
        }
        AppMethodBeat.m2505o(82263);
    }

    public void setAudioPause(boolean z) {
        this.mAudioPause = z;
    }
}
