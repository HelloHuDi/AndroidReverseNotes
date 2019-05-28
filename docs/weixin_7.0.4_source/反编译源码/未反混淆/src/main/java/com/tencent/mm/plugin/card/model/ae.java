package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class ae extends m implements k {
    private final b ehh;
    private f ehi;
    public bnd kem;

    public ae(LinkedList<String> linkedList, int i) {
        AppMethodBeat.i(87907);
        a aVar = new a();
        aVar.fsJ = new aif();
        aVar.fsK = new aig();
        aVar.uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
        this.ehh = aVar.acD();
        aif aif = (aif) this.ehh.fsG.fsP;
        aif.wor = linkedList;
        aif.scene = i;
        AppMethodBeat.o(87907);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87908);
        ab.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.kem = ((aig) this.ehh.fsH.fsP).wos;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87908);
    }

    public final int getType() {
        return 1382;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87909);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87909);
        return a;
    }
}
