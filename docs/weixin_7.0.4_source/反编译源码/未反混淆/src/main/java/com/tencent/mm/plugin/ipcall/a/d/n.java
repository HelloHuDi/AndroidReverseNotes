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
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m implements k {
    private b ehh = null;
    private f ehi = null;
    public bmh nyG = null;
    private bmi nyH = null;

    public n(int i, long j, long j2, int i2) {
        AppMethodBeat.i(21875);
        a aVar = new a();
        aVar.fsJ = new bmh();
        aVar.fsK = new bmi();
        aVar.fsI = 723;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        long currentTimeMillis = System.currentTimeMillis();
        this.nyG = (bmh) this.ehh.fsG.fsP;
        this.nyG.ndG = r.Yz();
        this.nyG.wem = i;
        this.nyG.wen = j;
        this.nyG.wOS = j2;
        this.nyG.jBT = i2;
        this.nyG.wOP = currentTimeMillis;
        ab.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(21875);
    }

    public final int getType() {
        return 723;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21876);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21876);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21877);
        ab.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyH = (bmi) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21877);
    }
}
