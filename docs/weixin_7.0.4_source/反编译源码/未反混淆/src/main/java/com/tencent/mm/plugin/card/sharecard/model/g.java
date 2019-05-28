package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class g extends m implements k {
    private final b ehh;
    private f ehi;
    public String kdS;
    public int kdT;
    public String kdU;

    public g(int i, LinkedList<byx> linkedList, String str, String str2, bzm bzm, int i2, cdc cdc) {
        AppMethodBeat.i(88033);
        a aVar = new a();
        aVar.fsJ = new byv();
        aVar.fsK = new byw();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecarditem";
        this.ehh = aVar.acD();
        byv byv = (byv) this.ehh.fsG.fsP;
        byv.wYd = i;
        byv.fjr = linkedList;
        byv.wSq = str;
        byv.wni = str2;
        ab.i("MicroMsg.NetSceneShareCardItem", "list length is " + linkedList.size());
        byv.wYe = bzm;
        byv.cME = i2;
        byv.vBy = cdc;
        AppMethodBeat.o(88033);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(88034);
        ab.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(902), Integer.valueOf(i2), Integer.valueOf(i3));
        byw byw;
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
            byw = (byw) this.ehh.fsH.fsP;
            if (byw != null) {
                this.kdS = byw.kdS;
                this.kdT = byw.kdT;
                this.kdU = byw.kdU;
            }
        } else {
            byw = (byw) this.ehh.fsH.fsP;
            if (byw != null) {
                this.kdS = byw.kdS;
                this.kdT = byw.kdT;
                this.kdU = byw.kdU;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(88034);
    }

    public final int getType() {
        return 902;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(88035);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(88035);
        return a;
    }
}
