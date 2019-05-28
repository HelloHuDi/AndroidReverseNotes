package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35953sw;
import com.tencent.p177mm.protocal.protobuf.C40572sv;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.b */
public final class C22495b extends C37440a<C35953sw> {
    public C22495b(String str, int i) {
        AppMethodBeat.m2504i(45228);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40572sv();
        c1196a.fsK = new C35953sw();
        c1196a.uri = "/cgi-bin/mmpay-bin/closefundaccount";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        C40572sv c40572sv = (C40572sv) acD.fsG.fsP;
        c40572sv.wan = str;
        c40572sv.wao = i;
        c40572sv.tgu = C14103ab.cMM();
        this.ehh = acD;
        AppMethodBeat.m2505o(45228);
    }
}
