package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bnx;
import com.tencent.p177mm.protocal.protobuf.bny;

/* renamed from: com.tencent.mm.modelsimple.r */
public final class C9706r extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public int fPr = 1;
    public int fPs;

    public C9706r(int i) {
        AppMethodBeat.m2504i(123457);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bnx();
        c1196a.fsK = new bny();
        c1196a.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
        c1196a.fsI = 255;
        c1196a.fsL = 132;
        c1196a.fsM = 1000000132;
        this.ehh = c1196a.acD();
        ((bnx) this.ehh.fsG.fsP).Scene = i;
        this.fPs = i;
        AppMethodBeat.m2505o(123457);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(123458);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(123458);
        return a;
    }

    public final int getType() {
        return 255;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(123459);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(123459);
    }
}
