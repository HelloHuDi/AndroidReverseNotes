package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    public int czE;
    private f ehi;
    private final com.tencent.mm.ai.b fAT;

    public b(int i) {
        AppMethodBeat.i(26494);
        this.czE = i;
        a aVar = new a();
        zg zgVar = new zg();
        zh zhVar = new zh();
        aVar.fsJ = zgVar;
        aVar.fsK = zhVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
        zgVar.nbk = i;
        zgVar.weF = 1;
        this.fAT = aVar.acD();
        AppMethodBeat.o(26494);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26495);
        ab.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(26495);
    }

    public final int getType() {
        return 792;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26496);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(26496);
        return a;
    }
}
