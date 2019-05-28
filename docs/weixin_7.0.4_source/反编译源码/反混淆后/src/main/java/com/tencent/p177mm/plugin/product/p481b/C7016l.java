package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cad;
import com.tencent.p177mm.protocal.protobuf.cfn;
import com.tencent.p177mm.protocal.protobuf.cfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.product.b.l */
public final class C7016l extends C36378u implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String phn;

    public C7016l(cad cad, String str) {
        AppMethodBeat.m2504i(44000);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cfn();
        c1196a.fsK = new cfo();
        c1196a.uri = "/cgi-bin/micromsg-bin/submitmallorder";
        this.ehh = c1196a.acD();
        cfn cfn = (cfn) this.ehh.fsG.fsP;
        cfn.xeP = cad;
        cfn.xeR = str;
        AppMethodBeat.m2505o(44000);
    }

    public final int getType() {
        return 556;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44001);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44001);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44002);
        cfo cfo = (cfo) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + cfo.xeQ);
            this.phn = cfo.xeQ;
        }
        C4990ab.m7410d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + i2 + ", errMsg " + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(44002);
    }
}
