package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String cEW;
    public String cMQ;
    public String pin;
    public String tTb;

    public final int cOX() {
        return 17;
    }

    public b(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(48371);
        this.tTb = str;
        this.cMQ = str2;
        this.pin = str3;
        this.cEW = str4;
        HashMap hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("payu_reference", str4);
        M(hashMap);
        AppMethodBeat.o(48371);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
