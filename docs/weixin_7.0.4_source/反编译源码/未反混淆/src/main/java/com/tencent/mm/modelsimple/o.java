package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class o extends m implements k {
    private f ehi;
    public final b fmP;

    public o() {
        AppMethodBeat.i(16594);
        a aVar = new a();
        aVar.fsJ = new ant();
        aVar.fsK = new anu();
        aVar.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
        this.fmP = aVar.acD();
        ((ant) this.fmP.fsG.fsP).jCt = 0;
        ab.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", Integer.valueOf(0), bo.dpG());
        AppMethodBeat.o(16594);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16595);
        ab.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            h.pYm.a(405, 2, 1, true);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16595);
    }

    public final int getType() {
        return 725;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16596);
        this.ehi = fVar;
        h.pYm.a(405, 1, 1, true);
        int a = a(eVar, this.fmP, this);
        AppMethodBeat.o(16596);
        return a;
    }
}
