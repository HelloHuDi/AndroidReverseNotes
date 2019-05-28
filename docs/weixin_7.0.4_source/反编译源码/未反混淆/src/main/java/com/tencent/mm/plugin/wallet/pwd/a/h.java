package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends m implements k {
    private final b ehh;
    private f ehi;
    private byi tqA;
    public byh tqz;

    public h(boolean z) {
        AppMethodBeat.i(46178);
        a aVar = new a();
        byh byh = new byh();
        byh.vzS = System.currentTimeMillis();
        if (z) {
            byh.wXF = 1;
        } else {
            byh.wXF = 0;
        }
        this.tqz = byh;
        aVar.fsJ = byh;
        aVar.fsK = new byi();
        aVar.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
        aVar.fsI = 2554;
        this.ehh = aVar.acD();
        AppMethodBeat.o(46178);
    }

    public final int getType() {
        return 2554;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46179);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46179);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46180);
        ab.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tqA = (byi) ((b) qVar).fsH.fsP;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(46180);
    }

    public final byi cOn() {
        AppMethodBeat.i(46181);
        byi byi;
        if (this.tqA == null) {
            byi = new byi();
            AppMethodBeat.o(46181);
            return byi;
        }
        byi = this.tqA;
        AppMethodBeat.o(46181);
        return byi;
    }
}
