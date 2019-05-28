package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends m implements k {
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    public String nHx = null;

    public b(String str) {
        AppMethodBeat.i(22524);
        a aVar = new a();
        aVar.fsJ = new vm();
        aVar.fsK = new vn();
        aVar.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
        aVar.fsI = 636;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nHx = str;
        AppMethodBeat.o(22524);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(22525);
        ab.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(22525);
    }

    public final int getType() {
        return 636;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(22526);
        this.ehi = fVar;
        vm vmVar = (vm) this.ehh.fsG.fsP;
        vmVar.wcD = this.nHx;
        if (this.nHx == null || bo.isNullOrNil(this.nHx)) {
            ab.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
            fVar.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
            AppMethodBeat.o(22526);
            return 0;
        }
        vmVar.wcD = this.nHx;
        vmVar.wcD = this.nHx;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(22526);
        return a;
    }
}
