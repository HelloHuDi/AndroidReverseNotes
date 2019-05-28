package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44110cq;
import com.tencent.p177mm.protocal.protobuf.C44111cr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.openim.b.b */
public final class C45464b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String geZ;

    public C45464b(String str, String str2) {
        AppMethodBeat.m2504i(78836);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44110cq();
        c1196a.fsK = new C44111cr();
        c1196a.uri = "/cgi-bin/micromsg-bin/addopenimcontact";
        this.ehh = c1196a.acD();
        this.geZ = str;
        C44110cq c44110cq = (C44110cq) this.ehh.fsG.fsP;
        c44110cq.geZ = str;
        c44110cq.vEP = str2;
        C4990ab.m7417i("MicroMsg.Openim.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", str, str2);
        AppMethodBeat.m2505o(78836);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78837);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geZ);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78837);
    }

    public final int getType() {
        return 667;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78838);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78838);
        return a;
    }
}
