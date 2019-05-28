package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class EyesStatusChecker implements FaceStatusChecker {
    private static EyesStatusChecker instance = new EyesStatusChecker();

    static {
        AppMethodBeat.m2504i(81887);
        AppMethodBeat.m2505o(81887);
    }

    public static EyesStatusChecker getInstance() {
        return instance;
    }

    private EyesStatusChecker() {
    }

    public boolean isInRange(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        if (faceRangeStatus == null || valueRange == null || ((double) faceRangeStatus.leftEye) < valueRange.min || ((double) faceRangeStatus.leftEye) > valueRange.max || ((double) faceRangeStatus.rightEye) < valueRange.min || ((double) faceRangeStatus.rightEye) > valueRange.max) {
            return false;
        }
        return true;
    }

    public float getLevel(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        return (faceRangeStatus.leftEye + faceRangeStatus.rightEye) / 2.0f;
    }
}
