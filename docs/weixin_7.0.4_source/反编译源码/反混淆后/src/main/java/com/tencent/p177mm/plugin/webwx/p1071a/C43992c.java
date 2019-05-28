package com.tencent.p177mm.plugin.webwx.p1071a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C7289zi;
import com.tencent.p177mm.protocal.protobuf.C7561zj;

/* renamed from: com.tencent.mm.plugin.webwx.a.c */
public final class C43992c extends C1207m implements C1918k {
    private C1202f ehi;
    private final C7472b fAT;

    public C43992c(String str) {
        AppMethodBeat.m2504i(26497);
        C1196a c1196a = new C1196a();
        C7289zi c7289zi = new C7289zi();
        C7561zj c7561zj = new C7561zj();
        c1196a.fsJ = c7289zi;
        c1196a.fsK = c7561zj;
        c1196a.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        c7289zi.weG = str;
        this.fAT = c1196a.acD();
        AppMethodBeat.m2505o(26497);
    }

    public final int getType() {
        return 973;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26498);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(26498);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26499);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26499);
    }
}
