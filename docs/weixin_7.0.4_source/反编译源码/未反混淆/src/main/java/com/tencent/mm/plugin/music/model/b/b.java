package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aw.d;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.jsapi.j.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private f ehi;
    private com.tencent.mm.ai.b fAT;
    public amz oMG;
    public boolean oMH;
    public a oMw;

    public b(a aVar, boolean z) {
        int i;
        AppMethodBeat.i(104965);
        this.oMw = aVar;
        this.oMH = z;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new amy();
        aVar2.fsK = new amz();
        aVar2.uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
        aVar2.fsI = e.CTRL_INDEX;
        this.fAT = aVar2.acD();
        amy amy = (amy) this.fAT.fsG.fsP;
        amy.fKj = aVar.field_songId;
        if (aVar.field_songWebUrl != null) {
            amy.wrz = aa.ad(aVar.field_songWebUrl.getBytes());
        }
        if (d.aio()) {
            i = 0;
        } else {
            i = 1;
        }
        amy.wrA = i;
        if (d.ain()) {
            i = 1;
        } else {
            i = 0;
        }
        amy.wrB = i;
        ab.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", Integer.valueOf(aVar.field_songId), aVar.field_songWebUrl, Integer.valueOf(amy.wrA), Integer.valueOf(amy.wrB));
        AppMethodBeat.o(104965);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(104966);
        ab.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.oMG = (amz) this.fAT.fsH.fsP;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(104966);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(104966);
    }

    public final int getType() {
        return e.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(104967);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(104967);
        return a;
    }
}
