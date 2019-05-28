package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.openim.room.p266a.C18742b.C1938c;
import com.tencent.p177mm.openim.room.p266a.C18742b.C9778b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.plugin.chatroom.p721a.C33811b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C23378co;
import com.tencent.p177mm.protocal.protobuf.C44109cp;
import com.tencent.p177mm.protocal.protobuf.bgc;
import com.tencent.p177mm.protocal.protobuf.bgd;
import com.tencent.p177mm.roomsdk.p1086a.C15409a;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44205c;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.openim.b.a */
public final class C37975a extends C15409a implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private String geY;

    public C37975a(String str, LinkedList<bgc> linkedList, String str2) {
        AppMethodBeat.m2504i(78832);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23378co();
        c1196a.fsK = new C44109cp();
        c1196a.uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
        this.ehh = c1196a.acD();
        this.geY = str;
        C23378co c23378co = (C23378co) this.ehh.fsG.fsP;
        c23378co.gfa = str;
        c23378co.vEN = linkedList;
        c23378co.desc = str2;
        C4990ab.m7417i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", str, Integer.valueOf(linkedList.size()), str2);
        AppMethodBeat.m2505o(78832);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78833);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (c1929q.mo5618ZS().vyl == 0) {
            C44109cp c44109cp = (C44109cp) ((C7472b) c1929q).fsH.fsP;
            String str2 = this.geY;
            if (!str2.toLowerCase().endsWith("@im.chatroom") || c44109cp.vEN.isEmpty()) {
                C4990ab.m7412e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + str2 + "] listCnt:" + c44109cp.vEN.size());
            } else {
                ArrayList arrayList = new ArrayList();
                C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
                Iterator it = c44109cp.vEN.iterator();
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
                if (!arrayList.isEmpty()) {
                    ((C33811b) C1720g.m3528K(C33811b.class)).mo54367a(str2, arrayList, null);
                }
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78833);
    }

    public final int getType() {
        return 814;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78834);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78834);
        return a;
    }

    /* renamed from: a */
    public final C46609a mo27452a(C46609a c46609a) {
        AppMethodBeat.m2504i(78835);
        if (c46609a != null && (c46609a instanceof C44205c)) {
            C44109cp c44109cp = (C44109cp) this.ehh.fsH.fsP;
            if (c44109cp != null) {
                C9778b c9778b = new C9778b();
                c9778b.mo21130q(c44109cp.vEN);
                C44205c c44205c = (C44205c) c46609a;
                c44205c.chatroomName = this.geY;
                c44205c.cEX = c9778b.ehj.size();
                c44205c.cFX = c9778b.ehj;
                c44205c.ehj = c9778b.ehj;
                c44205c.cGa = c9778b.cGa;
                c44205c.ehk = c9778b.ehk;
                c44205c.cGc = c9778b.cGc;
                c44205c.ehl = c9778b.ehl;
                c44205c.cGd = c9778b.cGd;
                c44205c.vEO = c44109cp.vEO;
                AppMethodBeat.m2505o(78835);
                return c44205c;
            }
        }
        AppMethodBeat.m2505o(78835);
        return c46609a;
    }
}
