package com.tencent.mm.audio.mix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SilkResampleJni {
    public static native int clearResample(String str);

    public static native int clearResampleAll();

    public static native int initResample(String str, int i, int i2);

    public static native int resamplePcm(String str, int i, int i2, short[] sArr, int i3, short[] sArr2);

    static {
        AppMethodBeat.i(137084);
        System.loadLibrary("wechataudiosilk");
        AppMethodBeat.o(137084);
    }
}
