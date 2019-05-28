package com.microrapid.face;

import android.graphics.Bitmap;
import com.tencent.filter.MRect;
import com.tencent.filter.QImage;

public class Algorithm {
    static boolean prepared = false;

    public static native void BlendBitmap(Bitmap bitmap, Bitmap bitmap2);

    public static native long nativeAutoFaceHandle();

    public static native void nativeCleanUp(long j);

    public static native void nativeClear();

    public static native void nativeClearAutoPramChanged(long j, int i);

    public static native void nativeDispose(long j);

    public static native double nativeGetAutoParam(long j, int i);

    public static native QImage nativeGetBeginImage(long j);

    public static native void nativeGetEyeMaskPoints(long j, int[] iArr);

    public static native void nativeGetFaceMaskPoints(long j, int[] iArr);

    public static native void nativeGetPouchMaskPoints(long j, int[] iArr);

    public static native boolean nativeIsAutoPramChanged(long j, int i);

    public static native boolean nativeIsInitMak(long j);

    public static native void nativePreProcessImage(long j);

    public static native void nativeProcessBitmap(long j, Bitmap bitmap);

    public static native void nativeSetAutoParam(long j, int i, double d);

    public static native void nativeSetBitmap(long j, Bitmap bitmap);

    public static native boolean nativeSetContrastON(long j, boolean z);

    public static native boolean nativeSetCpuSmoothenOn(long j, boolean z);

    public static native void nativeSetEyeMak(long j, Bitmap bitmap);

    public static native void nativeSetFaceFeatures(long j, int[][] iArr);

    public static native void nativeSetFaceInfo(long j, MRect mRect, MRect mRect2, MRect mRect3, MRect mRect4);

    public static native void nativeSetFaceMak(long j, Bitmap bitmap);

    public static native void nativeSetLipsMak(long j, Bitmap bitmap, MRect mRect);

    public static native void nativeSetMask(byte[] bArr, int i, int i2, int i3, int i4);

    public static native void nativeSetPouchMak(long j, Bitmap bitmap);

    public static native void nativeSetSkinMask(Bitmap bitmap, int i);

    public static native void nativeSmoothFace14(QImage qImage, float f);

    public static native void nativeSmoothImage(long j, QImage qImage);

    public static native void nativeSurfaceBlurAndSmoothmage(QImage qImage, int i);

    public static native void nativesetGlossyImage(long j, QImage qImage);
}
