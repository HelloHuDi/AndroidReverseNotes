package com.tencent.p177mm.plugin.wallet_payu.order.p1318a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bjn;
import com.tencent.p177mm.protocal.protobuf.bjx;
import com.tencent.p177mm.protocal.protobuf.bjy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_payu.order.a.c */
public final class C40159c extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    public bjn tTC = null;

    public C40159c(String str) {
        AppMethodBeat.m2504i(48421);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bjx();
        c1196a.fsK = new bjy();
        c1196a.uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
        c1196a.fsI = 1520;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bjx bjx = (bjx) this.ehh.fsG.fsP;
        if (!C5046bo.isNullOrNil(str)) {
            bjx.pcU = str;
        }
        AppMethodBeat.m2505o(48421);
    }

    public final int getType() {
        return 1520;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48422);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48422);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48423);
        C4990ab.m7420w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            bjy bjy = (bjy) ((C7472b) c1929q).fsH.fsP;
            this.tTC = bjy.wNc;
            if (bjy.wNc != null) {
                C4990ab.m7410d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + bjy.wNc.pcU);
                AppMethodBeat.m2505o(48423);
                return;
            }
            C4990ab.m7412e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
        }
        AppMethodBeat.m2505o(48423);
    }
}
