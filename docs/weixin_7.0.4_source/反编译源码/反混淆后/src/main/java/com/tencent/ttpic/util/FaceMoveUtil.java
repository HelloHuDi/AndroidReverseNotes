package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.model.FaceMoveItem;
import java.util.List;

public class FaceMoveUtil {
    public static final int[] FaceMeshTriangles = new int[]{1, 0, 35, 35, 36, 1, 35, 42, 36, 35, 20, 42, 19, 20, 35, 19, 26, 20, 19, 96, 26, 90, 96, 19, 35, 90, 19, 35, 0, 90, 95, 26, 96, 25, 26, 95, 26, 25, 21, 20, 26, 21, 42, 20, 21, 42, 21, 41, 42, 41, 43, 36, 42, 43, 36, 43, 37, 36, 37, 57, 57, 2, 36, 2, 57, 3, 65, 3, 57, 4, 3, 65, 5, 4, 65, 67, 5, 65, 67, 6, 5, 7, 6, 67, 7, 67, 68, 8, 7, 68, 68, 69, 8, 68, 73, 69, 68, 74, 73, 67, 74, 68, 67, 65, 74, 65, 75, 82, 75, 65, 57, 75, 57, 58, 75, 58, 76, 82, 75, 76, 65, 82, 74, 74, 82, 81, 74, 81, 73, 73, 81, 80, 73, 80, 72, 70, 73, 72, 69, 73, 70, 69, 70, 10, 10, 9, 69, 69, 9, 8, 10, 70, 11, 11, 70, 12, 12, 70, 71, 12, 71, 13, 13, 71, 66, 13, 66, 14, 14, 66, 15, 15, 66, 79, 79, 61, 15, 61, 79, 60, 60, 64, 61, 60, 59, 64, 78, 59, 60, 78, 77, 59, 80, 77, 78, 80, 81, 77, 76, 77, 81, 77, 76, 59, 76, 58, 59, 59, 58, 64, 58, 56, 64, 57, 56, 58, 57, 38, 56, 37, 38, 57, 38, 37, 43, 38, 43, 40, 38, 40, 39, 56, 38, 39, 39, 55, 56, 23, 55, 39, 31, 55, 23, 55, 31, 63, 56, 55, 63, 56, 63, 62, 64, 56, 62, 64, 62, 61, 47, 61, 62, 61, 47, 46, 61, 46, 17, 16, 61, 15, 16, 61, 17, 17, 46, 45, 45, 18, 17, 18, 45, 91, 45, 27, 91, 45, 28, 27, 52, 28, 45, 52, 29, 28, 51, 29, 52, 51, 50, 29, 50, 51, 53, 48, 50, 53, 49, 50, 48, 49, 31, 50, 49, 63, 31, 48, 63, 49, 48, 62, 63, 47, 62, 48, 48, 53, 47, 47, 53, 52, 46, 47, 52, 45, 46, 52, 53, 51, 52, 31, 30, 50, 31, 32, 30, 32, 31, 94, 32, 94, 92, 32, 92, 33, 30, 32, 33, 30, 33, 29, 50, 30, 29, 28, 29, 33, 34, 28, 33, 28, 34, 27, 27, 34, 93, 27, 93, 91, 93, 34, 92, 34, 33, 92, 94, 31, 23, 23, 24, 94, 22, 24, 23, 22, 21, 24, 41, 21, 22, 40, 41, 22, 43, 41, 40, 40, 22, 39, 39, 22, 23, 21, 25, 24, 25, 95, 24, 24, 95, 94, 82, 76, 81, 80, 78, 79, 72, 80, 66, 80, 79, 66, 71, 72, 66, 70, 72, 71, 79, 78, 60, 36, 2, 1, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100};
    public static final int SIZE_FULL_COORDS = 107;
    public static final int TRIANGLE_COUNT = 182;

