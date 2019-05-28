package com.tencent.p177mm.plugin.appbrand.media.encode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;

/* renamed from: com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni */
public class Mp3EncodeJni {
    public static native void close();

    public static native int encode(short[] sArr, short[] sArr2, int i, byte[] bArr);

    public static native int encodeBufferInterleaved(short[] sArr, int i, byte[] bArr);

    public static native int flush(byte[] bArr);

    public static native int getVersion();

    public static native int init(int i, int i2, int i3, int i4, int i5);

    public static native void setMode(int i);

    static {
        AppMethodBeat.m2504i(105581);
        C1449k.m3079a("mp3lame", Mp3EncodeJni.class.getClassLoader());
        AppMethodBeat.m2505o(105581);
    }
}
