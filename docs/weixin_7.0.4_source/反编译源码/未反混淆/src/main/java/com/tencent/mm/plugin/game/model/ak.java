package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class ak extends m implements k {
    private f ehi;
    public final b lty;

    public ak(String str, LinkedList<String> linkedList, LinkedList<String> linkedList2, int i) {
        AppMethodBeat.i(111427);
        a aVar = new a();
        aVar.fsJ = new acz();
        aVar.fsK = new ada();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearch";
        this.lty = aVar.acD();
        acz acz = (acz) this.lty.fsG.fsP;
        acz.nbs = str;
        acz.wkL = linkedList;
        acz.wkE = linkedList2;
        acz.wkM = i;
        AppMethodBeat.o(111427);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111428);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111428);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111429);
        ab.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111429);
    }

    public final int getType() {
        return 1328;
    }
}
