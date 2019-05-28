package com.tencent.p177mm.plugin.profile.p1287b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C7249am;
import com.tencent.p177mm.protocal.protobuf.alo;
import com.tencent.p177mm.protocal.protobuf.alp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.profile.b.a */
public final class C39501a extends C1207m implements C1918k {
    public String aIm;
    public final C7472b ehh;
    private C1202f ehi;
    public alp pkG;

    public C39501a(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(23281);
        C4990ab.m7417i("MicroMsg.NetSceneGetOpenUrl", "NetSceneGetOpenUrl username:%s ticket:%s climsgid:%s content:%s ", str, str2, str3, str4);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/micromsg-bin/getopenurl";
        c1196a.fsJ = new alo();
        c1196a.fsK = new alp();
        this.ehh = c1196a.acD();
        alo alo = (alo) this.ehh.fsG.fsP;
        alo.scene = 1;
        C7249am c7249am = new C7249am();
        c7249am.username = str;
        c7249am.cxb = str2;
        c7249am.pkI = str3;
        c7249am.content = str4;
        alo.wqQ = c7249am;
        AppMethodBeat.m2505o(23281);
    }

    public final int getType() {
        return 913;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(23282);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(23282);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(23283);
        C4990ab.m7411d("MicroMsg.NetSceneGetOpenUrl", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        this.aIm = str;
        AppMethodBeat.m2505o(23283);
    }
}
