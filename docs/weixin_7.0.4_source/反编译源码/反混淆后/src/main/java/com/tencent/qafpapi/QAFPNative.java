package com.tencent.qafpapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;

public class QAFPNative {
    public static native int QAFPGetAudioFingerPrint(byte[] bArr);

    public static native int QAFPGetAudioFingerPrintTV(byte[] bArr);

    public static native int QAFPGetVersion();

    public static native int QAFPInit();

    public static native int QAFPProcess(byte[] bArr, int i);

    public static native int QAFPProcessTV(byte[] bArr, int i);

    public static native int QAFPRelease();

    public static native int QAFPReset();

    static {
        AppMethodBeat.m2504i(35387);
        C1449k.m3079a("wechatQAFP", QAFPNative.class.getClassLoader());
        AppMethodBeat.m2505o(35387);
    }
}
