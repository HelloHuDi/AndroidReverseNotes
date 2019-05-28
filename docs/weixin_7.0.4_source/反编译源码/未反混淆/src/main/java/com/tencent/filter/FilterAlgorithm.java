package com.tencent.filter;

import android.graphics.Bitmap;

public class FilterAlgorithm {
    public static native void nativeDrawBitmapWithBlendmode(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3);

    public static native void nativeFastBlur(QImage qImage, float f);

    public static native float[] nativeGetMaxAndMin(QImage qImage);

    public static native void nativeImageAutoContrast(QImage qImage, float f);

    public static native void nativeImageAutoTone(QImage qImage);

    public static native void nativeImageHistogramStretch(QImage qImage, float f);

    public static native void nativeUpdateLookupBitmap(QImage qImage, float f);
}
