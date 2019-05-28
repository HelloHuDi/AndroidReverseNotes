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
import com.tencent.p177mm.protocal.protobuf.bmh;
import com.tencent.p177mm.protocal.protobuf.bmi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.n */
public final class C46033n extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;
    public bmh nyG = null;
    private bmi nyH = null;

    public C46033n(int i, long j, long j2, int i2) {
        AppMethodBeat.m2504i(21875);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bmh();
        c1196a.fsK = new bmi();
        c1196a.fsI = 723;
        c1196a.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        long currentTimeMillis = System.currentTimeMillis();
        this.nyG = (bmh) this.ehh.fsG.fsP;
        this.nyG.ndG = C1853r.m3846Yz();
        this.nyG.wem = i;
        this.nyG.wen = j;
        this.nyG.wOS = j2;
        this.nyG.jBT = i2;
        this.nyG.wOP = currentTimeMillis;
        C4990ab.m7417i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
        AppMethodBeat.m2505o(21875);
    }

    public final int getType() {
        return 723;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21876);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21876);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21877);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyH = (bmi) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21877);
    }
}
