package com.tencent.p177mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bwp;
import com.tencent.p177mm.protocal.protobuf.bwq;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.plugin.account.model.f */
public final class C42287f extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;

    public C42287f(bwp bwp) {
        AppMethodBeat.m2504i(124682);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = bwp;
        c1196a.fsK = new bwq();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
        c1196a.fsI = v2helper.EMethodSetSendToNetworkOff;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(124682);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(124683);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(124683);
        return a;
    }

    public final int getType() {
        return v2helper.EMethodSetSendToNetworkOff;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(124684);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(124684);
    }
}
