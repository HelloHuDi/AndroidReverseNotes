package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.sdk.platformtools.ab;

public final class au extends m implements k {
    private f ehi;
    final b lty;

    public au(int i, int i2) {
        AppMethodBeat.i(111457);
        ab.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", Integer.valueOf(i), Integer.valueOf(i2));
        a aVar = new a();
        aVar.fsJ = new bva();
        aVar.fsK = new bvb();
        aVar.uri = "/cgi-bin/mmgame-bin/searchgamelist";
        this.lty = aVar.acD();
        bva bva = (bva) this.lty.fsG.fsP;
        bva.ncn = i;
        bva.nco = i2;
        AppMethodBeat.o(111457);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111458);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111458);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111459);
        ab.i("MicroMsg.NetSceneSearchGameList", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111459);
    }

    public final int getType() {
        return 1215;
    }
}
