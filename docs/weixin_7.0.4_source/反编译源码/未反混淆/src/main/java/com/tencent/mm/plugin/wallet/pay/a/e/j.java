package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class j extends n {
    private int pQY = -1;
    public Orders tog = null;

    public j(s sVar, Orders orders) {
        String str = null;
        int i = -1;
        AppMethodBeat.i(45950);
        this.tog = orders;
        if (sVar.pGr != null) {
            this.pQY = sVar.pGr.cIf;
            i = sVar.pGr.cIb;
        }
        List list = orders.tAq;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).cAa;
        }
        a(orders.czZ, str, this.pQY, i, sVar.pbn, sVar.pbo);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ab.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", Boolean.valueOf(!bo.isNullOrNil(sVar.guu)));
        a(sVar.pGr, (Map) hashMap, (Map) hashMap2, r0);
        hashMap.put("flag", sVar.flag);
        hashMap.put("passwd", sVar.guu);
        hashMap.put("verify_code", sVar.tCi);
        hashMap.put("token", sVar.token);
        hashMap.put("favorcomposedid", sVar.two);
        hashMap.put("default_favorcomposedid", sVar.twn);
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(45950);
    }

    public final int bgI() {
        return 16;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45951);
        super.a(i, str, jSONObject);
        if (i != 0) {
            AppMethodBeat.o(45951);
            return;
        }
        ab.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:".concat(String.valueOf(jSONObject.optString("bind_serial"))));
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.tpw = true;
            this.tog = Orders.a(jSONObject, this.tog);
        } else {
            this.tpw = false;
        }
        ab.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.pQY);
        if (this.pQY == 39) {
            ab.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
            b.aK(jSONObject);
        } else {
            ab.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
        }
        for (c cVar : a.atm("PayProcess")) {
            cVar.mqu.putInt("key_is_clear_failure", this.AgM);
        }
        AppMethodBeat.o(45951);
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

    public int ZU() {
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
