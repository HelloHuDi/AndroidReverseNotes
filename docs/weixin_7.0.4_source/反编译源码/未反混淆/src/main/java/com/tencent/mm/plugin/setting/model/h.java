package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bcp;

public final class h extends m implements k {
    private final String csB;
    private f ehi;
    public final String qjG;
    public final int qjH;
    private final int scene;

    public h(String str, String str2, int i, int i2) {
        this.csB = str;
        this.qjG = str2;
        this.qjH = i;
        this.scene = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126854);
        bcp bcp = (bcp) ((b) qVar).fsH.fsP;
        this.ehi.onSceneEnd(i2, bcp.wcK.cyE, bcp.wcK.cyF, this);
        AppMethodBeat.o(126854);
    }

    public final int getType() {
        return 1144;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(126855);
        this.ehi = fVar;
        a aVar = new a();
        bco bco = new bco();
        bco.csB = this.csB;
        bco.wGP = this.qjG;
        bco.wGQ = this.qjH;
        aVar.fsJ = bco;
        aVar.uri = "/cgi-bin/mmbiz-bin/moduserauth";
        aVar.fsK = new bcp();
        aVar.fsI = 1144;
        aVar.fsL = 0;
        aVar.fsM = 0;
        int a = a(eVar, aVar.acD(), this);
        AppMethodBeat.o(126855);
        return a;
    }
}
