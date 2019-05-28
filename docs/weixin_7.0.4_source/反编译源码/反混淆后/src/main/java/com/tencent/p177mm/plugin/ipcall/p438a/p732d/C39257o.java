package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bmj;
import com.tencent.p177mm.protocal.protobuf.bmk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.o */
public final class C39257o extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi;
    public bmj nyI = null;
    public bmk nyJ = null;

    public C39257o(int i, long j, int i2, long j2, boolean z) {
        AppMethodBeat.m2504i(21878);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bmj();
        c1196a.fsK = new bmk();
        c1196a.fsI = 819;
        c1196a.uri = "/cgi-bin/micromsg-bin/pstnsync";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        long currentTimeMillis = System.currentTimeMillis();
        this.nyI = (bmj) this.ehh.fsG.fsP;
        this.nyI.wPm = C1853r.m3846Yz();
        this.nyI.wem = i;
        this.nyI.wen = j;
        this.nyI.wOP = currentTimeMillis;
        this.nyI.wPn = i2;
        this.nyI.wOS = j2;
        if (z) {
            this.nyI.wPo = 1;
        } else {
            this.nyI.wPo = 0;
        }
        C4990ab.m7417i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(this.nyI.wPo), Long.valueOf(currentTimeMillis));
        AppMethodBeat.m2505o(21878);
    }

    public final int getType() {
        return 819;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21879);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21879);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21880);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyJ = (bmk) ((C7472b) c1929q).fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(21880);
    }
}
