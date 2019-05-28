package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    private final b ehh;
    private com.tencent.mm.ai.f ehi;
    private boj tqy;

    public f() {
        AppMethodBeat.i(46172);
        a aVar = new a();
        boi boi = new boi();
        boi.vzS = System.currentTimeMillis();
        aVar.fsJ = boi;
        aVar.fsK = new boj();
        aVar.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
        this.ehh = aVar.acD();
        AppMethodBeat.o(46172);
    }

    public final int getType() {
        return 2635;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(46173);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46173);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46174);
        ab.w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tqy = (boj) ((b) qVar).fsH.fsP;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(46174);
    }

    public final boj cOm() {
        AppMethodBeat.i(46175);
        boj boj;
        if (this.tqy == null) {
            boj = new boj();
            AppMethodBeat.o(46175);
            return boj;
        }
        boj = this.tqy;
        AppMethodBeat.o(46175);
        return boj;
    }
}
