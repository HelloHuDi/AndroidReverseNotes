package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    private f ehi;
    private b gme;
    private ov pPd;
    public ow pPe;

    public o(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6) {
        AppMethodBeat.i(44755);
        a aVar = new a();
        aVar.fsJ = new ov();
        aVar.fsK = new ow();
        aVar.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.pPd = (ov) this.gme.fsG.fsP;
        this.pPd.vFb = str;
        this.pPd.vFc = str2;
        this.pPd.nUf = i;
        this.pPd.pPT = str3;
        this.pPd.pPS = str4;
        this.pPd.cIb = i2;
        this.pPd.pOA = i3;
        this.pPd.vVW = str5;
        this.pPd.vVX = str6;
        AppMethodBeat.o(44755);
    }

    public final int getType() {
        return 2773;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44756);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44756);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44757);
        ab.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pPe = (ow) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pPe.kCl), this.pPe.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44757);
    }
}
