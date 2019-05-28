package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;

public class OpencvAlgorithm {
    public static native void nativeDehazeProcess(QImage qImage, float f);

    public static native void nativeDetailEnhanceFilter(QImage qImage, float f);

    public static native int nativeGlowFilterDropShadow(QImage qImage, int i, int i2, int i3, float f);

    public static native int nativeGlowFilterGlow(QImage qImage, int i, int i2, float f);

    public static native int nativeGlowFilterPolyFit(QImage qImage, Bitmap bitmap, int i, float f);

    public static native void nativeImageHdrContrastEnhance(QImage qImage);
}
