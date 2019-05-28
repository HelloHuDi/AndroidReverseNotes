package com.tencent.recovery.crash;

import com.tencent.recovery.Recovery;
import com.tencent.recovery.log.RecoveryLog;

public class JNICrashHandler {
    private static final String TAG = "Recovery.JNICrashHandler";

    public static native void testSignal(int i);

    private static void onCrash() {
        RecoveryLog.i(TAG, "onCrash", new Object[0]);
        Recovery.dPW();
    }
}
