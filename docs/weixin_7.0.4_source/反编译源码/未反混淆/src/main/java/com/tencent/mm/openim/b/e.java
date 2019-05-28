package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private final b ehh;
    private f ehi;
    private final String geY;

    public e(String str) {
        AppMethodBeat.i(78846);
        a aVar = new a();
        aVar.fsJ = new ale();
        aVar.fsK = new alf();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
        this.ehh = aVar.acD();
        this.geY = str;
        ((ale) this.ehh.fsG.fsP).gfa = str;
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", str);
        AppMethodBeat.o(78846);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78847);
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (i2 == 0 && i3 == 0) {
            alf alf = (alf) ((b) qVar).fsH.fsP;
            if (alf.wqG != null) {
                com.tencent.mm.openim.room.a.a.b(alf.wqG);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78847);
    }

    public final int getType() {
        return 407;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(78848);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78848);
        return a;
    }
}
