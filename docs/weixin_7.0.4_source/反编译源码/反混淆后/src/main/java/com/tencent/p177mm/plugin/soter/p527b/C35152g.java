package com.tencent.p177mm.plugin.soter.p527b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42466ag;
import com.tencent.p177mm.plugin.soter.p527b.C4101c.C4102a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C30958e;
import com.tencent.soter.p663a.p1108f.C30958e.C16168a;
import com.tencent.soter.p663a.p1108f.C30958e.C30959b;

/* renamed from: com.tencent.mm.plugin.soter.b.g */
public final class C35152g extends C1207m implements C1918k, C30958e {
    private C1202f ehi;
    private C1929q ftU;
    private C24291b<C30959b> msq = null;

    /* renamed from: bR */
    public final /* synthetic */ void mo55795bR(Object obj) {
        AppMethodBeat.m2504i(59317);
        C16168a c16168a = (C16168a) obj;
        this.ftU = new C22153b();
        C4102a c4102a = (C4102a) this.ftU.acF();
        c4102a.rNE.xil = c16168a.Awa;
        c4102a.rNE.xim = c16168a.AvZ;
        AppMethodBeat.m2505o(59317);
    }

    public final int acn() {
        return 3;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int getType() {
        return C42466ag.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(59314);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(59314);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(59315);
        C4990ab.m7417i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
            if (this.msq != null) {
                this.msq.mo40382dd(new C30959b(true));
                AppMethodBeat.m2505o(59315);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
        if (this.msq != null) {
            this.msq.mo40382dd(new C30959b(false));
        }
        AppMethodBeat.m2505o(59315);
    }

    public final void execute() {
        AppMethodBeat.m2504i(59316);
        C4990ab.m7418v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
        C1720g.m3540Rg().mo14541a((C1207m) this, 0);
        AppMethodBeat.m2505o(59316);
    }

    /* renamed from: a */
    public final void mo55794a(C24291b<C30959b> c24291b) {
        this.msq = c24291b;
    }
}
