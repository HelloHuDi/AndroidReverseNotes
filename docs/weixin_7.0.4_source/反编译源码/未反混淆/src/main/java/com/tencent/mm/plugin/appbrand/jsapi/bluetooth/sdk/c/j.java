package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class j {
    public static final j hEL = new j(0, "");
    public static final j hEM = new j(-1, "fail:internal error");
    public static final j hEN = new j(Downloads.MIN_WAIT_FOR_NETWORK, "fail:not init");
    public static final j hEO = new j(10001, "fail:not available");
    public static final j hEP = new j(10002, "fail:no device");
    public static final j hEQ = new j(10003, "fail:connection fail");
    public static final j hER = new j(10004, "fail:no service");
    public static final j hES = new j(10005, "fail:no characteristic");
    public static final j hET = new j(10006, "fail:no connection");
    public static final j hEU = new j(CdnLogic.kMediaTypeFavoriteBigFile, "fail:property not support");
    public static final j hEV = new j(10008, "fail:system error");
    public static final j hEW = new j(10009, "fail:system not support");
    public static final j hEX = new j(10008, "fail:no descriptor");
    public static final j hEY = new j(10008, "fail:fail to set descriptor");
    public static final j hEZ = new j(10008, "fail:fail to write descriptor");
    public static final j hFa = new j(10012, "fail:operate time out");
    public static final j hFb = new j(-1, "fail:already connect");
    public static final j hFc = new j(10013, "fail:invalid data");
    public static final j hFd = new j(10008, "fail:not found service");
    public String aIm;
    public int errCode;

    static {
        AppMethodBeat.i(94284);
        AppMethodBeat.o(94284);
    }

    public j(int i, String str) {
        this.errCode = i;
        this.aIm = str;
    }

    public final String toString() {
        AppMethodBeat.i(94283);
        String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.aIm + '\'' + '}';
        AppMethodBeat.o(94283);
        return str;
    }
}
