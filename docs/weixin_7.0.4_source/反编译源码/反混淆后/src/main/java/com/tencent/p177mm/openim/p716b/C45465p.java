package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bcg;
import com.tencent.p177mm.protocal.protobuf.bch;
import com.tencent.p177mm.protocal.protobuf.bgc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.openim.b.p */
public final class C45465p extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String username;

    public C45465p(String str, String str2) {
        AppMethodBeat.m2504i(78878);
        C1196a c1196a = new C1196a();
        this.username = str2;
        bcg bcg = new bcg();
        bcg.gfa = str;
        bcg.wGM = new bgc();
        bcg.wGM.userName = str2;
        c1196a.fsJ = bcg;
        c1196a.fsK = new bch();
        c1196a.uri = "/cgi-bin/micromsg-bin/modopenimchatroomowner";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(78878);
    }

    public final int getType() {
        return 811;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78879);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78879);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78880);
        C4990ab.m7421w("MicroMsg.NetSceneTransferOpenImChatRoomOwner", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78880);
    }
}
