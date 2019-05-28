package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class d extends u {
    private b ehh;
    private f ehi;
    public String tRa;
    public String tRb;

    public d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9) {
        AppMethodBeat.i(48178);
        a aVar = new a();
        aVar.fsJ = new adh();
        aVar.fsK = new adi();
        aVar.uri = "/cgi-bin/mmpay-bin/genmallprepay";
        this.ehh = aVar.acD();
        adh adh = (adh) this.ehh.fsG.fsP;
        adh.fKh = str;
        adh.vYP = str4;
        adh.vYO = str3;
        adh.vYQ = str5;
        adh.vYR = str2;
        adh.vLo = str6;
        adh.vXP = str7;
        adh.wla = str8;
        adh.vAM = i;
        adh.ndT = str9;
        if (i2 > 0) {
            adh.Scene = i2;
        }
        ab.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2)}));
        AppMethodBeat.o(48178);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48179);
        ab.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        adi adi = (adi) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(adi.luT), adi.luU);
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.NetSceneGenMallPrepay", "rr " + adi.wlb);
            this.tRa = adi.wlb;
            this.tRb = adi.wlc;
        }
        String str2 = adi.luU;
        this.ehi.onSceneEnd(i, adi.luT, str2, this);
        AppMethodBeat.o(48179);
    }

    public final int getType() {
        return 2755;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48180);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48180);
        return a;
    }
}
