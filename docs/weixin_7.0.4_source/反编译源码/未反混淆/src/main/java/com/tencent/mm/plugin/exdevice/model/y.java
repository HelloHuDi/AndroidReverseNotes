package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.cjs;

public final class y extends m implements k {
    private String ceI;
    private String cws;
    public String dFl;
    private b ehh;
    private f ehi;
    private int ltJ = 0;

    public y(String str, String str2, String str3) {
        this.dFl = str3;
        this.ceI = str;
        this.cws = str2;
    }

    public final int getType() {
        return 1263;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19353);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new cjr();
        aVar.fsK = new cjs();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
        aVar.fsI = 1263;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cjr cjr = (cjr) this.ehh.fsG.fsP;
        cjr.dFl = this.dFl;
        cjr.oYp = this.ceI;
        cjr.devicetype = this.cws;
        cjr.xij = this.ltJ;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19353);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19354);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19354);
    }
}
