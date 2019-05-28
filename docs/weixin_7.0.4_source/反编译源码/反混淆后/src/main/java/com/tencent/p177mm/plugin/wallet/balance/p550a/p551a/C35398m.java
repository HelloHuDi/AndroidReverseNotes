package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bqp;
import com.tencent.p177mm.protocal.protobuf.bqq;
import com.tencent.p177mm.wallet_core.p649c.C44426i;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.m */
public final class C35398m extends C37440a<bqq> implements C44426i {
    public C35398m(int i, String str, String str2, int i2, String str3) {
        AppMethodBeat.m2504i(45239);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bqp();
        c1196a.fsK = new bqq();
        c1196a.uri = "/cgi-bin/mmpay-bin/redeemfund";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        bqp bqp = (bqp) acD.fsG.fsP;
        bqp.wOi = i;
        bqp.wan = str;
        bqp.wOn = str2;
        bqp.wao = i2;
        bqp.wOm = str3;
        bqp.tgu = C14103ab.cMM();
        this.ehh = acD;
        AppMethodBeat.m2505o(45239);
    }
}
