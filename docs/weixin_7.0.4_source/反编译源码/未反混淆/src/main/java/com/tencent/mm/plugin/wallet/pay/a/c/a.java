package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class a extends f {
    public a(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int ZU() {
        return 1551;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_aa_qrcodeusebindquery";
    }
}
