package com.tencent.p177mm.plugin.wallet.bind.p1311a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.appbrand.weishi.C2509f;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet.bind.a.b */
public final class C29586b extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    private String tlg;

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(45726);
        C4990ab.m7410d("MicroMsg.NetSceneSetMainBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            C46332s.cNC();
            C46332s.cND();
            C22587ak.acD(this.tlg);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(45726);
    }

    public final int getType() {
        return C2509f.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(45727);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(45727);
        return a;
    }
}
