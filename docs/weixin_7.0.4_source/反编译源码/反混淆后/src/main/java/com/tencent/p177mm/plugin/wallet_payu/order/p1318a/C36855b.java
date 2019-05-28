package com.tencent.p177mm.plugin.wallet_payu.order.p1318a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bjt;
import com.tencent.p177mm.protocal.protobuf.bju;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_payu.order.a.b */
public final class C36855b extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    public C36855b(String str) {
        AppMethodBeat.m2504i(48418);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bjt();
        c1196a.fsK = new bju();
        c1196a.uri = "/cgi-bin/mmpay-bin/payudeluserroll";
        this.ehh = c1196a.acD();
        bjt bjt = (bjt) this.ehh.fsG.fsP;
        if (!C5046bo.isNullOrNil(str)) {
            bjt.pcU = str;
        }
        AppMethodBeat.m2505o(48418);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48419);
        C4990ab.m7410d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(48419);
    }

    public final int getType() {
        return 1544;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48420);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48420);
        return a;
    }
}
