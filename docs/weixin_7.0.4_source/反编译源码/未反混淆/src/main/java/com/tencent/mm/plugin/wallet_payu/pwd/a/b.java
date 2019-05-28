package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b(String str, String str2) {
        AppMethodBeat.i(48503);
        HashMap hashMap = new HashMap();
        hashMap.put("old_pin", str);
        hashMap.put("new_pin", String.valueOf(str2));
        M(hashMap);
        AppMethodBeat.o(48503);
    }

    public final int cOX() {
        return 2;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
