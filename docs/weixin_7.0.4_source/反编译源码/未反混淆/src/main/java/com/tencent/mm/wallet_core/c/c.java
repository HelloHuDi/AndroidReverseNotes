package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class c {
    public String Afl = "";
    public String Afm = "";
    public String Afn = "";
    public String cBF = "";
    public String title = "";

    public c(String str) {
        AppMethodBeat.i(49036);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(49036);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.title = jSONObject.optString("title");
            this.Afl = jSONObject.optString("body1");
            this.Afm = jSONObject.optString("body2");
            this.Afn = jSONObject.optString("button");
            AppMethodBeat.o(49036);
        } catch (Exception e) {
            ab.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", e.getMessage());
            AppMethodBeat.o(49036);
        }
    }
}
