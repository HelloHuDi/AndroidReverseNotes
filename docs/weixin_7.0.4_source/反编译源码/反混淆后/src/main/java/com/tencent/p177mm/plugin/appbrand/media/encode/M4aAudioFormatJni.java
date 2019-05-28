package com.tencent.p177mm.plugin.appbrand.media.encode;

/* renamed from: com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni */
public class M4aAudioFormatJni {
    public static native void closeM4aFile();

    public static native int createM4aFile(String str, int i, int i2, int i3);

    public static native int writeAudioBuff(byte[] bArr, int i);
}
