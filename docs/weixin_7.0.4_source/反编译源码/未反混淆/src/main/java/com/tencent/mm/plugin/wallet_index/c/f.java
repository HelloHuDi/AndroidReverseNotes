package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class f extends u {
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    public int errCode;
    public auh tRe;
    public aui tRf;

    public f(int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(48184);
        a aVar = new a();
        aVar.fsJ = new aea();
        aVar.fsK = new aeb();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
        this.ehh = aVar.acD();
        aea aea = (aea) this.ehh.fsG.fsP;
        aea.csB = str;
        aea.wlY = i;
        aea.wlZ = Integer.parseInt(str2);
        aea.desc = str3;
        aea.count = i2;
        aea.scene = 13;
        aea.wma = str4;
        aea.wmb = str5;
        aea.sign = str6;
        aea.wmc = str7;
        AppMethodBeat.o(48184);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48185);
        ab.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            aeb aeb = (aeb) this.ehh.fsH.fsP;
            ab.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + aeb.cCJ + ",errMsg:" + aeb.cCK);
            int i3 = aeb.cCJ;
            String str2 = aeb.cCK;
            if (i3 == 0) {
                this.tRe = aeb.wmd;
                this.tRf = aeb.wme;
            }
            this.ehi.onSceneEnd(i, i3, str2, this);
            AppMethodBeat.o(48185);
            return;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(48185);
    }

    public final int getType() {
        return 1130;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(48186);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48186);
        return a;
    }
}
