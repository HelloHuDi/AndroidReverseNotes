package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ajx;
import com.tencent.p177mm.protocal.protobuf.ajy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelmulti.d */
public final class C42214d extends C1207m implements C1918k {
    public String content = "";
    private C7472b ehh;
    private C1202f ehi;
    public int fHT = 0;
    public String title = "";

    public C42214d(int i) {
        AppMethodBeat.m2504i(16497);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ajx();
        c1196a.fsK = new ajy();
        c1196a.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
        c1196a.fsI = 1803;
        this.ehh = c1196a.acD();
        ((ajx) this.ehh.fsG.fsP).wpw = i;
        this.fHT = i;
        AppMethodBeat.m2505o(16497);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16498);
        C4990ab.m7410d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ajy ajy = (ajy) this.ehh.fsH.fsP;
            this.title = ajy.wpx;
            this.content = ajy.wpy;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(16498);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16498);
    }

    public final int getType() {
        return 1803;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16499);
        C4990ab.m7410d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16499);
        return a;
    }
}
