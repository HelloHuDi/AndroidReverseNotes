package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.e;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q extends m {
    public BindCardOrder ttK;

    public q(s sVar) {
        this(sVar, -1);
    }

    public q(s sVar, int i) {
        AppMethodBeat.i(46530);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a(sVar.pGr, (Map) hashMap, (Map) hashMap2);
        hashMap.put("flag", sVar.flag);
        if ("2".equals(sVar.flag)) {
            hashMap.put("passwd", sVar.guu);
        }
        hashMap.put("verify_code", sVar.tCi);
        hashMap.put("token", sVar.token);
        if (!(sVar.pGr == null || bo.isNullOrNil(sVar.pGr.czZ))) {
            hashMap.put("req_key", sVar.pGr.czZ);
        }
        if (i >= 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            ab.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", Integer.valueOf(i));
        }
        if (!bo.isNullOrNil(sVar.pbn)) {
            hashMap.put("bank_type", sVar.pbn);
        }
        if (x.dNS()) {
            hashMap2.put("uuid_for_bindcard", x.dNU());
            hashMap2.put("bindcard_scene", x.dNT());
        }
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(46530);
    }

    public final int bgI() {
        return 13;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46531);
        ab.i("test", "test");
        this.ttK = new BindCardOrder();
        this.ttK.as(jSONObject);
        AppMethodBeat.o(46531);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverify";
    }

    public final int ZU() {
        return e.CTRL_INDEX;
    }
}
