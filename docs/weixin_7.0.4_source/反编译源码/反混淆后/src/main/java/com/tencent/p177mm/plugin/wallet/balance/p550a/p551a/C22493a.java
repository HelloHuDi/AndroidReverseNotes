package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15328ct;
import com.tencent.p177mm.protocal.protobuf.C44112cs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.a */
public final class C22493a extends C37440a<C15328ct> {
    public C22493a(String str, String str2, String str3, String str4, long j, int i, int i2) {
        AppMethodBeat.m2504i(45227);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44112cs();
        c1196a.fsK = new C15328ct();
        c1196a.uri = "/cgi-bin/mmpay-bin/addplan";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        C44112cs c44112cs = (C44112cs) acD.fsG.fsP;
        c44112cs.vER = str;
        c44112cs.pbn = str2;
        c44112cs.pck = str3;
        c44112cs.vEQ = str4;
        c44112cs.cSh = j;
        c44112cs.ehf = i;
        c44112cs.vES = i2;
        this.ehh = acD;
        C4990ab.m7417i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", str3, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(45227);
    }
}
