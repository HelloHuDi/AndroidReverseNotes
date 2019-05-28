package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.net.URLDecoder;

public final class i extends m implements k, com.tencent.mm.wallet_core.c.i {
    private f ehi;
    public b gme;
    public lv pOT;
    public String pOU;
    public fw pOV = null;

    public i(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6, int i4, int i5, String str7, abv abv, String str8, int i6, String str9, String str10, String str11, String str12, String str13, int i7, int i8) {
        AppMethodBeat.i(44738);
        a aVar = new a();
        aVar.fsJ = new lu();
        aVar.fsK = new lv();
        aVar.fsI = 1633;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
        aVar.fsL = 0;
        aVar.fsM = 0;
        e cvQ = d.cvQ();
        String str14 = cvQ.rOh;
        String str15 = cvQ.jSY;
        this.pOU = str9;
        this.gme = aVar.acD();
        lu luVar = (lu) this.gme.fsG.fsP;
        luVar.pPZ = str;
        luVar.vPp = URLDecoder.decode(str2);
        luVar.scene = i;
        luVar.vPq = str3;
        luVar.pPT = str4;
        luVar.vFg = i2;
        luVar.cIb = i3;
        luVar.pPU = str5;
        luVar.pQa = str6;
        luVar.pPY = i4;
        luVar.vPx = str13;
        luVar.vPz = i8;
        luVar.vFf = str7;
        if (abv != null) {
            luVar.vFe = abv;
        }
        luVar.vPj = str8;
        luVar.pOA = i6;
        if (i5 == 1) {
            WifiInfo wifiInfo = at.getWifiInfo(ah.getContext());
            if (wifiInfo != null) {
                luVar.vPr = wifiInfo.getBSSID();
            } else {
                ab.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
            }
            luVar.vPs = 0;
        }
        luVar.rOh = str14;
        luVar.jSY = str15;
        luVar.vPu = r.cPI().cQk();
        g.K(l.class);
        luVar.vPt = false;
        luVar.vPv = str9;
        luVar.pPW = str10;
        luVar.nickname = str11;
        luVar.vPy = i7;
        luVar.pPw = str12;
        ab.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", str9);
        ab.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), str2, Integer.valueOf(i5), a.a(abv), str9, str13, Integer.valueOf(i8), Integer.valueOf(i7));
        AppMethodBeat.o(44738);
    }

    public final int getType() {
        return 1633;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(44739);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44739);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44740);
        ab.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOT = (lv) ((b) qVar).fsH.fsP;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("trans_id: %s,", new Object[]{this.pOT.vFc}));
        stringBuffer.append(String.format("zero_pay_flag: %s,", new Object[]{Integer.valueOf(this.pOT.vPF)}));
        stringBuffer.append(String.format("can_use_fingerprint: %s,", new Object[]{Integer.valueOf(this.pOT.vPL)}));
        stringBuffer.append(String.format("payer_need_auth_flag: %s,", new Object[]{Integer.valueOf(this.pOT.vPG)}));
        com.tencent.mm.wallet_core.c.d dVar = new com.tencent.mm.wallet_core.c.d(i2, i3, str);
        com.tencent.mm.wallet_core.c.q.a(i2, i3, str, dVar);
        ab.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", Integer.valueOf(this.pOT.kdT), this.pOT.kdU, this.pOT.vFc, this.pOT.vFb, Integer.valueOf(this.pOT.vPE), this.pOT.vFd, this.pOT.cBT, stringBuffer.toString());
        if (this.ehi != null) {
            this.ehi.onSceneEnd(dVar.errType, dVar.errCode, dVar.aIm, this);
        }
        AppMethodBeat.o(44740);
    }
}
