package com.tencent.mm.plugin.luckymoney.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends m {
    public int obS = 0;

    public a(int i, String str, String str2) {
        AppMethodBeat.i(42549);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", String.valueOf(str2));
        this.obS = i;
        M(hashMap);
        AppMethodBeat.o(42549);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snspaymanage";
    }

    public final int ZU() {
        return 1697;
    }

    public final int bgI() {
        return 1697;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42550);
        ab.i("MicroMsg.NetSceneSnsPayManage", " errCode: " + i + " errMsg :" + str);
        if (i != 0) {
            ab.e("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() NetSceneSnsPayManage is false!");
            AppMethodBeat.o(42550);
        } else if (this.obS == 1) {
            com.tencent.mm.plugin.luckymoney.sns.b.a.xV(1);
            ab.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 1");
            AppMethodBeat.o(42550);
        } else {
            com.tencent.mm.plugin.luckymoney.sns.b.a.xV(0);
            ab.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 0");
            AppMethodBeat.o(42550);
        }
    }
}
