package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bkk;
import com.tencent.p177mm.protocal.protobuf.bkl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.g */
public final class C14106g extends C37440a<bkl> {
    public C14106g() {
        AppMethodBeat.m2504i(45233);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bkk();
        c1196a.fsK = new bkl();
        c1196a.uri = "/cgi-bin/mmpay-bin/planindex";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7416i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
        AppMethodBeat.m2505o(45233);
    }
}
