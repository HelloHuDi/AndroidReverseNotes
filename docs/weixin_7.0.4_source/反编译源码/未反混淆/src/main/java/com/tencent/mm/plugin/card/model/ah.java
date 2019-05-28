package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah extends m implements k {
    private final b ehh;
    private f ehi;

    public ah(LinkedList<bhl> linkedList) {
        AppMethodBeat.i(87916);
        a aVar = new a();
        aVar.fsJ = new brs();
        aVar.fsK = new brt();
        aVar.uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
        this.ehh = aVar.acD();
        ((brs) this.ehh.fsG.fsP).wTU = linkedList;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bhl bhl = (bhl) it.next();
                ab.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", bhl.cMC, bhl.kdG, Integer.valueOf(bhl.wKK), Integer.valueOf(bhl.wKL));
            }
        }
        AppMethodBeat.o(87916);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87917);
        ab.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87917);
    }

    public final int getType() {
        return 1275;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87918);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87918);
        return a;
    }
}
