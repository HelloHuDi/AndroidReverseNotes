package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C19403g;
import com.tencent.p177mm.protocal.protobuf.ahe;
import com.tencent.p177mm.protocal.protobuf.ahf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.chatroom.c.j */
public final class C6401j extends C1207m implements C1918k {
    public String chatroomName;
    private final C7472b ehh;
    private C1202f ehi = null;
    public String ehr;
    public int ehs;
    public int eht;
    public int status;

    public C6401j(String str) {
        AppMethodBeat.m2504i(103928);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ahe();
        c1196a.fsK = new ahf();
        c1196a.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
        c1196a.fsI = C19403g.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.chatroomName = str;
        ((ahe) this.ehh.fsG.fsP).vEf = str;
        AppMethodBeat.m2505o(103928);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103929);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103929);
        return a;
    }

    public final int getType() {
        return C19403g.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103930);
        ahf ahf = (ahf) this.ehh.fsH.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.status = ahf.jBT;
        this.ehr = ahf.wnK;
        this.eht = ahf.wnL;
        this.ehr = ahf.wnK;
        this.ehs = ahf.wnJ;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103930);
    }
}
