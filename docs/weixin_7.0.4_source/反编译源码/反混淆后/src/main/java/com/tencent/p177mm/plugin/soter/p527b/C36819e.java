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
import com.tencent.p177mm.protocal.protobuf.clo;
import com.tencent.p177mm.protocal.protobuf.clp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C30958e;
import com.tencent.soter.p663a.p1108f.C30958e.C16168a;
import com.tencent.soter.p663a.p1108f.C30958e.C30959b;

/* renamed from: com.tencent.mm.plugin.soter.b.e */
public final class C36819e extends C35149d implements C1918k, C30958e {
    private C7472b ehh;
    private C1202f ehi;
    private C24291b<C30959b> msq = null;

    /* renamed from: bR */
    public final /* synthetic */ void mo55795bR(Object obj) {
        AppMethodBeat.m2504i(59309);
        C16168a c16168a = (C16168a) obj;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clo();
        c1196a.fsK = new clp();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/uploadsoterauthkey";
        c1196a.fsI = 1185;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        clo clo = (clo) this.ehh.fsG.fsP;
        clo.xjk = c16168a.AvZ;
        clo.xjl = c16168a.Awa;
        AppMethodBeat.m2505o(59309);
    }

    public final int getType() {
        return 1185;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(59304);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(59304);
        return a;
    }

    /* renamed from: d */
    public final void mo55792d(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(59305);
        C4990ab.m7411d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        if (this.msq != null) {
            if (i == 0 && i2 == 0) {
                this.msq.mo40382dd(new C30959b(true));
                AppMethodBeat.m2505o(59305);
                return;
            }
            this.msq.mo40382dd(new C30959b(false));
        }
        AppMethodBeat.m2505o(59305);
    }

    public final void bxO() {
        AppMethodBeat.m2504i(59306);
        C4990ab.m7416i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        if (this.msq != null) {
            this.msq.mo40382dd(new C30959b(false));
        }
        AppMethodBeat.m2505o(59306);
    }

    /* renamed from: vL */
    public final void mo55793vL(int i) {
        AppMethodBeat.m2504i(59307);
        C4990ab.m7417i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.m2505o(59307);
    }

    public final void execute() {
        AppMethodBeat.m2504i(59308);
        C1720g.m3540Rg().mo14541a((C1207m) this, 0);
        AppMethodBeat.m2505o(59308);
    }

    /* renamed from: a */
    public final void mo55794a(C24291b<C30959b> c24291b) {
        this.msq = c24291b;
    }
}
