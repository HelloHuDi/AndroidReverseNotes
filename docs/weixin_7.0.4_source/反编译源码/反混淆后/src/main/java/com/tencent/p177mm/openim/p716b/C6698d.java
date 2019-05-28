package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6663ag;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.chatroom.p721a.C33811b;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.protocal.protobuf.C40582vx;
import com.tencent.p177mm.protocal.protobuf.C46595vw;
import com.tencent.p177mm.protocal.protobuf.bgc;
import com.tencent.p177mm.protocal.protobuf.bgd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7577u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.openim.b.d */
public final class C6698d extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private String geY;

    public C6698d(String str, LinkedList<bgc> linkedList) {
        AppMethodBeat.m2504i(78843);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46595vw();
        c1196a.fsK = new C40582vx();
        c1196a.uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
        this.ehh = c1196a.acD();
        this.geY = str;
        C46595vw c46595vw = (C46595vw) this.ehh.fsG.fsP;
        c46595vw.gfa = str;
        c46595vw.vEN = linkedList;
        C4990ab.m7417i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", str, Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(78843);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78844);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (c1929q.mo5618ZS().vyl == 0) {
            C40582vx c40582vx = (C40582vx) ((C7472b) c1929q).fsH.fsP;
            String str2 = this.geY;
            if (!str2.toLowerCase().endsWith("@im.chatroom") || c40582vx.vEN.isEmpty()) {
                C4990ab.m7412e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + str2 + "] listCnt:" + c40582vx.vEN.size());
            } else {
                C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
                C7577u oa = XV.mo14885oa(str2);
                List aor = C7577u.aor(oa.field_memberlist);
                C4990ab.m7410d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + aor.size());
                Iterator it = c40582vx.vEN.iterator();
                while (it.hasNext()) {
                    aor.remove(((bgd) it.next()).userName);
                }
                C4990ab.m7410d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + aor.size());
                oa.mo16804ep(aor).field_displayname = ((C33811b) C1720g.m3528K(C33811b.class)).mo54365U(aor);
                C4990ab.m7410d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(XV.mo10099a(oa))));
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78844);
    }

    public final int getType() {
        return 943;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78845);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78845);
        return a;
    }
}
