package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;

public final class i extends c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20791);
        a aVar = new a();
        aVar.fsJ = new amm();
        aVar.fsK = new amn();
        aVar.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
        aVar.fsI = 1709;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20791);
    }

    public final int getType() {
        return 1709;
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(20792);
        bzd();
        amm amm = (amm) this.ehh.fsG.fsP;
        amm.cuH = str;
        amm.mvO = str2;
        amm.mvP = str3;
        amm.mvQ = str4;
        amm.cxb = str5;
        amm.vAN = str6;
        AppMethodBeat.o(20792);
    }

    public final String bzn() {
        return ((amn) this.ehh.fsH.fsP).mwV;
    }

    public final String bzo() {
        return ((amn) this.ehh.fsH.fsP).mwW;
    }
}
