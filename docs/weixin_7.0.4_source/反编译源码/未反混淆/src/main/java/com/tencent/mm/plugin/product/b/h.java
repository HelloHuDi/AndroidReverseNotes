package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class h extends m implements k {
    private b ehh;
    private f ehi;
    public String phj;
    public m phk;
    public List<n> phl;

    public h(m mVar, String str) {
        AppMethodBeat.i(43988);
        a aVar = new a();
        aVar.fsJ = new amo();
        aVar.fsK = new amp();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdetail";
        this.ehh = aVar.acD();
        amo amo = (amo) this.ehh.fsG.fsP;
        this.phj = str;
        amo.wrm = str;
        ab.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(str)));
        amo.Version = 0;
        this.phk = mVar;
        AppMethodBeat.o(43988);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43989);
        amp amp = (amp) ((b) qVar).fsH.fsP;
        if (!bo.isNullOrNil(amp.wro)) {
            ab.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + amp.wro);
            this.phk = m.a(this.phk, amp.wro);
        }
        if (i3 == 0 && amp.vKp != 0) {
            i3 = amp.vKp;
            str = amp.vKq;
        }
        if (!bo.isNullOrNil(amp.wrp)) {
            ab.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + amp.wrp);
            this.phl = n.parse(amp.wrp);
        }
        ab.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43989);
    }

    public final int getType() {
        return 553;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43990);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43990);
        return a;
    }
}
