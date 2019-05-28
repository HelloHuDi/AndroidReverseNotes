package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class LeftEyeStatusChecker implements FaceStatusChecker {
    private static LeftEyeStatusChecker instance = new LeftEyeStatusChecker();

    static {
        AppMethodBeat.i(81893);
        AppMethodBeat.o(81893);
    }

    public static LeftEyeStatusChecker getInstance() {
        return instance;
    }

    private LeftEyeStatusChecker() {
    }

    public boolean isInRange(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        if (faceRangeStatus == null || valueRange == null || ((double) faceRangeStatus.leftEye) < valueRange.min || ((double) faceRangeStatus.leftEye) > valueRange.max) {
            return false;
        }
        return true;
    }

    public float getLevel(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        return faceRangeStatus.leftEye;
    }
}
