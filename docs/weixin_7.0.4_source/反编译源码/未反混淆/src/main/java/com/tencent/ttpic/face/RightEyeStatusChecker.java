package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class RightEyeStatusChecker implements FaceStatusChecker {
    private static RightEyeStatusChecker instance = new RightEyeStatusChecker();

    static {
        AppMethodBeat.i(81905);
        AppMethodBeat.o(81905);
    }

    public static RightEyeStatusChecker getInstance() {
        return instance;
    }

    private RightEyeStatusChecker() {
    }

    public boolean isInRange(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        if (faceRangeStatus == null || valueRange == null || ((double) faceRangeStatus.rightEye) < valueRange.min || ((double) faceRangeStatus.rightEye) > valueRange.max) {
            return false;
        }
        return true;
    }

    public float getLevel(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        return faceRangeStatus.rightEye;
    }
}
