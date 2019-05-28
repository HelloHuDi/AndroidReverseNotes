package com.tencent.p177mm.plugin.wallet_index.p564c.p1661b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bjv;
import com.tencent.p177mm.protocal.protobuf.bjw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.b.a */
public final class C46376a extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    public String tRa;
    public String tRb;

    public C46376a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        AppMethodBeat.m2504i(48215);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bjv();
        c1196a.fsK = new bjw();
        c1196a.uri = "/cgi-bin/mmpay-bin/payugenprepay";
        this.ehh = c1196a.acD();
        bjv bjv = (bjv) this.ehh.fsG.fsP;
        bjv.fKh = str;
        bjv.vYP = str4;
        bjv.vYO = str3;
        bjv.vYQ = str5;
        bjv.vYR = str2;
        bjv.vLo = str6;
        bjv.vXP = str7;
        bjv.wla = str8;
        bjv.vAM = i;
        C4990ab.m7410d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str3, str5, str2, str6, str7, str8}));
        AppMethodBeat.m2505o(48215);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48216);
        C4990ab.m7410d("MicroMsg.NetScenePayUGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        bjw bjw = (bjw) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            C4990ab.m7410d("MicroMsg.NetScenePayUGenPrepay", "rr " + bjw.wlb);
            this.tRa = bjw.wlb;
            this.tRb = bjw.wlc;
        }
        this.ehi.onSceneEnd(i, i2, bjw.luU, this);
        AppMethodBeat.m2505o(48216);
    }

    public final int getType() {
        return 1521;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48217);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48217);
        return a;
    }
}
