package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqf;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class e extends m implements k {
    public b ehh;
    private f ehi;
    private chv sBa;

    public e(chv chv, List<String> list) {
        AppMethodBeat.i(96389);
        ab.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStoryGetVideoUrl Video");
        this.sBa = chv;
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
        aVar.fsJ = new bqf();
        aVar.fsK = new bqg();
        this.ehh = aVar.acD();
        bqf bqf = (bqf) this.ehh.fsG.fsP;
        for (String str : list) {
            ue ueVar = new ue();
            ueVar.wbI = str;
            bqf.wSy.add(ueVar);
        }
        AppMethodBeat.o(96389);
    }

    public final int getType() {
        return 2579;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(96390);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(96390);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(96391);
        ab.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(96391);
    }
}
