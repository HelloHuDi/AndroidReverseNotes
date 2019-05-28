package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C23449up;
import com.tencent.p177mm.protocal.protobuf.C23450uq;
import com.tencent.p177mm.protocal.protobuf.bay;
import com.tencent.p177mm.protocal.protobuf.baz;
import com.tencent.p177mm.roomsdk.p1086a.C15409a;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44205c;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.c.g */
public final class C32438g extends C15409a implements C1918k {
    public int cFY = 0;
    public String cFZ;
    public final List<String> cGa;
    public final List<String> cGc;
    public List<String> cGd;
    public List<String> cGe;
    private final C7472b ehh;
    private C1202f ehi;
    public final List<String> ehk;

    public C32438g(String str, List<String> list) {
        AppMethodBeat.m2504i(103916);
        C4990ab.m7410d("MicroMsg.NetSceneCreateChatRoom", "topic : " + str + " size : " + list.size() + " username : " + ((String) list.get(0)));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23449up();
        c1196a.fsK = new C23450uq();
        c1196a.uri = "/cgi-bin/micromsg-bin/createchatroom";
        c1196a.fsI = C31128d.MIC_AVROUND_BLUR;
        c1196a.fsL = 37;
        c1196a.fsM = 1000000037;
        this.ehh = c1196a.acD();
        C23449up c23449up = (C23449up) this.ehh.fsG.fsP;
        c23449up.wcc = C1946aa.m4154vy(str);
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            bay bay = new bay();
            bay.wcG = C1946aa.m4154vy(str2);
            linkedList.add(bay);
        }
        c23449up.vEh = linkedList;
        c23449up.ehB = linkedList.size();
        this.cGa = new LinkedList();
        this.ehk = new LinkedList();
        this.cGc = new LinkedList();
        this.cGd = new LinkedList();
        this.cGe = new LinkedList();
        this.cFZ = "";
        AppMethodBeat.m2505o(103916);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103917);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103917);
        return a;
    }

    public final int getType() {
        return C31128d.MIC_AVROUND_BLUR;
    }

    /* renamed from: a */
    private static boolean m53102a(C23450uq c23450uq) {
        int i = 0;
        AppMethodBeat.m2504i(103918);
        if (!C1946aa.m4148a(c23450uq.vEi).toLowerCase().endsWith("@chatroom") || c23450uq.ehB == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + c23450uq.vEi + "] listCnt:" + c23450uq.ehB);
            AppMethodBeat.m2505o(103918);
            return false;
        }
        C7616ad c7616ad = new C7616ad();
        c7616ad.mo14703iB(C1946aa.m4148a(c23450uq.wcc));
        c7616ad.mo14704iC(C1946aa.m4148a(c23450uq.wce));
        c7616ad.mo14705iD(C1946aa.m4148a(c23450uq.wcf));
        c7616ad.setUsername(C1946aa.m4148a(c23450uq.vEi));
        C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
        if (!XM.aoQ(c7616ad.field_username)) {
            XM.mo15702Z(c7616ad);
        }
        C17880h c17880h = new C17880h();
        c17880h.username = c7616ad.field_username;
        c17880h.frW = c23450uq.vXm;
        c17880h.frV = c23450uq.vXn;
        c17880h.dtR = 3;
        c17880h.mo33385cB(false);
        c17880h.bJt = -1;
        C17884o.act().mo33391b(c17880h);
        ArrayList arrayList = new ArrayList();
        while (i < c23450uq.vEh.size()) {
            if (((baz) c23450uq.vEh.get(i)).wFJ == 0) {
                C6562ap c6562ap;
                C7616ad aoO = XM.aoO(C1946aa.m4148a(((baz) c23450uq.vEh.get(i)).wcG));
                if (((int) aoO.ewQ) != 0) {
                    aoO.mo16675NA();
                    XM.mo15724b(aoO.field_username, aoO);
                    c6562ap = aoO;
                } else {
                    c6562ap = C37921n.m64047a(aoO, (baz) c23450uq.vEh.get(i));
                    XM.mo15702Z(c6562ap);
                }
                arrayList.add(c6562ap.field_username);
            }
            i++;
        }
        if (!arrayList.contains(C1853r.m3846Yz())) {
            arrayList.add(C1853r.m3846Yz());
            C4990ab.m7410d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + arrayList.contains(C1853r.m3846Yz()));
        }
        boolean a = C37921n.m64055a(c7616ad.field_username, arrayList, C1853r.m3846Yz());
        AppMethodBeat.m2505o(103918);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103919);
        C4990ab.m7410d("MicroMsg.NetSceneCreateChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        C23450uq c23450uq = (C23450uq) this.ehh.fsH.fsP;
        this.cFZ = C1946aa.m4148a(c23450uq.vEi);
        int i4 = this.ehh.fsH.vyl;
        this.cFY = c23450uq.ehB;
        m53101M(c23450uq.vEh);
        if (!C5046bo.isNullOrNil(this.cFZ) && i4 == 0) {
            C32438g.m53102a(c23450uq);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103919);
    }

    /* renamed from: M */
    private void m53101M(List<baz> list) {
        AppMethodBeat.m2504i(103920);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                i = ((baz) list.get(i2)).wFJ;
                if (i == 0) {
                    this.cGe.add(C1946aa.m4148a(((baz) list.get(i2)).wcG));
                } else if (i == 3) {
                    C4990ab.m7410d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((baz) list.get(i2)).wcG);
                    this.ehk.add(C1946aa.m4148a(((baz) list.get(i2)).wcG));
                } else if (i == 1) {
                    C4990ab.m7410d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((baz) list.get(i2)).wcG);
                    this.cGc.add(C1946aa.m4148a(((baz) list.get(i2)).wcG));
                } else if (i == 2) {
                    C4990ab.m7410d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((baz) list.get(i2)).wcG);
                    this.cGa.add(C1946aa.m4148a(((baz) list.get(i2)).wcG));
                } else if (i == 4) {
                    C4990ab.m7410d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((baz) list.get(i2)).wcG);
                    this.cGd.add(C1946aa.m4148a(((baz) list.get(i2)).wcG));
                } else if (!(i == 5 || i == 6)) {
                    C4990ab.m7420w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(i)));
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(103920);
                return;
            }
        }
    }

    /* renamed from: a */
    public final C46609a mo27452a(C46609a c46609a) {
        AppMethodBeat.m2504i(103921);
        if (c46609a instanceof C44205c) {
            C44205c c44205c = (C44205c) c46609a;
            c44205c.chatroomName = this.cFZ;
            c44205c.cGa = this.cGa;
            c44205c.cEX = this.cFY;
            c44205c.cFX = this.cGe;
            c44205c.ehj = this.cGe;
            c44205c.ehk = this.ehk;
            c44205c.cGc = this.cGc;
            c44205c.ehl = new LinkedList();
            c44205c.cGd = this.cGd;
            AppMethodBeat.m2505o(103921);
            return c44205c;
        }
        AppMethodBeat.m2505o(103921);
        return c46609a;
    }
}
