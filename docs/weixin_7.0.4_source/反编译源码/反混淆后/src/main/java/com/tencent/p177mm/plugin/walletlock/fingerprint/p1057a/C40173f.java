package com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bhe;
import com.tencent.p177mm.protocal.protobuf.bhf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.f */
public final class C40173f extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public final int getType() {
        return 1967;
    }

    public C40173f(String str, String str2, String str3) {
        AppMethodBeat.m2504i(51481);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bhe();
        c1196a.fsK = new bhf();
        c1196a.uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
        this.ehh = c1196a.acD();
        bhe bhe = (bhe) this.ehh.fsG.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", str, str2, str3);
        bhe.wKv = str;
        bhe.signature = str2;
        bhe.tuu = str3;
        AppMethodBeat.m2505o(51481);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(51482);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(51482);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(51483);
        C4990ab.m7417i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(51483);
    }
}
