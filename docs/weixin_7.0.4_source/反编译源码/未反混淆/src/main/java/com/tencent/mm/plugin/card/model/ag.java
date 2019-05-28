package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.sdk.platformtools.ab;

public final class ag extends m implements k {
    public String cKE;
    public String content;
    private final b ehh;
    private f ehi;
    public String hfo;
    public String ken;
    public String keo;
    public boolean kep;
    public String keq;
    public String ker;
    public String kes;
    public String ket;
    public int status;

    public ag(int i, String str, String str2) {
        AppMethodBeat.i(87913);
        a aVar = new a();
        aVar.fsJ = new bkx();
        aVar.fsK = new bky();
        aVar.uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
        this.ehh = aVar.acD();
        bkx bkx = (bkx) this.ehh.fsG.fsP;
        bkx.vBA = i;
        bkx.vBB = str;
        bkx.vBC = str2;
        AppMethodBeat.o(87913);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87914);
        ab.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            bky bky = (bky) this.ehh.fsH.fsP;
            this.cKE = bky.vBF;
            this.ken = bky.vBG;
            this.status = bky.status;
            this.content = bky.content;
            this.keo = bky.kdE;
            this.hfo = bky.wNR;
            this.kep = bky.kep;
            this.keq = bky.wNS;
            this.ker = bky.wNT;
            this.kes = bky.wNU;
            this.ket = bky.wNV;
            ab.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", this.cKE, this.ken, Integer.valueOf(this.status), this.content, this.keo, this.hfo, Boolean.valueOf(this.kep));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87914);
    }

    public final int getType() {
        return 1171;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87915);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87915);
        return a;
    }
}
