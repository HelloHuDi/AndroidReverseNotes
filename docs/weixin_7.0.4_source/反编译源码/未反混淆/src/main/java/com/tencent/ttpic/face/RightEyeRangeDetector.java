package com.tencent.ttpic.face;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class RightEyeRangeDetector implements RangeDetector {
    private static RightEyeRangeDetector detector = new RightEyeRangeDetector();

    public enum RANGE {
        CLOSE_EYE(0),
        OPEN_EYE_20(1),
        OPEN_EYE_40(2),
        OPEN_EYE_60(3),
        OPEN_EYE_80(4),
        OPEN_EYE_100(5);
        
        public final int value;

        static {
            AppMethodBeat.o(81902);
        }

        private RANGE(int i) {
            this.value = i;
        }
    }

    static {
        AppMethodBeat.i(81904);
        AppMethodBeat.o(81904);
    }

    public static RightEyeRangeDetector getInstance() {
        return detector;
    }

    private RightEyeRangeDetector() {
    }

    public float detectRange(List<PointF> list) {
        AppMethodBeat.i(81903);
        if (list == null || list.size() < 90) {
            AppMethodBeat.o(81903);
            return 0.0f;
        }
        float distance;
        float distance2 = AlgoUtils.getDistance((PointF) list.get(37), (PointF) list.get(38));
        if (distance2 > 0.0f) {
            distance = AlgoUtils.getDistance((PointF) list.get(37), (PointF) list.get(41)) / (distance2 / 3.0f);
        } else {
            distance = 5.0f;
        }
        distance = Math.min(distance / 5.0f, 1.0f);
        AppMethodBeat.o(81903);
        return distance;
    }
}
