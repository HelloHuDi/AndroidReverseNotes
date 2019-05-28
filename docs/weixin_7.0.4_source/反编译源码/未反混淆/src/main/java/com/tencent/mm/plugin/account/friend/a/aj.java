package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxa;

public final class aj extends m implements k {
    private final b ehh;
    private f ehi;

    public aj(String str) {
        AppMethodBeat.i(108481);
        a aVar = new a();
        aVar.fsJ = new bwz();
        aVar.fsK = new bxa();
        aVar.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
        this.ehh = aVar.acD();
        ((bwz) this.ehh.fsG.fsP).wcB = new bts().alV(str);
        AppMethodBeat.o(108481);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108482);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108482);
        return a;
    }

    public final int getType() {
        return 108;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108483);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108483);
    }
}
