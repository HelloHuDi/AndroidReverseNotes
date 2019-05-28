package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e extends a implements k {
    private int cEX = 0;
    public final List<String> cFX;
    private final List<String> cGa;
    private final List<String> cGc;
    private final List<String> cGd;
    private String chatroomName = null;
    private final b ehh;
    private f ehi = null;
    private final List<String> ehj;
    private final List<String> ehk;
    private final List<String> ehl;

    public e(String str, List<String> list, String str2) {
        AppMethodBeat.i(103910);
        b.a aVar = new b.a();
        aVar.fsJ = new ca();
        aVar.fsK = new cb();
        aVar.uri = "/cgi-bin/micromsg-bin/addchatroommember";
        aVar.fsI = 120;
        aVar.fsL = 36;
        aVar.fsM = 1000000036;
        this.ehh = aVar.acD();
        ca caVar = (ca) this.ehh.fsG.fsP;
        caVar.vEi = aa.vy(str);
        this.chatroomName = str;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            bay bay = new bay();
            bay.wcG = aa.vy(str3);
            linkedList.add(bay);
        }
        caVar.vEh = linkedList;
        caVar.ehB = linkedList.size();
        this.ehj = new ArrayList();
        this.cGa = new LinkedList();
        this.ehk = new LinkedList();
        this.cGc = new LinkedList();
        this.cGd = new LinkedList();
        this.ehl = new ArrayList();
        this.cFX = list;
        caVar.vEk = str2;
        AppMethodBeat.o(103910);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(103911);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103911);
        return a;
    }

    public final int getType() {
        return 120;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103912);
        ca caVar = (ca) this.ehh.fsG.fsP;
        cb cbVar = (cb) this.ehh.fsH.fsP;
        this.cEX = cbVar.ehB;
        LinkedList linkedList = cbVar.vEh;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= linkedList.size()) {
                break;
            }
            i4 = ((baz) linkedList.get(i5)).wFJ;
            if (i4 == 0) {
                this.ehj.add(aa.a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 == 3) {
                ab.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((baz) linkedList.get(i5)).wcG);
                this.ehk.add(aa.a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 == 1) {
                ab.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((baz) linkedList.get(i5)).wcG);
                this.cGc.add(aa.a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 == 2) {
                ab.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((baz) linkedList.get(i5)).wcG);
                this.cGa.add(aa.a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 == 4) {
                ab.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((baz) linkedList.get(i5)).wcG);
                this.cGd.add(aa.a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 != 5) {
                if (i4 == 6) {
                    this.ehl.add(aa.a(((baz) linkedList.get(i5)).wcG));
                } else {
                    ab.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(i4)));
                }
            }
            i4 = i5 + 1;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            n.a(aa.a(caVar.vEi), cbVar);
        }
        AppMethodBeat.o(103912);
    }

    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        if (!(aVar instanceof c)) {
            return aVar;
        }
        c cVar = (c) aVar;
        cVar.chatroomName = this.chatroomName;
        cVar.cGa = this.cGa;
        cVar.cEX = this.cEX;
        cVar.cFX = this.cFX;
        cVar.ehk = this.ehk;
        cVar.ehj = this.ehj;
        cVar.cGc = this.cGc;
        cVar.ehl = this.ehl;
        cVar.cGd = this.cGd;
        return cVar;
    }
}
