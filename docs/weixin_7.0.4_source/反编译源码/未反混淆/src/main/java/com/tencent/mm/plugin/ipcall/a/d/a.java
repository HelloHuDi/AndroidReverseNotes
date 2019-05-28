package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private b ehh = null;
    private f ehi = null;
    public blu nyf = null;
    private blv nyg = null;

    public a(int i, long j, String str, String str2, int i2, long j2) {
        AppMethodBeat.i(21836);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new blu();
        aVar.fsK = new blv();
        aVar.fsI = 843;
        aVar.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        long currentTimeMillis = System.currentTimeMillis();
        this.nyf = (blu) this.ehh.fsG.fsP;
        this.nyf.wem = i;
        this.nyf.wen = j;
        this.nyf.ndF = str;
        this.nyf.wOP = currentTimeMillis;
        this.nyf.wOQ = i2;
        this.nyf.wOR = str2;
        this.nyf.wOS = j2;
        ab.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), str2, Long.valueOf(j2));
        AppMethodBeat.o(21836);
    }

    public final int getType() {
        return 843;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21837);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21837);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21838);
        ab.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyg = (blv) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21838);
    }
}
