package com.tencent.ttpic.face;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class LeftEyeRangeDetector implements RangeDetector {
    private static LeftEyeRangeDetector detector = new LeftEyeRangeDetector();

    public enum RANGE {
        CLOSE_EYE(0),
        OPEN_EYE_20(1),
        OPEN_EYE_40(2),
        OPEN_EYE_60(3),
        OPEN_EYE_80(4),
        OPEN_EYE_100(5);
        
        public final int value;

        static {
            AppMethodBeat.o(81890);
        }

        private RANGE(int i) {
            this.value = i;
        }
    }

    static {
        AppMethodBeat.i(81892);
        AppMethodBeat.o(81892);
    }

    public static LeftEyeRangeDetector getInstance() {
        return detector;
    }

    private LeftEyeRangeDetector() {
    }

    public float detectRange(List<PointF> list) {
        AppMethodBeat.i(81891);
        if (list == null || list.size() < 90) {
            AppMethodBeat.o(81891);
            return 0.0f;
        }
        float distance;
        float distance2 = AlgoUtils.getDistance((PointF) list.get(47), (PointF) list.get(48));
        if (distance2 > 0.0f) {
            distance = AlgoUtils.getDistance((PointF) list.get(47), (PointF) list.get(51)) / (distance2 / 3.0f);
        } else {
            distance = 5.0f;
        }
        distance = Math.min(distance / 5.0f, 1.0f);
        AppMethodBeat.o(81891);
        return distance;
    }
}
