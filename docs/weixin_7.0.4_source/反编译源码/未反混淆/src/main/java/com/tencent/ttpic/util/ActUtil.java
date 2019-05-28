package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class ActUtil {
    public static final String EXPRESSION = "expression";
    public static final int EXPRESSION_ITEM_COUNT = 7;
    public static final int HEIGHT = 1280;
    private static final String TAG = ActUtil.class.getSimpleName();
    public static final double[] WEIGHT = new double[]{0.2d, 0.2d, 0.3d, 0.06d, 0.06d, 0.06d, 0.12d};
    public static final int WIDTH = 720;

    public enum FRAME_SOURCE_TYPE {
        NONE(0),
        CAMERA(1),
        VIDEO(2),
        TOTAL_SCORE(3),
        CAPTURE(4),
        SINGEL_SCORE(5),
        STAR_IMAGE(6);
        
        public final int value;

        static {
            AppMethodBeat.o(83800);
        }

        private FRAME_SOURCE_TYPE(int i) {
            this.value = i;
        }
    }

    static {
        AppMethodBeat.i(83804);
        AppMethodBeat.o(83804);
    }

    public static float getExpressionSimilarity(List<PointF> list, List<PointF> list2, float[] fArr, float[] fArr2, double[] dArr) {
        AppMethodBeat.i(83801);
        if (list == null || list2 == null || fArr == null || fArr.length < 3 || dArr == null || dArr.length < 7) {
            AppMethodBeat.o(83801);
            return 0.0f;
        }
        List fullCoords = FaceOffUtil.getFullCoords(FaceDetectUtil.facePointf83to90(list), 2.0f);
        List fullCoords2 = FaceOffUtil.getFullCoords(FaceDetectUtil.facePointf83to90(list2), 2.0f);
        if (fullCoords2.size() < 106 || fullCoords.size() < 106) {
            AppMethodBeat.o(83801);
            return 0.0f;
        }
        ArrayList arrayList = new ArrayList(fullCoords.size());
        ArrayList arrayList2 = new ArrayList(fullCoords2.size());
        float distance = AlgoUtils.getDistance((PointF) fullCoords.get(99), (PointF) fullCoords.get(105));
        float distance2 = AlgoUtils.getDistance((PointF) fullCoords.get(99), (PointF) fullCoords.get(101));
        float distance3 = AlgoUtils.getDistance((PointF) fullCoords2.get(99), (PointF) fullCoords2.get(105));
        float distance4 = AlgoUtils.getDistance((PointF) fullCoords2.get(99), (PointF) fullCoords2.get(101));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fullCoords.size()) {
                break;
            }
            arrayList.add(new PointF(((PointF) fullCoords.get(i2)).x / distance, ((PointF) fullCoords.get(i2)).y / distance2));
            arrayList2.add(new PointF(((PointF) fullCoords2.get(i2)).x / distance3, ((PointF) fullCoords2.get(i2)).y / distance4));
            i = i2 + 1;
        }
        float[] fArr3 = new float[7];
        fArr3[0] = getSimilarityOfValue(distanceOfPoint((PointF) arrayList.get(37), (PointF) arrayList.get(41)) / distanceOfPoint((PointF) arrayList.get(35), (PointF) arrayList.get(39)), distanceOfPoint((PointF) arrayList2.get(37), (PointF) arrayList2.get(41)) / distanceOfPoint((PointF) arrayList2.get(35), (PointF) arrayList2.get(39)), 0.18f, 0.5f);
        fArr3[1] = getSimilarityOfValue(distanceOfPoint((PointF) arrayList.get(47), (PointF) arrayList.get(51)) / distanceOfPoint((PointF) arrayList.get(45), (PointF) arrayList.get(49)), distanceOfPoint((PointF) arrayList2.get(47), (PointF) arrayList2.get(51)) / distanceOfPoint((PointF) arrayList2.get(45), (PointF) arrayList2.get(49)), 0.18f, 0.5f);
        fArr3[2] = getSimilarityOfValue(distanceOfPoint((PointF) arrayList.get(73), (PointF) arrayList.get(81)) / distanceOfPoint((PointF) arrayList.get(65), (PointF) arrayList.get(66)), distanceOfPoint((PointF) arrayList2.get(73), (PointF) arrayList2.get(81)) / distanceOfPoint((PointF) arrayList2.get(65), (PointF) arrayList2.get(66)), 0.05f, 0.6f);
        fArr3[3] = getSimilarityOfValue(fArr[0], fArr2[0], -15.0f, 15.0f);
        fArr3[4] = getSimilarityOfValue(fArr[1], fArr2[1], -20.0f, 20.0f);
        fArr3[5] = getSimilarityOfValue(fArr[2], fArr2[2], -15.0f, 15.0f);
        fArr3[6] = getSimilarityOfValue((((((PointF) arrayList.get(44)).x - ((PointF) arrayList.get(35)).x) / (((PointF) arrayList.get(39)).x - ((PointF) arrayList.get(35)).x)) + ((((PointF) arrayList.get(54)).x - ((PointF) arrayList.get(45)).x) / (((PointF) arrayList.get(49)).x - ((PointF) arrayList.get(45)).x))) / 2.0f, (((((PointF) arrayList2.get(54)).x - ((PointF) arrayList2.get(45)).x) / (((PointF) arrayList2.get(49)).x - ((PointF) arrayList2.get(45)).x)) + ((((PointF) arrayList2.get(44)).x - ((PointF) arrayList2.get(35)).x) / (((PointF) arrayList2.get(39)).x - ((PointF) arrayList2.get(35)).x))) / 2.0f, 0.25f, 0.75f);
        float f = 0.0f;
        float f2 = 0.0f;
        for (i = 0; i < 7; i++) {
            f = (float) (((double) f) + (dArr[i] * ((double) fArr3[i])));
            f2 = (float) (((double) f2) + dArr[i]);
        }
        float f3 = (f / f2) * 100.0f;
        AppMethodBeat.o(83801);
        return f3;
    }

    private static float distanceOfPoint(PointF pointF, PointF pointF2) {
        AppMethodBeat.i(83802);
        float sqrt = (float) Math.sqrt((double) (((pointF.x - pointF2.x) * (pointF.x - pointF2.x)) + ((pointF.y - pointF2.y) * (pointF.y - pointF2.y))));
        AppMethodBeat.o(83802);
        return sqrt;
    }

    private static float getSimilarityOfValue(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        AppMethodBeat.i(83803);
        if (f < f3) {
            f5 = f3;
        } else {
            f5 = f;
        }
        if (f5 > f4) {
            f6 = f4;
        } else {
            f6 = f5;
        }
        if (f2 < f3) {
            f5 = f3;
        } else {
            f5 = f2;
        }
        if (f5 > f4) {
            f5 = f4;
        }
        f5 = (Math.abs(f6 - f5) * 2.0f) / (f4 - f3);
        if (((double) f5) > 1.0d) {
            f5 = 1.0f;
        }
        f5 = 1.0f - smoothStep(f5);
        AppMethodBeat.o(83803);
        return f5;
    }

    private static float smoothStep(float f) {
        return (((f * f) * f) * f) * (((35.0f - (84.0f * f)) + ((70.0f * f) * f)) - (((20.0f * f) * f) * f));
    }
}
