package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class c extends f {
    public c(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int ZU() {
        return 1543;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_ff_qrcodeusebindquery";
    }
}
