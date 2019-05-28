package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private f ehi;
    private b fAT;
    public rl oMF;

    public a(int i, com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(104962);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmusic";
        aVar2.fsJ = new rl();
        aVar2.fsK = new rm();
        this.fAT = aVar2.acD();
        this.oMF = (rl) this.fAT.fsG.fsP;
        this.oMF.Scene = i;
        this.oMF.fKh = aVar.field_appId;
        this.oMF.vYH = aVar.field_songAlbumUrl;
        this.oMF.vYI = aVar.field_songHAlbumUrl;
        this.oMF.vYK = aVar.field_songWifiUrl;
        this.oMF.vYL = aVar.field_songWapLinkUrl;
        this.oMF.vYJ = aVar.field_songWebUrl;
        this.oMF.Title = aVar.field_songName;
        this.oMF.fJU = aVar.field_musicId;
        AppMethodBeat.o(104962);
    }

    public final int getType() {
        return 940;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(104963);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(104963);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(104964);
        ab.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(104964);
    }
}
