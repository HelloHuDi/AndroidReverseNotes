package com.tencent.p177mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42528t;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.bis;
import com.tencent.p177mm.protocal.protobuf.bit;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.order.model.g */
public final class C43362g extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    public C43362g(String str, String str2) {
        AppMethodBeat.m2504i(43778);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bis();
        c1196a.fsK = new bit();
        c1196a.uri = "/cgi-bin/micromsg-bin/paydeluserroll";
        c1196a.fsI = C42528t.CTRL_INDEX;
        this.ehh = c1196a.acD();
        bis bis = (bis) this.ehh.fsG.fsP;
        bis.wMd = 1;
        if (!C5046bo.isNullOrNil(str)) {
            bis.pcU = str;
        }
        if (!C5046bo.isNullOrNil(str2)) {
            bis.pdn = str2;
        }
        bis.vRP = C22594k.cPy();
        AppMethodBeat.m2505o(43778);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(43779);
        C4990ab.m7410d("MicroMsg.NetScenePayDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(43779);
    }

    public final int bZa() {
        return ((bis) this.ehh.fsG.fsP).wMd;
    }

    public final String bZb() {
        return ((bis) this.ehh.fsG.fsP).pcU;
    }

    public final int getType() {
        return C42528t.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43780);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43780);
        return a;
    }
}
