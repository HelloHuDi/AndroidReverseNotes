package com.tencent.p177mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.d */
public enum C26968d {
    OK(0, "ok"),
    SYSTEM_ERROR(-1, "fail system error"),
    CGI_ERROR(-2, "fail CGI error"),
    CANCEL(-3, "fail cancel"),
    INVALID_BUSINESS_TYPE(-4, "fail invalid businessType");
    
    String aIm;
    int errCode;

    static {
        AppMethodBeat.m2505o(131042);
    }

    private C26968d(int i, String str) {
        this.errCode = i;
        this.aIm = str;
    }
}
