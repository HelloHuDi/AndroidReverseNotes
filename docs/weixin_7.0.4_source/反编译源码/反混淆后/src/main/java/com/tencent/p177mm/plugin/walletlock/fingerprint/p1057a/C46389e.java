package com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cia;
import com.tencent.p177mm.protocal.protobuf.cib;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.e */
public final class C46389e extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    String msn;
    boolean tVh = false;

    public C46389e(String str, String str2) {
        AppMethodBeat.m2504i(51478);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cia();
        c1196a.fsK = new cib();
        c1196a.uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
        c1196a.fsI = 1548;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cia cia = (cia) this.ehh.fsG.fsP;
        cia.scene = 1548;
        cia.rOh = str;
        cia.jSY = str2;
        AppMethodBeat.m2505o(51478);
    }

    public final int getType() {
        return 1548;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(51479);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(51479);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(51480);
        C4990ab.m7417i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        cib cib = (cib) ((C7472b) c1929q).fsH.fsP;
        this.msn = cib.msn;
        C4990ab.m7411d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", this.msn);
        if (cib.xca == 1) {
            this.tVh = true;
        } else {
            this.tVh = false;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(51480);
    }
}
