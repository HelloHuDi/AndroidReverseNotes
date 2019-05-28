package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class b extends f {
    public b(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int ZU() {
        return 1891;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/dc_qrcodeusebindquery";
    }
}
