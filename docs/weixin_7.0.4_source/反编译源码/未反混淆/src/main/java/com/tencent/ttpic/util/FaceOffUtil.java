package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.view.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FaceOffUtil {
    private static final String COORDS_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/coords/crazyface.tsv";
    private static final String COORDS_FILE_FACE_HEAD_CROP = "assets://camera/camera_video/faceOff/coords/faceheadcropgray.tsv";
    private static final String COORDS_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/coords/faceMask_skin.tsv";
    private static final String COORDS_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    private static final String COORDS_FILE_NO_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    private static PointF EMPTY_POINT = new PointF();
    public static final int[] FaceMeshTriangles = new int[]{19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, d.MIC_AVROUND_BLUR, 40, d.MIC_AVROUND_BLUR, 41, d.MIC_ALPHA_ADJUST_REAL, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 107, 57, 65, 19, 111, 90, 20, 19, 26, 21, 25, 22, 58, 64, 59, 64, 58, 57, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, GmsClientSupervisor.DEFAULT_BIND_FLAGS, d.MIC_SketchMark, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 51, 50, 21, 22, d.MIC_ALPHA_ADJUST_REAL, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, d.MIC_SketchMark, 47, 52, 46, 52, 47, 51, 31, 30, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, d.MIC_ALPHA_ADJUST_REAL, 41, d.MIC_ALPHA_ADJUST_REAL, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, d.MIC_AVROUND_BLUR, 61, 64, 62, 64, 61, 60, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 84, 63, 83, d.MIC_AVROUND_BLUR, d.MIC_ALPHA_ADJUST_REAL, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, d.MIC_SketchMark, 130, 51, 130, d.MIC_SketchMark, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 64, 60, 59, 48, 47, 123, 71, 11, 70, 31, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, d.MIC_SketchMark, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 83, 56, 55, 56, 83, 62, 64, 57, 56, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 56, 62, 64, 124, 125, 49, 63, 62, 83, 83, 55, 84, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, d.MIC_AVROUND_BLUR, 125, 63, 126, 50, 126, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100};
    public static final int[] FaceMeshTrianglesFaceAverage = new int[]{0, 1, 35, 1, 35, 36, 35, 36, 42, 20, 35, 42, 19, 20, 35, 19, 20, 26, 19, 26, 96, 19, 90, 96, 26, 95, 96, 25, 26, 95, 21, 25, 26, 20, 21, 26, 20, 21, 42, 21, 41, 42, 41, 42, 43, 36, 42, 43, 36, 37, 43, 36, 37, 57, 2, 36, 57, 2, 3, 57, 3, 4, 65, 4, 5, 65, 5, 65, 67, 5, 6, 67, 6, 7, 67, 7, 67, 68, 7, 8, 68, 8, 68, 69, 68, 69, 73, 68, 73, 74, 67, 68, 74, 65, 67, 74, 65, 75, 82, 57, 58, 75, 58, 75, 76, 75, 76, 82, 65, 74, 82, 74, 81, 82, 73, 74, 81, 70, 72, 73, 69, 70, 73, 10, 69, 70, 9, 10, 69, 8, 9, 69, 10, 11, 70, 12, 13, 71, 13, 66, 71, 13, 14, 66, 14, 15, 66, 60, 61, 79, 59, 60, 64, 59, 60, 78, 59, 77, 78, 76, 77, 81, 59, 76, 77, 58, 59, 76, 58, 59, 64, 56, 58, 64, 56, 57, 58, 37, 38, 43, 38, 40, 43, 38, 39, 40, 38, 39, 56, 39, 55, 56, 23, 39, 55, 56, 62, 64, 47, 61, 62, 46, 47, 61, 15, 16, 61, 17, 45, 46, 17, 18, 45, 27, 28, 45, 28, 45, 52, 28, 29, 52, 29, 51, 52, 29, 50, 51, 50, 51, 53, 48, 50, 53, 48, 49, 50, 31, 49, 63, 47, 48, 62, 47, 48, 53, 45, 46, 52, 51, 52, 53, 30, 31, 32, 31, 32, 94, 32, 92, 94, 32, 33, 92, 29, 30, 50, 27, 28, 34, 27, 34, 93, 27, 91, 93, 34, 92, 93, 33, 34, 92, 23, 31, 94, 23, 24, 94, 22, 23, 24, 21, 22, 24, 40, 41, 43, 22, 39, 40, 22, 23, 39, 21, 24, 25, 24, 25, 95, 24, 94, 95, 76, 81, 82, 78, 79, 80, 66, 72, 80, 66, 79, 80, 66, 71, 72, 70, 71, 72, 60, 78, 79, 1, 2, 36, 95, 96, 99, 92, 93, 105, 91, 104, 105, 14, 103, 104, 11, 102, 103, 7, 101, 102, 4, 100, 101, 90, 99, 100, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 92, 105, 106, 92, 94, 106, 94, 95, 106, 95, 99, 106, 90, 96, 99, 0, 90, 100, 21, 40, 41, 21, 22, 40, 23, 31, 83, 23, 55, 83, 31, 63, 83, 55, 56, 83, 56, 62, 83, 62, 63, 83, 49, 62, 63, 48, 49, 62, 30, 31, 49, 30, 49, 50, 29, 30, 32, 29, 32, 33, 29, 33, 34, 28, 29, 34, 46, 52, 53, 46, 47, 53, 37, 38, 56, 37, 56, 57, 60, 62, 64, 60, 61, 62, 16, 46, 61, 16, 17, 46, 77, 78, 81, 78, 80, 81, 72, 80, 81, 72, 73, 81, 11, 70, 71, 11, 12, 71, 0, 19, 90, 0, 19, 35, 18, 27, 91, 18, 27, 45, 3, 57, 65, 57, 65, 75, 61, 66, 79, 15, 61, 66};
    private static String GRAY_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/grayImages/crazyfacegray.png";
    private static String GRAY_FILE_CROP_HEAD_FACE = "assets://camera/camera_video/faceOff/grayImages/faceheadcropgray.png";
    private static String GRAY_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/grayImages/faceMask_skin.png";
    private static String GRAY_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/grayImages/noeyegray.png";
    private static String GRAY_FILE_NO_EYE = "assets://camera/camera_video/faceOff/grayImages/nomouthgray.png";
    public static final int IRIS_TRIANGLE_COUNT = 8;
    public static final int[] IrisMeshTriangles = new int[]{0, 1, 2, 0, 2, 3, 0, 3, 4, 0, 4, 1, 5, 6, 7, 5, 7, 8, 5, 8, 9, 5, 9, 6};
    public static final int NO_HOLE_TRIANGLE_COUNT = 230;
    public static final int NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE = 184;
    private static final String TAG = FaceOffUtil.class.getSimpleName();

    public enum FEATURE_TYPE {
        NO_EYE(0),
        HAS_EYE(1),
        CRAZY_FACE(2),
        FACE_HEAD_CROP(3),
        FACE_SKIN(4);
        
        public int value;

        static {
            AppMethodBeat.o(83886);
        }

        private FEATURE_TYPE(int i) {
            this.value = i;
        }
    }

    static {
        AppMethodBeat.i(83910);
        AppMethodBeat.o(83910);
    }

    public static List<PointF> loadTexCoords(String str) {
        AppMethodBeat.i(83887);
        if (TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(83887);
            return arrayList;
        }
        List<PointF> loadTexCoords = loadTexCoords(str.substring(0, str.lastIndexOf(File.separator)), str.substring(str.lastIndexOf(File.separator) + 1));
        AppMethodBeat.o(83887);
        return loadTexCoords;
    }

    private static List<PointF> loadTexCoords(String str, String str2) {
        AppMethodBeat.i(83888);
        List<PointF> arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(83888);
            return arrayList;
        }
        String load = FileUtils.load(VideoGlobalContext.getContext(), str, str2);
        if (load == null) {
            AppMethodBeat.o(83888);
            return arrayList;
        }
        String[] split = load.trim().split("\\s+");
        int i = 0;
        while (i < split.length / 2) {
            try {
                arrayList.add(new PointF(Float.parseFloat(split[i * 2]), Float.parseFloat(split[(i * 2) + 1])));
                i++;
            } catch (NumberFormatException e) {
                arrayList = new ArrayList();
                AppMethodBeat.o(83888);
                return arrayList;
            }
        }
        AppMethodBeat.o(83888);
        return arrayList;
    }

    public static float[] initMaterialFaceTexCoords(List<PointF> list, int i, int i2, float[] fArr) {
        AppMethodBeat.i(83889);
        if (BaseUtils.isEmpty(list) || fArr == null || i <= 0 || i2 <= 0 || fArr.length != 1380) {
            fArr = new float[0];
            AppMethodBeat.o(83889);
            return fArr;
        }
        PointF[] pointFArr = new PointF[3];
        int i3 = 0;
        for (int i4 = 0; i4 < 690; i4 += 3) {
            pointFArr[0] = (PointF) list.get(FaceMeshTriangles[i4]);
            pointFArr[1] = (PointF) list.get(FaceMeshTriangles[i4 + 1]);
            pointFArr[2] = (PointF) list.get(FaceMeshTriangles[i4 + 2]);
            for (int i5 = 0; i5 < 3; i5++) {
                fArr[(i5 * 2) + i3] = pointFArr[i5].x / ((float) i);
                fArr[((i5 * 2) + i3) + 1] = pointFArr[i5].y / ((float) i2);
            }
            i3 += 6;
        }
        AppMethodBeat.o(83889);
        return fArr;
    }

    public static float[] initFacePositions(List<PointF> list, int i, int i2, float[] fArr) {
        AppMethodBeat.i(83890);
        if (BaseUtils.isEmpty(list) || fArr == null || i <= 0 || i2 <= 0 || fArr.length != 1380) {
            fArr = new float[0];
            AppMethodBeat.o(83890);
            return fArr;
        }
        PointF[] pointFArr = new PointF[3];
        int i3 = 0;
        for (int i4 = 0; i4 < 690; i4 += 3) {
            pointFArr[0] = (PointF) list.get(FaceMeshTriangles[i4]);
            pointFArr[1] = (PointF) list.get(FaceMeshTriangles[i4 + 1]);
            pointFArr[2] = (PointF) list.get(FaceMeshTriangles[i4 + 2]);
            for (int i5 = 0; i5 < 3; i5++) {
                fArr[(i5 * 2) + i3] = ((pointFArr[i5].x / ((float) i)) * 2.0f) - 1.0f;
                fArr[((i5 * 2) + i3) + 1] = ((pointFArr[i5].y / ((float) i2)) * 2.0f) - 1.0f;
            }
            i3 += 6;
        }
        AppMethodBeat.o(83890);
        return fArr;
    }

    public static float[] initFacePositionsBaseOnFaceRect(List<PointF> list, float f, float f2, float[] fArr) {
        AppMethodBeat.i(83891);
        if (BaseUtils.isEmpty(list) || fArr == null || f <= 0.0f || f2 <= 0.0f || fArr.length != 1380) {
            fArr = new float[0];
            AppMethodBeat.o(83891);
            return fArr;
        }
        int size = list.size();
        float f3 = ((PointF) list.get(64)).x;
        float f4 = ((PointF) list.get(64)).y;
        int i = 0;
        while (i < size) {
            ((PointF) list.get(i)).x -= f3;
            ((PointF) list.get(i)).y -= f4;
            i++;
        }
        PointF[] pointFArr = new PointF[3];
        i = 0;
        for (int i2 = 0; i2 < 690; i2 += 3) {
            pointFArr[0] = (PointF) list.get(FaceMeshTriangles[i2]);
            pointFArr[1] = (PointF) list.get(FaceMeshTriangles[i2 + 1]);
            pointFArr[2] = (PointF) list.get(FaceMeshTriangles[i2 + 2]);
            for (int i3 = 0; i3 < 3; i3++) {
                fArr[(i3 * 2) + i] = (pointFArr[i3].x / f) * 2.0f;
                fArr[((i3 * 2) + i) + 1] = (pointFArr[i3].y / f2) * 2.0f;
            }
            i += 6;
        }
        AppMethodBeat.o(83891);
        return fArr;
    }

    public static float[] initMaterialFaceTexCoordsFaceAverage(List<PointF> list, int i, int i2, float[] fArr) {
        AppMethodBeat.i(83892);
        if (BaseUtils.isEmpty(list) || fArr == null || i <= 0 || i2 <= 0 || fArr.length != 1104) {
            fArr = new float[0];
            AppMethodBeat.o(83892);
            return fArr;
        }
        PointF[] pointFArr = new PointF[3];
        int i3 = 0;
        for (int i4 = 0; i4 < 552; i4 += 3) {
            pointFArr[0] = (PointF) list.get(FaceMeshTrianglesFaceAverage[i4]);
            pointFArr[1] = (PointF) list.get(FaceMeshTrianglesFaceAverage[i4 + 1]);
            pointFArr[2] = (PointF) list.get(FaceMeshTrianglesFaceAverage[i4 + 2]);
            for (int i5 = 0; i5 < 3; i5++) {
                fArr[(i5 * 2) + i3] = pointFArr[i5].x / ((float) i);
                fArr[((i5 * 2) + i3) + 1] = pointFArr[i5].y / ((float) i2);
            }
            i3 += 6;
        }
        AppMethodBeat.o(83892);
        return fArr;
    }

    public static float[] initFacePositionsFaceAverage(List<PointF> list, int i, int i2, float[] fArr) {
        AppMethodBeat.i(83893);
        if (BaseUtils.isEmpty(list) || fArr == null || i <= 0 || i2 <= 0 || fArr.length != 1104) {
            fArr = new float[0];
            AppMethodBeat.o(83893);
            return fArr;
        }
        PointF[] pointFArr = new PointF[3];
        int i3 = 0;
        for (int i4 = 0; i4 < 552; i4 += 3) {
            pointFArr[0] = (PointF) list.get(FaceMeshTrianglesFaceAverage[i4]);
            pointFArr[1] = (PointF) list.get(FaceMeshTrianglesFaceAverage[i4 + 1]);
            pointFArr[2] = (PointF) list.get(FaceMeshTrianglesFaceAverage[i4 + 2]);
            for (int i5 = 0; i5 < 3; i5++) {
                fArr[(i5 * 2) + i3] = ((pointFArr[i5].x / ((float) i)) * 2.0f) - 1.0f;
                fArr[((i5 * 2) + i3) + 1] = ((pointFArr[i5].y / ((float) i2)) * 2.0f) - 1.0f;
            }
            i3 += 6;
        }
        AppMethodBeat.o(83893);
        return fArr;
    }

    public static float[] initFaceLinePositions(List<PointF> list, int i, int i2, float[] fArr) {
        AppMethodBeat.i(83894);
        if (BaseUtils.isEmpty(list) || i <= 0 || i2 <= 0) {
            fArr = new float[0];
            AppMethodBeat.o(83894);
            return fArr;
        }
        PointF[] pointFArr = new PointF[3];
        int i3 = 0;
        for (int i4 = 0; i4 < 690; i4 += 3) {
            pointFArr[0] = (PointF) list.get(FaceMeshTriangles[i4]);
            pointFArr[1] = (PointF) list.get(FaceMeshTriangles[i4 + 1]);
            pointFArr[2] = (PointF) list.get(FaceMeshTriangles[i4 + 2]);
            fArr[i3] = ((pointFArr[0].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 1] = ((pointFArr[0].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 2] = ((pointFArr[1].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 3] = ((pointFArr[1].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 4] = ((pointFArr[1].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 5] = ((pointFArr[1].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 6] = ((pointFArr[2].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 7] = ((pointFArr[2].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 8] = ((pointFArr[2].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 9] = ((pointFArr[2].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 10] = ((pointFArr[0].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 11] = ((pointFArr[0].y / ((float) i2)) * 2.0f) - 1.0f;
            i3 += 12;
        }
        AppMethodBeat.o(83894);
        return fArr;
    }

    public static float[] initIrisLinePositions(List<PointF> list, int i, int i2, float[] fArr) {
        AppMethodBeat.i(83895);
        if (BaseUtils.isEmpty(list) || i <= 0 || i2 <= 0) {
            fArr = new float[0];
            AppMethodBeat.o(83895);
            return fArr;
        }
        PointF[] pointFArr = new PointF[3];
        int i3 = 0;
        for (int i4 = 0; i4 < 24; i4 += 3) {
            pointFArr[0] = (PointF) list.get(IrisMeshTriangles[i4]);
            pointFArr[1] = (PointF) list.get(IrisMeshTriangles[i4 + 1]);
            pointFArr[2] = (PointF) list.get(IrisMeshTriangles[i4 + 2]);
            fArr[i3] = ((pointFArr[0].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 1] = ((pointFArr[0].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 2] = ((pointFArr[1].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 3] = ((pointFArr[1].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 4] = ((pointFArr[1].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 5] = ((pointFArr[1].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 6] = ((pointFArr[2].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 7] = ((pointFArr[2].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 8] = ((pointFArr[2].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 9] = ((pointFArr[2].y / ((float) i2)) * 2.0f) - 1.0f;
            fArr[i3 + 10] = ((pointFArr[0].x / ((float) i)) * 2.0f) - 1.0f;
            fArr[i3 + 11] = ((pointFArr[0].y / ((float) i2)) * 2.0f) - 1.0f;
            i3 += 12;
        }
        AppMethodBeat.o(83895);
        return fArr;
    }

    public static List<PointF> getFullCoords(List<PointF> list) {
        AppMethodBeat.i(83896);
        if (BaseUtils.isEmpty(list) || list.size() < 90) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(83896);
            return arrayList;
        }
        int i;
        PointF pointF;
        int i2;
        float f;
        int i3;
        PointF pointF2 = (PointF) list.get(83);
        double atan = Math.atan((double) ((((PointF) list.get(9)).x - ((PointF) list.get(83)).x) / (((PointF) list.get(83)).y + (-((PointF) list.get(9)).y))));
        float distance = AlgoUtils.getDistance((PointF) list.get(0), (PointF) list.get(1));
        PointF pointF3 = new PointF((float) (((double) ((PointF) list.get(1)).x) + (((double) (2.0f * distance)) * Math.sin(atan))), (float) (((double) ((PointF) list.get(1)).y) - (((double) (2.0f * distance)) * Math.cos(atan))));
        list.add(pointF3);
        distance = AlgoUtils.getDistance((PointF) list.get(17), (PointF) list.get(18));
        PointF pointF4 = new PointF((float) (((double) ((PointF) list.get(17)).x) + (((double) (2.0f * distance)) * Math.sin(atan))), (float) (((double) ((PointF) list.get(17)).y) - (((double) (2.0f * distance)) * Math.cos(atan))));
        list.add(pointF4);
        float distance2 = (float) (((double) AlgoUtils.getDistance((PointF) list.get(59), pointF2)) * 1.2d);
        PointF pointF5 = new PointF((float) (((double) ((PointF) list.get(59)).x) + (((double) (2.0f * distance2)) * Math.sin(atan))), (float) (((double) ((PointF) list.get(59)).y) - (((double) (2.0f * distance2)) * Math.cos(atan))));
        for (i = 2; i > 0; i--) {
            atan = Math.toRadians((double) (((float) i) * 30.0f));
            pointF = new PointF();
            pointF.x = (float) (((double) pointF5.x) - (((double) (pointF5.x - pointF4.x)) * Math.cos(atan)));
            pointF.y = (float) (((double) pointF4.y) - (Math.sin(atan) * ((double) (pointF4.y - pointF5.y))));
            list.add(pointF);
        }
        for (i = 3; i > 0; i--) {
            atan = Math.toRadians((double) (((float) i) * 30.0f));
            pointF = new PointF();
            pointF.x = (float) (((double) pointF5.x) - (((double) (pointF5.x - pointF3.x)) * Math.cos(atan)));
            pointF.y = (float) (((double) pointF3.y) - (Math.sin(atan) * ((double) (pointF3.y - pointF5.y))));
            list.add(pointF);
        }
        list.add(EMPTY_POINT);
        list.add(EMPTY_POINT);
        pointF2 = (PointF) list.get(64);
        pointF = (PointF) list.get(54);
        pointF5 = (PointF) list.get(44);
        pointF3 = new PointF(pointF.x - pointF5.x, pointF.y - pointF5.y);
        pointF = new PointF(pointF3.x + pointF3.x, pointF3.y + pointF3.y);
        pointF5 = new PointF(-pointF.y, pointF.x);
        list.add(new PointF((pointF2.x - pointF.x) - pointF5.x, (pointF2.y - pointF.y) - pointF5.y));
        list.add(new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y));
        list.add(new PointF((pointF2.x - pointF.x) + pointF5.x, (pointF2.y - pointF.y) + pointF5.y));
        list.add(new PointF(pointF2.x + pointF5.x, pointF2.y + pointF5.y));
        list.add(new PointF((pointF2.x + pointF.x) + pointF5.x, (pointF2.y + pointF.y) + pointF5.y));
        list.add(new PointF(pointF2.x + pointF.x, pointF2.y + pointF.y));
        list.add(new PointF((pointF2.x + pointF.x) - pointF5.x, (pointF.y + pointF2.y) - pointF5.y));
        list.add(new PointF(pointF2.x - pointF5.x, pointF2.y - pointF5.y));
        list.get(3);
        list.get(15);
        list.get(65);
        list.get(66);
        pointF2 = AlgoUtils.middlePoint((PointF) list.get(3), (PointF) list.get(65));
        list.add(new PointF(pointF2.x, pointF2.y));
        pointF2 = AlgoUtils.middlePoint((PointF) list.get(15), (PointF) list.get(66));
        list.add(new PointF(pointF2.x, pointF2.y));
        list.get(2);
        list.get(16);
        list.get(39);
        list.get(49);
        list.get(57);
        list.get(61);
        list.get(35);
        list.get(45);
        pointF2 = AlgoUtils.middlePoint((PointF) list.get(35), (PointF) list.get(57));
        list.add(new PointF(pointF2.x, pointF2.y));
        pointF2 = AlgoUtils.middlePoint((PointF) list.get(45), (PointF) list.get(61));
        list.add(new PointF(pointF2.x, pointF2.y));
        list.get(37);
        pointF2 = (PointF) list.get(44);
        int i4 = 35;
        while (true) {
            i2 = i4;
            if (i2 >= 39) {
                break;
            }
            pointF = (PointF) list.get(i2);
            if (((double) Math.abs(pointF.x - pointF2.x)) < 1.0d) {
                list.add(new PointF(pointF.x, (float) (((double) pointF.y) + (((double) (pointF.y - pointF2.y)) * 0.7d))));
            } else {
                distance = (float) (((double) pointF.x) + (((double) (pointF.x - pointF2.x)) * 0.7d));
                f = pointF2.y + ((distance - pointF2.x) * ((pointF.y - pointF2.y) / (pointF.x - pointF2.x)));
                if (i2 != 35 || distance >= ((PointF) list.get(0)).x) {
                    distance2 = distance;
                } else {
                    distance2 = ((PointF) list.get(0)).x;
                }
                list.add(new PointF(distance2, f));
            }
            i4 = i2 + 1;
        }
        pointF = AlgoUtils.middlePoint((PointF) list.get(39), (PointF) list.get(55));
        list.add(new PointF(pointF.x, pointF.y));
        i2 = list.size();
        i4 = 40;
        while (true) {
            i3 = i4;
            if (i3 >= 43) {
                break;
            }
            pointF = (PointF) list.get(i3);
            if (((double) Math.abs(pointF.x - pointF2.x)) < 1.0d) {
                list.add(new PointF(pointF.x, (float) (((double) pointF.y) + (((double) (pointF.y - pointF2.y)) * 1.2d))));
            } else {
                f = (pointF.y - pointF2.y) / (pointF.x - pointF2.x);
                distance2 = (float) (((double) pointF.x) + (((double) (pointF.x - pointF2.x)) * 1.2d));
                list.add(new PointF(distance2, (f * (distance2 - pointF2.x)) + pointF2.y));
            }
            i4 = i3 + 1;
        }
        pointF = (PointF) list.get(i2 + 1);
        pointF5 = (PointF) list.get(i2 + 2);
        pointF2 = AlgoUtils.middlePoint((PointF) list.get(i2), pointF);
        pointF = AlgoUtils.middlePoint(pointF5, pointF);
        list.add(new PointF(pointF2.x, pointF2.y));
        list.add(new PointF(pointF.x, pointF.y));
        pointF2 = (PointF) list.get(54);
        i4 = 45;
        while (true) {
            i2 = i4;
            if (i2 >= 49) {
                break;
            }
            pointF = (PointF) list.get(i2);
            if (((double) Math.abs(pointF.x - pointF2.x)) < 1.0d) {
                list.add(new PointF(pointF.x, (float) (((double) pointF.y) + (((double) (pointF.y - pointF2.y)) * 0.7d))));
            } else {
                distance = (float) (((double) pointF.x) + (((double) (pointF.x - pointF2.x)) * 0.7d));
                f = pointF2.y + ((distance - pointF2.x) * ((pointF.y - pointF2.y) / (pointF.x - pointF2.x)));
                if (i2 != 45 || distance <= ((PointF) list.get(18)).x) {
                    distance2 = distance;
                } else {
                    distance2 = ((PointF) list.get(18)).x;
                }
                list.add(new PointF(distance2, f));
            }
            i4 = i2 + 1;
        }
        pointF = AlgoUtils.middlePoint((PointF) list.get(49), (PointF) list.get(63));
        list.add(new PointF(pointF.x, pointF.y));
        i2 = list.size();
        i4 = 50;
        while (true) {
            i3 = i4;
            if (i3 < 53) {
                pointF = (PointF) list.get(i3);
                if (((double) Math.abs(pointF.x - pointF2.x)) < 1.0d) {
                    list.add(new PointF(pointF.x, (float) (((double) pointF.y) + (((double) (pointF.y - pointF2.y)) * 1.2d))));
                } else {
                    f = (pointF.y - pointF2.y) / (pointF.x - pointF2.x);
                    distance2 = (float) (((double) pointF.x) + (((double) (pointF.x - pointF2.x)) * 1.2d));
                    list.add(new PointF(distance2, (f * (distance2 - pointF2.x)) + pointF2.y));
                }
                i4 = i3 + 1;
            } else {
                pointF = (PointF) list.get(i2 + 1);
                pointF5 = (PointF) list.get(i2 + 2);
                pointF2 = AlgoUtils.middlePoint((PointF) list.get(i2), pointF);
                pointF = AlgoUtils.middlePoint(pointF5, pointF);
                list.add(new PointF(pointF2.x, pointF2.y));
                list.add(new PointF(pointF.x, pointF.y));
                AppMethodBeat.o(83896);
                return list;
            }
        }
    }

    public static List<PointF> getFullCoordsForFaceOffFilter(List<PointF> list, float f) {
        AppMethodBeat.i(83897);
        if (BaseUtils.isEmpty(list) || list.size() < 90) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(83897);
            return arrayList;
        }
        int i;
        double toRadians;
        PointF pointF;
        float sin;
        int i2;
        float toRadians2;
        float sin2;
        PointF pointF2 = new PointF((((PointF) list.get(51)).x + ((PointF) list.get(41)).x) / 2.0f, (((PointF) list.get(51)).y + ((PointF) list.get(41)).y) / 2.0f);
        double atan2 = Math.atan2((double) (((PointF) list.get(9)).x - ((PointF) list.get(84)).x), (double) (((PointF) list.get(84)).y + (-((PointF) list.get(9)).y))) + 3.141592653589793d;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postTranslate(-pointF2.x, -pointF2.y);
        matrix.postRotate((float) Math.toDegrees(-atan2));
        matrix.postTranslate(pointF2.x, pointF2.y);
        List mapPoints = AlgoUtils.mapPoints(list, matrix);
        float distance = AlgoUtils.getDistance((PointF) mapPoints.get(0), (PointF) mapPoints.get(1));
        PointF pointF3 = new PointF((float) (((double) ((PointF) mapPoints.get(1)).x) + (((double) (2.0f * distance)) * Math.sin(0.0d))), (float) (((double) ((PointF) mapPoints.get(1)).y) - (((double) (2.0f * distance)) * Math.cos(0.0d))));
        mapPoints.add(pointF3);
        distance = AlgoUtils.getDistance((PointF) mapPoints.get(17), (PointF) mapPoints.get(18));
        PointF pointF4 = new PointF((float) (((double) ((PointF) mapPoints.get(17)).x) + (((double) (2.0f * distance)) * Math.sin(0.0d))), (float) (((double) ((PointF) mapPoints.get(17)).y) - (((double) (2.0f * distance)) * Math.cos(0.0d))));
        mapPoints.add(pointF4);
        distance = AlgoUtils.getDistance((PointF) mapPoints.get(59), pointF2);
        PointF pointF5 = new PointF((float) (((double) ((PointF) mapPoints.get(59)).x) + (((double) (2.0f * distance)) * Math.sin(0.0d))), (float) (((double) ((PointF) mapPoints.get(59)).y) - (((double) (2.0f * distance)) * Math.cos(0.0d))));
        for (i = 2; i > 0; i--) {
            toRadians = Math.toRadians((double) (((float) i) * 30.0f));
            pointF = new PointF();
            pointF.x = (float) (((double) pointF5.x) - (((double) (pointF5.x - pointF4.x)) * Math.cos(toRadians)));
            pointF.y = (float) (((double) pointF4.y) - (Math.sin(toRadians) * ((double) (pointF4.y - pointF5.y))));
            mapPoints.add(pointF);
        }
        for (i = 3; i > 0; i--) {
            toRadians = Math.toRadians((double) (((float) i) * 30.0f));
            pointF = new PointF();
            pointF.x = (float) (((double) pointF5.x) - (((double) (pointF5.x - pointF3.x)) * Math.cos(toRadians)));
            pointF.y = (float) (((double) pointF3.y) - (Math.sin(toRadians) * ((double) (pointF3.y - pointF5.y))));
            mapPoints.add(pointF);
        }
        mapPoints.add(EMPTY_POINT);
        mapPoints.add(EMPTY_POINT);
        PointF pointF6 = (PointF) mapPoints.get(64);
        pointF = (PointF) mapPoints.get(54);
        pointF3 = (PointF) mapPoints.get(44);
        pointF4 = new PointF(pointF.x - pointF3.x, pointF.y - pointF3.y);
        pointF = new PointF(pointF4.x * f, pointF4.y * f);
        pointF3 = new PointF(-pointF.y, pointF.x);
        mapPoints.add(new PointF((pointF6.x - pointF.x) - pointF3.x, (pointF6.y - pointF.y) - pointF3.y));
        mapPoints.add(new PointF(pointF6.x - pointF.x, pointF6.y - pointF.y));
        mapPoints.add(new PointF((pointF6.x - pointF.x) + pointF3.x, (pointF6.y - pointF.y) + pointF3.y));
        mapPoints.add(new PointF(pointF6.x + pointF3.x, pointF6.y + pointF3.y));
        mapPoints.add(new PointF((pointF6.x + pointF.x) + pointF3.x, (pointF6.y + pointF.y) + pointF3.y));
        mapPoints.add(new PointF(pointF6.x + pointF.x, pointF6.y + pointF.y));
        mapPoints.add(new PointF((pointF6.x + pointF.x) - pointF3.x, (pointF.y + pointF6.y) - pointF3.y));
        mapPoints.add(new PointF(pointF6.x - pointF3.x, pointF6.y - pointF3.y));
        mapPoints.get(3);
        mapPoints.get(15);
        mapPoints.get(65);
        mapPoints.get(66);
        pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(3), (PointF) mapPoints.get(65));
        mapPoints.add(new PointF(pointF6.x, pointF6.y));
        pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(15), (PointF) mapPoints.get(66));
        mapPoints.add(new PointF(pointF6.x, pointF6.y));
        mapPoints.get(2);
        mapPoints.get(16);
        pointF6 = (PointF) mapPoints.get(39);
        pointF = (PointF) mapPoints.get(49);
        mapPoints.get(57);
        mapPoints.get(61);
        pointF3 = (PointF) mapPoints.get(35);
        pointF4 = (PointF) mapPoints.get(45);
        pointF5 = AlgoUtils.middlePoint((PointF) mapPoints.get(35), (PointF) mapPoints.get(57));
        mapPoints.add(new PointF(pointF5.x, pointF5.y));
        pointF5 = AlgoUtils.middlePoint((PointF) mapPoints.get(45), (PointF) mapPoints.get(61));
        mapPoints.add(new PointF(pointF5.x, pointF5.y));
        pointF5 = (PointF) mapPoints.get(43);
        mapPoints.get(55);
        PointF pointF7 = (PointF) mapPoints.get(41);
        PointF pointF8 = (PointF) mapPoints.get(37);
        float distance2 = AlgoUtils.getDistance(pointF3, pointF6);
        AlgoUtils.getDistance(pointF7, pointF8);
        float f2 = distance2 / 50.0f;
        i = 35;
        while (true) {
            int i3 = i;
            if (i3 >= 39) {
                break;
            }
            float f3;
            pointF6 = (PointF) mapPoints.get(i3);
            sin = (float) (Math.sin((((double) (2.0f - ((float) Math.abs(i3 - 37)))) * 3.141592653589793d) / 4.0d) * 0.3d);
            if (i3 == 35) {
                f3 = pointF6.x + ((pointF6.x - pointF5.x) * 0.9f);
                sin = ((f3 - pointF5.x) * ((pointF6.y - pointF5.y) / (pointF6.x - pointF5.x))) + pointF5.y;
            } else {
                float toRadians3 = (float) Math.toRadians((double) (60.0f * ((float) (i3 - 37))));
                f3 = (float) (((double) pointF6.x) + (((double) ((10.0f * f2) * (1.0f + sin))) * Math.sin(0.0d + ((double) toRadians3))));
                sin = (float) (((double) pointF6.y) + (((double) ((10.0f * f2) * (sin + 1.0f))) * Math.cos(0.0d + ((double) toRadians3))));
            }
            if (i3 != 35 || f3 >= ((PointF) mapPoints.get(0)).x) {
                distance2 = f3;
            } else {
                distance2 = ((PointF) mapPoints.get(0)).x;
            }
            mapPoints.add(new PointF(distance2, sin));
            i = i3 + 1;
        }
        pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(39), (PointF) mapPoints.get(55));
        mapPoints.add(new PointF(pointF6.x, pointF6.y));
        int size = mapPoints.size();
        i = 40;
        while (true) {
            i2 = i;
            if (i2 >= 43) {
                break;
            }
            pointF6 = (PointF) mapPoints.get(i2);
            toRadians2 = (float) Math.toRadians((double) (60.0f * ((float) (i2 - 41))));
            sin = (float) (Math.sin((((double) (3.0f - ((float) Math.abs(i2 - 41)))) * 3.141592653589793d) / 2.0d) * 0.3d);
            mapPoints.add(new PointF((float) (((double) pointF6.x) - (((double) ((16.0f * f2) * (1.0f + sin))) * Math.sin(0.0d + ((double) toRadians2)))), (float) (((double) pointF6.y) - (((double) ((16.0f * f2) * (sin + 1.0f))) * Math.cos(0.0d + ((double) toRadians2))))));
            i = i2 + 1;
        }
        pointF6 = (PointF) mapPoints.get(size);
        pointF3 = (PointF) mapPoints.get(size + 1);
        pointF5 = (PointF) mapPoints.get(size + 2);
        pointF6 = AlgoUtils.middlePoint(pointF6, pointF3);
        pointF3 = AlgoUtils.middlePoint(pointF5, pointF3);
        mapPoints.add(new PointF(pointF6.x, pointF6.y));
        mapPoints.add(new PointF(pointF3.x, pointF3.y));
        pointF6 = (PointF) mapPoints.get(51);
        pointF3 = (PointF) mapPoints.get(47);
        pointF5 = (PointF) mapPoints.get(54);
        mapPoints.get(63);
        distance = AlgoUtils.getDistance(pointF4, pointF);
        AlgoUtils.getDistance(pointF6, pointF3);
        toRadians2 = distance / 50.0f;
        i = 45;
        while (true) {
            i2 = i;
            if (i2 >= 49) {
                break;
            }
            pointF6 = (PointF) mapPoints.get(i2);
            sin2 = (float) (Math.sin((((double) (2.0f - ((float) Math.abs(i2 - 47)))) * 3.141592653589793d) / 4.0d) * 0.3d);
            if (i2 == 45) {
                distance = pointF6.x + ((pointF6.x - pointF5.x) * 0.9f);
                sin2 = ((distance - pointF5.x) * ((pointF6.y - pointF5.y) / (pointF6.x - pointF5.x))) + pointF5.y;
            } else {
                sin = (float) Math.toRadians((double) (60.0f * ((float) (i2 - 47))));
                distance = (float) (((double) pointF6.x) + (((double) ((10.0f * toRadians2) * (1.0f + sin2))) * Math.sin(0.0d - ((double) sin))));
                sin2 = (float) (((double) pointF6.y) + (((double) ((10.0f * toRadians2) * (sin2 + 1.0f))) * Math.cos(0.0d - ((double) sin))));
            }
            if (i2 != 45 || distance <= ((PointF) mapPoints.get(18)).x) {
                distance2 = distance;
            } else {
                distance2 = ((PointF) mapPoints.get(18)).x;
            }
            mapPoints.add(new PointF(distance2, sin2));
            i = i2 + 1;
        }
        pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(49), (PointF) mapPoints.get(63));
        mapPoints.add(new PointF(pointF6.x, pointF6.y));
        i2 = mapPoints.size();
        i = 50;
        while (true) {
            int i4 = i;
            if (i4 < 53) {
                pointF6 = (PointF) mapPoints.get(i4);
                sin2 = (float) Math.toRadians((double) (60.0f * ((float) (i4 - 51))));
                float sin3 = (float) (Math.sin((((double) (3.0f - ((float) Math.abs(i4 - 51)))) * 3.141592653589793d) / 2.0d) * 0.3d);
                mapPoints.add(new PointF((float) (((double) pointF6.x) - (((double) ((16.0f * toRadians2) * (1.0f + sin3))) * Math.sin(0.0d - ((double) sin2)))), (float) (((double) pointF6.y) - (((double) ((16.0f * toRadians2) * (sin3 + 1.0f))) * Math.cos(0.0d - ((double) sin2))))));
                i = i4 + 1;
            } else {
                pointF6 = (PointF) mapPoints.get(i2);
                pointF = (PointF) mapPoints.get(i2 + 1);
                pointF3 = (PointF) mapPoints.get(i2 + 2);
                pointF6 = AlgoUtils.middlePoint(pointF6, pointF);
                pointF = AlgoUtils.middlePoint(pointF3, pointF);
                mapPoints.add(new PointF(pointF6.x, pointF6.y));
                mapPoints.add(new PointF(pointF.x, pointF.y));
                matrix.reset();
                matrix.postTranslate(-pointF2.x, -pointF2.y);
                matrix.postRotate((float) Math.toDegrees(atan2));
                matrix.postTranslate(pointF2.x, pointF2.y);
                List<PointF> mapPoints2 = AlgoUtils.mapPoints(mapPoints, matrix);
                AppMethodBeat.o(83897);
                return mapPoints2;
            }
        }
    }

    public static List<PointF> getFullCoords(List<PointF> list, float f) {
        AppMethodBeat.i(83898);
        if (BaseUtils.isEmpty(list) || list.size() < 90) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(83898);
            return arrayList;
        }
        if (list.size() > 97) {
            list.subList(97, list.size()).clear();
        }
        if (list.size() == 90 || list.size() == 97) {
            float distance;
            PointF pointF;
            PointF pointF2;
            PointF pointF3;
            int i;
            float f2;
            float f3;
            int i2;
            PointF pointF4 = new PointF((((PointF) list.get(51)).x + ((PointF) list.get(41)).x) / 2.0f, (((PointF) list.get(51)).y + ((PointF) list.get(41)).y) / 2.0f);
            double atan2 = Math.atan2((double) (((PointF) list.get(9)).x - ((PointF) list.get(84)).x), (double) (((PointF) list.get(84)).y + (-((PointF) list.get(9)).y))) + 3.141592653589793d;
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.postTranslate(-pointF4.x, -pointF4.y);
            matrix.postRotate((float) Math.toDegrees(-atan2));
            matrix.postTranslate(pointF4.x, pointF4.y);
            List mapPoints = AlgoUtils.mapPoints(list, matrix);
            if (mapPoints.size() == 90) {
                int i3;
                double toRadians;
                distance = AlgoUtils.getDistance((PointF) mapPoints.get(0), (PointF) mapPoints.get(1));
                pointF = new PointF((float) (((double) ((PointF) mapPoints.get(1)).x) + (((double) (2.0f * distance)) * Math.sin(0.0d))), (float) (((double) ((PointF) mapPoints.get(1)).y) - (((double) (2.0f * distance)) * Math.cos(0.0d))));
                mapPoints.add(pointF);
                distance = AlgoUtils.getDistance((PointF) mapPoints.get(17), (PointF) mapPoints.get(18));
                pointF2 = new PointF((float) (((double) ((PointF) mapPoints.get(17)).x) + (((double) (2.0f * distance)) * Math.sin(0.0d))), (float) (((double) ((PointF) mapPoints.get(17)).y) - (((double) (2.0f * distance)) * Math.cos(0.0d))));
                mapPoints.add(pointF2);
                distance = AlgoUtils.getDistance((PointF) mapPoints.get(59), pointF4);
                PointF pointF5 = new PointF((float) (((double) ((PointF) mapPoints.get(59)).x) + (((double) (2.0f * distance)) * Math.sin(0.0d))), (float) (((double) ((PointF) mapPoints.get(59)).y) - (((double) (2.0f * distance)) * Math.cos(0.0d))));
                for (i3 = 2; i3 > 0; i3--) {
                    toRadians = Math.toRadians((double) (((float) i3) * 30.0f));
                    pointF3 = new PointF();
                    pointF3.x = (float) (((double) pointF5.x) - (((double) (pointF5.x - pointF2.x)) * Math.cos(toRadians)));
                    pointF3.y = (float) (((double) pointF2.y) - (Math.sin(toRadians) * ((double) (pointF2.y - pointF5.y))));
                    mapPoints.add(pointF3);
                }
                for (i3 = 3; i3 > 0; i3--) {
                    toRadians = Math.toRadians((double) (((float) i3) * 30.0f));
                    pointF3 = new PointF();
                    pointF3.x = (float) (((double) pointF5.x) - (((double) (pointF5.x - pointF.x)) * Math.cos(toRadians)));
                    pointF3.y = (float) (((double) pointF.y) - (Math.sin(toRadians) * ((double) (pointF.y - pointF5.y))));
                    mapPoints.add(pointF3);
                }
            }
            mapPoints.add(EMPTY_POINT);
            mapPoints.add(EMPTY_POINT);
            PointF pointF6 = (PointF) mapPoints.get(64);
            pointF3 = (PointF) mapPoints.get(54);
            pointF = (PointF) mapPoints.get(44);
            pointF2 = new PointF(pointF3.x - pointF.x, pointF3.y - pointF.y);
            pointF3 = new PointF(pointF2.x * f, pointF2.y * f);
            pointF = new PointF(-pointF3.y, pointF3.x);
            mapPoints.add(new PointF((pointF6.x - pointF3.x) - pointF.x, (pointF6.y - pointF3.y) - pointF.y));
            mapPoints.add(new PointF(pointF6.x - pointF3.x, pointF6.y - pointF3.y));
            mapPoints.add(new PointF((pointF6.x - pointF3.x) + pointF.x, (pointF6.y - pointF3.y) + pointF.y));
            mapPoints.add(new PointF(pointF6.x + pointF.x, pointF6.y + pointF.y));
            mapPoints.add(new PointF((pointF6.x + pointF3.x) + pointF.x, (pointF6.y + pointF3.y) + pointF.y));
            mapPoints.add(new PointF(pointF6.x + pointF3.x, pointF6.y + pointF3.y));
            mapPoints.add(new PointF((pointF6.x + pointF3.x) - pointF.x, (pointF3.y + pointF6.y) - pointF.y));
            mapPoints.add(new PointF(pointF6.x - pointF.x, pointF6.y - pointF.y));
            mapPoints.get(3);
            mapPoints.get(15);
            mapPoints.get(65);
            mapPoints.get(66);
            pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(3), (PointF) mapPoints.get(65));
            mapPoints.add(new PointF(pointF6.x, pointF6.y));
            pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(15), (PointF) mapPoints.get(66));
            mapPoints.add(new PointF(pointF6.x, pointF6.y));
            mapPoints.get(2);
            mapPoints.get(16);
            mapPoints.get(39);
            mapPoints.get(49);
            mapPoints.get(57);
            mapPoints.get(61);
            mapPoints.get(35);
            mapPoints.get(45);
            pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(35), (PointF) mapPoints.get(57));
            mapPoints.add(new PointF(pointF6.x, pointF6.y));
            pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(45), (PointF) mapPoints.get(61));
            mapPoints.add(new PointF(pointF6.x, pointF6.y));
            mapPoints.get(37);
            pointF6 = (PointF) mapPoints.get(44);
            int i4 = 35;
            while (true) {
                i = i4;
                if (i >= 39) {
                    break;
                }
                pointF3 = (PointF) mapPoints.get(i);
                if (((double) Math.abs(pointF3.x - pointF6.x)) < 1.0d) {
                    mapPoints.add(new PointF(pointF3.x, (float) (((double) pointF3.y) + (((double) (pointF3.y - pointF6.y)) * 0.7d))));
                } else {
                    f2 = (float) (((double) pointF3.x) + (((double) (pointF3.x - pointF6.x)) * 0.7d));
                    f3 = pointF6.y + ((f2 - pointF6.x) * ((pointF3.y - pointF6.y) / (pointF3.x - pointF6.x)));
                    if (i != 35 || f2 >= ((PointF) mapPoints.get(0)).x) {
                        distance = f2;
                    } else {
                        distance = ((PointF) mapPoints.get(0)).x;
                    }
                    mapPoints.add(new PointF(distance, f3));
                }
                i4 = i + 1;
            }
            pointF3 = AlgoUtils.middlePoint((PointF) mapPoints.get(39), (PointF) mapPoints.get(55));
            mapPoints.add(new PointF(pointF3.x, pointF3.y));
            i = mapPoints.size();
            i4 = 40;
            while (true) {
                i2 = i4;
                if (i2 >= 43) {
                    break;
                }
                pointF3 = (PointF) mapPoints.get(i2);
                if (((double) Math.abs(pointF3.x - pointF6.x)) < 1.0d) {
                    mapPoints.add(new PointF(pointF3.x, (float) (((double) pointF3.y) + (((double) (pointF3.y - pointF6.y)) * 1.2d))));
                } else {
                    f3 = (pointF3.y - pointF6.y) / (pointF3.x - pointF6.x);
                    distance = (float) (((double) pointF3.x) + (((double) (pointF3.x - pointF6.x)) * 1.2d));
                    mapPoints.add(new PointF(distance, (f3 * (distance - pointF6.x)) + pointF6.y));
                }
                i4 = i2 + 1;
            }
            pointF3 = (PointF) mapPoints.get(i + 1);
            pointF = (PointF) mapPoints.get(i + 2);
            pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(i), pointF3);
            pointF3 = AlgoUtils.middlePoint(pointF, pointF3);
            mapPoints.add(new PointF(pointF6.x, pointF6.y));
            mapPoints.add(new PointF(pointF3.x, pointF3.y));
            pointF6 = (PointF) mapPoints.get(54);
            i4 = 45;
            while (true) {
                i = i4;
                if (i >= 49) {
                    break;
                }
                pointF3 = (PointF) mapPoints.get(i);
                if (((double) Math.abs(pointF3.x - pointF6.x)) < 1.0d) {
                    mapPoints.add(new PointF(pointF3.x, (float) (((double) pointF3.y) + (((double) (pointF3.y - pointF6.y)) * 0.7d))));
                } else {
                    f2 = (float) (((double) pointF3.x) + (((double) (pointF3.x - pointF6.x)) * 0.7d));
                    f3 = pointF6.y + ((f2 - pointF6.x) * ((pointF3.y - pointF6.y) / (pointF3.x - pointF6.x)));
                    if (i != 45 || f2 <= ((PointF) mapPoints.get(18)).x) {
                        distance = f2;
                    } else {
                        distance = ((PointF) mapPoints.get(18)).x;
                    }
                    mapPoints.add(new PointF(distance, f3));
                }
                i4 = i + 1;
            }
            pointF3 = AlgoUtils.middlePoint((PointF) mapPoints.get(49), (PointF) mapPoints.get(63));
            mapPoints.add(new PointF(pointF3.x, pointF3.y));
            i = mapPoints.size();
            i4 = 50;
            while (true) {
                i2 = i4;
                if (i2 < 53) {
                    pointF3 = (PointF) mapPoints.get(i2);
                    if (((double) Math.abs(pointF3.x - pointF6.x)) < 1.0d) {
                        mapPoints.add(new PointF(pointF3.x, (float) (((double) pointF3.y) + (((double) (pointF3.y - pointF6.y)) * 1.2d))));
                    } else {
                        f3 = (pointF3.y - pointF6.y) / (pointF3.x - pointF6.x);
                        distance = (float) (((double) pointF3.x) + (((double) (pointF3.x - pointF6.x)) * 1.2d));
                        mapPoints.add(new PointF(distance, (f3 * (distance - pointF6.x)) + pointF6.y));
                    }
                    i4 = i2 + 1;
                } else {
                    pointF3 = (PointF) mapPoints.get(i + 1);
                    pointF = (PointF) mapPoints.get(i + 2);
                    pointF6 = AlgoUtils.middlePoint((PointF) mapPoints.get(i), pointF3);
                    pointF3 = AlgoUtils.middlePoint(pointF, pointF3);
                    mapPoints.add(new PointF(pointF6.x, pointF6.y));
                    mapPoints.add(new PointF(pointF3.x, pointF3.y));
                    matrix.reset();
                    matrix.postTranslate(-pointF4.x, -pointF4.y);
                    matrix.postRotate((float) Math.toDegrees(atan2));
                    matrix.postTranslate(pointF4.x, pointF4.y);
                    list = AlgoUtils.mapPoints(mapPoints, matrix);
                    AppMethodBeat.o(83898);
                    return list;
                }
            }
        }
        AppMethodBeat.o(83898);
        return list;
    }

    public static FEATURE_TYPE getFeatureType(int i) {
        AppMethodBeat.i(83899);
        for (FEATURE_TYPE feature_type : FEATURE_TYPE.values()) {
            if (feature_type.value == i) {
                AppMethodBeat.o(83899);
                return feature_type;
            }
        }
        FEATURE_TYPE feature_type2 = FEATURE_TYPE.NO_EYE;
        AppMethodBeat.o(83899);
        return feature_type2;
    }

    public static List<PointF> genPoints(List<Float> list) {
        AppMethodBeat.i(83900);
        ArrayList arrayList = new ArrayList();
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(83900);
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size() / 2) {
                arrayList.add(new PointF(((Float) list.get(i2 * 2)).floatValue(), ((Float) list.get((i2 * 2) + 1)).floatValue()));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(83900);
                return arrayList;
            }
        }
    }

    public static List<PointF> genPointsDouble(List<Double> list) {
        AppMethodBeat.i(83901);
        ArrayList arrayList = new ArrayList();
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(83901);
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size() / 2) {
                arrayList.add(new PointF(((Double) list.get(i2 * 2)).floatValue(), ((Double) list.get((i2 * 2) + 1)).floatValue()));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(83901);
                return arrayList;
            }
        }
    }

    public static Bitmap getFaceBitmap(String str, FaceItem faceItem) {
        Bitmap decodeSampledBitmapFromFile;
        AppMethodBeat.i(83902);
        if (TextUtils.isEmpty(str) || !str.startsWith("assets://")) {
            decodeSampledBitmapFromFile = BitmapUtils.decodeSampledBitmapFromFile(str + File.separator + faceItem.faceExchangeImage, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            decodeSampledBitmapFromFile = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str) + File.separator + faceItem.faceExchangeImage, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        }
        if (BitmapUtils.isLegal(decodeSampledBitmapFromFile)) {
            AppMethodBeat.o(83902);
            return decodeSampledBitmapFromFile;
        }
        AppMethodBeat.o(83902);
        return null;
    }

    public static Bitmap getFaceBitmap(String str) {
        AppMethodBeat.i(83903);
        Bitmap faceBitmap = getFaceBitmap(str, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.o(83903);
        return faceBitmap;
    }

    public static Bitmap getFaceBitmap(String str, int i, int i2) {
        AppMethodBeat.i(83904);
        if (str == null) {
            AppMethodBeat.o(83904);
            return null;
        }
        Bitmap decodeSampledBitmapFromFile;
        if (str.startsWith("/")) {
            decodeSampledBitmapFromFile = BitmapUtils.decodeSampledBitmapFromFile(str, i, i2);
        } else {
            decodeSampledBitmapFromFile = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str), i, i2);
        }
        if (BitmapUtils.isLegal(decodeSampledBitmapFromFile)) {
            AppMethodBeat.o(83904);
            return decodeSampledBitmapFromFile;
        }
        AppMethodBeat.o(83904);
        return null;
    }

    public static Bitmap getGrayBitmap(FEATURE_TYPE feature_type) {
        AppMethodBeat.i(83905);
        Bitmap bitmap = null;
        if (feature_type.equals(FEATURE_TYPE.NO_EYE)) {
            bitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_NO_EYE, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        } else if (feature_type.equals(FEATURE_TYPE.HAS_EYE)) {
            bitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_HAS_EYE, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        } else if (feature_type.equals(FEATURE_TYPE.CRAZY_FACE)) {
            bitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_CRAZY_FACE, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        } else if (feature_type.equals(FEATURE_TYPE.FACE_HEAD_CROP)) {
            bitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_CROP_HEAD_FACE, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        } else if (feature_type.equals(FEATURE_TYPE.FACE_SKIN)) {
            bitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_FACE_SKIN, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        }
        AppMethodBeat.o(83905);
        return bitmap;
    }

    public static List<PointF> getGrayCoords(FEATURE_TYPE feature_type) {
        String str;
        AppMethodBeat.i(83906);
        switch (feature_type) {
            case HAS_EYE:
                str = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
                break;
            case CRAZY_FACE:
                str = COORDS_FILE_CRAZY_FACE;
                break;
            case FACE_HEAD_CROP:
                str = COORDS_FILE_FACE_HEAD_CROP;
                break;
            case FACE_SKIN:
                str = COORDS_FILE_FACE_SKIN;
                break;
            default:
                str = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
                break;
        }
        List loadTexCoords = loadTexCoords(str);
        AppMethodBeat.o(83906);
        return loadTexCoords;
    }

    public static List<PointF> getMaskCoords(List<Double> list) {
        AppMethodBeat.i(83907);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size() - 1) {
                arrayList.add(new PointF((float) ((Double) list.get(i2)).doubleValue(), (float) ((Double) list.get(i2 + 1)).doubleValue()));
                i = i2 + 2;
            } else {
                AppMethodBeat.o(83907);
                return arrayList;
            }
        }
    }

    public static void setNoEyeGrayImagePath(String str) {
        GRAY_FILE_HAS_EYE = str;
    }

    public static void setNoMouthGrayImagePath(String str) {
        GRAY_FILE_NO_EYE = str;
    }

    public static void scalePoints(List<PointF> list, double d) {
        AppMethodBeat.i(83908);
        if (list == null) {
            AppMethodBeat.o(83908);
            return;
        }
        for (PointF pointF : list) {
            pointF.x = (float) (((double) pointF.x) * d);
            pointF.y = (float) (((double) pointF.y) * d);
        }
        AppMethodBeat.o(83908);
    }

    public static void getCropNormalFaceFeature(List<PointF> list) {
        AppMethodBeat.i(83909);
        float distance = AlgoUtils.getDistance((PointF) list.get(99), (PointF) list.get(105));
        float distance2 = AlgoUtils.getDistance((PointF) list.get(99), (PointF) list.get(101));
        float f = 1.0f / distance;
        float f2 = 1.0f / distance2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ((PointF) list.get(i2)).set(f * AlgoUtils.distanceOfPoint2Line((PointF) list.get(99), (PointF) list.get(101), distance2, (PointF) list.get(i2)), f2 * AlgoUtils.distanceOfPoint2Line((PointF) list.get(99), (PointF) list.get(105), distance, (PointF) list.get(i2)));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(83909);
                return;
            }
        }
    }
}
