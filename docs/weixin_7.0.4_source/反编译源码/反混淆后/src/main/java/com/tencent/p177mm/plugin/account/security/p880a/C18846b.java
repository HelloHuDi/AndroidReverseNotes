package com.tencent.p177mm.plugin.account.security.p880a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.anv;
import com.tencent.p177mm.protocal.protobuf.anw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.security.a.b */
public final class C18846b extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public anw gzh;

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(69829);
        if (!(i2 == 0 && i3 == 0)) {
            C4990ab.m7413e("MicroMsg.NetSceneGetSafetyInfo", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.gzh = (anw) ((C7472b) c1929q).fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(69829);
    }

    public final int getType() {
        return 850;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(69830);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new anv();
        c1196a.fsK = new anw();
        c1196a.uri = "/cgi-bin/micromsg-bin/getsafetyinfo";
        c1196a.fsI = 850;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(69830);
        return a;
    }
}
