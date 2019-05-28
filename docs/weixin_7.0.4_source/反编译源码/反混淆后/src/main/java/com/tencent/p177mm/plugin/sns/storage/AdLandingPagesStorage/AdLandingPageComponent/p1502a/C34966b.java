package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p1502a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.abb;
import com.tencent.p177mm.protocal.protobuf.abc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b */
public final class C34966b extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String rdB = "";

    public C34966b(String str) {
        AppMethodBeat.m2504i(37658);
        this.rdB = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new abb();
        c1196a.fsK = new abc();
        c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
        c1196a.fsI = 2874;
        this.ehh = c1196a.acD();
        ((abb) this.ehh.fsG.fsP).wio = str;
        C4990ab.m7417i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", str);
        AppMethodBeat.m2505o(37658);
    }

    public final int getType() {
        return 2874;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(37659);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(37659);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(37660);
        C4990ab.m7416i("MicroMsg.NetSceneFavOfficialItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(37660);
    }
}
