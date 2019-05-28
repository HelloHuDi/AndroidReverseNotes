package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.support.v4.widget.j;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.CameraBeautyParams;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceDetectUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RemodelFilter {
    private static final String PERF_LOG = "[showPreview]";
    private String[] GPU_LIST;
    public CameraBeautyParams cameraBeautyParams;
    private BaseFilter copyFilter;
    private h copyFrame;
    private BaseFilter cropFilter;
    private h cropFrame;
    private BaseFilter drawFilter;
    private h eyesFrame;
    private int[][] faceOutline;
    private List<PointF> facePoints;
    private boolean isForPhotoEdit;
    private int mChoose;
    private int mCropWidth;
    private h noseFrame;
    private ReshapeCombineFilter reshapeCombineFilter;
    private h reshapeCombineFrame;
    private ReshapeEyeNoseLips reshapeEyeNoseLipsFilter;
    private ReshapeWholeFace reshapeWholeFaceFilter;
    private int singleItemStartIndex;
    private h tempFrame;
    private int useMeshType;

    public RemodelFilter() {
        AppMethodBeat.i(82731);
        this.singleItemStartIndex = 2;
        this.mChoose = this.singleItemStartIndex;
        this.copyFilter = new BaseFilter(GLSLRender.bJB);
        this.cropFilter = new BaseFilter(GLSLRender.bJB);
        this.drawFilter = new BaseFilter(GLSLRender.bJB);
        this.eyesFrame = new h();
        this.noseFrame = new h();
        this.reshapeCombineFrame = new h();
        this.tempFrame = new h();
        this.cropFrame = new h();
        this.copyFrame = new h();
        this.GPU_LIST = new String[]{"Mali", "PowerVR Rogue G6200"};
        this.useMeshType = 0;
        this.isForPhotoEdit = false;
        this.cameraBeautyParams = new CameraBeautyParams();
        this.faceOutline = null;
        this.facePoints = new ArrayList();
        this.useMeshType = 0;
        this.reshapeCombineFilter = new ReshapeCombineFilter();
        this.reshapeEyeNoseLipsFilter = new ReshapeEyeNoseLips(1 - this.useMeshType);
        this.reshapeWholeFaceFilter = new ReshapeWholeFace(1 - this.useMeshType);
        AppMethodBeat.o(82731);
    }

    public void init() {
        AppMethodBeat.i(82732);
        this.reshapeEyeNoseLipsFilter.ApplyGLSLFilter();
        this.reshapeWholeFaceFilter.ApplyGLSLFilter();
        this.reshapeCombineFilter.ApplyGLSLFilter();
        this.copyFilter.ApplyGLSLFilter();
        this.cropFilter.ApplyGLSLFilter();
        this.drawFilter.ApplyGLSLFilter();
        AppMethodBeat.o(82732);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82733);
        this.reshapeEyeNoseLipsFilter.setRenderMode(i);
        this.reshapeWholeFaceFilter.setRenderMode(i);
        this.reshapeCombineFilter.setRenderMode(i);
        this.copyFilter.setRenderMode(i);
        this.cropFilter.setRenderMode(i);
        this.drawFilter.setRenderMode(i);
        AppMethodBeat.o(82733);
    }

    private void initFilter(List<PointF> list, float[] fArr, int i, int i2) {
        int i3;
        AppMethodBeat.i(82734);
        if (this.faceOutline == null || this.faceOutline.length != list.size()) {
            this.faceOutline = (int[][]) Array.newInstance(Integer.TYPE, new int[]{list.size(), 2});
        }
        int i4 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i5 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i6 = j.INVALID_ID;
        int i7 = j.INVALID_ID;
        int i8 = 0;
        while (true) {
            i3 = i8;
            if (i3 >= list.size()) {
                break;
            }
            if (((float) i4) > ((PointF) list.get(i3)).x) {
                i4 = (int) ((PointF) list.get(i3)).x;
            }
            if (((float) i5) > ((PointF) list.get(i3)).y) {
                i5 = (int) ((PointF) list.get(i3)).y;
            }
            if (((float) i6) < ((PointF) list.get(i3)).x) {
                i6 = (int) ((PointF) list.get(i3)).x;
            }
            if (((float) i7) < ((PointF) list.get(i3)).y) {
                i7 = (int) ((PointF) list.get(i3)).y;
            }
            i8 = i3 + 1;
        }
        i8 = (i6 + i4) / 2;
        i3 = (i7 + i5) / 2;
        i7 = (int) (((double) Math.max(i6 - i4, i7 - i5)) * 2.5d);
        i6 = i7 / 2;
        i5 = i8 - i6;
        i4 = i3 - i6;
        int i9 = i8 + i6;
        i6 += i3;
        i8 = 0;
        while (true) {
            i3 = i8;
            if (i3 >= list.size()) {
                break;
            }
            this.faceOutline[i3][0] = (int) (((PointF) list.get(i3)).x - ((float) i5));
            this.faceOutline[i3][1] = (int) (((PointF) list.get(i3)).y - ((float) i4));
            i8 = i3 + 1;
        }
        float[] fArr2 = new float[]{((float) i5) / ((float) i), ((float) i4) / ((float) i2), ((float) i5) / ((float) i), ((float) i6) / ((float) i2), ((float) i9) / ((float) i), ((float) i6) / ((float) i2), ((float) i9) / ((float) i), ((float) i4) / ((float) i2)};
        this.cropFilter.setTexCords(fArr2);
        for (i8 = 0; i8 < 8; i8++) {
            fArr2[i8] = (fArr2[i8] * 2.0f) - 1.0f;
        }
        this.drawFilter.setPositions(fArr2);
        this.mCropWidth = i7;
        _initFilter(this.faceOutline, fArr, i7, i7);
        AppMethodBeat.o(82734);
    }

    private void initFilter4(List<PointF> list, float[] fArr, int i, int i2) {
        int i3;
        AppMethodBeat.i(82735);
        if (this.faceOutline == null || this.faceOutline.length != list.size()) {
            this.faceOutline = (int[][]) Array.newInstance(Integer.TYPE, new int[]{list.size(), 2});
        }
        int i4 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i5 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i6 = j.INVALID_ID;
        int i7 = j.INVALID_ID;
        int i8 = 0;
        while (true) {
            i3 = i8;
            if (i3 >= list.size()) {
                break;
            }
            if (((float) i4) > ((PointF) list.get(i3)).x) {
                i4 = (int) ((PointF) list.get(i3)).x;
            }
            if (((float) i5) > ((PointF) list.get(i3)).y) {
                i5 = (int) ((PointF) list.get(i3)).y;
            }
            if (((float) i6) < ((PointF) list.get(i3)).x) {
                i6 = (int) ((PointF) list.get(i3)).x;
            }
            if (((float) i7) < ((PointF) list.get(i3)).y) {
                i7 = (int) ((PointF) list.get(i3)).y;
            }
            i8 = i3 + 1;
        }
        i8 = (i6 + i4) / 2;
        i3 = (i7 + i5) / 2;
        i7 = (int) (((float) Math.max(i6 - i4, i7 - i5)) * 2.5f);
        i6 = i7 / 2;
        i5 = i8 - i6;
        i4 = i3 - i6;
        int i9 = i8 + i6;
        i6 += i3;
        i8 = 0;
        while (true) {
            i3 = i8;
            if (i3 < list.size()) {
                this.faceOutline[i3][0] = (int) (((PointF) list.get(i3)).x - ((float) i5));
                this.faceOutline[i3][1] = (int) (((PointF) list.get(i3)).y - ((float) i4));
                i8 = i3 + 1;
            } else {
                Map map = this.cameraBeautyParams.param;
                map.clear();
                map.put("size", new float[]{(float) i, (float) i2});
                map.put("vectorMapSize", new float[]{(float) i7, (float) i7});
                this.reshapeCombineFilter.updateSize(((float) i5) / ((float) i), ((float) i9) / ((float) i), ((float) i4) / ((float) i2), ((float) i6) / ((float) i2));
                this.reshapeCombineFilter.setParam(map);
                _initFilter(this.faceOutline, fArr, i7, i7);
                AppMethodBeat.o(82735);
                return;
            }
        }
    }

    private void _initFilter(int[][] iArr, float[] fArr, int i, int i2) {
        int i3;
        AppMethodBeat.i(82736);
        float[] fArr2 = new float[]{((float) (iArr[55][0] + iArr[63][0])) / 2.0f, ((float) (iArr[55][1] + iArr[63][1])) / 2.0f};
        float[] fArr3 = new float[]{((float) (iArr[23][0] + iArr[31][0])) / 2.0f, ((float) (iArr[23][1] + iArr[31][1])) / 2.0f};
        r9 = new float[2];
        r9[0] = getDistance(iArr[39], iArr[35]) / ((float) i);
        r9[1] = getDistance(iArr[41], iArr[37]) / ((float) i2);
        float[] fArr4 = new float[]{((float) iArr[43][0]) / ((float) i), ((float) iArr[43][1]) / ((float) i2)};
        r11 = new float[2];
        r11[0] = getDistance(iArr[45], iArr[49]) / ((float) i);
        r11[1] = getDistance(iArr[51], iArr[47]) / ((float) i2);
        float[] fArr5 = new float[]{((float) iArr[53][0]) / ((float) i), ((float) iArr[53][1]) / ((float) i2)};
        float[] fArr6 = new float[]{((fArr2[0] + ((float) iArr[59][0])) / 2.0f) / ((float) i), ((fArr2[1] + ((float) iArr[59][1])) / 2.0f) / ((float) i2)};
        r14 = new float[2];
        r14[0] = getDistance(iArr[61], iArr[57]) / ((float) i);
        r14[1] = getDistance(fArr2, new float[]{(float) iArr[59][0], (float) iArr[59][1]}) / ((float) i2);
        float[] fArr7 = new float[]{((float) iArr[64][0]) / ((float) i), ((float) iArr[64][1]) / ((float) i2)};
        float[] fArr8 = new float[]{((float) (iArr[56][0] + iArr[62][0])) / 2.0f, ((float) (iArr[56][1] + iArr[62][1])) / 2.0f};
        Object obj = new float[2];
        obj[0] = ((getDistance(iArr[62], iArr[56]) + getDistance(iArr[61], iArr[57])) / 2.0f) / ((float) i);
        obj[1] = getDistance(fArr8, iArr[59]) / ((float) i2);
        Object obj2 = new float[]{(((float) (iArr[61][0] + iArr[57][0])) / 2.0f) / ((float) i), (((float) (iArr[61][1] + iArr[57][1])) / 2.0f) / ((float) i2)};
        float f = ((float) (((iArr[75][0] + iArr[79][0]) + iArr[67][0]) + iArr[71][0])) / 4.0f;
        float f2 = ((float) (((iArr[75][1] + iArr[79][1]) + iArr[67][1]) + iArr[71][1])) / 4.0f;
        Object obj3 = new float[]{f / ((float) i), f2 / ((float) i2)};
        r19 = new float[2];
        r19[0] = getDistance(iArr[66], iArr[65]) / ((float) i);
        r19[1] = getDistance(iArr[77], iArr[69]) / ((float) i2);
        Object obj4 = new float[]{((float) iArr[65][0]) / ((float) i), ((float) iArr[65][1]) / ((float) i2)};
        Object obj5 = new float[]{((float) iArr[66][0]) / ((float) i), ((float) iArr[66][1]) / ((float) i2)};
        Object obj6 = new float[2];
        obj6[0] = r19[0] / 3.0f;
        obj6[1] = getDistance(iArr[2], iArr[8]) / ((float) i2);
        Object obj7 = new float[]{(((float) (iArr[4][0] + iArr[3][0])) / 2.0f) / ((float) i), (((float) (iArr[4][1] + iArr[3][1])) / 2.0f) / ((float) i2)};
        float atan2 = (float) (Math.atan2((double) (iArr[8][1] - iArr[1][1]), (double) (iArr[8][0] - iArr[1][0])) + 1.5707963267948966d);
        Object obj8 = new float[2];
        obj8[0] = r19[0] / 3.0f;
        obj8[1] = getDistance(iArr[16], iArr[10]) / ((float) i2);
        Object obj9 = new float[]{(((float) (iArr[15][0] + iArr[14][0])) / 2.0f) / ((float) i), (((float) (iArr[15][1] + iArr[14][1])) / 2.0f) / ((float) i2)};
        float atan22 = (float) (Math.atan2((double) (iArr[17][1] - iArr[10][1]), (double) (iArr[17][0] - iArr[10][0])) + 1.5707963267948966d);
        float f3 = 0.0f;
        f2 = 0.0f;
        for (i3 = 19; i3 <= 26; i3++) {
            f3 += (float) iArr[i3][0];
            f2 += (float) iArr[i3][1];
        }
        f2 /= 8.0f;
        Object obj10 = new float[]{(f3 / 8.0f) / ((float) i), f2 / ((float) i2)};
        r29 = new float[2];
        r29[0] = getDistance(iArr[19], iArr[23]) / ((float) i);
        r29[1] = getDistance(iArr[21], iArr[25]) / ((float) i2);
        f3 = 0.0f;
        f2 = 0.0f;
        for (i3 = 27; i3 <= 34; i3++) {
            f3 += (float) iArr[i3][0];
            f2 += (float) iArr[i3][1];
        }
        f = f3 / 8.0f;
        f2 /= 8.0f;
        float[] fArr9 = new float[]{f / ((float) i), f2 / ((float) i2)};
        r5 = new float[2];
        r5[0] = getDistance(iArr[27], iArr[31]) / ((float) i);
        r5[1] = getDistance(iArr[29], iArr[33]) / ((float) i2);
        r30 = new float[2];
        r30[0] = getDistance(iArr[0], iArr[18]) / ((float) i);
        r30[1] = (getDistance(new float[]{(float) iArr[9][0], (float) iArr[9][1]}, fArr3) * 1.1f) / ((float) i2);
        fArr3 = new float[]{(((float) (iArr[1][0] + iArr[17][0])) / 2.0f) / ((float) i), (((float) (iArr[1][1] + iArr[17][1])) / 2.0f) / ((float) i2)};
        Object obj11 = new float[]{(((float) (iArr[56][0] + iArr[62][0])) / 2.0f) / ((float) i), (((float) (iArr[56][1] + iArr[62][1])) / 2.0f) / ((float) i2)};
        r32 = new float[2];
        r32[0] = getDistance(iArr[2], iArr[57]) / ((float) i);
        r32[1] = getDistance(iArr[2], iArr[8]) / ((float) i2);
        Object obj12 = new float[]{(((float) (iArr[4][0] + iArr[5][0])) / 2.0f) / ((float) i), (((float) (iArr[4][1] + iArr[5][1])) / 2.0f) / ((float) i2)};
        for (i3 = 0; i3 < 2; i3++) {
            obj12[i3] = obj12[i3] + ((obj11[i3] - obj12[i3]) * 0.07f);
        }
        float atan23 = (float) (Math.atan2((double) (iArr[8][1] - iArr[1][1]), (double) (iArr[8][0] - iArr[1][0])) + 1.5707963267948966d);
        r35 = new float[2];
        r35[0] = getDistance(iArr[16], iArr[61]) / ((float) i);
        r35[1] = getDistance(iArr[16], iArr[10]) / ((float) i2);
        Object obj13 = new float[]{(((float) (iArr[13][0] + iArr[14][0])) / 2.0f) / ((float) i), (((float) (iArr[13][1] + iArr[14][1])) / 2.0f) / ((float) i2)};
        for (i3 = 0; i3 < 2; i3++) {
            obj13[i3] = obj13[i3] + ((obj11[i3] - obj13[i3]) * 0.07f);
        }
        float atan24 = (float) (Math.atan2((double) (iArr[17][1] - iArr[10][1]), (double) (iArr[17][0] - iArr[10][0])) + 1.5707963267948966d);
        Object obj14 = new float[]{((((float) iArr[4][0]) * 0.5f) + (((float) iArr[14][0]) * 0.5f)) / ((float) i), ((((float) iArr[4][1]) * 0.6f) + (((float) iArr[14][1]) * 0.4f)) / ((float) i2)};
        r39 = new float[2];
        r39[0] = getDistance(iArr[15], iArr[3]) / ((float) i);
        r39[1] = getDistance(iArr[9], iArr[59]) / ((float) i2);
        fArr8 = new float[]{fArr2[0] + ((fArr2[0] - ((float) iArr[9][0])) * 0.7f), fArr2[1] + ((fArr2[1] - ((float) iArr[9][1])) * 0.7f)};
        r40 = new float[2];
        r40[0] = getDistance(iArr[0], iArr[18]) / ((float) i);
        r40[1] = getDistance(new float[]{(float) iArr[59][0], (float) iArr[59][1]}, fArr2) / ((float) i2);
        Object obj15 = new float[]{fArr[0], fArr[1], fArr[2]};
        obj15[2] = (float) Math.atan2((double) (iArr[53][1] - iArr[43][1]), (double) (iArr[53][0] - iArr[43][0]));
        f = (float) Math.min(0.8353981633974483d, Math.max(-0.8353981633974483d, ((double) obj15[1]) * 1.0d));
        float cos = (float) Math.cos((double) f);
        float[] fArr10 = new float[]{((float) iArr[0][0]) + ((fArr2[0] - ((float) iArr[9][0])) * 0.7f), ((float) iArr[0][1]) + ((fArr2[1] - ((float) iArr[9][1])) * 0.7f)};
        float[] fArr11 = new float[2];
        fArr11[0] = ((float) iArr[18][0]) + ((fArr2[0] - ((float) iArr[9][0])) * 0.7f);
        fArr11[1] = ((fArr2[1] - ((float) iArr[9][1])) * 0.7f) + ((float) iArr[18][1]);
        if (f < 0.0f) {
            fArr8 = new float[2];
            fArr8[0] = fArr10[0] + (((fArr11[0] - fArr10[0]) / cos) / 2.0f);
            fArr8[1] = (((fArr11[1] - fArr10[1]) / cos) / 2.0f) + fArr10[1];
        } else {
            fArr8 = new float[2];
            fArr8[0] = fArr11[0] + (((fArr10[0] - fArr11[0]) / cos) / 2.0f);
            fArr8[1] = (((fArr10[1] - fArr11[1]) / cos) / 2.0f) + fArr11[1];
        }
        fArr8[0] = fArr8[0] / ((float) i);
        fArr8[1] = fArr8[1] / ((float) i2);
        r40[0] = r40[0] / cos;
        Map map = this.cameraBeautyParams.param;
        map.clear();
        map.put("angles", obj15);
        map.put("size", new float[]{(float) i, (float) i2});
        map.put("leftEyePlainSize", r9);
        map.put("leftEyeCenter", fArr4);
        map.put("rightEyePlainSize", r11);
        map.put("rightEyeCenter", fArr5);
        map.put("nose3DCenter", fArr6);
        map.put("nosePlainSize", r14);
        map.put("noseTipCenter", fArr7);
        map.put("noseTipPlaneSize", obj);
        map.put("noseBottomCenter", obj2);
        map.put("lipsCenter", obj3);
        map.put("lipsPlainSize", r19);
        map.put("leftEyebrowCenter", obj10);
        map.put("leftEyebrowPlainSize", r29);
        map.put("rightEyebrowCenter", fArr9);
        map.put("rightEyebrowPlainSize", r5);
        map.put("lipsProtectSizeLeft", obj6);
        map.put("lipsProtectCenterLeft", obj7);
        map.put("lipsProtectAngleLeft", Float.valueOf(atan2));
        map.put("lipsProtectSizeRight", obj8);
        map.put("lipsProtectCenterRight", obj9);
        map.put("lipsProtectAngleRight", Float.valueOf(atan22));
        this.reshapeEyeNoseLipsFilter.setParam(map);
        map.clear();
        map.put("angles", obj15);
        map.put("size", new float[]{(float) i, (float) i2});
        map.put("leftEyePlainSize", r9);
        map.put("leftEyeCenter", fArr4);
        map.put("rightEyePlainSize", r11);
        map.put("rightEyeCenter", fArr5);
        map.put("leftEyebrowCenter", obj10);
        map.put("leftEyebrowPlainSize", r29);
        map.put("rightEyebrowCenter", fArr9);
        map.put("rightEyebrowPlainSize", r5);
        map.put("nose3DCenter", fArr6);
        map.put("nosePlainSize", r14);
        map.put("lipsCenter", obj3);
        map.put("lipsPlainSize", r19);
        map.put("lipsLeftEdge", obj4);
        map.put("lipsRightEdge", obj5);
        map.put("facePlainSize", r30);
        map.put("faceCenter", fArr3);
        map.put("facePlainSizeLeft2", r32);
        map.put("faceCenterLeft2", obj12);
        map.put("leftAngle2", Float.valueOf(atan23));
        map.put("facePlainSizeRight2", r35);
        map.put("faceCenterRight2", obj13);
        map.put("rightAngle2", Float.valueOf(atan24));
        map.put("faceMoveCenter2", obj11);
        map.put("jawCenterOfGravity", obj14);
        map.put("jawSize", r39);
        map.put("foreheadCenter", fArr8);
        map.put("foreheadSize", r40);
        this.reshapeWholeFaceFilter.setParam(map);
        AppMethodBeat.o(82736);
    }

    private float getDistance(float[] fArr, int[] iArr) {
        AppMethodBeat.i(82737);
        float f = fArr[0] - ((float) iArr[0]);
        float f2 = fArr[1] - ((float) iArr[1]);
        f = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        AppMethodBeat.o(82737);
        return f;
    }

    private float getDistance(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(82738);
        float f = fArr[0] - fArr2[0];
        float f2 = fArr[1] - fArr2[1];
        f = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        AppMethodBeat.o(82738);
        return f;
    }

    private float getDistance(int[] iArr, int[] iArr2) {
        AppMethodBeat.i(82739);
        float f = (float) (iArr[0] - iArr2[0]);
        float f2 = (float) (iArr[1] - iArr2[1]);
        f = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        AppMethodBeat.o(82739);
        return f;
    }

    public void clear() {
        AppMethodBeat.i(82740);
        if (this.reshapeCombineFilter != null) {
            this.reshapeCombineFilter.clearGLSLSelf();
        }
        if (this.reshapeEyeNoseLipsFilter != null) {
            this.reshapeEyeNoseLipsFilter.clearGLSLSelf();
        }
        if (this.reshapeWholeFaceFilter != null) {
            this.reshapeWholeFaceFilter.clearGLSLSelf();
        }
        if (this.copyFilter != null) {
            this.copyFilter.clearGLSLSelf();
        }
        if (this.cropFilter != null) {
            this.cropFilter.clearGLSLSelf();
        }
        if (this.drawFilter != null) {
            this.drawFilter.clearGLSLSelf();
        }
        if (this.eyesFrame != null) {
            this.eyesFrame.clear();
        }
        if (this.noseFrame != null) {
            this.noseFrame.clear();
        }
        if (this.reshapeCombineFrame != null) {
            this.reshapeCombineFrame.clear();
        }
        if (this.tempFrame != null) {
            this.tempFrame.clear();
        }
        if (this.cropFrame != null) {
            this.cropFrame.clear();
        }
        if (this.copyFrame != null) {
            this.copyFrame.clear();
        }
        AppMethodBeat.o(82740);
    }

    private h processReshape(h hVar, List<List<PointF>> list, List<float[]> list2, double d) {
        AppMethodBeat.i(82741);
        this.cameraBeautyParams.updateReshapeParams();
        Map map = this.cameraBeautyParams.param;
        this.reshapeEyeNoseLipsFilter.setParam(map);
        this.reshapeWholeFaceFilter.setParam(map);
        int i = 0;
        h hVar2 = hVar;
        while (i < list.size()) {
            List<PointF> facePointf83to90 = FaceDetectUtil.facePointf83to90(VideoMaterialUtil.copyList((List) list.get(i)));
            for (PointF pointF : facePointf83to90) {
                pointF.x = (float) (((double) pointF.x) / d);
                pointF.y = (float) (((double) pointF.y) / d);
            }
            initFilter(facePointf83to90, (float[]) list2.get(i), hVar.width, hVar.height);
            this.cropFilter.RenderProcess(hVar2.texture[0], this.mCropWidth, this.mCropWidth, -1, 0.0d, this.cropFrame);
            this.reshapeEyeNoseLipsFilter.RenderProcess(this.cropFrame.texture[0], this.mCropWidth, this.mCropWidth, -1, 0.0d, this.eyesFrame);
            this.reshapeWholeFaceFilter.RenderProcess(this.eyesFrame.texture[0], this.mCropWidth, this.mCropWidth, -1, 0.0d, this.noseFrame);
            h hVar3 = this.noseFrame;
            this.copyFilter.RenderProcess(hVar2.texture[0], hVar.width, hVar.height, -1, 0.0d, this.reshapeCombineFrame);
            this.drawFilter.RenderProcess(hVar3.texture[0], hVar.width, hVar.height, -1, 0.0d, this.reshapeCombineFrame);
            i++;
            hVar2 = this.reshapeCombineFrame;
        }
        AppMethodBeat.o(82741);
        return hVar2;
    }

    private h processReshape4(h hVar, List<List<PointF>> list, List<float[]> list2, double d) {
        AppMethodBeat.i(82742);
        BenchUtil.benchStart("[showPreview]processReshape4 prepare");
        if (this.cameraBeautyParams.needRender()) {
            this.cameraBeautyParams.updateReshapeParams4();
            Map map = this.cameraBeautyParams.param;
            this.reshapeEyeNoseLipsFilter.setParam(map);
            this.reshapeWholeFaceFilter.setParam(map);
            FrameUtil.clearFrame(this.tempFrame, 0.49803922f, 0.49803922f, 0.5019608f, 0.5019608f, 128, 128);
            h hVar2 = this.tempFrame;
            BenchUtil.benchEnd("[showPreview]processReshape4 prepare");
            int i = 0;
            h hVar3 = hVar;
            h hVar4 = hVar2;
            while (i < list.size()) {
                h hVar5;
                BenchUtil.benchStart("[showPreview]processReshape4 initFilter 0");
                this.facePoints = VideoMaterialUtil.copyList((List) list.get(i));
                List<PointF> facePointf83to90 = FaceDetectUtil.facePointf83to90(this.facePoints);
                for (PointF pointF : facePointf83to90) {
                    pointF.x = (float) (((double) pointF.x) / d);
                    pointF.y = (float) (((double) pointF.y) / d);
                }
                BenchUtil.benchEnd("[showPreview]processReshape4 initFilter 0");
                BenchUtil.benchStart("[showPreview]processReshape4 initFilter4");
                initFilter4(facePointf83to90, (float[]) list2.get(i), hVar.width, hVar.height);
                BenchUtil.benchEnd("[showPreview]processReshape4 initFilter4");
                if (this.cameraBeautyParams.needRenderEyeNoseLips()) {
                    BenchUtil.benchStart("[showPreview]processReshape4 reshapeEyeNoseLipsFilter");
                    this.reshapeEyeNoseLipsFilter.RenderProcess(hVar4.texture[0], 128, 128, -1, 0.0d, this.eyesFrame);
                    hVar4 = this.eyesFrame;
                    BenchUtil.benchEnd("[showPreview]processReshape4 reshapeEyeNoseLipsFilter");
                }
                if (this.cameraBeautyParams.needRenderWholeFace()) {
                    BenchUtil.benchStart("[showPreview]processReshape4 reshapeWholeFaceFilter");
                    this.reshapeWholeFaceFilter.RenderProcess(hVar4.texture[0], 128, 128, -1, 0.0d, this.noseFrame);
                    hVar5 = this.noseFrame;
                    BenchUtil.benchEnd("[showPreview]processReshape4 reshapeWholeFaceFilter");
                } else {
                    hVar5 = hVar4;
                }
                BenchUtil.benchStart("[showPreview]processReshape4 copyFilter 0");
                map.clear();
                map.put("inputImageTexture2", Integer.valueOf(hVar5.texture[0]));
                this.copyFilter.RenderProcess(hVar3.texture[0], hVar3.width, hVar3.height, -1, 0.0d, this.reshapeCombineFrame);
                BenchUtil.benchEnd("[showPreview]processReshape4 copyFilter 0");
                BenchUtil.benchStart("[showPreview]processReshape4 reshapeCombineFilter");
                this.reshapeCombineFilter.setParam(map);
                this.reshapeCombineFilter.RenderProcess(hVar3.texture[0], hVar3.width, hVar3.height, -1, 0.0d, this.reshapeCombineFrame);
                BenchUtil.benchEnd("[showPreview]processReshape4 reshapeCombineFilter");
                hVar2 = this.reshapeCombineFrame;
                if (i < list.size() - 1) {
                    BenchUtil.benchStart("[showPreview]processReshape4 copyFilter 1");
                    this.copyFilter.RenderProcess(this.reshapeCombineFrame.texture[0], this.reshapeCombineFrame.width, this.reshapeCombineFrame.height, -1, 0.0d, this.copyFrame);
                    BenchUtil.benchEnd("[showPreview]processReshape4 copyFilter 1");
                    hVar2 = this.copyFrame;
                }
                i++;
                hVar3 = hVar2;
                hVar4 = hVar5;
            }
            AppMethodBeat.o(82742);
            return hVar3;
        }
        AppMethodBeat.o(82742);
        return hVar;
    }

    public h process(h hVar, List<List<PointF>> list, List<float[]> list2, double d) {
        AppMethodBeat.i(82743);
        h processReshape4;
        if (this.useMeshType == 0) {
            processReshape4 = processReshape4(hVar, list, list2, d);
            AppMethodBeat.o(82743);
            return processReshape4;
        }
        processReshape4 = processReshape(hVar, list, list2, d);
        AppMethodBeat.o(82743);
        return processReshape4;
    }

    public void setParam(int i, float f) {
        AppMethodBeat.i(82744);
        this.cameraBeautyParams.setParam(i, f);
        AppMethodBeat.o(82744);
    }

    public void setIsForPhotoEdit(boolean z) {
        this.isForPhotoEdit = z;
    }
}
