package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g extends a implements k {
    public int cFY = 0;
    public String cFZ;
    public final List<String> cGa;
    public final List<String> cGc;
    public List<String> cGd;
    public List<String> cGe;
    private final b ehh;
    private f ehi;
    public final List<String> ehk;

    public g(String str, List<String> list) {
        AppMethodBeat.i(103916);
        ab.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + str + " size : " + list.size() + " username : " + ((String) list.get(0)));
        b.a aVar = new b.a();
        aVar.fsJ = new up();
        aVar.fsK = new uq();
        aVar.uri = "/cgi-bin/micromsg-bin/createchatroom";
        aVar.fsI = d.MIC_AVROUND_BLUR;
        aVar.fsL = 37;
        aVar.fsM = 1000000037;
        this.ehh = aVar.acD();
        up upVar = (up) this.ehh.fsG.fsP;
        upVar.wcc = aa.vy(str);
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            bay bay = new bay();
            bay.wcG = aa.vy(str2);
            linkedList.add(bay);
        }
        upVar.vEh = linkedList;
        upVar.ehB = linkedList.size();
        this.cGa = new LinkedList();
        this.ehk = new LinkedList();
        this.cGc = new LinkedList();
        this.cGd = new LinkedList();
        this.cGe = new LinkedList();
        this.cFZ = "";
        AppMethodBeat.o(103916);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103917);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103917);
        return a;
    }

    public final int getType() {
        return d.MIC_AVROUND_BLUR;
    }

    private static boolean a(uq uqVar) {
        int i = 0;
        AppMethodBeat.i(103918);
        if (!aa.a(uqVar.vEi).toLowerCase().endsWith("@chatroom") || uqVar.ehB == 0) {
            ab.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + uqVar.vEi + "] listCnt:" + uqVar.ehB);
            AppMethodBeat.o(103918);
            return false;
        }
        ad adVar = new ad();
        adVar.iB(aa.a(uqVar.wcc));
        adVar.iC(aa.a(uqVar.wce));
        adVar.iD(aa.a(uqVar.wcf));
        adVar.setUsername(aa.a(uqVar.vEi));
        bd XM = ((j) com.tencent.mm.kernel.g.K(j.class)).XM();
        if (!XM.aoQ(adVar.field_username)) {
            XM.Z(adVar);
        }
        h hVar = new h();
        hVar.username = adVar.field_username;
        hVar.frW = uqVar.vXm;
        hVar.frV = uqVar.vXn;
        hVar.dtR = 3;
        hVar.cB(false);
        hVar.bJt = -1;
        o.act().b(hVar);
        ArrayList arrayList = new ArrayList();
        while (i < uqVar.vEh.size()) {
            if (((baz) uqVar.vEh.get(i)).wFJ == 0) {
                ap apVar;
                ad aoO = XM.aoO(aa.a(((baz) uqVar.vEh.get(i)).wcG));
                if (((int) aoO.ewQ) != 0) {
                    aoO.NA();
                    XM.b(aoO.field_username, aoO);
                    apVar = aoO;
                } else {
                    apVar = n.a(aoO, (baz) uqVar.vEh.get(i));
                    XM.Z(apVar);
                }
                arrayList.add(apVar.field_username);
            }
            i++;
        }
        if (!arrayList.contains(r.Yz())) {
            arrayList.add(r.Yz());
            ab.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + arrayList.contains(r.Yz()));
        }
        boolean a = n.a(adVar.field_username, arrayList, r.Yz());
        AppMethodBeat.o(103918);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103919);
        ab.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        uq uqVar = (uq) this.ehh.fsH.fsP;
        this.cFZ = aa.a(uqVar.vEi);
        int i4 = this.ehh.fsH.vyl;
        this.cFY = uqVar.ehB;
        M(uqVar.vEh);
        if (!bo.isNullOrNil(this.cFZ) && i4 == 0) {
            a(uqVar);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103919);
    }

    private void M(List<baz> list) {
        AppMethodBeat.i(103920);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                i = ((baz) list.get(i2)).wFJ;
                if (i == 0) {
                    this.cGe.add(aa.a(((baz) list.get(i2)).wcG));
                } else if (i == 3) {
                    ab.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((baz) list.get(i2)).wcG);
                    this.ehk.add(aa.a(((baz) list.get(i2)).wcG));
                } else if (i == 1) {
                    ab.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((baz) list.get(i2)).wcG);
                    this.cGc.add(aa.a(((baz) list.get(i2)).wcG));
                } else if (i == 2) {
                    ab.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((baz) list.get(i2)).wcG);
                    this.cGa.add(aa.a(((baz) list.get(i2)).wcG));
                } else if (i == 4) {
                    ab.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((baz) list.get(i2)).wcG);
                    this.cGd.add(aa.a(((baz) list.get(i2)).wcG));
                } else if (!(i == 5 || i == 6)) {
                    ab.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(i)));
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(103920);
                return;
            }
        }
    }

    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        AppMethodBeat.i(103921);
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            cVar.chatroomName = this.cFZ;
            cVar.cGa = this.cGa;
            cVar.cEX = this.cFY;
            cVar.cFX = this.cGe;
            cVar.ehj = this.cGe;
            cVar.ehk = this.ehk;
            cVar.cGc = this.cGc;
            cVar.ehl = new LinkedList();
            cVar.cGd = this.cGd;
            AppMethodBeat.o(103921);
            return cVar;
        }
        AppMethodBeat.o(103921);
        return aVar;
    }
}
