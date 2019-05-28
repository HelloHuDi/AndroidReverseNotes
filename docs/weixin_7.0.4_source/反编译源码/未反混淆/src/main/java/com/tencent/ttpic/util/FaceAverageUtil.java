package com.tencent.ttpic.util;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class FaceAverageUtil {
    public static boolean isPositiveFace(float[] fArr, List<PointF> list, int i, int i2, double d) {
        AppMethodBeat.i(83827);
        double min = Math.min(Math.abs(Math.cos((double) fArr[0])), Math.abs(Math.cos((double) fArr[1])));
        if (!checkFaceFeatureOutScreen(list, i, i2, d) || min < 0.94d) {
            AppMethodBeat.o(83827);
            return false;
        }
        AppMethodBeat.o(83827);
        return true;
    }

    private static boolean checkFaceFeatureOutScreen(List<PointF> list, int i, int i2, double d) {
        AppMethodBeat.i(83828);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(83828);
            return false;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) (((double) i) * d), (float) (((double) i2) * d));
        if (!rectF.contains(((PointF) list.get(65)).x, ((PointF) list.get(65)).y)) {
            AppMethodBeat.o(83828);
            return false;
        } else if (rectF.contains(((PointF) list.get(66)).x, ((PointF) list.get(66)).y)) {
            PointF pointF = new PointF((((PointF) list.get(9)).x + ((PointF) list.get(69)).x) / 2.0f, (((PointF) list.get(9)).y + ((PointF) list.get(69)).y) / 2.0f);
            boolean contains = rectF.contains(pointF.x, pointF.y);
            AppMethodBeat.o(83828);
            return contains;
        } else {
            AppMethodBeat.o(83828);
            return false;
        }
    }
}
