package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.brg;
import com.tencent.p177mm.protocal.protobuf.brh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.i */
public final class C23211i extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    public C23211i(String str, String str2) {
        AppMethodBeat.m2504i(48668);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new brg();
        c1196a.fsK = new brh();
        c1196a.uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
        this.ehh = c1196a.acD();
        brg brg = (brg) this.ehh.fsG.fsP;
        brg.wTF = str;
        brg.wTE = C5046bo.getInt(str2, 0);
        brg.vRP = C22594k.cPy();
        AppMethodBeat.m2505o(48668);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48669);
        C4990ab.m7410d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(48669);
    }

    public final int getType() {
        return 600;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48670);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48670);
        return a;
    }
}