    public static void genFullCoords(PointF[] pointFArr) {
        AppMethodBeat.m2504i(83880);
        if (pointFArr == null || pointFArr.length < 107) {
            AppMethodBeat.m2505o(83880);
            return;
        }
        int i;
        pointFArr[83].x = pointFArr[55].x + ((pointFArr[63].x - pointFArr[55].x) / 2.0f);
        pointFArr[83].y = pointFArr[55].y + ((pointFArr[63].y - pointFArr[55].y) / 2.0f);
        pointFArr[84].x = pointFArr[23].x + ((pointFArr[31].x - pointFArr[23].x) / 2.0f);
        pointFArr[84].y = pointFArr[23].y + ((pointFArr[31].y - pointFArr[23].y) / 2.0f);
        pointFArr[85].x = pointFArr[59].x + ((pointFArr[77].x - pointFArr[59].x) / 2.0f);
        pointFArr[85].y = pointFArr[59].y + ((pointFArr[77].y - pointFArr[59].y) / 2.0f);
        pointFArr[86].x = pointFArr[35].x + (pointFArr[35].x - pointFArr[6].x);
        pointFArr[86].y = pointFArr[35].y + (pointFArr[35].y - pointFArr[6].y);
        pointFArr[87].x = pointFArr[64].x + ((pointFArr[64].x - pointFArr[9].x) * 1.4f);
        pointFArr[87].y = pointFArr[64].y + ((pointFArr[64].y - pointFArr[9].y) * 1.4f);
        pointFArr[88].x = pointFArr[45].x + (pointFArr[45].x - pointFArr[12].x);
        pointFArr[88].y = pointFArr[45].y + (pointFArr[45].y - pointFArr[12].y);
        pointFArr[89].x = pointFArr[83].x + (pointFArr[83].x - pointFArr[59].x);
        pointFArr[89].y = pointFArr[83].y + (pointFArr[83].y - pointFArr[59].y);
        float atan = (float) Math.atan((double) ((pointFArr[9].x - pointFArr[84].x) / ((-pointFArr[9].y) + pointFArr[84].y)));
        float distance = AlgoUtils.getDistance(pointFArr[0], pointFArr[1]);
        pointFArr[90].x = (float) (((double) pointFArr[1].x) + (((double) (2.0f * distance)) * Math.sin((double) atan)));
        pointFArr[90].y = (float) (((double) pointFArr[1].y) - (((double) (distance * 2.0f)) * Math.cos((double) atan)));
        distance = AlgoUtils.getDistance(pointFArr[17], pointFArr[18]);
        pointFArr[91].x = (float) (((double) pointFArr[17].x) + (((double) (2.0f * distance)) * Math.sin((double) atan)));
        pointFArr[91].y = (float) (((double) pointFArr[17].y) - (((double) (distance * 2.0f)) * Math.cos((double) atan)));
        distance = AlgoUtils.getDistance(pointFArr[59], new PointF((pointFArr[41].x + pointFArr[51].x) / 2.0f, (pointFArr[41].y + pointFArr[51].y) / 2.0f));
        PointF pointF = pointFArr[91];
        PointF pointF2 = pointFArr[90];
        PointF pointF3 = new PointF((float) (((double) pointFArr[59].x) + (((double) (2.0f * distance)) * Math.sin((double) atan))), (float) (((double) pointFArr[59].y) - (Math.cos((double) atan) * ((double) (distance * 2.0f)))));
        for (i = 2; i > 0; i--) {
            distance = ((float) i) * 0.5233334f;
            pointFArr[94 - i].x = (float) (((double) pointF3.x) - (((double) (pointF3.x - pointF.x)) * Math.cos((double) distance)));
            pointFArr[94 - i].y = (float) (((double) pointF.y) - (((double) (pointF.y - pointF3.y)) * Math.sin((double) distance)));
        }
        for (i = 3; i > 0; i--) {
            distance = ((float) i) * 0.5233334f;
            pointFArr[97 - i].x = (float) (((double) pointF3.x) - (((double) (pointF3.x - pointF2.x)) * Math.cos((double) distance)));
            pointFArr[97 - i].y = (float) (((double) pointF2.y) - (((double) (pointF2.y - pointF3.y)) * Math.sin((double) distance)));
        }
        PointF pointF4 = pointFArr[64];
        PointF pointF5 = new PointF(pointFArr[54].x - pointFArr[44].x, pointFArr[54].y - pointFArr[44].y);
        pointF = new PointF(pointF5.x + pointF5.x, pointF5.y + pointF5.y);
        pointF5 = new PointF(-pointF.y, pointF.x);
        pointFArr[99].x = (pointF4.x - pointF.x) - pointF5.x;
        pointFArr[99].y = (pointF4.y - pointF.y) - pointF5.y;
        pointFArr[100].x = pointF4.x - pointF.x;
        pointFArr[100].y = pointF4.y - pointF.y;
        pointFArr[101].x = (pointF4.x - pointF.x) + pointF5.x;
        pointFArr[101].y = (pointF4.y - pointF.y) + pointF5.y;
        pointFArr[102].x = pointF4.x + pointF5.x;
        pointFArr[102].y = pointF4.y + pointF5.y;
        pointFArr[103].x = (pointF4.x + pointF.x) + pointF5.x;
        pointFArr[103].y = (pointF4.y + pointF.y) + pointF5.y;
        pointFArr[104].x = pointF4.x + pointF.x;
        pointFArr[104].y = pointF4.y + pointF.y;
        pointFArr[105].x = (pointF4.x + pointF.x) - pointF5.x;
        pointFArr[105].y = (pointF.y + pointF4.y) - pointF5.y;
        pointFArr[106].x = pointF4.x - pointF5.x;
        pointFArr[106].y = pointF4.y - pointF5.y;
        AppMethodBeat.m2505o(83880);
    }

