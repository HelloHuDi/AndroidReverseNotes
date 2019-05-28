package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.apc;
import com.tencent.p177mm.protocal.protobuf.apd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.setting.model.e */
public final class C39648e extends C1207m implements C1918k {
    private C1202f ehi;

    public final int getType() {
        return 869;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126848);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new apc();
        c1196a.fsK = new apd();
        c1196a.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
        c1196a.fsI = 869;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        int a = mo4457a(c1902e, c1196a.acD(), this);
        AppMethodBeat.m2505o(126848);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126847);
        this.fth = i;
        if (!(i2 == 0 && i3 == 0)) {
            C4990ab.m7413e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(126847);
    }
}
