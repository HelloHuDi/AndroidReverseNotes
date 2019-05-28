package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cvb;
import com.tencent.p177mm.protocal.protobuf.cvc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.a */
public final class C43690a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String nQB;
    private long sAZ = System.currentTimeMillis();

    public C43690a(String str, String str2) {
        AppMethodBeat.m2504i(65503);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2582;
        c1196a.uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
        c1196a.fsJ = new cvb();
        c1196a.fsK = new cvc();
        this.ehh = c1196a.acD();
        cvb cvb = (cvb) this.ehh.fsG.fsP;
        cvb.xra = str2;
        cvb.nQB = str;
        this.nQB = str;
        AppMethodBeat.m2505o(65503);
    }

    public final int getType() {
        return 2582;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(65504);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(65504);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(65505);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(65505);
    }

    public final cvc cFs() {
        return (cvc) this.ehh.fsH.fsP;
    }
}
