package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C30212p;
import com.tencent.p177mm.protocal.protobuf.C40561q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.aa.a.a.a */
public final class C45481a extends C37440a<C40561q> {
    public C45481a(String str, long j, int i, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(40639);
        C30212p c30212p = new C30212p();
        c30212p.vzL = str;
        c30212p.vAe = j;
        c30212p.scene = i;
        c30212p.vzM = str2;
        c30212p.vAg = str3;
        c30212p.pQe = str4;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c30212p;
        c1196a.fsK = new C40561q();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", c30212p.vzL, Long.valueOf(c30212p.vAe), Integer.valueOf(c30212p.scene), c30212p.vzM, c30212p.vAg, c30212p.pQe);
        AppMethodBeat.m2505o(40639);
    }
}
