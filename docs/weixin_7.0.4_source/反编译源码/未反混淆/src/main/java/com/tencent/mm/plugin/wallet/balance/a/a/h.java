package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends a<bla> {
    public int scene;

    public h(int i, int i2) {
        AppMethodBeat.i(45234);
        b.a aVar = new b.a();
        aVar.fsJ = new bkz();
        aVar.fsK = new bla();
        aVar.uri = "/cgi-bin/mmpay-bin/preaddplan";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        bkz bkz = (bkz) acD.fsG.fsP;
        bkz.scene = i;
        bkz.vES = i2;
        this.ehh = acD;
        this.scene = i;
        ab.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(45234);
    }
}
