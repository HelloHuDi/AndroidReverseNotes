package com.tencent.p177mm.plugin.wallet.pay.p554a.p556e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.utils.C40147b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.tenpay.model.C30875n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.e.j */
public class C31457j extends C30875n {
    private int pQY = -1;
    public Orders tog = null;

    public C31457j(C14264s c14264s, Orders orders) {
        String str = null;
        int i = -1;
        AppMethodBeat.m2504i(45950);
        this.tog = orders;
        if (c14264s.pGr != null) {
            this.pQY = c14264s.pGr.cIf;
            i = c14264s.pGr.cIb;
        }
        List list = orders.tAq;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).cAa;
        }
        mo49383a(orders.czZ, str, this.pQY, i, c14264s.pbn, c14264s.pbo);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        C4990ab.m7417i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", Boolean.valueOf(!C5046bo.isNullOrNil(c14264s.guu)));
        mo70325a(c14264s.pGr, (Map) hashMap, (Map) hashMap2, r0);
        hashMap.put("flag", c14264s.flag);
        hashMap.put("passwd", c14264s.guu);
        hashMap.put("verify_code", c14264s.tCi);
        hashMap.put("token", c14264s.token);
        hashMap.put("favorcomposedid", c14264s.two);
        hashMap.put("default_favorcomposedid", c14264s.twn);
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(45950);
    }

    public final int bgI() {
        return 16;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45951);
        super.mo9383a(i, str, jSONObject);
        if (i != 0) {
            AppMethodBeat.m2505o(45951);
            return;
        }
        C4990ab.m7410d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:".concat(String.valueOf(jSONObject.optString("bind_serial"))));
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.tpw = true;
            this.tog = Orders.m68757a(jSONObject, this.tog);
        } else {
            this.tpw = false;
        }
        C4990ab.m7416i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.pQY);
        if (this.pQY == 39) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
            C40147b.m68846aK(jSONObject);
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
        }
        for (C40931c c40931c : C24143a.atm("PayProcess")) {
            c40931c.mqu.putInt("key_is_clear_failure", this.AgM);
        }
        AppMethodBeat.m2505o(45951);
    }

    public String getUri() {
        if (this.pQY == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
        }
        if (this.pQY == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
    }

    /* renamed from: ZU */
    public int mo9382ZU() {
        if (this.pQY == 11) {
            return 1684;
        }
        if (this.pQY == 21) {
            return 1608;
        }
        return JsApiAddDownloadTask.CTRL_INDEX;
    }

    public final boolean cNK() {
        if (this.pQY == 11 || this.pQY == 21) {
            return true;
        }
        return false;
    }
}
