package com.tencent.faceBeauty;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends b {
    /* Access modifiers changed, original: protected|final */
    public final void doInitial() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void doDetectFace(Bitmap bitmap) {
        AppMethodBeat.i(86274);
        this.mDetectedFace = false;
        this.mFaceParams.clear();
        this.faceCount = 0;
        if (bitmap == null) {
            AppMethodBeat.o(86274);
            return;
        }
        int i;
        float eyesDistance;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        PointF pointF = new PointF();
        if (bitmap.getConfig() == Config.RGB_565) {
            i = 1;
        } else {
            i = (width > height ? width : height) / 512;
            if (i <= 0) {
                i = 1;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width / i, height / i, Config.RGB_565);
                new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, width, height), new Rect(0, 0, width / i, height / i), null);
                bitmap = createBitmap;
            } catch (OutOfMemoryError e) {
                pointF.x = (float) (bitmap.getWidth() / 2);
                pointF.y = (float) (bitmap.getHeight() / 2);
                a(pointF, (float) (bitmap.getWidth() / 4), width, height);
                AppMethodBeat.o(86274);
                return;
            }
        }
        Face[] faceArr = new Face[10];
        int findFaces = new FaceDetector(bitmap.getWidth(), bitmap.getHeight(), 10).findFaces(bitmap, faceArr);
        bitmap.recycle();
        this.faceCount = findFaces;
        for (int i3 = 0; i3 < this.faceCount; i3++) {
            Face face = faceArr[i3];
            eyesDistance = face.eyesDistance();
            int i4 = i3;
            for (i2 = i3 + 1; i2 < this.faceCount; i2++) {
                float eyesDistance2 = faceArr[i2].eyesDistance();
                if (eyesDistance2 > eyesDistance) {
                    eyesDistance = eyesDistance2;
                    i4 = i2;
                }
            }
            if (i4 != i3) {
                Face face2 = faceArr[i4];
                faceArr[i4] = face;
                faceArr[i3] = face2;
            }
        }
        for (i2 = 0; i2 < findFaces; i2++) {
            this.mDetectedFace = true;
            faceArr[i2].getMidPoint(pointF);
            eyesDistance = faceArr[i2].eyesDistance();
            pointF.x *= (float) i;
            pointF.y *= (float) i;
            a(pointF, eyesDistance * ((float) i), width, height);
        }
        AppMethodBeat.o(86274);
    }

    private void a(PointF pointF, float f, int i, int i2) {
        AppMethodBeat.i(86275);
        FaceParam faceParam = new FaceParam();
        Rect rect = new Rect();
        faceParam.bJk = rect;
        rect.left = (int) (((double) pointF.x) - (((double) f) * 1.2d));
        rect.top = (int) (((double) pointF.y) - (((double) f) * 0.9d));
        rect.right = (int) (((double) pointF.x) + (((double) f) * 1.2d));
        rect.bottom = (int) (((double) pointF.y) + (((double) f) * 1.4d));
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > i) {
            rect.right = i;
        }
        if (rect.bottom > i2) {
            rect.bottom = i2;
        }
        Rect rect2 = new Rect();
        faceParam.bJp = rect2;
        rect2.left = (int) (((double) pointF.x) - (0.8d * ((double) f)));
        rect2.top = (int) (((double) pointF.y) - (((double) f) * 0.2d));
        rect2.right = (int) (((double) pointF.x) + (0.8d * ((double) f)));
        rect2.bottom = (int) (((double) pointF.y) + (((double) f) * 0.28d));
        if (rect2.left < 0) {
            rect2.left = 0;
        }
        if (rect2.top < 0) {
            rect2.top = 0;
        }
        if (rect2.right > i) {
            rect2.right = i;
        }
        if (rect2.bottom > i2) {
            rect2.bottom = i2;
        }
        Rect rect3 = new Rect();
        faceParam.bJl = rect3;
        rect3.left = rect2.left;
        rect3.right = ((rect2.width() * 3) / 7) + rect3.left;
        rect3.top = rect2.top - (rect2.height() / 6);
        rect3.bottom = ((rect2.height() * 4) / 3) + rect3.top;
        faceParam.bJn = new Point(rect3.centerX(), rect3.centerY());
        Rect rect4 = new Rect(rect3);
        faceParam.bJm = rect4;
        rect4.left += (rect2.width() * 2) / 3;
        rect4.right = ((rect2.width() * 2) / 3) + rect4.right;
        faceParam.bJo = new Point(rect4.centerX(), rect4.centerY());
        rect2 = new Rect();
        faceParam.bJq = rect2;
        rect2.left = (int) (((double) rect.left) + ((((double) rect.width()) * 0.6d) / 2.0d));
        rect2.top = (int) (((double) rect.top) + (((double) rect.height()) * 0.72d));
        rect2.right = ((int) (((double) rect.width()) * 0.4d)) + rect2.left;
        rect2.bottom = ((int) (((double) rect.height()) * 0.16000000000000003d)) + rect2.top;
        faceParam.width = i;
        faceParam.height = i2;
        this.mFaceParams.add(faceParam);
        AppMethodBeat.o(86275);
    }

    /* Access modifiers changed, original: protected|final */
    public final void doRelease() {
    }
}
