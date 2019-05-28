package com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.d.b */
public final class C29595b extends C22531f {
    private boolean tov = false;
    private boolean tow;

    public final int bgI() {
        return 121;
    }

    public C29595b(C14264s c14264s, Orders orders) {
        super(c14264s, orders);
        AppMethodBeat.m2504i(45941);
        cNL();
        AppMethodBeat.m2505o(45941);
    }

    private void cNL() {
        AppMethodBeat.m2504i(45942);
        this.tov = false;
        C46332s.cNC();
        if (!(C46332s.cND().tCZ == null || this.tox.pGr == null)) {
            String str = this.tox.pbn;
            C46332s.cNC();
            if (str.equals(C46332s.cND().tCZ.field_bankcardType)) {
                if (this.tox.pGr.cIf == 31 || this.tox.pGr.cIf == 32 || this.tox.pGr.cIf == 33 || this.tox.pGr.cIf == 42 || this.tox.pGr.cIf == 37) {
                    this.tov = true;
                } else {
                    this.tow = true;
                }
            }
        }
        C4990ab.m7417i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", Boolean.valueOf(this.tov), Boolean.valueOf(this.tow));
        AppMethodBeat.m2505o(45942);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aj */
    public final void mo38073aj(Map<String, String> map) {
        AppMethodBeat.m2504i(45943);
        cNL();
        if (this.tov || this.tow) {
            map.put("busi_scene", this.tox.pbn);
        }
        AppMethodBeat.m2505o(45943);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        AppMethodBeat.m2504i(45944);
        cNL();
        if (this.tov) {
            AppMethodBeat.m2505o(45944);
            return 1281;
        } else if (this.tow) {
            AppMethodBeat.m2505o(45944);
            return 1305;
        } else {
            AppMethodBeat.m2505o(45944);
            return 1601;
        }
    }

    public final String getUri() {
        AppMethodBeat.m2504i(45945);
        cNL();
        String str;
        if (this.tov) {
            str = "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
            AppMethodBeat.m2505o(45945);
            return str;
        } else if (this.tow) {
            str = "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
            AppMethodBeat.m2505o(45945);
            return str;
        } else {
            str = "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
            AppMethodBeat.m2505o(45945);
            return str;
        }
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(45946);
        if (this.tov) {
            C7060h.pYm.mo8378a(663, 26, 1, false);
        } else if (this.tow) {
            C7060h.pYm.mo8378a(663, 22, 1, false);
        }
        int a = super.mo4456a(c1902e, c1202f);
        AppMethodBeat.m2505o(45946);
        return a;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45947);
        super.mo9383a(i, str, jSONObject);
        if (i != 0) {
            if (this.tov) {
                C7060h.pYm.mo8378a(663, 27, 1, false);
                AppMethodBeat.m2505o(45947);
                return;
            } else if (this.tow) {
                C7060h.pYm.mo8378a(663, 23, 1, false);
            }
        }
        AppMethodBeat.m2505o(45947);
    }
}
