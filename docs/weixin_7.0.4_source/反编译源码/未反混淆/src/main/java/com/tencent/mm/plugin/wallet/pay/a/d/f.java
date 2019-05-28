package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f extends n {
    private int pQY = -1;
    public Orders tog = null;
    protected s tox;

    public f(s sVar, Orders orders) {
        String str = null;
        AppMethodBeat.i(45948);
        this.tog = orders;
        this.tox = sVar;
        List list = orders.tAq;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).cAa;
        }
        if (sVar.pGr == null) {
            ab.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
            AppMethodBeat.o(45948);
            return;
        }
        this.pQY = sVar.pGr.cIf;
        a(orders.czZ, str, sVar.pGr.cIf, sVar.pGr.cIb, sVar.pbn, sVar.pbo);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", sVar.flag);
        hashMap.put("passwd", sVar.guu);
        ab.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", Boolean.valueOf(!bo.isNullOrNil(sVar.guu)));
        a(sVar.pGr, (Map) hashMap, (Map) hashMap2, r0);
        hashMap.put("verify_type", sVar.cHG);
        if (sVar.cHG == 0) {
            hashMap.put("verify_code", sVar.tCi);
        } else {
            hashMap.put("cre_tail", sVar.tCk);
            hashMap.put("cre_type", sVar.tCl);
        }
        hashMap.put("token", sVar.token);
        hashMap.put("bank_type", sVar.pbn);
        hashMap.put("bind_serial", sVar.pbo);
        hashMap.put("arrive_type", sVar.twk);
        hashMap.put("default_favorcomposedid", sVar.twn);
        hashMap.put("favorcomposedid", sVar.two);
        aj(hashMap);
        if (x.dNS()) {
            hashMap2.put("uuid_for_bindcard", x.dNU());
            hashMap2.put("bindcard_scene", x.dNT());
        }
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(45948);
    }

    /* Access modifiers changed, original: protected */
    public void aj(Map<String, String> map) {
    }

    public int bgI() {
        return 1;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45949);
        super.a(i, str, jSONObject);
        if (i != 0) {
            AppMethodBeat.o(45949);
            return;
        }
        ab.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:".concat(String.valueOf(jSONObject.optString("bind_serial"))));
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.tpw = true;
            this.tog = Orders.a(jSONObject, this.tog);
        } else {
            this.tpw = false;
        }
        ab.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.pQY);
        if (this.pQY == 39) {
            ab.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
            b.aK(jSONObject);
        } else {
            ab.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
        }
        for (c cVar : a.atm("PayProcess")) {
            cVar.mqu.putInt("key_is_clear_failure", this.AgM);
        }
        AppMethodBeat.o(45949);
    }

    public String getUri() {
        if (this.pQY == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverify";
        }
        if (this.pQY == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verify";
    }

    public int ZU() {
        if (this.pQY == 11) {
            return 1607;
        }
        if (this.pQY == 21) {
            return 1606;
        }
        return 462;
    }

    public final boolean cNK() {
        if (this.pQY == 11 || this.pQY == 21) {
            return true;
        }
        return false;
    }
}
