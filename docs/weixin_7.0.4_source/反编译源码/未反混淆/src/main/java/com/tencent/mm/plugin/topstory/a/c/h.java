package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class h extends m implements k {
    public b ehh;
    private f ehi;
    public int fLW = 0;
    private long sAZ;
    private List<String> sBb;
    private List<Integer> sBc;

    public h(h hVar) {
        AppMethodBeat.i(96395);
        ab.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "copy NetSceneTopStorySetBlockList", Integer.valueOf(hVar.sBb.size()), Integer.valueOf(hVar.sBc.size()));
        this.fLW = hVar.fLW;
        n(hVar.sBb, hVar.sBc);
        AppMethodBeat.o(96395);
    }

    public h(List<String> list, List<Integer> list2) {
        AppMethodBeat.i(96396);
        ab.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "create NetSceneTopStorySetBlockList, users size:%s, type size:%s", Integer.valueOf(list.size()), Integer.valueOf(list2.size()));
        n(list, list2);
        AppMethodBeat.o(96396);
    }

    private void n(List<String> list, List<Integer> list2) {
        AppMethodBeat.i(96397);
        this.sAZ = System.currentTimeMillis();
        this.sBb = list;
        this.sBc = list2;
        a aVar = new a();
        aVar.fsI = 2859;
        aVar.uri = "/cgi-bin/mmsearch-bin/colikeblock";
        aVar.fsJ = new tf();
        aVar.fsK = new th();
        this.ehh = aVar.acD();
        tf tfVar = (tf) this.ehh.fsG.fsP;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                tg tgVar = new tg();
                tgVar.cts = ((Integer) list2.get(i2)).intValue();
                tgVar.vHl = (String) list.get(i2);
                tfVar.vHk.add(tgVar);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(96397);
                return;
            }
        }
    }

    public final int getType() {
        return 2859;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(96398);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(96398);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(96399);
        ab.i("MicroMsg.TopStory.NetSceneTopStorySetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(96399);
    }
}
