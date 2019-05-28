package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ail;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends com.tencent.mm.ai.m implements k {
    private final b ehh;
    private f ehi;
    public byte[] kWS = null;
    private String kWT;

    public m(String str, byte[] bArr) {
        AppMethodBeat.i(53131);
        a aVar = new a();
        aVar.fsJ = new ail();
        aVar.fsK = new aim();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
        aVar.fsI = 299;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.kWS = bArr;
        this.kWT = str;
        AppMethodBeat.o(53131);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53132);
        ab.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + i2 + "   errCode:" + i3);
        aim aim = (aim) ((b) qVar).fsH.fsP;
        if (aim.vFq != null) {
            this.kWS = aa.a(aim.vFq);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53132);
    }

    public final int getType() {
        return 299;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53133);
        this.ehi = fVar;
        ail ail = (ail) this.ehh.fsG.fsP;
        if (this.kWS != null) {
            ail.ReqBuf = aa.ad(this.kWS);
        } else {
            ail.ReqBuf = new SKBuiltinBuffer_t();
        }
        ail.ProductID = this.kWT;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53133);
        return a;
    }

    public final aim bkA() {
        return (aim) this.ehh.fsH.fsP;
    }
}
