package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    public b ehh;
    private f ehi;
    private long sAZ = System.currentTimeMillis();
    public int type;

    public c(int i) {
        AppMethodBeat.i(96386);
        this.type = i;
        a aVar = new a();
        aVar.fsI = 2748;
        aVar.uri = "/cgi-bin/mmsearch-bin/getcolikeblocklist";
        aVar.fsJ = new ahm();
        aVar.fsK = new ahn();
        this.ehh = aVar.acD();
        ((ahm) this.ehh.fsG.fsP).jCt = i;
        ab.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "request NetSceneTopStoryGetBlockList: %d", Integer.valueOf(i));
        AppMethodBeat.o(96386);
    }

    public final int getType() {
        return 2748;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(96387);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(96387);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(96388);
        ab.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(96388);
    }
}
