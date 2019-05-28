package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Util4Phone {
    private static final String TAG = "Util4Phone";

    public static boolean isSupportNeon() {
        AppMethodBeat.m2504i(128386);
        boolean z = false;
        try {
            z = Util4NativeCommon.isSupportNeon();
        } catch (Throwable th) {
            Logger.m71022e(TAG, "isSupportNeon", th);
        }
        AppMethodBeat.m2505o(128386);
        return z;
    }
}
