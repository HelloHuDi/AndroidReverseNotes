package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.a;

public final class g extends m implements k, e {
    private f ehi;
    private q ftU;
    private b<e.b> msq = null;

    public final /* synthetic */ void bR(Object obj) {
        AppMethodBeat.i(59317);
        a aVar = (a) obj;
        this.ftU = new b();
        c.a aVar2 = (c.a) this.ftU.acF();
        aVar2.rNE.xil = aVar.Awa;
        aVar2.rNE.xim = aVar.AvZ;
        AppMethodBeat.o(59317);
    }

    public final int acn() {
        return 3;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int getType() {
        return ag.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(59314);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(59314);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(59315);
        ab.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
            if (this.msq != null) {
                this.msq.dd(new e.b(true));
                AppMethodBeat.o(59315);
                return;
            }
        }
        ab.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
        if (this.msq != null) {
            this.msq.dd(new e.b(false));
        }
        AppMethodBeat.o(59315);
    }

    public final void execute() {
        AppMethodBeat.i(59316);
        ab.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
        com.tencent.mm.kernel.g.Rg().a((m) this, 0);
        AppMethodBeat.o(59316);
    }

    public final void a(b<e.b> bVar) {
        this.msq = bVar;
    }
}
