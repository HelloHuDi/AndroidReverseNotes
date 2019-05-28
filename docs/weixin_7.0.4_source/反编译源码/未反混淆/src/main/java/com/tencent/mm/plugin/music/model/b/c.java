package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private f ehi;
    private b fAT;
    private aoa oMI;
    public String oMJ = "";
    public String playUrl = "";

    public c(String str) {
        AppMethodBeat.i(104968);
        a aVar = new a();
        aVar.fsI = 769;
        aVar.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
        aVar.fsJ = new aoa();
        aVar.fsK = new aob();
        this.fAT = aVar.acD();
        this.oMI = (aoa) this.fAT.fsG.fsP;
        this.oMI.wsy = str;
        this.playUrl = str;
        ab.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", str);
        AppMethodBeat.o(104968);
    }

    public final int getType() {
        return 769;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(104969);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(104969);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(104970);
        ab.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aob aob = (aob) this.fAT.fsH.fsP;
            this.ehi.onSceneEnd(i2, i3, str, this);
            if (aob != null) {
                this.oMJ = aob.wsy;
                ab.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", this.oMJ);
                AppMethodBeat.o(104970);
                return;
            }
            ab.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
            AppMethodBeat.o(104970);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(104970);
    }
}