    public static void genFullCoords(List<PointF> list) {
        AppMethodBeat.m2504i(83881);
        if (list == null || list.size() < 83) {
            AppMethodBeat.m2505o(83881);
            return;
        }
        while (list.size() < 107) {
            list.add(new PointF());
        }
        ((PointF) list.get(83)).x = ((((PointF) list.get(63)).x - ((PointF) list.get(55)).x) / 2.0f) + ((PointF) list.get(55)).x;
        ((PointF) list.get(83)).y = ((((PointF) list.get(63)).y - ((PointF) list.get(55)).y) / 2.0f) + ((PointF) list.get(55)).y;
        ((PointF) list.get(84)).x = ((((PointF) list.get(31)).x - ((PointF) list.get(23)).x) / 2.0f) + ((PointF) list.get(23)).x;
        ((PointF) list.get(84)).y = ((((PointF) list.get(31)).y - ((PointF) list.get(23)).y) / 2.0f) + ((PointF) list.get(23)).y;
        ((PointF) list.get(85)).x = ((((PointF) list.get(77)).x - ((PointF) list.get(59)).x) / 2.0f) + ((PointF) list.get(59)).x;
        ((PointF) list.get(85)).y = ((((PointF) list.get(77)).y - ((PointF) list.get(59)).y) / 2.0f) + ((PointF) list.get(59)).y;
        ((PointF) list.get(86)).x = (((PointF) list.get(35)).x - ((PointF) list.get(6)).x) + ((PointF) list.get(35)).x;
        ((PointF) list.get(86)).y = (((PointF) list.get(35)).y - ((PointF) list.get(6)).y) + ((PointF) list.get(35)).y;
        ((PointF) list.get(87)).x = ((((PointF) list.get(64)).x - ((PointF) list.get(9)).x) * 1.4f) + ((PointF) list.get(64)).x;
        ((PointF) list.get(87)).y = ((((PointF) list.get(64)).y - ((PointF) list.get(9)).y) * 1.4f) + ((PointF) list.get(64)).y;
        ((PointF) list.get(88)).x = (((PointF) list.get(45)).x - ((PointF) list.get(12)).x) + ((PointF) list.get(45)).x;
        ((PointF) list.get(88)).y = (((PointF) list.get(45)).y - ((PointF) list.get(12)).y) + ((PointF) list.get(45)).y;
        ((PointF) list.get(89)).x = (((PointF) list.get(83)).x - ((PointF) list.get(59)).x) + ((PointF) list.get(83)).x;
        ((PointF) list.get(89)).y = (((PointF) list.get(83)).y - ((PointF) list.get(59)).y) + ((PointF) list.get(83)).y;
        float atan = (float) Math.atan((double) ((((PointF) list.get(9)).x - ((PointF) list.get(84)).x) / (((PointF) list.get(84)).y + (-((PointF) list.get(9)).y))));
        float distance = AlgoUtils.getDistance((PointF) list.get(0), (PointF) list.get(1));
        ((PointF) list.get(90)).x = (float) (((double) ((PointF) list.get(1)).x) + (((double) (2.0f * distance)) * Math.sin((double) atan)));
        ((PointF) list.get(90)).y = (float) (((double) ((PointF) list.get(1)).y) - (((double) (2.0f * distance)) * Math.cos((double) atan)));
        distance = AlgoUtils.getDistance((PointF) list.get(17), (PointF) list.get(18));
        ((PointF) list.get(91)).x = (float) (((double) ((PointF) list.get(17)).x) + (((double) (2.0f * distance)) * Math.sin((double) atan)));
        ((PointF) list.get(91)).y = (float) (((double) ((PointF) list.get(17)).y) - (((double) (2.0f * distance)) * Math.cos((double) atan)));
        float distance2 = AlgoUtils.getDistance((PointF) list.get(59), new PointF((((PointF) list.get(51)).x + ((PointF) list.get(41)).x) / 2.0f, (((PointF) list.get(51)).y + ((PointF) list.get(41)).y) / 2.0f));
        PointF pointF = (PointF) list.get(91);
        PointF pointF2 = (PointF) list.get(90);
        PointF pointF3 = new PointF((float) (((double) ((PointF) list.get(59)).x) + (((double) (2.0f * distance2)) * Math.sin((double) atan))), (float) (((double) ((PointF) list.get(59)).y) - (Math.cos((double) atan) * ((double) (2.0f * distance2)))));
        for (int i = 2; i > 0; i--) {
            distance2 = 0.5233334f * ((float) i);
            ((PointF) list.get(94 - i)).x = (float) (((double) pointF3.x) - (((double) (pointF3.x - pointF.x)) * Math.cos((double) distance2)));
            ((PointF) list.get(94 - i)).y = (float) (((double) pointF.y) - (((double) (pointF.y - pointF3.y)) * Math.sin((double) distance2)));
        }
        for (int i2 = 3; i2 > 0; i2--) {
            atan = 0.5233334f * ((float) i2);
            ((PointF) list.get(97 - i2)).x = (float) (((double) pointF3.x) - (((double) (pointF3.x - pointF2.x)) * Math.cos((double) atan)));
            ((PointF) list.get(97 - i2)).y = (float) (((double) pointF2.y) - (((double) (pointF2.y - pointF3.y)) * Math.sin((double) atan)));
        }
        pointF = (PointF) list.get(64);
        PointF pointF4 = new PointF(((PointF) list.get(54)).x - ((PointF) list.get(44)).x, ((PointF) list.get(54)).y - ((PointF) list.get(44)).y);
        PointF pointF5 = new PointF(pointF4.x + pointF4.x, pointF4.y + pointF4.y);
        pointF4 = new PointF(-pointF5.y, pointF5.x);
        ((PointF) list.get(99)).x = (pointF.x - pointF5.x) - pointF4.x;
        ((PointF) list.get(99)).y = (pointF.y - pointF5.y) - pointF4.y;
        ((PointF) list.get(100)).x = pointF.x - pointF5.x;
        ((PointF) list.get(100)).y = pointF.y - pointF5.y;
        ((PointF) list.get(101)).x = (pointF.x - pointF5.x) + pointF4.x;
        ((PointF) list.get(101)).y = (pointF.y - pointF5.y) + pointF4.y;
        ((PointF) list.get(102)).x = pointF.x + pointF4.x;
        ((PointF) list.get(102)).y = pointF.y + pointF4.y;
        ((PointF) list.get(103)).x = (pointF.x + pointF5.x) + pointF4.x;
        ((PointF) list.get(103)).y = (pointF.y + pointF5.y) + pointF4.y;
        ((PointF) list.get(104)).x = pointF.x + pointF5.x;
        ((PointF) list.get(104)).y = pointF.y + pointF5.y;
        ((PointF) list.get(105)).x = (pointF.x + pointF5.x) - pointF4.x;
        ((PointF) list.get(105)).y = (pointF5.y + pointF.y) - pointF4.y;
        ((PointF) list.get(106)).x = pointF.x - pointF4.x;
        ((PointF) list.get(106)).y = pointF.y - pointF4.y;
        AppMethodBeat.m2505o(83881);
    }

