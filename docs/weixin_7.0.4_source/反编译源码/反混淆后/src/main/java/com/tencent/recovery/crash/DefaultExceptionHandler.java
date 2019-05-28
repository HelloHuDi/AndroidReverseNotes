package com.tencent.recovery.crash;

import java.lang.Thread.UncaughtExceptionHandler;

public class DefaultExceptionHandler extends RecoveryExceptionHandler {
    private UncaughtExceptionHandler Ard;

    public DefaultExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.Ard = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        super.uncaughtException(thread, th);
        if (this.Ard != null) {
            this.Ard.uncaughtException(thread, th);
        }
    }
}
