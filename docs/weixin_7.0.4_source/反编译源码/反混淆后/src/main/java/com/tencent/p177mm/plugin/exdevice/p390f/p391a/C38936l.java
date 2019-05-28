package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ayg;
import com.tencent.p177mm.protocal.protobuf.ayh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.l */
public final class C38936l extends C1207m implements C1918k {
    public int cKJ;
    private C7472b ehh = null;
    private C1202f ehi = null;
    public String fhH;
    public String lvL;

    public C38936l(String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(19466);
        this.lvL = str3;
        this.fhH = str2;
        this.cKJ = i;
        this.lvL = str3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ayg();
        c1196a.fsK = new ayh();
        c1196a.uri = "/cgi-bin/mmbiz-bin/rank/addlike";
        c1196a.fsI = 1041;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ayg ayg = (ayg) this.ehh.fsG.fsP;
        ayg.lCH = str2;
        ayg.username = str;
        ayg.cKJ = i;
        ayg.fha = str3;
        AppMethodBeat.m2505o(19466);
    }

    public final int getType() {
        return 1041;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19467);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19467);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19468);
        C4990ab.m7411d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19468);
    }
}
