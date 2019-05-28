package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.freewifi.C11963i.C11964a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C45955h.C39112b;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.protocal.protobuf.C15315ad;
import com.tencent.p177mm.protocal.protobuf.C46520ac;
import com.tencent.p177mm.protocal.protobuf.C7257dh;
import com.tencent.p177mm.protocal.protobuf.bzt;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.freewifi.d.b */
public final class C44737b extends C43104c {
    private static int mwv = 7200;
    public String mac;
    private String ssid;

    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20775);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46520ac();
        c1196a.fsK = new C15315ad();
        c1196a.uri = "/cgi-bin/mmo2o-bin/apcheck";
        c1196a.fsI = 1744;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20775);
    }

    public final int getType() {
        return 1744;
    }

    public C44737b(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(20776);
        bzd();
        this.ssid = str2;
        this.mac = str;
        LinkedList linkedList = new LinkedList();
        C7257dh c7257dh = new C7257dh();
        c7257dh.ssid = str2;
        c7257dh.mac = str;
        c7257dh.vFl = i;
        linkedList.add(c7257dh);
        C46520ac c46520ac = (C46520ac) this.ehh.fsG.fsP;
        c46520ac.vBd = C39112b.mtY.byg();
        c46520ac.vAL = linkedList;
        c46520ac.vBe = C34189m.byv();
        c46520ac.vBf = i2;
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", str, str2, Integer.valueOf(i));
        AppMethodBeat.m2505o(20776);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo45999b(int i, int i2, int i3, String str) {
        C15315ad c15315ad;
        boolean z;
        AppMethodBeat.m2504i(20777);
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!(this.ehh == null || this.ehh.fsH.fsP == null)) {
            C39112b.mtY.mo73808a((C15315ad) this.ehh.fsH.fsP);
            if (C34189m.m56074eg(i2, i3) || C34189m.m56075eh(i2, i3)) {
                c15315ad = (C15315ad) this.ehh.fsH.fsP;
                int i4 = c15315ad.vBi;
                z = c15315ad.vBh;
                if (!(i4 == 0 || i4 == C11964a.mtZ.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
                    C11964a.mtZ.mo23806ch("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", i4);
                }
                if (z) {
                    C11964a.mtZ.mo23805F("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
                }
            }
        }
        C3137c ML = C11976j.byW().mo17045ML(this.ssid);
        Object obj = null;
        if (ML == null) {
            obj = 1;
            ML = new C3137c();
            ML.field_ssidmd5 = C4995ag.m7428ck(this.ssid);
        }
        Object obj2 = obj;
        if (i2 == 0 && i3 == 0) {
            c15315ad = (C15315ad) this.ehh.fsH.fsP;
            ML.field_ssid = this.ssid;
            ML.field_showUrl = c15315ad.vAT;
            bzt bzt = c15315ad.vAU;
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
            ML.field_action = c15315ad.vAS;
            ML.field_verifyResult = 1;
            ML.field_connectState = -1;
            if (c15315ad.vBc <= 0) {
                c15315ad.vBc = mwv;
            }
            ML.field_expiredTime = C5046bo.anT() + ((long) c15315ad.vBc);
            ML.field_mac = this.mac;
            if (obj2 != null) {
                z = C11976j.byW().mo10101b((C4925c) ML);
                C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(z));
            } else {
                z = C11976j.byW().mo10103c(ML, new String[0]);
                C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(z));
            }
            C11976j.byW().mo17046MM(this.ssid);
            AppMethodBeat.m2505o(20777);
            return;
        }
        C4990ab.m7413e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", this.ssid);
        if (obj2 == null) {
            z = C11976j.byW().mo16760a((C4925c) ML, new String[0]);
            C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(20777);
    }
}
