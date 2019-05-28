package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.d.d;

public final class l extends m implements k, i, d {
    public String czZ;
    private f ehi;
    private b gme;
    public boolean lSR = false;
    public mb pOY;
    public boolean pOZ = false;
    private ma pPa;

    public l(chl chl, cz czVar, String str, int i, String str2, String str3) {
        AppMethodBeat.i(44747);
        a aVar = new a();
        aVar.fsJ = new ma();
        aVar.fsK = new mb();
        aVar.fsI = 2682;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.pPa = (ma) this.gme.fsG.fsP;
        this.pPa.vPn = czVar;
        this.pPa.vPH = chl;
        this.pPa.vPI = str;
        this.pPa.vPV = i;
        this.pPa.token = str2;
        this.czZ = str3;
        ab.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", str2, a.a(czVar), str);
        AppMethodBeat.o(44747);
    }

    public final int getType() {
        return 2682;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44748);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44748);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44749);
        ab.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOY = (mb) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOY.kdT), this.pOY.kdU);
        if (this.ehi != null) {
            boolean z;
            if (this.pOY.vPW == 1) {
                z = true;
            } else {
                z = false;
            }
            this.lSR = z;
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44749);
    }

    public final boolean cfp() {
        return this.pOZ;
    }
}
