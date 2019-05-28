package com.tencent.mm.plugin.collect.model.voice;

public class SynthesizerNative {
    public native int init(byte[] bArr, byte[] bArr2);

    public native int readmoney(byte[] bArr, byte[] bArr2, int i, float f, float f2);

    public native void release();
}
