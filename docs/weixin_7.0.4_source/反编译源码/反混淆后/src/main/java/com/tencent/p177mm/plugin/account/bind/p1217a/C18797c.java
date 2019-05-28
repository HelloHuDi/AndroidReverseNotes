package com.tencent.p177mm.plugin.account.bind.p1217a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C16657e;
import com.tencent.p177mm.protocal.protobuf.ciy;
import com.tencent.p177mm.protocal.protobuf.ciz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.bind.a.c */
public final class C18797c extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C18797c() {
        AppMethodBeat.m2504i(13324);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ciy();
        c1196a.fsK = new ciz();
        c1196a.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
        c1196a.fsI = C16657e.CTRL_INDEX;
        this.ehh = c1196a.acD();
        ((ciy) this.ehh.fsG.fsP).vIJ = 1;
        AppMethodBeat.m2505o(13324);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13325);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13325);
        return a;
    }

    public final int getType() {
        return C16657e.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13326);
        C4990ab.m7410d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            C1720g.m3536RP().mo5239Ry().set(286722, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(286721, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(286723, (Object) "");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(13326);
    }
}
