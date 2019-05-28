package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cjg;
import com.tencent.p177mm.protocal.protobuf.cke;
import com.tencent.p177mm.protocal.protobuf.ckf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.d */
public final class C35449d extends C37440a<ckf> {
    public C35449d(LinkedList<cjg> linkedList) {
        AppMethodBeat.m2504i(46169);
        cke cke = new cke();
        cke.vBz = linkedList;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = cke;
        c1196a.fsK = new ckf();
        c1196a.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7416i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
        AppMethodBeat.m2505o(46169);
    }
}
