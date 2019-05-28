package com.tencent.ttpic.model;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.e;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.model.StickerItem.ValueRange;
import java.util.List;
import java.util.regex.Pattern;

public class TriggerConfig {
    public final int BODY_TRIGGER_ANGLE_TOLERANCE;
    public int activateTriggerCount;
    public int activateTriggerTotalCount;
    public boolean alwaysTriggered;
    public boolean audioNeedAdjust;
    public List<Pair<Float, Double>> audioScaleFactorMap;
    public int audioTriggerType;
    public ValueRange audioValueRange;
    public int bodyTriggerDirection;
    public int bodyTriggerDistance;
    public int bodyTriggerPoint;
    public double bodyTriggerTimeGap;
    public int countTriggerType;
    public int playCount;
    public int preTriggerType;
    public int randomGroupNum;
    public boolean renderForBitmap;
    private StickerItem stickerItem;
    public int triggerType;
    private Pattern triggerWordsPattern;

    public TriggerConfig() {
        this.BODY_TRIGGER_ANGLE_TOLERANCE = 15;
        this.triggerType = PTExpression.FACE_DETECT.value;
    }

    public TriggerConfig(StickerItem stickerItem) {
        this.BODY_TRIGGER_ANGLE_TOLERANCE = 15;
        this.preTriggerType = stickerItem.preTriggerType;
        this.countTriggerType = stickerItem.countTriggerType;
        this.activateTriggerCount = stickerItem.activateTriggerCount;
        this.activateTriggerTotalCount = stickerItem.activateTriggerTotalCount;
        this.randomGroupNum = stickerItem.randomGroupNum;
        this.alwaysTriggered = stickerItem.alwaysTriggered;
        this.triggerType = stickerItem.triggerType;
        this.audioTriggerType = stickerItem.audioTriggerType;
        this.audioNeedAdjust = stickerItem.audioNeedAdjust;
        this.audioValueRange = stickerItem.audioValueRange;
        this.audioScaleFactorMap = stickerItem.audioScaleFactorMap;
        this.playCount = stickerItem.playCount;
        this.bodyTriggerPoint = stickerItem.bodyTriggerPoint;
        this.bodyTriggerDirection = stickerItem.bodyTriggerDirection;
        this.bodyTriggerDistance = stickerItem.bodyTriggerDistance;
        this.bodyTriggerTimeGap = stickerItem.bodyTriggerTimeGap;
        this.stickerItem = stickerItem;
    }

    public TriggerConfig(FaceItem faceItem) {
        this.BODY_TRIGGER_ANGLE_TOLERANCE = 15;
        this.preTriggerType = faceItem.preTriggerType;
        this.countTriggerType = faceItem.countTriggerType;
        this.activateTriggerCount = faceItem.activateTriggerCount;
        this.activateTriggerTotalCount = faceItem.activateTriggerTotalCount;
        this.randomGroupNum = faceItem.randomGroupNum;
        this.alwaysTriggered = faceItem.alwaysTriggered;
        this.triggerType = faceItem.triggerType;
        this.playCount = faceItem.playCount;
    }

    public TriggerConfig(FaceMeshItem faceMeshItem) {
        this.BODY_TRIGGER_ANGLE_TOLERANCE = 15;
        this.alwaysTriggered = faceMeshItem.alwaysTriggered;
        this.triggerType = faceMeshItem.triggerType;
        this.playCount = faceMeshItem.playCount;
    }

    public void setRenderForBitmap(boolean z) {
        this.renderForBitmap = z;
    }

    public boolean isRenderForBitmap() {
        return this.renderForBitmap;
    }

    public void setTriggerWords(String str) {
        AppMethodBeat.i(83553);
        if (str == null) {
            AppMethodBeat.o(83553);
            return;
        }
        this.triggerWordsPattern = Pattern.compile(str);
        AppMethodBeat.o(83553);
    }

    public boolean isSentenceTriggered(String str) {
        AppMethodBeat.i(83554);
        if (this.triggerWordsPattern == null) {
            AppMethodBeat.o(83554);
            return false;
        }
        boolean find = this.triggerWordsPattern.matcher(str).find();
        AppMethodBeat.o(83554);
        return find;
    }

    public int getBodyTriggerAngle() {
        switch (this.bodyTriggerDirection) {
            case 1:
                return 45;
            case 2:
                return 90;
            case 3:
                return b.CTRL_INDEX;
            case 4:
                return 180;
            case 5:
                return 225;
            case 6:
                return 270;
            case 7:
                return e.CTRL_INDEX;
            default:
                return 0;
        }
    }

    public boolean isDBTriggered() {
        AppMethodBeat.i(83555);
        if (this.stickerItem == null || !this.stickerItem.isDBTriggered()) {
            AppMethodBeat.o(83555);
            return false;
        }
        AppMethodBeat.o(83555);
        return true;
    }
}
