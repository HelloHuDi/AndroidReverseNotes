package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

public final class b extends f {
    private boolean tov = false;
    private boolean tow;

    public final int bgI() {
        return 121;
    }

    public b(s sVar, Orders orders) {
        super(sVar, orders);
        AppMethodBeat.i(45941);
        cNL();
        AppMethodBeat.o(45941);
    }

    private void cNL() {
        AppMethodBeat.i(45942);
        this.tov = false;
        com.tencent.mm.plugin.wallet.a.s.cNC();
        if (!(com.tencent.mm.plugin.wallet.a.s.cND().tCZ == null || this.tox.pGr == null)) {
            String str = this.tox.pbn;
            com.tencent.mm.plugin.wallet.a.s.cNC();
            if (str.equals(com.tencent.mm.plugin.wallet.a.s.cND().tCZ.field_bankcardType)) {
                if (this.tox.pGr.cIf == 31 || this.tox.pGr.cIf == 32 || this.tox.pGr.cIf == 33 || this.tox.pGr.cIf == 42 || this.tox.pGr.cIf == 37) {
                    this.tov = true;
                } else {
                    this.tow = true;
                }
            }
        }
        ab.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", Boolean.valueOf(this.tov), Boolean.valueOf(this.tow));
        AppMethodBeat.o(45942);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aj(Map<String, String> map) {
        AppMethodBeat.i(45943);
        cNL();
        if (this.tov || this.tow) {
            map.put("busi_scene", this.tox.pbn);
        }
        AppMethodBeat.o(45943);
    }

    public final int ZU() {
        AppMethodBeat.i(45944);
        cNL();
        if (this.tov) {
            AppMethodBeat.o(45944);
            return 1281;
        } else if (this.tow) {
            AppMethodBeat.o(45944);
            return 1305;
        } else {
            AppMethodBeat.o(45944);
            return 1601;
        }
    }

    public final String getUri() {
        AppMethodBeat.i(45945);
        cNL();
        String str;
        if (this.tov) {
            str = "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
            AppMethodBeat.o(45945);
            return str;
        } else if (this.tow) {
            str = "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
            AppMethodBeat.o(45945);
            return str;
        } else {
            str = "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
            AppMethodBeat.o(45945);
            return str;
        }
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(45946);
        if (this.tov) {
            h.pYm.a(663, 26, 1, false);
        } else if (this.tow) {
            h.pYm.a(663, 22, 1, false);
        }
        int a = super.a(eVar, fVar);
        AppMethodBeat.o(45946);
        return a;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45947);
        super.a(i, str, jSONObject);
        if (i != 0) {
            if (this.tov) {
                h.pYm.a(663, 27, 1, false);
                AppMethodBeat.o(45947);
                return;
            } else if (this.tow) {
                h.pYm.a(663, 23, 1, false);
            }
        }
        AppMethodBeat.o(45947);
    }
}
