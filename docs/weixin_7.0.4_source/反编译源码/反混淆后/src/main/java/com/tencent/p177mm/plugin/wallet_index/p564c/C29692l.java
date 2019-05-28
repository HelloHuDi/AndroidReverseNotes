package com.tencent.p177mm.plugin.wallet_index.p564c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.auh;
import com.tencent.p177mm.protocal.protobuf.aui;
import com.tencent.p177mm.protocal.protobuf.cmo;
import com.tencent.p177mm.protocal.protobuf.cmp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.l */
public final class C29692l extends C36378u {
    public String cwg;
    private C7472b ehh;
    private C1202f ehi;
    public int errCode;

    public C29692l(int i, int i2, String str, aui aui, auh auh) {
        AppMethodBeat.m2504i(48192);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cmo();
        c1196a.fsK = new cmp();
        c1196a.uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
        this.ehh = c1196a.acD();
        cmo cmo = (cmo) this.ehh.fsG.fsP;
        cmo.wlY = i;
        cmo.cHG = i2;
        this.cwg = str;
        cmo.wme = aui;
        cmo.wmd = auh;
        AppMethodBeat.m2505o(48192);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48193);
        C4990ab.m7412e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            cmp cmp = (cmp) this.ehh.fsH.fsP;
            C4990ab.m7412e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + cmp.cCJ + ",errMsg:" + cmp.cCK);
            this.ehi.onSceneEnd(i, cmp.cCJ, str, this);
            AppMethodBeat.m2505o(48193);
            return;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(48193);
    }

    public final int getType() {
        return 1306;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48194);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48194);
        return a;
    }
}
