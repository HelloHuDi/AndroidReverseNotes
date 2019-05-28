package com.tencent.p177mm.plugin.wallet_core.p749c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.C23435rp;
import com.tencent.p177mm.protocal.protobuf.C7551ro;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p649c.C36379x;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.a */
public final class C22558a extends C36378u {
    public C7472b ehh;
    private C1202f ehi;
    public int ttL = 0;

    public C22558a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2) {
        AppMethodBeat.m2504i(46488);
        this.ttL = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7551ro();
        c1196a.fsK = new C23435rp();
        c1196a.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        c1196a.fsI = 580;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C7551ro c7551ro = (C7551ro) this.ehh.fsG.fsP;
        c7551ro.fKh = str;
        c7551ro.vLo = str2;
        c7551ro.vYO = str3;
        c7551ro.vYP = str4;
        c7551ro.vYR = str5;
        c7551ro.vYQ = str6;
        c7551ro.vXP = str7;
        c7551ro.vYS = i;
        c7551ro.vRP = C22594k.cPy();
        if (C36379x.dNS()) {
            c7551ro.vYT = C36379x.dNU();
        }
        c7551ro.vEt = 1;
        c7551ro.vYV = str8;
        c7551ro.vYU = i2;
        C4990ab.m7417i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", str, str7, Integer.valueOf(i));
        AppMethodBeat.m2505o(46488);
    }

    public C22558a(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2) {
        AppMethodBeat.m2504i(46489);
        this.ttL = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7551ro();
        c1196a.fsK = new C23435rp();
        c1196a.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        c1196a.fsI = 580;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C7551ro c7551ro = (C7551ro) this.ehh.fsG.fsP;
        c7551ro.fKh = str;
        c7551ro.vLo = str2;
        c7551ro.vYO = str3;
        c7551ro.vYP = str4;
        c7551ro.vYR = str5;
        c7551ro.vYQ = str6;
        c7551ro.vYS = i;
        c7551ro.jBB = str7;
        c7551ro.ndP = str8;
        c7551ro.vEt = 2;
        c7551ro.vYV = str9;
        c7551ro.vYU = i2;
        c7551ro.vRP = C22594k.cPy();
        if (C36379x.dNS()) {
            c7551ro.vYT = C36379x.dNU();
        }
        C4990ab.m7417i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", str, str7, str8);
        AppMethodBeat.m2505o(46489);
    }

    public final int getType() {
        return 580;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46490);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46490);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(46491);
        C4990ab.m7410d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            C23435rp c23435rp = (C23435rp) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7416i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + c23435rp.luT + " resp.ErrMsg is " + c23435rp.luU);
            C7551ro c7551ro = (C7551ro) ((C7472b) c1929q).fsG.fsP;
            if (c7551ro.vXP != null) {
                if (Uri.parse(c7551ro.vXP).getQueryParameter("appid") != c7551ro.fKh) {
                    C7060h.pYm.mo8381e(14954, c23435rp.vwr, "", Integer.valueOf(c7551ro.vYS), c7551ro.vYV, c7551ro.fKh, Integer.valueOf(c7551ro.vEt), Integer.valueOf(c7551ro.vYU), c7551ro.vXP, r2);
                } else {
                    C7060h.pYm.mo8381e(14954, c23435rp.vwr, "", Integer.valueOf(c7551ro.vYS), c7551ro.vYV, c7551ro.fKh, Integer.valueOf(c7551ro.vEt), Integer.valueOf(c7551ro.vYU), c7551ro.vXP);
                }
            } else if (!(c7551ro.jBB == null || c7551ro.ndP == null)) {
                C7060h.pYm.mo8381e(14954, c23435rp.vwr, "", Integer.valueOf(c7551ro.vYS), c7551ro.vYV, c7551ro.fKh, Integer.valueOf(c7551ro.vEt), Integer.valueOf(c7551ro.vYU), c7551ro.ndP, c7551ro.jBB);
            }
            C4990ab.m7416i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + c23435rp.luT + " resp.ErrMsg is " + c23435rp.luU);
            str = c23435rp.luU;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(46491);
    }

    public final String getToken() {
        return ((C23435rp) this.ehh.fsH.fsP).token;
    }

    public final String cOS() {
        return ((C23435rp) this.ehh.fsH.fsP).vwr;
    }
}
