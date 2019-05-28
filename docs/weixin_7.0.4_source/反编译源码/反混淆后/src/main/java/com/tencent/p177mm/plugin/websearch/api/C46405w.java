package com.tencent.p177mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.protocal.protobuf.bsk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.websearch.api.w */
public final class C46405w extends C1207m implements C1918k {
    private C1202f ehi;
    public C7472b fAT;
    private int scene;
    private String tZV;

    public C46405w(bsj bsj) {
        AppMethodBeat.m2504i(124072);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmsearch-bin/searchreport";
        c1196a.fsJ = bsj;
        c1196a.fsK = new bsk();
        this.fAT = c1196a.acD();
        this.scene = bsj.Scene;
        this.tZV = bsj.wUu;
        AppMethodBeat.m2505o(124072);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(124073);
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            C14423an.m22640Il(6);
            C14423an.m22641a(this.scene, 5, i2, i3, this.tZV);
            AppMethodBeat.m2505o(124073);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        C14423an.m22640Il(7);
        AppMethodBeat.m2505o(124073);
    }

    public final int getType() {
        return 1134;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(124074);
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", Integer.valueOf(this.scene));
        C14423an.m22640Il(5);
        C14423an.m22658y(this.scene, 4, this.tZV);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(124074);
        return a;
    }
}
