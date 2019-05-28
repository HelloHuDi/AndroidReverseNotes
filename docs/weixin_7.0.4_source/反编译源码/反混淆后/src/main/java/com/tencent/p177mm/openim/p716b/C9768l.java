package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.bgt;
import com.tencent.p177mm.protocal.protobuf.bgu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.openim.b.l */
public final class C9768l extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public C3463b gfe;
    private int opType;

    public C9768l(C3463b c3463b) {
        AppMethodBeat.m2504i(1008);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bgt();
        c1196a.fsK = new bgu();
        c1196a.uri = "/cgi-bin/micromsg-bin/openimoplog";
        this.ehh = c1196a.acD();
        this.opType = c3463b.oqP;
        this.gfe = c3463b;
        C4990ab.m7417i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", Integer.valueOf(this.opType));
        bgt bgt = (bgt) this.ehh.fsG.fsP;
        bgt.type = this.opType;
        bgt.wKq = new C1332b(c3463b.getBuffer());
        AppMethodBeat.m2505o(1008);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(1009);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(1009);
        return a;
    }

    public final int getType() {
        return 806;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(1010);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.opType));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(1010);
    }
}
