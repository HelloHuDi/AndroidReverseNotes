package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.game.d.df;
import com.tencent.mm.sdk.platformtools.ab;

public final class av extends m implements k {
    private f ehi;
    public final b lty;

    public av(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(111460);
        a aVar = new a();
        aVar.fsJ = new de();
        aVar.fsK = new df();
        aVar.uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
        this.lty = aVar.acD();
        de deVar = (de) this.lty.fsG.fsP;
        deVar.mZr = str;
        deVar.nbs = str2;
        deVar.mZo = str3;
        deVar.mZD = z;
        AppMethodBeat.o(111460);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111461);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111461);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111462);
        ab.i("MicroMsg.NetSceneGameSubscription", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111462);
    }

    public final int getType() {
        return 1219;
    }
}
