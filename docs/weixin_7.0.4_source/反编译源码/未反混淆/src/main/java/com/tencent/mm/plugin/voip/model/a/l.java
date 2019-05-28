package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.cqh;
import java.util.LinkedList;

public final class l extends n<cqg, cqh> {
    public l(String str, String str2, String str3, String str4, String str5, String[] strArr) {
        int i = 0;
        AppMethodBeat.i(4733);
        a aVar = new a();
        aVar.fsJ = new cqg();
        aVar.fsK = new cqh();
        aVar.uri = "/cgi-bin/micromsg-bin/voipstatreport";
        this.ehh = aVar.acD();
        cqg cqg = (cqg) this.ehh.fsG.fsP;
        cqf cqf = new cqf();
        bts bts = new bts();
        bts.alV(str);
        cqf.xfu = bts;
        cqf cqf2 = new cqf();
        bts bts2 = new bts();
        bts2.alV(str2);
        cqf2.xfu = bts2;
        cqf cqf3 = new cqf();
        bts bts3 = new bts();
        bts3.alV(str3);
        cqf3.xfu = bts3;
        cqf cqf4 = new cqf();
        bts bts4 = new bts();
        bts4.alV(str4);
        cqf4.xfu = bts4;
        cqf cqf5 = new cqf();
        bts bts5 = new bts();
        bts5.alV(str5);
        cqf5.xfu = bts5;
        cqg.xmK = cqf;
        cqg.xol = cqf2;
        cqg.xok = cqf3;
        cqg.xom = cqf4;
        cqg.xon = cqf5;
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + strArr.length);
        LinkedList linkedList = new LinkedList();
        while (i < strArr.length) {
            linkedList.add(new bts().alV(strArr[i]));
            i++;
        }
        cqg.xoo = linkedList.size();
        cqg.xop = linkedList;
        AppMethodBeat.o(4733);
    }

    public final int getType() {
        return 320;
    }

    public final f cKt() {
        AppMethodBeat.i(4734);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4732);
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + mVar.getType() + " errType:" + i + " errCode:" + i2);
                AppMethodBeat.o(4732);
            }
        };
        AppMethodBeat.o(4734);
        return anonymousClass1;
    }
}
