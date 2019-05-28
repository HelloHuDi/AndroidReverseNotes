package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.bvs;

public final class i extends m implements k {
    private String ctj;
    private f ehi;
    public byte[] qjF;
    public bvs qjI;

    public i(String str) {
        this.ctj = str;
    }

    public i(byte[] bArr) {
        this.qjF = bArr;
    }

    public final int getType() {
        return 1169;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(126856);
        this.ehi = fVar;
        a aVar = new a();
        bvr bvr = new bvr();
        bvr.ctj = this.ctj;
        if (this.qjF != null) {
            bvr.wtt = aa.ad(this.qjF).getBuffer();
        }
        aVar.fsJ = bvr;
        aVar.fsK = new bvs();
        aVar.fsI = 1169;
        aVar.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
        aVar.fsL = 0;
        aVar.fsM = 0;
        int a = a(eVar, aVar.acD(), this);
        AppMethodBeat.o(126856);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126857);
        this.qjI = (bvs) ((b) qVar).fsH.fsP;
        if (this.qjI.wcK != null) {
            i3 = this.qjI.wcK.cyE;
            str = this.qjI.wcK.cyF;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(126857);
    }
}
