package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class NativeLog {
    private static final String TAG = "NativeLog";

    static native int init(String str);

    NativeLog() {
    }

    static {
        AppMethodBeat.i(128394);
        if (NativeLibs.audioCommon.load()) {
            Logger.i(TAG, "[static initializer] NativeLog load succeed.");
        }
        AppMethodBeat.o(128394);
    }
}
