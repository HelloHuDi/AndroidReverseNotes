package com.tencent.ttpic.util.youtu;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.faceBeauty.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;

public class TTpicBitmapFaceDetect extends b {
    private volatile boolean inited;
    private long mNativeObjPtr;

    private native boolean nativeConstructor();

    private native void nativeDestructor();

    private native TTImageFeature[] nativeDetectBitmap(Bitmap bitmap, boolean z);

    private native TTImageFeature[] nativeDetectBitmapByEyes(Bitmap bitmap, int i, int i2, int i3, int i4);

    private native TTImageFeature[] nativeDetectBitmapByFace(Bitmap bitmap, int i, int i2, int i3, int i4);

    private native float[] nativeGetAngles(int i);

    private native int[][] nativeGetFeatures(int i);

    private native int[][] nativeGetShapePoints(int i);

    private native int nativeInit(String str);

    public TTpicBitmapFaceDetect() {
        AppMethodBeat.i(84365);
        if (YTFaceDetectorBase.getInstance().initFaceTrack() != 0) {
            this.inited = false;
            AppMethodBeat.o(84365);
        } else if (YTFaceDetectorBase.getInstance().initPicFaceDetect() != 0) {
            this.inited = false;
            AppMethodBeat.o(84365);
        } else {
            nativeConstructor();
            this.inited = true;
            AppMethodBeat.o(84365);
        }
    }

    public void destroy() {
        AppMethodBeat.i(84366);
        if (this.inited) {
            nativeDestructor();
            this.inited = false;
        }
        AppMethodBeat.o(84366);
    }

    public void doInitial() {
    }

