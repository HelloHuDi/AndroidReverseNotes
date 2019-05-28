package com.tencent.p177mm.plugin.wallet_payu.pay.p571a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.protocal.protobuf.bjs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.a.a */
public final class C22700a extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    public final int getType() {
        return 1554;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48438);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48438);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48439);
        C4990ab.m7410d("MicroMsg.NetScenePayUCheckJsApi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        bjs bjs = (bjs) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            C4990ab.m7410d("MicroMsg.NetScenePayUCheckJsApi", "rr " + bjs.luT);
        }
        this.ehi.onSceneEnd(i, i2, bjs.luU, this);
        AppMethodBeat.m2505o(48439);
    }
}
