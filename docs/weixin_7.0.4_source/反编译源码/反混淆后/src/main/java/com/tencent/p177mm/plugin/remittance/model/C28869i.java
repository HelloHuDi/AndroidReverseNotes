package com.tencent.p177mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C37719fw;
import com.tencent.p177mm.plugin.soter.p528d.C13720d;
import com.tencent.p177mm.plugin.soter.p528d.C29254e;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.protocal.protobuf.C30202lu;
import com.tencent.p177mm.protocal.protobuf.C44143lv;
import com.tencent.p177mm.protocal.protobuf.abv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.wallet_core.p649c.C24144d;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.p649c.C44430q;
import java.net.URLDecoder;

/* renamed from: com.tencent.mm.plugin.remittance.model.i */
public final class C28869i extends C1207m implements C1918k, C44426i {
    private C1202f ehi;
    public C7472b gme;
    public C44143lv pOT;
    public String pOU;
    public C37719fw pOV = null;

    public C28869i(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6, int i4, int i5, String str7, abv abv, String str8, int i6, String str9, String str10, String str11, String str12, String str13, int i7, int i8) {
        AppMethodBeat.m2504i(44738);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30202lu();
        c1196a.fsK = new C44143lv();
        c1196a.fsI = 1633;
        c1196a.uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C29254e cvQ = C13720d.cvQ();
        String str14 = cvQ.rOh;
        String str15 = cvQ.jSY;
        this.pOU = str9;
        this.gme = c1196a.acD();
        C30202lu c30202lu = (C30202lu) this.gme.fsG.fsP;
        c30202lu.pPZ = str;
        c30202lu.vPp = URLDecoder.decode(str2);
        c30202lu.scene = i;
        c30202lu.vPq = str3;
        c30202lu.pPT = str4;
        c30202lu.vFg = i2;
        c30202lu.cIb = i3;
        c30202lu.pPU = str5;
        c30202lu.pQa = str6;
        c30202lu.pPY = i4;
        c30202lu.vPx = str13;
        c30202lu.vPz = i8;
        c30202lu.vFf = str7;
        if (abv != null) {
            c30202lu.vFe = abv;
        }
        c30202lu.vPj = str8;
        c30202lu.pOA = i6;
        if (i5 == 1) {
            WifiInfo wifiInfo = C5023at.getWifiInfo(C4996ah.getContext());
            if (wifiInfo != null) {
                c30202lu.vPr = wifiInfo.getBSSID();
            } else {
                C4990ab.m7420w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
            }
            c30202lu.vPs = 0;
        }
        c30202lu.rOh = str14;
        c30202lu.jSY = str15;
        c30202lu.vPu = C14241r.cPI().cQk();
        C1720g.m3528K(C30052l.class);
        c30202lu.vPt = false;
        c30202lu.vPv = str9;
        c30202lu.pPW = str10;
        c30202lu.nickname = str11;
        c30202lu.vPy = i7;
        c30202lu.pPw = str12;
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", str9);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), str2, Integer.valueOf(i5), C28868a.m45884a(abv), str9, str13, Integer.valueOf(i8), Integer.valueOf(i7));
        AppMethodBeat.m2505o(44738);
    }

    public final int getType() {
        return 1633;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44739);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44739);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44740);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOT = (C44143lv) ((C7472b) c1929q).fsH.fsP;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("trans_id: %s,", new Object[]{this.pOT.vFc}));
        stringBuffer.append(String.format("zero_pay_flag: %s,", new Object[]{Integer.valueOf(this.pOT.vPF)}));
        stringBuffer.append(String.format("can_use_fingerprint: %s,", new Object[]{Integer.valueOf(this.pOT.vPL)}));
        stringBuffer.append(String.format("payer_need_auth_flag: %s,", new Object[]{Integer.valueOf(this.pOT.vPG)}));
        C24144d c24144d = new C24144d(i2, i3, str);
        C44430q.m80322a(i2, i3, str, c24144d);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", Integer.valueOf(this.pOT.kdT), this.pOT.kdU, this.pOT.vFc, this.pOT.vFb, Integer.valueOf(this.pOT.vPE), this.pOT.vFd, this.pOT.cBT, stringBuffer.toString());
        if (this.ehi != null) {
            this.ehi.onSceneEnd(c24144d.errType, c24144d.errCode, c24144d.aIm, this);
        }
        AppMethodBeat.m2505o(44740);
    }
}
