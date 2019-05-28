package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    private f ehi;
    private b gme;
    public os kCi;

    public j() {
        AppMethodBeat.i(40970);
        a aVar = new a();
        aVar.fsJ = new or();
        aVar.fsK = new os();
        aVar.uri = "/cgi-bin/mmpay-bin/f2fannounce";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        ab.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
        AppMethodBeat.o(40970);
    }

    public final int getType() {
        return 1256;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40971);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40971);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40972);
        ab.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.kCi = (os) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40972);
    }
}
