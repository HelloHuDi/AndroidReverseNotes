package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bhh;
import com.tencent.p177mm.protocal.protobuf.bhi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.b */
public final class C46354b extends C37440a<bhi> {
    public C46354b() {
        AppMethodBeat.m2504i(46167);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bhh();
        c1196a.fsK = new bhi();
        c1196a.uri = "/cgi-bin/mmpay-bin/openunipayorder";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7416i("MicroMsg.CgiOpenUniPayOrder", "open uni pay order");
        AppMethodBeat.m2505o(46167);
    }
}
