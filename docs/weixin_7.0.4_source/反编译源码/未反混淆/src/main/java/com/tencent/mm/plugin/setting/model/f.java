package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.apl;

public final class f extends m implements k {
    private com.tencent.mm.ai.f ehi;
    public apl qjE;
    public byte[] qjF;

    public f(byte[] bArr) {
        this.qjF = bArr;
    }

    public final int getType() {
        return 1146;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(126849);
        this.ehi = fVar;
        a aVar = new a();
        apk apk = new apk();
        if (this.qjF != null) {
            apk.wtt = aa.ad(this.qjF).getBuffer();
        }
        aVar.fsJ = apk;
        this.qjE = new apl();
        aVar.fsK = this.qjE;
        aVar.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
        aVar.fsI = 1146;
        aVar.fsL = 0;
        aVar.fsM = 0;
        int a = a(eVar, aVar.acD(), this);
        AppMethodBeat.o(126849);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126850);
        this.qjE = (apl) ((b) qVar).fsH.fsP;
        if (this.qjE.wcK != null) {
            i3 = this.qjE.wcK.cyE;
            str = this.qjE.wcK.cyF;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(126850);
    }
}
