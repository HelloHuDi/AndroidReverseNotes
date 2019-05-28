package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Date;

public final class r extends m implements k {
    private Object data;
    public b ehh;
    private f ehi;

    public r(b bVar, int i, int i2, Object obj) {
        AppMethodBeat.i(11438);
        a aVar = new a();
        aVar.fsJ = new bmr();
        aVar.fsK = new bms();
        aVar.uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
        this.ehh = aVar.acD();
        bmr bmr = (bmr) this.ehh.fsG.fsP;
        bmr.wPC = 1;
        bmr.wPD = bVar.field_wwCorpId;
        bmr.vNx = bVar.field_wwUserVid;
        g.RN();
        bmr.wPE = com.tencent.mm.kernel.a.QF();
        bmr.scene = i2;
        bmr.cuy = i;
        bmr.wPF = 0;
        bmr.wPG = new Date().getTime();
        bmr.platform = 1;
        bmr.wMv = com.tencent.mm.sdk.platformtools.g.ar(null, d.vxo);
        this.data = obj;
        AppMethodBeat.o(11438);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11439);
        ab.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11439);
    }

    public final int getType() {
        return 2805;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11440);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11440);
        return a;
    }
}
