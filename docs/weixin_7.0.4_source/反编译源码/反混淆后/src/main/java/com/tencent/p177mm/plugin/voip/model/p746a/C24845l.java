package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cqf;
import com.tencent.p177mm.protocal.protobuf.cqg;
import com.tencent.p177mm.protocal.protobuf.cqh;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.voip.model.a.l */
public final class C24845l extends C22456n<cqg, cqh> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.l$1 */
    class C71701 implements C1202f {
        C71701() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4732);
            C46317a.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + c1207m.getType() + " errType:" + i + " errCode:" + i2);
            AppMethodBeat.m2505o(4732);
        }
    }

    public C24845l(String str, String str2, String str3, String str4, String str5, String[] strArr) {
        int i = 0;
        AppMethodBeat.m2504i(4733);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cqg();
        c1196a.fsK = new cqh();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipstatreport";
        this.ehh = c1196a.acD();
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
        C46317a.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + strArr.length);
        LinkedList linkedList = new LinkedList();
        while (i < strArr.length) {
            linkedList.add(new bts().alV(strArr[i]));
            i++;
        }
        cqg.xoo = linkedList.size();
        cqg.xop = linkedList;
        AppMethodBeat.m2505o(4733);
    }

    public final int getType() {
        return 320;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4734);
        C71701 c71701 = new C71701();
        AppMethodBeat.m2505o(4734);
        return c71701;
    }
}
