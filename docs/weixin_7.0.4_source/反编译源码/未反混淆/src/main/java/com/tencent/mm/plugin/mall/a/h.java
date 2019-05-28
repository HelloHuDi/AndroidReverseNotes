package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public final class h extends m implements k {
    private b ehh;
    private f ehi;
    public csi okW;

    public h() {
        boolean booleanValue;
        AppMethodBeat.i(43105);
        a aVar = new a();
        aVar.fsJ = new bjf();
        aVar.fsK = new bjg();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
        this.ehh = aVar.acD();
        bjf bjf = (bjf) this.ehh.fsG.fsP;
        g.RQ();
        Object obj = g.RP().Ry().get(ac.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        bjf.wMs = booleanValue ? 1 : 0;
        bjf.aOt = aa.dor();
        bjf.wMv = VERSION.RELEASE;
        bjf.wMu = com.tencent.mm.sdk.platformtools.g.ar(null, d.vxo);
        bjf.wMw = Build.MANUFACTURER;
        ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", Integer.valueOf(bjf.wMs), bjf.aOt, bjf.wMv, bjf.wMu, bjf.wMw);
        AppMethodBeat.o(43105);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43106);
        ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            bjg bjg = (bjg) ((b) qVar).fsH.fsP;
            if (bjg.wMz == null || bjg.wMA == null) {
                ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + bjg.okT);
            } else {
                ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", Integer.valueOf(bjg.okT), Integer.valueOf(bjg.wMz.wmz.size()), Integer.valueOf(bjg.wMA.wmz.size()));
                if (bjg.wMD != null) {
                    this.okW = bjg.wMD;
                    ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", Integer.valueOf(bjg.wMD.xpH), bjg.wMD.url);
                }
            }
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(bjg.okT));
            r.cPO().a(bjg.okT, bjg);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43106);
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

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43107);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43107);
        return a;
    }
}
