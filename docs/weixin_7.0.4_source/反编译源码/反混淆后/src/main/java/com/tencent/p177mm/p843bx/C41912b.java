package com.tencent.p177mm.p843bx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bsb;
import com.tencent.p177mm.protocal.protobuf.bsc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.bx.b */
public final class C41912b extends C1207m implements C1918k {
    private C1202f ehi;
    private final C7472b fsB;

    public C41912b(bsb bsb) {
        AppMethodBeat.m2504i(116353);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bsb();
        c1196a.fsK = new bsc();
        c1196a.uri = "/cgi-bin/micromsg-bin/reportmediainfo";
        this.fsB = c1196a.acD();
        bsb bsb2 = (bsb) this.fsB.fsG.fsP;
        bsb2.wUf = bsb.wUf;
        bsb2.wUe = bsb.wUe;
        bsb2.wdK = bsb.wdK;
        bsb2.EmotionList.addAll(bsb.EmotionList);
        bsb2.jCt = bsb.jCt;
        AppMethodBeat.m2505o(116353);
    }

    public final int getType() {
        return 809;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(116354);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fsB, this);
        AppMethodBeat.m2505o(116354);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(116355);
        C4990ab.m7417i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(hashCode()));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(116355);
    }
}
