package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends m {
    public h(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(48190);
        HashMap hashMap = new HashMap();
        hashMap.put("toUser", str);
        hashMap.put("receiverTitle", str2);
        hashMap.put("senderTitle", str3);
        hashMap.put("tempId", str4);
        hashMap.put("receiverdes", str6);
        hashMap.put("senderdes", str5);
        hashMap.put("Url", str7);
        hashMap.put("Scene", str8);
        M(hashMap);
        AppMethodBeat.o(48190);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1962;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48191);
        ab.d("Micromsg.NetSceneSendC2CMsg", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48191);
        } else {
            AppMethodBeat.o(48191);
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/h5sendc2cmsg";
    }
}
