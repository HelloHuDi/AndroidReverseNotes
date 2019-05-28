package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public String token = "";

    public c(String str) {
        AppMethodBeat.i(48504);
        HashMap hashMap = new HashMap();
        hashMap.put("pin", str);
        M(hashMap);
        AppMethodBeat.o(48504);
    }

    public final int cOX() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48505);
        ab.d("MicroMsg.NetScenePayUCheckPwd", "errCode " + i + " errMsg: " + str);
        this.token = jSONObject.optString("payu_reference");
        AppMethodBeat.o(48505);
    }
}
