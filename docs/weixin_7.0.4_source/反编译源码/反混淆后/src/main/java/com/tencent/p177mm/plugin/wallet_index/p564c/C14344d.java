package com.tencent.p177mm.plugin.wallet_index.p564c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.adh;
import com.tencent.p177mm.protocal.protobuf.adi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.d */
public final class C14344d extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    public String tRa;
    public String tRb;

    public C14344d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9) {
        AppMethodBeat.m2504i(48178);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new adh();
        c1196a.fsK = new adi();
        c1196a.uri = "/cgi-bin/mmpay-bin/genmallprepay";
        this.ehh = c1196a.acD();
        adh adh = (adh) this.ehh.fsG.fsP;
        adh.fKh = str;
        adh.vYP = str4;
        adh.vYO = str3;
        adh.vYQ = str5;
        adh.vYR = str2;
        adh.vLo = str6;
        adh.vXP = str7;
        adh.wla = str8;
        adh.vAM = i;
        adh.ndT = str9;
        if (i2 > 0) {
            adh.Scene = i2;
        }
        C4990ab.m7410d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2)}));
        AppMethodBeat.m2505o(48178);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48179);
        C4990ab.m7410d("MicroMsg.NetSceneGenMallPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        adi adi = (adi) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(adi.luT), adi.luU);
        if (i == 0 && i2 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGenMallPrepay", "rr " + adi.wlb);
            this.tRa = adi.wlb;
            this.tRb = adi.wlc;
        }
        String str2 = adi.luU;
        this.ehi.onSceneEnd(i, adi.luT, str2, this);
        AppMethodBeat.m2505o(48179);
    }

    public final int getType() {
        return 2755;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48180);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48180);
        return a;
    }
}