    private void detectParam(Bitmap bitmap, boolean z, Rect rect, Point point, Point point2) {
        AppMethodBeat.i(84367);
        this.mDetectedFace = false;
        this.mFaceParams.clear();
        this.faceCount = 0;
        if (this.inited && BitmapUtils.isLegal(bitmap)) {
            int i;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = (width > height ? width : height) / 512;
            if (i2 <= 0) {
                i = 1;
            } else {
                i = i2;
            }
            try {
                Object[] nativeDetectBitmap;
                Bitmap createBitmap = Bitmap.createBitmap(width / i, height / i, Config.ARGB_8888);
                new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, width, height), new Rect(0, 0, width / i, height / i), null);
                if (!z) {
                    nativeDetectBitmap = nativeDetectBitmap(createBitmap, false);
                } else if (rect == null) {
                    nativeDetectBitmap = nativeDetectBitmapByEyes(createBitmap, point.x / i, point.y / i, point2.x / i, point2.y / i);
                } else {
                    nativeDetectBitmap = nativeDetectBitmapByFace(createBitmap, rect.left / i, rect.top / i, rect.width() / i, rect.height() / i);
                }
                this.faceCount = size(nativeDetectBitmap);
                for (int i3 = 0; i3 < this.faceCount; i3++) {
                    TTImageFeature tTImageFeature = nativeDetectBitmap[i3];
                    this.mDetectedFace = true;
                    FaceParam faceParam = new FaceParam();
                    Rect rect2 = new Rect();
                    faceParam.bJk = rect2;
                    rect2.left = tTImageFeature.x * i;
                    rect2.top = tTImageFeature.y * i;
                    rect2.right = (tTImageFeature.x * i) + (tTImageFeature.w * i);
                    rect2.bottom = (tTImageFeature.y * i) + (tTImageFeature.h * i);
                    if (rect2.left < 0) {
                        rect2.left = 0;
                    }
                    if (rect2.top < 0) {
                        rect2.top = 0;
                    }
                    if (rect2.right > width) {
                        rect2.right = width;
                    }
                    if (rect2.bottom > height) {
                        rect2.bottom = height;
                    }
                    int i4 = (int) (((double) (tTImageFeature.h * i)) * 0.16d);
                    int i5 = (int) (((double) i4) * 2.0d);
                    Rect rect3 = new Rect();
                    faceParam.bJl = rect3;
                    rect3.left = (tTImageFeature.leftEyeX * i) - (i5 / 2);
                    rect3.right = rect3.left + i5;
                    rect3.top = (tTImageFeature.leftEyeY * i) - (i4 / 2);
                    rect3.bottom = rect3.top + i4;
                    faceParam.bJn = new Point(tTImageFeature.leftEyeX * i, tTImageFeature.leftEyeY * i);
                    Rect rect4 = new Rect();
                    faceParam.bJm = rect4;
                    rect4.left = (tTImageFeature.rightEyeX * i) - (i5 / 2);
                    rect4.right = i5 + rect4.left;
                    rect4.top = (tTImageFeature.rightEyeY * i) - (i4 / 2);
                    rect4.bottom = i4 + rect4.top;
                    faceParam.bJo = new Point(tTImageFeature.rightEyeX * i, tTImageFeature.rightEyeY * i);
                    rect2 = new Rect();
                    faceParam.bJp = rect2;
                    rect2.left = rect3.left;
                    rect2.top = rect3.top;
                    rect2.right = rect4.right;
                    rect2.bottom = rect4.bottom;
                    if (rect2.left < 0) {
                        rect2.left = 0;
                    }
                    if (rect2.top < 0) {
                        rect2.top = 0;
                    }
                    if (rect2.right > width) {
                        rect2.right = width;
                    }
                    if (rect2.bottom > height) {
                        rect2.bottom = height;
                    }
                    i4 = (int) (((double) (tTImageFeature.w * i)) * 0.4d);
                    i5 = (int) (((double) (tTImageFeature.h * i)) * 0.16d);
                    rect3 = new Rect();
                    faceParam.bJq = rect3;
                    rect3.left = (tTImageFeature.mouthX * i) - (i4 / 2);
                    rect3.top = (tTImageFeature.mouthY * i) - (i5 / 2);
                    rect3.right = rect3.left + i4;
                    rect3.bottom = rect3.top + i5;
                    faceParam.width = width;
                    faceParam.height = height;
                    this.mFaceParams.add(faceParam);
                    if (this.mGetFaceGender) {
                        this.mFemale.add(Boolean.TRUE);
                    }
                    if (this.mGetFaceFeatures) {
                        int[][] nativeGetFeatures = nativeGetFeatures(i3);
                        faceParam.bJr = nativeGetFeatures;
                        int size = size(nativeGetFeatures);
                        for (int i6 = 0; i6 < size; i6++) {
                            nativeGetFeatures[i6][0] = nativeGetFeatures[i6][0] * i;
                            nativeGetFeatures[i6][1] = nativeGetFeatures[i6][1] * i;
                        }
                    }
                }
                createBitmap.recycle();
                AppMethodBeat.o(84367);
                return;
            } catch (OutOfMemoryError e) {
                AppMethodBeat.o(84367);
                return;
            }
        }
        AppMethodBeat.o(84367);
    }

    public void doDetectFace(Bitmap bitmap) {
        AppMethodBeat.i(84368);
        detectParam(bitmap, false, null, null, null);
        AppMethodBeat.o(84368);
    }

    public void detectFaceByManual(Bitmap bitmap, Point point, Point point2) {
        AppMethodBeat.i(84369);
        detectParam(bitmap, true, null, point, point2);
        AppMethodBeat.o(84369);
    }

    public void detectFaceByManual(Bitmap bitmap, Rect rect, Point point, Point point2) {
        AppMethodBeat.i(84370);
        detectParam(bitmap, true, rect, point, point2);
        AppMethodBeat.o(84370);
    }

    public float[] getFaceAngles(int i) {
        AppMethodBeat.i(84371);
        float[] nativeGetAngles = nativeGetAngles(i);
        for (int i2 = 0; i2 < nativeGetAngles.length; i2++) {
            nativeGetAngles[i2] = (float) ((((double) nativeGetAngles[i2]) * 3.141592653589793d) / 180.0d);
        }
        AppMethodBeat.o(84371);
        return nativeGetAngles;
    }

    public void doRelease() {
    }

    public int size(Object[] objArr) {
        return objArr == null ? 0 : objArr.length;
    }
}
