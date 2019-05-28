package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class f extends c {
    private static int mwv = 7200;
    private String mac;
    private String ssid;

    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20784);
        a aVar = new a();
        aVar.fsJ = new aer();
        aVar.fsK = new aes();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
        aVar.fsI = 1726;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20784);
    }

    public final int getType() {
        return 1726;
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(20785);
        bzd();
        this.ssid = str;
        this.mac = str2;
        dh dhVar = new dh();
        dhVar.mac = str2;
        dhVar.ssid = str;
        aer aer = (aer) this.ehh.fsG.fsP;
        aer.appId = str3;
        aer.mwU = str4;
        aer.mwV = str5;
        aer.mwW = str6;
        aer.cvO = str7;
        aer.sign = str8;
        aer.wmv = dhVar;
        AppMethodBeat.o(20785);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(int i, int i2, int i3, String str) {
        AppMethodBeat.i(20786);
        c ML = j.byW().ML(this.ssid);
        Object obj = null;
        if (ML == null) {
            obj = 1;
            ML = new c();
            ML.field_ssidmd5 = ag.ck(this.ssid);
        }
        Object obj2 = obj;
        boolean b;
        if (i2 == 0 && i3 == 0) {
            aes aes = (aes) this.ehh.fsH.fsP;
            ML.field_ssid = this.ssid;
            ML.field_showUrl = aes.vAT;
            bzt bzt = aes.vAU;
            if (bzt != null) {
                ab.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", bzt.wYO, bzt.wYP, bzt.wYQ);
                ML.field_showWordCn = bzt.wYP;
                ML.field_showWordEn = bzt.wYO;
                ML.field_showWordTw = bzt.wYQ;
            } else {
                ML.field_showWordCn = ah.getContext().getResources().getString(R.string.c0y);
                ML.field_showWordEn = ah.getContext().getResources().getString(R.string.c0y);
                ML.field_showWordTw = ah.getContext().getResources().getString(R.string.c0y);
            }
            ML.field_action = aes.vAS;
            ML.field_verifyResult = 1;
            ML.field_connectState = -1;
            if (aes.vBc <= 0) {
                aes.vBc = mwv;
            }
            ML.field_expiredTime = bo.anT() + ((long) aes.vBc);
            ML.field_mac = this.mac;
            if (obj2 != null) {
                b = j.byW().b((com.tencent.mm.sdk.e.c) ML);
                ab.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", Boolean.valueOf(b));
            } else {
                b = j.byW().c(ML, new String[0]);
                ab.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", Boolean.valueOf(b));
            }
            j.byW().MM(this.ssid);
            AppMethodBeat.o(20786);
            return;
        }
        ab.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", this.ssid);
        if (obj2 == null) {
            b = j.byW().a((com.tencent.mm.sdk.e.c) ML, new String[0]);
            ab.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(b));
        }
        AppMethodBeat.o(20786);
    }

    public final gj bzj() {
        return ((aes) this.ehh.fsH.fsP).mzh;
    }
}
