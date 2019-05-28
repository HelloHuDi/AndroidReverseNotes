package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.am;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    public String aIm;
    public final b ehh;
    private f ehi;
    public alp pkG;

    public a(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(23281);
        ab.i("MicroMsg.NetSceneGetOpenUrl", "NetSceneGetOpenUrl username:%s ticket:%s climsgid:%s content:%s ", str, str2, str3, str4);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenurl";
        aVar.fsJ = new alo();
        aVar.fsK = new alp();
        this.ehh = aVar.acD();
        alo alo = (alo) this.ehh.fsG.fsP;
        alo.scene = 1;
        am amVar = new am();
        amVar.username = str;
        amVar.cxb = str2;
        amVar.pkI = str3;
        amVar.content = str4;
        alo.wqQ = amVar;
        AppMethodBeat.o(23281);
    }

    public final int getType() {
        return 913;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(23282);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(23282);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(23283);
        ab.d("MicroMsg.NetSceneGetOpenUrl", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        this.aIm = str;
        AppMethodBeat.o(23283);
    }
}
