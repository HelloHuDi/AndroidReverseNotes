package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class v extends m implements k {
    private b ehh;
    private f ehi;
    public int opType;

    public v(int i, String str) {
        AppMethodBeat.i(108418);
        this.opType = i;
        a aVar = new a();
        aVar.fsJ = new aad();
        aVar.fsK = new aae();
        aVar.uri = "/cgi-bin/micromsg-bin/facebookauth";
        this.ehh = aVar.acD();
        aad aad = (aad) this.ehh.fsG.fsP;
        if (bo.isNullOrNil(str)) {
            str = "";
        }
        aad.wfk = str;
        aad.nbk = i;
        AppMethodBeat.o(108418);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108419);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108419);
        return a;
    }

    public final int getType() {
        return 183;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108420);
        ab.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            aae aae = (aae) this.ehh.fsH.fsP;
            int i4 = aae.getBaseResponse().Ret;
            if (i4 != 0) {
                ab.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(i4)));
                this.ehi.onSceneEnd(4, i4, str, this);
                AppMethodBeat.o(108420);
                return;
            }
            ab.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + aae.wfm + ", fbusername = " + aae.wfn);
            if (this.opType == 0 || this.opType == 1) {
                g.RP().Ry().set(65825, aae.wfm);
                com.tencent.mm.ah.b.pR(aae.wfm);
                g.RP().Ry().set(65826, aae.wfn);
                g.RP().Ry().dsb();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108420);
    }
}
