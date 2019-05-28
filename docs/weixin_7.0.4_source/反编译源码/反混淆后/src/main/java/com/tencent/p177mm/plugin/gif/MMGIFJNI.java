package com.tencent.p177mm.plugin.gif;

import android.graphics.Bitmap;
import java.io.FileDescriptor;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.gif.MMGIFJNI */
public class MMGIFJNI {
    public static native byte[] decFile(String str, String str2);

    public static native boolean drawFrameBitmap(long j, Bitmap bitmap, int[] iArr);

    public static native boolean drawFramePixels(long j, int[] iArr, int[] iArr2);

    public static native void encFile(String str, String str2);

    public static native String encodeString(String str);

    public static native int getCurrentFrameDuration(long j);

    public static native int getCurrentFrameIndex(long j);

    public static native int getHeight(long j);

    public static native int getTotalFrameCount(long j);

    public static native int getWidth(long j);

    public static native void isEncFile(String str);

    public static native boolean isGif(long j);

    public static native void lockBitmap(Bitmap bitmap);

    public static native long openByByteArray(byte[] bArr, int[] iArr);

    public static native long openByFileDescroptor(FileDescriptor fileDescriptor, long j, int[] iArr);

    public static native long openByFilePath(String str, int[] iArr);

    public static native long openByInputStrem(InputStream inputStream, int[] iArr);

    public static native void recycle(long j);

    public static native void reset(long j);

    public static native void restoreRemainder(long j);

    public static native void saveRemainder(long j);
}
