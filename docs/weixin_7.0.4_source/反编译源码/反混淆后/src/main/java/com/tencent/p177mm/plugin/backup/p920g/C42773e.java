package com.tencent.p177mm.plugin.backup.p920g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19320l;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.protocal.protobuf.ahp;
import com.tencent.p177mm.protocal.protobuf.ahq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.backup.g.e */
public final class C42773e extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C42773e(String str) {
        AppMethodBeat.m2504i(17658);
        C4990ab.m7417i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", str, C5046bo.dpG());
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ahp();
        c1196a.fsK = new ahq();
        c1196a.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        c1196a.fsI = C19320l.CTRL_INDEX;
        this.ehh = c1196a.acD();
        ((ahp) this.ehh.fsG.fsP).URL = str;
        AppMethodBeat.m2505o(17658);
    }

    public final int getType() {
        return C19320l.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(17659);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(17659);
        return a;
    }

    public final ahq aUk() {
        return (ahq) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(17660);
        C4990ab.m7417i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd errType[%d], errCode[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ahq aUk = aUk();
            C38634d.m65497ao(aUk.vIn.getBuffer().f1226wR);
            C4990ab.m7417i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", aUk.f2976ID, aUk.vIW, aUk.vIX, aUk.vIP, aUk.vIQ, Integer.valueOf(aUk.Scene), aUk.wnV);
            aUk.vIn.getBuffer();
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(17660);
    }
}
