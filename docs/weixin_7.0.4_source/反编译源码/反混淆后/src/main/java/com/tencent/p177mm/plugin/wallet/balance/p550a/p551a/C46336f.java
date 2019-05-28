package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bfh;
import com.tencent.p177mm.protocal.protobuf.bfi;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.f */
public final class C46336f extends C37440a<bfi> {
    public C46336f(int i) {
        AppMethodBeat.m2504i(45232);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bfh();
        c1196a.fsK = new bfi();
        c1196a.uri = "/cgi-bin/mmpay-bin/onclickredeem";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        bfh bfh = (bfh) acD.fsG.fsP;
        bfh.wao = i;
        bfh.tgu = C14103ab.cMM();
        this.ehh = acD;
        AppMethodBeat.m2505o(45232);
    }
}
