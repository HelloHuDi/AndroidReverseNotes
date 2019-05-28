package com.tencent.smtt.export.external.interfaces;

public interface SslErrorHandler {
    void cancel();

    void proceed();
}
