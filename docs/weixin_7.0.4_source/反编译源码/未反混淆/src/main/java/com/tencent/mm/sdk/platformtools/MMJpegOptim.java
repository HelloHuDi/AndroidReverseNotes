package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;

public class MMJpegOptim {
    public static native boolean checkIntegrity(String str);

    public static native int compressByQuality(Bitmap bitmap, int i, boolean z, String str);

    public static native int compressByQualityOptim(Bitmap bitmap, int i, boolean z, String str);

    public static native int convertToProgressive(String str, String str2, int i);

    public static native int decodeToBitmap(String str, Bitmap bitmap, int i);

    public static native int isProgressiveFile(String str);

    public static native int queryQuality(String str);

    MMJpegOptim() {
    }
}
