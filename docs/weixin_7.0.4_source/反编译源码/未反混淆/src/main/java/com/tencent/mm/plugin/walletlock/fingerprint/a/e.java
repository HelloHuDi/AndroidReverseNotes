package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private b ehh;
    private f ehi;
    String msn;
    boolean tVh = false;

    public e(String str, String str2) {
        AppMethodBeat.i(51478);
        a aVar = new a();
        aVar.fsJ = new cia();
        aVar.fsK = new cib();
        aVar.uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
        aVar.fsI = 1548;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cia cia = (cia) this.ehh.fsG.fsP;
        cia.scene = 1548;
        cia.rOh = str;
        cia.jSY = str2;
        AppMethodBeat.o(51478);
    }

    public final int getType() {
        return 1548;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(51479);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(51479);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(51480);
        ab.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        cib cib = (cib) ((b) qVar).fsH.fsP;
        this.msn = cib.msn;
        ab.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", this.msn);
        if (cib.xca == 1) {
            this.tVh = true;
        } else {
            this.tVh = false;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(51480);
    }
}
