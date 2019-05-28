package com.tencent.mm.audio.mix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.l;

public class AudioFFmpegDecodeJni {
    protected long cmo = 0;
    protected long cmp = 0;

    public static native int decode(int i, int i2, int i3, String str, l lVar);

    public native int clearResample(String str, Object obj);

    public native int initResample(String str, int i, int i2, int i3, int i4, Object obj);

    public native int resamplePcm(String str, int i, int i2, byte[] bArr, int i3, byte[] bArr2, int i4, Object obj);

    static {
        AppMethodBeat.i(137083);
        System.loadLibrary("FFmpeg");
        AppMethodBeat.o(137083);
    }
}
