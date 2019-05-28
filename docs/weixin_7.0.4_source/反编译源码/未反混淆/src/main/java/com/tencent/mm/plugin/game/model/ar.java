package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;

public final class ar extends m implements k {
    private f ehi;
    public final b lty;

    public ar(int i, int i2, int i3) {
        AppMethodBeat.i(111448);
        ab.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", Integer.valueOf(i), Integer.valueOf(15), Integer.valueOf(i2), Integer.valueOf(i3));
        a aVar = new a();
        aVar.fsJ = new bn();
        aVar.fsK = new bo();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
        this.lty = aVar.acD();
        bn bnVar = (bn) this.lty.fsG.fsP;
        bnVar.ncn = i;
        bnVar.nco = 15;
        bnVar.nbs = aa.dor();
        bnVar.ncv = i2;
        bnVar.ncw = i3;
        AppMethodBeat.o(111448);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111449);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111449);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111450);
        ab.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111450);
    }

    public final int getType() {
        return 1220;
    }
}
