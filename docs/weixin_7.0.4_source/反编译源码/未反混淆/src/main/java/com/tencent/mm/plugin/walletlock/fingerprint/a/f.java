package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    private b ehh;
    private com.tencent.mm.ai.f ehi;

    public final int getType() {
        return 1967;
    }

    public f(String str, String str2, String str3) {
        AppMethodBeat.i(51481);
        a aVar = new a();
        aVar.fsJ = new bhe();
        aVar.fsK = new bhf();
        aVar.uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
        this.ehh = aVar.acD();
        bhe bhe = (bhe) this.ehh.fsG.fsP;
        ab.d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", str, str2, str3);
        bhe.wKv = str;
        bhe.signature = str2;
        bhe.tuu = str3;
        AppMethodBeat.o(51481);
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(51482);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(51482);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(51483);
        ab.i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(51483);
    }
}
