package com.tencent.ttpic.face;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class MouthRangeDetector implements RangeDetector {
    private static MouthRangeDetector detector = new MouthRangeDetector();

    public enum RANGE {
        CLOSE_MOUTH(0),
        OPEN_MOUTH_20(1),
        OPEN_MOUTH_40(2),
        OPEN_MOUTH_60(3),
        OPEN_MOUTH_80(4),
        OPEN_MOUTH_100(5);
        
        public final int value;

        static {
            AppMethodBeat.o(81896);
        }

        private RANGE(int i) {
            this.value = i;
        }
    }

    static {
        AppMethodBeat.i(81898);
        AppMethodBeat.o(81898);
    }

    public static MouthRangeDetector getInstance() {
        return detector;
    }

    private MouthRangeDetector() {
    }

    public float detectRange(List<PointF> list) {
        AppMethodBeat.i(81897);
        if (list == null || list.size() < 90) {
            AppMethodBeat.o(81897);
            return 0.0f;
        }
        float distance;
        float distance2 = AlgoUtils.getDistance((PointF) list.get(69), (PointF) list.get(73));
        if (distance2 > 0.0f) {
            distance = AlgoUtils.getDistance((PointF) list.get(81), (PointF) list.get(73)) / (distance2 / 2.0f);
        } else {
            distance = 5.0f;
        }
        distance = Math.min(distance / 5.0f, 1.0f);
        AppMethodBeat.o(81897);
        return distance;
    }
}
