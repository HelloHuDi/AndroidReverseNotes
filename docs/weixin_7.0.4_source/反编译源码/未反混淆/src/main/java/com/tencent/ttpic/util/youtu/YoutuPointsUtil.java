package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YoutuPointsUtil {
    public static List<PointF> transformYTPointsToPtuPoints(float[] fArr) {
        AppMethodBeat.i(84407);
        List transform90PointsTo83 = transform90PointsTo83(fArr);
        PointF middlePoint = AlgoUtils.middlePoint((PointF) transform90PointsTo83.get(55), (PointF) transform90PointsTo83.get(63));
        transform90PointsTo83.add(middlePoint);
        transform90PointsTo83.add(AlgoUtils.middlePoint((PointF) transform90PointsTo83.get(23), (PointF) transform90PointsTo83.get(31)));
        transform90PointsTo83.add(AlgoUtils.middlePoint((PointF) transform90PointsTo83.get(59), (PointF) transform90PointsTo83.get(77)));
        transform90PointsTo83.add(new PointF((2.0f * ((PointF) transform90PointsTo83.get(35)).x) - ((PointF) transform90PointsTo83.get(6)).x, (float) (((double) ((PointF) transform90PointsTo83.get(39)).y) + (((double) (((PointF) transform90PointsTo83.get(39)).y - ((PointF) transform90PointsTo83.get(56)).y)) * 3.2d))));
        transform90PointsTo83.add(new PointF((float) ((2.4d * ((double) ((PointF) transform90PointsTo83.get(64)).x)) - (1.4d * ((double) ((PointF) transform90PointsTo83.get(9)).x))), (float) ((2.5d * ((double) middlePoint.y)) - (1.5d * ((double) ((PointF) transform90PointsTo83.get(59)).y)))));
        transform90PointsTo83.add(new PointF((2.0f * ((PointF) transform90PointsTo83.get(45)).x) - ((PointF) transform90PointsTo83.get(12)).x, (float) ((((double) ((PointF) transform90PointsTo83.get(49)).y) * 4.2d) - (((double) ((PointF) transform90PointsTo83.get(62)).y) * 3.2d))));
        transform90PointsTo83.add(new PointF((2.0f * middlePoint.x) - ((PointF) transform90PointsTo83.get(59)).x, (float) ((((double) (((PointF) transform90PointsTo83.get(49)).y + ((PointF) transform90PointsTo83.get(39)).y)) / 2.0d) - (((double) (((PointF) transform90PointsTo83.get(64)).y - middlePoint.y)) * 1.4d))));
        AppMethodBeat.o(84407);
        return transform90PointsTo83;
    }

    private static List<PointF> transform90PointsTo83(float[] fArr) {
        int i;
        AppMethodBeat.i(84408);
        PointF[] pointFArr = new PointF[83];
        for (i = 0; i < 83; i++) {
            pointFArr[i] = new PointF();
        }
        pointFArr[0] = getMiddleV2(fArr, 67, 68);
        for (i = 1; i <= 17; i++) {
            pointFArr[i].x = fArr[((i + 68) * 2) + 0];
            pointFArr[i].y = fArr[((i + 68) * 2) + 1];
        }
        pointFArr[18] = getMiddleV2(fArr, 86, 87);
        for (i = 19; i <= 34; i++) {
            pointFArr[i].x = fArr[((i - 19) * 2) + 0];
            pointFArr[i].y = fArr[((i - 19) * 2) + 1];
        }
        for (i = 35; i <= 42; i++) {
            pointFArr[i].x = fArr[((i - 19) * 2) + 0];
            pointFArr[i].y = fArr[((i - 19) * 2) + 1];
        }
        pointFArr[43] = getArrayMiddleV2(fArr, 16, 23);
        pointFArr[44].x = fArr[ErrorCode.NEEDDOWNLOAD_FALSE_6];
        pointFArr[44].y = fArr[ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING];
        for (i = 45; i <= 52; i++) {
            pointFArr[i].x = fArr[((i - 21) * 2) + 0];
            pointFArr[i].y = fArr[((i - 21) * 2) + 1];
        }
        pointFArr[53] = getArrayMiddleV2(fArr, 24, 31);
        pointFArr[54].x = fArr[178];
        pointFArr[54].y = fArr[179];
        pointFArr[55].x = (float) ((((double) fArr[66]) * 0.5d) + (((double) fArr[40]) * 0.5d));
        pointFArr[55].y = (float) ((((double) fArr[67]) * 0.5d) + (((double) fArr[41]) * 0.5d));
        pointFArr[56].x = (float) (((0.1d * ((double) fArr[64])) + (((double) fArr[70]) * 0.45d)) + (((double) fArr[72]) * 0.45d));
        pointFArr[56].y = (float) (((0.1d * ((double) fArr[65])) + (((double) fArr[71]) * 0.45d)) + (((double) fArr[73]) * 0.45d));
        for (i = 57; i <= 61; i++) {
            pointFArr[i].x = fArr[((i - 20) * 2) + 0];
            pointFArr[i].y = fArr[((i - 20) * 2) + 1];
        }
        pointFArr[62].x = (float) (((0.1d * ((double) fArr[64])) + (((double) fArr[86]) * 0.45d)) + (((double) fArr[84]) * 0.45d));
        pointFArr[62].y = (float) (((0.1d * ((double) fArr[65])) + (((double) fArr[87]) * 0.45d)) + (((double) fArr[85]) * 0.45d));
        pointFArr[63].x = (float) ((((double) fArr[66]) * 0.5d) + (((double) fArr[56]) * 0.5d));
        pointFArr[63].y = (float) ((((double) fArr[67]) * 0.5d) + (((double) fArr[57]) * 0.5d));
        pointFArr[64].x = fArr[64];
        pointFArr[64].y = fArr[65];
        pointFArr[65].x = fArr[90];
        pointFArr[65].y = fArr[91];
        pointFArr[66].x = fArr[102];
        pointFArr[66].y = fArr[103];
        for (i = 67; i <= 71; i++) {
            pointFArr[i].x = fArr[((i - 21) * 2) + 0];
            pointFArr[i].y = fArr[((i - 21) * 2) + 1];
        }
        pointFArr[72] = getMiddleV2(fArr, 60, 61);
        pointFArr[73].x = fArr[118];
        pointFArr[73].y = fArr[d.MIC_AVROUND_BLUR];
        pointFArr[74] = getMiddleV2(fArr, 57, 58);
        for (i = 75; i <= 79; i++) {
            pointFArr[i].x = fArr[((131 - i) * 2) + 0];
            pointFArr[i].y = fArr[((131 - i) * 2) + 1];
        }
        pointFArr[80] = getMiddleV2(fArr, 62, 63);
        pointFArr[81].x = fArr[128];
        pointFArr[81].y = fArr[GmsClientSupervisor.DEFAULT_BIND_FLAGS];
        pointFArr[82] = getMiddleV2(fArr, 65, 66);
        adjustEyeFeatureV2(pointFArr);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(pointFArr));
        AppMethodBeat.o(84408);
        return arrayList;
    }

    private static PointF getMiddleV2(float[] fArr, int i, int i2) {
        AppMethodBeat.i(84409);
        PointF pointF = new PointF((fArr[i * 2] + fArr[i2 * 2]) / 2.0f, (fArr[(i * 2) + 1] + fArr[(i2 * 2) + 1]) / 2.0f);
        AppMethodBeat.o(84409);
        return pointF;
    }

    private static PointF getArrayMiddleV2(float[] fArr, int i, int i2) {
        AppMethodBeat.i(84410);
        PointF pointF = new PointF();
        for (int i3 = i; i3 <= i2; i3++) {
            pointF.x += fArr[i3 * 2];
            pointF.y += fArr[(i3 * 2) + 1];
        }
        pointF.x /= (float) ((i2 - i) + 1);
        pointF.y /= (float) ((i2 - i) + 1);
        AppMethodBeat.o(84410);
        return pointF;
    }

    private static void adjustEyeFeatureV2(PointF[] pointFArr) {
        pointFArr[40].x = (float) (((double) pointFArr[38].x) + (((double) (pointFArr[40].x - pointFArr[38].x)) * 0.98d));
        pointFArr[40].y = (float) (((double) pointFArr[38].y) + (((double) (pointFArr[40].y - pointFArr[38].y)) * 0.98d));
        pointFArr[41].x = (float) (((double) pointFArr[37].x) + (((double) (pointFArr[41].x - pointFArr[37].x)) * 0.95d));
        pointFArr[41].y = (float) (((double) pointFArr[37].y) + (((double) (pointFArr[41].y - pointFArr[37].y)) * 0.95d));
        pointFArr[42].x = (float) (((double) pointFArr[36].x) + (((double) (pointFArr[42].x - pointFArr[36].x)) * 0.9d));
        pointFArr[42].y = (float) (((double) pointFArr[36].y) + (((double) (pointFArr[42].y - pointFArr[36].y)) * 0.9d));
        pointFArr[50].x = (float) (((double) pointFArr[48].x) + (((double) (pointFArr[50].x - pointFArr[48].x)) * 0.98d));
        pointFArr[50].y = (float) (((double) pointFArr[48].y) + (((double) (pointFArr[50].y - pointFArr[48].y)) * 0.98d));
        pointFArr[51].x = (float) (((double) pointFArr[47].x) + (((double) (pointFArr[51].x - pointFArr[47].x)) * 0.95d));
        pointFArr[51].y = (float) (((double) pointFArr[47].y) + (((double) (pointFArr[51].y - pointFArr[47].y)) * 0.95d));
        pointFArr[52].x = (float) (((double) pointFArr[46].x) + (((double) (pointFArr[52].x - pointFArr[46].x)) * 0.9d));
        pointFArr[52].y = (float) (((double) pointFArr[46].y) + (((double) (pointFArr[52].y - pointFArr[46].y)) * 0.9d));
        PointF pointF = pointFArr[35];
        pointF.y = (float) (((double) pointF.y) + (((double) (pointFArr[39].x - pointFArr[35].x)) / 40.0d));
        pointF = pointFArr[45];
        pointF.y = (float) (((double) pointF.y) + (((double) (pointFArr[45].x - pointFArr[49].x)) / 40.0d));
    }

    public static List<PointF> getIrisPoints(float[] fArr) {
        AppMethodBeat.i(84411);
        ArrayList arrayList = new ArrayList();
        if (fArr.length != 188) {
            AppMethodBeat.o(84411);
        } else {
            for (int i = 90; i < 94; i++) {
                arrayList.add(new PointF(fArr[i * 2], fArr[(i * 2) + 1]));
            }
            AppMethodBeat.o(84411);
        }
        return arrayList;
    }

    public static List<PointF> getIrisRelatedPoints(List<List<PointF>> list, List<List<PointF>> list2) {
        AppMethodBeat.i(84412);
        ArrayList arrayList = new ArrayList();
        if (BaseUtils.isEmpty(list) || BaseUtils.isEmpty(list2)) {
            AppMethodBeat.o(84412);
            return arrayList;
        }
        List list3 = (List) list.get(0);
        List list4 = (List) list2.get(0);
        arrayList.add(list3.get(44));
        arrayList.add(list3.get(41));
        arrayList.add(list4.get(0));
        arrayList.add(list3.get(37));
        arrayList.add(list4.get(1));
        arrayList.add(list3.get(54));
        arrayList.add(list3.get(51));
        arrayList.add(list4.get(2));
        arrayList.add(list3.get(47));
        arrayList.add(list4.get(3));
        AppMethodBeat.o(84412);
        return arrayList;
    }

    public static List<PointF> getIris4Points(List<List<PointF>> list, List<List<PointF>> list2) {
        AppMethodBeat.i(84413);
        ArrayList arrayList = new ArrayList();
        if (BaseUtils.isEmpty(list) || BaseUtils.isEmpty(list2)) {
            AppMethodBeat.o(84413);
            return arrayList;
        }
        List list3 = (List) list.get(0);
        list2.get(0);
        arrayList.add(list3.get(44));
        arrayList.add(list3.get(54));
        AppMethodBeat.o(84413);
        return arrayList;
    }

    public static List<PointF> getIris3Points(List<List<PointF>> list, List<List<PointF>> list2) {
        AppMethodBeat.i(84414);
        ArrayList arrayList = new ArrayList();
        if (BaseUtils.isEmpty(list) || BaseUtils.isEmpty(list2)) {
            AppMethodBeat.o(84414);
            return arrayList;
        }
        List list3 = (List) list.get(0);
        list2.get(0);
        arrayList.add(list3.get(43));
        arrayList.add(list3.get(53));
        AppMethodBeat.o(84414);
        return arrayList;
    }
}
