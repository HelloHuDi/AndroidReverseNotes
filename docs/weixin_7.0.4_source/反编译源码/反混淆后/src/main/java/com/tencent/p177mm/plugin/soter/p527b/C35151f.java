package com.tencent.p177mm.plugin.soter.p527b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38269bc;
import com.tencent.p177mm.protocal.protobuf.ckb;
import com.tencent.p177mm.protocal.protobuf.ckc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C30958e;
import com.tencent.soter.p663a.p1108f.C30958e.C16168a;
import com.tencent.soter.p663a.p1108f.C30958e.C30959b;

/* renamed from: com.tencent.mm.plugin.soter.b.f */
public final class C35151f extends C1207m implements C1918k, C30958e {
    private C7472b ehh;
    private C1202f ehi;
    private C24291b<C30959b> msq = null;

    /* renamed from: bR */
    public final /* synthetic */ void mo55795bR(Object obj) {
        AppMethodBeat.m2504i(59313);
        C16168a c16168a = (C16168a) obj;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ckb();
        c1196a.fsK = new ckc();
        c1196a.uri = "/cgi-bin/micromsg-bin/updatesoterask";
        c1196a.fsI = C38269bc.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ckb ckb = (ckb) this.ehh.fsG.fsP;
        ckb.Scene = C38269bc.CTRL_INDEX;
        ckb.xil = c16168a.Awa;
        ckb.xim = c16168a.AvZ;
        C4990ab.m7417i("MicroMsg.NetSceneUploadSoterASK", "alvinluo keyJson: %s, signature: %s", c16168a.AvZ, c16168a.Awa);
        C4990ab.m7419v("MicroMsg.NetSceneUploadSoterASK", "alvinluo hashCode: %s", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(59313);
    }

    public final int getType() {
        return C38269bc.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(59310);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(59310);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(59311);
        C4990ab.m7417i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
            if (this.msq != null) {
                this.msq.mo40382dd(new C30959b(true));
                AppMethodBeat.m2505o(59311);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
        if (this.msq != null) {
            this.msq.mo40382dd(new C30959b(false));
        }
        AppMethodBeat.m2505o(59311);
    }

    /* renamed from: a */
    public final void mo55794a(C24291b<C30959b> c24291b) {
        this.msq = c24291b;
    }

    public final void execute() {
        AppMethodBeat.m2504i(59312);
        C4990ab.m7418v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
        C1720g.m3540Rg().mo14541a((C1207m) this, 0);
        AppMethodBeat.m2505o(59312);
    }
}
