package com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C42005if;
import com.tencent.p177mm.plugin.soter.p527b.C35149d;
import com.tencent.p177mm.protocal.protobuf.cic;
import com.tencent.p177mm.protocal.protobuf.cid;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C30958e;
import com.tencent.soter.p663a.p1108f.C30958e.C16168a;
import com.tencent.soter.p663a.p1108f.C30958e.C30959b;

/* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.g */
public final class C46390g extends C35149d implements C1918k, C30958e {
    public C7472b ehh;
    private C1202f ehi;
    private String gHr = null;
    private C24291b<C30959b> msq = null;

    /* renamed from: bR */
    public final /* synthetic */ void mo55795bR(Object obj) {
        AppMethodBeat.m2504i(51489);
        C16168a c16168a = (C16168a) obj;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cic();
        c1196a.fsK = new cid();
        c1196a.uri = "/cgi-bin/mmpay-bin/touchlockupdateauthkey";
        c1196a.fsI = 1244;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cic cic = (cic) this.ehh.fsG.fsP;
        cic.xcc = c16168a.AvZ;
        cic.xcd = c16168a.Awa;
        cic.xcb = this.gHr;
        C42005if c42005if = new C42005if();
        c42005if.cDl.cDn = this.gHr;
        C4879a.xxA.mo10055m(c42005if);
        cic.cDo = c42005if.cDm.cDo;
        C4990ab.m7419v("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo wcpaysign: %s", cic.cDo);
        AppMethodBeat.m2505o(51489);
    }

    public C46390g(String str) {
        this.gHr = str;
    }

    public final int getType() {
        return 1665;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(51484);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(51484);
        return a;
    }

    /* renamed from: d */
    public final void mo55792d(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(51485);
        C4990ab.m7411d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        if (this.msq != null) {
            if (i == 0 && i2 == 0) {
                this.msq.mo40382dd(new C30959b(true));
                AppMethodBeat.m2505o(51485);
                return;
            }
            this.msq.mo40382dd(new C30959b(false));
        }
        AppMethodBeat.m2505o(51485);
    }

    public final void bxO() {
        AppMethodBeat.m2504i(51486);
        C4990ab.m7416i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        if (this.msq != null) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
            this.msq.mo40382dd(new C30959b(false));
        }
        AppMethodBeat.m2505o(51486);
    }

    /* renamed from: vL */
    public final void mo55793vL(int i) {
        AppMethodBeat.m2504i(51487);
        C4990ab.m7417i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.m2505o(51487);
    }

    public final void execute() {
        AppMethodBeat.m2504i(51488);
        C1720g.m3540Rg().mo14541a((C1207m) this, 0);
        AppMethodBeat.m2505o(51488);
    }

    /* renamed from: a */
    public final void mo55794a(C24291b<C30959b> c24291b) {
        this.msq = c24291b;
    }
}
