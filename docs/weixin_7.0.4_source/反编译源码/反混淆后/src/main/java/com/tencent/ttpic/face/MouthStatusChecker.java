package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class MouthStatusChecker implements FaceStatusChecker {
    private static MouthStatusChecker instance = new MouthStatusChecker();

    static {
        AppMethodBeat.m2504i(81899);
        AppMethodBeat.m2505o(81899);
    }

    public static MouthStatusChecker getInstance() {
        return instance;
    }

    private MouthStatusChecker() {
    }

    public boolean isInRange(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        if (faceRangeStatus == null || valueRange == null || ((double) faceRangeStatus.mouth) < valueRange.min || ((double) faceRangeStatus.mouth) > valueRange.max) {
            return false;
        }
        return true;
    }

    public float getLevel(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        return faceRangeStatus.mouth;
    }
}
