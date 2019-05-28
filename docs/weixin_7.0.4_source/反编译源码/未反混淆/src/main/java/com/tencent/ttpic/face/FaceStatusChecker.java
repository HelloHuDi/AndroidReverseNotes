package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.ValueRange;

public interface FaceStatusChecker {
    float getLevel(FaceRangeStatus faceRangeStatus, ValueRange valueRange);

    boolean isInRange(FaceRangeStatus faceRangeStatus, ValueRange valueRange);
}
