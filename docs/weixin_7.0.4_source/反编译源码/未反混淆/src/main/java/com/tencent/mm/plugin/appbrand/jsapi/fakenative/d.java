package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d {
    OK(0, "ok"),
    SYSTEM_ERROR(-1, "fail system error"),
    CGI_ERROR(-2, "fail CGI error"),
    CANCEL(-3, "fail cancel"),
    INVALID_BUSINESS_TYPE(-4, "fail invalid businessType");
    
    String aIm;
    int errCode;

    static {
        AppMethodBeat.o(131042);
    }

    private d(int i, String str) {
        this.errCode = i;
        this.aIm = str;
    }
}
