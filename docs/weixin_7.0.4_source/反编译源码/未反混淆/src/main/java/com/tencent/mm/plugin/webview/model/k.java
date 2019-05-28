package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class k extends m implements com.tencent.mm.network.k {
    private f ehi;
    public final b lty;

    public k(String str, String str2) {
        AppMethodBeat.i(6595);
        a aVar = new a();
        aVar.fsJ = new ael();
        aVar.fsK = new aem();
        aVar.uri = "/cgi-bin/mmbiz-bin/getappticket";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI;
        this.lty = aVar.acD();
        ael ael = (ael) this.lty.fsG.fsP;
        ael.csB = str;
        ael.signature = str2;
        AppMethodBeat.o(6595);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6596);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(6596);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6597);
        ab.i("MicroMsg.NetSceneGetAppTicket", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6597);
    }
}
