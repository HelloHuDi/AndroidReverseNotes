package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.c.u;

public final class b extends u {
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    public String jumpUrl;
    public int tuH = 0;

    public b() {
        boolean booleanValue;
        int i;
        AppMethodBeat.i(46563);
        a aVar = new a();
        bjd bjd = new bjd();
        g.RQ();
        Object obj = g.RP().Ry().get(ac.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        if (booleanValue) {
            i = 1;
        } else {
            i = 0;
        }
        bjd.wMs = i;
        aVar.fsJ = bjd;
        aVar.fsK = new bje();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        aVar.fsI = 1564;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(46563);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(46564);
        ab.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        bje bje = (bje) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(bje.luT), bje.luU);
            str = bje.luU;
            i2 = bje.luT;
            this.jumpUrl = bje.mZj;
            this.tuH = bje.wMt;
        } else {
            ab.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
            this.jumpUrl = null;
        }
        if (bo.isNullOrNil(str)) {
            str = ah.getContext().getString(R.string.fdx);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(46564);
    }

    public final int getType() {
        return 1564;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46565);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46565);
        return a;
    }
}
