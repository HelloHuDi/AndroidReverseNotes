package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.sdk.platformtools.ab;

public final class v extends m implements k {
    public b ehh;
    private f ehi;

    public v(String str, String str2, int i) {
        AppMethodBeat.i(11636);
        a aVar = new a();
        aVar.fsJ = new bot();
        aVar.fsK = new bou();
        aVar.uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
        this.ehh = aVar.acD();
        bot bot = (bot) this.ehh.fsG.fsP;
        bot.vNb = str;
        bot.vMV = str2;
        bot.time_stamp = i;
        AppMethodBeat.o(11636);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11637);
        ab.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11637);
    }

    public final int getType() {
        return 1361;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11638);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11638);
        return a;
    }
}
