package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d extends m implements k {
    private final b ehh;
    private f ehi;
    private String geY;

    public d(String str, LinkedList<bgc> linkedList) {
        AppMethodBeat.i(78843);
        a aVar = new a();
        aVar.fsJ = new vw();
        aVar.fsK = new vx();
        aVar.uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
        this.ehh = aVar.acD();
        this.geY = str;
        vw vwVar = (vw) this.ehh.fsG.fsP;
        vwVar.gfa = str;
        vwVar.vEN = linkedList;
        ab.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", str, Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(78843);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78844);
        ab.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (qVar.ZS().vyl == 0) {
            vx vxVar = (vx) ((b) qVar).fsH.fsP;
            String str2 = this.geY;
            if (!str2.toLowerCase().endsWith("@im.chatroom") || vxVar.vEN.isEmpty()) {
                ab.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + str2 + "] listCnt:" + vxVar.vEN.size());
            } else {
                ag XV = ((c) g.K(c.class)).XV();
                u oa = XV.oa(str2);
                List aor = u.aor(oa.field_memberlist);
                ab.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + aor.size());
                Iterator it = vxVar.vEN.iterator();
                while (it.hasNext()) {
                    aor.remove(((bgd) it.next()).userName);
                }
                ab.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + aor.size());
                oa.ep(aor).field_displayname = ((com.tencent.mm.plugin.chatroom.a.b) g.K(com.tencent.mm.plugin.chatroom.a.b.class)).U(aor);
                ab.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(XV.a(oa))));
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78844);
    }

    public final int getType() {
        return 943;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78845);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78845);
        return a;
    }
}
