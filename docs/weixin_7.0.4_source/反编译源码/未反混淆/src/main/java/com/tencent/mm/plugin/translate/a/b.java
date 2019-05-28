package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import java.util.LinkedList;

public final class b extends m implements k {
    private final com.tencent.mm.ai.b ehh;
    private f ehi = null;
    public LinkedList<cis> sKv;

    public b(LinkedList<cir> linkedList) {
        AppMethodBeat.i(26058);
        a aVar = new a();
        aVar.fsJ = new apa();
        aVar.fsK = new apb();
        aVar.uri = "/cgi-bin/micromsg-bin/gettranstext";
        aVar.fsI = 631;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        apa apa = (apa) this.ehh.fsG.fsP;
        apa.wtc = linkedList;
        apa.jBu = linkedList.size();
        AppMethodBeat.o(26058);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26059);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(26059);
        return a;
    }

    public final int getType() {
        return 631;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26060);
        this.sKv = ((apb) this.ehh.fsH.fsP).wtc;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26060);
    }
}
