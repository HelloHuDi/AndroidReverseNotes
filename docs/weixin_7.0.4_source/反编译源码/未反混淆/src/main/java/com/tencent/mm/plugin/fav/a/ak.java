package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.sdk.platformtools.ab;

public final class ak extends m implements k {
    private final b ehh;
    private f ehi = null;

    public ak() {
        AppMethodBeat.i(102740);
        a aVar = new a();
        aVar.fsJ = new aix();
        aVar.fsK = new aiy();
        aVar.uri = "/cgi-bin/micromsg-bin/getfavinfo";
        aVar.fsI = 438;
        aVar.fsL = 217;
        aVar.fsM = 1000000217;
        this.ehh = aVar.acD();
        AppMethodBeat.o(102740);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102741);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102741);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102742);
        ab.d("MicroMsg.NetSceneGetFavInfo", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            aiy aiy = (aiy) ((b) qVar).fsH.fsP;
            ab.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", Long.valueOf(aiy.vEw), Long.valueOf(aiy.jBS), Integer.valueOf(aiy.woT), Integer.valueOf(aiy.woS), Integer.valueOf(aiy.woR));
            b.in(aiy.vEw);
            b.io(aiy.jBS);
            b.iq((long) aiy.woT);
            b.ir((long) aiy.woS);
            b.is((long) aiy.woR);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(102742);
    }

    public final int getType() {
        return 438;
    }
}
