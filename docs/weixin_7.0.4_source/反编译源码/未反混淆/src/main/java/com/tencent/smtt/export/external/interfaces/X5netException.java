package com.tencent.smtt.export.external.interfaces;

import java.io.IOException;

public abstract class X5netException extends IOException {
    protected X5netException(String str, Throwable th) {
        super(str, th);
    }
}
