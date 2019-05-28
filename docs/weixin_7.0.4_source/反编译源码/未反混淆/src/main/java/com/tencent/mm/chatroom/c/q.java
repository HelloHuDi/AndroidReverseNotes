package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;

public final class q extends m implements k {
    public String chatroomName = null;
    public String ehC = null;
    public int ehD = 0;
    public int ehE = 0;
    private final b ehh;
    private f ehi = null;
    public String ehr = null;

    public q(String str) {
        AppMethodBeat.i(103953);
        a aVar = new a();
        aVar.fsJ = new cko();
        aVar.fsK = new ckp();
        aVar.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
        aVar.fsI = 482;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.chatroomName = str;
        ((cko) this.ehh.fsG.fsP).vEf = str;
        AppMethodBeat.o(103953);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103954);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103954);
        return a;
    }

    public final int getType() {
        return 482;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(103955);
        ckp ckp = (ckp) this.ehh.fsH.fsP;
        ab.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehC = ckp.wGj;
        if (!bo.isNullOrNil(this.ehC)) {
            u oa = ((c) g.K(c.class)).XV().oa(this.chatroomName);
            if (oa == null) {
                oa = new u();
            }
            oa.ib(r.Yz(), this.ehC);
            n.a(oa);
        }
        this.ehr = ckp.wnK;
        this.ehD = ckp.wnJ;
        this.ehE = ckp.wnL;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103955);
    }
}
