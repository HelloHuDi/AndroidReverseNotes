package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.sdk.platformtools.ab;

public final class ad extends m implements k {
    private f ehi;
    private b gme;
    private bhc tgv;
    public bhd tgw;

    public ad(String str, String str2) {
        AppMethodBeat.i(45332);
        a aVar = new a();
        aVar.fsJ = new bhc();
        aVar.fsK = new bhd();
        aVar.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.tgv = (bhc) this.gme.fsG.fsP;
        this.tgv.vKZ = str;
        this.tgv.wKu = str2;
        this.tgv.tgu = ab.cMM();
        ab.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", str, str2);
        AppMethodBeat.o(45332);
    }

    public final int getType() {
        return 2996;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(45333);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(45333);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(45334);
        ab.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.tgw = (bhd) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", Integer.valueOf(this.tgw.kdT), this.tgw.kdU);
        if (this.tgw.kdT == 0) {
            ab.ach(this.tgw.tgu);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(45334);
    }
}
