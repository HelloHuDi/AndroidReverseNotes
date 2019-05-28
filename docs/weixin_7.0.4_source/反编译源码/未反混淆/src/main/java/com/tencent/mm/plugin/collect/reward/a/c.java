package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class c extends p {
    public bue kDw;

    public c(String str, int i) {
        AppMethodBeat.i(41037);
        a aVar = new a();
        aVar.fsJ = new bud();
        aVar.fsK = new bue();
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bud bud = (bud) this.ehh.fsG.fsP;
        bud.wVT = str;
        bud.scene = i;
        ab.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", str, Integer.valueOf(i));
        AppMethodBeat.o(41037);
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41038);
        this.kDw = (bue) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDw.kCl), this.kDw.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41038);
    }

    public final void f(q qVar) {
        bue bue = (bue) ((b) qVar).fsH.fsP;
        this.AfC = bue.kCl;
        this.AfD = bue.kCm;
    }

    public final int getType() {
        return 2811;
    }

    public final boolean bgR() {
        return true;
    }
}
