package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.btg;
import com.tencent.p177mm.protocal.protobuf.bth;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.chatroom.c.n */
public final class C32440n extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C32440n(String str, String str2) {
        AppMethodBeat.m2504i(103944);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new btg();
        c1196a.fsK = new bth();
        c1196a.uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
        this.ehh = c1196a.acD();
        btg btg = (btg) this.ehh.fsG.fsP;
        btg.wVm = str;
        btg.wVn = str2;
        AppMethodBeat.m2505o(103944);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103945);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103945);
        return a;
    }

    public final int getType() {
        return 700;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103946);
        C4990ab.m7410d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103946);
    }
}
