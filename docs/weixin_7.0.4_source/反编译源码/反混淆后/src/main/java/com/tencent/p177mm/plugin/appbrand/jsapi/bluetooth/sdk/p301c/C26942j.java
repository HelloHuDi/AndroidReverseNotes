package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j */
public final class C26942j {
    public static final C26942j hEL = new C26942j(0, "");
    public static final C26942j hEM = new C26942j(-1, "fail:internal error");
    public static final C26942j hEN = new C26942j(Downloads.MIN_WAIT_FOR_NETWORK, "fail:not init");
    public static final C26942j hEO = new C26942j(10001, "fail:not available");
    public static final C26942j hEP = new C26942j(10002, "fail:no device");
    public static final C26942j hEQ = new C26942j(10003, "fail:connection fail");
    public static final C26942j hER = new C26942j(10004, "fail:no service");
    public static final C26942j hES = new C26942j(10005, "fail:no characteristic");
    public static final C26942j hET = new C26942j(10006, "fail:no connection");
    public static final C26942j hEU = new C26942j(CdnLogic.kMediaTypeFavoriteBigFile, "fail:property not support");
    public static final C26942j hEV = new C26942j(10008, "fail:system error");
    public static final C26942j hEW = new C26942j(10009, "fail:system not support");
    public static final C26942j hEX = new C26942j(10008, "fail:no descriptor");
    public static final C26942j hEY = new C26942j(10008, "fail:fail to set descriptor");
    public static final C26942j hEZ = new C26942j(10008, "fail:fail to write descriptor");
    public static final C26942j hFa = new C26942j(10012, "fail:operate time out");
    public static final C26942j hFb = new C26942j(-1, "fail:already connect");
    public static final C26942j hFc = new C26942j(10013, "fail:invalid data");
    public static final C26942j hFd = new C26942j(10008, "fail:not found service");
    public String aIm;
    public int errCode;

    static {
        AppMethodBeat.m2504i(94284);
        AppMethodBeat.m2505o(94284);
    }

    public C26942j(int i, String str) {
        this.errCode = i;
        this.aIm = str;
    }

    public final String toString() {
        AppMethodBeat.m2504i(94283);
        String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.aIm + '\'' + '}';
        AppMethodBeat.m2505o(94283);
        return str;
    }
}
