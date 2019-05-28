package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.bjo;
import com.tencent.p177mm.protocal.protobuf.bjp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.wallet_core.c.r */
public final class C44431r extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    public C44431r(String str) {
        this(str, null, null, -1, -1, -1);
    }

    public C44431r(String str, String str2, String str3, int i, int i2, int i3) {
        AppMethodBeat.m2504i(49074);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bjo();
        c1196a.fsK = new bjp();
        c1196a.uri = "/cgi-bin/mmpay-bin/paysubscribe";
        c1196a.fsI = v2helper.EMethodSetPlayerPreCorrectCofOff;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        c1196a.fsO = C36391e.atB(str2);
        this.ehh = c1196a.acD();
        bjo bjo = (bjo) this.ehh.fsG.fsP;
        bjo.wMV = str;
        bjo.vRP = C22594k.cPy();
        bjo.wMW = str3;
        if (!C5046bo.isNullOrNil(str2)) {
            bjo.wMX = new C1332b(str2.getBytes());
        }
        if (i >= 0) {
            bjo.vRK = i;
        }
        if (i2 >= 0) {
            bjo.vAM = i2;
        }
        if (i3 >= 0) {
            bjo.wMY = i3;
        }
        AppMethodBeat.m2505o(49074);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(49075);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(49075);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(49076);
        C4990ab.m7410d("MicroMsg.NetScenePaySubscribe", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(49076);
    }

    public final int getType() {
        return v2helper.EMethodSetPlayerPreCorrectCofOff;
    }
}
