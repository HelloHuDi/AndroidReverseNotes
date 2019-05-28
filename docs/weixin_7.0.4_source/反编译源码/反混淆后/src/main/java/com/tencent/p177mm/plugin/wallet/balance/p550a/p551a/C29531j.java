package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bmn;
import com.tencent.p177mm.protocal.protobuf.bmo;
import com.tencent.p177mm.wallet_core.p649c.C44426i;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.j */
public final class C29531j extends C37440a<bmo> implements C44426i {
    public C29531j(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.m2504i(45236);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bmn();
        c1196a.fsK = new bmo();
        c1196a.uri = "/cgi-bin/mmpay-bin/purchasefund";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        bmn bmn = (bmn) acD.fsG.fsP;
        bmn.wPv = str;
        bmn.wPw = i;
        bmn.wao = i2;
        bmn.wPx = str2;
        bmn.wOm = str3;
        bmn.tgu = C14103ab.cMM();
        this.ehh = acD;
        AppMethodBeat.m2505o(45236);
    }
}
