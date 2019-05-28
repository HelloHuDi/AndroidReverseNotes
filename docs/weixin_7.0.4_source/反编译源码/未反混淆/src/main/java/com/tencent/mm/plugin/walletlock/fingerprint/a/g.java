package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.if;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.a;

public final class g extends d implements k, e {
    public b ehh;
    private f ehi;
    private String gHr = null;
    private com.tencent.soter.a.f.b<e.b> msq = null;

    public final /* synthetic */ void bR(Object obj) {
        AppMethodBeat.i(51489);
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.fsJ = new cic();
        aVar2.fsK = new cid();
        aVar2.uri = "/cgi-bin/mmpay-bin/touchlockupdateauthkey";
        aVar2.fsI = 1244;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        this.ehh = aVar2.acD();
        cic cic = (cic) this.ehh.fsG.fsP;
        cic.xcc = aVar.AvZ;
        cic.xcd = aVar.Awa;
        cic.xcb = this.gHr;
        if ifVar = new if();
        ifVar.cDl.cDn = this.gHr;
        com.tencent.mm.sdk.b.a.xxA.m(ifVar);
        cic.cDo = ifVar.cDm.cDo;
        ab.v("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo wcpaysign: %s", cic.cDo);
        AppMethodBeat.o(51489);
    }

    public g(String str) {
        this.gHr = str;
    }

    public final int getType() {
        return 1665;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(51484);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(51484);
        return a;
    }

    public final void d(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(51485);
        ab.d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        if (this.msq != null) {
            if (i == 0 && i2 == 0) {
                this.msq.dd(new e.b(true));
                AppMethodBeat.o(51485);
                return;
            }
            this.msq.dd(new e.b(false));
        }
        AppMethodBeat.o(51485);
    }

    public final void bxO() {
        AppMethodBeat.i(51486);
        ab.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        if (this.msq != null) {
            ab.e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
            this.msq.dd(new e.b(false));
        }
        AppMethodBeat.o(51486);
    }

    public final void vL(int i) {
        AppMethodBeat.i(51487);
        ab.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(51487);
    }

    public final void execute() {
        AppMethodBeat.i(51488);
        com.tencent.mm.kernel.g.Rg().a((m) this, 0);
        AppMethodBeat.o(51488);
    }

    public final void a(com.tencent.soter.a.f.b<e.b> bVar) {
        this.msq = bVar;
    }
}
