package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.ab;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a extends c {
    private static int mwv = 7200;
    private int czE;
    private String mac;
    private String ssid;

    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20770);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new aa();
        aVar.fsK = new ab();
        aVar.uri = "/cgi-bin/micromsg-bin/apauth";
        aVar.fsI = 640;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20770);
    }

    public final int getType() {
        return 640;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        AppMethodBeat.i(20771);
        bzd();
        this.ssid = str2;
        this.mac = str3;
        aa aaVar = (aa) this.ehh.fsG.fsP;
        String decode = URLDecoder.decode(str5);
        aaVar.OpCode = 0;
        aaVar.URL = str;
        aaVar.SSID = str2;
        aaVar.vAI = str4;
        aaVar.vAJ = decode;
        aaVar.vAK = str6;
        aaVar.vAM = i;
        aaVar.vAN = str7;
        LinkedList linkedList = new LinkedList();
        dh dhVar = new dh();
        dhVar.ssid = str2;
        dhVar.mac = str3;
        linkedList.add(dhVar);
        aaVar.vAL = linkedList;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", str, str2, str4, str3, str5, decode, str6);
        AppMethodBeat.o(20771);
    }

    public a(String str, String str2, String str3, int i, int i2, String str4) {
        AppMethodBeat.i(20772);
        bzd();
        this.ssid = str3;
        this.mac = str2;
        this.czE = 1;
        LinkedList linkedList = new LinkedList();
        dh dhVar = new dh();
        dhVar.ssid = str3;
        dhVar.mac = str2;
        dhVar.vFl = i;
        linkedList.add(dhVar);
        aa aaVar = (aa) this.ehh.fsG.fsP;
        aaVar.OpCode = 1;
        aaVar.vAL = linkedList;
        aaVar.URL = str;
        aaVar.vAM = i2;
        aaVar.vAN = str4;
        aaVar.vAP = m.Mz("MicroMsg.FreeWifi.NetSceneAPAuth");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", Integer.valueOf(1), str2, str3, Integer.valueOf(i));
        AppMethodBeat.o(20772);
    }

    public a(String str, int i, String str2) {
        AppMethodBeat.i(20773);
        bzd();
        this.czE = 4;
        aa aaVar = (aa) this.ehh.fsG.fsP;
        aaVar.OpCode = 4;
        aaVar.URL = str;
        aaVar.vAM = i;
        aaVar.vAN = str2;
        aaVar.vAO = m.byt();
        aaVar.vAL = new LinkedList();
        dh dhVar = new dh();
        dhVar.ssid = m.Mx("MicroMsg.FreeWifi.NetSceneAPAuth");
        dhVar.mac = m.My("MicroMsg.FreeWifi.NetSceneAPAuth");
        aaVar.vAL.add(dhVar);
        aaVar.vAP = m.Mz("MicroMsg.FreeWifi.NetSceneAPAuth");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", Integer.valueOf(aaVar.vAO), dhVar.ssid, dhVar.mac);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", Integer.valueOf(4), str);
        AppMethodBeat.o(20773);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(int i, int i2, int i3, String str) {
        AppMethodBeat.i(20774);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.czE));
        c ML;
        Object obj;
        Object obj2;
        ab abVar;
        bzt bzt;
        switch (this.czE) {
            case 0:
                if (i2 == 0 && i3 == 0) {
                    ML = j.byW().ML(this.ssid);
                    String str2 = "MicroMsg.FreeWifi.NetSceneAPAuth";
                    String str3 = "get freewifi by ssid :%s, is wifi info = null ? %b";
                    Object[] objArr = new Object[2];
                    objArr[0] = this.ssid;
                    objArr[1] = Boolean.valueOf(ML == null);
                    com.tencent.mm.sdk.platformtools.ab.i(str2, str3, objArr);
                    obj = null;
                    if (ML == null) {
                        obj = 1;
                        ML = new c();
                        ML.field_ssidmd5 = ag.ck(this.ssid);
                    }
                    obj2 = obj;
                    ML.field_wifiType = 1;
                    abVar = (ab) this.ehh.fsH.fsP;
                    bzt = abVar.vAU;
                    if (bzt != null) {
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", bzt.wYO, bzt.wYP, bzt.wYQ);
                        ML.field_showWordCn = bzt.wYP;
                        ML.field_showWordEn = bzt.wYO;
                        ML.field_showWordTw = bzt.wYQ;
                    } else {
                        ML.field_showWordCn = ah.getContext().getResources().getString(R.string.c0y);
                        ML.field_showWordEn = ah.getContext().getResources().getString(R.string.c0y);
                        ML.field_showWordTw = ah.getContext().getResources().getString(R.string.c0y);
                    }
                    ML.field_action = abVar.vAS;
                    ML.field_verifyResult = 1;
                    ML.field_connectState = -1;
                    if (abVar.vBc <= 0) {
                        abVar.vBc = mwv;
                    }
                    ML.field_expiredTime = bo.anT() + ((long) abVar.vBc);
                    ML.field_showUrl = abVar.vAT;
                    ML.field_action = abVar.vAS;
                    ML.field_ssid = this.ssid;
                    ML.field_mac = this.mac;
                    ML.field_wifiType = 1;
                    boolean b;
                    if (obj2 != null) {
                        b = j.byW().b((com.tencent.mm.sdk.e.c) ML);
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(b));
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", this.ssid, Boolean.valueOf(b), Integer.valueOf(abVar.vAR), Integer.valueOf(abVar.vAS), abVar.vAT);
                        AppMethodBeat.o(20774);
                        return;
                    }
                    b = j.byW().c(ML, new String[0]);
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", this.ssid, Boolean.valueOf(b), Integer.valueOf(abVar.vAR), Integer.valueOf(abVar.vAS), abVar.vAT);
                    AppMethodBeat.o(20774);
                    return;
                }
            case 1:
                ML = j.byW().ML(this.ssid);
                obj = null;
                if (ML == null) {
                    obj = 1;
                    ML = new c();
                    ML.field_ssidmd5 = ag.ck(this.ssid);
                }
                obj2 = obj;
                boolean a;
                if (i2 != 0 || i3 != 0) {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", this.ssid);
                    if (obj2 == null) {
                        a = j.byW().a((com.tencent.mm.sdk.e.c) ML, new String[0]);
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(a));
                        break;
                    }
                }
                abVar = (ab) this.ehh.fsH.fsP;
                ML.field_ssid = this.ssid;
                ML.field_showUrl = abVar.vAT;
                bzt = abVar.vAU;
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", this.ssid, Integer.valueOf(abVar.vAR), Integer.valueOf(abVar.vAS), abVar.vAT);
                if (bzt != null) {
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", bzt.wYO, bzt.wYP, bzt.wYQ);
                    ML.field_showWordCn = bzt.wYP;
                    ML.field_showWordEn = bzt.wYO;
                    ML.field_showWordTw = bzt.wYQ;
                } else {
                    ML.field_showWordCn = ah.getContext().getResources().getString(R.string.c0y);
                    ML.field_showWordEn = ah.getContext().getResources().getString(R.string.c0y);
                    ML.field_showWordTw = ah.getContext().getResources().getString(R.string.c0y);
                }
                ML.field_action = abVar.vAS;
                ML.field_verifyResult = 1;
                ML.field_connectState = -1;
                if (abVar.vBc <= 0) {
                    abVar.vBc = mwv;
                }
                ML.field_expiredTime = bo.anT() + ((long) abVar.vBc);
                ML.field_mac = this.mac;
                if (obj2 != null) {
                    a = j.byW().b((com.tencent.mm.sdk.e.c) ML);
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(a));
                } else {
                    a = j.byW().c(ML, new String[0]);
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(a));
                }
                j.byW().MM(this.ssid);
                AppMethodBeat.o(20774);
                return;
                break;
        }
        AppMethodBeat.o(20774);
    }

    public final String bze() {
        ab abVar = (ab) this.ehh.fsH.fsP;
        if (abVar != null) {
            return abVar.vAQ;
        }
        return null;
    }

    public final bns bzf() {
        ab abVar = (ab) this.ehh.fsH.fsP;
        if (abVar != null) {
            return abVar.vAX;
        }
        return null;
    }

    public final boolean bzg() {
        ab abVar = (ab) this.ehh.fsH.fsP;
        if (abVar == null || abVar.vAY == null) {
            return false;
        }
        if (abVar.vAY.vAO == 1) {
            return true;
        }
        return false;
    }

    public final acq bzh() {
        ab abVar = (ab) this.ehh.fsH.fsP;
        if (abVar != null) {
            return abVar.vAY;
        }
        return null;
    }

    public final String bzi() {
        ab abVar = (ab) this.ehh.fsH.fsP;
        if (abVar != null) {
            return abVar.vBa;
        }
        return null;
    }

    public final String Ge() {
        ab abVar = (ab) this.ehh.fsH.fsP;
        if (abVar != null) {
            return abVar.vBb;
        }
        return null;
    }

    public final gj bzj() {
        ab abVar = (ab) this.ehh.fsH.fsP;
        if (abVar != null) {
            return abVar.vAZ;
        }
        return null;
    }
}
