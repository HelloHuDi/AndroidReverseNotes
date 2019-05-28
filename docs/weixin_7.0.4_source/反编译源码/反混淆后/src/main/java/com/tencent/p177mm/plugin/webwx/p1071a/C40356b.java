package com.tencent.p177mm.plugin.webwx.p1071a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15403zg;
import com.tencent.p177mm.protocal.protobuf.C7560zh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webwx.a.b */
public final class C40356b extends C1207m implements C1918k {
    public int czE;
    private C1202f ehi;
    private final C7472b fAT;

    public C40356b(int i) {
        AppMethodBeat.m2504i(26494);
        this.czE = i;
        C1196a c1196a = new C1196a();
        C15403zg c15403zg = new C15403zg();
        C7560zh c7560zh = new C7560zh();
        c1196a.fsJ = c15403zg;
        c1196a.fsK = c7560zh;
        c1196a.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
        c15403zg.nbk = i;
        c15403zg.weF = 1;
        this.fAT = c1196a.acD();
        AppMethodBeat.m2505o(26494);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26495);
        C4990ab.m7410d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(26495);
    }

    public final int getType() {
        return 792;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26496);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(26496);
        return a;
    }
}
