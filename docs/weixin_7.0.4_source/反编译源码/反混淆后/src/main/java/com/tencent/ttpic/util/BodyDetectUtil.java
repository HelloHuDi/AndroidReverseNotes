package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.List;

public class BodyDetectUtil {
    private static final int WAISTLINE_LEFT_POINT = 15;
    private static final int WAISTLINE_RIGHT_POINT = 43;

    public static float calcWaistLine(List<PointF> list, double d, int i) {
        AppMethodBeat.m2504i(83823);
        float f = -1.0f;
        if (!(list == null || list.isEmpty() || i <= 0)) {
            f = ((((float) (((double) ((PointF) list.get(WAISTLINE_RIGHT_POINT)).y) / d)) + ((float) (((double) ((PointF) list.get(15)).y) / d))) / 2.0f) / ((float) i);
        }
        AppMethodBeat.m2505o(83823);
        return f;
    }

    public static void updateBodyPositionsAlterLongLeg(List<BodyDetectResult> list, float f) {
        AppMethodBeat.m2504i(83824);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(83824);
            return;
        }
        float f2 = f * 0.2f;
        for (BodyDetectResult bodyDetectResult : list) {
            List list2 = bodyDetectResult.bodyPoints;
            float f3 = (((PointF) list2.get(WAISTLINE_RIGHT_POINT)).y + ((PointF) list2.get(15)).y) / 2.0f;
            for (int i = 16; i < WAISTLINE_RIGHT_POINT; i++) {
                PointF pointF = (PointF) list2.get(i);
                pointF.y += (pointF.y - f3) * f2;
            }
        }
        AppMethodBeat.m2505o(83824);
    }
}
