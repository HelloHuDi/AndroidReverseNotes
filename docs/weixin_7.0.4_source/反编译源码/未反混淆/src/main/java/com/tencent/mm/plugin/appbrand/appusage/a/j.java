package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public class j extends a<bsg> {
    public j(long j, LinkedList<zd> linkedList, LinkedList<sp> linkedList2, int i, int i2, int i3, sq sqVar) {
        AppMethodBeat.i(129758);
        ab.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", Long.valueOf(j), Integer.valueOf(i));
        b.a aVar = new b.a();
        bsf bsf = new bsf();
        bsf.bHi = j;
        bsf.wUh = linkedList;
        bsf.wUk = linkedList2;
        bsf.wUi = i;
        bsf.wUj = i2;
        bsf.wUl = i3;
        bsf.wsi = sqVar;
        aVar.fsJ = bsf;
        aVar.fsK = new bsg();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
        this.ehh = aVar.acD();
        AppMethodBeat.o(129758);
    }
}
