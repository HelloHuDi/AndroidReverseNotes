package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class SingleEyeStatusChecker implements FaceStatusChecker {
    private static SingleEyeStatusChecker instance = new SingleEyeStatusChecker();

    static {
        AppMethodBeat.m2504i(81907);
        AppMethodBeat.m2505o(81907);
    }

    public static SingleEyeStatusChecker getInstance() {
        return instance;
    }

    private SingleEyeStatusChecker() {
    }

    public boolean isInRange(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        if (faceRangeStatus == null || valueRange == null) {
            return false;
        }
        if ((((double) faceRangeStatus.leftEye) < valueRange.min || ((double) faceRangeStatus.leftEye) > valueRange.max) && (((double) faceRangeStatus.rightEye) < valueRange.min || ((double) faceRangeStatus.rightEye) > valueRange.max)) {
            return false;
        }
        return true;
    }

    public float getLevel(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        AppMethodBeat.m2504i(81906);
        float max = Math.max(faceRangeStatus.leftEye, faceRangeStatus.rightEye);
        AppMethodBeat.m2505o(81906);
        return max;
    }
}
