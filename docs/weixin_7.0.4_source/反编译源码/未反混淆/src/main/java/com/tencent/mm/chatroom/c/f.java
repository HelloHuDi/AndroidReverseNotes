package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends m implements k {
    private LinkedList<arz> cFS;
    private final b ehh;
    private com.tencent.mm.ai.f ehi;

    public f(LinkedList<arz> linkedList) {
        AppMethodBeat.i(103913);
        this.cFS = linkedList;
        a aVar = new a();
        aVar.fsJ = new tk();
        aVar.fsK = new tl();
        aVar.uri = "/cgi-bin/micromsg-bin/collectchatroom";
        this.ehh = aVar.acD();
        tk tkVar = (tk) this.ehh.fsG.fsP;
        tkVar.waB = linkedList;
        tkVar.waA = linkedList.size();
        AppMethodBeat.o(103913);
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(103914);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103914);
        return a;
    }

    public final int getType() {
        return 181;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103915);
        ab.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (qVar.ZS().vyl != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(103915);
            return;
        }
        if (this.cFS != null) {
            Iterator it = this.cFS.iterator();
            while (it.hasNext()) {
                arz arz = (arz) it.next();
                ab.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + arz.wvO);
                n.mv(arz.wvO);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103915);
    }
}
