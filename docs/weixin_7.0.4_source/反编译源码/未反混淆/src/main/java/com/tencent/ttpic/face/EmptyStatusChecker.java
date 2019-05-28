package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class EmptyStatusChecker implements FaceStatusChecker {
    private static EmptyStatusChecker instance = new EmptyStatusChecker();

    static {
        AppMethodBeat.i(81886);
        AppMethodBeat.o(81886);
    }

    public static EmptyStatusChecker getInstance() {
        return instance;
    }

    private EmptyStatusChecker() {
    }

    public boolean isInRange(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        return true;
    }

    public float getLevel(FaceRangeStatus faceRangeStatus, ValueRange valueRange) {
        return 0.0f;
    }
}
