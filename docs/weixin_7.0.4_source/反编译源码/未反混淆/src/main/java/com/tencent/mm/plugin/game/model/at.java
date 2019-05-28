package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.sdk.platformtools.ab;

public final class at extends m implements k {
    private f ehi;
    private final b lty;

    public at(String str, int i, int i2, String str2, String str3) {
        AppMethodBeat.i(111454);
        a aVar = new a();
        aVar.fsJ = new au();
        aVar.fsK = new av();
        aVar.uri = "/cgi-bin/mmgame-bin/gamereport";
        this.lty = aVar.acD();
        au auVar = (au) this.lty.fsG.fsP;
        auVar.mZr = str;
        auVar.nbk = i;
        auVar.nbl = i2;
        auVar.nbm = str2;
        auVar.nbn = str3;
        auVar.nbj = (int) (System.currentTimeMillis() / 1000);
        AppMethodBeat.o(111454);
    }

    public final int getType() {
        return 1223;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111455);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111455);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111456);
        ab.i("MicroMsg.NetSceneGetGameIndex", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111456);
    }
}
