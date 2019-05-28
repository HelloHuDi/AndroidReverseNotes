package com.tencent.p177mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.address.p1534d.C38090b;
import com.tencent.p177mm.protocal.protobuf.bpk;
import com.tencent.p177mm.protocal.protobuf.bpr;
import com.tencent.p177mm.protocal.protobuf.bps;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.address.model.h */
public final class C26686h extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C26686h(C38090b c38090b) {
        AppMethodBeat.m2504i(16743);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bpr();
        c1196a.fsK = new bps();
        c1196a.uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
        this.ehh = c1196a.acD();
        bpr bpr = (bpr) this.ehh.fsG.fsP;
        bpr.wRJ = new bpk();
        bpr.wRJ.f15076id = c38090b.f16139id;
        bpr.wRJ.wRQ = new bts().alV(C5046bo.m7532bc(c38090b.gJb, ""));
        bpr.wRJ.wRO = new bts().alV(C5046bo.m7532bc(c38090b.gIZ, ""));
        bpr.wRJ.wRT = new bts().alV(C5046bo.m7532bc(c38090b.gJe, ""));
        bpr.wRJ.wRR = new bts().alV(C5046bo.m7532bc(c38090b.gJc, ""));
        bpr.wRJ.wRU = new bts().alV(C5046bo.m7532bc(c38090b.gJf, ""));
        bpr.wRJ.wRV = new bts().alV(C5046bo.m7532bc(c38090b.gJg, ""));
        bpr.wRJ.wRP = new bts().alV(C5046bo.m7532bc(c38090b.gJa, ""));
        bpr.wRJ.wRS = new bts().alV(C5046bo.m7532bc(c38090b.gJd, ""));
        bpr.wRJ.wRW = new bts().alV(C5046bo.m7532bc(c38090b.gJh, ""));
        AppMethodBeat.m2505o(16743);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16744);
        C4990ab.m7410d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bps bps = (bps) ((C7472b) c1929q).fsH.fsP;
            if (bps.wRK.wRN != null) {
                C4990ab.m7410d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + bps.wRK.wRN.size());
                C33045a.arQ();
                C33045a.arS().mo67844s(bps.wRK.wRN);
                C33045a.arQ();
                C33045a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16744);
    }

    public final int getType() {
        return 418;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16745);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16745);
        return a;
    }
}
