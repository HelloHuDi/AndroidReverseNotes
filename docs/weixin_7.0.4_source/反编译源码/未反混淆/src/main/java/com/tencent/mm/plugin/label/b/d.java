package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d extends m implements k {
    private final b ehh;
    private f ehi;
    private LinkedList<cmh> nHy = new LinkedList();

    public d(LinkedList<cmh> linkedList) {
        AppMethodBeat.i(22530);
        a aVar = new a();
        aVar.fsJ = new bcs();
        aVar.fsK = new bct();
        aVar.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
        aVar.fsI = 638;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nHy = linkedList;
        AppMethodBeat.o(22530);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(22531);
        ab.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(22531);
    }

    public final int getType() {
        return 638;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(22532);
        ab.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
        this.ehi = fVar;
        bcs bcs = (bcs) this.ehh.fsG.fsP;
        bcs.wHh = this.nHy;
        bcs.wnW = this.nHy.size();
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(22532);
        return a;
    }
}
