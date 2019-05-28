package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cmv;
import com.tencent.p177mm.protocal.protobuf.cmw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.openim.b.q */
public final class C42240q extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String geZ;
    public String gfi;
    public String gfj;

    public C42240q(String str, String str2) {
        AppMethodBeat.m2504i(78881);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cmv();
        c1196a.fsK = new cmw();
        c1196a.uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
        this.ehh = c1196a.acD();
        this.geZ = str;
        this.gfi = str2;
        cmv cmv = (cmv) this.ehh.fsG.fsP;
        cmv.geZ = str;
        cmv.gfi = str2;
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", str, str2);
        AppMethodBeat.m2505o(78881);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78882);
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geZ);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78882);
    }

    public final int getType() {
        return 853;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78883);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78883);
        return a;
    }
}
