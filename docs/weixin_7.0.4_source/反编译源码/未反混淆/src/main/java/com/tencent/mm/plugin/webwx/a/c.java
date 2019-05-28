package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.protocal.protobuf.zj;

public final class c extends m implements k {
    private f ehi;
    private final b fAT;

    public c(String str) {
        AppMethodBeat.i(26497);
        a aVar = new a();
        zi ziVar = new zi();
        zj zjVar = new zj();
        aVar.fsJ = ziVar;
        aVar.fsK = zjVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        ziVar.weG = str;
        this.fAT = aVar.acD();
        AppMethodBeat.o(26497);
    }

    public final int getType() {
        return 973;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26498);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(26498);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26499);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26499);
    }
}
