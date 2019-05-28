package com.tencent.p177mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.azx;
import com.tencent.p177mm.protocal.protobuf.azy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.websearch.api.v */
public final class C40195v extends C1207m implements C1918k {
    public int businessType;
    public int cIv;
    private C1202f ehi;
    private C7472b fAT;
    public String nQB;
    public int scene;
    public azy tZT;
    private int tZU;

    public C40195v(int i, int i2, int i3, int i4, String str, long j, String str2) {
        AppMethodBeat.m2504i(124069);
        this.scene = i;
        this.tZU = i3;
        this.cIv = i4;
        this.businessType = i2;
        this.nQB = str2;
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2));
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmsearch-bin/searchguide";
        c1196a.fsJ = new azx();
        c1196a.fsK = new azy();
        this.fAT = c1196a.acD();
        azx azx = (azx) this.fAT.fsG.fsP;
        azx.Scene = i;
        azx.wDH = i3;
        azx.wDI = C46400aa.abJ();
        azx.wDJ = i2;
        azx.luQ = str;
        azx.wDK = j;
        AppMethodBeat.m2505o(124069);
    }

    public final int getType() {
        return 1048;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(124070);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(124070);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(124071);
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tZT = (azy) this.fAT.fsH.fsP;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(124071);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(124071);
    }
}
