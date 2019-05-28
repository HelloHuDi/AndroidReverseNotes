package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aqj;
import com.tencent.p177mm.protocal.protobuf.aqk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.d */
public final class C34370d extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi;
    private aqj nyl = null;
    public aqk nym = null;

    public C34370d() {
        AppMethodBeat.m2504i(21845);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aqj();
        c1196a.fsK = new aqk();
        c1196a.fsI = C31128d.MIC_PTU_YOUJIALI;
        c1196a.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nyl = (aqj) this.ehh.fsG.fsP;
        C4990ab.m7416i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
        AppMethodBeat.m2505o(21845);
    }

    public final int getType() {
        return C31128d.MIC_PTU_YOUJIALI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21846);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21846);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21847);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nym = (aqk) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21847);
    }
}
