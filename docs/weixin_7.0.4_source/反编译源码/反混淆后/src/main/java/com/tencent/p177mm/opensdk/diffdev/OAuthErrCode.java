package com.tencent.p177mm.opensdk.diffdev;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.opensdk.diffdev.OAuthErrCode */
public enum OAuthErrCode {
    WechatAuth_Err_OK(0),
    WechatAuth_Err_NormalErr(-1),
    WechatAuth_Err_NetworkErr(-2),
    WechatAuth_Err_JsonDecodeErr(-3),
    WechatAuth_Err_Cancel(-4),
    WechatAuth_Err_Timeout(-5),
    WechatAuth_Err_Auth_Stopped(-6);
    
    private int code;

    static {
        AppMethodBeat.m2505o(128063);
    }

    private OAuthErrCode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        AppMethodBeat.m2504i(128062);
        String str = "OAuthErrCode:" + this.code;
        AppMethodBeat.m2505o(128062);
        return str;
    }
}
