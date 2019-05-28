package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bog;
import com.tencent.p177mm.protocal.protobuf.boh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.c */
public final class C41326c extends C37440a<boh> {
    public C41326c() {
        AppMethodBeat.m2504i(46168);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bog();
        c1196a.fsK = new boh();
        c1196a.uri = "/cgi-bin/mmpay-bin/queryunipayorder";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7416i("MicroMsg.CgiQueryUniPayOrder", "query uni pay order");
        AppMethodBeat.m2505o(46168);
    }
}
