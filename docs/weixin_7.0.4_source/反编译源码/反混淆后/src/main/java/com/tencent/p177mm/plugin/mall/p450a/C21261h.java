package com.tencent.p177mm.plugin.mall.p450a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.bjf;
import com.tencent.p177mm.protocal.protobuf.bjg;
import com.tencent.p177mm.protocal.protobuf.csi;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.mall.a.h */
public final class C21261h extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public csi okW;

    public C21261h() {
        boolean booleanValue;
        AppMethodBeat.m2504i(43105);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bjf();
        c1196a.fsK = new bjg();
        c1196a.uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
        this.ehh = c1196a.acD();
        bjf bjf = (bjf) this.ehh.fsG.fsP;
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        bjf.wMs = booleanValue ? 1 : 0;
        bjf.aOt = C4988aa.dor();
        bjf.wMv = VERSION.RELEASE;
        bjf.wMu = C5059g.m7672ar(null, C7243d.vxo);
        bjf.wMw = Build.MANUFACTURER;
        C4990ab.m7417i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", Integer.valueOf(bjf.wMs), bjf.aOt, bjf.wMv, bjf.wMu, bjf.wMw);
        AppMethodBeat.m2505o(43105);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43106);
        C4990ab.m7416i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            bjg bjg = (bjg) ((C7472b) c1929q).fsH.fsP;
            if (bjg.wMz == null || bjg.wMA == null) {
                C4990ab.m7416i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + bjg.okT);
            } else {
                C4990ab.m7417i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", Integer.valueOf(bjg.okT), Integer.valueOf(bjg.wMz.wmz.size()), Integer.valueOf(bjg.wMA.wmz.size()));
                if (bjg.wMD != null) {
                    this.okW = bjg.wMD;
                    C4990ab.m7417i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", Integer.valueOf(bjg.wMD.xpH), bjg.wMD.url);
                }
            }
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(bjg.okT));
            C14241r.cPO().mo38096a(bjg.okT, bjg);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43106);
    }

    public final String bMU() {
        if (this.okW == null) {
            return "";
        }
        return this.okW.url;
    }

    public final int getType() {
        return 1577;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43107);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43107);
        return a;
    }
}
