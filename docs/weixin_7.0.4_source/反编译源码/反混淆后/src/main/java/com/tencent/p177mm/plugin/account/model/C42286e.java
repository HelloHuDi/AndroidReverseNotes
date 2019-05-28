package com.tencent.p177mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.blo;
import com.tencent.p177mm.protocal.protobuf.blp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.account.model.e */
public final class C42286e extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private blo gyM;

    public C42286e(int i, String str) {
        AppMethodBeat.m2504i(124679);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new blo();
        c1196a.fsK = new blp();
        c1196a.fsI = C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI;
        c1196a.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
        this.gme = c1196a.acD();
        this.gyM = (blo) this.gme.fsG.fsP;
        this.gyM.wOC = i;
        this.gyM.guW = str;
        AppMethodBeat.m2505o(124679);
    }

    public final int getType() {
        return C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(124680);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(124680);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(124681);
        C4990ab.m7417i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(124681);
    }
}
