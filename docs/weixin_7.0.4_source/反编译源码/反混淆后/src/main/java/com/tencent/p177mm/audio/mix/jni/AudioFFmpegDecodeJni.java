package com.tencent.p177mm.audio.mix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p831d.C17960l;

/* renamed from: com.tencent.mm.audio.mix.jni.AudioFFmpegDecodeJni */
public class AudioFFmpegDecodeJni {
    protected long cmo = 0;
    protected long cmp = 0;

    public static native int decode(int i, int i2, int i3, String str, C17960l c17960l);

    public native int clearResample(String str, Object obj);

    public native int initResample(String str, int i, int i2, int i3, int i4, Object obj);

    public native int resamplePcm(String str, int i, int i2, byte[] bArr, int i3, byte[] bArr2, int i4, Object obj);

    static {
        AppMethodBeat.m2504i(137083);
        System.loadLibrary("FFmpeg");
        AppMethodBeat.m2505o(137083);
    }
}
