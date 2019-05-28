package com.tencent.smtt.export.external.interfaces;

public abstract class CallbackException extends X5netException {
    protected CallbackException(String str, Throwable th) {
        super(str, th);
    }
}
