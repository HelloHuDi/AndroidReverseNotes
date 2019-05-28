package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.adj;
import com.tencent.mm.protocal.protobuf.adk;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.u;

public class e extends u implements i {
    private b ehh;
    private f ehi;
    public String tRa;
    public String tRb;
    public csj tRc;
    public String tRd = "";

    public e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3, String str9) {
        AppMethodBeat.i(48181);
        a aVar = new a();
        aVar.fsJ = new adj();
        aVar.fsK = new adk();
        aVar.uri = getUri();
        aVar.fsI = getType();
        aVar.fsL = 189;
        aVar.fsM = 1000000189;
        aVar.fsO = com.tencent.mm.wallet_core.ui.e.atB(str4);
        this.ehh = aVar.acD();
        this.tRd = str7;
        com.tencent.mm.plugin.soter.d.e cvQ = d.cvQ();
        String str10 = cvQ.rOh;
        String str11 = cvQ.jSY;
        adj adj = (adj) this.ehh.fsG.fsP;
        adj.fKh = str;
        adj.vYP = str4;
        adj.vYO = str3;
        adj.vYQ = str5;
        adj.vYR = str2;
        adj.vLo = str6;
        adj.vXP = str7;
        adj.wla = str8;
        adj.vAM = i;
        adj.wle = str10;
        adj.wld = str11;
        adj.vRP = k.cPy();
        if (i2 > 0) {
            adj.Scene = i2;
        }
        adj.wlf = i3;
        adj.wlg = str9;
        ab.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str9);
        AppMethodBeat.o(48181);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48182);
        ab.d("MicroMsg.NetSceneGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        adk adk = (adk) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(adk.luT), adk.luU);
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.NetSceneGenPrepay", "rr " + adk.wlb);
            this.tRa = adk.wlb;
            this.tRb = adk.wlc;
            this.tRc = adk.wlh;
        }
        String str2 = adk.luU;
        this.ehi.onSceneEnd(i, adk.luT, str2, this);
        AppMethodBeat.o(48182);
    }

    public int getType() {
        return 398;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(48183);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48183);
        return a;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/genprepay";
    }
}
