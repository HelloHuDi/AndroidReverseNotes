package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.roomsdk.a.a implements k {
    private final b ehh;
    private f ehi;
    private String geY;

    public a(String str, LinkedList<bgc> linkedList, String str2) {
        AppMethodBeat.i(78832);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new co();
        aVar.fsK = new cp();
        aVar.uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
        this.ehh = aVar.acD();
        this.geY = str;
        co coVar = (co) this.ehh.fsG.fsP;
        coVar.gfa = str;
        coVar.vEN = linkedList;
        coVar.desc = str2;
        ab.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", str, Integer.valueOf(linkedList.size()), str2);
        AppMethodBeat.o(78832);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78833);
        ab.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (qVar.ZS().vyl == 0) {
            cp cpVar = (cp) ((b) qVar).fsH.fsP;
            String str2 = this.geY;
            if (!str2.toLowerCase().endsWith("@im.chatroom") || cpVar.vEN.isEmpty()) {
                ab.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + str2 + "] listCnt:" + cpVar.vEN.size());
            } else {
                ArrayList arrayList = new ArrayList();
                bd XM = ((j) g.K(j.class)).XM();
                Iterator it = cpVar.vEN.iterator();
                while (it.hasNext()) {
                    bgd bgd = (bgd) it.next();
                    if (bgd.status == 0) {
                        ap apVar;
                        ap aoO = XM.aoO(bgd.userName);
                        if (((int) aoO.ewQ) != 0) {
                            aoO.NA();
                            XM.b(aoO.field_username, (ad) aoO);
                            apVar = aoO;
                        } else {
                            apVar = c.a(aoO, bgd);
                            XM.Z(apVar);
                        }
                        arrayList.add(apVar.field_username);
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((com.tencent.mm.plugin.chatroom.a.b) g.K(com.tencent.mm.plugin.chatroom.a.b.class)).a(str2, arrayList, null);
                }
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78833);
    }

    public final int getType() {
        return 814;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78834);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78834);
        return a;
    }

    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        AppMethodBeat.i(78835);
        if (aVar != null && (aVar instanceof com.tencent.mm.roomsdk.a.b.c)) {
            cp cpVar = (cp) this.ehh.fsH.fsP;
            if (cpVar != null) {
                com.tencent.mm.openim.room.a.b.b bVar = new com.tencent.mm.openim.room.a.b.b();
                bVar.q(cpVar.vEN);
                com.tencent.mm.roomsdk.a.b.c cVar = (com.tencent.mm.roomsdk.a.b.c) aVar;
                cVar.chatroomName = this.geY;
                cVar.cEX = bVar.ehj.size();
                cVar.cFX = bVar.ehj;
                cVar.ehj = bVar.ehj;
                cVar.cGa = bVar.cGa;
                cVar.ehk = bVar.ehk;
                cVar.cGc = bVar.cGc;
                cVar.ehl = bVar.ehl;
                cVar.cGd = bVar.cGd;
                cVar.vEO = cpVar.vEO;
                AppMethodBeat.o(78835);
                return cVar;
            }
        }
        AppMethodBeat.o(78835);
        return aVar;
    }
}
