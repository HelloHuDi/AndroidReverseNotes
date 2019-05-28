package com.tencent.ttpic.util;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.FILL_STYLE;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.SizeI;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlgoUtils {
    private static final Random mRandom = new Random(System.currentTimeMillis());

    public static native void RGBA2YUV420SP(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void RGBA2YUV420SP2(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void RGBA2YUV420SP3(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void YUVNV21TORGBA(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    public static native void YUVX2YUV(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void nativeRotatePlane(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void nativeScalePlane(byte[] bArr, byte[] bArr2, int i, int i2, float f, float f2, boolean z, boolean z2);

    static {
        AppMethodBeat.m2504i(50255);
        AppMethodBeat.m2505o(50255);
    }

    public static float[] calPositions(float f, float f2, float f3, float f4, int i, int i2) {
        float f5 = ((f / ((float) i)) * 2.0f) - 1.0f;
        float f6 = ((f2 / ((float) i2)) * 2.0f) - 1.0f;
        float f7 = ((f3 / ((float) i)) * 2.0f) - 1.0f;
        float f8 = ((f4 / ((float) i2)) * 2.0f) - 1.0f;
        return new float[]{f5, f8, f5, f6, f7, f6, f7, f8};
    }

    public static float[] calPositionsTriangles(float f, float f2, float f3, float f4, int i, int i2) {
        float f5 = ((f / ((float) i)) * 2.0f) - 1.0f;
        float f6 = ((f2 / ((float) i2)) * 2.0f) - 1.0f;
        float f7 = ((f3 / ((float) i)) * 2.0f) - 1.0f;
        float f8 = ((f4 / ((float) i2)) * 2.0f) - 1.0f;
        return new float[]{f5, f6, f5, f8, f7, f8, f5, f6, f7, f8, f7, f6};
    }

    public static float[] calTexCoords(int i, int i2, double d) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (((double) i) / ((double) i2) >= d) {
            i3 = (int) (((double) i2) * d);
            i4 = (i - i3) / 2;
            i3 += i4;
            i5 = 0;
            i6 = i2;
        } else {
            i3 = (int) (((double) i) / d);
            i5 = (i2 - i3) / 2;
            i6 = i5 + i3;
            i3 = i;
            i4 = 0;
        }
        float f = ((float) i4) / ((float) i);
        float f2 = ((float) i3) / ((float) i);
        float f3 = ((float) i6) / ((float) i2);
        float f4 = ((float) i5) / ((float) i2);
        return new float[]{f, f4, f, f3, f2, f3, f2, f4};
    }

    public static float[] calTexCoords(int i, int i2, int i3, double d) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (i3 == 90 || i3 == 270) {
            i4 = i;
            i5 = i2;
        } else {
            i4 = i2;
            i5 = i;
        }
        if (((double) i5) / ((double) i4) >= d) {
            i6 = (int) (((double) i4) * d);
            i7 = (i5 - i6) / 2;
            i8 = i7 + i6;
            i6 = 0;
            i9 = i4;
        } else {
            i9 = (int) (((double) i5) / d);
            i6 = (i4 - i9) / 2;
            i9 += i6;
            i8 = i5;
            i7 = 0;
        }
        float f = ((float) i7) / ((float) i5);
        float f2 = ((float) i8) / ((float) i5);
        float f3 = ((float) i9) / ((float) i4);
        float f4 = ((float) i6) / ((float) i4);
        return new float[]{f, f4, f, f3, f2, f3, f2, f4};
    }

    public static float[] calPositions(Rect rect, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(50237);
        int i6;
        float[] calPositions;
        if (i5 == FILL_STYLE.SPACE.value) {
            SizeI calSpaceAspectSize = calSpaceAspectSize(i, i2, rect.width, rect.height);
            int i7 = rect.f1681x + ((rect.width - calSpaceAspectSize.width) / 2);
            i6 = ((rect.height - calSpaceAspectSize.height) / 2) + rect.f1682y;
            int i8 = i6 + calSpaceAspectSize.height;
            calPositions = calPositions((float) i7, (float) i8, (float) (calSpaceAspectSize.width + i7), (float) i6, i3, i4);
            AppMethodBeat.m2505o(50237);
            return calPositions;
        }
        int i9 = rect.f1681x;
        i6 = rect.f1682y;
        calPositions = calPositions((float) i9, (float) (rect.height + i6), (float) (i9 + rect.width), (float) i6, i3, i4);
        AppMethodBeat.m2505o(50237);
        return calPositions;
    }

    public static float[] calTexCords(Rect rect, int i, int i2, int i3) {
        AppMethodBeat.m2504i(50238);
        float[] calTexCoords;
        if (i3 == FILL_STYLE.CUT.value || i3 == FILL_STYLE.FRAME_STYLE_CUT.value) {
            calTexCoords = calTexCoords(i, i2, ((double) rect.width) / ((double) rect.height));
            AppMethodBeat.m2505o(50238);
            return calTexCoords;
        }
        calTexCoords = GlUtil.ORIGIN_TEX_COORDS;
        AppMethodBeat.m2505o(50238);
        return calTexCoords;
    }

    private static SizeI calCutAspectSize(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(50239);
        double d = ((double) i) / ((double) i2);
        double d2 = (double) i4;
        double d3 = (double) ((int) (d2 * d));
        if (d3 < ((double) i3)) {
            d3 = (double) i3;
            d2 = d3 / d;
        }
        SizeI sizeI = new SizeI((int) d3, (int) d2);
        AppMethodBeat.m2505o(50239);
        return sizeI;
    }

    private static SizeI calSpaceAspectSize(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(50240);
        double d = ((double) i) / ((double) i2);
        double d2 = (double) i4;
        double d3 = (double) ((int) (d2 * d));
        if (d3 > ((double) i3)) {
            d3 = (double) i3;
            d2 = d3 / d;
        }
        SizeI sizeI = new SizeI((int) d3, (int) d2);
        AppMethodBeat.m2505o(50240);
        return sizeI;
    }

    public static SizeI calCutSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(50241);
        SizeI sizeI;
        if (((double) i) / ((double) i2) >= d) {
            sizeI = new SizeI((int) (((double) i2) * d), i2);
            AppMethodBeat.m2505o(50241);
            return sizeI;
        }
        sizeI = new SizeI(i, (int) (((double) i) / d));
        AppMethodBeat.m2505o(50241);
        return sizeI;
    }

    public static float getDistance(PointF pointF, PointF pointF2) {
        AppMethodBeat.m2504i(50242);
        if (pointF == null || pointF2 == null) {
            AppMethodBeat.m2505o(50242);
            return 0.0f;
        }
        double d = (double) (pointF.x - pointF2.x);
        double d2 = (double) (pointF.y - pointF2.y);
        float sqrt = (float) Math.sqrt((d * d) + (d2 * d2));
        AppMethodBeat.m2505o(50242);
        return sqrt;
    }

    public static float distanceOfPoint2Line(PointF pointF, PointF pointF2, float f, PointF pointF3) {
        AppMethodBeat.m2504i(50243);
        float distance = getDistance(pointF, pointF3);
        float distance2 = getDistance(pointF2, pointF3);
        float f2 = ((f + distance) + distance2) / 2.0f;
        distance = ((f2 - distance) * ((f2 - f) * f2)) * (f2 - distance2);
        if (((double) distance) < 1.0E-6d) {
            AppMethodBeat.m2505o(50243);
            return 0.0f;
        }
        distance = (((float) Math.sqrt((double) distance)) * 2.0f) / f;
        AppMethodBeat.m2505o(50243);
        return distance;
    }

    public static PointF middlePoint(PointF pointF, PointF pointF2) {
        AppMethodBeat.m2504i(50244);
        PointF pointF3;
        if (pointF == null || pointF2 == null) {
            pointF3 = new PointF();
            AppMethodBeat.m2505o(50244);
            return pointF3;
        }
        pointF3 = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        AppMethodBeat.m2505o(50244);
        return pointF3;
    }

    public static List<Float> substract(List<Float> list, float[] fArr) {
        AppMethodBeat.m2504i(50245);
        ArrayList arrayList = new ArrayList();
        if (list == null || fArr == null) {
            AppMethodBeat.m2505o(50245);
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < Math.min(list.size(), fArr.length)) {
                arrayList.add(Float.valueOf(((Float) list.get(i2)).floatValue() - fArr[i2]));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(50245);
                return arrayList;
            }
        }
    }

    public static List<FaceStatus> rotateFaceStatusFor3D(List<FaceStatus> list, int i, int i2, int i3) {
        AppMethodBeat.m2504i(50246);
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                FaceStatus faceStatus = (FaceStatus) list.get(i4);
                i3 = (i3 + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                float f;
                if (i3 == 90) {
                    f = faceStatus.pitch;
                    faceStatus.pitch = -faceStatus.yaw;
                    faceStatus.yaw = f;
                    faceStatus.roll += (float) i3;
                } else if (i3 == 180) {
                    faceStatus.pitch = -faceStatus.pitch;
                    faceStatus.yaw = -faceStatus.yaw;
                    faceStatus.roll += (float) i3;
                } else if (i3 == 270) {
                    f = faceStatus.pitch;
                    faceStatus.pitch = faceStatus.yaw;
                    faceStatus.yaw = -f;
                    faceStatus.roll += (float) i3;
                }
                Matrix matrix = new Matrix();
                matrix.reset();
                matrix.postTranslate(((float) (-i)) / 2.0f, ((float) (-i2)) / 2.0f);
                matrix.postRotate((float) i3, 0.0f, 0.0f);
                if (i3 == 90 || i3 == 270) {
                    matrix.postTranslate(((float) i2) / 2.0f, ((float) i) / 2.0f);
                } else {
                    matrix.postTranslate(((float) i) / 2.0f, ((float) i2) / 2.0f);
                }
                r4 = new float[2];
                float[] fArr = new float[]{faceStatus.f16557tx, faceStatus.f16558ty};
                matrix.mapPoints(fArr, r4);
                faceStatus.f16557tx = fArr[0];
                faceStatus.f16558ty = fArr[1];
            }
        }
        AppMethodBeat.m2505o(50246);
        return list;
    }

    public static List<List<PointF>> rotatePointsForList(List<List<PointF>> list, int i, int i2, int i3) {
        AppMethodBeat.m2504i(50247);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(50247);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        for (List rotatePoints : list) {
            arrayList2.add(rotatePoints(rotatePoints, i, i2, i3));
        }
        AppMethodBeat.m2505o(50247);
        return arrayList2;
    }

    public static List<PointF> rotatePoints(List<PointF> list, int i, int i2, int i3) {
        AppMethodBeat.m2504i(50248);
        if (list == null) {
            AppMethodBeat.m2505o(50248);
            return null;
        }
        int i4 = (i3 + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postTranslate(((float) (-i)) / 2.0f, ((float) (-i2)) / 2.0f);
        matrix.postRotate((float) i4, 0.0f, 0.0f);
        if (i4 == 90 || i4 == 270) {
            matrix.postTranslate(((float) i2) / 2.0f, ((float) i) / 2.0f);
        } else {
            matrix.postTranslate(((float) i) / 2.0f, ((float) i2) / 2.0f);
        }
        float[] fArr = new float[2];
        float[] fArr2 = new float[2];
        for (PointF pointF : list) {
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            matrix.mapPoints(fArr2, fArr);
            pointF.x = fArr2[0];
            pointF.y = fArr2[1];
        }
        AppMethodBeat.m2505o(50248);
        return list;
    }

    public static List<float[]> rotateAngles(List<float[]> list, int i) {
        AppMethodBeat.m2504i(50249);
        if (list == null) {
            AppMethodBeat.m2505o(50249);
            return null;
        }
        int i2 = (i + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        ArrayList arrayList = new ArrayList(list.size());
        for (float[] fArr : list) {
            if (i2 == 90 || i2 == 270) {
                arrayList.add(new float[]{-fArr[1], -fArr[0], (float) (((double) fArr[2]) + ((((double) i2) * 3.141592653589793d) / 180.0d))});
            } else {
                arrayList.add(new float[]{fArr[0], fArr[1], (float) (((double) fArr[2]) + ((((double) i2) * 3.141592653589793d) / 180.0d))});
            }
        }
        AppMethodBeat.m2505o(50249);
        return arrayList;
    }

    public static PointF genVector(PointF pointF, PointF pointF2) {
        AppMethodBeat.m2504i(50250);
        PointF pointF3 = new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y);
        AppMethodBeat.m2505o(50250);
        return pointF3;
    }

    public static float[] linearRegression(List<PointF> list) {
        int i;
        AppMethodBeat.m2504i(50251);
        float f = 0.0f;
        float f2 = 0.0f;
        for (i = 0; i < list.size(); i++) {
            f2 += ((PointF) list.get(i)).x;
            f += ((PointF) list.get(i)).y;
        }
        float size = f2 / ((float) list.size());
        float size2 = f / ((float) list.size());
        i = 0;
        f = 0.0f;
        f2 = 0.0f;
        while (i < list.size()) {
            float f3 = ((PointF) list.get(i)).x;
            f2 += (((PointF) list.get(i)).y - size2) * (f3 - size);
            i++;
            f += (f3 - size) * (f3 - size);
        }
        float f4 = size2 - ((f2 / f) * size);
        float[] fArr = new float[]{f2 / f, f4};
        AppMethodBeat.m2505o(50251);
        return fArr;
    }

    public static List<PointF> mapPoints(List<PointF> list, Matrix matrix) {
        AppMethodBeat.m2504i(50252);
        float[] fArr = new float[2];
        float[] fArr2 = new float[2];
        for (PointF pointF : list) {
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            matrix.mapPoints(fArr2, fArr);
            pointF.x = fArr2[0];
            pointF.y = fArr2[1];
        }
        AppMethodBeat.m2505o(50252);
        return list;
    }

    public static int randValueDiff(int i, int i2) {
        int i3 = 1;
        AppMethodBeat.m2504i(50253);
        if (i2 <= 1) {
            AppMethodBeat.m2505o(50253);
        } else {
            do {
                i3 = mRandom.nextInt(i2) + 1;
            } while (i == i3);
            AppMethodBeat.m2505o(50253);
        }
        return i3;
    }

    public static float[] adjustPosition(float[] fArr, float f) {
        int i = 0;
        float f2 = (fArr[0] + fArr[4]) / 2.0f;
        float f3 = (fArr[1] + fArr[3]) / 2.0f;
        while (i < fArr.length / 2) {
            fArr[i * 2] = ((fArr[i * 2] - f2) * f) + f2;
            fArr[(i * 2) + 1] = ((fArr[(i * 2) + 1] - f3) * f) + f3;
            i++;
        }
        return fArr;
    }

    public static float[] adjustPosition(float[] fArr, float f, double[] dArr, int i) {
        int i2 = 0;
        float f2 = fArr[0] + ((fArr[4] - fArr[0]) * ((float) dArr[0]));
        float f3 = fArr[3] + ((fArr[1] - fArr[3]) * ((float) dArr[1]));
        if (i == 0) {
            while (i2 < fArr.length / 2) {
                fArr[i2 * 2] = ((fArr[i2 * 2] - f2) * f) + f2;
                fArr[(i2 * 2) + 1] = ((fArr[(i2 * 2) + 1] - f3) * f) + f3;
                i2++;
            }
        } else if (i == 1) {
            while (i2 < fArr.length / 2) {
                fArr[(i2 * 2) + 1] = ((fArr[(i2 * 2) + 1] - f3) * f) + f3;
                i2++;
            }
        } else if (i == 2) {
            while (i2 < fArr.length / 2) {
                fArr[i2 * 2] = ((fArr[i2 * 2] - f2) * f) + f2;
                i2++;
            }
        }
        return fArr;
    }

    public static float[] adjustPositionTriangles(float[] fArr, float f, double[] dArr, int i) {
        int i2 = 0;
        float f2 = fArr[0] + ((fArr[10] - fArr[0]) * ((float) dArr[0]));
        float f3 = fArr[1] + ((fArr[3] - fArr[1]) * ((float) dArr[1]));
        if (i == 0) {
            while (i2 < fArr.length / 2) {
                fArr[i2 * 2] = ((fArr[i2 * 2] - f2) * f) + f2;
                fArr[(i2 * 2) + 1] = ((fArr[(i2 * 2) + 1] - f3) * f) + f3;
                i2++;
            }
        } else if (i == 1) {
            while (i2 < fArr.length / 2) {
                fArr[(i2 * 2) + 1] = ((fArr[(i2 * 2) + 1] - f3) * f) + f3;
                i2++;
            }
        } else if (i == 2) {
            while (i2 < fArr.length / 2) {
                fArr[i2 * 2] = ((fArr[i2 * 2] - f2) * f) + f2;
                i2++;
            }
        }
        return fArr;
    }

    public static RectF getFaceRectF(List<PointF> list) {
        AppMethodBeat.m2504i(50254);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(50254);
            return null;
        }
        float f = Float.MIN_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MIN_VALUE;
        float f4 = Float.MAX_VALUE;
        for (PointF pointF : list) {
            f4 = Math.min(f4, pointF.x);
            float max = Math.max(f3, pointF.x);
            f2 = Math.min(f2, pointF.y);
            f = Math.max(f, pointF.y);
            f3 = max;
        }
        RectF rectF = new RectF(f4, f2, f3, f);
        AppMethodBeat.m2505o(50254);
        return rectF;
    }
}
