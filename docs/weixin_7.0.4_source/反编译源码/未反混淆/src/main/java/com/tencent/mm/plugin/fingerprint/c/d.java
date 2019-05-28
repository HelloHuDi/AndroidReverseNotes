package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m implements k {
    public d(int i) {
        AppMethodBeat.i(41584);
        HashMap hashMap = new HashMap();
        e cvQ = com.tencent.mm.plugin.soter.d.d.cvQ();
        String str = cvQ.rOh;
        String str2 = cvQ.jSY;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        hashMap.put("soter_type", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(41584);
    }

    public final int bgI() {
        return 116;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(41585);
        if (i == 0) {
            int optInt;
            if (jSONObject != null) {
                optInt = jSONObject.optInt("clear_rsa_key_level", 0);
            } else {
                optInt = 0;
            }
            a.bwM();
            a.bwN();
            new Object[1][0] = Integer.valueOf(optInt);
            ((l) g.K(l.class)).bxv();
            AppMethodBeat.o(41585);
            return;
        }
        ab.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
        AppMethodBeat.o(41585);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(41586);
        super.a(i, i2, i3, str, qVar, bArr);
        l lVar = (l) g.K(l.class);
        if (lVar.bxe()) {
            h.pYm.e(13686, Integer.valueOf(i2), Integer.valueOf(i3));
        } else if (lVar.bxh()) {
            h.pYm.e(16994, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        if (i2 == 0 && i3 == 0) {
            lVar.hq(false);
            lVar.hr(false);
            ab.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
            AppMethodBeat.o(41586);
            return;
        }
        ab.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
        AppMethodBeat.o(41586);
    }

    public final int ZU() {
        return 1597;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closetouchpay";
    }
}
