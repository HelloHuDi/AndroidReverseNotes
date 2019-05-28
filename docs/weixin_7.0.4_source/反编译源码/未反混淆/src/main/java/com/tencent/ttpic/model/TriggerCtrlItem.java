package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TriggerCtrlItem {
    private static final double MAX_AUDIO_FACTOR = 0.6d;
    private static final double MIN_AUDIO_FACTOR = 0.08d;
    private AgeRange ageRange;
    private double audioScaleFactor;
    private List<PointF> bodyPositionRecord;
    private int bodyPositionRecordMinNum;
    private CharmRange charmRange;
    private TriggerConfig config;
    private CpRange cpRange;
    private double frameDuration;
    private int frameIndex;
    private long frameStartTime;
    private int frames;
    private GenderRange genderRange;
    private int mRandomGroupValue;
    private int playCount;
    private PopularRange popularRange;
    private TRIGGERED_STATUS status;

    public TriggerCtrlItem() {
        AppMethodBeat.i(83556);
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        this.audioScaleFactor = 1.0d;
        this.bodyPositionRecordMinNum = 2;
        this.config = new TriggerConfig();
        this.bodyPositionRecord = new ArrayList();
        AppMethodBeat.o(83556);
    }

    public TriggerCtrlItem(StickerItem stickerItem) {
        int i = 2;
        AppMethodBeat.i(83557);
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        this.audioScaleFactor = 1.0d;
        this.bodyPositionRecordMinNum = 2;
        this.config = new TriggerConfig(stickerItem);
        this.charmRange = stickerItem.charmRange;
        this.ageRange = stickerItem.ageRange;
        this.genderRange = stickerItem.genderRange;
        this.popularRange = stickerItem.popularRange;
        this.cpRange = stickerItem.cpRange;
        this.frames = stickerItem.frames;
        this.frameDuration = stickerItem.frameDuration;
        this.bodyPositionRecord = new ArrayList();
        if (Math.ceil((this.config.bodyTriggerTimeGap * 1000.0d) / this.frameDuration) >= 1.0d) {
            i = ((int) Math.ceil((this.config.bodyTriggerTimeGap * 1000.0d) / this.frameDuration)) + 1;
        }
        this.bodyPositionRecordMinNum = i;
        AppMethodBeat.o(83557);
    }

    public TriggerCtrlItem(FaceItem faceItem) {
        AppMethodBeat.i(83558);
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        this.audioScaleFactor = 1.0d;
        this.bodyPositionRecordMinNum = 2;
        this.config = new TriggerConfig(faceItem);
        this.charmRange = faceItem.charmRange;
        this.frames = faceItem.frames;
        this.frameDuration = (double) faceItem.frameDuration;
        AppMethodBeat.o(83558);
    }

    public TriggerCtrlItem(FaceMeshItem faceMeshItem) {
        AppMethodBeat.i(83559);
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        this.audioScaleFactor = 1.0d;
        this.bodyPositionRecordMinNum = 2;
        this.config = new TriggerConfig(faceMeshItem);
        this.charmRange = faceMeshItem.charmRange;
        this.frames = faceMeshItem.frames;
        this.frameDuration = faceMeshItem.frameDuration;
        AppMethodBeat.o(83559);
    }

    public TRIGGERED_STATUS getTriggeredStatus(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(83560);
        updateFrameIndex(pTDetectInfo.timestamp);
        updateTriggeredStatus(pTDetectInfo);
        TRIGGERED_STATUS triggered_status = this.status;
        AppMethodBeat.o(83560);
        return triggered_status;
    }

    private void updateTriggeredStatus(PTDetectInfo pTDetectInfo) {
        int i = 1;
        AppMethodBeat.i(83561);
        int i2 = (isNormalTriggered(pTDetectInfo) && isRangeValueHit() && isRandomGroupValueHit() && isAudioTriggered()) ? 1 : 0;
        if (i2 == 0 && !this.config.renderForBitmap) {
            i = 0;
        }
        if (i != 0) {
            if (this.status == TRIGGERED_STATUS.NOT_TRIGGERED) {
                this.frameStartTime = pTDetectInfo.timestamp;
                this.status = TRIGGERED_STATUS.FIRST_TRIGGERED;
            } else {
                this.status = TRIGGERED_STATUS.TRIGGERED;
            }
        } else if (this.config.alwaysTriggered || this.playCount >= this.config.playCount) {
            this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        }
        if (!isTriggered()) {
            this.playCount = 0;
        }
        AppMethodBeat.o(83561);
    }

    private boolean isNormalTriggered(PTDetectInfo pTDetectInfo) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(83562);
        Set set = pTDetectInfo.triggeredExpression;
        Map map = pTDetectInfo.faceActionCounter;
        Map map2 = pTDetectInfo.handActionCounter;
        List list = pTDetectInfo.bodyPoints;
        if (this.config.activateTriggerTotalCount != 0) {
            Map map3;
            if (this.config.preTriggerType != PTExpression.ALWAYS.value) {
                if (VideoMaterialUtil.isFaceTriggerType(this.config.preTriggerType)) {
                }
            }
            boolean isFaceTriggerType = VideoMaterialUtil.isFaceTriggerType(this.config.countTriggerType);
            if (isFaceTriggerType) {
                map3 = map;
            } else {
                map3 = map2;
            }
            if (map3 != null) {
                if ((isFaceTriggerType ? map : map2).size() != 0) {
                    if ((isFaceTriggerType ? ((FaceActionCounter) map.get(Integer.valueOf(this.config.countTriggerType))).count : ((HandActionCounter) map2.get(Integer.valueOf(this.config.countTriggerType))).count) % this.config.activateTriggerTotalCount == this.config.activateTriggerCount) {
                        boolean z3;
                        if (this.config.playCount == 0 || this.playCount < this.config.playCount) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (this.playCount >= this.config.playCount) {
                            if (this.config.playCount > 0) {
                                if (isFaceTriggerType) {
                                    pTDetectInfo.faceDetector.clearActionCounter();
                                    z2 = z3;
                                } else {
                                    GestureDetector.getInstance().clearActionCounter();
                                }
                            }
                            z2 = z3;
                        } else if (isFaceTriggerType) {
                            pTDetectInfo.faceDetector.lockActionCounter();
                            z2 = z3;
                        } else {
                            GestureDetector.getInstance().lockActionCounter();
                            z2 = z3;
                        }
                    }
                }
            }
        } else if (VideoMaterialUtil.isFaceTriggerType(this.config.triggerType)) {
            if (set != null) {
                z2 = set.contains(Integer.valueOf(this.config.triggerType));
            }
        } else if (VideoMaterialUtil.isGestureTriggerType(this.config.triggerType)) {
            z2 = GestureDetector.getInstance().isGestureTriggered(this.config.triggerType);
        } else if (!VideoMaterialUtil.isAudioTextTriggerType(this.config.triggerType)) {
            if (VideoMaterialUtil.isBodyDetectType(this.config.triggerType)) {
                if (list == null || list.isEmpty()) {
                    z = false;
                }
                z2 = z;
            } else if (!(!VideoMaterialUtil.isBodyTriggerType(this.config.triggerType) || list == null || list.isEmpty())) {
                if (this.bodyPositionRecord.size() == this.bodyPositionRecordMinNum) {
                    this.bodyPositionRecord.remove(0);
                }
                this.bodyPositionRecord.add(list.get(this.config.bodyTriggerPoint));
                if (this.bodyPositionRecord.size() > 1) {
                    PointF pointF = (PointF) list.get(this.config.bodyTriggerPoint);
                    PointF pointF2 = (PointF) this.bodyPositionRecord.get(0);
                    int calPointsDistance = calPointsDistance(pointF2, pointF);
                    int calPointsAngle = calPointsAngle(pointF2, pointF);
                    if (calPointsDistance >= this.config.bodyTriggerDistance) {
                        calPointsAngle = Math.abs(calPointsAngle - this.config.getBodyTriggerAngle());
                        this.config.getClass();
                        if (calPointsAngle <= 15) {
                            z2 = true;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(83562);
        return z2;
    }

    private boolean isAudioTriggered() {
        if (this.config.audioTriggerType == 0) {
        }
        return true;
    }

    private boolean isInRange(double d, double d2, double d3) {
        return d >= d2 && d <= d3;
    }

    public void updateFrameIndex(long j) {
        AppMethodBeat.i(83563);
        if (!isTriggered()) {
            this.frameStartTime = j;
        }
        this.frameIndex = (int) (((double) (j - this.frameStartTime)) / Math.max(this.frameDuration, 1.0d));
        if (this.frameIndex >= this.frames * (this.playCount + 1)) {
            this.playCount++;
        }
        this.frameIndex %= Math.max(this.frames, 1);
        AppMethodBeat.o(83563);
    }

    public int getFrameIndex() {
        return this.frameIndex;
    }

    public boolean isTriggered() {
        return this.status == TRIGGERED_STATUS.FIRST_TRIGGERED || this.status == TRIGGERED_STATUS.TRIGGERED;
    }

    private boolean isRangeValueHit() {
        AppMethodBeat.i(83564);
        if ((this.charmRange == null || this.charmRange.isHit()) && ((this.ageRange == null || this.ageRange.isHit()) && ((this.genderRange == null || this.genderRange.isHit()) && ((this.popularRange == null || this.popularRange.isHit()) && (this.cpRange == null || this.cpRange.isHit()))))) {
            AppMethodBeat.o(83564);
            return true;
        }
        AppMethodBeat.o(83564);
        return false;
    }

    private boolean isRandomGroupValueHit() {
        if (this.config.randomGroupNum == 0 || this.mRandomGroupValue == this.config.randomGroupNum) {
            return true;
        }
        return false;
    }

    public void setFrameStartTime(long j) {
        this.frameStartTime = j;
    }

    public long getFrameStartTime() {
        return this.frameStartTime;
    }

    public void setRandomGroupValue(int i) {
        this.mRandomGroupValue = i;
    }

    public void setRenderForBitmap(boolean z) {
        AppMethodBeat.i(83565);
        this.config.setRenderForBitmap(z);
        AppMethodBeat.o(83565);
    }

    public boolean isRenderForBitmap() {
        AppMethodBeat.i(83566);
        boolean isRenderForBitmap = this.config.isRenderForBitmap();
        AppMethodBeat.o(83566);
        return isRenderForBitmap;
    }

    public void setPlayCount(int i) {
        this.playCount = i;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public void setTriggerWords(String str) {
        AppMethodBeat.i(83567);
        this.config.setTriggerWords(str);
        AppMethodBeat.o(83567);
    }

    public void reset() {
        AppMethodBeat.i(83568);
        this.playCount = 0;
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        if (this.bodyPositionRecord != null) {
            this.bodyPositionRecord.clear();
        }
        AppMethodBeat.o(83568);
    }

    private double getAudioScale(int i) {
        AppMethodBeat.i(83569);
        double rangeValue = FabbyUtil.getRangeValue(0, (float) i, this.config.audioScaleFactorMap, 1.0d);
        AppMethodBeat.o(83569);
        return rangeValue;
    }

    private double getAudioValidScale(double d) {
        if (d < MIN_AUDIO_FACTOR) {
            return d + MIN_AUDIO_FACTOR;
        }
        return d > MAX_AUDIO_FACTOR ? MAX_AUDIO_FACTOR : d;
    }

    public double getAudioScaleFactor() {
        return this.audioScaleFactor;
    }

    private int calPointsDistance(PointF pointF, PointF pointF2) {
        AppMethodBeat.i(83570);
        int sqrt = (int) Math.sqrt(Math.pow((double) (pointF2.x - pointF.x), 2.0d) + Math.pow((double) (pointF2.y - pointF.y), 2.0d));
        AppMethodBeat.o(83570);
        return sqrt;
    }

    private int calPointsAngle(PointF pointF, PointF pointF2) {
        AppMethodBeat.i(83571);
        float toDegrees = (float) Math.toDegrees(Math.atan2((double) (pointF2.y - pointF.y), (double) (pointF2.x - pointF.x)));
        if (toDegrees < 0.0f) {
            toDegrees += 360.0f;
        }
        int i = (int) toDegrees;
        AppMethodBeat.o(83571);
        return i;
    }
}
