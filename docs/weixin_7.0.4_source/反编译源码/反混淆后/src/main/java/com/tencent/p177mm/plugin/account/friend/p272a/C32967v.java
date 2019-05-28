package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aad;
import com.tencent.p177mm.protocal.protobuf.aae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.friend.a.v */
public final class C32967v extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public int opType;

    public C32967v(int i, String str) {
        AppMethodBeat.m2504i(108418);
        this.opType = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aad();
        c1196a.fsK = new aae();
        c1196a.uri = "/cgi-bin/micromsg-bin/facebookauth";
        this.ehh = c1196a.acD();
        aad aad = (aad) this.ehh.fsG.fsP;
        if (C5046bo.isNullOrNil(str)) {
            str = "";
        }
        aad.wfk = str;
        aad.nbk = i;
        AppMethodBeat.m2505o(108418);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108419);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108419);
        return a;
    }

    public final int getType() {
        return 183;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108420);
        C4990ab.m7410d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            aae aae = (aae) this.ehh.fsH.fsP;
            int i4 = aae.getBaseResponse().Ret;
            if (i4 != 0) {
                C4990ab.m7412e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(i4)));
                this.ehi.onSceneEnd(4, i4, str, this);
                AppMethodBeat.m2505o(108420);
                return;
            }
            C4990ab.m7410d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + aae.wfm + ", fbusername = " + aae.wfn);
            if (this.opType == 0 || this.opType == 1) {
                C1720g.m3536RP().mo5239Ry().set(65825, aae.wfm);
                C41730b.m73499pR(aae.wfm);
                C1720g.m3536RP().mo5239Ry().set(65826, aae.wfn);
                C1720g.m3536RP().mo5239Ry().dsb();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108420);
    }
}
