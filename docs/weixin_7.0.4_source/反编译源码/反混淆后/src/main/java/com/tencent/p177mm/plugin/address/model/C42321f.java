package com.tencent.p177mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.protocal.protobuf.bpn;
import com.tencent.p177mm.protocal.protobuf.bpo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.address.model.f */
public final class C42321f extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public int gIK = 0;

    public C42321f(int i) {
        AppMethodBeat.m2504i(16737);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bpn();
        c1196a.fsK = new bpo();
        c1196a.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
        c1196a.fsI = 416;
        c1196a.fsL = 201;
        c1196a.fsM = 1000000201;
        this.ehh = c1196a.acD();
        this.gIK = i;
        C4990ab.m7410d("MicroMsg.NetSceneRcptInfoRemove", "remove Id ".concat(String.valueOf(i)));
        ((bpn) this.ehh.fsG.fsP).f16204id = i;
        AppMethodBeat.m2505o(16737);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16738);
        C4990ab.m7410d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpo bpo = (bpo) ((C7472b) c1929q).fsH.fsP;
            if (bpo.wRK.wRN != null) {
                C4990ab.m7410d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + bpo.wRK.wRN.size());
                C33045a.arQ();
                C33045a.arS().mo67844s(bpo.wRK.wRN);
                C33045a.arQ();
                C33045a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16738);
    }

    public final int getType() {
        return 416;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16739);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16739);
        return a;
    }
}
