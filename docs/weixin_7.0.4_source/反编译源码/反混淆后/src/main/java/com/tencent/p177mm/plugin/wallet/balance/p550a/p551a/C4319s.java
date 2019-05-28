package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.protocal.protobuf.bfi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.s */
public final class C4319s {
    private static C4319s tfH;
    public bfi tfI;

    public static C4319s cMK() {
        AppMethodBeat.m2504i(45277);
        if (tfH == null) {
            tfH = new C4319s();
        }
        C4319s c4319s = tfH;
        AppMethodBeat.m2505o(45277);
        return c4319s;
    }

    /* renamed from: a */
    public final void mo9338a(bfi bfi) {
        AppMethodBeat.m2504i(45278);
        C4990ab.m7417i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", Integer.valueOf(bfi.wJb), Integer.valueOf(bfi.wJd), Integer.valueOf(bfi.wJc));
        this.tfI = bfi;
        if (C1947ae.gjw) {
            this.tfI.wJb = 100000000;
            this.tfI.wJd = 50000000;
            this.tfI.wJc = 50000000;
        }
        AppMethodBeat.m2505o(45278);
    }
}
