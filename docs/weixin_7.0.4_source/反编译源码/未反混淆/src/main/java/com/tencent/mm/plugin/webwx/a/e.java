package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.protocal.protobuf.zp;

public final class e extends m implements k {
    private f ehi;
    public final b fAT;
    public boolean uLe;

    public e(String str, String str2, boolean z) {
        AppMethodBeat.i(26503);
        this.uLe = z;
        a aVar = new a();
        zo zoVar = new zo();
        zp zpVar = new zp();
        aVar.fsJ = zoVar;
        aVar.fsK = zpVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        zoVar.weG = str;
        zoVar.weR = str2;
        zoVar.weT = z;
        this.fAT = aVar.acD();
        AppMethodBeat.o(26503);
    }

    public final int getType() {
        return 972;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(26504);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(26504);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26505);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26505);
    }
}
