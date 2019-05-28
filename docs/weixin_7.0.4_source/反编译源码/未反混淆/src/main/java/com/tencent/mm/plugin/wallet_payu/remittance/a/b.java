package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b(String str, int i, String str2, String str3) {
        AppMethodBeat.i(48527);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", String.valueOf(i));
        hashMap.put("fee_type", str2);
        hashMap.put("to_customer_name", str3);
        M(hashMap);
        AppMethodBeat.o(48527);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48528);
        ab.d("MicroMsg", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48528);
        } else {
            AppMethodBeat.o(48528);
        }
    }

    public final int cOX() {
        return 16;
    }
}
