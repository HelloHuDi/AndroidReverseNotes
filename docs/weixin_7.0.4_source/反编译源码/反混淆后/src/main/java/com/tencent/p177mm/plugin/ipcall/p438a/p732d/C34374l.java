package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p440c.C12250b;
import com.tencent.p177mm.protocal.protobuf.bmf;
import com.tencent.p177mm.protocal.protobuf.bmg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.l */
public final class C34374l extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi;
    private bmf nyC = null;
    private bmg nyD = null;

    public C34374l(int i, long j, boolean z) {
        AppMethodBeat.m2504i(21869);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bmf();
        c1196a.fsK = new bmg();
        c1196a.fsI = 227;
        c1196a.uri = "/cgi-bin/micromsg-bin/pstnreport";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nyC = (bmf) this.ehh.fsG.fsP;
        this.nyC.wem = i;
        this.nyC.wOS = j;
        this.nyC.wPl = z ? 1 : 0;
        C4990ab.m7411d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", Integer.valueOf(this.nyC.wem), Long.valueOf(this.nyC.wOS), Integer.valueOf(this.nyC.wPl));
        bmf bmf = this.nyC;
        C12250b bHs = C21088i.bHs();
        C4990ab.m7417i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", bHs.nwu + "," + bHs.nwv + "," + bHs.nxO + "," + bHs.gyD + "," + bHs.nxP + "," + bHs.nxE + "," + bHs.nxF + "," + bHs.nxG + "," + bHs.nxH + "," + bHs.nxI + "," + bHs.nxJ + "," + bHs.nxK + "," + bHs.nxL + "," + bHs.nxM + "," + bHs.nxN + "," + bHs.nxQ + "," + C34382c.bIP() + "," + bHs.nxZ + "," + bHs.countryCode + "," + bHs.nya + "," + bHs.nyb + "," + bHs.nyc + bHs.nxX + "," + bHs.nye);
        bmf.wPi = C1946aa.m4154vy(r3);
        bmf = this.nyC;
        bHs = C21088i.bHs();
        C4990ab.m7417i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", bHs.nwu + "," + bHs.nwv + "," + bHs.nxO + bHs.nxW);
        bmf.wPj = C1946aa.m4154vy(r3);
        bmf = this.nyC;
        bHs = C21088i.bHs();
        C4990ab.m7417i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", bHs.nwu + "," + bHs.nwv + "," + bHs.nxO + bHs.nxV);
        bmf.wPk = C1946aa.m4154vy(r3);
        AppMethodBeat.m2505o(21869);
    }

    public final int getType() {
        return 227;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21870);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21870);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21871);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyD = (bmg) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21871);
    }
}
