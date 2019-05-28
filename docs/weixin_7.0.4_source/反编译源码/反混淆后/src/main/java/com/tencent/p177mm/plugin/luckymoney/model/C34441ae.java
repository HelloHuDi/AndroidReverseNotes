package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.asf;
import com.tencent.p177mm.protocal.protobuf.asg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ae */
public final class C34441ae extends C44428p {
    public asg nYy;

    public C34441ae(String str, String str2, String str3) {
        AppMethodBeat.m2504i(42395);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new asf();
        c1196a.fsK = new asg();
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        asf asf = (asf) this.ehh.fsG.fsP;
        asf.nSX = str;
        asf.kBE = str2;
        asf.nZe = str3;
        C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", str, str3);
        AppMethodBeat.m2505o(42395);
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(42396);
        this.nYy = (asg) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", Integer.valueOf(this.nYy.kCl), this.nYy.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(42396);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        asg asg = (asg) ((C7472b) c1929q).fsH.fsP;
        this.AfC = asg.kCl;
        this.AfD = asg.kCm;
    }

    public final int getType() {
        return 2929;
    }
}
