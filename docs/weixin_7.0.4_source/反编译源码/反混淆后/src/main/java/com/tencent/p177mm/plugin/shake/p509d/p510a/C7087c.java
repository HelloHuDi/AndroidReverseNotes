package com.tencent.p177mm.plugin.shake.p509d.p510a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bfq;
import com.tencent.p177mm.protocal.protobuf.bfr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.shake.d.a.c */
public final class C7087c extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C7087c(int i, String str) {
        AppMethodBeat.m2504i(24607);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bfq();
        c1196a.fsK = new bfr();
        c1196a.uri = "/cgi-bin/mmoctv/optvhist";
        this.ehh = c1196a.acD();
        bfq bfq = (bfq) this.ehh.fsG.fsP;
        bfq.nbk = i;
        bfq.wJx = str;
        AppMethodBeat.m2505o(24607);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24608);
        C4990ab.m7417i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24608);
    }

    public final int getType() {
        return 1740;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24609);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(24609);
        return a;
    }
}
