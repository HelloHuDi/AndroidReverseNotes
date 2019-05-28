package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ci.f;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.bo;

public final class d extends a<arc> {
    public final b ehh;

    public d(String str, int i, String str2, int i2, int i3) {
        arb arb = new arb();
        arb.vOP = i;
        arb.csB = str;
        arb.wuL = str2;
        arb.wtb = i2;
        arb.wuM = i3;
        this(arb);
        AppMethodBeat.i(59428);
        AppMethodBeat.o(59428);
    }

    public d(arb arb) {
        AppMethodBeat.i(59429);
        b.a aVar = new b.a();
        aVar.fsI = 1139;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl";
        aVar.fsJ = arb;
        aVar.fsK = new arc();
        b acD = aVar.acD();
        this.ehh = acD;
        this.ehh = acD;
        AppMethodBeat.o(59429);
    }

    public d(String str, int i, String str2, int i2) {
        this(str, i, str2, i2, 0);
    }

    public final synchronized f<a.a<arc>> acy() {
        f b;
        AppMethodBeat.i(59430);
        final long anU = bo.anU();
        b = super.acy().b(new com.tencent.mm.vending.c.a<a.a<arc>, a.a<arc>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(59427);
                a.a aVar = (a.a) obj;
                vx vxVar = new vx();
                vxVar.cTe.cTf = d.this;
                vxVar.cTe.cTh = anU;
                vxVar.cTe.bZJ = bo.anU();
                vxVar.cTe.cTg = aVar;
                com.tencent.mm.sdk.b.a.xxA.m(vxVar);
                AppMethodBeat.o(59427);
                return aVar;
            }
        });
        AppMethodBeat.o(59430);
        return b;
    }

    public final int avn() {
        return ((arb) this.ehh.fsG.fsP).wtb;
    }
}
