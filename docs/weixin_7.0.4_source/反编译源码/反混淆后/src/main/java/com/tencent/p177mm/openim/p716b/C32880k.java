package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ava;
import com.tencent.p177mm.protocal.protobuf.avb;
import com.tencent.p177mm.protocal.protobuf.bgc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.openim.b.k */
public final class C32880k extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private String geY;

    public C32880k(String str, LinkedList<bgc> linkedList) {
        AppMethodBeat.m2504i(78865);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ava();
        c1196a.fsK = new avb();
        c1196a.uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
        this.ehh = c1196a.acD();
        this.geY = str;
        ava ava = (ava) this.ehh.fsG.fsP;
        ava.gfa = str;
        ava.vEN = linkedList;
        C4990ab.m7417i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", str, Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(78865);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78866);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78866);
    }

    public final int getType() {
        return 887;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78867);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78867);
        return a;
    }
}
