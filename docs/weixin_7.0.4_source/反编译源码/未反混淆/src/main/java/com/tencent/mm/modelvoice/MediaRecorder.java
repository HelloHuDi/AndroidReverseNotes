package com.tencent.mm.modelvoice;

import com.tencent.mm.pointers.PByteArray;

public class MediaRecorder {
    public static final int[] fYW = new int[]{13, 14, 16, 18, 20, 21, 27, 32};

    public static native int SetVoiceSilkControl(int i, int i2);

    public static native int SetVoiceSilkDecControl(int i, byte[] bArr, int i2);

    public static native int SilkDecInit(int i, byte[] bArr, int i2);

    public static native int SilkDecUnInit();

    public static native int SilkDoDec(byte[] bArr, short s);

    public static native int SilkDoEnc(byte[] bArr, short s, byte[] bArr2, short[] sArr, boolean z);

    public static native int SilkEncInit(int i, int i2, int i3);

    public static native int SilkEncUnInit();

    public static native int SilkGetEncSampleRate(byte[] bArr);

    public static native boolean native_init();

    public static native boolean native_pcm2amr(int i, byte[] bArr, int i2, PByteArray pByteArray, int i3);

    public static native boolean native_pcmresamp(byte[] bArr, int i, PByteArray pByteArray);

    public static native boolean native_release();
}
