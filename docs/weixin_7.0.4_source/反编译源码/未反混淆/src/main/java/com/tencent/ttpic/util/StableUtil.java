package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import java.util.ArrayList;
import java.util.List;

public class StableUtil {
    public static float getDistSquare(PointF pointF, PointF pointF2) {
        if (pointF == null || pointF2 == null) {
            return 0.0f;
        }
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return (f * f) + (f2 * f2);
    }

    public static List<PointF> getAvgPoints(List<List<PointF>> list) {
        int i = 0;
        AppMethodBeat.i(83975);
        if (BaseUtils.isEmpty(list)) {
            List list2 = VideoMaterialUtil.EMPTY_POINTS_LIST;
            AppMethodBeat.o(83975);
            return list2;
        }
        PointF pointF;
        ArrayList arrayList = new ArrayList(((List) list.get(0)).size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (int i3 = 0; i3 < ((List) list.get(0)).size(); i3++) {
                if (i3 >= arrayList.size()) {
                    arrayList.add(new PointF());
                }
                pointF = (PointF) arrayList.get(i3);
                pointF.x = ((PointF) ((List) list.get(i2)).get(i3)).x + pointF.x;
                pointF = (PointF) arrayList.get(i3);
                pointF.y = ((PointF) ((List) list.get(i2)).get(i3)).y + pointF.y;
            }
        }
        while (i < arrayList.size()) {
            pointF = (PointF) arrayList.get(i);
            pointF.x /= (float) list.size();
            pointF = (PointF) arrayList.get(i);
            pointF.y /= (float) list.size();
            i++;
        }
        AppMethodBeat.o(83975);
        return arrayList;
    }

    public static List<Integer> getAvgAngles(List<List<Integer>> list) {
        int i = 0;
        AppMethodBeat.i(83976);
        if (BaseUtils.isEmpty(list)) {
            List list2 = VideoMaterialUtil.EMPTY_ANGLES_LIST;
            AppMethodBeat.o(83976);
            return list2;
        }
        ArrayList arrayList = new ArrayList(((List) list.get(0)).size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (int i3 = 0; i3 < ((List) list.get(0)).size(); i3++) {
                if (i3 >= arrayList.size()) {
                    arrayList.add(Integer.valueOf(0));
                }
                arrayList.set(i3, Integer.valueOf(((Integer) ((List) list.get(i2)).get(i3)).intValue() + ((Integer) arrayList.get(i3)).intValue()));
            }
        }
        while (i < arrayList.size()) {
            arrayList.set(i, Integer.valueOf(((Integer) arrayList.get(i)).intValue() / list.size()));
            i++;
        }
        AppMethodBeat.o(83976);
        return arrayList;
    }
}
