package com.tencent.p177mm.plugin.wallet_core.p749c.p750a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bjd;
import com.tencent.p177mm.protocal.protobuf.bje;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.a.b */
public final class C36835b extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    public String jumpUrl;
    public int tuH = 0;

    public C36835b() {
        boolean booleanValue;
        int i;
        AppMethodBeat.m2504i(46563);
        C1196a c1196a = new C1196a();
        bjd bjd = new bjd();
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        if (booleanValue) {
            i = 1;
        } else {
            i = 0;
        }
        bjd.wMs = i;
        c1196a.fsJ = bjd;
        c1196a.fsK = new bje();
        c1196a.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        c1196a.fsI = 1564;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(46563);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(46564);
        C4990ab.m7417i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        bje bje = (bje) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            C4990ab.m7417i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(bje.luT), bje.luU);
            str = bje.luU;
            i2 = bje.luT;
            this.jumpUrl = bje.mZj;
            this.tuH = bje.wMt;
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
            this.jumpUrl = null;
        }
        if (C5046bo.isNullOrNil(str)) {
            str = C4996ah.getContext().getString(C25738R.string.fdx);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(46564);
    }

    public final int getType() {
        return 1564;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46565);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46565);
        return a;
    }
}
