package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bad;
import com.tencent.p177mm.protocal.protobuf.bae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.c */
public final class C43759c extends C37440a<bae> {
    public C43759c(int i, int i2, String str) {
        AppMethodBeat.m2504i(45229);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bad();
        c1196a.fsK = new bae();
        c1196a.uri = "/cgi-bin/mmpay-bin/manageplan";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        bad bad = (bad) acD.fsG.fsP;
        bad.type = i;
        bad.vES = i2;
        bad.vER = str;
        this.ehh = acD;
        C4990ab.m7417i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(45229);
    }
}
