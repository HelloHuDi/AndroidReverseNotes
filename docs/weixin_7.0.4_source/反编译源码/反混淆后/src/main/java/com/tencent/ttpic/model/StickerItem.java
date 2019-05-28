package com.tencent.ttpic.model;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.particle.ParticleConfig;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StickerItem {
    public int activateTriggerCount;
    public int activateTriggerTotalCount;
    public int activateTriggerType;
    public AgeRange ageRange;
    public int[] alignFacePoints;
    public boolean alwaysTriggered;
    public int[] anchorPoint;
    public double[] anchorPointAudio;
    public float angle = 0.0f;
    public int aspectMode = 0;
    public String audio;
    public int audioLoopCount;
    public boolean audioNeedAdjust;
    public List<Pair<Float, Double>> audioScaleFactorMap = new ArrayList();
    public int audioTriggerType;
    public ValueRange audioValueRange;
    public int blendMode;
    public int bodyTriggerDirection;
    public int bodyTriggerDistance;
    public int bodyTriggerPoint;
    public double bodyTriggerTimeGap;
    public CharmRange charmRange;
    public int countTriggerType;
    public CpRange cpRange;
    public List<Pair<Float, Double>> degreeMap = new ArrayList();
    /* renamed from: dx */
    public int f18269dx = 0;
    /* renamed from: dy */
    public int f18270dy = 0;
    public int fabbyPart = 0;
    public int fabbyTotalParts = 1;
    public int featureStatType;
    public ValueRange featureStatValueRange;
    public double frameDuration;
    public int frameType;
    public int frames;
    public GenderRange genderRange;
    public int height;
    /* renamed from: id */
    public String f18271id;
    public boolean isFabbyMvItem = false;
    public int markMode;
    public String name;
    public int originalScaleFactor;
    public ParticleConfig particleConfig;
    public int personID = -1;
    public int playCount;
    public PopularRange popularRange;
    public double[] position;
    public int preTriggerType;
    public int randomGroupNum;
    public float scale = 1.0f;
    public int scaleDirection;
    public int scaleFactor;
    public int[] scalePivots;
    public ITEM_SOURCE_TYPE sourceType;
    public int stickerType;
    public String subFolder;
    public int support3D;
    public Transition transition;
    public List<Pair<Float, Double>> translateXMap = new ArrayList();
    public List<Pair<Float, Double>> translateYMap = new ArrayList();
    public int triggerType;
    public String triggerWords;
    public int type;
    public int width;
    public WMGroup wmGroup;
    public List<WMGroup> wmGroupCopies;
    public int zIndex;

    public static class ValueRange {
        public double max;
        public double min;
    }

    public StickerItem() {
        AppMethodBeat.m2504i(83527);
        AppMethodBeat.m2505o(83527);
    }

    public String toString() {
        AppMethodBeat.m2504i(83528);
        String str = "StickerItem{id='" + this.f18271id + '\'' + ", name='" + this.name + '\'' + ", type=" + this.type + ", triggerType=" + this.triggerType + ", alwaysTriggered=" + this.alwaysTriggered + ", playCount=" + this.playCount + ", frameDuration=" + this.frameDuration + ", frames=" + this.frames + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ", audio='" + this.audio + '\'' + ", anchorPoint=" + Arrays.toString(this.anchorPoint) + ", alignFacePoints=" + Arrays.toString(this.alignFacePoints) + ", scalePivots=" + Arrays.toString(this.scalePivots) + ", scaleFactor=" + this.scaleFactor + ", support3D=" + this.support3D + '}';
        AppMethodBeat.m2505o(83528);
        return str;
    }

    public boolean isDBTriggered() {
        return this.audioTriggerType == 1 || this.audioTriggerType == 2;
    }
}
