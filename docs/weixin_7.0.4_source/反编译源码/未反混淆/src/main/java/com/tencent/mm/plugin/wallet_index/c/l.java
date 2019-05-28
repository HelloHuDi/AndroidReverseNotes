package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class l extends u {
    public String cwg;
    private b ehh;
    private f ehi;
    public int errCode;

    public l(int i, int i2, String str, aui aui, auh auh) {
        AppMethodBeat.i(48192);
        a aVar = new a();
        aVar.fsJ = new cmo();
        aVar.fsK = new cmp();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
        this.ehh = aVar.acD();
        cmo cmo = (cmo) this.ehh.fsG.fsP;
        cmo.wlY = i;
        cmo.cHG = i2;
        this.cwg = str;
        cmo.wme = aui;
        cmo.wmd = auh;
        AppMethodBeat.o(48192);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48193);
        ab.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            cmp cmp = (cmp) this.ehh.fsH.fsP;
            ab.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + cmp.cCJ + ",errMsg:" + cmp.cCK);
            this.ehi.onSceneEnd(i, cmp.cCJ, str, this);
            AppMethodBeat.o(48193);
            return;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(48193);
    }

    public final int getType() {
        return 1306;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48194);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48194);
        return a;
    }
}
