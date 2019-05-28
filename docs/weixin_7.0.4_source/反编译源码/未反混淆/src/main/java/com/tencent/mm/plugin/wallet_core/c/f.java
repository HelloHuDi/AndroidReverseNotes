package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    public String ttP = "";
    public boolean ttQ = false;

    public f() {
        AppMethodBeat.i(46503);
        a aVar = new a();
        aVar.fsJ = new amg();
        aVar.fsK = new amh();
        aVar.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
        aVar.fsI = 2541;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(46503);
    }

    public final int getType() {
        return 2541;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(46504);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46504);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46505);
        ab.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            amh amh = (amh) ((b) qVar).fsH.fsP;
            this.ttP = amh.ttP;
            this.ttQ = amh.ttQ;
            ab.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", this.ttP, Boolean.valueOf(this.ttQ));
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(46505);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(46505);
    }
}
