package com.tencent.recovery.crash;

import com.tencent.recovery.Recovery;
import java.lang.Thread.UncaughtExceptionHandler;

public class RecoveryExceptionHandler implements UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th) {
        Recovery.dPW();
    }
}
