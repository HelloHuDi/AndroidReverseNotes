package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends a implements k {
    private final b ehh;
    private f ehi;

    public c(LinkedList<bgc> linkedList) {
        AppMethodBeat.i(78839);
        b.a aVar = new b.a();
        aVar.fsJ = new ut();
        aVar.fsK = new uu();
        aVar.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
        this.ehh = aVar.acD();
        ((ut) this.ehh.fsG.fsP).vEN = linkedList;
        ab.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(78839);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78840);
        ab.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar.ZS().vyl == 0) {
            uu uuVar = (uu) ((b) qVar).fsH.fsP;
            if (!bo.isNullOrNil(uuVar.gfa)) {
                if (uuVar.gfa.toLowerCase().endsWith("@im.chatroom")) {
                    ad adVar = new ad();
                    adVar.setUsername(uuVar.gfa);
                    bd XM = ((j) g.K(j.class)).XM();
                    if (!XM.aoQ(adVar.field_username)) {
                        XM.Z(adVar);
                    }
                    if (!(bo.isNullOrNil(adVar.field_username) || bo.isNullOrNil(uuVar.wck))) {
                        h hVar = new h();
                        hVar.username = adVar.field_username;
                        hVar.frW = uuVar.wcj;
                        hVar.frV = uuVar.wck;
                        hVar.dtR = 3;
                        hVar.cB(false);
                        hVar.bJt = -1;
                        o.act().b(hVar);
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it = uuVar.vEN.iterator();
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
                                apVar = com.tencent.mm.openim.room.a.b.c.a(aoO, bgd);
                                XM.Z(apVar);
                            }
                            arrayList.add(apVar.field_username);
                        }
                    }
                    if (!arrayList.contains(r.Yz())) {
                        arrayList.add(r.Yz());
                        ab.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + arrayList.contains(r.Yz()));
                    }
                    ((com.tencent.mm.plugin.chatroom.a.b) g.K(com.tencent.mm.plugin.chatroom.a.b.class)).a(adVar.field_username, arrayList, r.Yz());
                } else {
                    ab.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + uuVar.gfa + "]");
                }
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78840);
    }

    public final int getType() {
        return 371;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78841);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78841);
        return a;
    }

    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        AppMethodBeat.i(78842);
        if (aVar != null && (aVar instanceof com.tencent.mm.roomsdk.a.b.c)) {
            uu uuVar = (uu) this.ehh.fsH.fsP;
            if (uuVar != null) {
                com.tencent.mm.openim.room.a.b.b bVar = new com.tencent.mm.openim.room.a.b.b();
                bVar.q(uuVar.vEN);
                com.tencent.mm.roomsdk.a.b.c cVar = (com.tencent.mm.roomsdk.a.b.c) aVar;
                cVar.chatroomName = uuVar.gfa;
                cVar.cEX = bVar.ehj.size();
                cVar.cFX = bVar.ehj;
                cVar.ehj = bVar.ehj;
                cVar.cGa = bVar.cGa;
                cVar.ehk = bVar.ehk;
                cVar.cGc = bVar.cGc;
                cVar.ehl = bVar.ehl;
                cVar.cGd = bVar.cGd;
                AppMethodBeat.o(78842);
                return cVar;
            }
        }
        AppMethodBeat.o(78842);
        return aVar;
    }
}
