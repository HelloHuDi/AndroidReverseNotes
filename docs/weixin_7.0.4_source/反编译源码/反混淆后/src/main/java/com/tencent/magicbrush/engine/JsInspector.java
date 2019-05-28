package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JsInspector {
    private static C17839a bSE;

    /* renamed from: com.tencent.magicbrush.engine.JsInspector$a */
    public interface C17839a {
        /* renamed from: yC */
        int mo33013yC();

        /* renamed from: yD */
        int mo33014yD();
    }

    static native int JniNotify(long j, long j2, String str);

    static native void JniReceiveData(long j, String str);

    @Keep
    public static int jniCallbackSendData(long j, String str) {
        AppMethodBeat.m2504i(115882);
        if (bSE == null) {
            AppMethodBeat.m2505o(115882);
            return -1;
        }
        int yC = bSE.mo33013yC();
        AppMethodBeat.m2505o(115882);
        return yC;
    }

    @Keep
    public static int jniCallbackNotify(long j, long j2, String str) {
        AppMethodBeat.m2504i(115883);
        if (bSE == null) {
            AppMethodBeat.m2505o(115883);
            return -1;
        }
        int yD = bSE.mo33014yD();
        AppMethodBeat.m2505o(115883);
        return yD;
    }
}
