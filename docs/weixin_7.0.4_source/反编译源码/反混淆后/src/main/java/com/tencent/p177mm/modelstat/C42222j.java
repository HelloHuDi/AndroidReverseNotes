package com.tencent.p177mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.ain;
import com.tencent.p177mm.protocal.protobuf.aio;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelstat.j */
public final class C42222j extends C1207m implements C1918k {
    private C1202f eIc;
    final C7472b fSY;

    public C42222j(C1332b c1332b) {
        AppMethodBeat.m2504i(78737);
        C1196a c1196a = new C1196a();
        ain ain = new ain();
        ain.woy = c1332b;
        c1196a.fsJ = ain;
        c1196a.fsK = new aio();
        c1196a.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
        c1196a.fsI = 1126;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fSY = c1196a.acD();
        AppMethodBeat.m2505o(78737);
    }

    public final int getType() {
        return 1126;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78738);
        C4990ab.m7416i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
        this.ftk = true;
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.fSY, this);
        AppMethodBeat.m2505o(78738);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78739);
        C4990ab.m7417i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", Integer.valueOf(i2), Integer.valueOf(i3), str, c1929q.toString());
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78739);
    }
}
