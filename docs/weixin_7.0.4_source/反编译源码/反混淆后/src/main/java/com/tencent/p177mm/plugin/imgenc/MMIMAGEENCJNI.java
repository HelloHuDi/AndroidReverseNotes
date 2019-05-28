package com.tencent.p177mm.plugin.imgenc;

/* renamed from: com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI */
public class MMIMAGEENCJNI {
    public static final String TAG = "MMIMAGEENCJNI";

    public static native long free(long j);

    public static native long open(long j);

    public static native long open(String str);

    public static native byte[] readByte(long j, byte[] bArr);

    public static native long seek(long j, long j2, int i);

    public static native long transFor(long j, byte[] bArr, long j2, long j3);
}
