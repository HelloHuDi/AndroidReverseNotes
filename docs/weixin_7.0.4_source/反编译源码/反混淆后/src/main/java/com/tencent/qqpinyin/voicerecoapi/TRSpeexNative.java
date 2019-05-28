package com.tencent.qqpinyin.voicerecoapi;

public class TRSpeexNative {
    public native int nativeTRSpeexDecode(int i, byte[] bArr, int i2, int i3, byte[] bArr2);

    public native int nativeTRSpeexDecodeInit();

    public native int nativeTRSpeexDecodeRelease(int i);

    public native int nativeTRSpeexEncode(int i, byte[] bArr, int i2, int i3, byte[] bArr2);

    public native int nativeTRSpeexInit();

    public native int nativeTRSpeexRelease(int i);

    TRSpeexNative() {
    }
}
