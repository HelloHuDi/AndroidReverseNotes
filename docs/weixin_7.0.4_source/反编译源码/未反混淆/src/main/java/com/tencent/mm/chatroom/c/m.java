package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.roomsdk.a.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.List;

public final class m extends a implements k {
    public bi cKd;
    public int ehB;
    private final b ehh;
    private f ehi;

    public m(String str, List<String> list) {
        AppMethodBeat.i(103940);
        b.a aVar = new b.a();
        aVar.fsJ = new aut();
        aVar.fsK = new auu();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        this.ehh = aVar.acD();
        aut aut = (aut) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            bay bay = new bay();
            bay.wcG = aa.vy(str2);
            linkedList.add(bay);
        }
        aut.vEh = linkedList;
        aut.ehB = linkedList.size();
        aut.vEi = aa.vy(str);
        aut.wyV = 0;
        AppMethodBeat.o(103940);
    }

    public m(String str, List<String> list, String str2, bi biVar) {
        AppMethodBeat.i(103941);
        this.cKd = biVar;
        b.a aVar = new b.a();
        aVar.fsJ = new aut();
        aVar.fsK = new auu();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        this.ehh = aVar.acD();
        aut aut = (aut) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            bay bay = new bay();
            bay.wcG = aa.vy(str3);
            linkedList.add(bay);
        }
        this.ehB = linkedList.size();
        aut.vEh = linkedList;
        aut.ehB = linkedList.size();
        aut.vEi = aa.vy(str);
        aut.wyV = 2;
        aut.wyW = str2;
        AppMethodBeat.o(103941);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103942);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103942);
        return a;
    }

    public final int getType() {
        return 610;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103943);
        ab.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103943);
    }

    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        if (!(aVar instanceof d)) {
            return aVar;
        }
        d dVar = (d) aVar;
        dVar.ehB = this.ehB;
        dVar.xuW = this.cKd;
        return dVar;
    }
}
