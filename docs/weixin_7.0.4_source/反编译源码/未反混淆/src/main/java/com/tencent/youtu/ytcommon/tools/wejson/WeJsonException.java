package com.tencent.youtu.ytcommon.tools.wejson;

import java.io.IOException;

public class WeJsonException extends IOException {
    public WeJsonException(String str) {
        super(str);
    }

    public WeJsonException(String str, Throwable th) {
        super(str, th);
    }

    public WeJsonException(Throwable th) {
        super(th);
    }
}
