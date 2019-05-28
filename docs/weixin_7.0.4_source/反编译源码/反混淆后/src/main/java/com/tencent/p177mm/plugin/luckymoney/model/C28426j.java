package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.j */
public final class C28426j {
    C21200i nSs;
    private C39319d nWN;

    public C28426j() {
        AppMethodBeat.m2504i(42289);
        init();
        AppMethodBeat.m2505o(42289);
    }

    private void init() {
        AppMethodBeat.m2504i(42290);
        this.nSs = new C21200i();
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(356355, null);
        if (C5046bo.isNullOrNil(str)) {
            this.nSs.nRR = 2000.0d;
            this.nSs.nRO = 100;
            this.nSs.nRS = 200.0d;
            this.nSs.nRQ = 0.01d;
            this.nSs.nRP = 200.0d;
        } else {
            try {
                this.nSs.parseFrom(str.getBytes("ISO-8859-1"));
                bLt();
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
                this.nSs.nRR = 2000.0d;
                this.nSs.nRO = 100;
                this.nSs.nRS = 200.0d;
                this.nSs.nRQ = 0.01d;
                this.nSs.nRP = 200.0d;
            }
        }
        C4990ab.m7416i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.nSs.nRR + " maxTotalNum:" + this.nSs.nRO + " perGroupMaxValue:" + this.nSs.nRS + " perMinValue:" + this.nSs.nRQ + " perPersonMaxValue:" + this.nSs.nRP);
        AppMethodBeat.m2505o(42290);
    }

    /* Access modifiers changed, original: final */
    public final void bLt() {
        AppMethodBeat.m2504i(42291);
        if (this.nSs != null) {
            this.nWN = C39319d.m66995Qg(this.nSs.nWM);
            if (!(this.nWN == null || this.nWN.nWu == null)) {
                ((C12405a) C1720g.m3528K(C12405a.class)).mo24256a(this.nWN.nWu.wwQ);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(1));
            }
        }
        AppMethodBeat.m2505o(42291);
    }

    public final C21200i bLu() {
        AppMethodBeat.m2504i(42292);
        if (this.nSs == null) {
            init();
        }
        C21200i c21200i = this.nSs;
        AppMethodBeat.m2505o(42292);
        return c21200i;
    }

    public final C39319d bLv() {
        AppMethodBeat.m2504i(42293);
        if (this.nWN == null) {
            init();
        }
        C39319d c39319d = this.nWN;
        AppMethodBeat.m2505o(42293);
        return c39319d;
    }
}
