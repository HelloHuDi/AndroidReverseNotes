package com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.utils.C40147b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.tenpay.model.C30875n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.d.f */
public class C22531f extends C30875n {
    private int pQY = -1;
    public Orders tog = null;
    protected C14264s tox;

    public C22531f(C14264s c14264s, Orders orders) {
        String str = null;
        AppMethodBeat.m2504i(45948);
        this.tog = orders;
        this.tox = c14264s;
        List list = orders.tAq;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).cAa;
        }
        if (c14264s.pGr == null) {
            C4990ab.m7412e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
            AppMethodBeat.m2505o(45948);
            return;
        }
        this.pQY = c14264s.pGr.cIf;
        mo49383a(orders.czZ, str, c14264s.pGr.cIf, c14264s.pGr.cIb, c14264s.pbn, c14264s.pbo);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", c14264s.flag);
        hashMap.put("passwd", c14264s.guu);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", Boolean.valueOf(!C5046bo.isNullOrNil(c14264s.guu)));
        mo70325a(c14264s.pGr, (Map) hashMap, (Map) hashMap2, r0);
        hashMap.put("verify_type", c14264s.cHG);
        if (c14264s.cHG == 0) {
            hashMap.put("verify_code", c14264s.tCi);
        } else {
            hashMap.put("cre_tail", c14264s.tCk);
            hashMap.put("cre_type", c14264s.tCl);
        }
        hashMap.put("token", c14264s.token);
        hashMap.put("bank_type", c14264s.pbn);
        hashMap.put("bind_serial", c14264s.pbo);
        hashMap.put("arrive_type", c14264s.twk);
        hashMap.put("default_favorcomposedid", c14264s.twn);
        hashMap.put("favorcomposedid", c14264s.two);
        mo38073aj(hashMap);
        if (C36379x.dNS()) {
            hashMap2.put("uuid_for_bindcard", C36379x.dNU());
            hashMap2.put("bindcard_scene", C36379x.dNT());
        }
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(45948);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: aj */
    public void mo38073aj(Map<String, String> map) {
    }

    public int bgI() {
        return 1;
    }

    /* renamed from: a */
    public void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45949);
        super.mo9383a(i, str, jSONObject);
        if (i != 0) {
            AppMethodBeat.m2505o(45949);
            return;
        }
        C4990ab.m7410d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:".concat(String.valueOf(jSONObject.optString("bind_serial"))));
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.tpw = true;
            this.tog = Orders.m68757a(jSONObject, this.tog);
        } else {
            this.tpw = false;
        }
        C4990ab.m7416i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.pQY);
        if (this.pQY == 39) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
            C40147b.m68846aK(jSONObject);
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
        }
        for (C40931c c40931c : C24143a.atm("PayProcess")) {
            c40931c.mqu.putInt("key_is_clear_failure", this.AgM);
        }
        AppMethodBeat.m2505o(45949);
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

    /* renamed from: ZU */
    public int mo9382ZU() {
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
