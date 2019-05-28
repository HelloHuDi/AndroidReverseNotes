package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bdc;
import com.tencent.p177mm.protocal.protobuf.bdd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.d */
public final class C43760d extends C37440a<bdd> {
    public C43760d(int i, String str, String str2, String str3, long j, int i2, String str4) {
        AppMethodBeat.m2504i(45230);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bdc();
        c1196a.fsK = new bdd();
        c1196a.uri = "/cgi-bin/mmpay-bin/modifyplan";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        bdc bdc = (bdc) acD.fsG.fsP;
        bdc.vES = i;
        bdc.pbn = str;
        bdc.pck = str2;
        bdc.vEQ = str3;
        bdc.cSh = j;
        bdc.ehf = i2;
        bdc.vER = str4;
        this.ehh = acD;
        C4990ab.m7417i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", Integer.valueOf(i), str2, Long.valueOf(j), Integer.valueOf(i2));
        AppMethodBeat.m2505o(45230);
    }
}
