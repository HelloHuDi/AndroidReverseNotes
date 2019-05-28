package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class al extends m implements k {
    public String ctj;
    private f ehi;
    public final b lty;

    public al(String str, String str2, LinkedList<String> linkedList) {
        AppMethodBeat.i(111430);
        a aVar = new a();
        aVar.fsJ = new acw();
        aVar.fsK = new acx();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
        if (str2 == null) {
            this.ctj = "";
        } else {
            this.ctj = str2.trim();
        }
        this.lty = aVar.acD();
        acw acw = (acw) this.lty.fsG.fsP;
        acw.nbs = str;
        acw.wkD = str2;
        acw.wkE = linkedList;
        AppMethodBeat.o(111430);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111431);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111431);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111432);
        ab.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111432);
    }

    public final int getType() {
        return 1329;
    }
}
