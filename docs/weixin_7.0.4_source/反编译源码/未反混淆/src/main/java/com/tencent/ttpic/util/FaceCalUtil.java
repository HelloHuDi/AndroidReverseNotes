package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FaceCalUtil {
    private static final String TAG = FaceCalUtil.class.getSimpleName();

    public enum CAL_PARAM {
        FACE_WIDTH_SCALE_FACTOR(1.0f),
        EYE_DIST_SCALE_FACTOR(1.0f),
        EYE_WIDTH_SCALE_FACTOR(1.0f),
        EYE_HEIGHT_SCALE_FACTOR(1.0f),
        EYE_ANGLE_SCALE_FACTOR(1.0f),
        BROW_ANGLE_SCALE_FACTOR(1.0f),
        BROW_DIST_X_SCALE_FACTOR(1.0f),
        BROW_DIST_Y_SCALE_FACTOR(1.0f),
        BROW_WIDTH_SCALE_FACTOR(1.0f),
        BROW_HEIGHT_SCALE_FACTOR(1.0f),
        MOUTH_DIST_Y_SCALE_FACTOR(1.0f),
        MOUTH_WIDTH_SCALE_FACTOR(1.0f),
        MOUTH_HEIGHT_SCALE_FACTOR(1.0f),
        NOSE_DIST_Y_SCALE_FACTOR(1.0f),
        NOSE_WIDTH_SCALE_FACTOR(1.0f),
        NOSE_HEIGHT_SCALE_FACTOR(1.0f),
        FACE_V_SCALE_FACTOR(1.0f),
        POW_FACTOR(1.0f),
        POW_FACTOR_EYE(1.0f);
        
        public final float value;

        static {
            AppMethodBeat.o(83831);
        }

        private CAL_PARAM(float f) {
            this.value = f;
        }
    }

    static {
        AppMethodBeat.i(83865);
        AppMethodBeat.o(83865);
    }

    public static PointsWithTexcoords transToStSpace(List<PointF> list, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(83832);
        PointF[] rangePoints = getRangePoints(list);
        PointF pointF = new PointF(rangePoints[1].x - rangePoints[0].x, rangePoints[1].y - rangePoints[0].y);
        PointF pointF2 = new PointF(pointF.x * 1.5f, pointF.y * 1.5f);
        PointF pointF3 = new PointF(-pointF2.y, pointF2.x);
        PointF pointF4 = new PointF(((PointF) list.get(83)).x - (pointF3.x * 0.1f), ((PointF) list.get(83)).y - (pointF3.y * 0.1f));
        pointF = new PointF((pointF4.x - pointF2.x) - pointF3.x, (pointF4.y - pointF2.y) - pointF3.y);
        PointF pointF5 = new PointF((pointF4.x - pointF2.x) + pointF3.x, (pointF4.y - pointF2.y) + pointF3.y);
        PointF pointF6 = new PointF((pointF4.x + pointF2.x) + pointF3.x, (pointF4.y + pointF2.y) + pointF3.y);
        PointF pointF7 = new PointF((pointF4.x + pointF2.x) - pointF3.x, (pointF2.y + pointF4.y) - pointF3.y);
        updateFacePoints(list, pointF, pointF7, pointF5, i3, i4);
        pointF.x /= (float) i;
        pointF5.x /= (float) i;
        pointF6.x /= (float) i;
        pointF7.x /= (float) i;
        pointF.y /= (float) i2;
        pointF5.y /= (float) i2;
        pointF6.y /= (float) i2;
        pointF7.y /= (float) i2;
        PointsWithTexcoords pointsWithTexcoords = new PointsWithTexcoords(list, new float[]{pointF.x, pointF.y, pointF5.x, pointF5.y, pointF6.x, pointF6.y, pointF7.x, pointF7.y});
        AppMethodBeat.o(83832);
        return pointsWithTexcoords;
    }

    public static List<PointF> AlignFace(List<PointF> list, List<PointF> list2, int i) {
        AppMethodBeat.i(83833);
        float faceWidth = getFaceWidth(list) / getFaceWidth(list2);
        for (PointF pointF : list2) {
            pointF.x = ((pointF.x - ((float) (i / 2))) * faceWidth) + ((float) (i / 2));
        }
        AppMethodBeat.o(83833);
        return list2;
    }

    public static List<PointF> arrayToPointList(int[][] iArr) {
        AppMethodBeat.i(83834);
        ArrayList arrayList = new ArrayList();
        if (iArr == null) {
            AppMethodBeat.o(83834);
            return arrayList;
        }
        for (int i = 0; i < iArr.length; i++) {
            arrayList.add(new PointF((float) iArr[i][0], (float) iArr[i][1]));
        }
        AppMethodBeat.o(83834);
        return arrayList;
    }

    public static List<PointF> arrayToPointList(float[] fArr) {
        AppMethodBeat.i(83835);
        ArrayList arrayList = new ArrayList();
        if (fArr == null) {
            AppMethodBeat.o(83835);
            return arrayList;
        }
        for (int i = 0; i < fArr.length / 2; i++) {
            arrayList.add(new PointF(fArr[i * 2], fArr[(i * 2) + 1]));
        }
        AppMethodBeat.o(83835);
        return arrayList;
    }

    public static float getFaceScaleX(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83836);
        PointF middlePoint = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list2.get(8), (PointF) list2.get(10)), (PointF) list2.get(9));
        PointF middlePoint2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list.get(8), (PointF) list.get(10)), (PointF) list.get(9));
        float distance = AlgoUtils.getDistance((PointF) list2.get(83), middlePoint);
        float adjustValue = FaceItemCal.FACE_WIDTH.getAdjustValue((AlgoUtils.getDistance((PointF) list.get(83), middlePoint2) / getFaceWidth(list)) / (distance / getFaceWidth(list2))) * CAL_PARAM.FACE_WIDTH_SCALE_FACTOR.value;
        AppMethodBeat.o(83836);
        return adjustValue;
    }

    public static float getFaceScaleX2(List<PointF> list, List<PointF> list2) {
        return 0.0f;
    }

    public static float getDiffEyeX(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83837);
        float adjustValue = FaceItemCal.EYE_DIST_X.getAdjustValue((AlgoUtils.getDistance((PointF) list.get(43), (PointF) list.get(53)) / getFaceWidth(list)) / (AlgoUtils.getDistance((PointF) list2.get(43), (PointF) list2.get(53)) / getFaceWidth(list2))) * CAL_PARAM.EYE_DIST_SCALE_FACTOR.value;
        AppMethodBeat.o(83837);
        return adjustValue;
    }

    public static float getEyeScaleX(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83838);
        float faceWidth = getFaceWidth(list2);
        float faceWidth2 = getFaceWidth(list);
        float adjustValue = FaceItemCal.EYE_WIDTH.getAdjustValue((((AlgoUtils.getDistance((PointF) list.get(45), (PointF) list.get(49)) + AlgoUtils.getDistance((PointF) list.get(35), (PointF) list.get(39))) / 2.0f) / faceWidth2) / (((AlgoUtils.getDistance((PointF) list2.get(45), (PointF) list2.get(49)) + AlgoUtils.getDistance((PointF) list2.get(35), (PointF) list2.get(39))) / 2.0f) / faceWidth)) * CAL_PARAM.EYE_WIDTH_SCALE_FACTOR.value;
        AppMethodBeat.o(83838);
        return adjustValue;
    }

    public static float getEyeScaleY(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83839);
        PointF middlePoint = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list2.get(8), (PointF) list2.get(10)), (PointF) list2.get(9));
        PointF middlePoint2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list.get(8), (PointF) list.get(10)), (PointF) list.get(9));
        float distance = AlgoUtils.getDistance((PointF) list2.get(83), middlePoint);
        float distance2 = AlgoUtils.getDistance((PointF) list.get(83), middlePoint2);
        float adjustValue = FaceItemCal.EYE_HEIGHT.getAdjustValue((((AlgoUtils.getDistance((PointF) list.get(47), (PointF) list.get(51)) + AlgoUtils.getDistance((PointF) list.get(37), (PointF) list.get(41))) / 2.0f) / distance2) / (((AlgoUtils.getDistance((PointF) list2.get(47), (PointF) list2.get(51)) + AlgoUtils.getDistance((PointF) list2.get(37), (PointF) list2.get(41))) / 2.0f) / distance)) * CAL_PARAM.EYE_HEIGHT_SCALE_FACTOR.value;
        AppMethodBeat.o(83839);
        return adjustValue;
    }

    public static float getEyeAngle(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83840);
        PointF genVector = AlgoUtils.genVector((PointF) list.get(35), (PointF) list.get(39));
        PointF genVector2 = AlgoUtils.genVector((PointF) list2.get(35), (PointF) list2.get(39));
        float adjustValue = FaceItemCal.EYE_ANGLE.getAdjustValue((float) (Math.atan2((double) genVector.y, (double) genVector.x) - Math.atan2((double) genVector2.y, (double) genVector2.x))) * CAL_PARAM.EYE_ANGLE_SCALE_FACTOR.value;
        AppMethodBeat.o(83840);
        return adjustValue;
    }

    public static float getBrowAngle(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83841);
        PointF genVector = AlgoUtils.genVector((PointF) list.get(19), (PointF) list.get(23));
        PointF genVector2 = AlgoUtils.genVector((PointF) list2.get(19), (PointF) list2.get(23));
        float adjustValue = FaceItemCal.BROW_ANGLE.getAdjustValue((float) (Math.atan2((double) genVector.y, (double) genVector.x) - Math.atan2((double) genVector2.y, (double) genVector2.x))) * CAL_PARAM.BROW_ANGLE_SCALE_FACTOR.value;
        AppMethodBeat.o(83841);
        return adjustValue;
    }

    public static float getDiffBrowX(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83842);
        float adjustValue = FaceItemCal.BROW_DIST_X.getAdjustValue((AlgoUtils.getDistance((PointF) list.get(43), (PointF) list.get(53)) / AlgoUtils.getDistance((PointF) list.get(0), (PointF) list.get(18))) / (AlgoUtils.getDistance((PointF) list2.get(43), (PointF) list2.get(53)) / AlgoUtils.getDistance((PointF) list2.get(0), (PointF) list2.get(18)))) * CAL_PARAM.BROW_DIST_X_SCALE_FACTOR.value;
        AppMethodBeat.o(83842);
        return adjustValue;
    }

    public static float getDiffBrowY(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83843);
        PointF middlePoint = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list2.get(8), (PointF) list2.get(10)), (PointF) list2.get(9));
        PointF middlePoint2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list.get(8), (PointF) list.get(10)), (PointF) list.get(9));
        float distance = AlgoUtils.getDistance((PointF) list2.get(83), middlePoint);
        distance = (((PointF) list2.get(83)).y - ((((PointF) list2.get(34)).y + ((((((((((((PointF) list2.get(20)).y + ((PointF) list2.get(26)).y) + ((PointF) list2.get(21)).y) + ((PointF) list2.get(25)).y) + ((PointF) list2.get(22)).y) + ((PointF) list2.get(24)).y) + ((PointF) list2.get(30)).y) + ((PointF) list2.get(32)).y) + ((PointF) list2.get(29)).y) + ((PointF) list2.get(33)).y) + ((PointF) list2.get(28)).y)) / 12.0f)) / distance;
        float adjustValue = FaceItemCal.BROW_DIST_Y.getAdjustValue(((((PointF) list.get(83)).y - ((((PointF) list.get(34)).y + ((((((((((((PointF) list.get(20)).y + ((PointF) list.get(26)).y) + ((PointF) list.get(21)).y) + ((PointF) list.get(25)).y) + ((PointF) list.get(22)).y) + ((PointF) list.get(24)).y) + ((PointF) list.get(30)).y) + ((PointF) list.get(32)).y) + ((PointF) list.get(29)).y) + ((PointF) list.get(33)).y) + ((PointF) list.get(28)).y)) / 12.0f)) / AlgoUtils.getDistance((PointF) list.get(83), middlePoint2)) / distance) * CAL_PARAM.BROW_DIST_Y_SCALE_FACTOR.value;
        AppMethodBeat.o(83843);
        return adjustValue;
    }

    public static float getDiffBrowY2(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83844);
        float adjustValue = FaceItemCal.BROW_DIST_Y2.getAdjustValue(((((PointF) list.get(21)).y + ((PointF) list.get(25)).y) - (((PointF) list2.get(25)).y + ((PointF) list2.get(21)).y)) / 2.0f) * CAL_PARAM.BROW_DIST_Y_SCALE_FACTOR.value;
        AppMethodBeat.o(83844);
        return adjustValue;
    }

    public static float getDiffNoseY(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83845);
        PointF middlePoint = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list2.get(8), (PointF) list2.get(10)), (PointF) list2.get(9));
        PointF middlePoint2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list.get(8), (PointF) list.get(10)), (PointF) list.get(9));
        float distance = AlgoUtils.getDistance((PointF) list2.get(83), middlePoint);
        distance = AlgoUtils.getDistance((PointF) list2.get(83), (PointF) list2.get(59)) / distance;
        float adjustValue = FaceItemCal.NOSE_DIST_Y.getAdjustValue((AlgoUtils.getDistance((PointF) list.get(83), (PointF) list.get(59)) / AlgoUtils.getDistance((PointF) list.get(83), middlePoint2)) / distance) * CAL_PARAM.NOSE_DIST_Y_SCALE_FACTOR.value;
        AppMethodBeat.o(83845);
        return adjustValue;
    }

    public static float getDiffNoseY2(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83846);
        float adjustValue = FaceItemCal.NOSE_DIST_Y2.getAdjustValue(((PointF) list.get(59)).y - ((PointF) list2.get(59)).y) * CAL_PARAM.NOSE_DIST_Y_SCALE_FACTOR.value;
        AppMethodBeat.o(83846);
        return adjustValue;
    }

    public static float getNoseScaleX(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83847);
        float faceWidth = getFaceWidth(list2);
        faceWidth = AlgoUtils.getDistance((PointF) list2.get(57), (PointF) list2.get(61)) / faceWidth;
        float adjustValue = FaceItemCal.NOSE_WIDTH.getAdjustValue((AlgoUtils.getDistance((PointF) list.get(57), (PointF) list.get(61)) / getFaceWidth(list)) / faceWidth) * CAL_PARAM.NOSE_WIDTH_SCALE_FACTOR.value;
        AppMethodBeat.o(83847);
        return adjustValue;
    }

    public static float getDiffMouthY(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83848);
        PointF middlePoint = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list2.get(8), (PointF) list2.get(10)), (PointF) list2.get(9));
        PointF middlePoint2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list.get(8), (PointF) list.get(10)), (PointF) list.get(9));
        float distance = AlgoUtils.getDistance((PointF) list2.get(59), middlePoint);
        distance = (((((PointF) list2.get(73)).y + ((PointF) list2.get(81)).y) - (((PointF) list2.get(59)).y * 2.0f)) / 2.0f) / distance;
        float adjustValue = FaceItemCal.MOUTH_DIST_Y.getAdjustValue(((((((PointF) list.get(73)).y + ((PointF) list.get(81)).y) - (((PointF) list.get(59)).y * 2.0f)) / 2.0f) / AlgoUtils.getDistance((PointF) list.get(59), middlePoint2)) / distance) * CAL_PARAM.MOUTH_DIST_Y_SCALE_FACTOR.value;
        AppMethodBeat.o(83848);
        return adjustValue;
    }

    public static float getDiffMouthY2(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83849);
        float adjustValue = FaceItemCal.MOUTH_DIST_Y2.getAdjustValue(((((PointF) list.get(77)).y + ((PointF) list.get(69)).y) - (((PointF) list2.get(69)).y + ((PointF) list2.get(77)).y)) / 2.0f) * CAL_PARAM.MOUTH_DIST_Y_SCALE_FACTOR.value;
        AppMethodBeat.o(83849);
        return adjustValue;
    }

    public static float getMouthScaleX(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83850);
        float faceWidth = getFaceWidth(list2);
        faceWidth = AlgoUtils.getDistance((PointF) list2.get(65), (PointF) list2.get(66)) / faceWidth;
        float adjustValue = FaceItemCal.MOUTH_WIDTH.getAdjustValue((AlgoUtils.getDistance((PointF) list.get(65), (PointF) list.get(66)) / getFaceWidth(list)) / faceWidth) * CAL_PARAM.MOUTH_WIDTH_SCALE_FACTOR.value;
        AppMethodBeat.o(83850);
        return adjustValue;
    }

    public static float getMouthScaleY(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83851);
        PointF middlePoint = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list2.get(8), (PointF) list2.get(10)), (PointF) list2.get(9));
        PointF middlePoint2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list.get(8), (PointF) list.get(10)), (PointF) list.get(9));
        float distance = AlgoUtils.getDistance((PointF) list2.get(83), middlePoint);
        distance = ((((((PointF) list2.get(69)).y * 2.0f) - ((PointF) list2.get(76)).y) - ((PointF) list2.get(78)).y) / 2.0f) / distance;
        float adjustValue = FaceItemCal.MOUTH_HEIGHT.getAdjustValue((((((((PointF) list.get(69)).y * 2.0f) - ((PointF) list.get(76)).y) - ((PointF) list.get(78)).y) / 2.0f) / AlgoUtils.getDistance((PointF) list.get(83), middlePoint2)) / distance) * CAL_PARAM.MOUTH_HEIGHT_SCALE_FACTOR.value;
        AppMethodBeat.o(83851);
        return adjustValue;
    }

    public static float getFaceVLevel(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83852);
        float faceOutlineDist = getFaceOutlineDist(list);
        float faceOutlineDist2 = getFaceOutlineDist(list2);
        faceOutlineDist = FaceItemCal.FACE_V.getAdjustValue((faceOutlineDist / getFaceWidth(list)) / (faceOutlineDist2 / getFaceWidth(list2))) * CAL_PARAM.FACE_V_SCALE_FACTOR.value;
        AppMethodBeat.o(83852);
        return faceOutlineDist;
    }

    public static float getFaceVLevel1(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83853);
        float adjustValue = FaceItemCal.FACE_V.getAdjustValue((float) (getFaceAngle(list) / getFaceAngle(list2))) * CAL_PARAM.FACE_V_SCALE_FACTOR.value;
        AppMethodBeat.o(83853);
        return adjustValue;
    }

    public static float getFaceJawLevel(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(83854);
        float adjustValue = FaceItemCal.FACE_JAW.getAdjustValue(AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list.get(8), (PointF) list.get(10)), (PointF) list.get(9)).y - AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF) list2.get(8), (PointF) list2.get(10)), (PointF) list2.get(9)).y) * CAL_PARAM.MOUTH_DIST_Y_SCALE_FACTOR.value;
        AppMethodBeat.o(83854);
        return adjustValue;
    }

    public static double getFaceAngle(List<PointF> list) {
        AppMethodBeat.i(83855);
        List faceOutlinePoints = getFaceOutlinePoints(list, true);
        List faceOutlinePoints2 = getFaceOutlinePoints(list, false);
        float[] linearRegression = AlgoUtils.linearRegression(faceOutlinePoints);
        float[] linearRegression2 = AlgoUtils.linearRegression(faceOutlinePoints2);
        double atan2 = 3.141592653589793d - Math.atan2((double) (linearRegression[0] - linearRegression2[0]), (double) ((linearRegression[0] * linearRegression2[0]) + 1.0f));
        AppMethodBeat.o(83855);
        return atan2;
    }

    private static List<PointF> getFaceOutlinePoints(List<PointF> list, boolean z) {
        AppMethodBeat.i(83856);
        ArrayList arrayList = new ArrayList();
        int i = 2;
        while (i <= 5) {
            arrayList.add(list.get(z ? i : 18 - i));
            i++;
        }
        AppMethodBeat.o(83856);
        return arrayList;
    }

    private static float getFaceOutlineDist(List<PointF> list) {
        AppMethodBeat.i(83857);
        float f = 0.0f;
        int i = 2;
        while (true) {
            int i2 = i;
            float f2 = f;
            if (i2 <= 7) {
                f = f2 + AlgoUtils.getDistance((PointF) list.get(i2), (PointF) list.get(18 - i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(83857);
                return f2;
            }
        }
    }

    public static float getFaceWidth(List<PointF> list) {
        AppMethodBeat.i(83858);
        float distance = AlgoUtils.getDistance((PointF) list.get(0), (PointF) list.get(18));
        float distance2 = AlgoUtils.getDistance((PointF) list.get(1), (PointF) list.get(17));
        float max = Math.max(Math.max(distance, distance2), AlgoUtils.getDistance((PointF) list.get(2), (PointF) list.get(16)));
        AppMethodBeat.o(83858);
        return max;
    }

    public static PointF[] getRangePoints(List<PointF> list) {
        AppMethodBeat.i(83859);
        float faceWidth = getFaceWidth(list);
        float distance = AlgoUtils.getDistance((PointF) list.get(0), (PointF) list.get(18));
        float distance2 = AlgoUtils.getDistance((PointF) list.get(1), (PointF) list.get(17));
        AlgoUtils.getDistance((PointF) list.get(2), (PointF) list.get(16));
        PointF[] pointFArr;
        if (Float.compare(faceWidth, distance) == 0) {
            pointFArr = new PointF[]{(PointF) list.get(0), (PointF) list.get(18)};
            AppMethodBeat.o(83859);
            return pointFArr;
        } else if (Float.compare(faceWidth, distance2) == 0) {
            pointFArr = new PointF[]{(PointF) list.get(1), (PointF) list.get(17)};
            AppMethodBeat.o(83859);
            return pointFArr;
        } else {
            pointFArr = new PointF[]{(PointF) list.get(2), (PointF) list.get(16)};
            AppMethodBeat.o(83859);
            return pointFArr;
        }
    }

    public static void updateFacePoints(List<PointF> list, PointF pointF, PointF pointF2, PointF pointF3, int i, int i2) {
        AppMethodBeat.i(83860);
        float distance = AlgoUtils.getDistance(pointF, pointF2);
        float distance2 = AlgoUtils.getDistance(pointF, pointF3);
        float f = ((float) i) / distance;
        float f2 = ((float) i2) / distance2;
        for (int i3 = 0; i3 < 83; i3++) {
            ((PointF) list.get(i3)).set(f * AlgoUtils.distanceOfPoint2Line(pointF, pointF3, distance2, (PointF) list.get(i3)), f2 * AlgoUtils.distanceOfPoint2Line(pointF, pointF2, distance, (PointF) list.get(i3)));
        }
        while (list.size() > 83) {
            list.remove(list.size() - 1);
        }
        facePointf83to90(list);
        AppMethodBeat.o(83860);
    }

    public static List<PointF> facePointf83to90(List<PointF> list) {
        AppMethodBeat.i(83861);
        if (list == null || list.size() < 83) {
            AppMethodBeat.o(83861);
        } else {
            while (list.size() < 90) {
                list.add(new PointF());
            }
            while (list.size() > 90) {
                list.remove(list.size() - 1);
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
            AppMethodBeat.o(83861);
        }
        return list;
    }

    public static float[] toFlatArray(List<PointF> list) {
        int i = 0;
        AppMethodBeat.i(83862);
        if (list == null) {
            float[] fArr = new float[0];
            AppMethodBeat.o(83862);
            return fArr;
        }
        float[] fArr2 = new float[(list.size() * 2)];
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                PointF pointF = (PointF) list.get(i2);
                if (pointF != null) {
                    fArr2[i2 * 2] = pointF.x;
                    fArr2[(i2 * 2) + 1] = pointF.y;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(83862);
                return fArr2;
            }
        }
    }

    public static void printPoints(List<PointF> list) {
        AppMethodBeat.i(83863);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[facePoints] ");
        for (PointF pointF : list) {
            stringBuilder.append(pointF.x + "f, " + pointF.y + "f, ");
        }
        AppMethodBeat.o(83863);
    }

    public static void printPoints(int[][] iArr) {
        AppMethodBeat.i(83864);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[facePoints] ");
        for (int[] iArr2 : iArr) {
            stringBuilder.append(iArr2[0] + ", " + iArr2[1] + ", ");
        }
        AppMethodBeat.o(83864);
    }
}
