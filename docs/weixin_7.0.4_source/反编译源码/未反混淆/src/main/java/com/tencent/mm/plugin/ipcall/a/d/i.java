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
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends m implements k {
    private b ehh = null;
    private f ehi = null;
    public bma nyw = null;
    public bmb nyx = null;

    public i(String str, String str2, int i, int i2, int i3) {
        AppMethodBeat.i(21860);
        a aVar = new a();
        aVar.fsJ = new bma();
        aVar.fsK = new bmb();
        aVar.fsI = 991;
        aVar.uri = "/cgi-bin/micromsg-bin/pstninvite";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        long currentTimeMillis = System.currentTimeMillis();
        int bIP = c.bIP();
        bma bma = (bma) this.ehh.fsG.fsP;
        bma.ndG = r.Yz();
        bma.wOR = str2;
        bma.ndF = str;
        bma.wOQ = i;
        bma.vZF = bIP;
        bma.wOZ = 1;
        bma.wOP = currentTimeMillis;
        bma.wOY = i2;
        bma.wPa = i3;
        this.nyw = bma;
        ab.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", str, str2, Integer.valueOf(i), Integer.valueOf(bIP), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(21860);
    }

    public final int getType() {
        return 991;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21861);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21861);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21862);
        ab.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyx = (bmb) ((b) qVar).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.o(21862);
            return;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21862);
    }
}
