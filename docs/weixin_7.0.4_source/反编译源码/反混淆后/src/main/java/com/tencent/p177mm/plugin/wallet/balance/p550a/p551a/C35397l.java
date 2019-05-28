package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bnq;
import com.tencent.p177mm.protocal.protobuf.bnr;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.l */
public final class C35397l extends C37440a<bnr> {
    private C7472b gme;
    private bnq tfh = null;

    public C35397l() {
        AppMethodBeat.m2504i(45238);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bnq();
        c1196a.fsK = new bnr();
        c1196a.fsI = 1211;
        c1196a.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.tfh = (bnq) this.gme.fsG.fsP;
        this.tfh.time_stamp = (int) System.currentTimeMillis();
        this.tfh.tgu = C14103ab.cMM();
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(45238);
    }
}
