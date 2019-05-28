package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.ab;

public final class w extends m implements k {
    Object data;
    public b ehh;
    private f ehi;

    public w(String str, kd kdVar, Object obj) {
        AppMethodBeat.i(11639);
        a aVar = new a();
        aVar.fsJ = new cjn();
        aVar.fsK = new cjo();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
        this.ehh = aVar.acD();
        cjn cjn = (cjn) this.ehh.fsG.fsP;
        cjn.vNb = str;
        cjn.wku = kdVar;
        this.data = obj;
        AppMethodBeat.o(11639);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11640);
        ab.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11640);
    }

    public final int getType() {
        return 1356;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11641);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11641);
        return a;
    }
}
