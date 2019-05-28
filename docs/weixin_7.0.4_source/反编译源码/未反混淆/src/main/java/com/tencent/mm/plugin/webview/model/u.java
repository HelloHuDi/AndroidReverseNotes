package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class u extends m implements k {
    private final b ehh;
    private f ehi;

    public u(List<axc> list) {
        AppMethodBeat.i(6625);
        a aVar = new a();
        aVar.fsJ = new awn();
        aVar.fsK = new awo();
        aVar.uri = "/cgi-bin/mmux-bin/jslog";
        this.ehh = aVar.acD();
        awn awn = (awn) this.ehh.fsG.fsP;
        axb axb = new axb();
        axb.vOz = d.vxj;
        axb.vOA = d.vxi;
        axb.vOB = d.vxl;
        axb.vOC = d.vxm;
        axb.vOD = aa.dor();
        axb.wBk = (int) (System.currentTimeMillis() / 1000);
        awn.vDV = axb;
        awn.vDW.addAll(list);
        AppMethodBeat.o(6625);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6626);
        ab.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            awo awo = (awo) ((b) qVar).fsH.fsP;
            ab.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
            StringBuilder stringBuilder = new StringBuilder("{ ");
            if (bo.ek(awo.wAU)) {
                stringBuilder.append("{  }");
            } else {
                Iterator it = awo.wAU.iterator();
                while (it.hasNext()) {
                    aus aus = (aus) it.next();
                    stringBuilder.append(String.format(" { logId(%d), interval(%d) },", new Object[]{Integer.valueOf(aus.wyT), Integer.valueOf(aus.wyU)}));
                }
            }
            stringBuilder.append(" }");
            ab.i("MicroMsg.NetSceneJsLog", stringBuilder.toString());
            f.a.ulU;
            f.ea(awo.wAU);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6626);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6627);
        this.ehi = fVar;
        ab.d("MicroMsg.NetSceneJsLog", "doScene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6627);
        return a;
    }
}
