package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class q extends m {
    public n oYH;
    public y oYI = new y(null, 8);
    public d oYJ;
    public d oYK;

    public q(int i) {
        AppMethodBeat.i(43416);
        this.oYH = new n(System.currentTimeMillis(), i);
        M(this.oYH.oYG);
        aZ(this.oYI.oYG);
        ba(this.oYI.toe);
        AppMethodBeat.o(43416);
    }

    public final int bgI() {
        return 1742;
    }

    public final int ZU() {
        return 1742;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43417);
        if (i != 0) {
            AppMethodBeat.o(43417);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("queryuser_resp");
        this.oYJ = ab(optJSONObject);
        this.oYH.a(this.oYJ.errCode, this.oYJ.aIm, optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bindquerynew_resp");
        this.oYK = ab(optJSONObject2);
        this.oYI.a(this.oYK.errCode, this.oYK.aIm, optJSONObject2);
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("card_list");
            if (optString != null) {
                a.Uf(optString);
            }
        }
        AppMethodBeat.o(43417);
    }

    private static d ab(JSONObject jSONObject) {
        int i;
        AppMethodBeat.i(43418);
        d dVar = new d();
        dVar.aIm = ah.getContext().getString(R.string.fdx);
        String string = ah.getContext().getString(R.string.fdx);
        try {
            i = jSONObject.getInt("retcode");
            string = jSONObject.optString("retmsg");
        } catch (Exception e) {
            ab.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + e.toString());
            i = -10089;
        }
        if (i != 0) {
            ab.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
            if (i != -10089) {
                dVar.f(1000, i, string, 2);
            } else {
                dVar.f(1000, 2, string, 2);
            }
        } else {
            ab.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
        }
        AppMethodBeat.o(43418);
        return dVar;
    }

    public static boolean isEnabled() {
        AppMethodBeat.i(43419);
        boolean z = false;
        c ll = com.tencent.mm.model.c.c.abi().ll("100337");
        if (ll.isValid()) {
            Map dru = ll.dru();
            String str = "enabled";
            if (dru.containsKey(str) && "1".equals(dru.get(str))) {
                z = true;
            }
        }
        ab.v("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "isUserBindQueryEnabled: ".concat(String.valueOf(z)));
        AppMethodBeat.o(43419);
        return z;
    }
}
