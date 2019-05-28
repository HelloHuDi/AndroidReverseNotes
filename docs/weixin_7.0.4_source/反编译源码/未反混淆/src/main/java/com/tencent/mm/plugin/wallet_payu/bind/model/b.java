package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String cEW;
    public String tSI;

    public b(String str, String str2) {
        AppMethodBeat.i(48337);
        this.tSI = str;
        this.cEW = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serial", str);
        hashMap.put("payu_reference", String.valueOf(str2));
        M(hashMap);
        AppMethodBeat.o(48337);
    }

    public final int cOX() {
        return 6;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
