package com.tencent.p177mm.plugin.wallet_payu.order.p1318a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bjq;
import com.tencent.p177mm.protocal.protobuf.bjr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_payu.order.a.a */
public final class C22698a extends C36378u {
    public C7472b ehh;
    private C1202f ehi;

    public C22698a(int i) {
        AppMethodBeat.m2504i(48415);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bjq();
        c1196a.fsK = new bjr();
        c1196a.uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
        this.ehh = c1196a.acD();
        bjq bjq = (bjq) this.ehh.fsG.fsP;
        bjq.nco = 10;
        bjq.vOq = i;
        C4990ab.m7410d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(48415);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48416);
        C4990ab.m7420w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            C4990ab.m7410d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((bjr) ((C7472b) c1929q).fsH.fsP).wMZ);
        }
        AppMethodBeat.m2505o(48416);
    }

    public final int cTg() {
        return ((bjr) this.ehh.fsH.fsP).wMZ;
    }

    public final int getType() {
        return 1519;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48417);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48417);
        return a;
    }
}