    public static void adjustCoords(PointF[] pointFArr, PointF[] pointFArr2, List<FaceMoveItem> list) {
        int i = 0;
        AppMethodBeat.m2504i(83882);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.m2505o(83882);
            return;
        }
        VideoMaterialUtil.copyArrayToArray(pointFArr, pointFArr2);
        float distance = AlgoUtils.getDistance(pointFArr[0], pointFArr[18]) / 480.0f;
        PointF pointF = new PointF(pointFArr[54].x - pointFArr[44].x, pointFArr[54].y - pointFArr[44].y);
        PointF pointF2 = new PointF(-pointF.y, pointF.x);
        float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
        float sqrt2 = (float) Math.sqrt((double) ((pointF2.x * pointF2.x) + (pointF2.y * pointF2.y)));
        PointF pointF3 = new PointF((pointF.x * distance) / sqrt, (pointF.y * distance) / sqrt);
        PointF pointF4 = new PointF((pointF2.x * distance) / sqrt2, (distance * pointF2.y) / sqrt2);
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                FaceMoveItem faceMoveItem = (FaceMoveItem) list.get(i2);
                pointF2 = pointFArr[((FaceMoveItem) list.get(i2)).pos1];
                PointF pointF5 = pointFArr[((FaceMoveItem) list.get(i2)).pos2];
                PointF pointF6 = pointFArr[((FaceMoveItem) list.get(i2)).position];
                PointF pointF7 = new PointF((pointF2.x * faceMoveItem.ratio1) + (pointF5.x * (1.0f - faceMoveItem.ratio1)), (pointF2.y * faceMoveItem.ratio1) + (pointF5.y * (1.0f - faceMoveItem.ratio1)));
                pointF2 = new PointF((pointF7.x * faceMoveItem.ratio2) + (pointF6.x * (1.0f - faceMoveItem.ratio2)), (pointF6.y * (1.0f - faceMoveItem.ratio2)) + (pointF7.y * faceMoveItem.ratio2));
                pointFArr2[faceMoveItem.position] = new PointF((pointF2.x + (pointF3.x * ((float) faceMoveItem.f15466dx))) + (pointF4.x * ((float) faceMoveItem.f15467dy)), (((float) faceMoveItem.f15467dy) * pointF4.y) + (pointF2.y + (pointF3.y * ((float) faceMoveItem.f15466dx))));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(83882);
                return;
            }
        }
    }

    public static float[] initMaterialFaceTexCoords(PointF[] pointFArr, int i, int i2, float[] fArr, int[] iArr) {
        if (pointFArr == null || fArr == null || i <= 0 || i2 <= 0 || fArr.length != FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG) {
            return new float[0];
        }
        PointF[] pointFArr2 = new PointF[3];
        if (iArr == null) {
            iArr = FaceMeshTriangles;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < iArr.length; i4 += 3) {
            pointFArr2[0] = pointFArr[iArr[i4]];
            pointFArr2[1] = pointFArr[iArr[i4 + 1]];
            pointFArr2[2] = pointFArr[iArr[i4 + 2]];
            for (int i5 = 0; i5 < 3; i5++) {
                fArr[(i5 * 2) + i3] = pointFArr2[i5].x / ((float) i);
                fArr[((i5 * 2) + i3) + 1] = pointFArr2[i5].y / ((float) i2);
            }
            i3 += 6;
        }
        return fArr;
    }

    public static float[] initFacePositions(PointF[] pointFArr, int i, int i2, float[] fArr, int[] iArr) {
        if (pointFArr == null || fArr == null || i <= 0 || i2 <= 0 || fArr.length != FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG) {
            return new float[0];
        }
        PointF[] pointFArr2 = new PointF[3];
        if (iArr == null) {
            iArr = FaceMeshTriangles;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < iArr.length; i4 += 3) {
            pointFArr2[0] = pointFArr[iArr[i4]];
            pointFArr2[1] = pointFArr[iArr[i4 + 1]];
            pointFArr2[2] = pointFArr[iArr[i4 + 2]];
            for (int i5 = 0; i5 < 3; i5++) {
                fArr[(i5 * 2) + i3] = ((pointFArr2[i5].x / ((float) i)) * 2.0f) - 1.0f;
                fArr[((i5 * 2) + i3) + 1] = ((pointFArr2[i5].y / ((float) i2)) * 2.0f) - 1.0f;
            }
            i3 += 6;
        }
        return fArr;
    }
}
