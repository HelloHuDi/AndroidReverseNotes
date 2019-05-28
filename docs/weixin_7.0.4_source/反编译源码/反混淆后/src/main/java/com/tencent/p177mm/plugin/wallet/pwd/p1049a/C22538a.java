package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35954sx;
import com.tencent.p177mm.protocal.protobuf.C7552sy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.a */
public final class C22538a extends C37440a<C7552sy> {
    public C22538a() {
        AppMethodBeat.m2504i(46166);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35954sx();
        c1196a.fsK = new C7552sy();
        c1196a.uri = "/cgi-bin/mmpay-bin/closeunipayorder";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7416i("MicroMsg.CgiCloseUniPayOrder", "close uni pay order");
        AppMethodBeat.m2505o(46166);
    }
}
