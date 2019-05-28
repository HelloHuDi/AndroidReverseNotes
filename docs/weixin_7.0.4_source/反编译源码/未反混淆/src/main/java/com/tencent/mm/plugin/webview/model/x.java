package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.protocal.protobuf.beq;
import java.util.LinkedList;

public final class x extends m implements k {
    private f eIc;
    public final b ehh;
    public Object tag;

    public x(String str, int i, LinkedList<String> linkedList) {
        AppMethodBeat.i(6634);
        a aVar = new a();
        aVar.fsJ = new bep();
        aVar.fsK = new beq();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
        this.ehh = aVar.acD();
        bep bep = (bep) this.ehh.fsG.fsP;
        bep.wIH = str;
        bep.wII = i;
        bep.wIJ = linkedList;
        AppMethodBeat.o(6634);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6635);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6635);
    }

    public final int getType() {
        return 1373;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6636);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6636);
        return a;
    }
}
