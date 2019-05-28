package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.x;

public final class a extends u {
    public b ehh;
    private f ehi;
    public int ttL = 0;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2) {
        AppMethodBeat.i(46488);
        this.ttL = i;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new ro();
        aVar.fsK = new rp();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.fsI = 580;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ro roVar = (ro) this.ehh.fsG.fsP;
        roVar.fKh = str;
        roVar.vLo = str2;
        roVar.vYO = str3;
        roVar.vYP = str4;
        roVar.vYR = str5;
        roVar.vYQ = str6;
        roVar.vXP = str7;
        roVar.vYS = i;
        roVar.vRP = k.cPy();
        if (x.dNS()) {
            roVar.vYT = x.dNU();
        }
        roVar.vEt = 1;
        roVar.vYV = str8;
        roVar.vYU = i2;
        ab.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", str, str7, Integer.valueOf(i));
        AppMethodBeat.o(46488);
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2) {
        AppMethodBeat.i(46489);
        this.ttL = i;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new ro();
        aVar.fsK = new rp();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.fsI = 580;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ro roVar = (ro) this.ehh.fsG.fsP;
        roVar.fKh = str;
        roVar.vLo = str2;
        roVar.vYO = str3;
        roVar.vYP = str4;
        roVar.vYR = str5;
        roVar.vYQ = str6;
        roVar.vYS = i;
        roVar.jBB = str7;
        roVar.ndP = str8;
        roVar.vEt = 2;
        roVar.vYV = str9;
        roVar.vYU = i2;
        roVar.vRP = k.cPy();
        if (x.dNS()) {
            roVar.vYT = x.dNU();
        }
        ab.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", str, str7, str8);
        AppMethodBeat.o(46489);
    }

    public final int getType() {
        return 580;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46490);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46490);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(46491);
        ab.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            rp rpVar = (rp) ((b) qVar).fsH.fsP;
            ab.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + rpVar.luT + " resp.ErrMsg is " + rpVar.luU);
            ro roVar = (ro) ((b) qVar).fsG.fsP;
            if (roVar.vXP != null) {
                if (Uri.parse(roVar.vXP).getQueryParameter("appid") != roVar.fKh) {
                    h.pYm.e(14954, rpVar.vwr, "", Integer.valueOf(roVar.vYS), roVar.vYV, roVar.fKh, Integer.valueOf(roVar.vEt), Integer.valueOf(roVar.vYU), roVar.vXP, r2);
                } else {
                    h.pYm.e(14954, rpVar.vwr, "", Integer.valueOf(roVar.vYS), roVar.vYV, roVar.fKh, Integer.valueOf(roVar.vEt), Integer.valueOf(roVar.vYU), roVar.vXP);
                }
            } else if (!(roVar.jBB == null || roVar.ndP == null)) {
                h.pYm.e(14954, rpVar.vwr, "", Integer.valueOf(roVar.vYS), roVar.vYV, roVar.fKh, Integer.valueOf(roVar.vEt), Integer.valueOf(roVar.vYU), roVar.ndP, roVar.jBB);
            }
            ab.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + rpVar.luT + " resp.ErrMsg is " + rpVar.luU);
            str = rpVar.luU;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(46491);
    }

    public final String getToken() {
        return ((rp) this.ehh.fsH.fsP).token;
    }

    public final String cOS() {
        return ((rp) this.ehh.fsH.fsP).vwr;
    }
}
