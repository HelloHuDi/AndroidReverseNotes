package com.tencent.mm.plugin.wallet_core.c;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.u;

public final class b extends u {
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    public int ttL;
    public sc ttM;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        this(str, str2, str3, str4, str5, str6, str7, str8, i, (byte) 0);
    }

    private b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, byte b) {
        AppMethodBeat.i(46492);
        this.ttL = 0;
        this.ttL = 5;
        a aVar = new a();
        aVar.fsJ = new sb();
        aVar.fsK = new sc();
        aVar.uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
        aVar.fsI = 2728;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        sb sbVar = (sb) this.ehh.fsG.fsP;
        sbVar.fKh = str;
        sbVar.vLo = str2;
        sbVar.vYO = str3;
        sbVar.vYP = str4;
        sbVar.vYR = str5;
        sbVar.vYQ = str6;
        sbVar.vXP = str7;
        sbVar.vYS = 5;
        sbVar.vRP = k.cPy();
        sbVar.vEt = 1;
        sbVar.jBB = null;
        sbVar.ndP = null;
        sbVar.vYV = str8;
        sbVar.vYU = i;
        boolean bxe = ((l) g.K(l.class)).bxe();
        SharedPreferences doB = ah.doB();
        String str9 = null;
        String str10 = null;
        if (doB != null) {
            str9 = doB.getString("cpu_id", null);
            str10 = doB.getString("uid", null);
        }
        sbVar.vZt = 0;
        sbVar.rOh = str9;
        sbVar.jSY = str10;
        sbVar.vZu = bxe ? 1 : 0;
        ab.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", str9, str10);
        ab.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", str, str7, Integer.valueOf(5), Boolean.valueOf(bxe));
        AppMethodBeat.o(46492);
    }

    public final int getType() {
        return 580;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46493);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46493);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(46494);
        ab.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            this.ttM = (sc) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
            sb sbVar = (sb) ((com.tencent.mm.ai.b) qVar).fsG.fsP;
            if (sbVar.vXP != null) {
                if (Uri.parse(sbVar.vXP).getQueryParameter("appid") != sbVar.fKh) {
                    h.pYm.e(14954, this.ttM.vwr, "", Integer.valueOf(sbVar.vYS), sbVar.vYV, sbVar.fKh, Integer.valueOf(sbVar.vEt), Integer.valueOf(sbVar.vYU), sbVar.vXP, r1);
                } else {
                    h.pYm.e(14954, this.ttM.vwr, "", Integer.valueOf(sbVar.vYS), sbVar.vYV, sbVar.fKh, Integer.valueOf(sbVar.vEt), Integer.valueOf(sbVar.vYU), sbVar.vXP);
                }
            } else if (!(sbVar.jBB == null || sbVar.ndP == null)) {
                h.pYm.e(14954, this.ttM.vwr, "", Integer.valueOf(sbVar.vYS), sbVar.vYV, sbVar.fKh, Integer.valueOf(sbVar.vEt), Integer.valueOf(sbVar.vYU), sbVar.ndP, sbVar.jBB);
            }
            ab.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.ttM.luT + " resp.ErrMsg is " + this.ttM.luU);
            str = this.ttM.luU;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(46494);
    }
}
