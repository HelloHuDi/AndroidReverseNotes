package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class a extends u {
    private b ehh;
    private f ehi;
    public String tRa;
    public String tRb;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        AppMethodBeat.i(48215);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bjv();
        aVar.fsK = new bjw();
        aVar.uri = "/cgi-bin/mmpay-bin/payugenprepay";
        this.ehh = aVar.acD();
        bjv bjv = (bjv) this.ehh.fsG.fsP;
        bjv.fKh = str;
        bjv.vYP = str4;
        bjv.vYO = str3;
        bjv.vYQ = str5;
        bjv.vYR = str2;
        bjv.vLo = str6;
        bjv.vXP = str7;
        bjv.wla = str8;
        bjv.vAM = i;
        ab.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str3, str5, str2, str6, str7, str8}));
        AppMethodBeat.o(48215);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48216);
        ab.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        bjw bjw = (bjw) ((b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.NetScenePayUGenPrepay", "rr " + bjw.wlb);
            this.tRa = bjw.wlb;
            this.tRb = bjw.wlc;
        }
        this.ehi.onSceneEnd(i, i2, bjw.luU, this);
        AppMethodBeat.o(48216);
    }

    public final int getType() {
        return 1521;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48217);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48217);
        return a;
    }
}
