package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class h extends f {
    public h(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int ZU() {
        return 1569;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_qrcodeusebindquery";
    }
}
