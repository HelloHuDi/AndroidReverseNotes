package com.tencent.p177mm.plugin.luckymoney.f2f.p1279a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40595zu;
import com.tencent.p177mm.protocal.protobuf.C46606zt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a.a */
public final class C43253a extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private C46606zt nTX;
    private C40595zu nTY;

    public C43253a(String str) {
        AppMethodBeat.m2504i(42145);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46606zt();
        c1196a.fsK = new C40595zu();
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
        this.gme = c1196a.acD();
        this.nTX = (C46606zt) this.gme.fsG.fsP;
        this.nTX.nSX = str;
        AppMethodBeat.m2505o(42145);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(42146);
        this.nTY = (C40595zu) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(this.nTY.kCl), this.nTY.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, this.nTY.kCl, this.nTY.kCm, this);
        }
        AppMethodBeat.m2505o(42146);
    }

    public final int getType() {
        return 1987;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(42147);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(42147);
        return a;
    }
}
