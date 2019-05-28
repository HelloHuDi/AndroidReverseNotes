package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.sdk.platformtools.ab;

public final class af extends m implements k {
    public String cMD;
    private final b ehh;
    private f ehi;
    public int kdT;
    public String kdU;

    public af(String str, String str2, int i) {
        AppMethodBeat.i(87910);
        a aVar = new a();
        aVar.fsJ = new arl();
        aVar.fsK = new arm();
        aVar.uri = "/cgi-bin/micromsg-bin/giftcarditem";
        this.ehh = aVar.acD();
        arl arl = (arl) this.ehh.fsG.fsP;
        arl.cMC = str;
        arl.wvx = str2;
        arl.wvy = i;
        AppMethodBeat.o(87910);
    }

    public final int getType() {
        return 652;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87911);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87911);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87912);
        ab.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        arm arm;
        if (i2 == 0 && i3 == 0) {
            arm = (arm) this.ehh.fsH.fsP;
            if (arm != null) {
                this.cMD = arm.cMD;
                this.kdU = arm.kdU;
                this.kdT = arm.kdT;
            }
        } else {
            arm = (arm) this.ehh.fsH.fsP;
            if (arm != null) {
                this.cMD = arm.cMD;
                this.kdU = arm.kdU;
                this.kdT = arm.kdT;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87912);
    }
}
