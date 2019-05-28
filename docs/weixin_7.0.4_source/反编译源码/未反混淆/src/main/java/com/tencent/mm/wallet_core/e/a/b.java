package com.tencent.mm.wallet_core.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b() {
        AppMethodBeat.i(49160);
        M(new HashMap());
        AppMethodBeat.o(49160);
    }

    public final int cOX() {
        return 28;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(49161);
        ab.d("Micromsg.NetScenePayUTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (!bo.isNullOrNil(optString)) {
            w.setTimeStamp(optString);
        }
        AppMethodBeat.o(49161);
    }
}
