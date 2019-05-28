package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class t extends m {
    public t(String str, String str2) {
        AppMethodBeat.i(44767);
        HashMap hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        M(hashMap);
        AppMethodBeat.o(44767);
    }

    public t(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(44768);
        HashMap hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        hashMap.put("rcvr_ticket", str3);
        hashMap.put("receiver_openid", str4);
        M(hashMap);
        AppMethodBeat.o(44768);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1535;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersendcancelf2f";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44769);
        ab.d("MicroMsg.NetSenceTenPayBase", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(44769);
        } else {
            AppMethodBeat.o(44769);
        }
    }
}
