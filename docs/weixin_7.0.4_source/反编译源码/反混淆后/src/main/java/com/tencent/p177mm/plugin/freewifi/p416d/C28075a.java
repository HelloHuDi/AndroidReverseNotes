package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.protocal.protobuf.C40500ab;
import com.tencent.p177mm.protocal.protobuf.C46519aa;
import com.tencent.p177mm.protocal.protobuf.C7257dh;
import com.tencent.p177mm.protocal.protobuf.acq;
import com.tencent.p177mm.protocal.protobuf.bns;
import com.tencent.p177mm.protocal.protobuf.bzt;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URLDecoder;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.freewifi.d.a */
public final class C28075a extends C43104c {
    private static int mwv = 7200;
    private int czE;
    private String mac;
    private String ssid;

    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20770);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46519aa();
        c1196a.fsK = new C40500ab();
        c1196a.uri = "/cgi-bin/micromsg-bin/apauth";
        c1196a.fsI = 640;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20770);
    }

    public final int getType() {
        return 640;
    }

    public C28075a(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        AppMethodBeat.m2504i(20771);
        bzd();
        this.ssid = str2;
        this.mac = str3;
        C46519aa c46519aa = (C46519aa) this.ehh.fsG.fsP;
        String decode = URLDecoder.decode(str5);
        c46519aa.OpCode = 0;
        c46519aa.URL = str;
        c46519aa.SSID = str2;
        c46519aa.vAI = str4;
        c46519aa.vAJ = decode;
        c46519aa.vAK = str6;
        c46519aa.vAM = i;
        c46519aa.vAN = str7;
        LinkedList linkedList = new LinkedList();
        C7257dh c7257dh = new C7257dh();
        c7257dh.ssid = str2;
        c7257dh.mac = str3;
        linkedList.add(c7257dh);
        c46519aa.vAL = linkedList;
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", str, str2, str4, str3, str5, decode, str6);
        AppMethodBeat.m2505o(20771);
    }

    public C28075a(String str, String str2, String str3, int i, int i2, String str4) {
        AppMethodBeat.m2504i(20772);
        bzd();
        this.ssid = str3;
        this.mac = str2;
        this.czE = 1;
        LinkedList linkedList = new LinkedList();
        C7257dh c7257dh = new C7257dh();
        c7257dh.ssid = str3;
        c7257dh.mac = str2;
        c7257dh.vFl = i;
        linkedList.add(c7257dh);
        C46519aa c46519aa = (C46519aa) this.ehh.fsG.fsP;
        c46519aa.OpCode = 1;
        c46519aa.vAL = linkedList;
        c46519aa.URL = str;
        c46519aa.vAM = i2;
        c46519aa.vAN = str4;
        c46519aa.vAP = C34189m.m56061Mz("MicroMsg.FreeWifi.NetSceneAPAuth");
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", Integer.valueOf(1), str2, str3, Integer.valueOf(i));
        AppMethodBeat.m2505o(20772);
    }

    public C28075a(String str, int i, String str2) {
        AppMethodBeat.m2504i(20773);
        bzd();
        this.czE = 4;
        C46519aa c46519aa = (C46519aa) this.ehh.fsG.fsP;
        c46519aa.OpCode = 4;
        c46519aa.URL = str;
        c46519aa.vAM = i;
        c46519aa.vAN = str2;
        c46519aa.vAO = C34189m.byt();
        c46519aa.vAL = new LinkedList();
        C7257dh c7257dh = new C7257dh();
        c7257dh.ssid = C34189m.m56059Mx("MicroMsg.FreeWifi.NetSceneAPAuth");
        c7257dh.mac = C34189m.m56060My("MicroMsg.FreeWifi.NetSceneAPAuth");
        c46519aa.vAL.add(c7257dh);
        c46519aa.vAP = C34189m.m56061Mz("MicroMsg.FreeWifi.NetSceneAPAuth");
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", Integer.valueOf(c46519aa.vAO), c7257dh.ssid, c7257dh.mac);
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", Integer.valueOf(4), str);
        AppMethodBeat.m2505o(20773);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo45999b(int i, int i2, int i3, String str) {
        AppMethodBeat.m2504i(20774);
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.czE));
        C3137c ML;
        Object obj;
        Object obj2;
        C40500ab c40500ab;
        bzt bzt;
        switch (this.czE) {
            case 0:
                if (i2 == 0 && i3 == 0) {
                    ML = C11976j.byW().mo17045ML(this.ssid);
                    String str2 = "MicroMsg.FreeWifi.NetSceneAPAuth";
                    String str3 = "get freewifi by ssid :%s, is wifi info = null ? %b";
                    Object[] objArr = new Object[2];
                    objArr[0] = this.ssid;
                    objArr[1] = Boolean.valueOf(ML == null);
                    C4990ab.m7417i(str2, str3, objArr);
                    obj = null;
                    if (ML == null) {
                        obj = 1;
                        ML = new C3137c();
                        ML.field_ssidmd5 = C4995ag.m7428ck(this.ssid);
                    }
                    obj2 = obj;
                    ML.field_wifiType = 1;
                    c40500ab = (C40500ab) this.ehh.fsH.fsP;
                    bzt = c40500ab.vAU;
                    if (bzt != null) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", bzt.wYO, bzt.wYP, bzt.wYQ);
                        ML.field_showWordCn = bzt.wYP;
                        ML.field_showWordEn = bzt.wYO;
                        ML.field_showWordTw = bzt.wYQ;
                    } else {
                        ML.field_showWordCn = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
                        ML.field_showWordEn = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
                        ML.field_showWordTw = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
                    }
                    ML.field_action = c40500ab.vAS;
                    ML.field_verifyResult = 1;
                    ML.field_connectState = -1;
                    if (c40500ab.vBc <= 0) {
                        c40500ab.vBc = mwv;
                    }
                    ML.field_expiredTime = C5046bo.anT() + ((long) c40500ab.vBc);
                    ML.field_showUrl = c40500ab.vAT;
                    ML.field_action = c40500ab.vAS;
                    ML.field_ssid = this.ssid;
                    ML.field_mac = this.mac;
                    ML.field_wifiType = 1;
                    boolean b;
                    if (obj2 != null) {
                        b = C11976j.byW().mo10101b((C4925c) ML);
                        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(b));
                        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", this.ssid, Boolean.valueOf(b), Integer.valueOf(c40500ab.vAR), Integer.valueOf(c40500ab.vAS), c40500ab.vAT);
                        AppMethodBeat.m2505o(20774);
                        return;
                    }
                    b = C11976j.byW().mo10103c(ML, new String[0]);
                    C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", this.ssid, Boolean.valueOf(b), Integer.valueOf(c40500ab.vAR), Integer.valueOf(c40500ab.vAS), c40500ab.vAT);
                    AppMethodBeat.m2505o(20774);
                    return;
                }
            case 1:
                ML = C11976j.byW().mo17045ML(this.ssid);
                obj = null;
                if (ML == null) {
                    obj = 1;
                    ML = new C3137c();
                    ML.field_ssidmd5 = C4995ag.m7428ck(this.ssid);
                }
                obj2 = obj;
                boolean a;
                if (i2 != 0 || i3 != 0) {
                    C4990ab.m7413e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", this.ssid);
                    if (obj2 == null) {
                        a = C11976j.byW().mo16760a((C4925c) ML, new String[0]);
                        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(a));
                        break;
                    }
                }
                c40500ab = (C40500ab) this.ehh.fsH.fsP;
                ML.field_ssid = this.ssid;
                ML.field_showUrl = c40500ab.vAT;
                bzt = c40500ab.vAU;
                C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", this.ssid, Integer.valueOf(c40500ab.vAR), Integer.valueOf(c40500ab.vAS), c40500ab.vAT);
                if (bzt != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", bzt.wYO, bzt.wYP, bzt.wYQ);
                    ML.field_showWordCn = bzt.wYP;
                    ML.field_showWordEn = bzt.wYO;
                    ML.field_showWordTw = bzt.wYQ;
                } else {
                    ML.field_showWordCn = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
                    ML.field_showWordEn = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
                    ML.field_showWordTw = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
                }
                ML.field_action = c40500ab.vAS;
                ML.field_verifyResult = 1;
                ML.field_connectState = -1;
                if (c40500ab.vBc <= 0) {
                    c40500ab.vBc = mwv;
                }
                ML.field_expiredTime = C5046bo.anT() + ((long) c40500ab.vBc);
                ML.field_mac = this.mac;
                if (obj2 != null) {
                    a = C11976j.byW().mo10101b((C4925c) ML);
                    C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(a));
                } else {
                    a = C11976j.byW().mo10103c(ML, new String[0]);
                    C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(a));
                }
                C11976j.byW().mo17046MM(this.ssid);
                AppMethodBeat.m2505o(20774);
                return;
                break;
        }
        AppMethodBeat.m2505o(20774);
    }

    public final String bze() {
        C40500ab c40500ab = (C40500ab) this.ehh.fsH.fsP;
        if (c40500ab != null) {
            return c40500ab.vAQ;
        }
        return null;
    }

    public final bns bzf() {
        C40500ab c40500ab = (C40500ab) this.ehh.fsH.fsP;
        if (c40500ab != null) {
            return c40500ab.vAX;
        }
        return null;
    }

    public final boolean bzg() {
        C40500ab c40500ab = (C40500ab) this.ehh.fsH.fsP;
        if (c40500ab == null || c40500ab.vAY == null) {
            return false;
        }
        if (c40500ab.vAY.vAO == 1) {
            return true;
        }
        return false;
    }

    public final acq bzh() {
        C40500ab c40500ab = (C40500ab) this.ehh.fsH.fsP;
        if (c40500ab != null) {
            return c40500ab.vAY;
        }
        return null;
    }

    public final String bzi() {
        C40500ab c40500ab = (C40500ab) this.ehh.fsH.fsP;
        if (c40500ab != null) {
            return c40500ab.vBa;
        }
        return null;
    }

    /* renamed from: Ge */
    public final String mo45998Ge() {
        C40500ab c40500ab = (C40500ab) this.ehh.fsH.fsP;
        if (c40500ab != null) {
            return c40500ab.vBb;
        }
        return null;
    }

    public final C23391gj bzj() {
        C40500ab c40500ab = (C40500ab) this.ehh.fsH.fsP;
        if (c40500ab != null) {
            return c40500ab.vAZ;
        }
        return null;
    }
}
