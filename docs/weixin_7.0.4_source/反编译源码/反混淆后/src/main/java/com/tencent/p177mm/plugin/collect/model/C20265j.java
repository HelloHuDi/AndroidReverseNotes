package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40554or;
import com.tencent.p177mm.protocal.protobuf.C46572os;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.model.j */
public final class C20265j extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    public C46572os kCi;

    public C20265j() {
        AppMethodBeat.m2504i(40970);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40554or();
        c1196a.fsK = new C46572os();
        c1196a.uri = "/cgi-bin/mmpay-bin/f2fannounce";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        C4990ab.m7410d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
        AppMethodBeat.m2505o(40970);
    }

    public final int getType() {
        return 1256;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40971);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40971);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40972);
        C4990ab.m7417i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.kCi = (C46572os) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40972);
    }
}
