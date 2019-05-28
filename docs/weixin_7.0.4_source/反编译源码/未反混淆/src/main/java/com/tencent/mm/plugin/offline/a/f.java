package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends m {
    private boolean cNi = true;

    public f(String str, String str2) {
        AppMethodBeat.i(43393);
        HashMap hashMap = new HashMap();
        hashMap.put("code_ver", str);
        hashMap.put("cn", str2);
        ab.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", str, str2);
        M(hashMap);
        AppMethodBeat.o(43393);
    }

    public final int bgI() {
        return 1686;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
    }

    public final int ZU() {
        return 1686;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43394);
        ab.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", Integer.valueOf(i), str);
        if (i == 0) {
            ab.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
            h.pYm.a(135, 22, 1, true);
            AppMethodBeat.o(43394);
            return;
        }
        ab.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", Integer.valueOf(i), str);
        h.pYm.a(135, 23, 1, true);
        AppMethodBeat.o(43394);
    }

    public final void a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(43395);
        if (dVar.Afo != 0 || dVar.errType == 0) {
            this.cNi = true;
        } else {
            this.cNi = false;
        }
        ab.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", Boolean.valueOf(this.cNi));
        AppMethodBeat.o(43395);
    }

    public final boolean bXm() {
        return this.cNi;
    }
}
