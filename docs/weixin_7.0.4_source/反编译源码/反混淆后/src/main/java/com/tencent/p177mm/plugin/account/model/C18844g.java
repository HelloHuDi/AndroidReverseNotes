package com.tencent.p177mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.cgw;
import com.tencent.p177mm.protocal.protobuf.cgx;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.model.g */
public final class C18844g extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C18844g(String str) {
        AppMethodBeat.m2504i(124685);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cgw();
        c1196a.fsK = new cgx();
        c1196a.uri = "/cgi-bin/micromsg-bin/thirdappverify";
        this.ehh = c1196a.acD();
        ((cgw) this.ehh.fsG.fsP).wfk = str;
        ((cgw) this.ehh.fsG.fsP).xfE = 1;
        ((cgw) this.ehh.fsG.fsP).luQ = C4988aa.dor();
        byte[] dpz = C5046bo.dpz();
        ((cgw) this.ehh.fsG.fsP).vLz = C1946aa.m4152ad(dpz);
        this.ehh.mo16652a(C4851z.dmx());
        this.ehh.cQh = 1;
        this.ehh.acF().vyi = dpz;
        this.ehh.acF().vyf = 1;
        AppMethodBeat.m2505o(124685);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(124686);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(124686);
        return a;
    }

    public final int getType() {
        return 755;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(124687);
        C4990ab.m7417i("MicroMsg.NetSceneVerifyThirdApp", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(124687);
    }
}
