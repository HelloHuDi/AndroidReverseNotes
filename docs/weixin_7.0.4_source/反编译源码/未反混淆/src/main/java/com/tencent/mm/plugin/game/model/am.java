package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.sdk.platformtools.ab;

public final class am extends m implements k {
    private f ehi;
    public final b lty;

    public am(String str, String str2, boolean z) {
        AppMethodBeat.i(111433);
        a aVar = new a();
        aVar.fsJ = new az();
        aVar.fsK = new ba();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
        this.lty = aVar.acD();
        az azVar = (az) this.lty.fsG.fsP;
        azVar.nbs = str;
        azVar.mZr = str2;
        azVar.nbG = z;
        azVar.nbI = true;
        AppMethodBeat.o(111433);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111434);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111434);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111435);
        ab.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111435);
    }

    public final int getType() {
        return 1217;
    }
}
