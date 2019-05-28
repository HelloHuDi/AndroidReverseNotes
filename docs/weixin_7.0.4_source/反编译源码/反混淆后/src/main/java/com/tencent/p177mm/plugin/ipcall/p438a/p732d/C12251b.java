package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.blw;
import com.tencent.p177mm.protocal.protobuf.blx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.b */
public final class C12251b extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi;
    private blw nyh = null;
    public blx nyi = null;

    public C12251b(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.m2504i(21839);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new blw();
        c1196a.fsK = new blx();
        c1196a.fsI = 807;
        c1196a.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nyh = (blw) this.ehh.fsG.fsP;
        this.nyh.wOT = str;
        this.nyh.wOV = str2;
        this.nyh.wOX = str3;
        this.nyh.wOW = str4;
        this.nyh.wOY = i;
        C4990ab.m7417i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", str, str2, str3, str4, Integer.valueOf(i));
        AppMethodBeat.m2505o(21839);
    }

    public final int getType() {
        return 807;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21840);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21840);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21841);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyi = (blx) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21841);
    }
}
