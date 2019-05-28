package com.tencent.p177mm.plugin.wallet_index.p564c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.soter.p528d.C13720d;
import com.tencent.p177mm.plugin.soter.p528d.C29254e;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.adj;
import com.tencent.p177mm.protocal.protobuf.adk;
import com.tencent.p177mm.protocal.protobuf.csj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.e */
public class C4484e extends C36378u implements C44426i {
    private C7472b ehh;
    private C1202f ehi;
    public String tRa;
    public String tRb;
    public csj tRc;
    public String tRd = "";

    public C4484e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3, String str9) {
        AppMethodBeat.m2504i(48181);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new adj();
        c1196a.fsK = new adk();
        c1196a.uri = getUri();
        c1196a.fsI = getType();
        c1196a.fsL = 189;
        c1196a.fsM = 1000000189;
        c1196a.fsO = C36391e.atB(str4);
        this.ehh = c1196a.acD();
        this.tRd = str7;
        C29254e cvQ = C13720d.cvQ();
        String str10 = cvQ.rOh;
        String str11 = cvQ.jSY;
        adj adj = (adj) this.ehh.fsG.fsP;
        adj.fKh = str;
        adj.vYP = str4;
        adj.vYO = str3;
        adj.vYQ = str5;
        adj.vYR = str2;
        adj.vLo = str6;
        adj.vXP = str7;
        adj.wla = str8;
        adj.vAM = i;
        adj.wle = str10;
        adj.wld = str11;
        adj.vRP = C22594k.cPy();
        if (i2 > 0) {
            adj.Scene = i2;
        }
        adj.wlf = i3;
        adj.wlg = str9;
        C4990ab.m7411d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str9);
        AppMethodBeat.m2505o(48181);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48182);
        C4990ab.m7410d("MicroMsg.NetSceneGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        adk adk = (adk) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(adk.luT), adk.luU);
        if (i == 0 && i2 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGenPrepay", "rr " + adk.wlb);
            this.tRa = adk.wlb;
            this.tRb = adk.wlc;
            this.tRc = adk.wlh;
        }
        String str2 = adk.luU;
        this.ehi.onSceneEnd(i, adk.luT, str2, this);
        AppMethodBeat.m2505o(48182);
    }

    public int getType() {
        return 398;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48183);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48183);
        return a;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/genprepay";
    }
}
