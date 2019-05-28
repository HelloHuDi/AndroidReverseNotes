package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.ad;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b extends c {
    private static int mwv = 7200;
    public String mac;
    private String ssid;

    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20775);
        a aVar = new a();
        aVar.fsJ = new ac();
        aVar.fsK = new ad();
        aVar.uri = "/cgi-bin/mmo2o-bin/apcheck";
        aVar.fsI = 1744;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20775);
    }

    public final int getType() {
        return 1744;
    }

    public b(String str, String str2, int i, int i2) {
        AppMethodBeat.i(20776);
        bzd();
        this.ssid = str2;
        this.mac = str;
        LinkedList linkedList = new LinkedList();
        dh dhVar = new dh();
        dhVar.ssid = str2;
        dhVar.mac = str;
        dhVar.vFl = i;
        linkedList.add(dhVar);
        ac acVar = (ac) this.ehh.fsG.fsP;
        acVar.vBd = com.tencent.mm.plugin.freewifi.h.b.mtY.byg();
        acVar.vAL = linkedList;
        acVar.vBe = m.byv();
        acVar.vBf = i2;
        ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", str, str2, Integer.valueOf(i));
        AppMethodBeat.o(20776);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(int i, int i2, int i3, String str) {
        ad adVar;
        boolean z;
        AppMethodBeat.i(20777);
        ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!(this.ehh == null || this.ehh.fsH.fsP == null)) {
            com.tencent.mm.plugin.freewifi.h.b.mtY.a((ad) this.ehh.fsH.fsP);
            if (m.eg(i2, i3) || m.eh(i2, i3)) {
                adVar = (ad) this.ehh.fsH.fsP;
                int i4 = adVar.vBi;
                z = adVar.vBh;
                if (!(i4 == 0 || i4 == i.a.mtZ.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
                    i.a.mtZ.ch("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", i4);
                }
                if (z) {
                    i.a.mtZ.F("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
                }
            }
        }
        c ML = j.byW().ML(this.ssid);
        Object obj = null;
        if (ML == null) {
            obj = 1;
            ML = new c();
            ML.field_ssidmd5 = ag.ck(this.ssid);
        }
        Object obj2 = obj;
        if (i2 == 0 && i3 == 0) {
            adVar = (ad) this.ehh.fsH.fsP;
            ML.field_ssid = this.ssid;
            ML.field_showUrl = adVar.vAT;
            bzt bzt = adVar.vAU;
            if (bzt != null) {
                ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", bzt.wYO, bzt.wYP, bzt.wYQ);
                ML.field_showWordCn = bzt.wYP;
                ML.field_showWordEn = bzt.wYO;
                ML.field_showWordTw = bzt.wYQ;
            } else {
                ML.field_showWordCn = ah.getContext().getResources().getString(R.string.c0y);
                ML.field_showWordEn = ah.getContext().getResources().getString(R.string.c0y);
                ML.field_showWordTw = ah.getContext().getResources().getString(R.string.c0y);
            }
            ML.field_action = adVar.vAS;
            ML.field_verifyResult = 1;
            ML.field_connectState = -1;
            if (adVar.vBc <= 0) {
                adVar.vBc = mwv;
            }
            ML.field_expiredTime = bo.anT() + ((long) adVar.vBc);
            ML.field_mac = this.mac;
            if (obj2 != null) {
                z = j.byW().b((com.tencent.mm.sdk.e.c) ML);
                ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(z));
            } else {
                z = j.byW().c(ML, new String[0]);
                ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(z));
            }
            j.byW().MM(this.ssid);
            AppMethodBeat.o(20777);
            return;
        }
        ab.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", this.ssid);
        if (obj2 == null) {
            z = j.byW().a((com.tencent.mm.sdk.e.c) ML, new String[0]);
            ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(z));
        }
        AppMethodBeat.o(20777);
    }
}
