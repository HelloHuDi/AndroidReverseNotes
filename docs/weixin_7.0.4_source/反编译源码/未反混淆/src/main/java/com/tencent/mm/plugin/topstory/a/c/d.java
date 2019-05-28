package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    public b ehh;
    private f ehi;

    public d(String str) {
        AppMethodBeat.i(65506);
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmsearch-bin/getuserattrbyopenid";
        aVar.fsJ = new apu();
        aVar.fsK = new apv();
        this.ehh = aVar.acD();
        ((apu) this.ehh.fsG.fsP).vGs = str;
        AppMethodBeat.o(65506);
    }

    public final int getType() {
        return 2830;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(65507);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(65507);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(65508);
        ab.i("MicroMsg.TopStory.NetSceneTopStoryGetUsername", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(65508);
    }
}
