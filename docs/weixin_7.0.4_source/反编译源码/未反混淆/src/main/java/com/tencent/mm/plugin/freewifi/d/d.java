package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.protocal.protobuf.rf;

public final class d extends c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20779);
        a aVar = new a();
        aVar.fsJ = new re();
        aVar.fsK = new rf();
        aVar.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
        aVar.fsI = 1155;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20779);
    }

    public final int getType() {
        return 1155;
    }

    public d(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        AppMethodBeat.i(20780);
        bzd();
        re reVar = (re) this.ehh.fsG.fsP;
        reVar.vYm = str;
        reVar.vYn = str2;
        reVar.vYo = str3;
        reVar.vYp = str4;
        reVar.vYq = str5;
        reVar.vYr = j;
        reVar.vYs = str6;
        reVar.vYt = str7;
        AppMethodBeat.o(20780);
    }

    public final rf bzk() {
        return (rf) this.ehh.fsH.fsP;
    }
}
