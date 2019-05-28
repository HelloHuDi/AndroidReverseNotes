package com.tencent.p177mm.plugin.wallet_core.p749c;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.protocal.protobuf.C23438sc;
import com.tencent.p177mm.protocal.protobuf.C35951sb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.b */
public final class C22559b extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    public int ttL;
    public C23438sc ttM;

    public C22559b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        this(str, str2, str3, str4, str5, str6, str7, str8, i, (byte) 0);
    }

    private C22559b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, byte b) {
        AppMethodBeat.m2504i(46492);
        this.ttL = 0;
        this.ttL = 5;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35951sb();
        c1196a.fsK = new C23438sc();
        c1196a.uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
        c1196a.fsI = 2728;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C35951sb c35951sb = (C35951sb) this.ehh.fsG.fsP;
        c35951sb.fKh = str;
        c35951sb.vLo = str2;
        c35951sb.vYO = str3;
        c35951sb.vYP = str4;
        c35951sb.vYR = str5;
        c35951sb.vYQ = str6;
        c35951sb.vXP = str7;
        c35951sb.vYS = 5;
        c35951sb.vRP = C22594k.cPy();
        c35951sb.vEt = 1;
        c35951sb.jBB = null;
        c35951sb.ndP = null;
        c35951sb.vYV = str8;
        c35951sb.vYU = i;
        boolean bxe = ((C30052l) C1720g.m3528K(C30052l.class)).bxe();
        SharedPreferences doB = C4996ah.doB();
        String str9 = null;
        String str10 = null;
        if (doB != null) {
            str9 = doB.getString("cpu_id", null);
            str10 = doB.getString("uid", null);
        }
        c35951sb.vZt = 0;
        c35951sb.rOh = str9;
        c35951sb.jSY = str10;
        c35951sb.vZu = bxe ? 1 : 0;
        C4990ab.m7411d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", str9, str10);
        C4990ab.m7417i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", str, str7, Integer.valueOf(5), Boolean.valueOf(bxe));
        AppMethodBeat.m2505o(46492);
    }

    public final int getType() {
        return 580;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46493);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46493);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(46494);
        C4990ab.m7410d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            this.ttM = (C23438sc) ((C7472b) c1929q).fsH.fsP;
            C35951sb c35951sb = (C35951sb) ((C7472b) c1929q).fsG.fsP;
            if (c35951sb.vXP != null) {
                if (Uri.parse(c35951sb.vXP).getQueryParameter("appid") != c35951sb.fKh) {
                    C7060h.pYm.mo8381e(14954, this.ttM.vwr, "", Integer.valueOf(c35951sb.vYS), c35951sb.vYV, c35951sb.fKh, Integer.valueOf(c35951sb.vEt), Integer.valueOf(c35951sb.vYU), c35951sb.vXP, r1);
                } else {
                    C7060h.pYm.mo8381e(14954, this.ttM.vwr, "", Integer.valueOf(c35951sb.vYS), c35951sb.vYV, c35951sb.fKh, Integer.valueOf(c35951sb.vEt), Integer.valueOf(c35951sb.vYU), c35951sb.vXP);
                }
            } else if (!(c35951sb.jBB == null || c35951sb.ndP == null)) {
                C7060h.pYm.mo8381e(14954, this.ttM.vwr, "", Integer.valueOf(c35951sb.vYS), c35951sb.vYV, c35951sb.fKh, Integer.valueOf(c35951sb.vEt), Integer.valueOf(c35951sb.vYU), c35951sb.ndP, c35951sb.jBB);
            }
            C4990ab.m7416i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.ttM.luT + " resp.ErrMsg is " + this.ttM.luU);
            str = this.ttM.luU;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(46494);
    }
}
