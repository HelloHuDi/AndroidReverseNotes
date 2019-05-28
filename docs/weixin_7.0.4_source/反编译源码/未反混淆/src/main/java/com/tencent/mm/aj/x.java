package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class x extends m implements k {
    private b ehh;
    private f ehi;

    public x(LinkedList<brm> linkedList) {
        AppMethodBeat.i(11458);
        a aVar = new a();
        aVar.fsJ = new brn();
        aVar.fsK = new bro();
        aVar.uri = "/cgi-bin/micromsg-bin/reportcommand";
        this.ehh = aVar.acD();
        ((brn) this.ehh.fsG.fsP).vZY = linkedList;
        ab.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", Integer.valueOf(r0.vZY.size()));
        AppMethodBeat.o(11458);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11459);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(11459);
    }

    public final int getType() {
        return 2592;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11460);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11460);
        return a;
    }
}
