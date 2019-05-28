package com.tencent.p177mm.plugin.wallet_index.p564c.p565a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bjb;
import com.tencent.p177mm.protocal.protobuf.bjc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.a.a */
public final class C4483a extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    public String jumpUrl;
    public String prepayId;
    public String tRb;
    public String tRo;

    public C4483a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        AppMethodBeat.m2504i(48212);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bjb();
        c1196a.fsK = new bjc();
        c1196a.uri = "/cgi-bin/mmpay-bin/payibggenprepay";
        this.ehh = c1196a.acD();
        bjb bjb = (bjb) this.ehh.fsG.fsP;
        bjb.fKh = str;
        bjb.vYP = str4;
        bjb.vYO = str2;
        bjb.vYQ = str5;
        bjb.vYR = str6;
        bjb.vLo = str3;
        bjb.vXP = str7;
        bjb.wla = str8;
        bjb.vAM = i;
        C4990ab.m7410d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str2, str5, str6, str3, str7, str8}));
        AppMethodBeat.m2505o(48212);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48213);
        C4990ab.m7417i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        bjc bjc = (bjc) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            C4990ab.m7417i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(bjc.luT), bjc.luU);
            str = bjc.luU;
            i2 = bjc.luT;
            this.jumpUrl = bjc.mZj;
            this.prepayId = bjc.wlb;
            this.tRb = bjc.wlc;
            this.tRo = bjc.wMr;
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
            this.jumpUrl = null;
        }
        if (C5046bo.isNullOrNil(str)) {
            str = C4996ah.getContext().getString(C25738R.string.fdx);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(48213);
    }

    public final int getType() {
        return 1563;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48214);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48214);
        return a;
    }
}
