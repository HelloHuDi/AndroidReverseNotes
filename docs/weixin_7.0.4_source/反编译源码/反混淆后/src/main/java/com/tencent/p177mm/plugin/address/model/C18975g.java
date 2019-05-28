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
import com.tencent.p177mm.protocal.protobuf.bpp;
import com.tencent.p177mm.protocal.protobuf.bpq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.address.model.g */
public final class C18975g extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C18975g(int i) {
        AppMethodBeat.m2504i(16740);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bpp();
        c1196a.fsK = new bpq();
        c1196a.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
        this.ehh = c1196a.acD();
        ((bpp) this.ehh.fsG.fsP).f4414id = i;
        AppMethodBeat.m2505o(16740);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16741);
        C4990ab.m7410d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpq bpq = (bpq) ((C7472b) c1929q).fsH.fsP;
            if (bpq.wRK.wRN != null) {
                C4990ab.m7410d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + bpq.wRK.wRN.size());
                C33045a.arQ();
                C33045a.arS().mo67844s(bpq.wRK.wRN);
                C33045a.arQ();
                C33045a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16741);
    }

    public final int getType() {
        return 419;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16742);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16742);
        return a;
    }
}
