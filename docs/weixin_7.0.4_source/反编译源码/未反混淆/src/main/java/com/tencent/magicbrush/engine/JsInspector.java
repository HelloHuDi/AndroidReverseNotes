package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JsInspector {
    private static a bSE;

    public interface a {
        int yC();

        int yD();
    }

    static native int JniNotify(long j, long j2, String str);

    static native void JniReceiveData(long j, String str);

    @Keep
    public static int jniCallbackSendData(long j, String str) {
        AppMethodBeat.i(115882);
        if (bSE == null) {
            AppMethodBeat.o(115882);
            return -1;
        }
        int yC = bSE.yC();
        AppMethodBeat.o(115882);
        return yC;
    }

    @Keep
    public static int jniCallbackNotify(long j, long j2, String str) {
        AppMethodBeat.i(115883);
        if (bSE == null) {
            AppMethodBeat.o(115883);
            return -1;
        }
        int yD = bSE.yD();
        AppMethodBeat.o(115883);
        return yD;
    }
}
