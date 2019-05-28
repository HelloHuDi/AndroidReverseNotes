package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class ae extends p {
    public asg nYy;

    public ae(String str, String str2, String str3) {
        AppMethodBeat.i(42395);
        a aVar = new a();
        aVar.fsJ = new asf();
        aVar.fsK = new asg();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        asf asf = (asf) this.ehh.fsG.fsP;
        asf.nSX = str;
        asf.kBE = str2;
        asf.nZe = str3;
        ab.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", str, str3);
        AppMethodBeat.o(42395);
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(42396);
        this.nYy = (asg) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", Integer.valueOf(this.nYy.kCl), this.nYy.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(42396);
    }

    public final void f(q qVar) {
        asg asg = (asg) ((b) qVar).fsH.fsP;
        this.AfC = asg.kCl;
        this.AfD = asg.kCm;
    }

    public final int getType() {
        return 2929;
    }
}
