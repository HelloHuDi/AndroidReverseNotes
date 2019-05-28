package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends m implements k {
    private final b ehh;
    private f ehi;
    private axj nHz = null;

    public e(int i, String str) {
        AppMethodBeat.i(22533);
        a aVar = new a();
        aVar.fsJ = new cjp();
        aVar.fsK = new cjq();
        aVar.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
        aVar.fsI = 637;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        if (i >= 0 && !bo.isNullOrNil(str)) {
            this.nHz = new axj();
            this.nHz.wBr = i;
            this.nHz.wBq = str;
        }
        AppMethodBeat.o(22533);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(22534);
        ab.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(22534);
    }

    public final int getType() {
        return 637;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(22535);
        this.ehi = fVar;
        cjp cjp = (cjp) this.ehh.fsG.fsP;
        if (this.nHz != null) {
            cjp.xii = this.nHz;
            int a = a(eVar, this.ehh, this);
            AppMethodBeat.o(22535);
            return a;
        }
        ab.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
        fVar.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
        AppMethodBeat.o(22535);
        return 0;
    }
}
