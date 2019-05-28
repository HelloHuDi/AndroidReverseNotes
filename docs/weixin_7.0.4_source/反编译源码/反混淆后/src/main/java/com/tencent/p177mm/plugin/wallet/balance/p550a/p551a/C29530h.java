package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bkz;
import com.tencent.p177mm.protocal.protobuf.bla;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.h */
public final class C29530h extends C37440a<bla> {
    public int scene;

    public C29530h(int i, int i2) {
        AppMethodBeat.m2504i(45234);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bkz();
        c1196a.fsK = new bla();
        c1196a.uri = "/cgi-bin/mmpay-bin/preaddplan";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        bkz bkz = (bkz) acD.fsG.fsP;
        bkz.scene = i;
        bkz.vES = i2;
        this.ehh = acD;
        this.scene = i;
        C4990ab.m7417i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(45234);
    }
}
