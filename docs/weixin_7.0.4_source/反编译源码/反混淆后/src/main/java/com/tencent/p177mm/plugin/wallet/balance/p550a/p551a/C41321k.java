package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bno;
import com.tencent.p177mm.protocal.protobuf.bnp;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.k */
public final class C41321k extends C37440a<bnp> {
    public C41321k(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.m2504i(45237);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bno();
        c1196a.fsK = new bnp();
        c1196a.uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        bno bno = (bno) acD.fsG.fsP;
        bno.wQm = str;
        bno.pQe = str2;
        bno.wPw = i;
        bno.wao = i2;
        bno.wOm = str3;
        bno.tgu = C14103ab.cMM();
        this.ehh = acD;
        AppMethodBeat.m2505o(45237);
    }
}
