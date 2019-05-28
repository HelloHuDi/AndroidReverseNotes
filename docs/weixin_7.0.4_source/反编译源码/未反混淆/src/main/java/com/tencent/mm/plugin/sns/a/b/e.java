package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.util.List;

public final class e extends m implements k {
    private b ehh;
    public f ehi;
    public List<axc> iKa;

    public e(List<axc> list) {
        int i = 0;
        AppMethodBeat.i(35708);
        a aVar = new a();
        this.iKa = list;
        aVar.fsJ = new bq();
        aVar.fsK = new br();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        this.ehh = aVar.acD();
        bq bqVar = (bq) this.ehh.fsG.fsP;
        axb axb = new axb();
        axb.vOz = d.vxj;
        axb.vOA = d.vxi;
        axb.vOB = d.vxl;
        axb.vOC = d.vxm;
        axb.vOD = aa.dor();
        axb.wBk = (int) (System.currentTimeMillis() / 1000);
        bqVar.vDV = axb;
        while (i < list.size()) {
            bqVar.vDW.add(list.get(i));
            i++;
        }
        ab.i("MicroMsg.NetSceneAdLog", "report count: " + bqVar.vDW.size());
        AppMethodBeat.o(35708);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(35709);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(35709);
        return a;
    }

    public final int getType() {
        return 1802;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(35710);
        ab.d("MicroMsg.NetSceneAdLog", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            int i4 = ((br) ((b) qVar).fsH.fsP).vDX;
            g.RQ();
            g.RP().Ry().set(ac.a.BUSINESS_SNS_ADLOG_FREQUENCY_INT, Integer.valueOf(i4));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(35710);
    }
}
