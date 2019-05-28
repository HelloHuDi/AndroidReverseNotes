package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aze;
import com.tencent.p177mm.protocal.protobuf.azf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ad */
public final class C14872ad extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C14872ad(int i, String str) {
        AppMethodBeat.m2504i(79381);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aze();
        c1196a.fsK = new azf();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
        this.ehh = c1196a.acD();
        aze aze = (aze) this.ehh.fsG.fsP;
        aze.offset = i;
        aze.limit = 20;
        aze.lang = str;
        C1720g.m3537RQ();
        aze.wCY = String.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue());
        AppMethodBeat.m2505o(79381);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(79382);
        C4990ab.m7411d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(79382);
    }

    public final int getType() {
        return 1060;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(79383);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneGetServiceAppList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(79383);
        return a;
    }
}
