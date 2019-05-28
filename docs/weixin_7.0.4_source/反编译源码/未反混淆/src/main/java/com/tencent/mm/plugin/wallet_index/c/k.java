package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.opensdk.modelpay.PayReq;

public final class k extends g {
    public k(PayReq payReq, String str, String str2, String str3, String str4) {
        super(payReq, str, str2, str3, str4);
    }

    public final int getType() {
        return 2655;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/unipayauthapp";
    }
}
