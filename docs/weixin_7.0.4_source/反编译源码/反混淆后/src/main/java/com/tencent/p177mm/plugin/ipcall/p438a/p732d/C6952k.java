package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bmd;
import com.tencent.p177mm.protocal.protobuf.bme;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.k */
public final class C6952k extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;
    public bmd nyA = null;
    public bme nyB = null;

    public C6952k(int i, long j, long j2) {
        AppMethodBeat.m2504i(21866);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bmd();
        c1196a.fsK = new bme();
        c1196a.fsI = 726;
        c1196a.uri = "/cgi-bin/micromsg-bin/pstnredirect";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nyA = (bmd) this.ehh.fsG.fsP;
        this.nyA.wem = i;
        this.nyA.wen = j;
        this.nyA.wOS = j2;
        AppMethodBeat.m2505o(21866);
    }

    public final int getType() {
        return 726;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21867);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21867);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21868);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyB = (bme) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21868);
    }
}
