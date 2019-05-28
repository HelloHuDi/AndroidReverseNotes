package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.sdk.platformtools.ab;

public final class x extends m implements k {
    private final b ehh;
    private f ehi;
    private String ked = "";

    public x() {
        AppMethodBeat.i(87886);
        a aVar = new a();
        aVar.fsJ = new agd();
        aVar.fsK = new age();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
        aVar.fsI = 692;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(87886);
    }

    public final int getType() {
        return 692;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87887);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87887);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87888);
        ab.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.ked = ((age) this.ehh.fsH.fsP).kdS;
            g.RP().Ry().set(282885, this.ked);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87888);
    }
}
