package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends f {
    private final b ehh;
    private f ehi;
    private final String nNq;
    private int sceneType = 0;
    public int syE;
    public LinkedList<cgm> sza;

    public c(int i, long j, String str, int i2) {
        AppMethodBeat.i(25875);
        this.sceneType = i2;
        a aVar = new a();
        aVar.fsJ = new aow();
        aVar.fsK = new aox();
        aVar.uri = "/cgi-bin/micromsg-bin/gettalkroommember";
        aVar.fsI = 336;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        aow aow = (aow) this.ehh.fsG.fsP;
        aow.wem = i;
        aow.wen = j;
        this.nNq = str;
        aow.Scene = i2;
        AppMethodBeat.o(25875);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25876);
        ab.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(25876);
        return a;
    }

    public final int getType() {
        return 336;
    }

    public final String cED() {
        return this.nNq;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25877);
        ab.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            aox aox = (aox) this.ehh.fsH.fsP;
            ab.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", aox.toString());
            this.syE = aox.weo;
            this.sza = as(aox.vEh);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25877);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25877);
    }

    private static LinkedList<cgm> as(LinkedList<cgm> linkedList) {
        AppMethodBeat.i(25878);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cgm cgm = (cgm) it.next();
            if (!bo.isNullOrNil(cgm.jBB)) {
                linkedList2.add(cgm);
            }
        }
        AppMethodBeat.o(25878);
        return linkedList2;
    }

    public final int cEE() {
        return this.sceneType;
    }
}
