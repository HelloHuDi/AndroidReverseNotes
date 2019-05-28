package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends m {
    public d okN;

    public e() {
        AppMethodBeat.i(43096);
        M(new HashMap());
        AppMethodBeat.o(43096);
    }

    public final int bgI() {
        return 2713;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/geteuinfo";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43097);
        ab.d("MicroMsg.NetSceneGetEUInfo", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(43097);
            return;
        }
        try {
            this.okN = new d(jSONObject.toString());
            g.RQ();
            g.RP().Ry().set(a.USERINFO_MALL_INDEX_GDPR_CACHE_STRING_SYNC, jSONObject.toString());
            AppMethodBeat.o(43097);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneGetEUInfo", e, "", new Object[0]);
            AppMethodBeat.o(43097);
        }
    }
}
