package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class as extends m implements k {
    private String appId;
    private f ehi;
    final b lty;

    public as(String str) {
        AppMethodBeat.i(111451);
        a aVar = new a();
        aVar.fsJ = new asl();
        aVar.fsK = new asm();
        aVar.uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
        this.appId = str;
        this.lty = aVar.acD();
        asl asl = (asl) this.lty.fsG.fsP;
        asl.nbs = aa.dor();
        asl.guW = bo.gQ(ah.getContext());
        asl.fKh = str;
        ab.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", asl.nbs, asl.guW, asl.fKh);
        AppMethodBeat.o(111451);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111452);
        ab.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 != 0 || i3 != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(111452);
        } else if (((asm) ((b) qVar).fsH.fsP) == null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(111452);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(111452);
        }
    }

    public final int getType() {
        return 1369;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111453);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111453);
        return a;
    }
}
