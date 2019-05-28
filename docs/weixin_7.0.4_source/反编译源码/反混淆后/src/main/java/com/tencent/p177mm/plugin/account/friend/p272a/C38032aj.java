package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.bwz;
import com.tencent.p177mm.protocal.protobuf.bxa;

/* renamed from: com.tencent.mm.plugin.account.friend.a.aj */
public final class C38032aj extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C38032aj(String str) {
        AppMethodBeat.m2504i(108481);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwz();
        c1196a.fsK = new bxa();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
        this.ehh = c1196a.acD();
        ((bwz) this.ehh.fsG.fsP).wcB = new bts().alV(str);
        AppMethodBeat.m2505o(108481);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108482);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108482);
        return a;
    }

    public final int getType() {
        return 108;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108483);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108483);
    }
}
