package com.tencent.p177mm.plugin.topstory.p539a.p1042c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.apu;
import com.tencent.p177mm.protocal.protobuf.apv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.topstory.a.c.d */
public final class C22399d extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C22399d(String str) {
        AppMethodBeat.m2504i(65506);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmsearch-bin/getuserattrbyopenid";
        c1196a.fsJ = new apu();
        c1196a.fsK = new apv();
        this.ehh = c1196a.acD();
        ((apu) this.ehh.fsG.fsP).vGs = str;
        AppMethodBeat.m2505o(65506);
    }

    public final int getType() {
        return 2830;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(65507);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(65507);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(65508);
        C4990ab.m7417i("MicroMsg.TopStory.NetSceneTopStoryGetUsername", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(65508);
    }
}
