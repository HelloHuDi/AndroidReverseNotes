package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class d extends f {
    public d(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int ZU() {
        return 1573;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_qrcodeusebindquery";
    }
}
