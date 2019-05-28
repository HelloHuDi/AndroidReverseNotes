package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bl;
import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class aq extends m implements k {
    private f ehi;
    public final b lty;

    public aq(int i, LinkedList<String> linkedList, int i2, boolean z) {
        AppMethodBeat.i(111445);
        a aVar = new a();
        aVar.fsJ = new bl();
        aVar.fsK = new bm();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
        this.lty = aVar.acD();
        bl blVar = (bl) this.lty.fsG.fsP;
        blVar.ncn = i;
        blVar.nco = 15;
        blVar.nbs = aa.dor();
        blVar.guW = bo.gQ(ah.getContext());
        blVar.ncp = i2;
        blVar.nbX = linkedList;
        blVar.ncq = z;
        AppMethodBeat.o(111445);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111446);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111446);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111447);
        ab.i("MicroMsg.NetSceneGetLibGameList", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111447);
    }

    public final int getType() {
        return 1218;
    }
}
