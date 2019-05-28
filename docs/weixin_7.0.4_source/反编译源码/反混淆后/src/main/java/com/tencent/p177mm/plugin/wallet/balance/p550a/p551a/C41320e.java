package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bff;
import com.tencent.p177mm.protocal.protobuf.bfg;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.e */
public final class C41320e extends C37440a<bfg> {
    public C41320e(int i, int i2) {
        AppMethodBeat.m2504i(45231);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bff();
        c1196a.fsK = new bfg();
        c1196a.uri = "/cgi-bin/mmpay-bin/onclickpurchase";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        bff bff = (bff) acD.fsG.fsP;
        bff.wao = i;
        bff.tyc = i2;
        bff.tgu = C14103ab.cMM();
        this.ehh = acD;
        AppMethodBeat.m2505o(45231);
    }
}
