package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;

class mmjpeg {
    public static native int convertToProgressive(String str, String str2);

    public static native boolean decodeToBitmap(String str, Bitmap bitmap);

    public static native int isProgressiveFile(String str);

    public static native JpegParams queryParams(String str);

    public static native int queryQuality(String str);

    mmjpeg() {
    }
}
