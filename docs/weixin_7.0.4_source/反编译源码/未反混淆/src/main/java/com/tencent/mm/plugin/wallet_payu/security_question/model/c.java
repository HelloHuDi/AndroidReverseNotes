package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public String cEW;
    public String id;
    public String tUL;

    public c() {
        this("");
    }

    public c(String str) {
        AppMethodBeat.i(48570);
        this.cEW = str;
        HashMap hashMap = new HashMap();
        hashMap.put("payu_reference", bo.bc(str, ""));
        M(hashMap);
        AppMethodBeat.o(48570);
    }

    public final int cOX() {
        return 23;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48571);
        this.id = jSONObject.optString("id");
        this.tUL = jSONObject.optString("description");
        AppMethodBeat.o(48571);
    }
}
