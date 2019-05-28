package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String cEW;
    public String id;
    public boolean lSP;
    public String nYb;
    public String tUK;

    public b(String str, String str2, String str3) {
        AppMethodBeat.i(48568);
        this.id = str2;
        this.nYb = str3;
        this.cEW = str;
        HashMap hashMap = new HashMap();
        hashMap.put("id", str2);
        hashMap.put("answer", str3);
        hashMap.put("payu_reference", str);
        M(hashMap);
        AppMethodBeat.o(48568);
    }

    public final int cOX() {
        return 18;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48569);
        this.lSP = jSONObject.optBoolean("verified");
        this.tUK = jSONObject.optString("payu_reference");
        AppMethodBeat.o(48569);
    }
}
