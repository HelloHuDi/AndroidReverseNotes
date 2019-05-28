package com.tencent.p177mm.sdk.platformtools;

import android.graphics.Bitmap;

/* renamed from: com.tencent.mm.sdk.platformtools.mmjpeg */
class mmjpeg {
    public static native int convertToProgressive(String str, String str2);

    public static native boolean decodeToBitmap(String str, Bitmap bitmap);

    public static native int isProgressiveFile(String str);

    public static native JpegParams queryParams(String str);

    public static native int queryQuality(String str);

    mmjpeg() {
    }
}
