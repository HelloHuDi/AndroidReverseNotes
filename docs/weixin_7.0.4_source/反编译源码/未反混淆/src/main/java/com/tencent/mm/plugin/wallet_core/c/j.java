package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    private f ehi;
    private b gme;
    private boolean ttT;
    private zb ttZ;
    public zc tua;

    public j(String str, boolean z) {
        AppMethodBeat.i(46515);
        this.ttT = z;
        a aVar = new a();
        aVar.fsJ = new zb();
        aVar.fsK = new zc();
        if (z) {
            aVar.fsI = 2529;
            aVar.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";
        } else {
            aVar.fsI = 2888;
            aVar.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure";
        }
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.ttZ = (zb) this.gme.fsG.fsP;
        this.ttZ.wev = str;
        AppMethodBeat.o(46515);
    }

    public final int getType() {
        if (this.ttT) {
            return 2529;
        }
        return 2888;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46516);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(46516);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46517);
        ab.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tua = (zc) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(46517);
    }
}
