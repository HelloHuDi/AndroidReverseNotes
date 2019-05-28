package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajw;

public final class g extends c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20787);
        a aVar = new a();
        aVar.fsJ = new ajv();
        aVar.fsK = new ajw();
        aVar.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
        aVar.fsI = 1746;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20787);
    }

    public final int getType() {
        return 1746;
    }

    public g(String str, String str2, String str3) {
        AppMethodBeat.i(20788);
        bzd();
        ajv ajv = (ajv) this.ehh.fsG.fsP;
        ajv.mvO = str;
        ajv.mvP = str2;
        ajv.mvQ = str3;
        ajv.vBe = m.byv();
        AppMethodBeat.o(20788);
    }

    public final String bzm() {
        return ((ajw) this.ehh.fsH.fsP).wpv;
    }
}
