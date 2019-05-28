package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.openim.room.p266a.C18742b.C1938c;
import com.tencent.p177mm.openim.room.p266a.C18742b.C9778b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.plugin.chatroom.p721a.C33811b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C44176ut;
import com.tencent.p177mm.protocal.protobuf.C44177uu;
import com.tencent.p177mm.protocal.protobuf.bgc;
import com.tencent.p177mm.protocal.protobuf.bgd;
import com.tencent.p177mm.roomsdk.p1086a.C15409a;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44205c;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.openim.b.c */
public final class C16542c extends C15409a implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C16542c(LinkedList<bgc> linkedList) {
        AppMethodBeat.m2504i(78839);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44176ut();
        c1196a.fsK = new C44177uu();
        c1196a.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
        this.ehh = c1196a.acD();
        ((C44176ut) this.ehh.fsG.fsP).vEN = linkedList;
        C4990ab.m7417i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(78839);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78840);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (c1929q.mo5618ZS().vyl == 0) {
            C44177uu c44177uu = (C44177uu) ((C7472b) c1929q).fsH.fsP;
            if (!C5046bo.isNullOrNil(c44177uu.gfa)) {
                if (c44177uu.gfa.toLowerCase().endsWith("@im.chatroom")) {
                    C7616ad c7616ad = new C7616ad();
                    c7616ad.setUsername(c44177uu.gfa);
                    C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
                    if (!XM.aoQ(c7616ad.field_username)) {
                        XM.mo15702Z(c7616ad);
                    }
                    if (!(C5046bo.isNullOrNil(c7616ad.field_username) || C5046bo.isNullOrNil(c44177uu.wck))) {
                        C17880h c17880h = new C17880h();
                        c17880h.username = c7616ad.field_username;
                        c17880h.frW = c44177uu.wcj;
                        c17880h.frV = c44177uu.wck;
                        c17880h.dtR = 3;
                        c17880h.mo33385cB(false);
                        c17880h.bJt = -1;
                        C17884o.act().mo33391b(c17880h);
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it = c44177uu.vEN.iterator();
                    while (it.hasNext()) {
                        bgd bgd = (bgd) it.next();
                        if (bgd.status == 0) {
                            C6562ap c6562ap;
                            C6562ap aoO = XM.aoO(bgd.userName);
                            if (((int) aoO.ewQ) != 0) {
                                aoO.mo16675NA();
                                XM.mo15724b(aoO.field_username, (C7616ad) aoO);
                                c6562ap = aoO;
                            } else {
                                c6562ap = C1938c.m4137a(aoO, bgd);
                                XM.mo15702Z(c6562ap);
                            }
                            arrayList.add(c6562ap.field_username);
                        }
                    }
                    if (!arrayList.contains(C1853r.m3846Yz())) {
                        arrayList.add(C1853r.m3846Yz());
                        C4990ab.m7410d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + arrayList.contains(C1853r.m3846Yz()));
                    }
                    ((C33811b) C1720g.m3528K(C33811b.class)).mo54367a(c7616ad.field_username, arrayList, C1853r.m3846Yz());
                } else {
                    C4990ab.m7412e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + c44177uu.gfa + "]");
                }
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78840);
    }

    public final int getType() {
        return 371;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78841);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78841);
        return a;
    }

    /* renamed from: a */
    public final C46609a mo27452a(C46609a c46609a) {
        AppMethodBeat.m2504i(78842);
        if (c46609a != null && (c46609a instanceof C44205c)) {
            C44177uu c44177uu = (C44177uu) this.ehh.fsH.fsP;
            if (c44177uu != null) {
                C9778b c9778b = new C9778b();
                c9778b.mo21130q(c44177uu.vEN);
                C44205c c44205c = (C44205c) c46609a;
                c44205c.chatroomName = c44177uu.gfa;
                c44205c.cEX = c9778b.ehj.size();
                c44205c.cFX = c9778b.ehj;
                c44205c.ehj = c9778b.ehj;
                c44205c.cGa = c9778b.cGa;
                c44205c.ehk = c9778b.ehk;
                c44205c.cGc = c9778b.cGc;
                c44205c.ehl = c9778b.ehl;
                c44205c.cGd = c9778b.cGd;
                AppMethodBeat.m2505o(78842);
                return c44205c;
            }
        }
        AppMethodBeat.m2505o(78842);
        return c46609a;
    }
}
