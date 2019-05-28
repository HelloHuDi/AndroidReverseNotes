package com.tencent.p177mm.plugin.shake.p506c.p507a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15367nj;
import com.tencent.p177mm.protocal.protobuf.C30207nk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.shake.c.a.a */
public final class C39692a extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C39692a(String str, String str2) {
        AppMethodBeat.m2504i(24508);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15367nj();
        c1196a.fsK = new C30207nk();
        c1196a.uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
        this.ehh = c1196a.acD();
        C15367nj c15367nj = (C15367nj) this.ehh.fsG.fsP;
        c15367nj.kbU = str;
        c15367nj.cMD = str2;
        AppMethodBeat.m2505o(24508);
    }

    public final int getType() {
        return 1252;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24509);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(24509);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24510);
        C4990ab.m7416i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = 1252 errType = " + i2 + " errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24510);
    }
}
