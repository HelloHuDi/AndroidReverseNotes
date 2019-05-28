package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends a {
    public String cEW;
    public String tUr;
    public String tUs;

    public d(String str, String str2) {
        AppMethodBeat.i(48506);
        this.tUr = str;
        this.tUs = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("payu_reference", str);
        hashMap.put("new_pin", str2);
        M(hashMap);
        AppMethodBeat.o(48506);
    }

    public final int cOX() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48507);
        this.cEW = jSONObject.optString("payu_reference");
        AppMethodBeat.o(48507);
    }
}
