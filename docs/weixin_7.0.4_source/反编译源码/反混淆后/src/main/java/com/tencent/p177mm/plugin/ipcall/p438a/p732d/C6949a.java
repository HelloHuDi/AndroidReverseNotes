package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.blu;
import com.tencent.p177mm.protocal.protobuf.blv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.a */
public final class C6949a extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;
    public blu nyf = null;
    private blv nyg = null;

    public C6949a(int i, long j, String str, String str2, int i2, long j2) {
        AppMethodBeat.m2504i(21836);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new blu();
        c1196a.fsK = new blv();
        c1196a.fsI = 843;
        c1196a.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        long currentTimeMillis = System.currentTimeMillis();
        this.nyf = (blu) this.ehh.fsG.fsP;
        this.nyf.wem = i;
        this.nyf.wen = j;
        this.nyf.ndF = str;
        this.nyf.wOP = currentTimeMillis;
        this.nyf.wOQ = i2;
        this.nyf.wOR = str2;
        this.nyf.wOS = j2;
        C4990ab.m7411d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), str2, Long.valueOf(j2));
        AppMethodBeat.m2505o(21836);
    }

    public final int getType() {
        return 843;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21837);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21837);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21838);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyg = (blv) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21838);
    }
}
