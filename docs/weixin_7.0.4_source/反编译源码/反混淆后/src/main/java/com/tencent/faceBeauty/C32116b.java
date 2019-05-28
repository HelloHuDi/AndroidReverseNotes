package com.tencent.faceBeauty;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.util.C16371i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.faceBeauty.b */
public abstract class C32116b {
    public static final int FACE_FEATURE_NUM = 83;
    public static final String TAG = "FaceDetect";
    protected int faceCount = 0;
    protected boolean mDetectedFace;
    public List<FaceParam> mFaceParams = new ArrayList();
    protected List<Boolean> mFemale = new ArrayList();
    protected boolean mGetFaceFeatures = false;
    protected boolean mGetFaceGender = false;

    public abstract void doDetectFace(Bitmap bitmap);

    public abstract void doInitial();

    public abstract void doRelease();

    public final boolean detectedFace() {
        return this.mDetectedFace;
    }

    public void needDetectFaceFeatures(boolean z) {
        this.mGetFaceFeatures = z;
    }

    public void needDetectFaceGender(boolean z) {
        this.mGetFaceGender = z;
    }

    public final void detectFace(Bitmap bitmap) {
        long currentTimeMillis = System.currentTimeMillis();
        doDetectFace(bitmap);
        C16371i.m25186k(TAG, "detectFace() :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void release() {
        doRelease();
    }

    public FaceParam getFaceParams(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return (FaceParam) this.mFaceParams.get(i);
    }

    public Rect getFaces(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return ((FaceParam) this.mFaceParams.get(i)).bJk;
    }

    public int getFaceCount() {
        return this.faceCount;
    }

    public Rect getEyes(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return ((FaceParam) this.mFaceParams.get(i)).bJp;
    }

    public Rect getLeftEyes(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return ((FaceParam) this.mFaceParams.get(i)).bJl;
    }

    public Rect getRightEyes(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return ((FaceParam) this.mFaceParams.get(i)).bJm;
    }

    public Rect getMouths(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return ((FaceParam) this.mFaceParams.get(i)).bJq;
    }

    public Point getRightEyeCenters(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return ((FaceParam) this.mFaceParams.get(i)).bJo;
    }

    public Point getLeftEyeCenters(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return ((FaceParam) this.mFaceParams.get(i)).bJn;
    }

    public int[][] getFaceFeatures(int i) {
        if (i > this.mFaceParams.size() - 1) {
            return null;
        }
        return ((FaceParam) this.mFaceParams.get(i)).bJr;
    }

    public boolean getFaceFemale(int i) {
        if (i > this.mFemale.size() - 1) {
            return false;
        }
        return ((Boolean) this.mFemale.get(i)).booleanValue();
    }

    public void resizeData(int i, int i2) {
        for (int i3 = 0; i3 < this.faceCount; i3++) {
            FaceParam faceParam = (FaceParam) this.mFaceParams.get(i3);
            if (faceParam.height != i2 || faceParam.width != i) {
                float f = ((float) i) / ((float) faceParam.width);
                float f2 = ((float) i2) / ((float) faceParam.height);
                faceParam.height = (int) (((float) faceParam.height) * f2);
                faceParam.width = (int) (((float) faceParam.width) * f);
                Rect rect = faceParam.bJk;
                rect.left = (int) (((float) rect.left) * f);
                rect.top = (int) (((float) rect.top) * f2);
                rect.right = (int) (((float) rect.right) * f);
                rect.bottom = (int) (((float) rect.bottom) * f2);
                rect = faceParam.bJl;
                rect.left = (int) (((float) rect.left) * f);
                rect.top = (int) (((float) rect.top) * f2);
                rect.right = (int) (((float) rect.right) * f);
                rect.bottom = (int) (((float) rect.bottom) * f2);
                Point point = faceParam.bJn;
                point.x = (int) (((float) point.x) * f);
                point.y = (int) (((float) point.y) * f2);
                rect = faceParam.bJm;
                rect.left = (int) (((float) rect.left) * f);
                rect.top = (int) (((float) rect.top) * f2);
                rect.right = (int) (((float) rect.right) * f);
                rect.bottom = (int) (((float) rect.bottom) * f2);
                point = faceParam.bJo;
                point.x = (int) (((float) point.x) * f);
                point.y = (int) (((float) point.y) * f2);
                rect = faceParam.bJp;
                rect.left = (int) (((float) rect.left) * f);
                rect.top = (int) (((float) rect.top) * f2);
                rect.right = (int) (((float) rect.right) * f);
                rect.bottom = (int) (((float) rect.bottom) * f2);
                rect = faceParam.bJq;
                rect.left = (int) (((float) rect.left) * f);
                rect.top = (int) (((float) rect.top) * f2);
                rect.right = (int) (((float) rect.right) * f);
                rect.bottom = (int) (((float) rect.bottom) * f2);
                if (faceParam.bJr != null) {
                    int[][] iArr = faceParam.bJr;
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        iArr[i4][0] = (int) (((float) iArr[i4][0]) * f);
                        iArr[i4][1] = (int) (((float) iArr[i4][1]) * f2);
                    }
                }
                faceParam.height = i2;
                faceParam.width = i;
            }
        }
    }

    public static Rect boundingRect(int[][] iArr, int i, int i2) {
        int i3 = iArr[i][0];
        int i4 = iArr[i][1];
        int i5 = i4;
        int i6 = i4;
        int i7 = i3;
        int i8 = i3;
        for (int i9 = i + 1; i9 <= i2; i9++) {
            if (iArr[i9][0] < i8) {
                i8 = iArr[i9][0];
            } else if (iArr[i9][0] > i7) {
                i7 = iArr[i9][0];
            }
            if (iArr[i9][1] < i6) {
                i6 = iArr[i9][1];
            } else if (iArr[i9][1] > i5) {
                i5 = iArr[i9][1];
            }
        }
        return new Rect(i8, i6, i7, i5);
    }
}
