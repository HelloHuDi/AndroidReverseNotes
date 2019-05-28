package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    private b ehh = null;
    private f ehi;
    public bmj nyI = null;
    public bmk nyJ = null;

    public o(int i, long j, int i2, long j2, boolean z) {
        AppMethodBeat.i(21878);
        a aVar = new a();
        aVar.fsJ = new bmj();
        aVar.fsK = new bmk();
        aVar.fsI = 819;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnsync";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        long currentTimeMillis = System.currentTimeMillis();
        this.nyI = (bmj) this.ehh.fsG.fsP;
        this.nyI.wPm = r.Yz();
        this.nyI.wem = i;
        this.nyI.wen = j;
        this.nyI.wOP = currentTimeMillis;
        this.nyI.wPn = i2;
        this.nyI.wOS = j2;
        if (z) {
            this.nyI.wPo = 1;
        } else {
            this.nyI.wPo = 0;
        }
        ab.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(this.nyI.wPo), Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(21878);
    }

    public final int getType() {
        return 819;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21879);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21879);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21880);
        ab.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyJ = (bmk) ((b) qVar).fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(21880);
    }
}
