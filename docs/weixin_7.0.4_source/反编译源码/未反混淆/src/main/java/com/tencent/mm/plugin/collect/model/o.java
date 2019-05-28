package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    private f ehi;
    private b gme;
    private byd kCC;

    public o(String str) {
        AppMethodBeat.i(40986);
        a aVar = new a();
        aVar.fsJ = new byd();
        aVar.fsK = new bye();
        aVar.uri = "/cgi-bin/micromsg-bin/setpushsound";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.kCC = (byd) this.gme.fsG.fsP;
        this.kCC.jCt = 3;
        this.kCC.wXD = str;
        ab.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", Integer.valueOf(3), str);
        AppMethodBeat.o(40986);
    }

    public final int getType() {
        return 304;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40987);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40987);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40988);
        ab.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40988);
    }
}
