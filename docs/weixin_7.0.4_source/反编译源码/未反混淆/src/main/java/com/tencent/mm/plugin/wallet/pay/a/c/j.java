package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class j extends f {
    public j(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int ZU() {
        return 1688;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_tf_qrcodeusebindquery";
    }
}
