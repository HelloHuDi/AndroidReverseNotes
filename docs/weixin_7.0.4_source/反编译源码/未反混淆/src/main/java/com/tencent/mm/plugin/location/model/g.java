package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends m implements k {
    public final b ehh;
    private f ehi;
    private byte[] nJF;
    String nJG;

    public g(float f, float f2, int i, int i2, int i3, String str, String str2) {
        AppMethodBeat.i(113312);
        a aVar = new a();
        aVar.fsJ = new akj();
        aVar.fsK = new akk();
        aVar.uri = "/cgi-bin/micromsg-bin/getlocimg";
        this.ehh = aVar.acD();
        akj akj = (akj) this.ehh.fsG.fsP;
        akj.luQ = str2;
        if (bo.gT(ah.getContext())) {
            akj.wqd = 1;
        } else {
            akj.wqd = 0;
        }
        akj.vRq = f;
        akj.vRp = f2;
        akj.wqe = i;
        ab.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", Integer.valueOf(i2), Integer.valueOf(i3));
        while (i2 * i3 > 270000) {
            i2 = (int) (((double) i2) / 1.2d);
            i3 = (int) (((double) i3) / 1.2d);
        }
        ab.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), akj.luQ);
        akj.Height = i3;
        akj.Width = i2;
        this.nJG = str;
        AppMethodBeat.o(113312);
    }

    public final int getType() {
        return 648;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(113313);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(113313);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(113314);
        ab.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        try {
            this.nJF = ((akk) ((b) qVar).fsH.fsP).vEF.getBuffer().wR;
            com.tencent.mm.vfs.e.b(this.nJG, this.nJF, this.nJF.length);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneGetLocImg", e, "", new Object[0]);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(113314);
    }
}
