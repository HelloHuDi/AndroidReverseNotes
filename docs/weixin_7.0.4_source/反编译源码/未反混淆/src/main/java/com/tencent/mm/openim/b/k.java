package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class k extends m implements com.tencent.mm.network.k {
    private final b ehh;
    private f ehi;
    private String geY;

    public k(String str, LinkedList<bgc> linkedList) {
        AppMethodBeat.i(78865);
        a aVar = new a();
        aVar.fsJ = new ava();
        aVar.fsK = new avb();
        aVar.uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
        this.ehh = aVar.acD();
        this.geY = str;
        ava ava = (ava) this.ehh.fsG.fsP;
        ava.gfa = str;
        ava.vEN = linkedList;
        ab.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", str, Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(78865);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78866);
        ab.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78866);
    }

    public final int getType() {
        return 887;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78867);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78867);
        return a;
    }
}
