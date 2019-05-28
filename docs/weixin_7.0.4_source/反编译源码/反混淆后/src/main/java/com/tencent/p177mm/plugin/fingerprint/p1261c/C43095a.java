package com.tencent.p177mm.plugin.fingerprint.p1261c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.soter.p527b.C35149d;
import com.tencent.p177mm.plugin.soter.p528d.C13720d;
import com.tencent.p177mm.plugin.soter.p528d.C29254e;
import com.tencent.p177mm.plugin.wallet_core.model.C35481v;
import com.tencent.p177mm.protocal.protobuf.ccq;
import com.tencent.p177mm.protocal.protobuf.ccr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fingerprint.c.a */
public final class C43095a extends C35149d implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;
    public String msn = "";
    public boolean mso = false;

    public C43095a(int i) {
        AppMethodBeat.m2504i(41568);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ccq();
        c1196a.fsK = new ccr();
        c1196a.uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
        c1196a.fsI = 1586;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ccq ccq = (ccq) this.ehh.fsG.fsP;
        C29254e cvQ = C13720d.cvQ();
        C4990ab.m7417i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", cvQ.rOh, cvQ.jSY);
        ccq.rOh = r2;
        ccq.jSY = r1;
        ccq.scene = 0;
        ccq.xbY = i;
        ccq.xbZ = 1;
        AppMethodBeat.m2505o(41568);
    }

    public final int getType() {
        return 1586;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41569);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41569);
        return a;
    }

    /* renamed from: d */
    public final void mo55792d(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41570);
        C4990ab.m7411d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            boolean z;
            ccr ccr = (ccr) ((C7472b) c1929q).fsH.fsP;
            this.msn = ccr.msn;
            C35481v.tCn.msn = this.msn;
            this.mso = 1 == ccr.xca;
            String str2 = "MicroMsg.NetSceneSoterGetPayChallenge";
            String str3 = "get pay challenge needChangeAuthKey: %b";
            Object[] objArr = new Object[1];
            if (1 == ccr.xca) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7411d(str2, str3, objArr);
            C35481v.tCn.mso = this.mso;
            C4990ab.m7417i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", this.msn, Boolean.valueOf(this.mso));
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(41570);
    }

    public final void bxO() {
        AppMethodBeat.m2504i(41571);
        C4990ab.m7412e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.m2505o(41571);
    }

    /* renamed from: vL */
    public final void mo55793vL(int i) {
        AppMethodBeat.m2504i(41572);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.m2505o(41572);
    }
}
