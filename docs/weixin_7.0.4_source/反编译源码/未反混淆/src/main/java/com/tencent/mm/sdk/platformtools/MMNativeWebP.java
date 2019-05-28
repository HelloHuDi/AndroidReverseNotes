package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;

public final class MMNativeWebP {
    public static native Bitmap nativeDecodeByteArray(byte[] bArr, Options options);

    public static native byte[] nativeEncodeBitmap(Bitmap bitmap, int i);

    public static native boolean nativeIsWebPImage(byte[] bArr);
}
