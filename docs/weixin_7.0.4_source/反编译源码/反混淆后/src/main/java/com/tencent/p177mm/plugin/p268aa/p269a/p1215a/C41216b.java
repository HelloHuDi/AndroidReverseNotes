package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40568s;
import com.tencent.p177mm.protocal.protobuf.C46579r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.aa.a.a.b */
public final class C41216b extends C37440a<C40568s> {
    public C41216b(String str, String str2, int i) {
        AppMethodBeat.m2504i(40640);
        C1196a c1196a = new C1196a();
        C46579r c46579r = new C46579r();
        c46579r.vzL = str;
        c46579r.vzM = str2;
        c46579r.scene = i;
        c1196a.fsJ = c46579r;
        c1196a.fsK = new C40568s();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaapayurge";
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", str, str2, Integer.valueOf(i));
        AppMethodBeat.m2505o(40640);
    }
}
