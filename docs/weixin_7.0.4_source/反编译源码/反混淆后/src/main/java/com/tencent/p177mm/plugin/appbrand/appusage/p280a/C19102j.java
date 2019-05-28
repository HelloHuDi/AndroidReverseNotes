package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23440sq;
import com.tencent.p177mm.protocal.protobuf.C46585sp;
import com.tencent.p177mm.protocal.protobuf.C46603zd;
import com.tencent.p177mm.protocal.protobuf.bsf;
import com.tencent.p177mm.protocal.protobuf.bsg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.j */
public class C19102j extends C37440a<bsg> {
    public C19102j(long j, LinkedList<C46603zd> linkedList, LinkedList<C46585sp> linkedList2, int i, int i2, int i3, C23440sq c23440sq) {
        AppMethodBeat.m2504i(129758);
        C4990ab.m7417i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", Long.valueOf(j), Integer.valueOf(i));
        C1196a c1196a = new C1196a();
        bsf bsf = new bsf();
        bsf.bHi = j;
        bsf.wUh = linkedList;
        bsf.wUk = linkedList2;
        bsf.wUi = i;
        bsf.wUj = i2;
        bsf.wUl = i3;
        bsf.wsi = c23440sq;
        c1196a.fsJ = bsf;
        c1196a.fsK = new bsg();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(129758);
    }
}
