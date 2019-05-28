package com.tencent.p177mm.plugin.account.security.p880a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44182vz;
import com.tencent.p177mm.protocal.protobuf.C44183wa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.security.a.a */
public final class C42288a extends C1207m implements C1918k {
    private String ceI;
    private C7472b ehh;
    private C1202f ehi;

    public C42288a(String str) {
        AppMethodBeat.m2504i(69826);
        this.ceI = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44182vz();
        c1196a.fsK = new C44183wa();
        c1196a.uri = "/cgi-bin/micromsg-bin/delsafedevice";
        this.ehh = c1196a.acD();
        ((C44182vz) this.ehh.fsG.fsP).wcI = str;
        AppMethodBeat.m2505o(69826);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(69827);
        C4990ab.m7410d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            C44183wa c44183wa = (C44183wa) this.ehh.fsH.fsP;
            C1720g.m3536RP().mo5239Ry().set(64, Integer.valueOf(c44183wa.vCl));
            C4990ab.m7410d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + c44183wa.vCl);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(69827);
    }

    public final int getType() {
        return 362;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(69828);
        if (C5046bo.isNullOrNil(this.ceI)) {
            C4990ab.m7412e("MicroMsg.NetSceneDelSafeDevice", "null device id");
            AppMethodBeat.m2505o(69828);
            return -1;
        }
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(69828);
        return a;
    }
}
