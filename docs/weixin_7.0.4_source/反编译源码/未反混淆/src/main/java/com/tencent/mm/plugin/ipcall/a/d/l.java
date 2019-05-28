package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bmg;
import com.tencent.mm.sdk.platformtools.ab;

public final class l extends m implements k {
    private b ehh = null;
    private f ehi;
    private bmf nyC = null;
    private bmg nyD = null;

    public l(int i, long j, boolean z) {
        AppMethodBeat.i(21869);
        a aVar = new a();
        aVar.fsJ = new bmf();
        aVar.fsK = new bmg();
        aVar.fsI = 227;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnreport";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyC = (bmf) this.ehh.fsG.fsP;
        this.nyC.wem = i;
        this.nyC.wOS = j;
        this.nyC.wPl = z ? 1 : 0;
        ab.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", Integer.valueOf(this.nyC.wem), Long.valueOf(this.nyC.wOS), Integer.valueOf(this.nyC.wPl));
        bmf bmf = this.nyC;
        com.tencent.mm.plugin.ipcall.a.c.b bHs = i.bHs();
        ab.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", bHs.nwu + "," + bHs.nwv + "," + bHs.nxO + "," + bHs.gyD + "," + bHs.nxP + "," + bHs.nxE + "," + bHs.nxF + "," + bHs.nxG + "," + bHs.nxH + "," + bHs.nxI + "," + bHs.nxJ + "," + bHs.nxK + "," + bHs.nxL + "," + bHs.nxM + "," + bHs.nxN + "," + bHs.nxQ + "," + c.bIP() + "," + bHs.nxZ + "," + bHs.countryCode + "," + bHs.nya + "," + bHs.nyb + "," + bHs.nyc + bHs.nxX + "," + bHs.nye);
        bmf.wPi = aa.vy(r3);
        bmf = this.nyC;
        bHs = i.bHs();
        ab.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", bHs.nwu + "," + bHs.nwv + "," + bHs.nxO + bHs.nxW);
        bmf.wPj = aa.vy(r3);
        bmf = this.nyC;
        bHs = i.bHs();
        ab.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", bHs.nwu + "," + bHs.nwv + "," + bHs.nxO + bHs.nxV);
        bmf.wPk = aa.vy(r3);
        AppMethodBeat.o(21869);
    }

    public final int getType() {
        return 227;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21870);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21870);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21871);
        ab.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyD = (bmg) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21871);
    }
}
