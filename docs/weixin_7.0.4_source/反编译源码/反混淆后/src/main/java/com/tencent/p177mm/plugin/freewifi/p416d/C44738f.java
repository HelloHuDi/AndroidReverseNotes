package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.protocal.protobuf.C7257dh;
import com.tencent.p177mm.protocal.protobuf.aer;
import com.tencent.p177mm.protocal.protobuf.aes;
import com.tencent.p177mm.protocal.protobuf.bzt;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.freewifi.d.f */
public final class C44738f extends C43104c {
    private static int mwv = 7200;
    private String mac;
    private String ssid;

    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20784);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aer();
        c1196a.fsK = new aes();
        c1196a.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
        c1196a.fsI = 1726;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20784);
    }

    public final int getType() {
        return 1726;
    }

    public C44738f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.m2504i(20785);
        bzd();
        this.ssid = str;
        this.mac = str2;
        C7257dh c7257dh = new C7257dh();
        c7257dh.mac = str2;
        c7257dh.ssid = str;
        aer aer = (aer) this.ehh.fsG.fsP;
        aer.appId = str3;
        aer.mwU = str4;
        aer.mwV = str5;
        aer.mwW = str6;
        aer.cvO = str7;
        aer.sign = str8;
        aer.wmv = c7257dh;
        AppMethodBeat.m2505o(20785);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo45999b(int i, int i2, int i3, String str) {
        AppMethodBeat.m2504i(20786);
        C3137c ML = C11976j.byW().mo17045ML(this.ssid);
        Object obj = null;
        if (ML == null) {
            obj = 1;
            ML = new C3137c();
            ML.field_ssidmd5 = C4995ag.m7428ck(this.ssid);
        }
        Object obj2 = obj;
        boolean b;
        if (i2 == 0 && i3 == 0) {
            aes aes = (aes) this.ehh.fsH.fsP;
            ML.field_ssid = this.ssid;
            ML.field_showUrl = aes.vAT;
            bzt bzt = aes.vAU;
            if (bzt != null) {
                C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", bzt.wYO, bzt.wYP, bzt.wYQ);
                ML.field_showWordCn = bzt.wYP;
                ML.field_showWordEn = bzt.wYO;
                ML.field_showWordTw = bzt.wYQ;
            } else {
                ML.field_showWordCn = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
                ML.field_showWordEn = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
                ML.field_showWordTw = C4996ah.getContext().getResources().getString(C25738R.string.c0y);
            }
            ML.field_action = aes.vAS;
            ML.field_verifyResult = 1;
            ML.field_connectState = -1;
            if (aes.vBc <= 0) {
                aes.vBc = mwv;
            }
            ML.field_expiredTime = C5046bo.anT() + ((long) aes.vBc);
            ML.field_mac = this.mac;
            if (obj2 != null) {
                b = C11976j.byW().mo10101b((C4925c) ML);
                C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", Boolean.valueOf(b));
            } else {
                b = C11976j.byW().mo10103c(ML, new String[0]);
                C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", Boolean.valueOf(b));
            }
            C11976j.byW().mo17046MM(this.ssid);
            AppMethodBeat.m2505o(20786);
            return;
        }
        C4990ab.m7413e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", this.ssid);
        if (obj2 == null) {
            b = C11976j.byW().mo16760a((C4925c) ML, new String[0]);
            C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(b));
        }
        AppMethodBeat.m2505o(20786);
    }

    public final C23391gj bzj() {
        return ((aes) this.ehh.fsH.fsP).mzh;
    }
}
