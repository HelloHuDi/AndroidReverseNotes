package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.model.StickerItem.ValueRange;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class FaceItem {
    public int activateTriggerCount;
    public int activateTriggerTotalCount;
    public int activateTriggerType;
    public boolean alwaysTriggered = true;
    public float blendAlpha;
    public int blendMode;
    public CharmRange charmRange;
    public int countTriggerType;
    public String faceExchangeImage;
    public List<Float> facePoints;
    public int featureStatType;
    public ValueRange featureStatValueRange;
    public FEATURE_TYPE featureType;
    public int frameDuration;
    public int frameType;
    public int frames;
    public int grayScale;
    public int height;
    public String id;
    public String irisImage;
    public int personID;
    public int playCount;
    public int preTriggerType;
    public int randomGroupNum;
    public int triggerType = PTExpression.FACE_DETECT.value;
    public int width;

    public FaceItem(String str, float f, int i, int i2, List<Float> list) {
        AppMethodBeat.i(83487);
        this.faceExchangeImage = str;
        this.blendAlpha = f;
        this.grayScale = i;
        this.featureType = FaceOffUtil.getFeatureType(i2);
        this.facePoints = list;
        this.personID = -1;
        AppMethodBeat.o(83487);
    }
}
